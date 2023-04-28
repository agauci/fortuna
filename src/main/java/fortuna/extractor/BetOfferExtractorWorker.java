package fortuna.extractor;

import akka.actor.typed.ActorRef;
import akka.actor.typed.Behavior;
import akka.actor.typed.javadsl.*;
import fortuna.bettingsource.BetOfferSource;
import fortuna.message.extractor.BetOfferSourceExtracted;
import fortuna.message.extractor.ExtractorMessage;
import fortuna.message.extractor.TriggerBetOfferSourceExtraction;
import fortuna.message.internal.shutdown.SystemShutdown;
import fortuna.models.offer.BetOffer;
import lombok.Builder;
import lombok.Data;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.core.io.ResourceLoader;

import java.io.IOException;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

import static fortuna.support.BehaviorUtils.wrap;

public class BetOfferExtractorWorker extends AbstractBehavior<ExtractorMessage> {

    private static final Duration               EXTRACTION_TIMEOUT = Duration.of(1, ChronoUnit.MINUTES);
    private static final Integer                RETRY_LIMIT = 3;
    private static final String                 CHROMEDRIVER_FILENAME = "chromedriver.exe";

    final ResourceLoader                        resourceLoader;
    final TimerScheduler<ExtractorMessage>      timer;

    WebDriver                                   webDriver;
    BetOfferSource<?>                           betOfferSource;
    ActorRef<ExtractorMessage>                  senderRef;
    String                                      extractedHtml;
    Integer                                     currentRetryCount = 0;

    BetOfferSource.BetOfferSourceStep<?>        currentStep;
    Queue<BetOfferSource.BetOfferSourceStep<?>> pendingSteps;

    public BetOfferExtractorWorker(ActorContext<ExtractorMessage> context,
                                   TimerScheduler<ExtractorMessage> timer,
                                   ResourceLoader resourceLoader,
                                   String betOfferSourceUniqueIdentifier) {
        super(context);
        getContext().getLog().debug("Starting BetOfferExtractorWorker, will extract bet offer source {}", betOfferSourceUniqueIdentifier);

        this.timer = timer;
        this.resourceLoader = resourceLoader;
    }

    @Override
    public Receive<ExtractorMessage> createReceive() {
        return newReceiveBuilder()
                .onMessage(TriggerBetOfferSourceExtraction.class, this::onTriggerBetOfferSourceExtraction)
                .onMessage(StepDelayComplete.class, this::onStepDelayComplete)
                .onMessage(ExtractionTimeout.class, this::onExtractionTimeout)
                .onMessage(SystemShutdown.class, this::onSystemShutdown)
                .build();
    }

    private Behavior<ExtractorMessage> onTriggerBetOfferSourceExtraction(TriggerBetOfferSourceExtraction message) {
        return wrap(() -> {
            betOfferSource = message.getBetOfferSource();
            pendingSteps = new LinkedList<>(betOfferSource.steps());

            senderRef = message.getSenderRef();
            webDriver = createWebDriver();

            webDriver.get(betOfferSource.getUrl());

            timer.startSingleTimer(ExtractionTimeout.builder().build(), EXTRACTION_TIMEOUT);

            return processNextStep();
        }, (e) -> cleanupAndSendFailureResponse(betOfferSource), getContext(), message);
    }

    private Behavior<ExtractorMessage> onStepDelayComplete(StepDelayComplete message) {
        return wrap(() -> {
            runCurrentStep();

            return processNextStep();
        }, (e) -> {
            if (e instanceof NoSuchElementException && currentRetryCount < RETRY_LIMIT) {
                getContext().getLog().debug("Failed to resolve source code. Retrying.");
                currentRetryCount += 1;

                timer.startSingleTimer(StepDelayComplete.builder().build(), betOfferSource.retryDelay());

                return Behaviors.same();
            } else {
                return cleanupAndSendFailureResponse(betOfferSource);
            }
        }, getContext(), message);
    }

    private void runCurrentStep() {
        if (currentStep.getExtractor() != null) {
            extractOffers(betOfferSource, currentStep);
        } else {
            currentStep.getIntermediateStep().accept(webDriver);
        }
    }

    private Behavior<ExtractorMessage> processNextStep() {
        if (pendingSteps.isEmpty()) {
            return Behaviors.stopped();
        } else {
            currentStep = pendingSteps.poll();
            timer.startSingleTimer(StepDelayComplete.builder().build(), currentStep.getPreDelay());

            return Behaviors.same();
        }
    }

    private Behavior<ExtractorMessage> onSystemShutdown(SystemShutdown message) {
        return wrap(() -> {
            if (webDriver != null) {
                webDriver.close();
            }

            return Behaviors.stopped();
        }, getContext(), message);
    }

    private <T extends BetOffer<T>> void extractOffers(BetOfferSource<?> betOfferSource, BetOfferSource.BetOfferSourceStep<T> betOfferSourceStep) {
        extractedHtml = webDriver.getPageSource();
        webDriver.close();

        List<T> betOffers = betOfferSourceStep.getExtractor().apply(extractedHtml);
        getContext().getLog().info(
                "Completed extraction of bet offer source {}, extracting offers for events {}. Stopping extractor worker.",
                betOfferSource.getUniqueIdentifier(), betOffers.stream().map(BetOffer::getEventIdentifier).collect(Collectors.toList())
        );
        if (betOffers.isEmpty()) {
            getContext().getLog().warn("No bet offers extracted for source {}", betOfferSource.getUniqueIdentifier());
        }

        senderRef.tell(
                BetOfferSourceExtracted.<T>builder()
                        .success(true)
                        .extractedOffers(betOffers)
                        .betOfferSource((BetOfferSource<T>) betOfferSource)
                        .build()
        );
    }

    private Behavior<ExtractorMessage> onExtractionTimeout(ExtractionTimeout message) {
        return wrap(() -> cleanupAndSendFailureResponse(betOfferSource), getContext(), message);
    }

    private <T extends BetOffer<T>>  Behavior<ExtractorMessage> cleanupAndSendFailureResponse(BetOfferSource<T> betOfferSource) {
        getContext().getLog().warn("Extraction for bet offer source {} failed! Aborting extraction and stopping extractor worker.", betOfferSource.getUniqueIdentifier());

        senderRef.tell(
            BetOfferSourceExtracted.<T>builder()
               .success(false)
               .betOfferSource(betOfferSource)
               .build()
        );

        try {
            if (webDriver != null) {
                webDriver.close();
            }
        } catch (Exception e) {
            getContext().getLog().warn("Failed to close webdriver cleanly while handling {} extraction failure!", betOfferSource.getUniqueIdentifier(), e);
        }


        return Behaviors.stopped();
    }

    private WebDriver createWebDriver() {
        try {
            String chromeDriverPath = resourceLoader.getResource("classpath:" + CHROMEDRIVER_FILENAME).getFile().getAbsolutePath();
            System.setProperty("webdriver.chrome.driver", chromeDriverPath);

            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();

            return driver;
        } catch (IOException e) {
            getContext().getLog().error("Unable to initialise web driver pool!");
            throw new IllegalArgumentException(e);
        }
    }

    @Builder
    @Data
    private static class StepDelayComplete implements ExtractorMessage {}

    @Builder
    @Data
    private static class ExtractionTimeout implements ExtractorMessage {}
}
