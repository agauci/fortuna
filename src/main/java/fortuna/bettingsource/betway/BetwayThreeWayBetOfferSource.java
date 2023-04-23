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
    public void preExtract(WebDriver driver) {
        driver.findElement(By.cssSelector("div.messagePromptButton.action")).click();

        List<WebElement> elements = driver.findElements(By.cssSelector("div[collapsed=true].collapsableHeader"));
        for (WebElement i : elements) {
            i.click();
        }
    }

    @Override
    public List<ThreeWayBetOffer> extractOffers(String html) {
        Document doc = Jsoup.parse(html);

        return doc.select("div.eventHolder").stream().map(
                e -> {
                    List<String> participants = processParticipants(e.select("span.teamNameFirstPart"), log);
                    List<BigDecimal> odds = processOdds(e.select("div.oddsDisplay"), log);

                    return processThreeWayBetOffer(participants, odds, null, log).orElse(null);
                }
        ).filter(Objects::nonNull)
         .collect(Collectors.toList());
    }

    @Override
    public Duration initialDelay() {
        return Duration.of(10, ChronoUnit.SECONDS);
    }

    @Override
    public Duration preHtmlExtractionDelay() {
        return Duration.of(100, ChronoUnit.MILLIS);
    }

    @Override
    public BettingSourceType getBettingSourceType() {
        return BETWAY;
    }
}
