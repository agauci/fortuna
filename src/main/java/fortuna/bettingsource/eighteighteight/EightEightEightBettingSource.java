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
                            EightEightEightThreeWayBetOfferSource.builder()
                                    .url("https://www.888sport.com/football/turkey/turkey-1-lig-t-320221/")
                                    .eventCompetition(TURKEY_LEAGUE_2)
                                    .build(),
                            // TODO missing turkey cup

                            /* PORTUGAL */
                            EightEightEightThreeWayBetOfferSource.builder()
                                    .url("https://www.888sport.com/football/portugal/portugal-primeira-liga-t-320549/")
                                    .description("PRIMIERA_LIGA_PORTUGAL")
                                    .eventCompetition(PRIMIERA_LIGA_PORTUGAL)
                                    .build(),
                            EightEightEightThreeWayBetOfferSource.builder()
                                    .url("https://www.888sport.com/football/portugal/portugal-primeira-liga-t-320549/")
                                    .eventCompetition(PORTUGAL_LEAGUE_2)
                                    .build(),
                            EightEightEightThreeWayBetOfferSource.builder()
                                    .url("https://www.888sport.com/football/portugal/portugal-cup-t-320545/")
                                    .eventCompetition(PORTUGAL_CUP)
                                    .build(),

                            /* NETHERLANDS */
                            EightEightEightThreeWayBetOfferSource.builder()
                                    .url("https://www.888sport.com/football/netherlands/eredivisie/")
                                    .description("EERSTE_DIVISIE")
                                    .eventCompetition(EERSTE_DIVISIE)
                                    .build(),
                            EightEightEightThreeWayBetOfferSource.builder()
                                    .url("https://www.888sport.com/football/netherlands/netherlands-eerste-divisie-t-319694/")
                                    .description("EERSTE_DIVISIE")
                                    .eventCompetition(EERSTE_DIVISIE)
                                    .build(),
                            EightEightEightThreeWayBetOfferSource.builder()
                                    .url("https://www.888sport.com/football/netherlands/netherlands-knvb-beker-t-321686/")
                                    .description("KNVB_CUP")
                                    .eventCompetition(KNVB_CUP)
                                    .build(),

                            /* AUSTRIA */
                            EightEightEightThreeWayBetOfferSource.builder()
                                    .url("https://www.888sport.com/football/austria/bundesliga/")
                                    .eventCompetition(AUSTRIA_LEAGUE_1)
                                    .build(),
                            EightEightEightThreeWayBetOfferSource.builder()
                                    .url("https://www.888sport.com/football/austria/austria-2-liga-t-322735/")
                                    .eventCompetition(AUSTRIA_LEAGUE_2)
                                    .build(),
                            EightEightEightThreeWayBetOfferSource.builder()
                                    .url("https://www.888sport.com/football/austria/austria-ofb-cup-t-320401/")
                                    .eventCompetition(AUSTRIA_OFB_CUP)
                                    .build(),

                            /* ARGENTINA */
                            EightEightEightThreeWayBetOfferSource.builder()
                                    .url("https://www.888sport.com/football/argentina/argentina-superliga-t-153362/")
                                    .eventCompetition(ARGENTINA_LEAGUE_1)
                                    .build(),
                            EightEightEightThreeWayBetOfferSource.builder()
                                    .url("https://www.888sport.com/football/argentina/argentina-primera-nacional-t-320380/")
                                    .eventCompetition(ARGENTINA_LEAGUE_2)
                                    .build(),

                            /* BELGIUM */
                            EightEightEightThreeWayBetOfferSource.builder()
                                    .url("https://www.888sport.com/football/belgium/")
                                    .eventCompetition(BELGIUM_FIRST_DIVISION_A_1)
                                    .build(),
                            EightEightEightThreeWayBetOfferSource.builder()
                                    .url("https://www.888sport.com/football/belgium/belgium-first-division-b-t-320080/")
                                    .eventCompetition(BELGIUM_FIRST_DIVISION_B_2)
                                    .build(),
                            EightEightEightThreeWayBetOfferSource.builder()
                                    .url("https://www.888sport.com/football/belgium/belgium-cup-t-320073/")
                                    .eventCompetition(BELGIUM_CUP)
                                    .build(),

                            /* BULGARIA */
                            EightEightEightThreeWayBetOfferSource.builder()
                                    .url("https://www.888sport.com/football/bulgaria/bulgaria-first-division-t-321524/")
                                    .eventCompetition(BULGARIA_LEAGUE_1)
                                    .build(),
                            // TODO missing bulgaria league 2

                            /* BRAZIL */
                            EightEightEightThreeWayBetOfferSource.builder()
                                    .url("https://www.888sport.com/football/brazil/serie-a/")
                                    .eventCompetition(BRAZIL_LEAGUE_1)
                                    .build(),
                            EightEightEightThreeWayBetOfferSource.builder()
                                    .url("https://www.888sport.com/football/brazil/brazil-serie-b/")
                                    .eventCompetition(BRAZIL_LEAGUE_2)
                                    .build(),

                            /* CROATIA */
                            EightEightEightThreeWayBetOfferSource.builder()
                                    .url("https://www.888sport.com/football/croatia/croatia-first-division-t-152936/")
                                    .eventCompetition(CROATIA_LEAGUE_1)
                                    .build(),
                            EightEightEightThreeWayBetOfferSource.builder()
                                    .url("https://www.888sport.com/football/croatia/croatia-second-division-t-322773/")
                                    .eventCompetition(CROATIA_LEAGUE_2)
                                    .build(),

                            /* CYPRUS */
                            EightEightEightThreeWayBetOfferSource.builder()
                                    .url("https://www.888sport.com/football/cyprus/cyprus-1-division-t-320220/")
                                    .eventCompetition(CYPRUS_LEAGUE_1)
                                    .build(),

                            /* CZECH REPUBLIC */
                            EightEightEightThreeWayBetOfferSource.builder()
                                    .url("https://www.888sport.com/football/czech-republic/czech-republic-premier-league-t-321528/")
                                    .eventCompetition(CZECH_REPUBLIC_LEAGUE_1)
                                    .build(),
                            EightEightEightThreeWayBetOfferSource.builder()
                                    .url("https://www.888sport.com/football/czech-republic/czech-republic-second-divison-t-323559/")
                                    .eventCompetition(CZECH_REPUBLIC_LEAGUE_2)
                                    .build(),
                            EightEightEightThreeWayBetOfferSource.builder()
                                    .url("https://www.888sport.com/football/czech-republic/czech-republic-cup-t-328131/")
                                    .eventCompetition(CZECH_REPUBLIC_CUP)
                                    .build(),

                            /* DENMARK */
                            EightEightEightThreeWayBetOfferSource.builder()
                                    .url("https://www.888sport.com/football/denmark/superligaen/")
                                    .eventCompetition(DENMARK_LEAGUE_1)
                                    .build(),
                            EightEightEightThreeWayBetOfferSource.builder()
                                    .url("https://www.888sport.com/football/denmark/denmark-1division-t-323159/")
                                    .eventCompetition(DENMARK_LEAGUE_2)
                                    .build(),

                            /* GREECE */
                            EightEightEightThreeWayBetOfferSource.builder()
                                    .url("https://www.888sport.com/football/greece/greece-super-league-t-320509/")
                                    .eventCompetition(GREECE_LEAGUE_1)
                                    .build(),
                            EightEightEightThreeWayBetOfferSource.builder()
                                    .url("https://www.888sport.com/football/greece/greece-super-league-2-t-320230/")
                                    .eventCompetition(GREECE_LEAGUE_2)
                                    .build(),

                            /* IRELAND */
                            EightEightEightThreeWayBetOfferSource.builder()
                                    .url("https://www.888sport.com/football/ireland/ireland-premier-division-t-321690/")
                                    .eventCompetition(IRELAND_LEAGUE_1)
                                    .build(),
                            EightEightEightThreeWayBetOfferSource.builder()
                                    .url("https://www.888sport.com/football/ireland/ireland-first-division-t-322768/")
                                    .eventCompetition(IRELAND_LEAGUE_2)
                                    .build(),

                            /* ISRAEL */
                            // Missing isreal league 1

                            /* JAPAN */
                            EightEightEightThreeWayBetOfferSource.builder()
                                    .url("https://www.888sport.com/football/japan/japan-j-league-t-322628/")
                                    .eventCompetition(JAPAN_LEAGUE_1)
                                    .build(),
                            EightEightEightThreeWayBetOfferSource.builder()
                                    .url("https://www.888sport.com/football/japan/japan-j-league-2-t-328711/")
                                    .eventCompetition(JAPAN_LEAGUE_2)
                                    .build(),
                            EightEightEightThreeWayBetOfferSource.builder()
                                    .url("https://www.888sport.com/football/japan/japan-j-league-3-t-328834/")
                                    .eventCompetition(JAPAN_LEAGUE_3)
                                    .build(),

                            /* NORWAY */
                            EightEightEightThreeWayBetOfferSource.builder()
                                    .url("https://www.888sport.com/football/norway/obos-ligaen/")
                                    .eventCompetition(NORWAY_LEAGUE_1)
                                    .build(),
                            EightEightEightThreeWayBetOfferSource.builder()
                                    .url("https://www.888sport.com/football/norway/norway-first-division-t-329065/")
                                    .eventCompetition(NORWAY_LEAGUE_2)
                                    .build(),

                            /* POLAND */
                            EightEightEightThreeWayBetOfferSource.builder()
                                    .url("https://www.888sport.com/football/poland/poland-ekstraklasa-t-320563/")
                                    .eventCompetition(POLAND_LEAGUE_1)
                                    .build(),
                            EightEightEightThreeWayBetOfferSource.builder()
                                    .url("https://www.888sport.com/football/poland/poland-first-league-t-323266/")
                                    .eventCompetition(POLAND_LEAGUE_2)
                                    .build(),
                            EightEightEightThreeWayBetOfferSource.builder()
                                    .url("https://www.888sport.com/football/poland/poland-cup-t-323711/")
                                    .eventCompetition(POLAND_CUP)
                                    .build(),

                            /* SCOTLAND */
                            EightEightEightThreeWayBetOfferSource.builder()
                                    .url("https://www.888sport.com/football/scotland/scottish-premiership/")
                                    .eventCompetition(SCOTLAND_PREMIER_LEAGUE)
                                    .build(),
                            EightEightEightThreeWayBetOfferSource.builder()
                                    .url("https://www.888sport.com/football/scotland/scotland-championship-t-320615/")
                                    .eventCompetition(SCOTLAND_CHAMPIONSHIP)
                                    .build(),
                            EightEightEightThreeWayBetOfferSource.builder()
                                    .url("https://www.888sport.com/football/scotland/scotland-league-one-t-320621/")
                                    .eventCompetition(SCOTLAND_LEAGUE_ONE)
                                    .build(),
                            EightEightEightThreeWayBetOfferSource.builder()
                                    .url("https://www.888sport.com/football/scotland/scotland-league-two-t-320623/")
                                    .eventCompetition(SCOTLAND_LEAGUE_TWO)
                                    .build(),
                            EightEightEightThreeWayBetOfferSource.builder()
                                    .url("https://www.888sport.com/football/scotland/scotland-fa-cup-t-320619/")
                                    .eventCompetition(SCOTLAND_FA_CUP)
                                    .build(),

                            /* SWEDEN */
                            EightEightEightThreeWayBetOfferSource.builder()
                                    .url("https://www.888sport.com/football/sweden/allsvenskan/")
                                    .eventCompetition(SWEDEN_LEAGUE_1)
                                    .build(),
                            EightEightEightThreeWayBetOfferSource.builder()
                                    .url("https://www.888sport.com/football/sweden/sweden-superettan-t-327714/")
                                    .eventCompetition(SWEDEN_LEAGUE_2)
                                    .build(),
                            // TODO missing sweden cup

                            /* SWITZERLAND */
                            EightEightEightThreeWayBetOfferSource.builder()
                                    .url("https://www.888sport.com/football/switzerland/switzerland-super-league-t-320642/")
                                    .eventCompetition(SWITZERLAND_SUPER_LEAGUE_1)
                                    .build(),
                            EightEightEightThreeWayBetOfferSource.builder()
                                    .url("https://www.888sport.com/football/switzerland/switzerland-challenge-league-t-320644/")
                                    .eventCompetition(SWITZERLAND_CHALLENGE_LEAGUE_2)
                                    .build(),
                            // TODO missing switzerland league 3

                            /* UKRAINE */
                            // TODO ukraine league

                            /* USA */
                            EightEightEightThreeWayBetOfferSource.builder()
                                    .url("https://www.888sport.com/football/united-states-of-america/us-major-league-soccer/")
                                    .eventCompetition(MLS)
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
