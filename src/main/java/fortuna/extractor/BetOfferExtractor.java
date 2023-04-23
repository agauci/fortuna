package fortuna.extractor;

import akka.actor.typed.ActorRef;
import akka.actor.typed.Behavior;
import akka.actor.typed.DispatcherSelector;
import akka.actor.typed.javadsl.*;
import fortuna.bettingsource.BetOfferSource;
import fortuna.bettingsource.BettingSourceCatalogue;
import fortuna.message.FortunaMessage;
import fortuna.message.engine.BetOfferIdentified;
import fortuna.message.engine.BetOfferTick;
import fortuna.message.engine.BetOfferUpdated;
import fortuna.message.extractor.BetOfferSourceExtracted;
import fortuna.message.extractor.ExtractorMessage;
import fortuna.message.extractor.TriggerBetOfferSourceExtraction;
import fortuna.message.internal.shutdown.SystemShutdown;
import fortuna.message.internal.shutdown.SystemShutdownAck;
import fortuna.models.offer.BetOffer;
import fortuna.support.BehaviorUtils;
import fortuna.support.RuntimeUtils;
import lombok.Builder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.core.io.ResourceLoader;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static fortuna.support.BehaviorUtils.wrap;
import static fortuna.support.RuntimeUtils.cleanupChromeDriver;

public class BetOfferExtractor extends AbstractBehavior<ExtractorMessage> {

    private static final Integer                CONCURRENCY_LEVEL = 3;
    private static final Long                   EXTRACTION_PERIOD_MS = 60000L;
    private static final Long                   CLEANUP_PERIOD_MS = 120000L;

    final TimerScheduler<ExtractorMessage>      timer;
    final ResourceLoader                        resourceLoader;
    final ActorRef<FortunaMessage>              engineRef;

    Queue<BetOfferSource>                       betOfferSources;

    Set<String>                                 runningExtractions = new HashSet<>();
    Long                                        lastCleanupMs = System.currentTimeMillis();

    public BetOfferExtractor(ActorContext<ExtractorMessage> context,
                             TimerScheduler<ExtractorMessage> timer,
                             ResourceLoader resourceLoader,
                             ActorRef<FortunaMessage> engineRef) {
        super(context);
        this.resourceLoader = resourceLoader;
        this.engineRef = engineRef;

        initialiseBetOfferSources();
        getContext().getLog().info("BetOfferExtractor started!");

        timer.startTimerAtFixedRate(MaybeTriggerNextExtraction.builder().build(), Duration.of(5, ChronoUnit.SECONDS));

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
            if ((System.currentTimeMillis() - lastCleanupMs) > CLEANUP_PERIOD_MS) {
                getContext().getLog().debug("Cleanup period exceeded. Skipping run.");
                return Behaviors.same();
            }

            BetOfferSource betOfferSource = betOfferSources.peek();
            if (betOfferSource == null) {
                getContext().getLog().debug("No bet offer sources available in queue. Skipping run.");
                return Behaviors.same();
            }

            if ((runningExtractions.size() <= CONCURRENCY_LEVEL)
                    && ((System.currentTimeMillis() - betOfferSource.getLastExtractedTimestamp()) > EXTRACTION_PERIOD_MS)) {
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
            } else {
                getContext().getLog().debug("Skipping extraction of {} since extraction period is not exceeded.", betOfferSource.getUniqueIdentifier());
            }

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

                if (((System.currentTimeMillis() - lastCleanupMs) > CLEANUP_PERIOD_MS) && runningExtractions.isEmpty()) {
                    getContext().getLog().debug("Performing chromedriver cleanup & resuming processing.");
                    cleanupChromeDriver();
                    lastCleanupMs = System.currentTimeMillis();
                }
            } else {
                betOfferSources.add(message.getBetOfferSource());
                runningExtractions.remove(message.getBetOfferSource().getUniqueIdentifier());
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

    @Builder
    private static class MaybeTriggerNextExtraction implements ExtractorMessage { }
}
