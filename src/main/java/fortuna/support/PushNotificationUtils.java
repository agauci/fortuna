package fortuna.support;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Slf4j
public class PushNotificationUtils {

    private static final String TOKEN = "a2qv3d7oobgkp84c4dzqg4kg8nbcmr";
    private static final String USER_KEY = "uxtgy8q522yaewikhwcwerqgsqnynz";

    private static final Long PUSH_COOLDOWN_DURATION_MS = 300000L;

    private static long lastPushTimestamp = 0;

    public static void maybeTriggerPush(String title, String message) {
        if ((System.currentTimeMillis() - lastPushTimestamp) < PUSH_COOLDOWN_DURATION_MS) {
            log.debug("Skipping push notification with title={} and message={} due to cooldown period.", title, message);
            return;
        }

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> map= new LinkedMultiValueMap<>();
        map.add("token", TOKEN);
        map.add("user", USER_KEY);
        map.add("title", title);
        map.add("message", message);
        ResponseEntity<String> response = restTemplate.postForEntity("https://api.pushover.net/1/messages.json", new HttpEntity<>(map, headers), String.class);
        lastPushTimestamp = System.currentTimeMillis();

        if (response.getStatusCode() == HttpStatus.OK) {
            log.debug("Push notification with title={} and message={} completed successfully.", title, message);
        } else {
            log.warn("Failed to push notification with title={} and message={}!", title, message);
        }
    }

}
