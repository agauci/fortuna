package fortuna.message.engine;

import fortuna.models.competition.EventCompetition;
import fortuna.models.offer.BetOffer;
import fortuna.models.source.BettingSourceType;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class BetOfferUpdated implements BetEventMessage {
    BetOffer offer;

    @Override
    public List<String> getParticipants() {
        return offer.getParticipants();
    }

    @Override
    public EventCompetition getEventCompetition() {
        return offer.getEventCompetition();
    }

    @Override
    public String getEventIdentifier() {
        return offer.getEventIdentifier();
    }

    @Override
    public BettingSourceType getBettingSourceType() {
        return offer.getBettingSourceType();
    }
}
