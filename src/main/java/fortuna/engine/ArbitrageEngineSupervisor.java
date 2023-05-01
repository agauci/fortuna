package fortuna.engine;

import akka.actor.typed.ActorRef;
import akka.actor.typed.Behavior;
import akka.actor.typed.javadsl.AbstractBehavior;
import akka.actor.typed.javadsl.ActorContext;
import akka.actor.typed.javadsl.Behaviors;
import akka.actor.typed.javadsl.Receive;
import akka.japi.Pair;
import fortuna.message.FortunaMessage;
import fortuna.message.engine.BetArbitrageIdentified;
import fortuna.message.engine.BetEventMessage;
import fortuna.message.engine.NameMismatchIdentified;
import fortuna.models.competition.EventCompetition;
import fortuna.models.notification.NotificationMessage;
import fortuna.support.BehaviorUtils;
import fortuna.support.NameSimilarityUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static fortuna.support.BehaviorUtils.generateActorName;
import static fortuna.support.BehaviorUtils.wrap;

public class ArbitrageEngineSupervisor extends AbstractBehavior<FortunaMessage> {

    private ActorRef<NotificationMessage>   notificationManagerRef;

    private Map<Pair<String, String>, Pair<String, EventCompetition>> eventWorkers = new HashMap<>();

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

                    List<String> participants = message.getParticipants();
                    Pair<String, String> participantPair = Pair.apply(participants.get(0), participants.get(1));

                    Optional<Pair<Pair<String, String>, Pair<String, EventCompetition>>> result = NameSimilarityUtils.eventIdentifierMismatch(eventWorkers, participantPair, message.getEventIdentifier(), message.getEventCompetition());
                    if (result.isPresent()) {
                        getContext().getLog().warn("Name mismatch identified! participants1 = {}, eventIdentifier1 = {}, participants2={}, eventIdentifier2={}", participantPair, message.getEventIdentifier(), result.get().first(), result.get().second());
                        notificationManagerRef.tell(NameMismatchIdentified.builder()
                                .participants1(participants)
                                .eventIdentifier1(message.getEventIdentifier())
                                .participants2(List.of(result.get().first().first(), result.get().first().second()))
                                .eventIdentifier2(result.get().second().first())
                                .build());
                    }
                    eventWorkers.put(participantPair, Pair.apply(message.getEventIdentifier(), message.getEventCompetition()));
                }

                return Behaviors.same();
        }, getContext(), message);
    }

    private Behavior<FortunaMessage> onBetArbitrageIdentified(BetArbitrageIdentified message) {
        notificationManagerRef.tell(message);

        return Behaviors.same();
    }
}
