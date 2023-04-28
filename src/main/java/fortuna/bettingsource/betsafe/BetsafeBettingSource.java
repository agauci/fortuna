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
                                    .build(),

                            /* EUROPE */
                            BetsafeThreeWayBetOfferSource.builder()
                                    .url("https://www.betsafe.com/en/sportsbook/football/champions-league/champions-league")
                                    .description("CHAMPIONS_LEAGUE")
                                    .eventCompetition(CHAMPIONS_LEAGUE)
                                    .build(),
                            BetsafeThreeWayBetOfferSource.builder()
                                    .url("https://www.betsafe.com/en/sportsbook/football/europa-league/europa-league")
                                    .description("EUROPA_LEAGUE")
                                    .eventCompetition(EUROPA_LEAGUE)
                                    .build(),
                            BetsafeThreeWayBetOfferSource.builder()
                                    .url("https://www.betsafe.com/en/sportsbook/football/europa-conference-league/europa-conference-league")
                                    .description("CONFERENCE_LEAGUE")
                                    .eventCompetition(CONFERENCE_LEAGUE)
                                    .build(),

                            /* SPAIN */
                            BetsafeThreeWayBetOfferSource.builder()
                                    .url("https://www.betsafe.com/en/sportsbook/football/spain/spain-la-liga")
                                    .description("LA_LIGA")
                                    .eventCompetition(LA_LIGA)
                                    .build(),
                            BetsafeThreeWayBetOfferSource.builder()
                                    .url("https://www.betsafe.com/en/sportsbook/football/spain/spain-segunda-division")
                                    .description("LA_LIGA_2")
                                    .eventCompetition(LA_LIGA_2)
                                    .build(),
                            BetsafeThreeWayBetOfferSource.builder()
                                    .url("https://www.betsafe.com/en/sportsbook/football/spain/spain-copa-del-rey")
                                    .description("COPA_DEL_REY")
                                    .eventCompetition(COPA_DEL_REY)
                                    .build(),

                            /* FRANCE */
                            BetsafeThreeWayBetOfferSource.builder()
                                    .url("https://www.betsafe.com/en/sportsbook/football/france/france-ligue-1")
                                    .description("LIGUE_1")
                                    .eventCompetition(LIGUE_1)
                                    .build(),
                            BetsafeThreeWayBetOfferSource.builder()
                                    .url("https://www.betsafe.com/en/sportsbook/football/france/france-ligue-2")
                                    .description("LIGUE_2")
                                    .eventCompetition(LIGUE_2)
                                    .build(),
                            BetsafeThreeWayBetOfferSource.builder()
                                    .url("https://www.betsafe.com/en/sportsbook/football/france/france-coupe-de-france")
                                    .description("COUPE_DE_FRANCE")
                                    .eventCompetition(COUPE_DE_FRANCE)
                                    .build(),

                            /* GERMANY */
                            BetsafeThreeWayBetOfferSource.builder()
                                    .url("https://www.betsafe.com/en/sportsbook/football/germany/germany-bundesliga")
                                    .description("BUNDESLIGA")
                                    .eventCompetition(BUNDESLIGA)
                                    .build(),
                            BetsafeThreeWayBetOfferSource.builder()
                                    .url("https://www.betsafe.com/en/sportsbook/football/germany/germany-2-bundesliga")
                                    .description("BUNDESLIGA_2")
                                    .eventCompetition(BUNDESLIGA_2)
                                    .build(),
                            BetsafeThreeWayBetOfferSource.builder()
                                    .url("https://www.betsafe.com/en/sportsbook/football/germany/germany-dfb-pokal")
                                    .description("DFB_POKAL")
                                    .eventCompetition(DFB_POKAL)
                                    .build(),

                            /* TURKEY */
                            BetsafeThreeWayBetOfferSource.builder()
                                    .url("https://www.betsafe.com/en/sportsbook/football/turkey/turkey-super-lig")
                                    .description("SUPER_LIG_TURKEY")
                                    .eventCompetition(SUPER_LIG_TURKEY)
                                    .build(),

                            /* PORTUGAL */
                            BetsafeThreeWayBetOfferSource.builder()
                                    .url("https://www.betsafe.com/en/sportsbook/football/portugal/portugal-primeira-liga")
                                    .description("PRIMIERA_LIGA_PORTUGAL")
                                    .eventCompetition(PRIMIERA_LIGA_PORTUGAL)
                                    .build(),

                            /* NETHERLANDS */
                            BetsafeThreeWayBetOfferSource.builder()
                                    .url("https://www.betsafe.com/en/sportsbook/football/netherlands/netherlands-eredivisie")
                                    .description("EVERDISIE")
                                    .eventCompetition(EVERDISIE)
                                    .build(),
                            BetsafeThreeWayBetOfferSource.builder()
                                    .url("https://www.betsafe.com/en/sportsbook/football/netherlands/netherlands-eerste-divisie")
                                    .description("EERSTE_DIVISIE")
                                    .eventCompetition(EERSTE_DIVISIE)
                                    .build(),
                            BetsafeThreeWayBetOfferSource.builder()
                                    .url("https://www.betsafe.com/en/sportsbook/football/netherlands/netherlands-knvb-beker")
                                    .description("KNVB_CUP")
                                    .eventCompetition(KNVB_CUP)
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
