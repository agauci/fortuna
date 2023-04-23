package fortuna.bettingsource;

import fortuna.models.competition.EventCompetition;
import fortuna.models.offer.BetOffer;
import fortuna.models.offer.ThreeWayBetOffer;
import fortuna.models.source.BettingSourceType;
import fortuna.support.EventIdentifierUtils;
import lombok.Data;
import lombok.experimental.SuperBuilder;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Data
@SuperBuilder
public abstract class BetOfferSource<T extends BetOffer<T>> {

    String              url;
    String              description;
    EventCompetition    eventCompetition;
    Long                lastExtractedTimestamp;
    List<T>             lastExtractedOffers;

    List<String>        encounteredIdentifiersDuringRun;

    public abstract void preExtract(WebDriver driver);

    public abstract List<T> extractOffers(String html);

    public abstract Duration initialDelay();

    public abstract Duration preHtmlExtractionDelay();

    public abstract BettingSourceType getBettingSourceType();

    public Optional<EventCompetition> getEventCompetition() {
        return Optional.ofNullable(eventCompetition);
    }

    public BetOfferSource<T> onInit() {
        this.lastExtractedOffers = Collections.emptyList();
        this.lastExtractedTimestamp = 0L;
        this.encounteredIdentifiersDuringRun = new ArrayList<>();

        return this;
    }

    public BetOfferSource<T> onOffersExtracted(final List<T> lastExtractedOffers) {
        this.lastExtractedTimestamp = System.currentTimeMillis();
        this.lastExtractedOffers = lastExtractedOffers;
        this.encounteredIdentifiersDuringRun.clear();

        return this;
    }

    public String getUniqueIdentifier() {
        return getBettingSourceType() + "_" + getEventCompetition().map(EventCompetition::toString).orElse(description);
    }

    protected List<BigDecimal> processOdds(Elements elements, Logger logger) {
        try {
            return elements.stream().map(Element::text).limit(3).map(BigDecimal::new).collect(Collectors.toList());
        } catch (Exception e) {
            logger.debug("Failed to parse odds while processing bet offer source {}. Skipping extraction.", getUniqueIdentifier());
            return Collections.emptyList();
        }
    }

    protected List<String> processParticipants(Elements elements, Logger logger) {
        try {
            return elements.stream().map(p -> StringUtils.stripAccents(p.text())).collect(Collectors.toList());
        } catch (Exception e) {
            logger.debug("Failed to parse participants while processing bet offer source {}. Skipping extraction.", getUniqueIdentifier());
            return Collections.emptyList();
        }
    }

    protected Optional<ThreeWayBetOffer> processThreeWayBetOffer(List<String> participants, List<BigDecimal> odds, EventCompetition competition, Logger logger) {
        if (participants.size() != 2) {
            logger.debug("Skipping entry for participants {} due to missing/insufficient odds found. [Bet offer source: {}]", participants, getUniqueIdentifier());
            return Optional.empty();
        }
        if (odds.size() != 3) {
            logger.debug("Skipping entry for participants {} due to missing/insufficient odds found. [Bet offer source: {}]", participants, getUniqueIdentifier());
            return Optional.empty();
        }

        EventCompetition resolvedEventCompetition = getEventCompetition().orElse(competition);
        String eventIdentifier = EventIdentifierUtils.buildIdentifier(participants, resolvedEventCompetition);
        if (encounteredIdentifiersDuringRun.contains(eventIdentifier)) {
            logger.debug("Duplicate entry for event {} identified while processing {}. Skipping latter extraction.", eventIdentifier, getUniqueIdentifier());
            return Optional.empty();
        }
        encounteredIdentifiersDuringRun.add(eventIdentifier);

        return Optional.of(buildThreeWayBetOffer(participants, eventIdentifier, resolvedEventCompetition, odds));
    }

    private ThreeWayBetOffer buildThreeWayBetOffer(List<String> participants, String eventIdentifier, EventCompetition eventCompetition, List<BigDecimal> odds) {
        return ThreeWayBetOffer.builder()
                .participants(participants)
                .eventIdentifier(eventIdentifier)
                .bettingSourceType(getBettingSourceType())
                .eventCompetition(eventCompetition)
                .extractedTimestamp(System.currentTimeMillis())
                .one(odds.get(0))
                .draw(odds.get(1))
                .two(odds.get(2))
                .build();
    }

}
