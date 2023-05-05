package fortuna;

import akka.Done;
import akka.actor.typed.ActorSystem;
import akka.actor.typed.javadsl.AskPattern;
import fortuna.message.FortunaMessage;
import fortuna.message.engine.*;
import fortuna.models.competition.EventCompetition;
import fortuna.models.competition.FootballCompetition;
import fortuna.models.offer.BetOffer;
import fortuna.models.source.BettingSourceType;
import fortuna.models.source.BettingSourceTypeResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

@RestController
public class AdminController {

    @Autowired
    ActorSystem<FortunaMessage> actorSystemRef;

    @GetMapping(path = "/offers", produces = "application/json")
    public CompletionStage<List<BetOffer<?>>> getOffers(@RequestParam(name = "eventIdentifier") String eventIdentifier, @RequestParam(name = "participants") List<String> participants, @RequestParam(name = "eventCompetition") String eventCompetition) {
        return AskPattern.<FortunaMessage, BetOffersRetrieved>ask(
                actorSystemRef,
                senderRef -> GetBetOffers.builder()
                                .senderRef(senderRef)
                                .eventCompetition((eventCompetition != null) ? FootballCompetition.valueOf(eventCompetition) : null)
                                .participants(participants)
                                .eventIdentifier(eventIdentifier)
                                .build(),
                Duration.ofSeconds(30),
                actorSystemRef.scheduler()
        ).thenApply(res -> res.getBetOffers());
    }

    @DeleteMapping(path = "/offers", produces = "application/json")
    public CompletionStage<ResponseEntity> removeOffers(@RequestParam(name = "bettingSourceType")String bettingSourceType, @RequestParam(name = "eventCompetition") String eventCompetition) {
        return AskPattern.<FortunaMessage, Done>ask(
                actorSystemRef,
                senderRef -> RemoveBettingSourceOffers.builder().senderRef(senderRef).eventCompetition(FootballCompetition.valueOf(eventCompetition)).bettingSourceType(BettingSourceTypeResolver.resolve(bettingSourceType)).build(),
                Duration.ofSeconds(30),
                actorSystemRef.scheduler()
        ).thenApply(res -> ResponseEntity.ok().build());
    }

    @GetMapping(path = "/event-identifiers", produces = "application/json")
    public CompletionStage<Map<EventCompetition, List<String>>> getEventIdentifiers() {
        return AskPattern.<FortunaMessage, EventIdentifiersRetrieved>ask(
                actorSystemRef,
                senderRef -> GetEventIdentifiers.builder().senderRef(senderRef).build(),
                Duration.ofSeconds(30),
                actorSystemRef.scheduler()
        ).thenApply(EventIdentifiersRetrieved::getEventIdentifiers);
    }


}
