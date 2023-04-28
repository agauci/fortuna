package fortuna.bettingsource.betway;

import com.google.common.collect.ImmutableList;
import fortuna.bettingsource.BetOfferSource;
import fortuna.bettingsource.BettingSource;
import fortuna.models.source.BettingSourceType;
import lombok.Builder;

import java.util.List;

import static fortuna.models.competition.FootballCompetition.*;
import static fortuna.models.source.Bookmaker.BETWAY;

@Builder
public class BetwayBettingSource extends BettingSource {

    private static List<BetOfferSource<?>> SOURCES =
                ImmutableList.<BetOfferSource<?>>builder()
                        .add(
                            /* ENGLAND */
                            BetwayThreeWayBetOfferSource.builder()
                                    .url("https://betway.com/en/sports/grp/soccer/england/premier-league")
                                    .description("PREMIER_LEAGUE")
                                    .eventCompetition(PREMIER_LEAGUE)
                                    .build(),
                            BetwayThreeWayBetOfferSource.builder()
                                    .url("https://betway.com/en/sports/grp/soccer/england/fa-cup")
                                    .description("FA_CUP")
                                    .eventCompetition(FA_CUP)
                                    .build(),
                            BetwayThreeWayBetOfferSource.builder()
                                    .url("https://betway.com/en/sports/grp/soccer/england/championship")
                                    .description("CHAMPIONSHIP")
                                    .eventCompetition(CHAMPIONSHIP)
                                    .build(),
                            BetwayThreeWayBetOfferSource.builder()
                                    .url("https://betway.com/en/sports/grp/soccer/england/league-one")
                                    .description("LEAGUE_ONE")
                                    .eventCompetition(LEAGUE_ONE)
                                    .build(),
                            BetwayThreeWayBetOfferSource.builder()
                                    .url("https://betway.com/en/sports/grp/soccer/england/league-two")
                                    .description("LEAGUE_TWO")
                                    .eventCompetition(LEAGUE_TWO)
                                    .build(),

                            /* ITALY */
                            BetwayThreeWayBetOfferSource.builder()
                                    .url("https://betway.com/en/sports/grp/soccer/italy/serie-a")
                                    .description("CHAMPIONSHIP")
                                    .eventCompetition(SERIE_A)
                                    .build(),
                            BetwayThreeWayBetOfferSource.builder()
                                    .url("https://betway.com/en/sports/grp/soccer/italy/serie-b")
                                    .description("SERIE_B")
                                    .eventCompetition(SERIE_B)
                                    .build(),
                            BetwayThreeWayBetOfferSource.builder()
                                    .url("https://betway.com/en/sports/grp/soccer/italy/coppa-italia")
                                    .description("COPPA_ITALIA")
                                    .eventCompetition(COPPA_ITALIA)
                                    .build(),

                            /* EUROPE */
                            BetwayThreeWayBetOfferSource.builder()
                                    .url("https://betway.com/en/sports/grp/soccer/european-cups/uefa-champions-league")
                                    .description("CHAMPIONS_LEAGUE")
                                    .eventCompetition(CHAMPIONS_LEAGUE)
                                    .build(),
                            BetwayThreeWayBetOfferSource.builder()
                                    .url("https://betway.com/en/sports/grp/soccer/european-cups/uefa-europa-league")
                                    .description("EUROPA_LEAGUE")
                                    .eventCompetition(EUROPA_LEAGUE)
                                    .build(),
                            BetwayThreeWayBetOfferSource.builder()
                                    .url("https://betway.com/en/sports/grp/soccer/european-cups/uefa-conference-league")
                                    .description("CONFERENCE_LEAGUE")
                                    .eventCompetition(CONFERENCE_LEAGUE)
                                    .build(),

                            /* SPAIN */
                            BetwayThreeWayBetOfferSource.builder()
                                    .url("https://betway.com/en/sports/grp/soccer/spain/la-liga")
                                    .description("LA_LIGA")
                                    .eventCompetition(LA_LIGA)
                                    .build(),
                            BetwayThreeWayBetOfferSource.builder()
                                    .url("https://betway.com/en/sports/grp/soccer/spain/la-liga-2")
                                    .description("LA_LIGA_2")
                                    .eventCompetition(LA_LIGA_2)
                                    .build(),
                            BetwayThreeWayBetOfferSource.builder()
                                    .url("https://betway.com/en/sports/grp/soccer/spain/copa-del-rey")
                                    .description("COPA_DEL_REY")
                                    .eventCompetition(COPA_DEL_REY)
                                    .build(),

                            /* FRANCE */
                            BetwayThreeWayBetOfferSource.builder()
                                    .url("https://betway.com/en/sports/grp/soccer/france/ligue-1")
                                    .description("LIGUE_1")
                                    .eventCompetition(LIGUE_1)
                                    .build(),
                            BetwayThreeWayBetOfferSource.builder()
                                    .url("https://betway.com/en/sports/grp/soccer/france/ligue-2")
                                    .description("LIGUE_2")
                                    .eventCompetition(LIGUE_2)
                                    .build(),
                            BetwayThreeWayBetOfferSource.builder()
                                    .url("https://betway.com/en/sports/grp/soccer/france/coupe-de-france")
                                    .description("COUPE_DE_FRANCE")
                                    .eventCompetition(COUPE_DE_FRANCE)
                                    .build(),

                            /* GERMANY */
                            BetwayThreeWayBetOfferSource.builder()
                                    .url("https://betway.com/en/sports/grp/soccer/germany/bundesliga")
                                    .description("BUNDESLIGA")
                                    .eventCompetition(BUNDESLIGA)
                                    .build(),
                            BetwayThreeWayBetOfferSource.builder()
                                    .url("https://betway.com/en/sports/grp/soccer/germany/2-bundesliga")
                                    .description("BUNDESLIGA_2")
                                    .eventCompetition(BUNDESLIGA_2)
                                    .build(),
                            BetwayThreeWayBetOfferSource.builder()
                                    .url("https://betway.com/en/sports/grp/soccer/germany/dfb-pokal")
                                    .description("DFB_POKAL")
                                    .eventCompetition(DFB_POKAL)
                                    .build(),

                            /* TURKEY */
                            BetwayThreeWayBetOfferSource.builder()
                                    .url("https://betway.com/en/sports/grp/soccer/turkey/super-lig")
                                    .description("SUPER_LIG_TURKEY")
                                    .eventCompetition(SUPER_LIG_TURKEY)
                                    .build(),

                            /* PORTUGAL */
                            BetwayThreeWayBetOfferSource.builder()
                                    .url("https://betway.com/en/sports/grp/soccer/portugal/primeira-liga")
                                    .description("PRIMIERA_LIGA_PORTUGAL")
                                    .eventCompetition(PRIMIERA_LIGA_PORTUGAL)
                                    .build(),

                            /* NETHERLANDS */
                            BetwayThreeWayBetOfferSource.builder()
                                    .url("https://betway.com/en/sports/grp/soccer/netherlands/eredivisie")
                                    .description("EVERDISIE")
                                    .eventCompetition(EVERDISIE)
                                    .build(),
                            BetwayThreeWayBetOfferSource.builder()
                                    .url("https://betway.com/en/sports/grp/soccer/netherlands/eerste-divisie")
                                    .description("EERSTE_DIVISIE")
                                    .eventCompetition(EERSTE_DIVISIE)
                                    .build(),
                            BetwayThreeWayBetOfferSource.builder()
                                    .url("https://betway.com/en/sports/grp/soccer/netherlands/knvb-beker")
                                    .description("KNVB_CUP")
                                    .eventCompetition(KNVB_CUP)
                                    .build()
                        )
                    .build();

    @Override
    public BettingSourceType getType() {
        return BETWAY;
    }

    @Override
    public List<BetOfferSource<?>> sources() {
        return SOURCES;
    }
}
