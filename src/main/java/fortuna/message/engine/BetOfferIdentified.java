package fortuna.message.engine;

import fortuna.models.competition.EventCompetition;
import fortuna.models.offer.BetOffer;
import fortuna.models.source.BettingSourceType;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class BetOfferIdentified implements BetEventMessage {
    BetOffer offer;

    @Override
    public String getEventIdentifier() {
        return offer.getEventIdentifier();
    }

    @Override
    public BettingSourceType getBettingSourceType() {
        return offer.getBettingSourceType();
    }

    @Override
    public List<String> getParticipants() {
        return offer.getParticipants();
    }

    @Override
    public EventCompetition getEventCompetition() {
        return offer.getEventCompetition();
    }
}
