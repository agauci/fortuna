package fortuna;

import akka.actor.typed.ActorSystem;
import akka.actor.typed.javadsl.AskPattern;
import fortuna.message.FortunaMessage;
import fortuna.message.engine.BetOffersRetrieved;
import fortuna.message.engine.GetBetOffers;
import fortuna.models.competition.EventCompetition;
import fortuna.models.competition.FootballCompetition;
import fortuna.models.offer.BetOffer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

@RestController
public class AdminController {

    @Autowired
    ActorSystem<FortunaMessage> actorSystemRef;

    @GetMapping(path = "/offers", produces = "application/json")
    public CompletionStage<List<BetOffer<?>>> getBook(@RequestParam(name = "eventIdentifier") String eventIdentifier, @RequestParam(name = "participants") List<String> participants, @RequestParam(name = "eventCompetition") String eventCompetition) {
        return AskPattern.<FortunaMessage, BetOffersRetrieved>ask(
                actorSystemRef,
                senderRef -> GetBetOffers.builder().senderRef(senderRef).eventCompetition(FootballCompetition.valueOf(eventCompetition)).participants(participants).eventIdentifier(eventIdentifier).build(),
                Duration.ofSeconds(30),
                actorSystemRef.scheduler()
        ).thenApply(res -> res.getBetOffers());
    }

}
