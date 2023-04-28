package fortuna.bettingsource.bwin;

import com.google.common.collect.ImmutableList;
import fortuna.bettingsource.BetOfferSource;
import fortuna.bettingsource.BettingSource;
import fortuna.models.source.BettingSourceType;
import lombok.Builder;

import java.util.List;

import static fortuna.models.competition.FootballCompetition.*;
import static fortuna.models.source.Bookmaker.BWIN;

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
                                    .build(),

                            /* EUROPE */
                            BwinThreeWayBetOfferSource.builder()
                                    .url("https://sports.bwin.com/en/sports/football-4/betting/europe-7/champions-league-0:3")
                                    .description("CHAMPIONS_LEAGUE")
                                    .eventCompetition(CHAMPIONS_LEAGUE)
                                    .build(),
                            BwinThreeWayBetOfferSource.builder()
                                    .url("https://sports.bwin.com/en/sports/football-4/betting/europe-7/uefa-europa-league-0:5")
                                    .description("EUROPA_LEAGUE")
                                    .eventCompetition(EUROPA_LEAGUE)
                                    .build(),
                            BwinThreeWayBetOfferSource.builder()
                                    .url("https://sports.bwin.com/en/sports/football-4/betting/europe-7/uefa-europa-conference-league-0:9")
                                    .description("CONFERENCE_LEAGUE")
                                    .eventCompetition(CONFERENCE_LEAGUE)
                                    .build(),

                            /* SPAIN */
                            BwinThreeWayBetOfferSource.builder()
                                    .url("https://sports.bwin.com/en/sports/football-4/betting/spain-28/laliga-102829")
                                    .description("LA_LIGA")
                                    .eventCompetition(LA_LIGA)
                                    .build(),
                            BwinThreeWayBetOfferSource.builder()
                                    .url("https://sports.bwin.com/en/sports/football-4/betting/spain-28/laliga-2-102830")
                                    .description("LA_LIGA_2")
                                    .eventCompetition(LA_LIGA_2)
                                    .build(),
                            BwinThreeWayBetOfferSource.builder()
                                    .url("https://sports.bwin.com/en/sports/football-4/betting/spain-28/copa-del-rey-102728")
                                    .description("COPA_DEL_REY")
                                    .eventCompetition(COPA_DEL_REY)
                                    .build(),

                            /* FRANCE */
                            BwinThreeWayBetOfferSource.builder()
                                    .url("https://sports.bwin.com/en/sports/football-4/betting/france-16/ligue-1-102843")
                                    .description("LIGUE_1")
                                    .eventCompetition(LIGUE_1)
                                    .build(),
                            BwinThreeWayBetOfferSource.builder()
                                    .url("https://sports.bwin.com/en/sports/football-4/betting/france-16/ligue-2-102376")
                                    .description("LIGUE_2")
                                    .eventCompetition(LIGUE_2)
                                    .build(),
                            BwinThreeWayBetOfferSource.builder()
                                    .url("https://sports.bwin.com/en/sports/football-4/betting/france-16/coupe-de-france-102808")
                                    .description("COUPE_DE_FRANCE")
                                    .eventCompetition(COUPE_DE_FRANCE)
                                    .build(),

                            /* GERMANY */
                            BwinThreeWayBetOfferSource.builder()
                                    .url("https://sports.bwin.com/en/sports/football-4/betting/germany-17/bundesliga-102842")
                                    .description("BUNDESLIGA")
                                    .eventCompetition(BUNDESLIGA)
                                    .build(),
                            BwinThreeWayBetOfferSource.builder()
                                    .url("https://sports.bwin.com/en/sports/football-4/betting/germany-17/2nd-bundesliga-102845")
                                    .description("BUNDESLIGA_2")
                                    .eventCompetition(BUNDESLIGA_2)
                                    .build(),
                            BwinThreeWayBetOfferSource.builder()
                                    .url("https://sports.bwin.com/en/sports/football-4/betting/germany-17/dfb-pokal-102809")
                                    .description("DFB_POKAL")
                                    .eventCompetition(DFB_POKAL)
                                    .build(),

                            /* TURKEY */
                            BwinThreeWayBetOfferSource.builder()
                                    .url("https://sports.bwin.com/en/sports/football-4/betting/turkey-31/super-lig-102832")
                                    .description("SUPER_LIG_TURKEY")
                                    .eventCompetition(SUPER_LIG_TURKEY)
                                    .build(),

                            /* PORTUGAL */
                            BwinThreeWayBetOfferSource.builder()
                                    .url("https://sports.bwin.com/en/sports/football-4/betting/portugal-37/primeira-liga-102851")
                                    .description("PRIMIERA_LIGA_PORTUGAL")
                                    .eventCompetition(PRIMIERA_LIGA_PORTUGAL)
                                    .build(),

                            /* NETHERLANDS */
                            BwinThreeWayBetOfferSource.builder()
                                    .url("https://sports.bwin.com/en/sports/football-4/betting/netherlands-36/eredivisie-102847")
                                    .description("EVERDISIE")
                                    .eventCompetition(EVERDISIE)
                                    .build(),
                            BwinThreeWayBetOfferSource.builder()
                                    .url("https://sports.bwin.com/en/sports/football-4/betting/netherlands-36/eerste-divisie-102254")
                                    .description("EERSTE_DIVISIE")
                                    .eventCompetition(EERSTE_DIVISIE)
                                    .build(),
                            BwinThreeWayBetOfferSource.builder()
                                    .url("https://sports.bwin.com/en/sports/football-4/betting/netherlands-36/knvb-beker-102816")
                                    .description("KNVB_CUP")
                                    .eventCompetition(KNVB_CUP)
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
