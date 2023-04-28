package fortuna.bettingsource.betway;

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
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static fortuna.models.source.Bookmaker.BETWAY;
import static fortuna.models.source.Bookmaker.BWIN;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@SuperBuilder
@Slf4j
public class BetwayThreeWayBetOfferSource extends BetOfferSource<ThreeWayBetOffer> {

    @Override
    public List<BetOfferSourceStep<ThreeWayBetOffer>> steps() {
        return List.of(
                BetOfferSourceStep.<ThreeWayBetOffer>builder()
                        .preDelay(Duration.of(10, ChronoUnit.SECONDS))
                        .intermediateStep(this::clickInitialCookieAccept)
                        .build(),
                BetOfferSourceStep.<ThreeWayBetOffer>builder()
                        .preDelay(Duration.of(1, ChronoUnit.SECONDS))
                        .intermediateStep(this::preExtract)
                        .build(),
                BetOfferSourceStep.<ThreeWayBetOffer>builder()
                        .preDelay(Duration.of(100, ChronoUnit.MILLIS))
                        .extractor(this::extractOffers)
                        .build()
        );
    }

    public void clickInitialCookieAccept(WebDriver driver) {
        driver.findElement(By.cssSelector("span.sc-jTrPJq.ciTQMB")).click();
    }

    public void preExtract(WebDriver driver) {
        driver.findElement(By.cssSelector("button.sc-gLDzan.VlIQN.sc-dmqHEX.iOgbCN")).click();

        List<WebElement> elements = driver.findElements(By.cssSelector("div[collapsed=true].collapsableHeader"));
        for (WebElement i : elements) {
            i.click();
        }
    }

    public List<ThreeWayBetOffer> extractOffers(String html) {
        Document doc = Jsoup.parse(html);

        return doc.select("div.eventHolder").stream().map(
                e -> {
                    List<String> participants = processParticipants(e.select("span.teamNameFirstPart"), log);

                    if (e.selectFirst("span.homeTeamScore") != null) {
                        log.debug("Match {} for source {} is ongoing.", participants, getBettingSourceType());
                        return null;
                    }

                    List<BigDecimal> odds = processOdds(e.select("div.oddsDisplay"), log);

                    return processThreeWayBetOffer(participants, odds, null, log).orElse(null);
                }
        ).filter(Objects::nonNull)
         .collect(Collectors.toList());
    }

    @Override
    public BettingSourceType getBettingSourceType() {
        return BETWAY;
    }

    @Override
    public Duration retryDelay() {
        return Duration.of(3, ChronoUnit.SECONDS);
    }
}
