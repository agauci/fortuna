package fortuna.bettingsource.izibet;

import com.google.common.collect.ImmutableList;
import fortuna.bettingsource.BetOfferSource;
import fortuna.bettingsource.BettingSource;
import fortuna.models.source.BettingSourceType;
import lombok.Builder;

import java.util.List;

import static fortuna.models.competition.FootballCompetition.*;
import static fortuna.models.source.Bookmaker.IZIBET;

@Builder
public class IzibetBettingSource extends BettingSource {

    private static List<BetOfferSource<?>> SOURCES =
                ImmutableList.<BetOfferSource<?>>builder()
                        .add(
                            /* ENGLAND */
                            IzibetThreeWayBetOfferSource.builder()
                                    .url("https://sports2.izibet.com/en/tournament-location/football/1/england/77/premier-league-2022-2023/172350176981209088/upcoming")
                                    .description("PREMIER_LEAGUE")
                                    .eventCompetition(PREMIER_LEAGUE)
                                    .build(),
                            IzibetThreeWayBetOfferSource.builder()
                                    .url("https://izibet.com/sports/tournament-location/football/1/england/77/fa-cup-2022-2023/176430786050838528/upcoming")
                                    .description("FA_CUP")
                                    .eventCompetition(FA_CUP)
                                    .build(),
                            IzibetThreeWayBetOfferSource.builder()
                                    .url("https://izibet.com/sports/tournament-location/football/1/england/77/championship-2022-2023/173180507601817600/upcoming")
                                    .description("CHAMPIONSHIP")
                                    .eventCompetition(CHAMPIONSHIP)
                                    .build(),
                            IzibetThreeWayBetOfferSource.builder()
                                    .url("https://izibet.com/sports/tournament-location/football/1/england/77/league-one-2022-2023/174891337287520256/upcoming")
                                    .description("LEAGUE_ONE")
                                    .eventCompetition(LEAGUE_ONE)
                                    .build(),
                            IzibetThreeWayBetOfferSource.builder()
                                    .url("https://izibet.com/sports/tournament-location/football/1/england/77/league-two-2022-2023/174625422780190720/upcoming")
                                    .description("LEAGUE_TWO")
                                    .eventCompetition(LEAGUE_TWO)
                                    .build(),

                            /* ITALY */
                            IzibetThreeWayBetOfferSource.builder()
                                    .url("https://sports2.izibet.com/en/tournament-location/football/1/italy/111/serie-a-2022-2023/172351402271625216/upcoming")
                                    .description("SERIE_A")
                                    .eventCompetition(SERIE_A)
                                    .build(),
                            IzibetThreeWayBetOfferSource.builder()
                                    .url("https://izibet.com/sports/tournament-location/football/1/italy/111/serie-b-2022-2023/176429455908065280/upcoming")
                                    .description("SERIE_B")
                                    .eventCompetition(SERIE_B)
                                    .build(),
                            IzibetThreeWayBetOfferSource.builder()
                                    .url("https://izibet.com/sports/tournament-location/football/1/italy/111/coppa-italia-2022-2023/176427778145570816/upcoming")
                                    .description("COPPA_ITALIA")
                                    .eventCompetition(COPPA_ITALIA)
                                    .build(),

                            /* EUROPE */
                            IzibetThreeWayBetOfferSource.builder()
                                    .url("https://izibet.com/sports/tournament-location/football/1/europe/67/uefa-champions-league-2022-2023/172352451535491072/upcoming")
                                    .description("CHAMPIONS_LEAGUE")
                                    .eventCompetition(CHAMPIONS_LEAGUE)
                                    .build(),
                            IzibetThreeWayBetOfferSource.builder()
                                    .url("https://izibet.com/sports/tournament-location/football/1/europe/67/uefa-europa-league-2022-2023/180336446343794688/upcoming")
                                    .description("EUROPA_LEAGUE")
                                    .eventCompetition(EUROPA_LEAGUE)
                                    .build(),
                            IzibetThreeWayBetOfferSource.builder()
                                    .url("https://izibet.com/sports/tournament-location/football/1/europe/67/uefa-europa-conference-league-2022-2023/173810118319722496/upcoming")
                                    .description("CONFERENCE_LEAGUE")
                                    .eventCompetition(CONFERENCE_LEAGUE)
                                    .build(),

                            /* SPAIN */
                            IzibetThreeWayBetOfferSource.builder()
                                    .url("https://izibet.com/sports/tournament-location/football/1/spain/65/la-liga-2022-2023/172351049260126208/upcoming")
                                    .description("LA_LIGA")
                                    .eventCompetition(LA_LIGA)
                                    .build(),
                            IzibetThreeWayBetOfferSource.builder()
                                    .url("https://izibet.com/sports/tournament-location/football/1/spain/65/laliga-2-2022-2023/176149561401724928/upcoming")
                                    .description("LA_LIGA_2")
                                    .eventCompetition(LA_LIGA_2)
                                    .build(),
                            IzibetThreeWayBetOfferSource.builder()
                                    .url("https://izibet.com/sports/tournament-location/football/1/spain/65/copa-del-rey-2022-2023/172351640782819328/upcoming")
                                    .description("COPA_DEL_REY")
                                    .eventCompetition(COPA_DEL_REY)
                                    .build(),

                            /* FRANCE */
                            IzibetThreeWayBetOfferSource.builder()
                                    .url("https://izibet.com/sports/tournament-location/football/1/france/73/ligue-1-2022-2023/172349803249848320/upcoming")
                                    .description("LIGUE_1")
                                    .eventCompetition(LIGUE_1)
                                    .build(),
                            IzibetThreeWayBetOfferSource.builder()
                                    .url("https://izibet.com/sports/tournament-location/football/1/france/73/ligue-2-2022-2023/176421614924124160/upcoming")
                                    .description("LIGUE_2")
                                    .eventCompetition(LIGUE_2)
                                    .build(),
                            IzibetThreeWayBetOfferSource.builder()
                                    .url("https://izibet.com/sports/tournament-location/football/1/france/73/coupe-de-france-2022-2023/185334182935842816/upcoming")
                                    .description("COUPE_DE_FRANCE")
                                    .eventCompetition(COUPE_DE_FRANCE)
                                    .build(),

                            /* GERMANY */
                            IzibetThreeWayBetOfferSource.builder()
                                    .url("https://izibet.com/sports/tournament-location/football/1/germany/54/bundesliga-2022-2023/172350346522316800/upcoming")
                                    .description("BUNDESLIGA")
                                    .eventCompetition(BUNDESLIGA)
                                    .build(),
                            IzibetThreeWayBetOfferSource.builder()
                                    .url("https://izibet.com/sports/tournament-location/football/1/germany/54/2-bundesliga-2022-2023/174892109525995520/upcoming")
                                    .description("BUNDESLIGA_2")
                                    .eventCompetition(BUNDESLIGA_2)
                                    .build(),
                            IzibetThreeWayBetOfferSource.builder()
                                    .url("https://izibet.com/sports/tournament-location/football/1/germany/54/dfb-pokal-2022-2023/175520646916263936/upcoming")
                                    .description("DFB_POKAL")
                                    .eventCompetition(DFB_POKAL)
                                    .build(),

                            /* TURKEY */
                            IzibetThreeWayBetOfferSource.builder()
                                    .url("https://izibet.com/sports/tournament-location/football/1/turkey/221/1-lig-2022-2023/176464888748625920/upcoming")
                                    .description("SUPER_LIG_TURKEY")
                                    .eventCompetition(SUPER_LIG_TURKEY)
                                    .build(),
                                IzibetThreeWayBetOfferSource.builder()
                                        .url("https://sports2.izibet.com/en/tournament-location/football/1/turkey/221/2-lig-2023/179049821830696960/upcoming")
                                        .eventCompetition(TURKEY_LEAGUE_2)
                                        .build(),
                                IzibetThreeWayBetOfferSource.builder()
                                        .url("https://sports2.izibet.com/en/tournament-location/football/1/turkey/221/cup-2022-2023/181962285002051584/upcoming")
                                        .eventCompetition(TURKEY_CUP)
                                        .build(),

                            /* PORTUGAL */
                            IzibetThreeWayBetOfferSource.builder()
                                    .url("https://sports2.izibet.com/en/tournament-location/football/1/portugal/182/primeira-liga-2022-2023/176420483277836544/upcoming")
                                    .description("PRIMIERA_LIGA_PORTUGAL")
                                    .eventCompetition(PRIMIERA_LIGA_PORTUGAL)
                                    .build(),
                                IzibetThreeWayBetOfferSource.builder()
                                        .url("https://sports2.izibet.com/en/tournament-location/football/1/portugal/182/taca-de-portugal-2022-2023/181680013795446784/upcoming")
                                        .eventCompetition(PORTUGAL_CUP)
                                        .build(),
                                IzibetThreeWayBetOfferSource.builder()
                                        .url("https://sports2.izibet.com/en/tournament-location/football/1/portugal/182/liga-segunda-2022-2023/177375774005841920/upcoming")
                                        .eventCompetition(PORTUGAL_LEAGUE_2)
                                        .build(),

                            /* NETHERLANDS */
                            IzibetThreeWayBetOfferSource.builder()
                                    .url("https://izibet.com/sports/tournament-location/football/1/netherlands/164/eredivisie-2022-2023/175809810879533056/upcoming")
                                    .description("EVERDISIE")
                                    .eventCompetition(EVERDISIE)
                                    .build(),
                            IzibetThreeWayBetOfferSource.builder()
                                    .url("https://izibet.com/sports/tournament-location/football/1/netherlands/164/eerste-divisie-jupiler-league-2022-2023/177355362768310272/upcoming")
                                    .description("EERSTE_DIVISIE")
                                    .eventCompetition(EERSTE_DIVISIE)
                                    .build(),
                            IzibetThreeWayBetOfferSource.builder()
                                    .url("https://izibet.com/sports/tournament-location/football/1/netherlands/164/knvb-cup-2022-2023/182531287015280640/upcoming")
                                    .description("KNVB_CUP")
                                    .eventCompetition(KNVB_CUP)
                                    .build(),

                                /* AUSTRIA */
                                IzibetThreeWayBetOfferSource.builder()
                                        .url("https://sports2.izibet.com/en/tournament-location/football/1/austria/14/bundesliga-2022-2023/174892911084752896/upcoming")
                                        .eventCompetition(AUSTRIA_LEAGUE_1)
                                        .build(),
                                IzibetThreeWayBetOfferSource.builder()
                                        .url("https://sports2.izibet.com/en/tournament-location/football/1/austria/14/2-liga-2022-2023/175985196931272704/upcoming")
                                        .eventCompetition(AUSTRIA_LEAGUE_2)
                                        .build(),
                                IzibetThreeWayBetOfferSource.builder()
                                        .url("https://sports2.izibet.com/en/tournament-location/football/1/austria/14/ofb-cup-2023/175625031076859904/upcoming")
                                        .eventCompetition(AUSTRIA_OFB_CUP)
                                        .build(),

                                /* ARGENTINA */
                                IzibetThreeWayBetOfferSource.builder()
                                        .url("https://sports2.izibet.com/en/tournament-location/football/1/argentina/12/liga-profesional-2022-2023/172341015583182848/upcoming")
                                        .eventCompetition(ARGENTINA_LEAGUE_1)
                                        .build(),
                                IzibetThreeWayBetOfferSource.builder()
                                        .url("https://sports2.izibet.com/en/tournament-location/football/1/argentina/12/argentina-nacional-b-2023/194740277091659776/upcoming")
                                        .eventCompetition(ARGENTINA_LEAGUE_2)
                                        .build(),

                                /* BELGIUM */
                                IzibetThreeWayBetOfferSource.builder()
                                        .url("https://sports2.izibet.com/en/tournament-location/football/1/belgium/21/first-division-a-2022-2023/175279246647808000/upcoming")
                                        .eventCompetition(BELGIUM_FIRST_DIVISION_A_1)
                                        .build(),
                                IzibetThreeWayBetOfferSource.builder()
                                        .url("https://sports2.izibet.com/en/tournament-location/football/1/belgium/21/first-division-b-2023-2023/196627483590815744/upcoming")
                                        .eventCompetition(BELGIUM_FIRST_DIVISION_B_2)
                                        .build(),
                                IzibetThreeWayBetOfferSource.builder()
                                        .url("https://sports2.izibet.com/en/tournament-location/football/1/belgium/21/beker-van-belgie-2022-2023/182665743251329024/upcoming")
                                        .eventCompetition(BELGIUM_CUP)
                                        .build(),

                                /* BULGARIA */
                                IzibetThreeWayBetOfferSource.builder()
                                        .url("https://sports2.izibet.com/en/tournament-location/football/1/bulgaria/23/a-pfg-2022-2023/175519779754397696/upcoming")
                                        .eventCompetition(BULGARIA_LEAGUE_1)
                                        .build(),
                                IzibetThreeWayBetOfferSource.builder()
                                        .url("https://sports2.izibet.com/en/tournament-location/football/1/bulgaria/23/b-pfg-2023/176392198502273024/upcoming")
                                        .eventCompetition(BULGARIA_LEAGUE_2)
                                        .build(),

                                /* BRAZIL */
                                IzibetThreeWayBetOfferSource.builder()
                                        .url("https://sports2.izibet.com/en/tournament-location/football/1/brazil/30/serie-a-2023/198376411867803648/upcoming")
                                        .eventCompetition(BRAZIL_LEAGUE_1)
                                        .build(),
                                IzibetThreeWayBetOfferSource.builder()
                                        .url("https://sports2.izibet.com/en/tournament-location/football/1/brazil/30/serie-b-2023/198396214338809856/upcoming")
                                        .eventCompetition(BRAZIL_LEAGUE_2)
                                        .build(),

                                /* CROATIA */
                                IzibetThreeWayBetOfferSource.builder()
                                        .url("https://sports2.izibet.com/en/tournament-location/football/1/croatia/100/hnl-2022-2023/176158156734386176/upcoming")
                                        .eventCompetition(CROATIA_LEAGUE_1)
                                        .build(),
                                IzibetThreeWayBetOfferSource.builder()
                                        .url("https://sports2.izibet.com/en/tournament-location/football/1/croatia/100/1-nl-2023-2023/199263749866156032/upcoming")
                                        .eventCompetition(CROATIA_LEAGUE_1)
                                        .build(),

                                /* CYPRUS */
                                IzibetThreeWayBetOfferSource.builder()
                                        .url("https://sports2.izibet.com/en/tournament-location/football/1/cyprus/52/1-division-2022-2023/173180151432007680/upcoming")
                                        .eventCompetition(CYPRUS_LEAGUE_1)
                                        .build(),

                                /* CZECH REPUBLIC */
                                IzibetThreeWayBetOfferSource.builder()
                                        .url("https://sports2.izibet.com/en/tournament-location/football/1/czech-republic/53/1-liga-2022-2023/176385550176014336/upcoming")
                                        .eventCompetition(CZECH_REPUBLIC_LEAGUE_1)
                                        .build(),
                                IzibetThreeWayBetOfferSource.builder()
                                        .url("https://sports2.izibet.com/en/tournament-location/football/1/czech-republic/53/2-liga-2023/177631007945576448/upcoming")
                                        .eventCompetition(CZECH_REPUBLIC_LEAGUE_2)
                                        .build(),
                                // TODO missing czech republic cup

                                /* DENMARK */
                                IzibetThreeWayBetOfferSource.builder()
                                        .url("https://sports2.izibet.com/en/tournament-location/football/1/denmark/56/superligaen-2022-2023/173796292397420544/upcoming")
                                        .eventCompetition(DENMARK_LEAGUE_1)
                                        .build(),
                                IzibetThreeWayBetOfferSource.builder()
                                        .url("https://sports2.izibet.com/en/tournament-location/football/1/denmark/56/1st-division-2022-2023/175279421948743680/upcoming")
                                        .eventCompetition(DENMARK_LEAGUE_2)
                                        .build(),

                                /* GREECE */
                                IzibetThreeWayBetOfferSource.builder()
                                        .url("https://sports2.izibet.com/en/tournament-location/football/1/greece/91/super-league-championship-group-2023/198380022087708672/upcoming")
                                        .eventCompetition(GREECE_LEAGUE_1)
                                        .build(),
                                IzibetThreeWayBetOfferSource.builder()
                                        .url("https://sports2.izibet.com/en/tournament-location/football/1/greece/91/super-league-relegation-group-2023/198379944921952256/upcoming")
                                        .eventCompetition(GREECE_LEAGUE_1)
                                        .build(),
                                IzibetThreeWayBetOfferSource.builder()
                                        .url("https://sports2.izibet.com/en/tournament-location/football/1/greece/91/super-league-2-2022-2023/186476620302831616/upcoming")
                                        .eventCompetition(GREECE_LEAGUE_2)
                                        .build(),

                                /* IRELAND */
                                IzibetThreeWayBetOfferSource.builder()
                                        .url("https://sports2.izibet.com/en/tournament-location/football/1/ireland/104/premier-division-2023/192419790237888512/upcoming")
                                        .eventCompetition(IRELAND_LEAGUE_1)
                                        .build(),
                                IzibetThreeWayBetOfferSource.builder()
                                        .url("https://sports2.izibet.com/en/tournament-location/football/1/ireland/104/first-division-2023-2023/187291626410921984/upcoming")
                                        .eventCompetition(IRELAND_LEAGUE_2)
                                        .build(),

                                /* ISRAEL */
                                IzibetThreeWayBetOfferSource.builder()
                                        .url("https://sports2.izibet.com/en/tournament-location/football/1/israel/105/ligat-ha-al-2022-2023/179348309036552192/upcoming")
                                        .eventCompetition(ISRAEL_LEAGUE_1)
                                        .build(),

                                /* JAPAN */
                                IzibetThreeWayBetOfferSource.builder()
                                        .url("https://sports2.izibet.com/en/tournament-location/football/1/japan/114/j-league-2023/192327782293991424/upcoming")
                                        .eventCompetition(JAPAN_LEAGUE_1)
                                        .build(),
                                IzibetThreeWayBetOfferSource.builder()
                                        .url("https://sports2.izibet.com/en/tournament-location/football/1/japan/114/j2-league-2023/195296551604744192/upcoming")
                                        .eventCompetition(JAPAN_LEAGUE_2)
                                        .build(),
                                IzibetThreeWayBetOfferSource.builder()
                                        .url("https://sports2.izibet.com/en/tournament-location/football/1/japan/114/j3-league-2023/196643254087872512/upcoming")
                                        .eventCompetition(JAPAN_LEAGUE_3)
                                        .build(),

                                /* MALTA */
                                IzibetThreeWayBetOfferSource.builder()
                                        .url("https://sports2.izibet.com/en/tournament-location/football/1/malta/151/fa-trophy-2023-2023/202158504952360960/upcoming")
                                        .eventCompetition(MALTA_CUP)
                                        .build(),

                                /* NORWAY */
                                IzibetThreeWayBetOfferSource.builder()
                                        .url("https://sports2.izibet.com/en/tournament-location/football/1/norway/165/eliteserien-2023/192058742000480256/upcoming")
                                        .eventCompetition(NORWAY_LEAGUE_1)
                                        .build(),
                                IzibetThreeWayBetOfferSource.builder()
                                        .url("https://sports2.izibet.com/en/tournament-location/football/1/norway/165/1-division-2023/192056804259295232/upcoming")
                                        .eventCompetition(NORWAY_LEAGUE_2)
                                        .build(),

                                /* POLAND */
                                IzibetThreeWayBetOfferSource.builder()
                                        .url("https://sports2.izibet.com/en/tournament-location/football/1/poland/178/ekstraklasa-2022-2023/173796694003077120/upcoming")
                                        .eventCompetition(POLAND_LEAGUE_1)
                                        .build(),
                                IzibetThreeWayBetOfferSource.builder()
                                        .url("https://sports2.izibet.com/en/tournament-location/football/1/poland/178/1-division-2022-2023/175884056922214400/upcoming")
                                        .eventCompetition(POLAND_LEAGUE_2)
                                        .build(),
                                IzibetThreeWayBetOfferSource.builder()
                                        .url("https://sports2.izibet.com/en/tournament-location/football/1/poland/178/cup-2022-2023/180600771067301888/upcoming")
                                        .eventCompetition(POLAND_CUP)
                                        .build(),

                                /* SCOTLAND */
                                IzibetThreeWayBetOfferSource.builder()
                                        .url("https://sports2.izibet.com/en/tournament-location/football/1/scotland/78/premiership-2022-2023/174182169769463808/upcoming")
                                        .eventCompetition(SCOTLAND_PREMIER_LEAGUE)
                                        .build(),
                                IzibetThreeWayBetOfferSource.builder()
                                        .url("https://sports2.izibet.com/en/tournament-location/football/1/scotland/78/championship-2022-2023/177375425219055616/upcoming")
                                        .eventCompetition(SCOTLAND_CHAMPIONSHIP)
                                        .build(),
                                IzibetThreeWayBetOfferSource.builder()
                                        .url("https://sports2.izibet.com/en/tournament-location/football/1/scotland/78/league-one-2022-2023/177621661427748864/upcoming")
                                        .eventCompetition(SCOTLAND_LEAGUE_ONE)
                                        .build(),
                                // TODO missing scottish league 2
                                IzibetThreeWayBetOfferSource.builder()
                                        .url("https://sports2.izibet.com/en/tournament-location/football/1/scotland/78/fa-cup-2022-2023/185318309707698176/upcoming")
                                        .eventCompetition(SCOTLAND_FA_CUP)
                                        .build(),

                                /* SWEDEN */
                                IzibetThreeWayBetOfferSource.builder()
                                        .url("https://sports2.izibet.com/en/tournament-location/football/1/sweden/194/allsvenskan-2023/192137677077901312/upcoming")
                                        .eventCompetition(SWEDEN_LEAGUE_1)
                                        .build(),
                                IzibetThreeWayBetOfferSource.builder()
                                        .url("https://sports2.izibet.com/en/tournament-location/football/1/sweden/194/superettan-2023/198936585411129344/upcoming")
                                        .eventCompetition(SWEDEN_LEAGUE_2)
                                        .build(),
                                IzibetThreeWayBetOfferSource.builder()
                                        .url("https://sports2.izibet.com/en/tournament-location/football/1/sweden/194/svenska-cupen-2022-2023/173790166575534080/upcoming")
                                        .eventCompetition(SWEDEN_CUP)
                                        .build(),

                                /* SWITZERLAND */
                                IzibetThreeWayBetOfferSource.builder()
                                        .url("https://sports2.izibet.com/en/tournament-location/football/1/switzerland/41/super-league-2022-2023/175518295999434752/upcoming")
                                        .eventCompetition(SWITZERLAND_SUPER_LEAGUE_1)
                                        .build(),
                                IzibetThreeWayBetOfferSource.builder()
                                        .url("https://sports2.izibet.com/en/tournament-location/football/1/switzerland/41/challenge-league-2022-2023/175785069373345792/upcoming")
                                        .eventCompetition(SWITZERLAND_CHALLENGE_LEAGUE_2)
                                        .build(),
                                // TODO missing switzerland league 3

                                /* UKRAINE */
                                // TODO missing ukraine league 1

                                /* USA */
                                IzibetThreeWayBetOfferSource.builder()
                                        .url("https://sports2.izibet.com/en/tournament-location/football/1/united-states/229/mls-2023/193475268207341568/upcoming")
                                        .eventCompetition(MLS)
                                        .build()
                    )
                    .build();

    @Override
    public BettingSourceType getType() {
        return IZIBET;
    }

    @Override
    public List<BetOfferSource<?>> sources() {
        return SOURCES;
    }
}
