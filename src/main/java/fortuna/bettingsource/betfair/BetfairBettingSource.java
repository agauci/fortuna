package fortuna.bettingsource.betfair;

import com.google.common.collect.ImmutableList;
import fortuna.bettingsource.BetOfferSource;
import fortuna.bettingsource.BettingSource;
import fortuna.models.source.BettingSourceType;
import lombok.Builder;

import java.util.List;

import static fortuna.models.competition.FootballCompetition.*;
import static fortuna.models.source.BettingExchange.BETFAIR;

@Builder
public class BetfairBettingSource extends BettingSource {

    private static List<BetOfferSource<?>> SOURCES =
                ImmutableList.<BetOfferSource<?>>builder()
                        .add(
                            /* ENGLAND */
                            BetfairThreeWayBetOfferSource.builder()
                                    .url("https://www.betfair.com/sport/football/english-premier-league/10932509")
                                    .description("PREMIER_LEAGUE")
                                    .eventCompetition(PREMIER_LEAGUE)
                                    .build(),
                            BetfairThreeWayBetOfferSource.builder()
                                    .url("https://www.betfair.com/sport/football/english-championship/7129730")
                                    .description("CHAMPIONSHIP")
                                    .eventCompetition(CHAMPIONSHIP)
                                    .build(),
                            BetfairThreeWayBetOfferSource.builder()
                                    .url("https://www.betfair.com/sport/football/english-fa-cup/30558")
                                    .description("FA_CUP")
                                    .eventCompetition(FA_CUP)
                                    .build(),
                            BetfairThreeWayBetOfferSource.builder()
                                    .url("https://www.betfair.com/sport/football/english-league-1/35")
                                    .description("LEAGUE_1")
                                    .eventCompetition(LEAGUE_ONE)
                                    .build(),
                            BetfairThreeWayBetOfferSource.builder()
                                    .url("https://www.betfair.com/sport/football/english-league-2/37")
                                    .description("LEAGUE_TWO")
                                    .eventCompetition(LEAGUE_TWO)
                                    .build(),

                            /* ITALY */
                            BetfairThreeWayBetOfferSource.builder()
                                    .url("https://www.betfair.com/sport/football/italian-serie-a/81")
                                    .description("SERIE_A")
                                    .eventCompetition(SERIE_A)
                                    .build(),
                            BetfairThreeWayBetOfferSource.builder()
                                    .url("https://www.betfair.com/sport/football/italian-serie-b/12199689")
                                    .description("SERIE_B")
                                    .eventCompetition(SERIE_B)
                                    .build(),
                            BetfairThreeWayBetOfferSource.builder()
                                    .url("https://www.betfair.com/sport/football/italian-cup/12214429")
                                    .description("COPPA_ITALIA")
                                    .eventCompetition(COPPA_ITALIA)
                                    .build(),

                            /* EUROPE */
                            BetfairThreeWayBetOfferSource.builder()
                                    .url("https://www.betfair.com/sport/football/uefa-champions-league/228")
                                    .description("CHAMPIONS_LEAGUE")
                                    .eventCompetition(CHAMPIONS_LEAGUE)
                                    .build(),
                            BetfairThreeWayBetOfferSource.builder()
                                    .url("https://www.betfair.com/sport/football/uefa-europa-league/2005")
                                    .description("EUROPA_LEAGUE")
                                    .eventCompetition(EUROPA_LEAGUE)
                                    .build(),
                            BetfairThreeWayBetOfferSource.builder()
                                    .url("https://www.betfair.com/sport/football/uefa-europa-conference-league/12375833")
                                    .description("CONFERENCE_LEAGUE")
                                    .eventCompetition(CONFERENCE_LEAGUE)
                                    .build(),

                            /* SPAIN */
                            BetfairThreeWayBetOfferSource.builder()
                                    .url("https://www.betfair.com/sport/football/spanish-la-liga/117")
                                    .description("LA_LIGA")
                                    .eventCompetition(LA_LIGA)
                                    .build(),
                            BetfairThreeWayBetOfferSource.builder()
                                    .url("https://www.betfair.com/sport/football/spanish-segunda-division/12204313")
                                    .description("LA_LIGA_2")
                                    .eventCompetition(LA_LIGA_2)
                                    .build(),
                            BetfairThreeWayBetOfferSource.builder()
                                    .url("https://www.betfair.com/sport/football/spanish-copa-del-rey/12801")
                                    .description("COPA_DEL_REY")
                                    .eventCompetition(COPA_DEL_REY)
                                    .build(),

                            /* FRANCE */
                            BetfairThreeWayBetOfferSource.builder()
                                    .url("https://sports2.bet-at-home.com/en/tournament-location/football/1/fra/73/ligue-1-2022-2023/172349803249848320/odds")
                                    .description("LIGUE_1")
                                    .eventCompetition(LIGUE_1)
                                    .build(),
                            BetfairThreeWayBetOfferSource.builder()
                                    .url("https://sports2.bet-at-home.com/en/tournament-location/football/1/fra/73/ligue-2-2022-2023/176421614924124160/odds")
                                    .description("LIGUE_2")
                                    .eventCompetition(LIGUE_2)
                                    .build(),
                            BetfairThreeWayBetOfferSource.builder()
                                    .url("https://sports2.bet-at-home.com/en/tournament-location/football/1/fra/73/coupe-de-france-2022-2023/185334182935842816/odds")
                                    .description("COUPE_DE_FRANCE")
                                    .eventCompetition(COUPE_DE_FRANCE)
                                    .build(),

                            /* GERMANY */
                            BetfairThreeWayBetOfferSource.builder()
                                    .url("https://sports2.bet-at-home.com/en/tournament-location/football/1/deu/54/bundesliga-2022-2023/172350346522316800/odds")
                                    .description("BUNDESLIGA")
                                    .eventCompetition(BUNDESLIGA)
                                    .build(),
                            BetfairThreeWayBetOfferSource.builder()
                                    .url("https://sports2.bet-at-home.com/en/tournament-location/football/1/deu/54/2-bundesliga-2022-2023/174892109525995520/odds")
                                    .description("BUNDESLIGA_2")
                                    .eventCompetition(BUNDESLIGA_2)
                                    .build(),
                            BetfairThreeWayBetOfferSource.builder()
                                    .url("https://sports2.bet-at-home.com/en/tournament-location/football/1/deu/54/dfb-pokal-2022-2023/175520646916263936/odds")
                                    .description("DFB_POKAL")
                                    .eventCompetition(DFB_POKAL)
                                    .build(),

                            /* TURKEY */
                            BetfairThreeWayBetOfferSource.builder()
                                    .url("https://sports2.bet-at-home.com/en/tournament-location/football/1/tur/221/super-lig-2022-2023/175788422471929856/odds")
                                    .description("SUPER_LIG_TURKEY")
                                    .eventCompetition(SUPER_LIG_TURKEY)
                                    .build(),

                            /* PORTUGAL */
                            BetfairThreeWayBetOfferSource.builder()
                                    .url("https://sports2.bet-at-home.com/en/tournament-location/football/1/prt/182/primeira-liga-2022-2023/176420483277836544/odds")
                                    .description("PRIMIERA_LIGA_PORTUGAL")
                                    .eventCompetition(PRIMIERA_LIGA_PORTUGAL)
                                    .build(),

                            /* NETHERLANDS */
                            BetfairThreeWayBetOfferSource.builder()
                                    .url("https://sports2.bet-at-home.com/en/tournament-location/football/1/nld/164/eredivisie-2022-2023/175809810879533056/odds")
                                    .description("EVERDISIE")
                                    .eventCompetition(EVERDISIE)
                                    .build(),
                            BetfairThreeWayBetOfferSource.builder()
                                    .url("https://sports2.bet-at-home.com/en/tournament-location/football/1/nld/164/eerste-divisie-jupiler-league-2022-2023/177355362768310272/odds")
                                    .description("EERSTE_DIVISIE")
                                    .eventCompetition(EERSTE_DIVISIE)
                                    .build(),
                            BetfairThreeWayBetOfferSource.builder()
                                    .url("https://sports2.bet-at-home.com/en/tournament-location/football/1/nld/164/knvb-cup-2022-2023/182531287015280640/odds")
                                    .description("KNVB_CUP")
                                    .eventCompetition(KNVB_CUP)
                                    .build()
                        ).build();

    @Override
    public BettingSourceType getType() {
        return BETFAIR;
    }

    @Override
    public List<BetOfferSource<?>> sources() {
        return SOURCES;
    }
}
