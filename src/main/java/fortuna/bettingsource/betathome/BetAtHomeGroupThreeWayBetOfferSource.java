package fortuna.bettingsource.betathome;

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
import org.jsoup.nodes.Element;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

import static fortuna.models.source.Bookmaker.BET_AT_HOME;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@SuperBuilder
@Slf4j
public class BetAtHomeGroupThreeWayBetOfferSource extends BetOfferSource<ThreeWayBetOffer> {

    public Map<String, EventCompetition> competitions;

    @Override
    public List<BetOfferSourceStep<ThreeWayBetOffer>> steps() {
        return Collections.singletonList(
                BetOfferSourceStep.<ThreeWayBetOffer>builder()
                        .preDelay(Duration.of(1, ChronoUnit.SECONDS))
                        .extractor(this::extractOffers)
                        .build()
        );
    }

    public List<ThreeWayBetOffer> extractOffers(String html) {
        Document doc = Jsoup.parse(html);

        List<ThreeWayBetOffer> offers = new ArrayList<>();
        for (Element groupElement : doc.select("div.MixedGroupedMatchListItem")) {
            Element groupTitleElement = groupElement.selectFirst("span.MatchListGroup__Tournament");
            if (groupTitleElement != null && competitions.containsKey(groupTitleElement.text())) {
                offers.addAll(
                        groupElement.select("div.EventItem").stream().map(
                                        e -> {
                                            List<String> participants = processParticipants(e.select("span.Details__ParticipantName"), log);

                                            // If a lock is present, skip
                                            if (e.selectFirst("span.OM-Icon.OM-Icon--Svg.OM-Icon--general.OM-Icon--lock") != null) {
                                                log.debug("Lock identified for {} - {}! Skipping entry.", BET_AT_HOME, participants);
                                                return null;
                                            }
                                            List<BigDecimal> odds = processOdds(e.select("span.OddsButton__Odds"), log);

                                            return processThreeWayBetOffer(participants, odds, competitions.get(groupTitleElement.text()), log).orElse(null);
                                        }
                                ).filter(Objects::nonNull)
                                .toList()
                );
            }

        }

        return offers;
    }

    @Override
    public BettingSourceType getBettingSourceType() {
        return BET_AT_HOME;
    }
}
