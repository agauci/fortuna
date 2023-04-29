package fortuna.bettingsource.betathome;

import com.google.common.collect.ImmutableList;
import fortuna.bettingsource.BetOfferSource;
import fortuna.bettingsource.BettingSource;
import fortuna.models.source.BettingSourceType;
import lombok.Builder;

import java.util.List;
import java.util.Map;

import static fortuna.models.competition.FootballCompetition.*;
import static fortuna.models.source.Bookmaker.BET_AT_HOME;

@Builder
public class BetAtHomeBettingSource extends BettingSource {

    private static List<BetOfferSource<?>> SOURCES =
                ImmutableList.<BetOfferSource<?>>builder()
                        .add(
                            /* EUROPE */
                            BetAtHomeThreeWayBetOfferSource.builder()
                                    .url("https://sports2.bet-at-home.com/en/tournament-location/football/1/eur/67/uefa-champions-league-2022-2023/172352451535491072/odds")
                                    .description("CHAMPIONS_LEAGUE")
                                    .eventCompetition(CHAMPIONS_LEAGUE)
                                    .build(),
                            BetAtHomeThreeWayBetOfferSource.builder()
                                    .url("https://sports2.bet-at-home.com/en/tournament-location/football/1/eur/67/uefa-europa-league-2022-2023/180336446343794688/odds")
                                    .description("EUROPA_LEAGUE")
                                    .eventCompetition(EUROPA_LEAGUE)
                                    .build(),
                            BetAtHomeThreeWayBetOfferSource.builder()
                                    .url("https://sports2.bet-at-home.com/en/tournament-location/football/1/eur/67/uefa-europa-conference-league-2022-2023/173810118319722496/odds")
                                    .description("CONFERENCE_LEAGUE")
                                    .eventCompetition(CONFERENCE_LEAGUE)
                                    .build(),    
                                
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
                                    .build(),

                            /* SPAIN */
                            BetAtHomeThreeWayBetOfferSource.builder()
                                    .url("https://sports2.bet-at-home.com/en/tournament-location/football/1/esp/65/la-liga-2022-2023/172351049260126208/odds")
                                    .description("LA_LIGA")
                                    .eventCompetition(LA_LIGA)
                                    .build(),
                            BetAtHomeThreeWayBetOfferSource.builder()
                                    .url("https://sports2.bet-at-home.com/en/tournament-location/football/1/esp/65/laliga-2-2022-2023/176149561401724928/odds")
                                    .description("LA_LIGA_2")
                                    .eventCompetition(LA_LIGA_2)
                                    .build(),
                            BetAtHomeThreeWayBetOfferSource.builder()
                                    .url("https://sports2.bet-at-home.com/en/tournament-location/football/1/esp/65/copa-del-rey-2022-2023/172351640782819328/odds")
                                    .description("COPA_DEL_REY")
                                    .eventCompetition(COPA_DEL_REY)
                                    .build(),

                            /* FRANCE */
                            BetAtHomeThreeWayBetOfferSource.builder()
                                    .url("https://sports2.bet-at-home.com/en/tournament-location/football/1/fra/73/ligue-1-2022-2023/172349803249848320/odds")
                                    .description("LIGUE_1")
                                    .eventCompetition(LIGUE_1)
                                    .build(),
                            BetAtHomeThreeWayBetOfferSource.builder()
                                    .url("https://sports2.bet-at-home.com/en/tournament-location/football/1/fra/73/ligue-2-2022-2023/176421614924124160/odds")
                                    .description("LIGUE_2")
                                    .eventCompetition(LIGUE_2)
                                    .build(),
                            BetAtHomeThreeWayBetOfferSource.builder()
                                    .url("https://sports2.bet-at-home.com/en/tournament-location/football/1/fra/73/coupe-de-france-2022-2023/185334182935842816/odds")
                                    .description("COUPE_DE_FRANCE")
                                    .eventCompetition(COUPE_DE_FRANCE)
                                    .build(),

                            /* GERMANY */
                            BetAtHomeThreeWayBetOfferSource.builder()
                                    .url("https://sports2.bet-at-home.com/en/tournament-location/football/1/deu/54/bundesliga-2022-2023/172350346522316800/odds")
                                    .description("BUNDESLIGA")
                                    .eventCompetition(BUNDESLIGA)
                                    .build(),
                            BetAtHomeThreeWayBetOfferSource.builder()
                                    .url("https://sports2.bet-at-home.com/en/tournament-location/football/1/deu/54/2-bundesliga-2022-2023/174892109525995520/odds")
                                    .description("BUNDESLIGA_2")
                                    .eventCompetition(BUNDESLIGA_2)
                                    .build(),
                            BetAtHomeThreeWayBetOfferSource.builder()
                                    .url("https://sports2.bet-at-home.com/en/tournament-location/football/1/deu/54/dfb-pokal-2022-2023/175520646916263936/odds")
                                    .description("DFB_POKAL")
                                    .eventCompetition(DFB_POKAL)
                                    .build(),

                            /* TURKEY */
                                BetAtHomeGroupThreeWayBetOfferSource.builder()
                                        .url("https://sports2.bet-at-home.com/en/sport/football/1/tur/221/location")
                                        .description("TURKEY")
                                        .competitions(Map.of(
                                                "Super Lig", SUPER_LIG_TURKEY,
                                                "1. Lig", TURKEY_LEAGUE_2,
                                                "Cup", TURKEY_CUP
                                        ))
                                        .build(),

                                /* PORTUGAL */
                                BetAtHomeGroupThreeWayBetOfferSource.builder()
                                        .url("https://sports2.bet-at-home.com/en/sport/football/1/prt/182/location/odds")
                                        .description("PORTUGAL")
                                        .competitions(Map.of(
                                                "Primeira Liga", PRIMIERA_LIGA_PORTUGAL,
                                                "Liga Segunda", PORTUGAL_LEAGUE_2,
                                                "Taca de Portugal", PORTUGAL_CUP
                                        ))
                                        .build(),

                            /* NETHERLANDS */
                            BetAtHomeThreeWayBetOfferSource.builder()
                                    .url("https://sports2.bet-at-home.com/en/tournament-location/football/1/nld/164/eredivisie-2022-2023/175809810879533056/odds")
                                    .description("EVERDISIE")
                                    .eventCompetition(EVERDISIE)
                                    .build(),
                            BetAtHomeThreeWayBetOfferSource.builder()
                                    .url("https://sports2.bet-at-home.com/en/tournament-location/football/1/nld/164/eerste-divisie-jupiler-league-2022-2023/177355362768310272/odds")
                                    .description("EERSTE_DIVISIE")
                                    .eventCompetition(EERSTE_DIVISIE)
                                    .build(),
                            BetAtHomeThreeWayBetOfferSource.builder()
                                    .url("https://sports2.bet-at-home.com/en/tournament-location/football/1/nld/164/knvb-cup-2022-2023/182531287015280640/odds")
                                    .description("KNVB_CUP")
                                    .eventCompetition(KNVB_CUP)
                                    .build(),

                            /* AUSTRIA */
                            BetAtHomeThreeWayBetOfferSource.builder()
                                    .url("https://sports2.bet-at-home.com/en/tournament-location/football/1/aut/14/bundesliga-championship-group-2023-2023/199345258308464640/odds")
                                    .eventCompetition(AUSTRIA_LEAGUE_1)
                                    .build(),
                            BetAtHomeThreeWayBetOfferSource.builder()
                                    .url("https://sports2.bet-at-home.com/en/tournament-location/football/1/aut/14/bundesliga-relegation-group-2023-2023/199345197182775296/odds")
                                    .eventCompetition(AUSTRIA_LEAGUE_1)
                                    .build(),
                            BetAtHomeThreeWayBetOfferSource.builder()
                                    .url("https://sports2.bet-at-home.com/en/tournament-location/football/1/aut/14/2-liga-2022-2023/175985196931272704/odds")
                                    .eventCompetition(AUSTRIA_LEAGUE_2)
                                    .build(),
                            BetAtHomeThreeWayBetOfferSource.builder()
                                    .url("https://sports2.bet-at-home.com/en/tournament-location/football/1/aut/14/ofb-cup-2023/175625031076859904/odds")
                                    .eventCompetition(AUSTRIA_OFB_CUP)
                                    .build(),

                                /* SWITZERLAND */
                                BetAtHomeThreeWayBetOfferSource.builder()
                                        .url("https://sports2.bet-at-home.com/en/tournament-location/football/1/che/41/super-league-2022-2023/175518295999434752/odds")
                                        .eventCompetition(SWITZERLAND_SUPER_LEAGUE_1)
                                        .build(),
                                BetAtHomeThreeWayBetOfferSource.builder()
                                        .url("https://sports2.bet-at-home.com/en/tournament-location/football/1/che/41/challenge-league-2022-2023/175785069373345792/odds")
                                        .eventCompetition(SWITZERLAND_CHALLENGE_LEAGUE_2)
                                        .build(),
                                BetAtHomeThreeWayBetOfferSource.builder()
                                        .url("https://sports2.bet-at-home.com/en/tournament-location/football/1/che/41/promotion-league-2022-2023/178528313629790208/odds")
                                        .eventCompetition(SWITZERLAND_PROMOTION_LEAGUE_3)
                                        .build(),

                                /* BELGIUM */
                                BetAtHomeGroupThreeWayBetOfferSource.builder()
                                        .url("https://sports2.bet-at-home.com/en/sport/football/1/bel/21/location")
                                        .description("BELGIUM")
                                        .competitions(Map.of(
                                                "First Division A", BELGIUM_FIRST_DIVISION_A_1,
                                                "First Division B", BELGIUM_FIRST_DIVISION_B_2,
                                                "Beker van Belgie", BELGIUM_CUP
                                        ))
                                        .build(),

                                /* BULGARIA */
                                BetAtHomeGroupThreeWayBetOfferSource.builder()
                                        .url("https://sports2.bet-at-home.com/en/sport/football/1/bgr/23/location")
                                        .description("BULGARIA")
                                        .competitions(Map.of(
                                                "A PFG", BULGARIA_LEAGUE_1,
                                                "B PFG", BULGARIA_LEAGUE_2
                                        ))
                                        .build(),

                                /* CROATIA */
                                BetAtHomeThreeWayBetOfferSource.builder()
                                        .url("https://sports2.bet-at-home.com/en/tournament-location/football/1/hrv/100/hnl-2022-2023/176158156734386176/odds")
                                        .eventCompetition(CROATIA_LEAGUE_1)
                                        .build(),

                                /* CYPRUS */
                                BetAtHomeThreeWayBetOfferSource.builder()
                                        .url("https://sports2.bet-at-home.com/en/tournament-location/football/1/cyp/52/1-division-2022-2023/173180151432007680/odds")
                                        .eventCompetition(CYPRUS_LEAGUE_1)
                                        .build(),

                                /* CZECH REPUBLIC */
                                BetAtHomeGroupThreeWayBetOfferSource.builder()
                                        .url("https://sports2.bet-at-home.com/en/sport/football/1/cze/53/location")
                                        .description("CZECH_REPUBLIC")
                                        .competitions(Map.of(
                                                "1. Liga", CZECH_REPUBLIC_LEAGUE_1,
                                                "2. Liga", CZECH_REPUBLIC_LEAGUE_2,
                                                "Czech Cup", CZECH_REPUBLIC_CUP
                                        ))
                                        .build(),

                                /* DENMARK */
                                BetAtHomeGroupThreeWayBetOfferSource.builder()
                                        .url("https://sports2.bet-at-home.com/en/sport/football/1/dnk/56/location")
                                        .description("DENMARK")
                                        .competitions(Map.of(
                                                "Superligaen", DENMARK_LEAGUE_1,
                                                "1st Division", DENMARK_LEAGUE_2
                                        ))
                                        .build(),

                                /* GREECE */
                                BetAtHomeGroupThreeWayBetOfferSource.builder()
                                        .url("https://sports2.bet-at-home.com/en/sport/football/1/grc/91/location/odds")
                                        .description("GREECE")
                                        .competitions(Map.of(
                                                "Super League Championship Group", GREECE_LEAGUE_1,
                                                "Super League Relegation Group", GREECE_LEAGUE_1
                                        ))
                                        .build(),

                                /* IRELAND */
                                BetAtHomeGroupThreeWayBetOfferSource.builder()
                                        .url("https://sports2.bet-at-home.com/en/sport/football/1/irl/104/location")
                                        .description("IRELAND")
                                        .competitions(Map.of(
                                                "Premier Division", IRELAND_LEAGUE_1,
                                                "First Division", IRELAND_LEAGUE_2
                                        ))
                                        .build(),

                                /* ISRAEL */
                                BetAtHomeThreeWayBetOfferSource.builder()
                                        .url("https://sports2.bet-at-home.com/en/tournament-location/football/1/isr/105/ligat-ha-al-2022-2023/179348309036552192/odds")
                                        .eventCompetition(ISRAEL_LEAGUE_1)
                                        .build(),

                                /* MALTA */
                                BetAtHomeThreeWayBetOfferSource.builder()
                                        .url("https://sports2.bet-at-home.com/en/tournament-location/football/1/mlt/151/fa-trophy-2023-2023/202158504952360960/odds")
                                        .eventCompetition(MALTA_CUP)
                                        .build(),

                                /* NORWAY */
                                BetAtHomeGroupThreeWayBetOfferSource.builder()
                                        .url("https://sports2.bet-at-home.com/en/sport/football/1/nor/165/location/odds")
                                        .description("NORWAY")
                                        .competitions(Map.of(
                                                "Eliteserien", NORWAY_LEAGUE_1,
                                                "1. Division", NORWAY_LEAGUE_2
                                        ))
                                        .build(),

                                /* POLAND */
                                BetAtHomeGroupThreeWayBetOfferSource.builder()
                                        .url("https://sports2.bet-at-home.com/en/sport/football/1/pol/178/location")
                                        .description("POLAND")
                                        .competitions(Map.of(
                                                "Ekstraklasa", POLAND_LEAGUE_1,
                                                "1. Division", POLAND_LEAGUE_2,
                                                "Cup", POLAND_CUP
                                        ))
                                        .build(),

                                /* SCOTLAND */
                                BetAtHomeGroupThreeWayBetOfferSource.builder()
                                        .url("https://sports2.bet-at-home.com/en/sport/football/1/sct/78/location/odds")
                                        .description("SCOTLAND")
                                        .competitions(Map.of(
                                                "Premiership", SCOTLAND_PREMIER_LEAGUE,
                                                "Championship", SCOTLAND_CHAMPIONSHIP,
                                                "League One", SCOTLAND_LEAGUE_ONE,
                                                "League Two", SCOTLAND_LEAGUE_TWO,
                                                "FA Cup", SCOTLAND_FA_CUP
                                        ))
                                        .build(),

                                /* SWEDEN */
                                BetAtHomeGroupThreeWayBetOfferSource.builder()
                                        .url("https://sports2.bet-at-home.com/en/sport/football/1/swe/194/location/odds")
                                        .description("SWEDEN")
                                        .competitions(Map.of(
                                                "Allsvenskan", SWEDEN_LEAGUE_1,
                                                "Superettan", SWEDEN_LEAGUE_2,
                                                "Svenska Cupen", SWEDEN_CUP
                                        ))
                                        .build(),

                                /* UKRAINE */
                                BetAtHomeThreeWayBetOfferSource.builder()
                                        .url("https://sports2.bet-at-home.com/en/tournament-location/football/1/ukr/226/premier-league-2022-2023/179949239220097024/odds")
                                        .eventCompetition(UKRAINE_LEAGUE_1)
                                        .build(),

                                /* ARGENTINA */
                                BetAtHomeGroupThreeWayBetOfferSource.builder()
                                        .url("https://sports2.bet-at-home.com/en/sport/football/1/arg/12/location/odds")
                                        .description("ARGENTINA")
                                        .competitions(Map.of(
                                                "Liga Profesional", ARGENTINA_LEAGUE_1,
                                                "Argentina Nacional B", ARGENTINA_LEAGUE_2
                                        ))
                                        .build(),

                                /* BRAZIL */
                                BetAtHomeGroupThreeWayBetOfferSource.builder()
                                        .url("https://sports2.bet-at-home.com/en/sport/football/1/bra/30/location/odds")
                                        .description("BRAZIL")
                                        .competitions(Map.of(
                                                "Serie A", BRAZIL_LEAGUE_1,
                                                "Serie B", BRAZIL_LEAGUE_2
                                        ))
                                        .build(),

                                /* MLS */
                                BetAtHomeThreeWayBetOfferSource.builder()
                                        .url("https://sports2.bet-at-home.com/en/tournament-location/football/1/usa/229/mls-2023/193475268207341568/odds")
                                        .eventCompetition(MLS)
                                        .build(),

                                /* JAPAN */
                                BetAtHomeGroupThreeWayBetOfferSource.builder()
                                        .url("https://sports2.bet-at-home.com/en/sport/football/1/jpn/114/location/odds")
                                        .description("JAPAN")
                                        .competitions(Map.of(
                                                "J League", JAPAN_LEAGUE_1,
                                                "J2 League", JAPAN_LEAGUE_2,
                                                "J3 League", JAPAN_LEAGUE_3
                                        ))
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
