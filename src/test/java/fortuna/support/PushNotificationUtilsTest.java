package fortuna.support;

import fortuna.models.notification.PushNotificationAwareNotification.PushNotification;
import org.junit.Ignore;
import org.junit.Test;

public class PushNotificationUtilsTest {

    @Test
    @Ignore
    public void test_push_notification() {
        PushNotificationUtils.triggerPushNotification(PushNotification.builder().title("Unit test push").message("This push notification was triggered by a unit test!").build());
    }

}
