package fortuna.support;

import fortuna.bettingsource.BettingSourceCatalogue;
import fortuna.engine.ArbitrageEngineSupervisor;
import fortuna.message.engine.BetArbitrageIdentified;
import fortuna.models.competition.EventCompetition;
import fortuna.models.notification.LogAwareNotification;
import fortuna.models.notification.PushNotificationAwareNotification.PushNotification;
import fortuna.models.offer.BetOffer;
import fortuna.models.offer.ThreeWayBetOffer;
import fortuna.models.source.BettingSourceType;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.Ignore;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import static fortuna.models.competition.FootballCompetition.PREMIER_LEAGUE;
import static fortuna.models.source.Bookmaker.*;

public class LogNotificationUtilsTest {

    @Test
    public void test_log_notification() {
        String eventIdentifier = "MAN_UTD_ARSENAL";
        List<String> participants = List.of("Manchester United", "Arsenal");

        ThreeWayBetOffer betwayOffer = createOffer(eventIdentifier, participants, BETWAY, PREMIER_LEAGUE, BigDecimal.valueOf(1.90), BigDecimal.valueOf(3.10), BigDecimal.valueOf(4.00));
        ThreeWayBetOffer bwinOffer = createOffer(eventIdentifier, participants, BWIN, PREMIER_LEAGUE, BigDecimal.valueOf(1.80), BigDecimal.valueOf(3.20), BigDecimal.valueOf(5.00));
        ThreeWayBetOffer unibetOffer = createOffer(eventIdentifier, participants, UNIBET, PREMIER_LEAGUE, BigDecimal.valueOf(1.60), BigDecimal.valueOf(3.00), BigDecimal.valueOf(8.00));
        List<BetOffer<?>> offers = List.of(betwayOffer, bwinOffer, unibetOffer);
        BigDecimal probability = ThreeWayBetOffer.multiOfferOdds(betwayOffer, bwinOffer, unibetOffer);

        LogNotificationUtils.triggerLogNotification(
                LogAwareNotification.LogNotification.builder()
                        .timestamp(System.currentTimeMillis())
                        .message(BetArbitrageIdentified.BetArbitrageLog.builder()
                                .betOffers(offers.stream().map(BetOffer::toSummary).collect(Collectors.toList()))
                                .participants(offers.stream().map(offer -> Pair.of(
                                        offer.getParticipants(),
                                        offer.getEventIdentifier()
                                )).collect(Collectors.toList()))
                                .type(offers.get(0).getType())
                                .bettingSources(offers.stream().map(offer -> Pair.of(
                                        offer.getBettingSourceType(),
                                        BettingSourceCatalogue.resolveUrl(offer)
                                )).collect(Collectors.toList()))
                                .eventCompetition(offers.get(0).getEventCompetition())
                                .odds(List.of(betwayOffer.getOne(), bwinOffer.getDraw(), unibetOffer.getTwo()))
                                .betOffers(offers.stream().map(BetOffer::toSummary).collect(Collectors.toList()))
                                .probability(probability)
                                .build())
                        .source("Test")
                        .logType("ARBITRAGE_BET_IDENTIFIED")
                        .logLevel(LogAwareNotification.LogLevel.HIGH)
                        .build()
        );
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
                .extractedTimestamp(LocalDateTime.now())
                .one(one)
                .draw(draw)
                .two(two)
                .build();
    }

}
