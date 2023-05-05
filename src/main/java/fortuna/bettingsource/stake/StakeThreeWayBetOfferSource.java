package fortuna.bettingsource.stake;

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
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static fortuna.models.source.Bookmaker.STAKE;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@SuperBuilder
@Slf4j
public class StakeThreeWayBetOfferSource extends BetOfferSource<ThreeWayBetOffer> {

    @Override
    public List<BetOfferSourceStep<ThreeWayBetOffer>> steps() {
        return List.of(
                BetOfferSourceStep.<ThreeWayBetOffer>builder()
                        .preDelay(Duration.of(1, ChronoUnit.SECONDS))
                        .extractor(this::extractOffers)
                        .build()
        );
    }
    public List<ThreeWayBetOffer> extractOffers(String html) {
        Document doc = Jsoup.parse(html);

        return doc.select("div.fixture-preview").stream().map(
                e -> {
                    List<String> participants = processParticipants(e.select("span.content-or-loader"), log);

                    if (e.selectFirst("div.score-wrapper") != null) {
                        log.debug("Match {} for source {} is ongoing.", participants, getBettingSourceType());
                        return null;
                    }

                    List<BigDecimal> odds = processOdds(e.select("div.odds.svelte-bbfzn7 > span"), log);

                    return processThreeWayBetOffer(participants, odds, null, log).orElse(null);
                }
        ).filter(Objects::nonNull)
         .collect(Collectors.toList());
    }

    @Override
    public BettingSourceType getBettingSourceType() {
        return STAKE;
    }
}
