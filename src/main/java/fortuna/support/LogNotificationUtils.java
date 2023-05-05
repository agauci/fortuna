package fortuna.support;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import fortuna.models.notification.LogAwareNotification;
import fortuna.models.notification.LogAwareNotification.LogNotification;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Slf4j
public class LogNotificationUtils {

    private static final String API_KEY = "eu01xxb71c533c016b4a217008e66439b53bNRAL";

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper().registerModule(new JavaTimeModule()).configure(JsonGenerator.Feature.WRITE_BIGDECIMAL_AS_PLAIN, true);

    public static void triggerLogNotification(LogNotification logNotification) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Api-Key", API_KEY);
        try {
            ResponseEntity<String> response = restTemplate.postForEntity("https://log-api.eu.newrelic.com/log/v1", new HttpEntity<>(OBJECT_MAPPER.writeValueAsString(logNotification), headers), String.class);

            if (response.getStatusCode() == HttpStatus.ACCEPTED) {
                log.debug("Log notification for {} completed successfully.", logNotification);
            } else {
                log.warn("Failed to log notification {}! Response: {}", logNotification, response);
            }
        } catch (JsonProcessingException e) {
            log.warn("Unable to convert log {} to Json. Aborting log notification trigger", logNotification, e);
            return;
        }
    }

}
