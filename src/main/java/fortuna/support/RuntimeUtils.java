package fortuna.support;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@UtilityClass
@Slf4j
public class RuntimeUtils {

    public static void cleanupChromeDriver() {
        try {
            Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe");
            log.info("Successfully killed off any pending chromedriver executions");
        } catch (IOException e) {
            log.error("Unable to kill off any pending chromedriver executions!");
        }
    }
}
