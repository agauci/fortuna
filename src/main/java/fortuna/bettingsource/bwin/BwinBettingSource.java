package fortuna.bettingsource.bwin;

import com.google.common.collect.ImmutableList;
import fortuna.bettingsource.BetOfferSource;
import fortuna.bettingsource.BettingSource;
import fortuna.models.source.BettingSourceType;
import lombok.Builder;

import java.util.List;

import static fortuna.models.competition.FootballCompetition.*;
import static fortuna.models.source.Bookmaker.BWIN;
import static fortuna.models.source.Bookmaker.UNIBET;

@Builder
public class BwinBettingSource extends BettingSource {

    private static List<BetOfferSource<?>> SOURCES =
                ImmutableList.<BetOfferSource<?>>builder()
                        .add(
                            /* ENGLAND */
                            BwinThreeWayBetOfferSource.builder()
                                    .url("https://sports.bwin.com/en/sports/football-4/betting/england-14/premier-league-102841")
                                    .description("PREMIER_LEAGUE")
                                    .eventCompetition(PREMIER_LEAGUE)
                                    .build(),
                            BwinThreeWayBetOfferSource.builder()
                                    .url("https://sports.bwin.com/en/sports/football-4/betting/england-14/fa-cup-102802")
                                    .description("FA_CUP")
                                    .eventCompetition(FA_CUP)
                                    .build(),
                            BwinThreeWayBetOfferSource.builder()
                                    .url("https://sports.bwin.com/en/sports/football-4/betting/england-14/championship-102839")
                                    .description("CHAMPIONSHIP")
                                    .eventCompetition(CHAMPIONSHIP)
                                    .build(),
                            BwinThreeWayBetOfferSource.builder()
                                    .url("https://sports.bwin.com/en/sports/football-4/betting/england-14/league-one-101551")
                                    .description("LEAGUE_ONE")
                                    .eventCompetition(LEAGUE_ONE)
                                    .build(),
                            BwinThreeWayBetOfferSource.builder()
                                    .url("https://sports.bwin.com/en/sports/football-4/betting/england-14/league-two-101550")
                                    .description("LEAGUE_TWO")
                                    .eventCompetition(LEAGUE_TWO)
                                    .build(),

                            /* ITALY */
                            BwinThreeWayBetOfferSource.builder()
                                    .url("https://sports.bwin.com/en/sports/football-4/betting/italy-20/serie-a-102846")
                                    .description("SERIE_A")
                                    .eventCompetition(SERIE_A)
                                    .build(),
                            BwinThreeWayBetOfferSource.builder()
                                    .url("https://sports.bwin.com/en/sports/football-4/betting/italy-20/serie-b-102848")
                                    .description("SERIE_B")
                                    .eventCompetition(SERIE_B)
                                    .build(),
                            BwinThreeWayBetOfferSource.builder()
                                    .url("https://sports.bwin.com/en/sports/football-4/betting/italy-20/coppa-italia-102811")
                                    .description("COPPA_ITALIA")
                                    .eventCompetition(COPPA_ITALIA)
                                    .build()
                    )
                    .build();

    @Override
    public BettingSourceType getType() {
        return BWIN;
    }

    @Override
    public List<BetOfferSource<?>> sources() {
        return SOURCES;
    }
}
