package fortuna.bettingsource;

import fortuna.UnitTest;
import fortuna.bettingsource.BetOfferSource.BetOfferSourceStep;
import fortuna.models.competition.EventCompetition;
import fortuna.models.offer.BetOffer;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

@Slf4j
public abstract class BettingOfferSourceTest<T extends BetOffer<T>> extends UnitTest {

    protected void run(final String description) {
        run(bettingSource().resolveBetOfferSourceByDescription(description));
    }

    protected void run(final EventCompetition eventCompetition) {
        run(bettingSource().resolveBetOfferSourceByCompetition(eventCompetition));
    }

    private void run(final BetOfferSource<T> betOfferSource) {
        try {
            WebDriver webDriver = getWebDriver();
            betOfferSource.onInit();

            webDriver.get(betOfferSource.getUrl());

            LinkedList<BetOfferSourceStep<T>> steps = new LinkedList<>(betOfferSource.steps());

            while (!steps.isEmpty()) {
                BetOfferSourceStep<T> step = steps.poll();
                Thread.sleep(step.getPreDelay().toMillis());

                if (step.getExtractor() != null) {
                    String html = webDriver.getPageSource();

                    if (!step.stopOnRedirect || webDriver.getCurrentUrl().equals(betOfferSource.getUrl())) {
                        log.info("Extracted the following offers: ");
                        for (final T offer : step.getExtractor().apply(html)) {
                            log.info("{}", offer);
                        }
                    } else {
                        log.info("Page redirect to {} detected.", webDriver.getCurrentUrl());
                    }

                    webDriver.quit();
                } else {
                    step.getIntermediateStep().accept(webDriver);

                    if (step.getRepeatStepCondition() != null && step.getRepeatStepCondition().apply(webDriver)) {
                        steps.addFirst(step);
                    }
                }
            }

            try {
                Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe");
                log.info("Successfully killed off any pending chromedriver executions");
            } catch (IOException e) {
                log.error("Unable to kill off any pending chromedriver executions!");
            }

            // Some additional time is added at the end to give enough time for a clean termination
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    protected abstract BettingSource bettingSource();

    private WebDriver getWebDriver() {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("chromedriver.exe").getFile());
        String absolutePath = file.getAbsolutePath();

        System.setProperty("webdriver.chrome.driver", absolutePath);
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        return driver;
    }

}
