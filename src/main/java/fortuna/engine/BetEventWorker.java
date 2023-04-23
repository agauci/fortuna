package fortuna.engine;

import akka.actor.typed.ActorRef;
import akka.actor.typed.Behavior;
import akka.actor.typed.javadsl.*;
import fortuna.message.FortunaMessage;
import fortuna.message.engine.*;
import fortuna.models.offer.BetOffer;
import fortuna.models.offer.BetOfferType;
import fortuna.models.offer.ThreeWayBetOffer;
import fortuna.support.PermutationUtils;
import lombok.Builder;
import lombok.Data;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static fortuna.support.BehaviorUtils.wrap;

public class BetEventWorker extends AbstractBehavior<BetEventMessage> {

    private static final Duration                 EVICTION_DELAY = Duration.of(1, ChronoUnit.HOURS);
    private static final String                   EVICTION_TIMER_KEY = "eviction-timer-key";

    private final TimerScheduler<BetEventMessage> timer;
    private final String                          eventIdentifier;
    private final ActorRef<FortunaMessage>        parentRef;

    private final List<BetOffer<?>>               offers = new ArrayList<>();
    private BetOfferType                          type;

    public BetEventWorker(ActorContext<BetEventMessage> context, TimerScheduler<BetEventMessage> timer, String eventIdentifier, ActorRef<FortunaMessage> parentRef) {
        super(context);
        context.getLog().debug("Started BetEventSupervisor for event {}", eventIdentifier);

        this.timer = timer;
        this.eventIdentifier = eventIdentifier;
        this.parentRef = parentRef;
    }

    @Override
    public Receive<BetEventMessage> createReceive() {
        return newReceiveBuilder()
                .onMessage(BetOfferIdentified.class, this::onBetOfferIdentified)
                .onMessage(BetOfferUpdated.class, this::onBetOfferUpdated)
                .onMessage(BetOfferTick.class, this::onBetOfferTick)
                .build();
    }

    private Behavior<BetEventMessage> onBetOfferIdentified(BetOfferIdentified message) {
        return wrap(() -> {
            offers.add(message.getOffer());
            type = message.getOffer().getType();

            searchArbitrage();
            resetTimer();

            return Behaviors.same();
        }, getContext(), message);
    }

    private Behavior<BetEventMessage> onBetOfferUpdated(BetOfferUpdated message) {
        return wrap(() -> {
            List<BetOffer> newOffers = new ArrayList<>();
            for (BetOffer offer : offers) {
                if (offer.getBettingSourceType().equals(message.getOffer().getBettingSourceType())) {
                    newOffers.add(message.getOffer());
                } else {
                    newOffers.add(offer);
                }
            }

            searchArbitrage();
            resetTimer();

            return Behaviors.same();
        }, getContext(), message);
    }

    private Behavior<BetEventMessage> onBetOfferTick(BetOfferTick message) {
        return wrap(() -> {
            resetTimer();

            return Behaviors.same();
        }, getContext(), message);
    }

    private void searchArbitrage() {
        if (offers.size() == 1) {
            getContext().getLog().debug("Only one bet offer available for event {}. Skipping arbitrage search.", eventIdentifier);
            return;
        }

        switch (type) {
            case TWO_WAY -> {
                throw new IllegalStateException("TWO_WAY not supported yet: " + type);
            }
            case THREE_WAY -> {
                searchThreeWayArbitrage();
            }
            default -> throw new IllegalStateException("Unexpected value: " + type);
        }
    }

    private void searchThreeWayArbitrage() {
        PermutationUtils.generatePermutations(IntStream.range(0, offers.size()).boxed().collect(Collectors.toSet()), 2).forEach(
                combination -> {
                    List<BetOffer<?>> oneDrawOffers = extractOffers(combination);

                    final Optional<? extends BetOffer<?>> twoWinOffer = ThreeWayBetOffer.searchArbitrage(oneDrawOffers.get(0), oneDrawOffers.get(1), offers);

                    if (twoWinOffer.isPresent()) {
                        getContext().getLog().warn("Arbitrage opportunity identified!!!!!! See offers {}, {}, {}", oneDrawOffers.get(0), oneDrawOffers.get(1), twoWinOffer.get());
                        parentRef.tell(BetArbitrageIdentified.builder().offers(List.of(oneDrawOffers.get(0), oneDrawOffers.get(1), twoWinOffer.get())).build());
                    } else {
                        getContext().getLog().debug("No arbitrage opportunities identified across offers from sources {}", offers.stream().map(BetOffer::getBettingSourceType).collect(Collectors.toList()));
                    }
                }
        );
    }

    private List<BetOffer<?>> extractOffers(List<Integer> indexes) {
        return indexes.stream()
                .sorted()
                .map(i -> offers.get(i))
                .collect(Collectors.toList());
    }

    private void resetTimer() {
        timer.startSingleTimer(EVICTION_TIMER_KEY, BetEventSupervisorEvicted.builder().eventIdentifier(eventIdentifier).build(), EVICTION_DELAY);
    }

    @Builder
    @Data
    private static class BetEventSupervisorEvicted implements BetEventMessage {
        String eventIdentifier;
    }
}
