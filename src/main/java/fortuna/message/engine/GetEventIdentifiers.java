package fortuna.message.engine;

import akka.actor.typed.ActorRef;
import fortuna.message.FortunaMessage;
import fortuna.models.competition.EventCompetition;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class GetEventIdentifiers implements FortunaMessage {

    ActorRef<EventIdentifiersRetrieved> senderRef;
}
