package fortuna.message.engine;

import fortuna.models.source.BettingSourceType;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class BetOfferTick implements BetEventMessage {
    BettingSourceType   source;
    String              eventIdentifier;

    @Override
    public String getEventIdentifier() {
        return eventIdentifier;
    }
}
