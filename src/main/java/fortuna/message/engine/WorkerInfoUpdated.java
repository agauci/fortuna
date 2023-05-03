package fortuna.message.engine;

import fortuna.models.competition.EventCompetition;
import fortuna.models.notification.FileAwareNotification;
import fortuna.models.notification.LogAwareNotification;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class WorkerInfoUpdated implements LogAwareNotification {

    private static final String WORKER_FILE = "C:\\dev\\trees\\fortuna\\workers.txt";

    EventCompetition eventCompetition;
    List<String>     eventIdentifiers;

//    @Override
//    public FileNotification toFileNotification() {
//        return FileNotification.builder()
//                .fileName(WORKER_FILE)
//                .lineContent(eventCompetition + " - " + eventIdentifiers)
//                .clearFileAfterLastWrite(Duration.of(5, ChronoUnit.MINUTES))
//                .build();
//    }

    @Override
    public LogNotification toLogNotification() {
        return LogNotification.builder()
                .timestamp(System.currentTimeMillis())
                .message(this)
                .logType("WORKER_INFO_UPDATED")
                .logLevel(LogLevel.LOW)
                .build();
    }
}
