package fortuna.support;

import fortuna.models.notification.PushNotificationAwareNotification.PushNotification;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Slf4j
public class PushNotificationUtils {

    private static final String TOKEN = "a2qv3d7oobgkp84c4dzqg4kg8nbcmr";
    private static final String USER_KEY = "uxtgy8q522yaewikhwcwerqgsqnynz";

    public static void triggerPushNotification(PushNotification pushNotification) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> map= new LinkedMultiValueMap<>();
        map.add("token", TOKEN);
        map.add("user", USER_KEY);
        map.add("title", pushNotification.getTitle());
        map.add("message", pushNotification.getMessage());
        ResponseEntity<String> response = restTemplate.postForEntity("https://api.pushover.net/1/messages.json", new HttpEntity<>(map, headers), String.class);

        if (response.getStatusCode() == HttpStatus.OK) {
            log.debug("Push notification with title={} and message={} completed successfully.", pushNotification.getTitle(), pushNotification.getMessage());
        } else {
            log.warn("Failed to push notification {}!", pushNotification);
        }
    }

}
