package fortuna.bettingsource.eighteighteight;

import fortuna.bettingsource.BetOfferSource;
import fortuna.models.offer.ThreeWayBetOffer;
import fortuna.models.source.BettingSourceType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static fortuna.models.source.Bookmaker.EIGHTEIGHTEIGHT;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@SuperBuilder
@Slf4j
public class EightEightEightThreeWayBetOfferSource extends BetOfferSource<ThreeWayBetOffer> {

    @Override
    public List<BetOfferSourceStep<ThreeWayBetOffer>> steps() {
        return Collections.singletonList(
                BetOfferSourceStep.<ThreeWayBetOffer>builder()
                        .preDelay(Duration.of(2, ChronoUnit.SECONDS))
                        .extractor(this::extractOffers)
                        .build()
        );
    }

    public List<ThreeWayBetOffer> extractOffers(String html) {
        Document doc = Jsoup.parse(html);

        return doc.select("div.bet-card").stream().map(
                e -> {
                    List<String> participants = processParticipants(e.select("span.event-description__competitor-text"), log);

                    if (e.selectFirst("span.bb-score-board__score-field") != null) {
                        log.debug("Match {} for source {} is ongoing.", participants, getBettingSourceType());
                        return processThreeWayBetOffer(participants, null, null, true, log).orElse(null);
                    }

                    List<BigDecimal> odds = processOdds(e.select("span.bb-sport-event__selection"), log);

                    return processThreeWayBetOffer(participants, odds, null,false,  log).orElse(null);
                }
        ).filter(Objects::nonNull)
         .collect(Collectors.toList());
    }

    @Override
    public BettingSourceType getBettingSourceType() {
        return EIGHTEIGHTEIGHT;
    }
}
