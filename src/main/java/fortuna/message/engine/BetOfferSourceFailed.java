package fortuna.message.engine;

import fortuna.bettingsource.BetOfferSource;
import fortuna.extractor.BetOfferExtractor;
import fortuna.models.competition.EventCompetition;
import fortuna.models.notification.LogAwareNotification;
import fortuna.models.offer.BetOffer;
import fortuna.models.source.BettingSourceType;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class BetOfferSourceFailed implements BetEventMessage, LogAwareNotification {
    BetOfferSource<?> offerSource;

    @Override
    public String getEventIdentifier() {
        return null;
    }

    @Override
    public BettingSourceType getBettingSourceType() {
        return offerSource.getBettingSourceType();
    }

    @Override
    public List<String> getParticipants() {
        return null;
    }

    @Override
    public EventCompetition getEventCompetition() {
        return offerSource.getEventCompetition().orElse(null);
    }

    @Override
    public LogNotification toLogNotification() {
        return LogNotification.builder()
                .timestamp(System.currentTimeMillis())
                .message(offerSource.toSummary())
                .source(BetOfferExtractor.class.getSimpleName())
                .logType("BET_OFFER_SOURCE_SUSPECTED_FAILURE")
                .logLevel(LogLevel.HIGH)
                .build();
    }
}
