package fortuna.message.engine;

import fortuna.message.FortunaMessage;
import fortuna.models.competition.EventCompetition;

import java.util.List;

public interface BetEventMessage extends FortunaMessage {

    List<String> getParticipants();
    EventCompetition getEventCompetition();
    String getEventIdentifier();
}
