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
                                BwinThreeWayBetOfferSource.builder()
                                        .url("https://sports.bwin.com/en/sports/football-4/betting/turkey-31/1-lig-102226")
                                        .eventCompetition(TURKEY_LEAGUE_2)
                                        .build(),

                            /* PORTUGAL */
                            BwinThreeWayBetOfferSource.builder()
                                    .url("https://sports.bwin.com/en/sports/football-4/betting/portugal-37/primeira-liga-102851")
                                    .description("PRIMIERA_LIGA_PORTUGAL")
                                    .eventCompetition(PRIMIERA_LIGA_PORTUGAL)
                                    .build(),
                                BwinThreeWayBetOfferSource.builder()
                                        .url("https://sports.bwin.com/en/sports/football-4/betting/portugal-37/liga-portugal-2-102206")
                                        .eventCompetition(PORTUGAL_LEAGUE_2)
                                        .build(),
                                BwinThreeWayBetOfferSource.builder()
                                        .url("https://sports.bwin.com/en/sports/football-4/betting/portugal-37/taca-de-portugal-102820")
                                        .eventCompetition(PORTUGAL_CUP)
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
                                    .build(),

                                /* AUSTRIA */
                                BwinThreeWayBetOfferSource.builder()
                                        .url("https://sports.bwin.com/en/sports/football-4/betting/austria-8/bundesliga-102835")
                                        .eventCompetition(AUSTRIA_LEAGUE_1)
                                        .build(),
                                BwinThreeWayBetOfferSource.builder()
                                        .url("https://sports.bwin.com/en/sports/football-4/betting/austria-8/2-liga-102121")
                                        .eventCompetition(AUSTRIA_LEAGUE_2)
                                        .build(),
                                BwinThreeWayBetOfferSource.builder()
                                        .url("https://sports.bwin.com/en/sports/football-4/betting/austria-8/ofb-cup-102721")
                                        .eventCompetition(AUSTRIA_OFB_CUP)
                                        .build(),

                                /* ARGENTINA */
                                BwinThreeWayBetOfferSource.builder()
                                        .url("https://sports.bwin.com/en/sports/football-4/betting/argentina-38/liga-profesional-de-futbol-102540")
                                        .eventCompetition(ARGENTINA_LEAGUE_1)
                                        .build(),
                                BwinThreeWayBetOfferSource.builder()
                                        .url("https://sports.bwin.com/en/sports/football-4/betting/argentina-38/primera-nacional-102234")
                                        .eventCompetition(ARGENTINA_LEAGUE_2)
                                        .build(),

                                /* BELGIUM */
                                BwinThreeWayBetOfferSource.builder()
                                        .url("https://sports.bwin.com/en/sports/football-4/betting/belgium-35/jupiler-pro-league-0:12")
                                        .eventCompetition(BELGIUM_FIRST_DIVISION_A_1)
                                        .build(),
                                // TODO Missing belgium second division
                                BwinThreeWayBetOfferSource.builder()
                                        .url("https://sports.bwin.com/en/sports/football-4/betting/belgium-35/beker-van-belgie-102722")
                                        .eventCompetition(BELGIUM_CUP)
                                        .build(),

                                /* BULGARIA */
                                BwinThreeWayBetOfferSource.builder()
                                        .url("https://sports.bwin.com/en/sports/football-4/betting/bulgaria-63/first-professional-league-2062")
                                        .eventCompetition(BULGARIA_LEAGUE_1)
                                        .build(),
                                // TODO missing bulgaria league 2

                                /* BRAZIL */
                                BwinThreeWayBetOfferSource.builder()
                                        .url("https://sports.bwin.com/en/sports/football-4/betting/brazil-33/brasileiro-serie-a-102838")
                                        .eventCompetition(BRAZIL_LEAGUE_1)
                                        .build(),
                                BwinThreeWayBetOfferSource.builder()
                                        .url("https://sports.bwin.com/en/sports/football-4/betting/brazil-33/brasileiro-serie-b-102361")
                                        .eventCompetition(BRAZIL_LEAGUE_2)
                                        .build(),

                                /* CROATIA */
                                BwinThreeWayBetOfferSource.builder()
                                        .url("https://sports.bwin.com/en/sports/football-4/betting/croatia-50/hnl-102164")
                                        .eventCompetition(CROATIA_LEAGUE_1)
                                        .build(),
                                BwinThreeWayBetOfferSource.builder()
                                        .url("https://sports.bwin.com/en/sports/football-4/betting/croatia-50/prva-nl-101537")
                                        .eventCompetition(CROATIA_LEAGUE_2)
                                        .build(),

                                /* CYPRUS */
                                BwinThreeWayBetOfferSource.builder()
                                        .url("https://sports.bwin.com/en/sports/football-4/betting/cyprus-58/1st-division-101413")
                                        .eventCompetition(CYPRUS_LEAGUE_1)
                                        .build(),

                                /* CZECH REPUBLIC */
                                BwinThreeWayBetOfferSource.builder()
                                        .url("https://sports.bwin.com/en/sports/football-4/betting/czech-republic-12/1-liga-101587")
                                        .eventCompetition(CZECH_REPUBLIC_LEAGUE_1)
                                        .build(),
                                BwinThreeWayBetOfferSource.builder()
                                        .url("https://sports.bwin.com/en/sports/football-4/betting/czech-republic-12/fnl-101586")
                                        .eventCompetition(CZECH_REPUBLIC_LEAGUE_2)
                                        .build(),
                                // TODO missing czech cup

                                /* DENMARK */
                                BwinThreeWayBetOfferSource.builder()
                                        .url("https://sports.bwin.com/en/sports/football-4/betting/denmark-13/superligaen-102837")
                                        .eventCompetition(DENMARK_LEAGUE_1)
                                        .build(),
                                BwinThreeWayBetOfferSource.builder()
                                        .url("https://sports.bwin.com/en/sports/football-4/betting/denmark-13/1st-division-102166")
                                        .eventCompetition(DENMARK_LEAGUE_2)
                                        .build(),

                                /* GREECE */
                                BwinThreeWayBetOfferSource.builder()
                                        .url("https://sports.bwin.com/en/sports/football-4/betting/greece-18/super-league-102844")
                                        .eventCompetition(GREECE_LEAGUE_1)
                                        .build(),
                                BwinThreeWayBetOfferSource.builder()
                                        .url("https://sports.bwin.com/en/sports/football-4/betting/greece-18/super-league-2-102191")
                                        .eventCompetition(GREECE_LEAGUE_2)
                                        .build(),

                                /* IRELAND */
                                BwinThreeWayBetOfferSource.builder()
                                        .url("https://sports.bwin.com/en/sports/football-4/betting/ireland-23/premier-division-102208")
                                        .eventCompetition(IRELAND_LEAGUE_1)
                                        .build(),
                                // TODO missing ireland league 2

                                /* ISRAEL */
                                BwinThreeWayBetOfferSource.builder()
                                        .url("https://sports.bwin.com/en/sports/football-4/betting/israel-62/premier-league-101409")
                                        .eventCompetition(ISRAEL_LEAGUE_1)
                                        .build(),

                                /* JAPAN */
                                // TODO missing Japan J1 league
                                BwinThreeWayBetOfferSource.builder()
                                        .url("https://sports.bwin.com/en/sports/football-4/betting/japan-52/j2-league-101400")
                                        .eventCompetition(JAPAN_LEAGUE_2)
                                        .build(),
                                BwinThreeWayBetOfferSource.builder()
                                        .url("https://sports.bwin.com/en/sports/football-4/betting/japan-52/j3-league-102237")
                                        .eventCompetition(JAPAN_LEAGUE_3)
                                        .build(),

                                /* NORWAY */
                                BwinThreeWayBetOfferSource.builder()
                                        .url("https://sports.bwin.com/en/sports/football-4/betting/norway-21/eliteserien-102275")
                                        .eventCompetition(NORWAY_LEAGUE_1)
                                        .build(),
                                BwinThreeWayBetOfferSource.builder()
                                        .url("https://sports.bwin.com/en/sports/football-4/betting/norway-21/1st-division-101578")
                                        .eventCompetition(NORWAY_LEAGUE_2)
                                        .build(),

                                /* POLAND */
                                BwinThreeWayBetOfferSource.builder()
                                        .url("https://sports.bwin.com/en/sports/football-4/betting/poland-22/ekstraklasa-2063")
                                        .eventCompetition(POLAND_LEAGUE_1)
                                        .build(),
                                BwinThreeWayBetOfferSource.builder()
                                        .url("https://sports.bwin.com/en/sports/football-4/betting/poland-22/i-liga-101534")
                                        .eventCompetition(POLAND_LEAGUE_2)
                                        .build(),
                                // Missing poland cup

                                /* SCOTLAND */
                                BwinThreeWayBetOfferSource.builder()
                                        .url("https://sports.bwin.com/en/sports/football-4/betting/scotland-26/premiership-102853")
                                        .eventCompetition(SCOTLAND_PREMIER_LEAGUE)
                                        .build(),
                                BwinThreeWayBetOfferSource.builder()
                                        .url("https://sports.bwin.com/en/sports/football-4/betting/scotland-26/championship-101557")
                                        .eventCompetition(SCOTLAND_CHAMPIONSHIP)
                                        .build(),
                                BwinThreeWayBetOfferSource.builder()
                                        .url("https://sports.bwin.com/en/sports/football-4/betting/scotland-26/league-one-2018")
                                        .eventCompetition(SCOTLAND_LEAGUE_ONE)
                                        .build(),
                                BwinThreeWayBetOfferSource.builder()
                                        .url("https://sports.bwin.com/en/sports/football-4/betting/scotland-26/league-two-2019")
                                        .eventCompetition(SCOTLAND_LEAGUE_TWO)
                                        .build(),
                                BwinThreeWayBetOfferSource.builder()
                                        .url("https://sports.bwin.com/en/sports/football-4/betting/scotland-26/scottish-cup-102824")
                                        .eventCompetition(SCOTLAND_FA_CUP)
                                        .build(),

                                /* SWEDEN */
                                BwinThreeWayBetOfferSource.builder()
                                        .url("https://sports.bwin.com/en/sports/football-4/betting/sweden-29/allsvenskan-102831")
                                        .eventCompetition(SWEDEN_LEAGUE_1)
                                        .build(),
                                BwinThreeWayBetOfferSource.builder()
                                        .url("https://sports.bwin.com/en/sports/football-4/betting/sweden-29/superettan-102222")
                                        .eventCompetition(SWEDEN_LEAGUE_2)
                                        .build(),
                                // TODO missing sweden cup

                                /* SWITZERLAND */
                                BwinThreeWayBetOfferSource.builder()
                                        .url("https://sports.bwin.com/en/sports/football-4/betting/switzerland-30/super-league-102378")
                                        .eventCompetition(SWITZERLAND_SUPER_LEAGUE_1)
                                        .build(),
                                BwinThreeWayBetOfferSource.builder()
                                        .url("https://sports.bwin.com/en/sports/football-4/betting/switzerland-30/challenge-league-102221")
                                        .eventCompetition(SWITZERLAND_CHALLENGE_LEAGUE_2)
                                        .build(),
                                BwinThreeWayBetOfferSource.builder()
                                        .url("https://sports.bwin.com/en/sports/football-4/betting/switzerland-30/promotion-league-102699")
                                        .eventCompetition(SWITZERLAND_PROMOTION_LEAGUE_3)
                                        .build(),

                                /* UKRAINE */
                                BwinThreeWayBetOfferSource.builder()
                                        .url("https://sports.bwin.com/en/sports/football-4/betting/ukraine-53/premier-league-102227")
                                        .eventCompetition(UKRAINE_LEAGUE_1)
                                        .build(),

                                /* USA */
                                BwinThreeWayBetOfferSource.builder()
                                        .url("https://sports.bwin.com/en/sports/football-4/betting/north-america-9/major-league-soccer-102849")
                                        .eventCompetition(MLS)
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
