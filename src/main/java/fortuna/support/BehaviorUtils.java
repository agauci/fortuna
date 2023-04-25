package fortuna.support;

import akka.actor.typed.Behavior;
import akka.actor.typed.javadsl.ActorContext;
import akka.actor.typed.javadsl.Behaviors;
import akka.actor.typed.javadsl.TimerScheduler;
import lombok.experimental.UtilityClass;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@UtilityClass
public class BehaviorUtils {

    public static <M extends T, T> Behavior<T> wrap(Supplier<Behavior<T>> behaviorSupplier, ActorContext<T> context, M message) {
        return wrap(behaviorSupplier, (e) -> Behaviors.stopped(), context, message);
    }

    public static <M extends T, T> Behavior<T> wrap(Supplier<Behavior<T>> behaviorSupplier, Function<Exception, Behavior<T>> failureBehaviorSupplier, ActorContext<T> context, M message) {
        try {
            context.getLog().debug("Received message {}", message);

            return behaviorSupplier.get();
        } catch (Exception e) {
            context.getLog().error("Encountered unexpected exception while processing message {}. Stopping actor! Exception:", message, e);
            return failureBehaviorSupplier.apply(e);
        }
    }

    public static <T> Behavior<T> withTimers(BiFunction<ActorContext<T>, TimerScheduler<T>, Behavior<T>> behaviorCreator) {
        return Behaviors.setup(ctx -> Behaviors.withTimers(timers -> behaviorCreator.apply(ctx, timers)));
    }

    public static String generateActorName(String... identifiers) {
        return Arrays.stream(identifiers).collect(Collectors.joining("-"));
    }

}
