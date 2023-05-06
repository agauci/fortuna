package fortuna.engine;

import akka.Done;
import akka.actor.typed.ActorRef;
import akka.actor.typed.Behavior;
import akka.actor.typed.javadsl.*;
import fortuna.message.FortunaMessage;
import fortuna.message.engine.*;
import fortuna.models.competition.EventCompetition;
import fortuna.models.notification.NotificationMessage;
import fortuna.support.BehaviorUtils;
import lombok.Builder;
import lombok.Data;
import org.apache.commons.lang3.tuple.Pair;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

import static fortuna.support.BehaviorUtils.generateActorName;
import static fortuna.support.BehaviorUtils.wrap;
import static fortuna.support.NameSimilarityUtils.findSimilarWorker;

public class ArbitrageEngineSupervisor extends AbstractBehavior<FortunaMessage> {

    private ActorRef<NotificationMessage>   notificationManagerRef;

    private Set<WorkerInfo> eventWorkers = new HashSet<>();
    private Set<WorkerInfo> activeEventWorkers = new HashSet<>();

    public ArbitrageEngineSupervisor(ActorContext<FortunaMessage> context, ActorRef<NotificationMessage> notificationManagerRef, TimerScheduler<FortunaMessage> scheduler) {
        super(context);

        getContext().getLog().info("Arbitrage engine supervisor started!");

        this.notificationManagerRef = notificationManagerRef;
    }

    @Override
    public Receive<FortunaMessage> createReceive() {
        return newReceiveBuilder()
                .onMessage(RemoveBettingSourceOffers.class, this::onRemoveBettingSourceOffers)
                .onMessage(GetEventIdentifiers.class, this::onGetEventIdentifiers)
                .onMessage(GetBetOffers.class, this::onGetBetOffers)
                .onMessage(BetOfferEventActive.class, this::onBetOfferEventActive)
                .onMessage(BetEventMessage.class, this::onBetEventMessage)
                .onMessage(BetArbitrageIdentified.class, this::onBetArbitrageIdentified)
                .build();
    }

    private Behavior<FortunaMessage> onBetOfferEventActive(BetOfferEventActive message) {
        return wrap(() -> {
            Optional<WorkerInfo> activeEventWorker = findSimilarWorker(activeEventWorkers, message.getParticipants(), message.getEventIdentifier(), message.getEventCompetition());

            if (activeEventWorker.isEmpty()) {
                activeEventWorkers.add(WorkerInfo.builder().participants(message.getParticipants()).eventIdentifier(message.getEventIdentifier()).eventCompetition(message.getEventCompetition()).build());
                getContext().getLog().warn("Event {} marked as active! No more messages will be processed for this event.", message.getEventIdentifier());
            }

            return Behaviors.same();
        }, getContext(), message);
    }

    private Behavior<FortunaMessage> onGetBetOffers(GetBetOffers message) {
        return wrap(() -> {
            Optional<WorkerInfo> workerInfo = eventWorkers.stream().filter(eventWorker -> eventWorker.getEventIdentifier().equals(message.getEventIdentifier()))
                    .findFirst();

            if (workerInfo.isPresent()) {
                workerInfo.get().getWorkerRef().tell(message);
            } else {
                message.getSenderRef().tell(BetOffersRetrieved.builder().build());
            }

            return Behaviors.same();
        }, getContext(), message);
    }

    private Behavior<FortunaMessage> onGetEventIdentifiers(GetEventIdentifiers message) {
        return wrap(() -> {
            message.getSenderRef().tell(
                    EventIdentifiersRetrieved.builder()
                            .eventIdentifiers(
                                    eventWorkers.stream()
                                            .collect(Collectors.groupingBy(WorkerInfo::getEventCompetition))
                                            .entrySet()
                                            .stream()
                                            .map(entry -> Pair.of(entry.getKey(), entry.getValue().stream().map(WorkerInfo::getEventIdentifier).sorted().collect(Collectors.toList())))
                                            .collect(Collectors.toMap(Pair::getLeft, Pair::getRight))
                            )
                            .build()
            );

            return Behaviors.same();
        }, getContext(), message);
    }

    private Behavior<FortunaMessage> onRemoveBettingSourceOffers(RemoveBettingSourceOffers message) {
        return wrap(() -> {
            eventWorkers.stream()
                    .filter(worker -> worker.getEventCompetition().equals(message.getEventCompetition()))
                    .forEach(workerInfo -> workerInfo.getWorkerRef().tell(message));

            message.getSenderRef().tell(Done.done());

            return Behaviors.same();
        }, getContext(), message);
    }

    private Behavior<FortunaMessage> onBetEventMessage(final BetEventMessage message) {
        return wrap(
            () -> {
                Optional<WorkerInfo> activeEventWorker = findSimilarWorker(activeEventWorkers, message.getParticipants(), message.getEventIdentifier(), message.getEventCompetition());

                if (activeEventWorker.isPresent()) {
                    getContext().getLog().debug("Ignoring message {} due to active event worker {}", message, activeEventWorker.get());

                    return Behaviors.same();
                }

                Optional<WorkerInfo> similarWorker = findSimilarWorker(eventWorkers, message.getParticipants(), message.getEventIdentifier(), message.getEventCompetition());

                if (similarWorker.isPresent()) {
                    similarWorker.get().workerRef.tell(message);
                } else {
                    ActorRef<BetEventMessage> workerRef = getContext().spawn(
                            BehaviorUtils.withTimers((ctx, timer) -> new BetEventWorker(ctx, timer, message.getEventIdentifier(), getContext().getSelf())),
                            generateActorName(BetEventWorker.class.getSimpleName(), message.getEventIdentifier())
                    );
                    workerRef.tell(message);

                    if (message.getEventCompetition() == null || message.getParticipants() == null || message.getEventIdentifier() == null) {
                        getContext().getLog().error("Encountered incomplete message {}! Stopping supervisor.", message);
                        return Behaviors.stopped();
                    }

                    eventWorkers.add(WorkerInfo.builder().participants(message.getParticipants()).eventIdentifier(message.getEventIdentifier()).eventCompetition(message.getEventCompetition()).workerRef(workerRef).build());
                }

                return Behaviors.same();
        }, getContext(), message);
    }

    private Behavior<FortunaMessage> onBetArbitrageIdentified(BetArbitrageIdentified message) {
        notificationManagerRef.tell(message);

        return Behaviors.same();
    }

    @Builder
    @Data
    public static class WorkerInfo {
        List<String> participants;
        String eventIdentifier;
        EventCompetition eventCompetition;
        ActorRef<BetEventMessage> workerRef;
    }
}
