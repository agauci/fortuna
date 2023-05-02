package fortuna.models.notification;

import lombok.Builder;
import lombok.Data;

import java.time.Duration;

public interface FileAwareNotification extends NotificationMessage {

    FileNotification toFileNotification();

    @Data
    @Builder
    class FileNotification {
        String fileName;
        String lineContent;
        Duration clearFileAfterLastWrite;
    }

}
