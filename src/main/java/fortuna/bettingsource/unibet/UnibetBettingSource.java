package fortuna.bettingsource.unibet;

import com.google.common.collect.ImmutableList;
import fortuna.bettingsource.BetOfferSource;
import fortuna.bettingsource.BettingSource;
import fortuna.models.source.BettingSourceType;
import lombok.Builder;

import java.util.List;

import static fortuna.models.competition.FootballCompetition.*;
import static fortuna.models.source.Bookmaker.UNIBET;
@Builder
public class UnibetBettingSource extends BettingSource {

    private static List<BetOfferSource<?>> SOURCES =
            ImmutableList.<BetOfferSource<?>>builder()
                    .add(
                            /* EUROPE */
                            UnibetThreeWayBetOfferSource.builder()
                                    .url("https://www.unibet.com/betting/sports/filter/football/champions_league/all/matches")
                                    .description("CHAMPIONS_LEAGUE")
                                    .eventCompetition(CHAMPIONS_LEAGUE)
                                    .build(),
                            UnibetThreeWayBetOfferSource.builder()
                                    .url("https://www.unibet.com/betting/sports/filter/football/europa_league/all/matches")
                                    .description("EUROPA_LEAGUE")
                                    .eventCompetition(EUROPA_LEAGUE)
                                    .build(),
                            UnibetThreeWayBetOfferSource.builder()
                                    .url("https://www.unibet.com/betting/sports/filter/football/europa_conference_league/all/matches")
                                    .description("CONFERENCE_LEAGUE")
                                    .eventCompetition(CONFERENCE_LEAGUE)
                                    .build(),

                            /* ENGLAND */
                            UnibetThreeWayBetOfferSource.builder()
                                    .url("https://www.unibet.com/betting/sports/filter/football/england/premier_league/all/matches")
                                    .description("PREMIER_LEAGUE")
                                    .eventCompetition(PREMIER_LEAGUE)
                                    .build(),
                            UnibetThreeWayBetOfferSource.builder()
                                    .url("https://www.unibet.com/betting/sports/filter/football/england/fa_cup/all/matches")
                                    .description("FA_CUP")
                                    .eventCompetition(FA_CUP)
                                    .build(),
                            UnibetThreeWayBetOfferSource.builder()
                                    .url("https://www.unibet.com/betting/sports/filter/football/england/the_championship/all/matches")
                                    .description("CHAMPIONSHIP")
                                    .eventCompetition(CHAMPIONSHIP)
                                    .build(),
                            UnibetThreeWayBetOfferSource.builder()
                                    .url("https://www.unibet.com/betting/sports/filter/football/england/league_one/all/matches")
                                    .description("LEAGUE_ONE")
                                    .eventCompetition(LEAGUE_ONE)
                                    .build(),
                            UnibetThreeWayBetOfferSource.builder()
                                    .url("https://www.unibet.com/betting/sports/filter/football/england/league_two/all/matches")
                                    .description("LEAGUE_TWO")
                                    .eventCompetition(LEAGUE_TWO)
                                    .build(),

                            /* ITALY */
                            UnibetThreeWayBetOfferSource.builder()
                                    .url("https://www.unibet.com/betting/sports/filter/football/italy/serie_a/all/matches")
                                    .description("SERIE_A")
                                    .eventCompetition(SERIE_A)
                                    .build(),
                            UnibetThreeWayBetOfferSource.builder()
                                    .url("https://www.unibet.com/betting/sports/filter/football/italy/serie_b/all/matches")
                                    .description("SERIE_B")
                                    .eventCompetition(SERIE_B)
                                    .build(),
                            UnibetThreeWayBetOfferSource.builder()
                                    .url("https://www.unibet.com/betting/sports/filter/football/italy/coppa_italia/all/matches")
                                    .description("COPPA_ITALIA")
                                    .eventCompetition(COPPA_ITALIA)
                                    .build(),

                            /* SPAIN */
                            UnibetThreeWayBetOfferSource.builder()
                                    .url("https://www.unibet.com/betting/sports/filter/football/spain/la_liga/all/matches")
                                    .description("LA_LIGA")
                                    .eventCompetition(LA_LIGA)
                                    .build(),
                            UnibetThreeWayBetOfferSource.builder()
                                    .url("https://www.unibet.com/betting/sports/filter/football/spain/la_liga_2/all/matches")
                                    .description("LA_LIGA_2")
                                    .eventCompetition(LA_LIGA_2)
                                    .build(),
                            UnibetThreeWayBetOfferSource.builder()
                                    .url("https://www.unibet.com/betting/sports/filter/football/spain/copa_del_rey/all/matches")
                                    .description("COPA_DEL_REY")
                                    .eventCompetition(COPA_DEL_REY)
                                    .build(),

                            /* FRANCE */
                            UnibetThreeWayBetOfferSource.builder()
                                    .url("https://www.unibet.com/betting/sports/filter/football/france/ligue_1/all/matches")
                                    .description("LIGUE_1")
                                    .eventCompetition(LIGUE_1)
                                    .build(),
                            UnibetThreeWayBetOfferSource.builder()
                                    .url("https://www.unibet.com/betting/sports/filter/football/france/ligue_2/all/matches")
                                    .description("LIGUE_2")
                                    .eventCompetition(LIGUE_2)
                                    .build(),
                            UnibetThreeWayBetOfferSource.builder()
                                    .url("https://www.unibet.com/betting/sports/filter/football/france/coupe_de_france/all/matches")
                                    .description("COUPE_DE_FRANCE")
                                    .eventCompetition(COUPE_DE_FRANCE)
                                    .build(),

                            /* GERMANY */
                            UnibetThreeWayBetOfferSource.builder()
                                    .url("https://www.unibet.com/betting/sports/filter/football/germany/bundesliga/all/matches")
                                    .description("BUNDESLIGA")
                                    .eventCompetition(BUNDESLIGA)
                                    .build(),
                            UnibetThreeWayBetOfferSource.builder()
                                    .url("https://www.unibet.com/betting/sports/filter/football/germany/2__bundesliga/all/matches")
                                    .description("BUNDESLIGA_2")
                                    .eventCompetition(BUNDESLIGA_2)
                                    .build(),
                            UnibetThreeWayBetOfferSource.builder()
                                    .url("https://www.unibet.com/betting/sports/filter/football/germany/dfb_pokal/all/matches")
                                    .description("DFB_POKAL")
                                    .eventCompetition(DFB_POKAL)
                                    .build(),

                            /* TURKEY */
                            UnibetThreeWayBetOfferSource.builder()
                                    .url("https://www.unibet.com/betting/sports/filter/football/turkey/super_lig/all/matches")
                                    .description("SUPER_LIG_TURKEY")
                                    .eventCompetition(SUPER_LIG_TURKEY)
                                    .build(),

                            /* PORTUGAL */
                            UnibetThreeWayBetOfferSource.builder()
                                    .url("https://www.unibet.com/betting/sports/filter/football/portugal/primeira_liga/all/matches")
                                    .description("PRIMIERA_LIGA_PORTUGAL")
                                    .eventCompetition(PRIMIERA_LIGA_PORTUGAL)
                                    .build(),

                            /* NETHERLANDS */
                            UnibetThreeWayBetOfferSource.builder()
                                    .url("https://www.unibet.com/betting/sports/filter/football/netherlands/eredivisie/all/matches")
                                    .description("EVERDISIE")
                                    .eventCompetition(EVERDISIE)
                                    .build(),
                            UnibetThreeWayBetOfferSource.builder()
                                    .url("https://www.unibet.com/betting/sports/filter/football/netherlands/eerste_divisie/all/matches")
                                    .description("EERSTE_DIVISIE")
                                    .eventCompetition(EERSTE_DIVISIE)
                                    .build(),
                            UnibetThreeWayBetOfferSource.builder()
                                    .url("https://www.unibet.com/betting/sports/filter/football/netherlands/knvb_beker/all/matches")
                                    .description("KNVB_CUP")
                                    .eventCompetition(KNVB_CUP)
                                    .build()
                    )
                    .build();

    @Override
    public BettingSourceType getType() {
        return UNIBET;
    }

    @Override
    public List<BetOfferSource<?>> sources() {
        return SOURCES;
    }
}
