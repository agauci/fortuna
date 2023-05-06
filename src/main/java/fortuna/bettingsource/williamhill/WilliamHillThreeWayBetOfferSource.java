package fortuna.bettingsource.williamhill;

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

import static fortuna.models.source.Bookmaker.WILLIAM_HILL;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@SuperBuilder
@Slf4j
public class WilliamHillThreeWayBetOfferSource extends BetOfferSource<ThreeWayBetOffer> {

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

        return doc.select("article.sp-o-market.sp-o-market--default").stream().map(
                e -> {
                    List<String> participants = processParticipants(e.selectFirst("a > span"), " v ", log);

                    if (e.selectFirst("div.score-block") != null) {
                        log.debug("Match {} for source {} is ongoing.", participants, getBettingSourceType());
                        return processThreeWayBetOffer(participants, null, null, true, log).orElse(null);
                    }

                    List<BigDecimal> odds = processFractionalOdds(e.select("button.sp-betbutton > span"), "/", log);

                    return processThreeWayBetOffer(participants, odds, null, false, log).orElse(null);
                }
        ).filter(Objects::nonNull)
         .collect(Collectors.toList());
    }

    @Override
    public BettingSourceType getBettingSourceType() {
        return WILLIAM_HILL;
    }
}
