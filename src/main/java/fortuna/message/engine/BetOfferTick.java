package fortuna.message.engine;

import fortuna.models.competition.EventCompetition;
import fortuna.models.source.BettingSourceType;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class BetOfferTick implements BetEventMessage {
    BettingSourceType   source;
    String              eventIdentifier;
    List<String>        participants;
    EventCompetition    eventCompetition;
}
