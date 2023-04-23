package fortuna.bettingsource;

import fortuna.models.competition.EventCompetition;
import fortuna.models.offer.BetOffer;
import fortuna.models.source.BettingSourceType;
import lombok.Builder;
import lombok.Data;

import java.util.List;

public abstract class BettingSource {

    public abstract BettingSourceType getType();

    public abstract List<BetOfferSource<?>> sources();

    public <T extends BetOffer<T>> BetOfferSource<T> resolveCompetition(EventCompetition competition) {
        return sources().stream()
                .filter(source -> competition.equals(source.getEventCompetition().orElse(null)))
                .map(e -> (BetOfferSource<T>) e)
                .findFirst()
                .orElseThrow();
    }

}
