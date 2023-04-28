package fortuna;

import java.time.Duration;

import akka.actor.typed.ActorSystem;
import akka.actor.typed.javadsl.AskPattern;
import akka.actor.typed.javadsl.Behaviors;
import fortuna.message.FortunaMessage;
import fortuna.message.internal.shutdown.SystemShutdown;
import fortuna.message.internal.shutdown.SystemShutdownAck;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import static fortuna.support.RuntimeUtils.cleanupChrome;

@SpringBootApplication
@Slf4j
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    @Scope("singleton")
    public ActorSystem<FortunaMessage> createActorSystem(@Autowired ResourceLoader resourceLoader) {
        return ActorSystem.create(Behaviors.setup(ctx -> new FortunaSupervisor(ctx, resourceLoader)), "fortuna");
    }

    @Component
    public static class ContextClosedEventListener {

        @Autowired
        ActorSystem<FortunaMessage> actorSystem;

        @EventListener(ContextClosedEvent.class)
        public void onContextClosedEvent(ContextClosedEvent contextClosedEvent) throws InterruptedException {
            AskPattern.<FortunaMessage, SystemShutdownAck>ask(
                actorSystem,
                senderRef -> SystemShutdown.builder().senderRef(senderRef).build(),
                Duration.ofSeconds(5),
                actorSystem.scheduler()
            ).thenAccept(confirmation -> cleanupChrome());

            Thread.sleep(3000);
        }
    }

}
