package fortuna.message.engine;

import akka.Done;
import akka.actor.typed.ActorRef;
import fortuna.models.competition.EventCompetition;
import fortuna.models.source.BettingSourceType;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class RemoveBettingSourceOffers implements BetEventMessage {
    EventCompetition    eventCompetition;
    BettingSourceType   bettingSourceType;

    ActorRef<Done>      senderRef;

    @Override
    public List<String> getParticipants() {
        return null;
    }

    @Override
    public String getEventIdentifier() {
        return null;
    }
}
