package fortuna.bettingsource.izibet;

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
import org.openqa.selenium.WebDriver;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static fortuna.models.source.Bookmaker.IZIBET;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@SuperBuilder
@Slf4j
public class IzibetThreeWayBetOfferSource extends BetOfferSource<ThreeWayBetOffer> {

    @Override
    public void preExtract(WebDriver driver) {
        // Do nothing
    }

    @Override
    public List<ThreeWayBetOffer> extractOffers(String html) {
        Document doc = Jsoup.parse(html);

        return doc.select("div.EventItem").stream().map(
                e -> {
                    List<String> participants = processParticipants(e.select("span.Details__ParticipantName"), log);
                    List<BigDecimal> odds = processOdds(e.select("span.OddsButton__Odds"), log);

                    return processThreeWayBetOffer(participants, odds, null, log).orElse(null);
                }
        ).filter(Objects::nonNull)
         .collect(Collectors.toList());
    }

    @Override
    public Duration initialDelay() {
        return Duration.of(1, ChronoUnit.SECONDS);
    }

    @Override
    public Duration preHtmlExtractionDelay() {
        return Duration.of(100, ChronoUnit.MILLIS);
    }

    @Override
    public BettingSourceType getBettingSourceType() {
        return IZIBET;
    }
}
