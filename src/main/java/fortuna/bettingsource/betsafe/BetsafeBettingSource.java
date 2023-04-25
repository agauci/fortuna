package fortuna.bettingsource.betsafe;

import com.google.common.collect.ImmutableList;
import fortuna.bettingsource.BetOfferSource;
import fortuna.bettingsource.BettingSource;
import fortuna.models.source.BettingSourceType;
import lombok.Builder;

import java.util.List;
import java.util.Map;

import static fortuna.models.competition.FootballCompetition.*;
import static fortuna.models.source.Bookmaker.BETSAFE;

@Builder
public class BetsafeBettingSource extends BettingSource {

    private static List<BetOfferSource<?>> SOURCES =
                ImmutableList.<BetOfferSource<?>>builder()
                        .add(
                            /* ENGLAND */
                            BetsafeGroupThreeWayBetOfferSource.builder()
                                    .url("https://www.betsafe.com/en/sportsbook/football?tab=competitionsAndLeagues")
                                    .description("ENGLAND")
                                    .competitions(Map.of(
                                        "England Premier League (EPL)", PREMIER_LEAGUE,
                                        "England EFL Championship", CHAMPIONSHIP,
                                        "England League One", LEAGUE_ONE,
                                        "England League Two", LEAGUE_TWO
                                    ))
                                    .build(),

                            /* ITALY */
                            BetsafeThreeWayBetOfferSource.builder()
                                    .url("https://www.betsafe.com/en/sportsbook/football/italy/italy-serie-a")
                                    .description("SERIE_A")
                                    .eventCompetition(SERIE_A)
                                    .build(),
                            BetsafeThreeWayBetOfferSource.builder()
                                    .url("https://www.betsafe.com/en/sportsbook/football/italy/italy-coppa-italia")
                                    .description("COPPA_ITALIA")
                                    .eventCompetition(COPPA_ITALIA)
                                    .build(),
                            BetsafeThreeWayBetOfferSource.builder()
                                    .url("https://www.betsafe.com/en/sportsbook/football/italy/italy-serie-b")
                                    .description("SERIE_B")
                                    .eventCompetition(SERIE_B)
                                    .build()
                    )
                    .build();

    @Override
    public BettingSourceType getType() {
        return BETSAFE;
    }

    @Override
    public List<BetOfferSource<?>> sources() {
        return SOURCES;
    }
}
