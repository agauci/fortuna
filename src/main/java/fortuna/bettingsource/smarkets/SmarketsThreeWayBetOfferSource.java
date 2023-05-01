package fortuna.bettingsource.smarkets;

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

import static fortuna.models.source.BettingExchange.SMARKETS;
import static fortuna.models.source.Bookmaker.BET_AT_HOME;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@SuperBuilder
@Slf4j
public class SmarketsThreeWayBetOfferSource extends BetOfferSource<ThreeWayBetOffer> {

    @Override
    public List<BetOfferSourceStep<ThreeWayBetOffer>> steps() {
        return Collections.singletonList(
                BetOfferSourceStep.<ThreeWayBetOffer>builder()
                        .preDelay(Duration.of(3, ChronoUnit.SECONDS))
                        .extractor(this::extractOffers)
                        .build()
        );
    }

    public List<ThreeWayBetOffer> extractOffers(String html) {
        Document doc = Jsoup.parse(html);

        if (doc.selectFirst("h1.listing-main-header") == null) {
            log.debug("Redirected to main page! Skipping run.");
            return Collections.emptyList();
        }

        return doc.select("li.item-tile.event-tile").stream().map(
                e -> {
                    List<String> participants = processParticipants(e.select("span.team-name"), log);

                    if (e.selectFirst("div.score-block") != null) {
                        log.debug("Match {} for source {} is ongoing.", participants, getBettingSourceType());
                        return null;
                    }

                    List<BigDecimal> odds = processOdds(e.select("span.price.tick.buy"), log);

                    return processThreeWayBetOffer(participants, odds, null, log).orElse(null);
                }
        ).filter(Objects::nonNull)
         .collect(Collectors.toList());
    }

    @Override
    public BettingSourceType getBettingSourceType() {
        return SMARKETS;
    }
}
