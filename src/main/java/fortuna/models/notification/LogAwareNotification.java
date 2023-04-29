package fortuna.models.notification;

import lombok.Builder;
import lombok.Data;

public interface LogAwareNotification extends NotificationMessage {

    LogNotification toLogNotification();

    @Data
    @Builder
    class LogNotification {
        Long timestamp;
        Object message;
        String source;
        String logType;
        LogLevel logLevel;
    }

    enum LogLevel {
        LOW,
        MEDIUM,
        HIGH
    }

}
