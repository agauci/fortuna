package fortuna.message.extractor;

import akka.actor.typed.ActorRef;
import fortuna.bettingsource.BetOfferSource;
import lombok.Builder;
import lombok.Data;
import org.openqa.selenium.WebDriver;

@Builder
@Data
public class TriggerBetOfferSourceExtraction implements ExtractorMessage {
    BetOfferSource              betOfferSource;
    ActorRef<ExtractorMessage>  senderRef;
}
