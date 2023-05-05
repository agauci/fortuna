package fortuna.bettingsource;

import fortuna.models.competition.EventCompetition;
import fortuna.models.offer.BetOffer;
import fortuna.models.offer.ThreeWayBetOffer;
import fortuna.models.source.BettingExchange;
import fortuna.models.source.BettingSourceType;
import fortuna.support.EventIdentifierUtils;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.SuperBuilder;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
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

    public abstract List<BetOfferSourceStep<T>> steps();

    public Duration retryDelay() {
        return Duration.of(1, ChronoUnit.SECONDS);
    }

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

    protected List<BigDecimal> processFractionalOdds(Elements elements, String delimiter, Logger logger) {
        try {
            return elements.stream().map(Element::text).limit(3).map(str -> {
                List<String> values = Arrays.stream(str.split(delimiter)).map(String::trim).collect(Collectors.toList());

                return new BigDecimal(values.get(0)).divide(new BigDecimal(values.get(1)), 2, RoundingMode.DOWN).add(BigDecimal.ONE);
            }).collect(Collectors.toList());
        } catch (Exception e) {
            logger.debug("Failed to parse odds while processing bet offer source {}. Skipping extraction.", getUniqueIdentifier());
            return Collections.emptyList();
        }
    }

    protected List<BigDecimal> processOdds(Elements elements, Logger logger) {
        return processOdds(elements, 0, logger);
    }

    protected List<BigDecimal> processOdds(Elements elements, Integer skip, Logger logger) {
        try {
            return elements.stream().map(Element::text).skip(skip).limit(3).map(str -> new BigDecimal(str).setScale(2, RoundingMode.DOWN)).collect(Collectors.toList());
        } catch (Exception e) {
            logger.debug("Failed to parse odds while processing bet offer source {}. Skipping extraction.", getUniqueIdentifier());
            return Collections.emptyList();
        }
    }

    protected List<BigDecimal> processExchangeOdds(Elements elements, Logger logger) {
        try {
            List<BigDecimal> odds = elements.stream().map(Element::text).map(str -> new BigDecimal(str).setScale(2, RoundingMode.DOWN)).collect(Collectors.toList());

            List<BigDecimal> finalOdds = new ArrayList<>();
            for (int i = 0; i < odds.size(); i++) {
                if (i % 2 == 0) {
                    finalOdds.add(odds.get(i));
                }
            }

            return finalOdds;
        } catch (Exception e) {
            logger.debug("Failed to parse odds while processing bet offer source {}. Skipping extraction.", getUniqueIdentifier());
            return Collections.emptyList();
        }
    }

    protected List<String> processParticipants(Elements elements, Logger logger) {
        return processParticipants(elements, "", 2, logger);
    }

    protected List<String> processParticipants(Elements elements, String stripRegex, Integer limit, Logger logger) {
        try {
            return elements.stream().map(p -> StringUtils.stripAccents(p.text()).replaceAll(stripRegex, "").trim()).limit(limit).collect(Collectors.toList());
        } catch (Exception e) {
            logger.debug("Failed to parse participants while processing bet offer source {}. Skipping extraction.", getUniqueIdentifier());
            return Collections.emptyList();
        }
    }

    protected List<String> processParticipants(Element element, String delimiter, Logger logger) {
        try {
            return Arrays.stream(element.text().split(delimiter)).map(str -> StringUtils.stripAccents(str.trim())).collect(Collectors.toList());
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

        boolean addOriginalOdds = false;
        List<BigDecimal> finalOdds;
        if (getBettingSourceType() instanceof BettingExchange) {
            addOriginalOdds = true;
            finalOdds = odds.stream()
                    .map(val -> ((BettingExchange) getBettingSourceType()).calculateTrueOdds(val))
                    .collect(Collectors.toList());
        } else {
            finalOdds = odds;
        }

        return Optional.of(buildThreeWayBetOffer(participants, eventIdentifier, resolvedEventCompetition, finalOdds, (addOriginalOdds) ? odds : null));
    }

    private ThreeWayBetOffer buildThreeWayBetOffer(List<String> participants, String eventIdentifier, EventCompetition eventCompetition, List<BigDecimal> odds, List<BigDecimal> originalOdds) {
        return ThreeWayBetOffer.builder()
                .participants(participants)
                .eventIdentifier(eventIdentifier)
                .bettingSourceType(getBettingSourceType())
                .eventCompetition(eventCompetition)
                .extractedTimestamp(System.currentTimeMillis())
                .one(odds.get(0))
                .draw(odds.get(1))
                .two(odds.get(2))
                .originalOdds(originalOdds)
                .build();
    }

    @Data
    @Builder
    public static class BetOfferSourceStep<T extends BetOffer<T>> {
        String                          description;
        Duration                        preDelay;
        Consumer<WebDriver>             intermediateStep;
        Function<WebDriver, Boolean>    repeatStepCondition;
        Function<String, List<T>>       extractor;
        boolean                         stopOnRedirect = true;
    }

}
