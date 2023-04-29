package fortuna.extractor;

import akka.actor.typed.ActorRef;
import akka.actor.typed.Behavior;
import akka.actor.typed.DispatcherSelector;
import akka.actor.typed.javadsl.*;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import fortuna.bettingsource.BetOfferSource;
import fortuna.bettingsource.BettingSourceCatalogue;
import fortuna.message.FortunaMessage;
import fortuna.message.engine.BetOfferIdentified;
import fortuna.message.engine.BetOfferTick;
import fortuna.message.engine.BetOfferUpdated;
import fortuna.message.extractor.BetOfferExtractionFailed;
import fortuna.message.extractor.BetOfferSourceExtracted;
import fortuna.message.extractor.ExtractorMessage;
import fortuna.message.extractor.TriggerBetOfferSourceExtraction;
import fortuna.message.internal.shutdown.SystemShutdown;
import fortuna.message.internal.shutdown.SystemShutdownAck;
import fortuna.models.notification.NotificationMessage;
import fortuna.models.offer.BetOffer;
import fortuna.support.BehaviorUtils;
import lombok.Builder;
import lombok.Data;
import org.springframework.core.io.ResourceLoader;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.stream.Collectors;

import static fortuna.support.BehaviorUtils.wrap;
import static fortuna.support.RuntimeUtils.cleanupChrome;

public class BetOfferExtractor extends AbstractBehavior<ExtractorMessage> {

    private static final Integer                CONCURRENCY_LEVEL = 7;
    private static final Long                   EXTRACTOR_TRIGGER_PERIOD_MS = 1000L;
    private static final Long                   EXTRACTION_PERIOD_MS = 60000L;
    private static final Long                   CLEANUP_PERIOD_MS = 120000L;
    private static final Long                   CLEANUP_BUFFER_PERIOD_MS = 115000L;

    final TimerScheduler<ExtractorMessage>      timer;
    final ResourceLoader                        resourceLoader;
    final ActorRef<FortunaMessage>              engineRef;
    final ActorRef<NotificationMessage>         notificationManagerRef;

    Queue<BetOfferSource>                       betOfferSources;

    Set<String>                                 runningExtractions = new HashSet<>();
    Long                                        lastCleanupMs = System.currentTimeMillis();

    Cache<String, String>                       failedSources = CacheBuilder.newBuilder().expireAfterWrite(1, TimeUnit.HOURS).build();

    public BetOfferExtractor(ActorContext<ExtractorMessage> context,
                             TimerScheduler<ExtractorMessage> timer,
                             ResourceLoader resourceLoader,
                             ActorRef<FortunaMessage> engineRef,
                             ActorRef<NotificationMessage> notificationManagerRef) {
        super(context);
        this.resourceLoader = resourceLoader;
        this.engineRef = engineRef;
        this.notificationManagerRef = notificationManagerRef;

        initialiseBetOfferSources();
        getContext().getLog().info("BetOfferExtractor started!");

        timer.startTimerAtFixedRate(MaybeTriggerNextExtraction.builder().build(), Duration.of(EXTRACTOR_TRIGGER_PERIOD_MS, ChronoUnit.MILLIS));

        this.timer = timer;
    }

    @Override
    public Receive<ExtractorMessage> createReceive() {
        return newReceiveBuilder()
                .onMessage(MaybeTriggerNextExtraction.class, this::onMaybeTriggerNextExtraction)
                .onMessage(SystemShutdown.class, this::onSystemShutdown)
                .onMessage(BetOfferSourceExtracted.class, this::onBetOfferSourceExtracted)
                .build();
    }

    private Behavior<ExtractorMessage> onMaybeTriggerNextExtraction(MaybeTriggerNextExtraction message) {
        return wrap(() -> {
            // If sufficient time elapsed and there are no more pending running extractions, trigger the chromedriver
            // cleanup
            if (((System.currentTimeMillis() - lastCleanupMs) > CLEANUP_PERIOD_MS) && runningExtractions.isEmpty()) {
                getContext().getLog().info("Performing chromedriver cleanup & resuming processing.");
                cleanupChrome();
                lastCleanupMs = System.currentTimeMillis();
            }

            // The extractor goes into cleanup mode 5 seconds before doing the actual cleanup in order to
            // give any pending chrome driver instances sufficient time to close gracefully. No extractions
            // are commissioned during cleanup mode.
            if ((System.currentTimeMillis() - lastCleanupMs) > CLEANUP_BUFFER_PERIOD_MS) {
                getContext().getLog().debug("Cleanup period exceeded. Skipping run. Currently running extractions: {}", runningExtractions);
                return Behaviors.same();
            }

            BetOfferSource betOfferSource = betOfferSources.peek();
            if (betOfferSource == null) {
                getContext().getLog().debug("No bet offer sources available in queue. Skipping run.");
                return Behaviors.same();
            }

            if ((System.currentTimeMillis() - betOfferSource.getLastExtractedTimestamp()) < EXTRACTION_PERIOD_MS) {
                getContext().getLog().debug("Skipping extraction of {} since extraction period is not exceeded.", betOfferSource.getUniqueIdentifier());
                return Behaviors.same();
            }

            if (runningExtractions.size() >= CONCURRENCY_LEVEL) {
                getContext().getLog().debug("Skipping extraction of {} since concurrency level limit is reached.", betOfferSource.getUniqueIdentifier());
                return Behaviors.same();
            }

            betOfferSources.poll();
            getContext().spawn(
                    BehaviorUtils.<ExtractorMessage>withTimers((ctx, timer) -> new BetOfferExtractorWorker(ctx, timer, resourceLoader, betOfferSource.getUniqueIdentifier())),
                    BehaviorUtils.generateActorName(BetOfferExtractorWorker.class.getSimpleName(), betOfferSource.getUniqueIdentifier()),
                    DispatcherSelector.blocking()
            ).tell(
                    TriggerBetOfferSourceExtraction.builder()
                            .betOfferSource(betOfferSource)
                            .senderRef(getContext().getSelf())
                            .build()
            );
            runningExtractions.add(betOfferSource.getUniqueIdentifier());

            return Behaviors.same();
        }, getContext(), message);
    }

    private <T extends BetOffer<T>> Behavior<ExtractorMessage> onBetOfferSourceExtracted(BetOfferSourceExtracted<T> message) {
        return wrap(() -> {
            if (message.isSuccess()) {
                List<T> extractedOffers = message.getExtractedOffers();
                BetOfferSource<T> betOfferSource = message.getBetOfferSource();

                Map<String, BetOffer<T>> previousState = betOfferSource.getLastExtractedOffers().stream()
                                                            .collect(Collectors.toMap(BetOffer::getEventIdentifier, Function.identity()));

                message.getExtractedOffers().stream()
                        .map(betOffer -> {
                            BetOffer<T> previousOfferState = previousState.get(betOffer.getEventIdentifier());

                            if (previousOfferState == null) {
                                return BetOfferIdentified.builder().offer(betOffer).build();
                            } else if (previousOfferState.isEquivalentTo(betOffer)) {
                                return BetOfferTick.builder().eventIdentifier(betOffer.getEventIdentifier()).source(betOffer.getBettingSourceType()).build();
                            } else {
                                return BetOfferUpdated.builder().offer(betOffer).build();
                            }
                        }).forEach(engineRef::tell);

                betOfferSource.onOffersExtracted(extractedOffers);
                betOfferSources.add(betOfferSource);
                runningExtractions.remove(betOfferSource.getUniqueIdentifier());

                if (message.getExtractedOffers() == null || message.getExtractedOffers().isEmpty()) {
                    notifyFailure(message.getBetOfferSource().getUniqueIdentifier(), "No offers extracted!");
                }
            } else {
                betOfferSources.add(message.getBetOfferSource());
                runningExtractions.remove(message.getBetOfferSource().getUniqueIdentifier());

                notifyFailure(message.getBetOfferSource().getUniqueIdentifier(), message.getFailReason());
            }

            return Behaviors.same();
        }, getContext(), message);
    }

    private Behavior<ExtractorMessage> onSystemShutdown(SystemShutdown message) {
        return wrap(() -> {
            timer.cancelAll();

            getContext().getChildren().forEach(childRef -> childRef.unsafeUpcast().tell(message));

            message.getSenderRef().tell(SystemShutdownAck.builder().build());

            return Behaviors.same();
        }, getContext(), message);
    }

    private void initialiseBetOfferSources() {
        List<BetOfferSource> betOfferSourcesList = BettingSourceCatalogue.BETTING_SOURCES.stream()
                .flatMap(bettingSource ->
                        bettingSource.sources().stream()
                                .map(offerSource -> offerSource.onInit())
                ).collect(Collectors.toList());

        Collections.shuffle(betOfferSourcesList);

        betOfferSources = new LinkedList<>(betOfferSourcesList);
    }

    private void notifyFailure(String sourceUniqueIdentifier, String failReason) {
        if (failedSources.getIfPresent(sourceUniqueIdentifier) != null) {
            getContext().getLog().debug("Skipping failure notification {} due to already having notified of source failure less than an hour ago.", sourceUniqueIdentifier);
            return;
        }

        failedSources.put(sourceUniqueIdentifier, sourceUniqueIdentifier);
        notificationManagerRef.tell(BetOfferExtractionFailed.builder().sourceUniqueIdentifier(sourceUniqueIdentifier).failReason(failReason).build());
    }

    @Builder
    @Data
    private static class MaybeTriggerNextExtraction implements ExtractorMessage { }
}
