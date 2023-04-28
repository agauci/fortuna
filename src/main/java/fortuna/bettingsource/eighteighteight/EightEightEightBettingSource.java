package fortuna.bettingsource.eighteighteight;

import com.google.common.collect.ImmutableList;
import fortuna.bettingsource.BetOfferSource;
import fortuna.bettingsource.BettingSource;
import fortuna.models.source.BettingSourceType;
import lombok.Builder;

import java.util.List;

import static fortuna.models.competition.FootballCompetition.*;
import static fortuna.models.source.Bookmaker.EIGHTEIGHTEIGHT;

@Builder
public class EightEightEightBettingSource extends BettingSource {

    private static List<BetOfferSource<?>> SOURCES =
            ImmutableList.<BetOfferSource<?>>builder()
                    .add(
                            /* ENGLAND */
                            EightEightEightThreeWayBetOfferSource.builder()
                                    .url("https://www.888sport.com/football/england/premier-league/")
                                    .description("PREMIER_LEAGUE")
                                    .eventCompetition(PREMIER_LEAGUE)
                                    .build(),
                            EightEightEightThreeWayBetOfferSource.builder()
                                    .url("https://www.888sport.com/football/england/the-championship/")
                                    .description("CHAMPIONSHIP")
                                    .eventCompetition(CHAMPIONSHIP)
                                    .build(),
                            EightEightEightThreeWayBetOfferSource.builder()
                                    .url("https://www.888sport.com/football/england/league-one/")
                                    .description("LEAGUE_ONE")
                                    .eventCompetition(LEAGUE_ONE)
                                    .build(),
                            EightEightEightThreeWayBetOfferSource.builder()
                                    .url("https://www.888sport.com/england/league-two/")
                                    .description("LEAGUE_TWO")
                                    .eventCompetition(LEAGUE_TWO)
                                    .build(),

                            /* ITALY */
                            EightEightEightThreeWayBetOfferSource.builder()
                                    .url("https://www.888sport.com/football/italy/serie-a/")
                                    .description("SERIE_A")
                                    .eventCompetition(SERIE_A)
                                    .build(),
                            EightEightEightThreeWayBetOfferSource.builder()
                                    .url("https://www.888sport.com/football/italy/italy-serie-b-t-319569/")
                                    .description("SERIE_B")
                                    .eventCompetition(SERIE_B)
                                    .build(),
                            EightEightEightThreeWayBetOfferSource.builder()
                                    .url("https://www.888sport.com/football/italy/coppa-italia-odds/")
                                    .description("COPPA_ITALIA")
                                    .eventCompetition(COPPA_ITALIA)
                                    .build(),

                            /* EUROPE */
                            EightEightEightThreeWayBetOfferSource.builder()
                                    .url("https://www.888sport.com/football/champions-league/")
                                    .description("CHAMPIONS_LEAGUE")
                                    .eventCompetition(CHAMPIONS_LEAGUE)
                                    .build(),
                            EightEightEightThreeWayBetOfferSource.builder()
                                    .url("https://www.888sport.com/football/europa-league/")
                                    .description("EUROPA_LEAGUE")
                                    .eventCompetition(EUROPA_LEAGUE)
                                    .build(),
                            EightEightEightThreeWayBetOfferSource.builder()
                                    .url("https://www.888sport.com/football/europe/uefa-europa-conference-league/")
                                    .description("CONFERENCE_LEAGUE")
                                    .eventCompetition(CONFERENCE_LEAGUE)
                                    .build(),

                            /* SPAIN */
                            EightEightEightThreeWayBetOfferSource.builder()
                                    .url("https://www.888sport.com/football/spain/la-liga/")
                                    .description("LA_LIGA")
                                    .eventCompetition(LA_LIGA)
                                    .build(),
                            EightEightEightThreeWayBetOfferSource.builder()
                                    .url("https://www.888sport.com/football/spain/spain-segunda-division/")
                                    .description("LA_LIGA_2")
                                    .eventCompetition(LA_LIGA_2)
                                    .build(),
                            EightEightEightThreeWayBetOfferSource.builder()
                                    .url("https://www.888sport.com/football/spain/copa-del-rey/")
                                    .description("COPA_DEL_REY")
                                    .eventCompetition(COPA_DEL_REY)
                                    .build(),

                            /* FRANCE */
                            EightEightEightThreeWayBetOfferSource.builder()
                                    .url("https://www.888sport.com/football/france/ligue-1/")
                                    .description("LIGUE_1")
                                    .eventCompetition(LIGUE_1)
                                    .build(),
                            EightEightEightThreeWayBetOfferSource.builder()
                                    .url("https://www.888sport.com/football/france/ligue-2/")
                                    .description("LIGUE_2")
                                    .eventCompetition(LIGUE_2)
                                    .build(),
                            EightEightEightThreeWayBetOfferSource.builder()
                                    .url("https://www.888sport.com/football/france/france-cup-t-319621/")
                                    .description("COUPE_DE_FRANCE")
                                    .eventCompetition(COUPE_DE_FRANCE)
                                    .build(),

                            /* GERMANY */
                            EightEightEightThreeWayBetOfferSource.builder()
                                    .url("https://www.888sport.com/football/germany/bundesliga/")
                                    .description("BUNDESLIGA")
                                    .eventCompetition(BUNDESLIGA)
                                    .build(),
                            EightEightEightThreeWayBetOfferSource.builder()
                                    .url("https://www.888sport.com/football/germany/2-bundesliga/")
                                    .description("BUNDESLIGA_2")
                                    .eventCompetition(BUNDESLIGA_2)
                                    .build(),
                            EightEightEightThreeWayBetOfferSource.builder()
                                    .url("https://www.888sport.com/football/germany/dfb-pokal/")
                                    .description("DFB_POKAL")
                                    .eventCompetition(DFB_POKAL)
                                    .build(),

                            /* TURKEY */
                            EightEightEightThreeWayBetOfferSource.builder()
                                    .url("https://www.888sport.com/football/turkey/turkey-super-lig-t-320219/")
                                    .description("SUPER_LIG_TURKEY")
                                    .eventCompetition(SUPER_LIG_TURKEY)
                                    .build(),

                            /* PORTUGAL */
                            EightEightEightThreeWayBetOfferSource.builder()
                                    .url("https://www.888sport.com/football/portugal/portugal-primeira-liga-t-320549/")
                                    .description("PRIMIERA_LIGA_PORTUGAL")
                                    .eventCompetition(PRIMIERA_LIGA_PORTUGAL)
                                    .build(),

                            /* NETHERLANDS */
                            // TODO Add everdisie once available
                            EightEightEightThreeWayBetOfferSource.builder()
                                    .url("https://www.888sport.com/football/netherlands/netherlands-eerste-divisie-t-319694/")
                                    .description("EERSTE_DIVISIE")
                                    .eventCompetition(EERSTE_DIVISIE)
                                    .build(),
                            EightEightEightThreeWayBetOfferSource.builder()
                                    .url("https://www.888sport.com/football/netherlands/netherlands-knvb-beker-t-321686/")
                                    .description("KNVB_CUP")
                                    .eventCompetition(KNVB_CUP)
                                    .build()
                    )
                    .build();

    @Override
    public BettingSourceType getType() {
        return EIGHTEIGHTEIGHT;
    }

    @Override
    public List<BetOfferSource<?>> sources() {
        return SOURCES;
    }
}
