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
                                    .url("https://izibet.com/sports/tournament-location/football/1/italy/111/serie-a-2022-2023/172351402271625216")
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

                            /* PORTUGAL */
                            IzibetThreeWayBetOfferSource.builder()
                                    .url("https://izibet.com/sports/tournament-location/football/1/portugal/182/primeira-liga-2022-2023/176420483277836544")
                                    .description("PRIMIERA_LIGA_PORTUGAL")
                                    .eventCompetition(PRIMIERA_LIGA_PORTUGAL)
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
