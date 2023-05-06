package fortuna.models.offer;

import fortuna.models.competition.EventCompetition;
import fortuna.models.source.BettingSourceType;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.*;

import static java.math.BigDecimal.ONE;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Slf4j
public class ThreeWayBetOffer extends BetOffer<ThreeWayBetOffer> {

    private static RoundingMode DEFAULT_ROUNDING_MODE = RoundingMode.HALF_EVEN;

    BigDecimal one;
    BigDecimal draw;
    BigDecimal two;

    @Builder(toBuilder = true)
    protected ThreeWayBetOffer(List<String> participants,
                               String eventIdentifier,
                               BettingSourceType bettingSourceType,
                               EventCompetition eventCompetition,
                               LocalDateTime extractedTimestamp,
                               List<BigDecimal> originalOdds,
                               BigDecimal one,
                               BigDecimal draw,
                               BigDecimal two) {
        super(participants, eventIdentifier, BetOfferType.THREE_WAY, bettingSourceType, eventCompetition, extractedTimestamp, originalOdds);

        this.one = one;
        this.draw = draw;
        this.two = two;
    }

    public BigDecimal offerOdds() {
        return calculateThreeWayOdds(one, draw, two);
    }

    public static BigDecimal multiOfferOdds(final ThreeWayBetOffer firstTeamWin, final ThreeWayBetOffer draw, final ThreeWayBetOffer secondTeamWin) {
        return calculateThreeWayOdds(firstTeamWin.one, draw.draw, secondTeamWin.two);
    }

    private static BigDecimal calculateThreeWayOdds(final BigDecimal one, final BigDecimal draw, final BigDecimal two) {
        return divide(ONE, one).add(divide(ONE, draw).add(divide(ONE, two)));
    }

    public static Optional<? extends BetOffer<?>> searchArbitrage(final BetOffer<?> firstTeamWin, final BetOffer<?> draw, final List<BetOffer<?>> candidateOffers) {

        Optional<BigDecimal> twoWinThreshold = extractTwoWinThreshold(firstTeamWin, draw);
        if (twoWinThreshold.isEmpty()) {
            return Optional.empty();
        }

        Set<BettingSourceType> consumedBettingSources = Set.of(firstTeamWin.getBettingSourceType(), draw.getBettingSourceType());

        Optional<ThreeWayBetOffer> offerWithHighestTwoWinOdds = candidateOffers.stream()
                .map(offer -> (ThreeWayBetOffer) offer)
                .filter(offer -> !consumedBettingSources.contains(offer.bettingSourceType))
                .max(Comparator.comparing(val -> val.two));

        if (offerWithHighestTwoWinOdds.isPresent() && offerWithHighestTwoWinOdds.get().two.compareTo(twoWinThreshold.get()) >= 0) {
            return offerWithHighestTwoWinOdds;
        } else {
            return Optional.empty();
        }
    }

    private static Optional<BigDecimal> extractTwoWinThreshold(final BetOffer<?> firstTeamWin, final BetOffer<?> draw) {
        BigDecimal firstTeamWinOdds = ((ThreeWayBetOffer) firstTeamWin).one;
        BigDecimal drawOdds = ((ThreeWayBetOffer) draw).draw;

        BigDecimal denominator = BigDecimal.valueOf(0.975).subtract(divide(ONE, firstTeamWinOdds)).subtract(divide(ONE, drawOdds));

        if (denominator.compareTo(BigDecimal.ZERO) <= 0) {
            return Optional.empty();
        }

        return Optional.of(divide(ONE, denominator));
    }

    private static BigDecimal divide(BigDecimal val1, BigDecimal val2) {
        return val1.divide(val2, 8, DEFAULT_ROUNDING_MODE);
    }

    @Override
    public boolean isEquivalentTo(ThreeWayBetOffer betOffer) {
        if (!eventIdentifier.equals(betOffer.eventIdentifier)) {
            return false;
        }
        if (!type.equals(betOffer.type)) {
            return false;
        }

        return (one.compareTo(betOffer.one) == 0)
                    && (draw.compareTo(betOffer.draw) == 0)
                        && (two.compareTo(betOffer.two) == 0);
    }

    @Override
    public BetOfferSummary toSummary() {
        return BetOfferSummary.builder()
                .participants(participants)
                .type(type)
                .bettingSourceType(bettingSourceType)
                .eventCompetition(eventCompetition)
                .extractedTimestamp(extractedTimestamp)
                .odds(List.of(one, draw, two))
                .build();
    }
}
