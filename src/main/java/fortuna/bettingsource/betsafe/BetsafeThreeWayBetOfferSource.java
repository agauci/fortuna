package fortuna.bettingsource.betsafe;

import fortuna.bettingsource.BetOfferSource;
import fortuna.models.competition.EventCompetition;
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
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import static fortuna.models.source.Bookmaker.BETSAFE;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@SuperBuilder
@Slf4j
public class BetsafeThreeWayBetOfferSource extends BetOfferSource<ThreeWayBetOffer> {

    @Override
    public List<BetOfferSourceStep<ThreeWayBetOffer>> steps() {
        return List.of(
                BetOfferSourceStep.<ThreeWayBetOffer>builder()
                        .preDelay(Duration.of(2, ChronoUnit.SECONDS))
                        .intermediateStep(this::preExtract)
                        .build(),
                BetOfferSourceStep.<ThreeWayBetOffer>builder()
                        .preDelay(Duration.of(1, ChronoUnit.SECONDS))
                        .extractor(this::extractOffers)
                        .build()
        );
    }

    public void preExtract(WebDriver driver) {
        driver.findElement(By.id("onetrust-accept-btn-handler")).click();

        driver.findElements(By.cssSelector("div:not(.expanded).obg-m-events-master-detail-header.no-animation.ng-star-inserted")).forEach((element) -> {
            element.click();
        });
    }

    public List<ThreeWayBetOffer> extractOffers(String html) {
        Document doc = Jsoup.parse(html);

        return doc.select("div.obg-event-row-event-container").stream().map(
                        e -> {
                            List<String> participants = processParticipants(e.select("span.obg-event-info-participant-name"), log);

                            if (e.selectFirst("div.obg-event-info-default-scoreboard") != null) {
                                log.debug("Match {} for source {} is ongoing.", participants, getBettingSourceType());
                                return null;
                            }

                            List<BigDecimal> odds = processOdds(e.select("obg-numeric-change.obg-numeric-change.ng-star-inserted > span"), log);

                            return processThreeWayBetOffer(participants, odds, null, log).orElse(null);
                        }
                ).filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    @Override
    public BettingSourceType getBettingSourceType() {
        return BETSAFE;
    }
}
