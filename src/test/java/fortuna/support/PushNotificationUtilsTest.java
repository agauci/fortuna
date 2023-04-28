package fortuna.support;

import org.junit.Ignore;
import org.junit.Test;

public class PushNotificationUtilsTest {

    @Test
    @Ignore
    public void test_push_notification() {
        PushNotificationUtils.maybeTriggerPush("Unit test push", "This push notification was triggered by a unit test!");
    }

}
