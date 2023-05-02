package fortuna.engine;

import akka.actor.typed.ActorRef;
import akka.actor.typed.Behavior;
import akka.actor.typed.javadsl.*;
import fortuna.message.FortunaMessage;
import fortuna.message.engine.BetArbitrageIdentified;
import fortuna.message.engine.BetEventMessage;
import fortuna.message.engine.WorkerInfoUpdated;
import fortuna.models.competition.EventCompetition;
import fortuna.models.notification.NotificationMessage;
import fortuna.support.BehaviorUtils;
import lombok.Builder;
import lombok.Data;

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

    public ArbitrageEngineSupervisor(ActorContext<FortunaMessage> context, ActorRef<NotificationMessage> notificationManagerRef, TimerScheduler<FortunaMessage> scheduler) {
        super(context);

        getContext().getLog().info("Arbitrage engine supervisor started!");

        scheduler.startTimerWithFixedDelay(EventWorkerUpdateTrigger.builder().build(), Duration.of(10, ChronoUnit.MINUTES));

        this.notificationManagerRef = notificationManagerRef;
    }

    @Override
    public Receive<FortunaMessage> createReceive() {
        return newReceiveBuilder()
                .onMessage(BetEventMessage.class, this::onBetEventMessage)
                .onMessage(BetArbitrageIdentified.class, this::onBetArbitrageIdentified)
                .onMessage(EventWorkerUpdateTrigger.class, this::onEventWorkerUpdateTrigger)
                .build();
    }

    private Behavior<FortunaMessage> onBetEventMessage(final BetEventMessage message) {
        return wrap(
            () -> {
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


    private Behavior<FortunaMessage> onEventWorkerUpdateTrigger(EventWorkerUpdateTrigger tick) {
        return wrap(() -> {
            eventWorkers.stream()
                    .collect(Collectors.groupingBy(WorkerInfo::getEventCompetition))
                    .forEach((key, val) -> {
                        notificationManagerRef.tell(WorkerInfoUpdated.builder()
                                                        .eventCompetition(key)
                                                        .eventIdentifiers(val.stream().map(WorkerInfo::getEventIdentifier).sorted().collect(Collectors.toList()))
                                                        .build());
                    });


            return Behaviors.same();
        }, getContext(), tick);
    }

    @Builder
    @Data
    public static class WorkerInfo {
        List<String> participants;
        String eventIdentifier;
        EventCompetition eventCompetition;
        ActorRef<BetEventMessage> workerRef;
    }

    @Data
    @Builder
    private static class EventWorkerUpdateTrigger implements FortunaMessage {}
}
