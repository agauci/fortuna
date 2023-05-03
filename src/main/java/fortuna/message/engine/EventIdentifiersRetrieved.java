package fortuna.message.engine;

import fortuna.models.competition.EventCompetition;
import fortuna.models.offer.BetOffer;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
@Builder
public class EventIdentifiersRetrieved {
    Map<EventCompetition, List<String>> eventIdentifiers;
}
