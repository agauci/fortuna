package fortuna.message.engine;

import fortuna.message.FortunaMessage;
import fortuna.models.offer.BetOffer;
import fortuna.models.offer.BetOfferType;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Builder
@Data
public class BetArbitrageIdentified implements FortunaMessage {
    List<BetOffer<?>> offers;
    BetOfferType betOfferType;
    List<BigDecimal> odds;
    BigDecimal probability;
}