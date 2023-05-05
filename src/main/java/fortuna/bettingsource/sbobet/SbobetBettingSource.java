package fortuna.bettingsource.sbobet;

import com.google.common.collect.ImmutableList;
import fortuna.bettingsource.BetOfferSource;
import fortuna.bettingsource.BettingSource;
import fortuna.models.source.BettingSourceType;
import lombok.Builder;

import java.util.List;

import static fortuna.models.competition.FootballCompetition.*;
import static fortuna.models.source.Bookmaker.SBOBET;

@Builder
public class SbobetBettingSource extends BettingSource {

    private static List<BetOfferSource<?>> SOURCES =
                ImmutableList.<BetOfferSource<?>>builder()
                        .add(
                            /* EUROPE */
                            SbobetThreeWayBetOfferSource.builder()
                                    .url("https://www.sbobet.com/euro/football/uefa-champions-league")
                                    .eventCompetition(CHAMPIONS_LEAGUE)
                                    .build(),
                            SbobetThreeWayBetOfferSource.builder()
                                    .url("https://www.sbobet.com/euro/football/uefa-europa-league")
                                    .eventCompetition(EUROPA_LEAGUE)
                                    .build(),
                            SbobetThreeWayBetOfferSource.builder()
                                    .url("https://www.sbobet.com/euro/football/uefa-europa-conference-league")
                                    .eventCompetition(CONFERENCE_LEAGUE)
                                    .build(),

                                /* ARGENTINA */
                                SbobetThreeWayBetOfferSource.builder()
                                        .url("https://www.sbobet.com/euro/football/argentina-liga-profesional")
                                        .eventCompetition(ARGENTINA_LEAGUE_1)
                                        .build(),
                                SbobetThreeWayBetOfferSource.builder()
                                        .url("https://www.sbobet.com/euro/football/argentina-primera-nacional")
                                        .eventCompetition(ARGENTINA_LEAGUE_2)
                                        .build(),

                            /* AUSTRIA */
                            SbobetThreeWayBetOfferSource.builder()
                                    .url("https://www.sbobet.com/en/euro/football/austria-bundesliga-playoff/2023-05-06")
                                    .eventCompetition(AUSTRIA_LEAGUE_1)
                                    .build(),
                            // TODO missing the relegation group?
                            SbobetThreeWayBetOfferSource.builder()
                                    .url("https://www.sbobet.com/euro/football/austria-2nd-liga")
                                    .eventCompetition(AUSTRIA_LEAGUE_2)
                                    .build(),
                            // TODO missing austria cup

                                /* BELGIUM */
                                SbobetThreeWayBetOfferSource.builder()
                                        .url("https://www.sbobet.com/euro/football/belgium-first-division-a-playoff")
                                        .eventCompetition(BELGIUM_FIRST_DIVISION_A_1)
                                        .build(),
                                SbobetThreeWayBetOfferSource.builder()
                                        .url("https://www.sbobet.com/euro/football/belgium-first-division-b-playoff")
                                        .eventCompetition(BELGIUM_FIRST_DIVISION_B_2)
                                        .build(),
                                // todo missing belgium cup

                                /* BRAZIL */
                                SbobetThreeWayBetOfferSource.builder()
                                        .url("https://www.sbobet.com/euro/football/brazil-serie-a")
                                        .eventCompetition(BRAZIL_LEAGUE_1)
                                        .build(),
                                SbobetThreeWayBetOfferSource.builder()
                                        .url("https://www.sbobet.com/euro/football/brazil-serie-b")
                                        .eventCompetition(BRAZIL_LEAGUE_2)
                                        .build(),

                                /* BULGARIA */
                                // TODO missing bulgaria league 1
                                SbobetThreeWayBetOfferSource.builder()
                                        .url("https://www.sbobet.com/euro/football/bulgaria-second-professional-football-league")
                                        .eventCompetition(BULGARIA_LEAGUE_2)
                                        .build(),

                                /* CROATIA */
                                SbobetThreeWayBetOfferSource.builder()
                                        .url("https://www.sbobet.com/euro/football/croatia-superliga")
                                        .eventCompetition(CROATIA_LEAGUE_1)
                                        .build(),
                                // Missing croatia league 2

                                /* CYPRUS */
                                SbobetThreeWayBetOfferSource.builder()
                                        .url("https://www.sbobet.com/euro/football/cyprus-1st-div-playoff")
                                        .eventCompetition(CYPRUS_LEAGUE_1)
                                        .build(),

                                /* CZECH REPUBLIC */
                                SbobetThreeWayBetOfferSource.builder()
                                        .url("https://www.sbobet.com/euro/football/czech-republic-first-league-playoff")
                                        .eventCompetition(CZECH_REPUBLIC_LEAGUE_1)
                                        .build(),
                                SbobetThreeWayBetOfferSource.builder()
                                        .url("https://www.sbobet.com/euro/football/czech-republic-national-football-league")
                                        .eventCompetition(CZECH_REPUBLIC_LEAGUE_2)
                                        .build(),

                                /* DENMARK */
                                SbobetThreeWayBetOfferSource.builder()
                                        .url("https://www.sbobet.com/euro/football/denmark-super-league-playoff")
                                        .eventCompetition(DENMARK_LEAGUE_1)
                                        .build(),
                                SbobetThreeWayBetOfferSource.builder()
                                        .url("https://www.sbobet.com/euro/football/denmark-1st-div-playoff")
                                        .eventCompetition(DENMARK_LEAGUE_2)
                                        .build(),
                                // Missing denmark cup

                                /* ENGLAND */
                                SbobetThreeWayBetOfferSource.builder()
                                        .url("https://www.sbobet.com/en/euro/football/english-premier-league")
                                        .eventCompetition(PREMIER_LEAGUE)
                                        .build(),
                                SbobetThreeWayBetOfferSource.builder()
                                        .url("https://www.sbobet.com/euro/football/english-championship")
                                        .eventCompetition(CHAMPIONSHIP)
                                        .build(),
                                SbobetThreeWayBetOfferSource.builder()
                                        .url("https://www.sbobet.com/euro/football/english-fa-cup")
                                        .eventCompetition(FA_CUP)
                                        .build(),
                                SbobetThreeWayBetOfferSource.builder()
                                        .url("https://www.sbobet.com/euro/football/english-league-one")
                                        .eventCompetition(LEAGUE_ONE)
                                        .build(),
                                SbobetThreeWayBetOfferSource.builder()
                                        .url("https://www.sbobet.com/euro/football/english-league-two")
                                        .eventCompetition(LEAGUE_TWO)
                                        .build(),

                                /* FRANCE */
                                SbobetThreeWayBetOfferSource.builder()
                                        .url("https://www.sbobet.com/euro/football/france-ligue-1")
                                        .eventCompetition(LIGUE_1)
                                        .build(),
                                SbobetThreeWayBetOfferSource.builder()
                                        .url("https://www.sbobet.com/euro/football/france-ligue-2")
                                        .eventCompetition(LIGUE_2)
                                        .build(),
                                // TODO missing france cup

                                /* GERMANY */
                                SbobetThreeWayBetOfferSource.builder()
                                        .url("https://www.sbobet.com/euro/football/germany-bundesliga")
                                        .eventCompetition(BUNDESLIGA)
                                        .build(),
                                SbobetThreeWayBetOfferSource.builder()
                                        .url("https://www.sbobet.com/euro/football/germany-bundesliga-2")
                                        .eventCompetition(BUNDESLIGA_2)
                                        .build(),
                                SbobetThreeWayBetOfferSource.builder()
                                        .url("https://www.sbobet.com/euro/football/germany-cup")
                                        .eventCompetition(DFB_POKAL)
                                        .build(),

                                /* GREECE */
                                SbobetThreeWayBetOfferSource.builder()
                                        .url("https://www.sbobet.com/euro/football/greece-super-league-playoff")
                                        .eventCompetition(GREECE_LEAGUE_1)
                                        .build(),
                                // TODO missing Greece League 2

                                /* IRELAND */
                                SbobetThreeWayBetOfferSource.builder()
                                        .url("https://www.sbobet.com/euro/football/ireland-premier-division")
                                        .eventCompetition(IRELAND_LEAGUE_1)
                                        .build(),
                                SbobetThreeWayBetOfferSource.builder()
                                        .url("https://www.sbobet.com/euro/football/ireland-1st-div")
                                        .eventCompetition(IRELAND_LEAGUE_2)
                                        .build(),

                                /* ISRAEL */
                                SbobetThreeWayBetOfferSource.builder()
                                        .url("https://www.sbobet.com/euro/football/israel-premier-league-playoff")
                                        .eventCompetition(ISRAEL_LEAGUE_1)
                                        .build(),

                                /* ITALY */
                                SbobetThreeWayBetOfferSource.builder()
                                        .url("https://www.sbobet.com/euro/football/italy-serie-a")
                                        .eventCompetition(SERIE_A)
                                        .build(),
                                SbobetThreeWayBetOfferSource.builder()
                                        .url("https://www.sbobet.com/euro/football/italy-serie-b")
                                        .eventCompetition(SERIE_B)
                                        .build(),
                                SbobetThreeWayBetOfferSource.builder()
                                        .url("https://www.sbobet.com/euro/football/italy-cup")
                                        .eventCompetition(COPPA_ITALIA)
                                        .build(),

                                /* JAPAN */
                                SbobetThreeWayBetOfferSource.builder()
                                        .url("https://www.sbobet.com/euro/football/japan-j1-league")
                                        .eventCompetition(JAPAN_LEAGUE_1)
                                        .build(),
                                SbobetThreeWayBetOfferSource.builder()
                                        .url("https://www.sbobet.com/euro/football/japan-j2-league")
                                        .eventCompetition(JAPAN_LEAGUE_2)
                                        .build(),
                                // TODO missing Japan league 3

                                /* MALTA */
                                // Missing Malta Cup

                                /* NETHERLANDS */
                                SbobetThreeWayBetOfferSource.builder()
                                        .url("https://www.sbobet.com/euro/football/netherlands-eredivisie")
                                        .eventCompetition(EVERDISIE)
                                        .build(),
                                SbobetThreeWayBetOfferSource.builder()
                                        .url("https://www.sbobet.com/euro/football/netherlands-eerste-divisie")
                                        .eventCompetition(EERSTE_DIVISIE)
                                        .build(),
                                // TODO missing netherlands cup

                                /* NORWAY */
                                SbobetThreeWayBetOfferSource.builder()
                                        .url("https://www.sbobet.com/euro/football/norway-eliteserien")
                                        .eventCompetition(NORWAY_LEAGUE_1)
                                        .build(),
                                SbobetThreeWayBetOfferSource.builder()
                                        .url("https://www.sbobet.com/euro/football/norway-1st-div")
                                        .eventCompetition(NORWAY_LEAGUE_2)
                                        .build(),

                                /* POLAND */
                                SbobetThreeWayBetOfferSource.builder()
                                        .url("https://www.sbobet.com/euro/football/poland-ekstraklasa")
                                        .eventCompetition(POLAND_LEAGUE_1)
                                        .build(),
                                SbobetThreeWayBetOfferSource.builder()
                                        .url("https://www.sbobet.com/euro/football/poland-1st-liga")
                                        .eventCompetition(POLAND_LEAGUE_2)
                                        .build(),
                                // TODO missing poland cup

                                /* PORTUGAL */
                                SbobetThreeWayBetOfferSource.builder()
                                        .url("https://www.sbobet.com/en/euro/football/liga-portugal")
                                        .eventCompetition(PRIMIERA_LIGA_PORTUGAL)
                                        .build(),
                                SbobetThreeWayBetOfferSource.builder()
                                        .url("https://www.sbobet.com/euro/football/liga-portugal-2")
                                        .eventCompetition(PORTUGAL_LEAGUE_2)
                                        .build(),
                                SbobetThreeWayBetOfferSource.builder()
                                        .url("https://www.pinnacle.bet/en/soccer/portugal-cup/matchups/#period:0")
                                        .eventCompetition(PORTUGAL_CUP)
                                        .build(),

                                /* SCOTLAND */
                                SbobetThreeWayBetOfferSource.builder()
                                        .url("https://www.sbobet.com/euro/football/scotland-premiership-playoff")
                                        .eventCompetition(SCOTLAND_PREMIER_LEAGUE)
                                        .build(),
                                SbobetThreeWayBetOfferSource.builder()
                                        .url("https://www.sbobet.com/euro/football/scotland-championship")
                                        .eventCompetition(SCOTLAND_CHAMPIONSHIP)
                                        .build(),
                                SbobetThreeWayBetOfferSource.builder()
                                        .url("https://www.sbobet.com/euro/football/scotland-league-1")
                                        .eventCompetition(SCOTLAND_LEAGUE_ONE)
                                        .build(),
                                SbobetThreeWayBetOfferSource.builder()
                                        .url("https://www.sbobet.com/euro/football/scotland-league-2")
                                        .eventCompetition(SCOTLAND_LEAGUE_TWO)
                                        .build(),
                                // TODO missing scotland league cup

                                /* SPAIN */
                                SbobetThreeWayBetOfferSource.builder()
                                        .url("https://www.sbobet.com/euro/football/spain-la-liga")
                                        .eventCompetition(LA_LIGA)
                                        .build(),
                                SbobetThreeWayBetOfferSource.builder()
                                        .url("https://www.sbobet.com/euro/football/spain-la-liga-2")
                                        .eventCompetition(LA_LIGA_2)
                                        .build(),
                                SbobetThreeWayBetOfferSource.builder()
                                        .url("https://www.sbobet.com/euro/football/spain-cup")
                                        .eventCompetition(COPA_DEL_REY)
                                        .build(),

                                /* SWEDEN */
                                SbobetThreeWayBetOfferSource.builder()
                                        .url("https://www.sbobet.com/euro/football/sweden-allsvenskan")
                                        .eventCompetition(SWEDEN_LEAGUE_1)
                                        .build(),
                                SbobetThreeWayBetOfferSource.builder()
                                        .url("https://www.sbobet.com/euro/football/sweden-superettan")
                                        .eventCompetition(SWEDEN_LEAGUE_2)
                                        .build(),
                                // TODO missing sweden cup

                                /* SWITZERLAND */
                                SbobetThreeWayBetOfferSource.builder()
                                        .url("https://www.sbobet.com/euro/football/swiss-super-league")
                                        .eventCompetition(SWITZERLAND_SUPER_LEAGUE_1)
                                        .build(),
                                SbobetThreeWayBetOfferSource.builder()
                                        .url("https://www.sbobet.com/euro/football/swiss-challenge-league")
                                        .eventCompetition(SWITZERLAND_CHALLENGE_LEAGUE_2)
                                        .build(),
                                // TODO missing switzerland promotion league

                                /* TURKEY */
                                SbobetThreeWayBetOfferSource.builder()
                                        .url("https://www.sbobet.com/euro/football/turkey-super-league")
                                        .eventCompetition(SUPER_LIG_TURKEY)
                                        .build(),
                                SbobetThreeWayBetOfferSource.builder()
                                        .url("https://www.sbobet.com/euro/football/turkey-1st-lig")
                                        .eventCompetition(TURKEY_LEAGUE_2)
                                        .build(),
                                // TODO missing turkey cup

                                /* UKRAINE */
                                SbobetThreeWayBetOfferSource.builder()
                                        .url("https://www.sbobet.com/euro/football/ukraine-premier-league")
                                        .eventCompetition(UKRAINE_LEAGUE_1)
                                        .build(),

                                /* MLS */
                                SbobetThreeWayBetOfferSource.builder()
                                        .url("https://www.sbobet.com/euro/football/usa-major-league-soccer")
                                        .eventCompetition(MLS)
                                        .build()

                        )
                    .build();

    @Override
    public BettingSourceType getType() {
        return SBOBET;
    }

    @Override
    public List<BetOfferSource<?>> sources() {
        return SOURCES;
    }
}
