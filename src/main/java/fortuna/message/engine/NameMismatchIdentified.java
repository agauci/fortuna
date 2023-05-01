package fortuna.message.engine;

import akka.japi.Pair;
import fortuna.engine.ArbitrageEngineSupervisor;
import fortuna.models.notification.LogAwareNotification;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class NameMismatchIdentified implements LogAwareNotification {

    Pair<String, String> participants1;
    String eventIdentifier1;
    Pair<String, String> participants2;
    String eventIdentifier2;

    @Override
    public LogNotification toLogNotification() {
        return LogNotification.builder()
                .timestamp(System.currentTimeMillis())
                .message(this)
                .source(ArbitrageEngineSupervisor.class.getSimpleName())
                .logType("NAME_MISTMATCH_IDENTIFIED")
                .logLevel(LogLevel.HIGH)
                .build();
    }
}
