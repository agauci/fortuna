package fortuna.message.engine;

import fortuna.message.FortunaMessage;
import fortuna.models.offer.BetOffer;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class BetArbitrageIdentified implements FortunaMessage {
    List<BetOffer<?>> offers;
}
