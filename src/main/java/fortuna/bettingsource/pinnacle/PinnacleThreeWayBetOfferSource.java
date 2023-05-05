package fortuna.bettingsource.pinnacle;

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
import org.jsoup.select.Elements;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static fortuna.models.source.Bookmaker.BET_AT_HOME;
import static fortuna.models.source.Bookmaker.PINNACLE;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@SuperBuilder
@Slf4j
public class PinnacleThreeWayBetOfferSource extends BetOfferSource<ThreeWayBetOffer> {

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

        return doc.select("div.style_row__3q4g_").stream().map(
                e -> {
                    Elements participantsElement = e.select("span.ellipsis.event-row-participant");
                    if (participantsElement.size() < 2) {
                        return null;
                    }
                    List<String> participants = processParticipants(participantsElement, "\\([\\w\\s]+\\)", 2, log);

                    if (e.selectFirst("span.style_live__2pH4R") != null) {
                        log.debug("Match {} for source {} is ongoing.", participants, getBettingSourceType());
                        return null;
                    }

                    List<BigDecimal> odds = processOdds(e.select("span.style_price__15SlF"), log);

                    return processThreeWayBetOffer(participants, odds, null, log).orElse(null);
                }
        ).filter(Objects::nonNull)
         .collect(Collectors.toList());
    }

    @Override
    public BettingSourceType getBettingSourceType() {
        return PINNACLE;
    }
}
