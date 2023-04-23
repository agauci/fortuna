package fortuna.message.extractor;

import fortuna.bettingsource.BetOfferSource;
import fortuna.models.offer.BetOffer;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import org.openqa.selenium.WebDriver;

import java.util.List;

@Builder
@Data
public class BetOfferSourceExtracted<T extends BetOffer<T>> implements ExtractorMessage {
    boolean                         success;
    @ToString.Exclude
    List<T>                         extractedOffers;
    BetOfferSource<T>               betOfferSource;
}
