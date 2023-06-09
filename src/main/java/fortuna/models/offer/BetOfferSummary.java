package fortuna.models.offer;

import fortuna.models.competition.EventCompetition;
import fortuna.models.source.BettingSourceType;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class BetOfferSummary {
    List<String>        participants;
    BetOfferType        type;
    BettingSourceType   bettingSourceType;
    EventCompetition    eventCompetition;
    LocalDateTime       extractedTimestamp;
    List<BigDecimal>    odds;
}
