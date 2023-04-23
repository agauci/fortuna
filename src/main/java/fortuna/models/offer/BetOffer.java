package fortuna.models.offer;

import fortuna.models.competition.EventCompetition;
import fortuna.models.source.BettingSourceType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    public abstract boolean isEquivalentTo(T betOffer);

}
