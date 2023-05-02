package fortuna.message.engine;

import fortuna.models.competition.EventCompetition;
import fortuna.models.notification.FileAwareNotification;
import lombok.Builder;
import lombok.Data;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Set;

@Builder
@Data
public class WorkerInfoUpdated implements FileAwareNotification {

    private static final String WORKER_FILE = "C:\\dev\\trees\\fortuna\\workers.txt";

    EventCompetition eventCompetition;
    Set<String>      eventIdentifiers;

    @Override
    public FileNotification toFileNotification() {
        return FileNotification.builder()
                .fileName(WORKER_FILE)
                .lineContent(eventCompetition + " - " + eventIdentifiers)
                .clearFileAfterLastWrite(Duration.of(5, ChronoUnit.MINUTES))
                .build();
    }
}
