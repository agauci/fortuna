package fortuna.bettingsource.betway;

import com.google.common.collect.ImmutableList;
import fortuna.bettingsource.BetOfferSource;
import fortuna.bettingsource.BettingSource;
import fortuna.bettingsource.betfair.BetfairThreeWayBetOfferSource;
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
                                BetwayThreeWayBetOfferSource.builder()
                                        .url("https://betway.com/en/sports/grp/soccer/turkey/1-lig")
                                        .eventCompetition(TURKEY_LEAGUE_2)
                                        .build(),

                            /* PORTUGAL */
                            BetwayThreeWayBetOfferSource.builder()
                                    .url("https://betway.com/en/sports/grp/soccer/portugal/primeira-liga")
                                    .description("PRIMIERA_LIGA_PORTUGAL")
                                    .eventCompetition(PRIMIERA_LIGA_PORTUGAL)
                                    .build(),
                           BetwayThreeWayBetOfferSource.builder()
                                   .url("https://betway.com/en/sports/grp/soccer/portugal/segunda-liga")
                                   .eventCompetition(PORTUGAL_LEAGUE_2)
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
                                    .build(),

                                /* AUSTRIA */
                                BetwayThreeWayBetOfferSource.builder()
                                        .url("https://betway.com/en/sports/grp/soccer/austria/bundesliga")
                                        .eventCompetition(AUSTRIA_LEAGUE_1)
                                        .build(),
                                BetwayThreeWayBetOfferSource.builder()
                                        .url("https://betway.com/en/sports/grp/soccer/austria/2-liga")
                                        .eventCompetition(AUSTRIA_LEAGUE_2)
                                        .build(),
                                BetwayThreeWayBetOfferSource.builder()
                                        .url("https://betway.com/en/sports/grp/soccer/austria/cup")
                                        .eventCompetition(AUSTRIA_OFB_CUP)
                                        .build(),

                                /* ARGENTINA */
                                BetwayThreeWayBetOfferSource.builder()
                                        .url("https://betway.com/en/sports/grp/soccer/argentina/primera-division")
                                        .eventCompetition(ARGENTINA_LEAGUE_1)
                                        .build(),
                                BetwayThreeWayBetOfferSource.builder()
                                        .url("https://betway.com/en/sports/grp/soccer/argentina/primera-nacional")
                                        .eventCompetition(ARGENTINA_LEAGUE_2)
                                        .build(),

                                /* BELGIUM */
                                BetwayThreeWayBetOfferSource.builder()
                                        .url("https://betway.com/en/sports/grp/soccer/belgium/first-division-a")
                                        .eventCompetition(BELGIUM_FIRST_DIVISION_A_1)
                                        .build(),
                                BetwayThreeWayBetOfferSource.builder()
                                        .url("https://betway.com/en/sports/grp/soccer/belgium/first-division-b")
                                        .eventCompetition(BELGIUM_FIRST_DIVISION_B_2)
                                        .build(),
                                BetwayThreeWayBetOfferSource.builder()
                                        .url("https://betway.com/en/sports/grp/soccer/belgium/beker-van-belgie")
                                        .eventCompetition(BELGIUM_CUP)
                                        .build(),

                                /* BULGARIA */
                                BetwayThreeWayBetOfferSource.builder()
                                        .url("hhttps://betway.com/en/sports/grp/soccer/bulgaria/first-professional-league")
                                        .eventCompetition(BULGARIA_LEAGUE_1)
                                        .build(),
                                // TODO missing bulgaria league 2

                                /* BRAZIL */
                                BetwayThreeWayBetOfferSource.builder()
                                        .url("https://betway.com/en/sports/grp/soccer/brazil/brasileiro-serie-a")
                                        .eventCompetition(BRAZIL_LEAGUE_1)
                                        .build(),
                                BetwayThreeWayBetOfferSource.builder()
                                        .url("https://betway.com/en/sports/grp/soccer/brazil/brasileiro-serie-b")
                                        .eventCompetition(BRAZIL_LEAGUE_2)
                                        .build(),

                                /* CROATIA */
                                BetwayThreeWayBetOfferSource.builder()
                                        .url("https://betway.com/en/sports/grp/soccer/croatia/premier-league")
                                        .eventCompetition(CROATIA_LEAGUE_1)
                                        .build(),
                                BetwayThreeWayBetOfferSource.builder()
                                        .url("https://betway.com/en/sports/grp/soccer/croatia/first-league")
                                        .eventCompetition(CROATIA_LEAGUE_2)
                                        .build(),

                                /* CYPRUS */
                                BetwayThreeWayBetOfferSource.builder()
                                        .url("https://betway.com/en/sports/grp/soccer/cyprus/1st-division")
                                        .eventCompetition(CYPRUS_LEAGUE_1)
                                        .build(),

                                /* CZECH REPUBLIC */
                                BetwayThreeWayBetOfferSource.builder()
                                        .url("https://betway.com/en/sports/grp/soccer/czech-republic/1-liga")
                                        .eventCompetition(CZECH_REPUBLIC_LEAGUE_1)
                                        .build(),
                                BetwayThreeWayBetOfferSource.builder()
                                        .url("https://betway.com/en/sports/grp/soccer/czech-republic/2-liga")
                                        .eventCompetition(CZECH_REPUBLIC_LEAGUE_2)
                                        .build(),
                                // TODO missing czech cup

                                /* DENMARK */
                                BetwayThreeWayBetOfferSource.builder()
                                        .url("https://betway.com/en/sports/grp/soccer/denmark/superligaen")
                                        .eventCompetition(DENMARK_LEAGUE_1)
                                        .build(),
                                BetwayThreeWayBetOfferSource.builder()
                                        .url("https://betway.com/en/sports/grp/soccer/denmark/1st-division")
                                        .eventCompetition(DENMARK_LEAGUE_2)
                                        .build(),

                                /* GREECE */
                                BetwayThreeWayBetOfferSource.builder()
                                        .url("https://betway.com/en/sports/grp/soccer/greece/super-league")
                                        .eventCompetition(GREECE_LEAGUE_1)
                                        .build(),
                                BetwayThreeWayBetOfferSource.builder()
                                        .url("https://betway.com/en/sports/grp/soccer/greece/super-league-2")
                                        .eventCompetition(GREECE_LEAGUE_2)
                                        .build(),

                                /* IRELAND */
                                BetwayThreeWayBetOfferSource.builder()
                                        .url("https://betway.com/en/sports/grp/soccer/ireland/premier-division")
                                        .eventCompetition(IRELAND_LEAGUE_1)
                                        .build(),
                                BetwayThreeWayBetOfferSource.builder()
                                        .url("https://betway.com/en/sports/grp/soccer/ireland/first-division")
                                        .eventCompetition(IRELAND_LEAGUE_2)
                                        .build(),

                                /* ISRAEL */
                                BetwayThreeWayBetOfferSource.builder()
                                        .url("https://betway.com/en/sports/grp/soccer/israel/premier-league")
                                        .eventCompetition(ISRAEL_LEAGUE_1)
                                        .build(),

                                /* JAPAN */
                                BetwayThreeWayBetOfferSource.builder()
                                        .url("https://betway.com/en/sports/grp/soccer/japan/j-league-1")
                                        .eventCompetition(JAPAN_LEAGUE_1)
                                        .build(),
                                BetwayThreeWayBetOfferSource.builder()
                                        .url("https://betway.com/en/sports/grp/soccer/japan/j-league-2")
                                        .eventCompetition(JAPAN_LEAGUE_2)
                                        .build(),
                                BetwayThreeWayBetOfferSource.builder()
                                        .url("https://betway.com/en/sports/grp/soccer/japan/j-league-3")
                                        .eventCompetition(JAPAN_LEAGUE_3)
                                        .build(),

                                /* NORWAY */
                                BetwayThreeWayBetOfferSource.builder()
                                        .url("https://betway.com/en/sports/grp/soccer/norway/eliteserien")
                                        .eventCompetition(NORWAY_LEAGUE_1)
                                        .build(),
                                BetwayThreeWayBetOfferSource.builder()
                                        .url("https://betway.com/en/sports/grp/soccer/norway/1st-division")
                                        .eventCompetition(NORWAY_LEAGUE_2)
                                        .build(),

                                /* POLAND */
                                BetwayThreeWayBetOfferSource.builder()
                                        .url("https://betway.com/en/sports/grp/soccer/poland/ekstraklasa")
                                        .eventCompetition(POLAND_LEAGUE_1)
                                        .build(),
                                BetwayThreeWayBetOfferSource.builder()
                                        .url("https://betway.com/en/sports/grp/soccer/poland/i-liga")
                                        .eventCompetition(POLAND_LEAGUE_2)
                                        .build(),
                                BetwayThreeWayBetOfferSource.builder()
                                        .url("https://betway.com/en/sports/grp/soccer/poland/cup")
                                        .eventCompetition(POLAND_CUP)
                                        .build(),

                                /* SCOTLAND */
                                BetwayThreeWayBetOfferSource.builder()
                                        .url("https://betway.com/en/sports/grp/soccer/scotland/premiership")
                                        .eventCompetition(SCOTLAND_PREMIER_LEAGUE)
                                        .build(),
                                BetwayThreeWayBetOfferSource.builder()
                                        .url("https://betway.com/en/sports/grp/soccer/scotland/championship")
                                        .eventCompetition(SCOTLAND_CHAMPIONSHIP)
                                        .build(),
                                BetwayThreeWayBetOfferSource.builder()
                                        .url("https://betway.com/en/sports/grp/soccer/scotland/league-one")
                                        .eventCompetition(SCOTLAND_LEAGUE_ONE)
                                        .build(),
                                BetwayThreeWayBetOfferSource.builder()
                                        .url("https://betway.com/en/sports/grp/soccer/scotland/league-two")
                                        .eventCompetition(SCOTLAND_LEAGUE_TWO)
                                        .build(),
                                BetwayThreeWayBetOfferSource.builder()
                                        .url("https://betway.com/en/sports/grp/soccer/scotland/fa-cup")
                                        .eventCompetition(SCOTLAND_FA_CUP)
                                        .build(),

                                /* SWEDEN */
                                BetwayThreeWayBetOfferSource.builder()
                                        .url("https://betway.com/en/sports/grp/soccer/sweden/allsvenskan")
                                        .eventCompetition(SWEDEN_LEAGUE_1)
                                        .build(),
                                BetwayThreeWayBetOfferSource.builder()
                                        .url("https://betway.com/en/sports/grp/soccer/sweden/superettan")
                                        .eventCompetition(SWEDEN_LEAGUE_2)
                                        .build(),
                                BetwayThreeWayBetOfferSource.builder()
                                        .url("https://betway.com/en/sports/grp/soccer/sweden/svenska-cupen")
                                        .eventCompetition(SWEDEN_CUP)
                                        .build(),

                                /* SWITZERLAND */
                                BetwayThreeWayBetOfferSource.builder()
                                        .url("https://betway.com/en/sports/grp/soccer/switzerland/super-league")
                                        .eventCompetition(SWITZERLAND_SUPER_LEAGUE_1)
                                        .build(),
                                BetwayThreeWayBetOfferSource.builder()
                                        .url("https://betway.com/en/sports/grp/soccer/switzerland/challenge-league")
                                        .eventCompetition(SWITZERLAND_CHALLENGE_LEAGUE_2)
                                        .build(),
                                BetwayThreeWayBetOfferSource.builder()
                                        .url("https://betway.com/en/sports/grp/soccer/switzerland/erste-liga-promotion")
                                        .eventCompetition(SWITZERLAND_PROMOTION_LEAGUE_3)
                                        .build(),

                                /* UKRAINE */
                                // TODO missing ukraine

                                /* USA */
                                BetwayThreeWayBetOfferSource.builder()
                                        .url("https://betway.com/en/sports/grp/soccer/usa/mls")
                                        .eventCompetition(MLS)
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
