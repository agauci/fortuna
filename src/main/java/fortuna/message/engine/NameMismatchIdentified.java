package fortuna.message.engine;

import fortuna.engine.ArbitrageEngineSupervisor;
import fortuna.models.notification.LogAwareNotification;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class NameMismatchIdentified implements LogAwareNotification {

    List<String> participants1;
    String eventIdentifier1;
    List<String> participants2;
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
