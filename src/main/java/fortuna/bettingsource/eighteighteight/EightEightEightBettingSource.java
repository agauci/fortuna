package fortuna.bettingsource.eighteighteight;

import com.google.common.collect.ImmutableList;
import fortuna.bettingsource.BetOfferSource;
import fortuna.bettingsource.BettingSource;
import fortuna.models.source.BettingSourceType;
import lombok.Builder;

import java.util.List;

import static fortuna.models.competition.FootballCompetition.*;
import static fortuna.models.source.Bookmaker.EIGHTEIGHTEIGHT;

@Builder
public class EightEightEightBettingSource extends BettingSource {

    private static List<BetOfferSource<?>> SOURCES =
            ImmutableList.<BetOfferSource<?>>builder()
                    .add(
                            /* ENGLAND */
                            EightEightEightThreeWayBetOfferSource.builder()
                                    .url("https://www.888sport.com/football/england/premier-league/")
                                    .description("PREMIER_LEAGUE")
                                    .eventCompetition(PREMIER_LEAGUE)
                                    .build(),
                            EightEightEightThreeWayBetOfferSource.builder()
                                    .url("https://www.888sport.com/football/england/the-championship/")
                                    .description("CHAMPIONSHIP")
                                    .eventCompetition(CHAMPIONSHIP)
                                    .build(),
                            EightEightEightThreeWayBetOfferSource.builder()
                                    .url("https://www.888sport.com/football/england/league-one/")
                                    .description("LEAGUE_ONE")
                                    .eventCompetition(LEAGUE_ONE)
                                    .build(),
                            EightEightEightThreeWayBetOfferSource.builder()
                                    .url("https://www.888sport.com/england/league-two/")
                                    .description("LEAGUE_TWO")
                                    .eventCompetition(LEAGUE_TWO)
                                    .build(),

                            /* ITALY */
                            EightEightEightThreeWayBetOfferSource.builder()
                                    .url("https://www.888sport.com/football/italy/serie-a/")
                                    .description("SERIE_A")
                                    .eventCompetition(SERIE_A)
                                    .build(),
                            EightEightEightThreeWayBetOfferSource.builder()
                                    .url("https://www.888sport.com/football/italy/italy-serie-b-t-319569/")
                                    .description("SERIE_B")
                                    .eventCompetition(SERIE_B)
                                    .build(),
                            EightEightEightThreeWayBetOfferSource.builder()
                                    .url("https://www.888sport.com/football/italy/coppa-italia-odds/")
                                    .description("COPPA_ITALIA")
                                    .eventCompetition(COPPA_ITALIA)
                                    .build()
                    )
                    .build();

    @Override
    public BettingSourceType getType() {
        return EIGHTEIGHTEIGHT;
    }

    @Override
    public List<BetOfferSource<?>> sources() {
        return SOURCES;
    }
}
