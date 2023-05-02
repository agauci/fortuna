package fortuna.message.engine;

import fortuna.models.offer.BetOffer;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class BetOffersRetrieved {
    List<BetOffer<?>> betOffers;
}
