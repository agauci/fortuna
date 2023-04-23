package fortuna.message.internal.shutdown;

import akka.actor.typed.ActorRef;
import fortuna.message.extractor.ExtractorMessage;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class SystemShutdown implements ExtractorMessage {
    ActorRef<SystemShutdownAck> senderRef;
}
