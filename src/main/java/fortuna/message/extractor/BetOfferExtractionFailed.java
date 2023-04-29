package fortuna.message.extractor;

import fortuna.extractor.BetOfferExtractor;
import fortuna.models.notification.LogAwareNotification;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BetOfferExtractionFailed implements LogAwareNotification {

    String sourceUniqueIdentifier;
    String failReason;

    @Override
    public LogNotification toLogNotification() {
        return LogNotification.builder()
                .timestamp(System.currentTimeMillis())
                .message(this)
                .source(BetOfferExtractor.class.getSimpleName())
                .logType("BET_OFFER_EXTRACTION_FAILED")
                .logLevel(LogLevel.MEDIUM)
                .build();
    }
}
