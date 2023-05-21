package fortuna.message.engine;

import akka.actor.typed.ActorRef;
import fortuna.models.competition.EventCompetition;
import fortuna.models.source.BettingSourceType;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class GetBetOffers implements BetEventMessage {
    String eventIdentifier;
    List<String> participants;
    EventCompetition eventCompetition;

    ActorRef<BetOffersRetrieved> senderRef;

    @Override
    public BettingSourceType getBettingSourceType() {
        return null;
    }
}
