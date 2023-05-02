package fortuna.notification;

import akka.actor.typed.Behavior;
import akka.actor.typed.javadsl.AbstractBehavior;
import akka.actor.typed.javadsl.ActorContext;
import akka.actor.typed.javadsl.Behaviors;
import akka.actor.typed.javadsl.Receive;
import fortuna.models.notification.FileAwareNotification;
import fortuna.models.notification.FileAwareNotification.FileNotification;
import fortuna.models.notification.LogAwareNotification;
import fortuna.models.notification.LogAwareNotification.LogNotification;
import fortuna.models.notification.NotificationMessage;
import fortuna.models.notification.PushNotificationAwareNotification;
import fortuna.models.notification.PushNotificationAwareNotification.PushNotification;
import fortuna.support.FileUtils;
import fortuna.support.LogNotificationUtils;
import fortuna.support.PushNotificationUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static fortuna.support.BehaviorUtils.wrap;

public class NotificationManager extends AbstractBehavior<NotificationMessage> {

    private static final SimpleDateFormat   TIMESTAMP_FORMAT = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
    private static final Long               PUSH_COOLDOWN_DURATION_MS = 300000L;

    private long                            lastPushTimestamp = 0;
    private Map<String, Long>               lastFileWrite = new HashMap<>();

    public NotificationManager(ActorContext<NotificationMessage> context) {
        super(context);
    }

    @Override
    public Receive<NotificationMessage> createReceive() {
        return newReceiveBuilder()
                .onMessage(NotificationMessage.class, this::onNotificationMessage)
                .build();
    }

    private Behavior<NotificationMessage> onNotificationMessage(NotificationMessage message) {
        return wrap(() -> {
            if (message instanceof FileAwareNotification) {
                handleFileNotification(((FileAwareNotification) message).toFileNotification());
            }
            if (message instanceof PushNotificationAwareNotification) {
                handlePushNotification(((PushNotificationAwareNotification) message).toPushNotification());
            }
            if (message instanceof LogAwareNotification) {
                handleLogNotification(((LogAwareNotification) message).toLogNotification());
            }

            return Behaviors.same();
        }, getContext(), message);
    }

    private void handleFileNotification(FileNotification notification) {
        boolean truncateFile = false;
        Long lastFileTimestamp = lastFileWrite.get(notification.getFileName());
        if (lastFileTimestamp != null && notification.getClearFileAfterLastWrite() != null && notification.getClearFileAfterLastWrite().toMillis() > (System.currentTimeMillis() - lastFileTimestamp)) {
            truncateFile = true;
        }

        FileUtils.appendToFile(notification.getFileName(), "[" + TIMESTAMP_FORMAT.format(new Date()) + "] " + notification.getLineContent() + System.lineSeparator(), truncateFile);

        lastFileWrite.put(notification.getFileName(), System.currentTimeMillis());
    }

    private void handlePushNotification(PushNotification notification) {
        if ((System.currentTimeMillis() - lastPushTimestamp) < PUSH_COOLDOWN_DURATION_MS) {
            getContext().getLog().debug("Skipping push notification with title={} and message={} due to cooldown period.", notification.getTitle(), notification.getMessage());
            return;
        }

        PushNotificationUtils.triggerPushNotification(notification);
    }

    private void handleLogNotification(LogNotification notification) {
        LogNotificationUtils.triggerLogNotification(notification);
    }
}
