package fortuna.bettingsource.betfair;

import fortuna.bettingsource.BetOfferSource;
import fortuna.models.offer.ThreeWayBetOffer;
import fortuna.models.source.BettingSourceType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static fortuna.models.source.BettingExchange.BETFAIR_EXCHANGE;
import static fortuna.models.source.Bookmaker.BETFAIR;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@SuperBuilder
@Slf4j
public class BetfairThreeWayBetOfferSource extends BetOfferSource<ThreeWayBetOffer> {

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

        if (doc.selectFirst("div.competition-name") == null) {
            log.debug("Redirected to homepage. Skipping run.");
            return Collections.emptyList();
        }

        return doc.select("li.com-coupon-line-new-layout.betbutton-layout.avb-row.avb-table.market-avb.quarter-template.market-2-columns").stream().map(
                e -> {
                    List<String> participants = processParticipants(e.select("span.team-name"), log);

                    Element scoreElement = e.selectFirst("span.ui-score-home");
                    if (scoreElement != null && !StringUtils.isEmpty(scoreElement.text())) {
                        log.debug("Match {} for source {} is ongoing.", participants, getBettingSourceType());
                        return processThreeWayBetOffer(participants, null, null, true, log).orElse(null);
                    }

                    Element inPlayElement = e.selectFirst("span.ui-no-score > span");
                    if (inPlayElement != null && inPlayElement.text().trim().equalsIgnoreCase("in-play")) {
                        log.debug("Match {} for source {} is ongoing.", participants, getBettingSourceType());
                        return processThreeWayBetOffer(participants, null, null, true, log).orElse(null);
                    }

                    List<BigDecimal> odds = processOdds(e.select("span.ui-runner-price"), 2, log);

                    return processThreeWayBetOffer(participants, odds, null, false, log).orElse(null);
                }
        ).filter(Objects::nonNull)
         .collect(Collectors.toList());
    }

    @Override
    public BettingSourceType getBettingSourceType() {
        return BETFAIR;
    }
}
