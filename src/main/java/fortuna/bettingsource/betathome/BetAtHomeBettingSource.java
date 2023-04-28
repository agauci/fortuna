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
                            BetAtHomeThreeWayBetOfferSource.builder()
                                    .url("https://sports2.bet-at-home.com/en/tournament-location/football/1/tur/221/super-lig-2022-2023/175788422471929856/odds")
                                    .description("SUPER_LIG_TURKEY")
                                    .eventCompetition(SUPER_LIG_TURKEY)
                                    .build(),

                            /* PORTUGAL */
                            BetAtHomeThreeWayBetOfferSource.builder()
                                    .url("https://sports2.bet-at-home.com/en/tournament-location/football/1/prt/182/primeira-liga-2022-2023/176420483277836544/odds")
                                    .description("PRIMIERA_LIGA_PORTUGAL")
                                    .eventCompetition(PRIMIERA_LIGA_PORTUGAL)
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
