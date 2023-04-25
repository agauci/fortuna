package fortuna.engine;

import akka.actor.testkit.typed.javadsl.TestProbe;
import akka.actor.typed.ActorRef;
import fortuna.ActorAwareTest;
import fortuna.bettingsource.BettingSource;
import fortuna.message.FortunaMessage;
import fortuna.message.engine.BetArbitrageIdentified;
import fortuna.message.engine.BetEventMessage;
import fortuna.message.engine.BetOfferIdentified;
import fortuna.message.engine.BetOfferUpdated;
import fortuna.models.competition.EventCompetition;
import fortuna.models.offer.ThreeWayBetOffer;
import fortuna.models.source.BettingSourceType;
import fortuna.support.BehaviorUtils;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.List;

import static fortuna.models.competition.FootballCompetition.PREMIER_LEAGUE;
import static fortuna.models.source.BettingExchange.BETFAIR;
import static fortuna.models.source.Bookmaker.*;
import static org.assertj.core.api.Assertions.assertThat;

public class BetEventWorkerTest extends ActorAwareTest {

    TestProbe<FortunaMessage> parentProbe;

    @Before
    public void setup() {
        parentProbe = testKit.createTestProbe();
    }

    @Test
    public void test_arbitrage_opportunity_identified() {
        String eventIdentifier = "MAN_UTD_ARSENAL";
        List<String> participants = List.of("Manchester United", "Arsenal");

        ActorRef<BetEventMessage> actorRef = createActor(eventIdentifier);

        ThreeWayBetOffer unibetOffer = createOffer(eventIdentifier, participants, UNIBET, PREMIER_LEAGUE, BigDecimal.valueOf(1.60), BigDecimal.valueOf(3.00), BigDecimal.valueOf(8.00));
        ThreeWayBetOffer bwinOffer = createOffer(eventIdentifier, participants, BWIN, PREMIER_LEAGUE, BigDecimal.valueOf(1.80), BigDecimal.valueOf(3.20), BigDecimal.valueOf(5.00));
        ThreeWayBetOffer betwayOffer = createOffer(eventIdentifier, participants, BETWAY, PREMIER_LEAGUE, BigDecimal.valueOf(1.90), BigDecimal.valueOf(3.10), BigDecimal.valueOf(4.00));

        actorRef.tell(BetOfferIdentified.builder().offer(bwinOffer).build());
        actorRef.tell(BetOfferIdentified.builder().offer(unibetOffer).build());
        actorRef.tell(BetOfferIdentified.builder().offer(betwayOffer).build());

        BetArbitrageIdentified betArbitrageIdentifiedMessage = awaitMessage(parentProbe, BetArbitrageIdentified.class, Duration.of(1, ChronoUnit.SECONDS));
        assertThat(betArbitrageIdentifiedMessage.getOffers()).isEqualTo(List.of(betwayOffer, bwinOffer, unibetOffer));
    }

    @Test
    public void test_non_arbitrage_opportunity_correctly_skipped() {
        String eventIdentifier = "MAN_UTD_ARSENAL";
        List<String> participants = List.of("Manchester United", "Arsenal");

        ActorRef<BetEventMessage> actorRef = createActor(eventIdentifier);

        ThreeWayBetOffer unibetOffer = createOffer(eventIdentifier, participants, UNIBET, PREMIER_LEAGUE, BigDecimal.valueOf(3.25), BigDecimal.valueOf(3.25), BigDecimal.valueOf(2.20));
        ThreeWayBetOffer bwinOffer = createOffer(eventIdentifier, participants, BWIN, PREMIER_LEAGUE, BigDecimal.valueOf(3.5), BigDecimal.valueOf(3.30), BigDecimal.valueOf(2.10));
        ThreeWayBetOffer betwayOffer = createOffer(eventIdentifier, participants, BETWAY, PREMIER_LEAGUE, BigDecimal.valueOf(3.40), BigDecimal.valueOf(3.30), BigDecimal.valueOf(2.10));

        actorRef.tell(BetOfferIdentified.builder().offer(unibetOffer).build());
        actorRef.tell(BetOfferIdentified.builder().offer(bwinOffer).build());
        actorRef.tell(BetOfferIdentified.builder().offer(betwayOffer).build());

        parentProbe.expectNoMessage(Duration.of(2, ChronoUnit.SECONDS));
    }

    @Test
    public void test_arbitrage_opportunity_identified_on_update() {
        String eventIdentifier = "MAN_UTD_ARSENAL";
        List<String> participants = List.of("Manchester United", "Arsenal");

        ActorRef<BetEventMessage> actorRef = createActor(eventIdentifier);

        ThreeWayBetOffer unibetOffer = createOffer(eventIdentifier, participants, UNIBET, PREMIER_LEAGUE, BigDecimal.valueOf(1.60), BigDecimal.valueOf(3.00), BigDecimal.valueOf(5.00));
        ThreeWayBetOffer bwinOffer = createOffer(eventIdentifier, participants, BWIN, PREMIER_LEAGUE, BigDecimal.valueOf(1.80), BigDecimal.valueOf(3.20), BigDecimal.valueOf(5.00));
        ThreeWayBetOffer betwayOffer = createOffer(eventIdentifier, participants, BETWAY, PREMIER_LEAGUE, BigDecimal.valueOf(1.90), BigDecimal.valueOf(3.10), BigDecimal.valueOf(4.00));

        actorRef.tell(BetOfferIdentified.builder().offer(bwinOffer).build());
        actorRef.tell(BetOfferIdentified.builder().offer(unibetOffer).build());
        actorRef.tell(BetOfferIdentified.builder().offer(betwayOffer).build());

        // At first, no arbitrage opportunity exists
        parentProbe.expectNoMessage(Duration.of(2, ChronoUnit.SECONDS));

        ThreeWayBetOffer updatedUnibetOffer = createOffer(eventIdentifier, participants, UNIBET, PREMIER_LEAGUE, BigDecimal.valueOf(1.60), BigDecimal.valueOf(3.00), BigDecimal.valueOf(8.00));
        actorRef.tell(BetOfferUpdated.builder().offer(updatedUnibetOffer).build());

        BetArbitrageIdentified betArbitrageIdentifiedMessage = awaitMessage(parentProbe, BetArbitrageIdentified.class, Duration.of(1, ChronoUnit.SECONDS));
        assertThat(betArbitrageIdentifiedMessage.getOffers()).isEqualTo(List.of(betwayOffer, bwinOffer, updatedUnibetOffer));
    }

    @Test
    public void test_non_arbitrage_opportunity_with_draw_and_win_probability_higher_than_100_correctly_skipped() {
        String eventIdentifier = "MAN_UTD_ARSENAL";
        List<String> participants = List.of("Manchester United", "Arsenal");

        ActorRef<BetEventMessage> actorRef = createActor(eventIdentifier);

        ThreeWayBetOffer betfairOffer = createOffer(eventIdentifier, participants, BETFAIR, PREMIER_LEAGUE, BigDecimal.valueOf(1.19), BigDecimal.valueOf(6.22), BigDecimal.valueOf(11.45));
        ThreeWayBetOffer bwinOffer = createOffer(eventIdentifier, participants, BWIN, PREMIER_LEAGUE, BigDecimal.valueOf(1.22), BigDecimal.valueOf(6.00), BigDecimal.valueOf(13.00));
        ThreeWayBetOffer betwayOffer = createOffer(eventIdentifier, participants, BETWAY, PREMIER_LEAGUE, BigDecimal.valueOf(1.23), BigDecimal.valueOf(7.00), BigDecimal.valueOf(14.00));

        actorRef.tell(BetOfferIdentified.builder().offer(bwinOffer).build());
        actorRef.tell(BetOfferIdentified.builder().offer(betfairOffer).build());
        actorRef.tell(BetOfferIdentified.builder().offer(betwayOffer).build());

        parentProbe.expectNoMessage(Duration.of(2, ChronoUnit.SECONDS));
    }

    private ThreeWayBetOffer createOffer(String eventIdentifier,
                                         List<String> participants,
                                         BettingSourceType bettingSourceType,
                                         EventCompetition eventCompetition,
                                         BigDecimal one,
                                         BigDecimal draw,
                                         BigDecimal two) {
        return ThreeWayBetOffer.builder()
                   .participants(participants)
                   .eventIdentifier(eventIdentifier)
                   .bettingSourceType(bettingSourceType)
                   .eventCompetition(eventCompetition)
                   .extractedTimestamp(System.currentTimeMillis())
                   .one(one)
                   .draw(draw)
                   .two(two)
                   .build();
    }

    private ActorRef<BetEventMessage> createActor(final String eventIdentifier) {
        return track(testKit.spawn(BehaviorUtils.withTimers((ctx, timer) -> new BetEventWorker(ctx, timer, eventIdentifier, parentProbe.getRef()))));
    }

}
