package fortuna.message.engine;

import fortuna.models.offer.BetOffer;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class BetOfferIdentified implements BetEventMessage {
    BetOffer offer;

    @Override
    public String getEventIdentifier() {
        return offer.getEventIdentifier();
    }
}
