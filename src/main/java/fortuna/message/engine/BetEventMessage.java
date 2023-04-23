package fortuna.message.engine;

import fortuna.message.FortunaMessage;

public interface BetEventMessage extends FortunaMessage {

    String getEventIdentifier();
}
