package fortuna.message.engine;

import fortuna.bettingsource.BettingSourceCatalogue;
import fortuna.engine.ArbitrageEngineSupervisor;
import fortuna.models.competition.EventCompetition;
import fortuna.models.notification.FileAwareNotification;
import fortuna.models.notification.LogAwareNotification;
import fortuna.models.notification.PushNotificationAwareNotification;
import fortuna.models.offer.BetOffer;
import fortuna.models.offer.BetOfferSummary;
import fortuna.models.offer.BetOfferType;
import fortuna.models.offer.ThreeWayBetOffer;
import fortuna.models.source.BettingSourceType;
import lombok.Builder;
import lombok.Data;
import org.apache.commons.lang3.tuple.Pair;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static fortuna.bettingsource.BettingSourceCatalogue.resolveUrl;

@Builder
@Data
public class BetArbitrageIdentified implements FileAwareNotification, LogAwareNotification, PushNotificationAwareNotification {

    private static final String ARBITRAGE_FILE = "C:\\dev\\trees\\fortuna\\arbitrageOutcome.txt";

    List<BetOffer<?>> offers;
    BetOfferType betOfferType;
    List<BigDecimal> odds;
    BigDecimal probability;

    @Override
    public FileNotification toFileNotification() {
        switch (betOfferType) {
            case TWO_WAY -> throw new IllegalStateException("Unsupported value: " + betOfferType);
            case THREE_WAY -> {
                return FileNotification.builder()
                        .fileName(ARBITRAGE_FILE)
                        .lineContent(String.format("Probability: %s, Odds: %s %s ONE: %s - %s, %s DRAW: %s - %s, %s TWO: %s - %s",
                                probability, odds, System.lineSeparator(),
                                resolveUrl(offers.get(0)), offers.get(0).toString(), System.lineSeparator(),
                                resolveUrl(offers.get(1)), offers.get(1).toString(), System.lineSeparator(),
                                resolveUrl(offers.get(2)), offers.get(2).toString()))
                        .build();
            }
            default -> throw new IllegalStateException("Unexpected value: " + betOfferType);
        }
    }

    @Override
    public LogNotification toLogNotification() {
        return LogNotification.builder()
                .timestamp(System.currentTimeMillis())
                .message(BetArbitrageLog.builder()
                        .participants(offers.get(0).getParticipants())
                        .type(offers.get(0).getType())
                        .bettingSources(offers.stream().map(offer -> Pair.of(
                                offer.getBettingSourceType(),
                                BettingSourceCatalogue.resolveUrl(offer)
                        )).collect(Collectors.toMap(Pair::getLeft, Pair::getRight)))
                        .eventCompetition(offers.get(0).getEventCompetition())
                        .odds(odds)
                        .probability(probability)
                        .betOffers(offers.stream().map(BetOffer::toSummary).collect(Collectors.toList()))
                        .build())
                .source(ArbitrageEngineSupervisor.class.getSimpleName())
                .logType("ARBITRAGE_BET_IDENTIFIED")
                .logLevel(LogLevel.HIGH)
                .build();
    }

    @Override
    public PushNotification toPushNotification() {
        switch (betOfferType) {
            case TWO_WAY -> throw new IllegalStateException("Unsupported value: " + betOfferType);
            case THREE_WAY -> {
                return PushNotification.builder()
                        .title(probability.multiply(BigDecimal.valueOf(100)) + " Arbitrage Opportunity Identified")
                        .message(String.format("ONE: %s - %s (%s), DRAW: %s (%s), TWO: %s - %s (%s)",
                                offers.get(0).getParticipants().get(0),  offers.get(0).getBettingSourceType(), ((ThreeWayBetOffer) offers.get(0)).getOne(),
                                offers.get(1).getBettingSourceType(),  ((ThreeWayBetOffer) offers.get(1)).getDraw(),
                                offers.get(2).getParticipants().get(1),  offers.get(2).getBettingSourceType(), ((ThreeWayBetOffer) offers.get(2)).getTwo()))
                        .build();
            }
            default -> throw new IllegalStateException("Unexpected value: " + betOfferType);
        }
    }

    @Data
    @Builder
    public static class BetArbitrageLog {
        List<BetOfferSummary>           betOffers;
        List<String>                    participants;
        BetOfferType                    type;
        Map<BettingSourceType, String>  bettingSources;
        EventCompetition                eventCompetition;
        List<BigDecimal>                odds;
        BigDecimal                      probability;
    }
}
