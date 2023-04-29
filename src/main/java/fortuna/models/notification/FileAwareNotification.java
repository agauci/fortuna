package fortuna.models.notification;

import lombok.Builder;
import lombok.Data;

public interface FileAwareNotification extends NotificationMessage {

    FileNotification toFileNotification();

    @Data
    @Builder
    class FileNotification {
        String fileName;
        String lineContent;
    }

}
