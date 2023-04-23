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
import fortuna.support.BehaviorUtils;
import fortuna.support.FileUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

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
        final List<BetOffer<?>> offers = message.getOffers();
        // I know, I know. This should be done on the blocking dispatcher. However, this will happen very rarely.
        FileUtils.appendToFile(ARBITRAGE_FILE, String.format("[%s] ONE: %s, DRAW: %s, TWO: %s", TIMESTAMP_FORMAT.format(new Date()), offers.get(0).toString(), offers.get(1).toString(), offers.get(2).toString()) + System.lineSeparator());

        return Behaviors.same();
    }
}
