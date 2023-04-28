package fortuna.engine;

import akka.actor.typed.ActorRef;
import akka.actor.typed.Behavior;
import akka.actor.typed.javadsl.AbstractBehavior;
import akka.actor.typed.javadsl.ActorContext;
import akka.actor.typed.javadsl.Behaviors;
import akka.actor.typed.javadsl.Receive;
import fortuna.message.FortunaMessage;
import fortuna.message.engine.BetArbitrageIdentified;
import fortuna.message.engine.BetEventMessage;
import fortuna.models.offer.BetOffer;
import fortuna.models.offer.ThreeWayBetOffer;
import fortuna.support.BehaviorUtils;
import fortuna.support.FileUtils;
import fortuna.support.PushNotificationUtils;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static fortuna.bettingsource.BettingSourceCatalogue.resolveUrl;
import static fortuna.support.BehaviorUtils.generateActorName;
import static fortuna.support.BehaviorUtils.wrap;

public class ArbitrageEngineSupervisor extends AbstractBehavior<FortunaMessage> {

    private static final String             ARBITRAGE_FILE = "C:\\dev\\trees\\fortuna\\arbitrageOutcome.txt";
    private static final SimpleDateFormat   TIMESTAMP_FORMAT = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");

    public ArbitrageEngineSupervisor(ActorContext<FortunaMessage> context) {
        super(context);

        getContext().getLog().info("Arbitrage engine supervisor started!");
    }

    @Override
    public Receive<FortunaMessage> createReceive() {
        return newReceiveBuilder()
                .onMessage(BetEventMessage.class, this::onBetEventMessage)
                .onMessage(BetArbitrageIdentified.class, this::onBetArbitrageIdentified)
                .build();
    }

    private Behavior<FortunaMessage> onBetEventMessage(final BetEventMessage message) {
        return wrap(
            () -> {
                String actorIdentifier = generateActorName(BetEventWorker.class.getSimpleName(), message.getEventIdentifier());

                final Optional<ActorRef<Void>> child = getContext().getChild(actorIdentifier);

                if (child.isPresent()) {
                    child.get().unsafeUpcast().tell(message);
                } else {
                    getContext().spawn(
                            BehaviorUtils.<BetEventMessage>withTimers((ctx, timer) -> new BetEventWorker(ctx, timer, message.getEventIdentifier(), getContext().getSelf())),
                            actorIdentifier
                    ).tell(message);
                }

                return Behaviors.same();
        }, getContext(), message);
    }

    private Behavior<FortunaMessage> onBetArbitrageIdentified(BetArbitrageIdentified message) {
        switch (message.getBetOfferType()) {
            case TWO_WAY ->  throw new IllegalStateException("Unsupported value: " + message.getBetOfferType());
            case THREE_WAY -> {
                final List<BetOffer<?>> offers = message.getOffers();
                // I know, I know. These should be done on the blocking dispatcher. However, this will happen very rarely.
                FileUtils.appendToFile(ARBITRAGE_FILE, String.format("[%s] Probability: %s, Odds: %s %s ONE: %s - %s, %s DRAW: %s - %s, %s TWO: %s - %s %s",
                        TIMESTAMP_FORMAT.format(new Date()), message.getProbability(), message.getOdds(), System.lineSeparator(),
                        resolveUrl(offers.get(0)), offers.get(0).toString(), System.lineSeparator(),
                        resolveUrl(offers.get(1)), offers.get(1).toString(), System.lineSeparator(),
                        resolveUrl(offers.get(2)), offers.get(2).toString(), System.lineSeparator()));

                PushNotificationUtils.maybeTriggerPush(
                        message.getProbability().multiply(BigDecimal.valueOf(100)) + " Arbitrage Opportunity Identified",
                        String.format("ONE: %s - %s (%s), DRAW: %s (%s), TWO: %s - %s (%s)",
                                offers.get(0).getParticipants().get(0),  offers.get(0).getBettingSourceType(), ((ThreeWayBetOffer) offers.get(0)).getOne(),
                                offers.get(1).getBettingSourceType(),  ((ThreeWayBetOffer) offers.get(1)).getDraw(),
                                offers.get(2).getParticipants().get(1),  offers.get(2).getBettingSourceType(), ((ThreeWayBetOffer) offers.get(2)).getTwo())
                );
            }
            default -> throw new IllegalStateException("Unexpected value: " + message.getBetOfferType());
        }

        return Behaviors.same();
    }
}
