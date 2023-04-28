package fortuna.bettingsource.unibet;

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
import java.util.*;
import java.util.stream.Collectors;

import static fortuna.models.source.Bookmaker.UNIBET;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@SuperBuilder
@Slf4j
@Deprecated
public class LegacyUnibetThreeWayBetOfferSource extends BetOfferSource<ThreeWayBetOffer> {

    @Override
    public List<BetOfferSourceStep<ThreeWayBetOffer>> steps() {
        return List.of(
                BetOfferSourceStep.<ThreeWayBetOffer>builder()
                        .preDelay(Duration.of(5, ChronoUnit.SECONDS))
                        .intermediateStep(this::preExtract)
                        .build(),
                BetOfferSourceStep.<ThreeWayBetOffer>builder()
                        .preDelay(Duration.of(5, ChronoUnit.SECONDS))
                        .extractor(this::extractOffers)
                        .build()
        );
    }

    public void preExtract(WebDriver driver) {
        driver.findElement(By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll")).click();

        List<WebElement> elements = driver.findElements(By.cssSelector("div:not(.KambiBC-expanded).KambiBC-collapsible-container"));
        for (WebElement i : elements) {
            i.click();
        }
    }

    public List<ThreeWayBetOffer> extractOffers(String html) {
        Document doc = Jsoup.parse(html);

        return doc.select("li.KambiBC-event-item").stream().map(
           e -> {
               List<String> participants = e.select("div.KambiBC-event-participants__name").stream().map(p -> StringUtils.stripAccents(p.text())).collect(Collectors.toList());
               List<BigDecimal> odds = e.select("div.sc-iBYQkv").stream().map(Element::text).limit(3).map(BigDecimal::new).collect(Collectors.toList());

               return processThreeWayBetOffer(participants, odds, null, log).orElse(null);
           }
        ).filter(Objects::nonNull)
         .collect(Collectors.toList());
    }

    @Override
    public BettingSourceType getBettingSourceType() {
        return UNIBET;
    }
}
