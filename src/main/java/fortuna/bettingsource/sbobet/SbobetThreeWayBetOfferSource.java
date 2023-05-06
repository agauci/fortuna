package fortuna.bettingsource.sbobet;

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
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static fortuna.models.source.Bookmaker.SBOBET;
import static fortuna.models.source.Bookmaker.STAKE;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@SuperBuilder
@Slf4j
public class SbobetThreeWayBetOfferSource extends BetOfferSource<ThreeWayBetOffer> {

    private List<String> pages;
    private Queue<Element> tabs;

    @Override
    public List<BetOfferSourceStep<ThreeWayBetOffer>> steps() {
        return List.of(
                BetOfferSourceStep.<ThreeWayBetOffer>builder()
                        .preDelay(Duration.of(1, ChronoUnit.SECONDS))
                        .intermediateStep(this::extractPage)
                        .repeatStepCondition(wd -> !tabs.isEmpty())
                        .build(),
                BetOfferSourceStep.<ThreeWayBetOffer>builder()
                        .preDelay(Duration.of(1, ChronoUnit.SECONDS))
                        .extractor(this::extractOffers)
                        .stopOnRedirect(false)
                        .build()
        );
    }

    public void extractPage(WebDriver webDriver) {

        String pageSource = webDriver.getPageSource();

        if (tabs == null) {
            pages = new ArrayList<>();
            tabs = new LinkedList<>();

            Document doc = Jsoup.parse(pageSource);

            if (doc.select("span.TrailSymbol").size() != 3) {
                return;
            }

            Element tableElement = doc.selectFirst("table.TimeTab");

            if (tableElement != null) {
                tableElement.select("tr > td").forEach(
                        e -> {
                            if (!e.hasClass("Sel")) {
                                String tabText = e.selectFirst("a").text();

                                if (!StringUtils.isEmpty(tabText) && Integer.parseInt(tabText.substring(tabText.indexOf("(") + 1, tabText.indexOf(")")).trim()) > 0) {
                                    tabs.add(e);
                                }
                            }
                        }
                );
            }
        }

        if (!tabs.isEmpty()) {
            pages.add(pageSource);
            Element tabElement = tabs.poll();

            webDriver.findElement(By.id(tabElement.selectFirst("a").id())).click();
        }
    }

    public List<ThreeWayBetOffer> extractOffers(String html) {
        pages.add(html);

        List<ThreeWayBetOffer> offers = pages.stream().flatMap(page -> {
            Document doc = Jsoup.parse(page);

            if (doc.select("span.TrailSymbol").size() != 3) {
                log.debug("Redirect detected! Skipping run.");
                return Stream.empty();
            }

            Element marketDiv = doc.selectFirst("div.NonLiveMarket");
            if (marketDiv == null) {
                return Collections.<ThreeWayBetOffer>emptyList().stream();
            }

            return marketDiv.selectFirst("div.MarketBd").select("tr").stream().map(
                    e -> {
                        List<String> participants = processParticipants(e.select("span.OddsL"), "", 3, log).stream()
                                .filter(str -> !str.toLowerCase().trim().equals("draw"))
                                .collect(Collectors.toList());

                        Element element = e.selectFirst("div.DateTimeDiv");
                        if (element != null && element.toString().contains("\"red\"")) {
                            log.debug("Match {} for source {} is ongoing.", participants, getBettingSourceType());
                            return processThreeWayBetOffer(participants, null, null, true, log).orElse(null);
                        }

                        List<BigDecimal> odds = processOdds(e.select("span.OddsR"), log);

                        return processThreeWayBetOffer(participants, odds, null, false, log).orElse(null);
                    }
            ).filter(Objects::nonNull);
        }).toList();

        pages = null;
        tabs = null;

        return offers;
    }

    @Override
    public BettingSourceType getBettingSourceType() {
        return SBOBET;
    }
}
