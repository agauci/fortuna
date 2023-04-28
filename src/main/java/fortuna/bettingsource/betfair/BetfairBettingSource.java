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
                                    .url("https://www.betfair.com/sport/football/french-ligue-1/55")
                                    .description("LIGUE_1")
                                    .eventCompetition(LIGUE_1)
                                    .build(),
                            BetfairThreeWayBetOfferSource.builder()
                                    .url("https://www.betfair.com/sport/football/french-ligue-2/57")
                                    .description("LIGUE_2")
                                    .eventCompetition(LIGUE_2)
                                    .build(),
                            BetfairThreeWayBetOfferSource.builder()
                                    .url("https://www.betfair.com/sport/football/french-cup/12209560")
                                    .description("COUPE_DE_FRANCE")
                                    .eventCompetition(COUPE_DE_FRANCE)
                                    .build(),

                            /* GERMANY */
                            BetfairThreeWayBetOfferSource.builder()
                                    .url("https://www.betfair.com/sport/football/german-bundesliga/59")
                                    .description("BUNDESLIGA")
                                    .eventCompetition(BUNDESLIGA)
                                    .build(),
                            BetfairThreeWayBetOfferSource.builder()
                                    .url("https://www.betfair.com/sport/football/german-bundesliga-2/61")
                                    .description("BUNDESLIGA_2")
                                    .eventCompetition(BUNDESLIGA_2)
                                    .build(),
                            BetfairThreeWayBetOfferSource.builder()
                                    .url("https://www.betfair.com/sport/football/german-cup/11458113")
                                    .description("DFB_POKAL")
                                    .eventCompetition(DFB_POKAL)
                                    .build(),

                            /* TURKEY */
                            BetfairThreeWayBetOfferSource.builder()
                                    .url("https://www.betfair.com/sport/football/turkish-1-lig/175680")
                                    .description("SUPER_LIG_TURKEY")
                                    .eventCompetition(SUPER_LIG_TURKEY)
                                    .build(),

                            /* PORTUGAL */
                            BetfairThreeWayBetOfferSource.builder()
                                    .url("https://www.betfair.com/sport/football/portuguese-primeira-liga/99")
                                    .description("PRIMIERA_LIGA_PORTUGAL")
                                    .eventCompetition(PRIMIERA_LIGA_PORTUGAL)
                                    .build(),

                            /* NETHERLANDS */
                            // TODO missing everdisise
                            BetfairThreeWayBetOfferSource.builder()
                                    .url("https://www.betfair.com/sport/football/dutch-eerste-divisie/11")
                                    .description("EERSTE_DIVISIE")
                                    .eventCompetition(EERSTE_DIVISIE)
                                    .build(),
                            BetfairThreeWayBetOfferSource.builder()
                                    .url("https://www.betfair.com/sport/football/dutch-cup/19513")
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
