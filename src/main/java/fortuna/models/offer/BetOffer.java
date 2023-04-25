package fortuna.models.offer;

import fortuna.models.competition.EventCompetition;
import fortuna.models.source.BettingSourceType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class BetOffer<T extends BetOffer<T>> {
    List<String>        participants;
    String              eventIdentifier;
    BetOfferType        type;
    BettingSourceType   bettingSourceType;
    EventCompetition    eventCompetition;
    Long                extractedTimestamp;
    List<BigDecimal>    originalOdds;

    public abstract boolean isEquivalentTo(T betOffer);

}
