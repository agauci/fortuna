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
import java.util.Collections;
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
public class BetsafeGroupThreeWayBetOfferSource extends BetOfferSource<ThreeWayBetOffer> {

    public Map<String, EventCompetition> competitions;

    @Override
    public List<BetOfferSourceStep<ThreeWayBetOffer>> steps() {
        return List.of(
                BetOfferSourceStep.<ThreeWayBetOffer>builder()
                        .preDelay(Duration.of(4, ChronoUnit.SECONDS))
                        .intermediateStep(this::preExtract)
                        .build(),
                BetOfferSourceStep.<ThreeWayBetOffer>builder()
                        .preDelay(Duration.of(100, ChronoUnit.MILLIS))
                        .extractor(this::extractOffers)
                        .build()
        );
    }

    public void preExtract(WebDriver driver) {
        driver.findElement(By.id("onetrust-accept-btn-handler")).click();

        // Close all expanded sections
        driver.findElements(By.cssSelector("div.expanded")).forEach(WebElement::click);

        driver.findElements(By.cssSelector("div:not(.expanded).obg-m-events-master-detail-header.no-animation.ng-star-inserted")).forEach((element) -> {
            if (competitions.containsKey(element.findElement(By.cssSelector("span.obg-m-events-master-detail-header-title")).getText())) {
                element.click();
            }
        });
    }

    public List<ThreeWayBetOffer> extractOffers(String html) {
        Document doc = Jsoup.parse(html);

        return doc.select("div.obg-event-row-event-container").stream().map(
                        e -> {
                            List<String> participants = processParticipants(e.select("span.obg-event-info-participant-name"), log);
                            List<BigDecimal> odds = processOdds(e.select("obg-numeric-change.obg-numeric-change.ng-star-inserted > span"), log);
                            String rawCompetition = e.selectFirst("span.obg-event-info-category-label.ng-star-inserted").text();

                            if (e.selectFirst("div.obg-event-info-default-scoreboard") != null) {
                                log.debug("Match {} for source {} is ongoing.", participants, getBettingSourceType());
                                return null;
                            }

                            return processThreeWayBetOffer(participants, odds, competitions.get(rawCompetition.substring(rawCompetition.indexOf("/") + 1).trim()), log).orElse(null);
                        }
                ).filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    @Override
    public BettingSourceType getBettingSourceType() {
        return BETSAFE;
    }
}
