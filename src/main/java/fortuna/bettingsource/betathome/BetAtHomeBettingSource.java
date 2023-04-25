package fortuna.bettingsource.betathome;

import com.google.common.collect.ImmutableList;
import fortuna.bettingsource.BetOfferSource;
import fortuna.bettingsource.BettingSource;
import fortuna.models.source.BettingSourceType;
import lombok.Builder;

import java.util.List;

import static fortuna.models.competition.FootballCompetition.*;
import static fortuna.models.source.Bookmaker.BET_AT_HOME;

@Builder
public class BetAtHomeBettingSource extends BettingSource {

    private static List<BetOfferSource<?>> SOURCES =
                ImmutableList.<BetOfferSource<?>>builder()
                        .add(
                            /* ENGLAND */
                            BetAtHomeThreeWayBetOfferSource.builder()
                                    .url("https://sports2.bet-at-home.com/en/tournament-location/football/1/eng/77/premier-league-2022-2023/172350176981209088/odds")
                                    .description("PREMIER_LEAGUE")
                                    .eventCompetition(PREMIER_LEAGUE)
                                    .build(),
                            BetAtHomeThreeWayBetOfferSource.builder()
                                    .url("https://sports2.bet-at-home.com/en/tournament-location/football/1/eng/77/championship-2022-2023/173180507601817600/odds")
                                    .description("CHAMPIONSHIP")
                                    .eventCompetition(CHAMPIONSHIP)
                                    .build(),
                            BetAtHomeThreeWayBetOfferSource.builder()
                                    .url("https://sports2.bet-at-home.com/en/tournament-location/football/1/eng/77/fa-cup-2022-2023/176430786050838528/odds")
                                    .description("FA_CUP")
                                    .eventCompetition(FA_CUP)
                                    .build(),
                            BetAtHomeThreeWayBetOfferSource.builder()
                                    .url("https://sports2.bet-at-home.com/en/tournament-location/football/1/eng/77/league-one-2022-2023/174891337287520256/odds")
                                    .description("LEAGUE_1")
                                    .eventCompetition(LEAGUE_ONE)
                                    .build(),
                            BetAtHomeThreeWayBetOfferSource.builder()
                                    .url("https://sports2.bet-at-home.com/en/tournament-location/football/1/eng/77/league-two-2022-2023/174625422780190720/odds")
                                    .description("LEAGUE_TWO")
                                    .eventCompetition(LEAGUE_TWO)
                                    .build(),

                            /* ITALY */
                            BetAtHomeThreeWayBetOfferSource.builder()
                                    .url("https://sports2.bet-at-home.com/en/tournament-location/football/1/ita/111/serie-a-2022-2023/172351402271625216/odds")
                                    .description("SERIE_A")
                                    .eventCompetition(SERIE_A)
                                    .build(),
                            BetAtHomeThreeWayBetOfferSource.builder()
                                    .url("https://sports2.bet-at-home.com/en/tournament-location/football/1/ita/111/serie-b-2022-2023/176429455908065280/odds")
                                    .description("SERIE_B")
                                    .eventCompetition(SERIE_B)
                                    .build(),
                            BetAtHomeThreeWayBetOfferSource.builder()
                                    .url("https://sports2.bet-at-home.com/en/tournament-location/football/1/ita/111/coppa-italia-2022-2023/176427778145570816/odds")
                                    .description("COPPA_ITALIA")
                                    .eventCompetition(COPPA_ITALIA)
                                    .build()
                    )
                    .build();

    @Override
    public BettingSourceType getType() {
        return BET_AT_HOME;
    }

    @Override
    public List<BetOfferSource<?>> sources() {
        return SOURCES;
    }
}
