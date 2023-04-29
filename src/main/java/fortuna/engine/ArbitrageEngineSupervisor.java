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
import fortuna.models.notification.NotificationMessage;
import fortuna.models.offer.BetOffer;
import fortuna.support.BehaviorUtils;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

import static fortuna.support.BehaviorUtils.generateActorName;
import static fortuna.support.BehaviorUtils.wrap;

public class ArbitrageEngineSupervisor extends AbstractBehavior<FortunaMessage> {

    private ActorRef<NotificationMessage>   notificationManagerRef;

    public ArbitrageEngineSupervisor(ActorContext<FortunaMessage> context, ActorRef<NotificationMessage> notificationManagerRef) {
        super(context);

        getContext().getLog().info("Arbitrage engine supervisor started!");

        this.notificationManagerRef = notificationManagerRef;
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
        notificationManagerRef.tell(message);

        return Behaviors.same();
    }
}
