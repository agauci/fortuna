package fortuna.models.notification;

import lombok.Builder;
import lombok.Data;

public interface PushNotificationAwareNotification extends NotificationMessage {

    PushNotification toPushNotification();

    @Data
    @Builder
    class PushNotification {
        String title;
        String message;
    }

}
