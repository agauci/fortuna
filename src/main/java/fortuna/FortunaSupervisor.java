package fortuna;

import akka.actor.typed.ActorRef;
import akka.actor.typed.Behavior;
import akka.actor.typed.javadsl.AbstractBehavior;
import akka.actor.typed.javadsl.ActorContext;
import akka.actor.typed.javadsl.Behaviors;
import akka.actor.typed.javadsl.Receive;
import fortuna.engine.ArbitrageEngineSupervisor;
import fortuna.extractor.BetOfferExtractor;
import fortuna.message.FortunaMessage;
import fortuna.message.extractor.ExtractorMessage;
import fortuna.message.internal.shutdown.SystemShutdown;
import fortuna.support.BehaviorUtils;
import org.springframework.core.io.ResourceLoader;

import static fortuna.support.BehaviorUtils.wrap;

public class FortunaSupervisor extends AbstractBehavior<FortunaMessage> {

    private ResourceLoader              resourceLoader;

    private ActorRef<FortunaMessage>    engineRef;
    private ActorRef<ExtractorMessage>  extractorRef;

    public FortunaSupervisor(ActorContext<FortunaMessage> context, ResourceLoader resourceLoader) {
        super(context);
        this.resourceLoader = resourceLoader;

        createInitialActors();

        getContext().getLog().info("FortunaSupervisor supervisor started!");
    }

    @Override
    public Receive<FortunaMessage> createReceive() {
        return newReceiveBuilder()
                .onMessage(SystemShutdown.class, this::onSystemShutdown)
                .build();
    }

    private Behavior<FortunaMessage> onSystemShutdown(SystemShutdown message) {
        return wrap(() -> {
            extractorRef.tell(message);
            return Behaviors.same();
        }, getContext(), message);
    }

    private void createInitialActors() {
        engineRef = getContext().spawn(Behaviors.setup(ArbitrageEngineSupervisor::new), ArbitrageEngineSupervisor.class.getSimpleName());
        extractorRef = getContext().spawn(BehaviorUtils.withTimers((ctx, timer) -> new BetOfferExtractor(ctx, timer, resourceLoader, engineRef)), BetOfferExtractor.class.getSimpleName());
    }
}
