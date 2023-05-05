package fortuna.bettingsource.pinnacle;

import com.google.common.collect.ImmutableList;
import fortuna.bettingsource.BetOfferSource;
import fortuna.bettingsource.BettingSource;
import fortuna.models.source.BettingSourceType;
import lombok.Builder;

import java.util.List;

import static fortuna.models.competition.FootballCompetition.*;
import static fortuna.models.source.Bookmaker.PINNACLE;

@Builder
public class PinnacleBettingSource extends BettingSource {

    private static List<BetOfferSource<?>> SOURCES =
                ImmutableList.<BetOfferSource<?>>builder()
                        .add(
                            /* EUROPE */
                            PinnacleThreeWayBetOfferSource.builder()
                                    .url("https://www.pinnacle.bet/en/soccer/uefa-champions-league/matchups/#all")
                                    .eventCompetition(CHAMPIONS_LEAGUE)
                                    .build(),
                            PinnacleThreeWayBetOfferSource.builder()
                                    .url("https://www.pinnacle.bet/en/soccer/uefa-europa-league/matchups/#all")
                                    .eventCompetition(EUROPA_LEAGUE)
                                    .build(),
                            PinnacleThreeWayBetOfferSource.builder()
                                    .url("https://www.pinnacle.bet/en/soccer/uefa-europa-conference-league/matchups/#period:0")
                                    .eventCompetition(CONFERENCE_LEAGUE)
                                    .build(),

                                /* ARGENTINA */
                                PinnacleThreeWayBetOfferSource.builder()
                                        .url("https://www.pinnacle.bet/en/soccer/argentina-liga-pro/matchups/#period:0")
                                        .eventCompetition(ARGENTINA_LEAGUE_1)
                                        .build(),
                                PinnacleThreeWayBetOfferSource.builder()
                                        .url("https://www.pinnacle.bet/en/soccer/argentina-primera-b-nacional/matchups/#period:0")
                                        .eventCompetition(ARGENTINA_LEAGUE_2)
                                        .build(),

                            /* AUSTRIA */
                            PinnacleThreeWayBetOfferSource.builder()
                                    .url("https://www.pinnacle.bet/en/soccer/austria-bundesliga/matchups/#period:0")
                                    .eventCompetition(AUSTRIA_LEAGUE_1)
                                    .build(),
                            PinnacleThreeWayBetOfferSource.builder()
                                    .url("https://www.pinnacle.bet/en/soccer/austria-2-liga/matchups/#period:0")
                                    .eventCompetition(AUSTRIA_LEAGUE_2)
                                    .build(),
                            // TODO missing austria cup

                                /* BELGIUM */
                                PinnacleThreeWayBetOfferSource.builder()
                                        .url("https://www.pinnacle.bet/en/soccer/belgium-first-division-a/matchups/#period:0")
                                        .eventCompetition(BELGIUM_FIRST_DIVISION_A_1)
                                        .build(),
                                PinnacleThreeWayBetOfferSource.builder()
                                        .url("https://www.pinnacle.bet/en/soccer/belgium-challenger-pro-league/matchups/#period:0")
                                        .eventCompetition(BELGIUM_FIRST_DIVISION_B_2)
                                        .build(),
                                // todo missing belgium cup

                                /* BRAZIL */
                                PinnacleThreeWayBetOfferSource.builder()
                                        .url("https://www.pinnacle.bet/en/soccer/brazil-serie-a/matchups/#period:0")
                                        .eventCompetition(BRAZIL_LEAGUE_1)
                                        .build(),
                                PinnacleThreeWayBetOfferSource.builder()
                                        .url("https://www.pinnacle.bet/en/soccer/brazil-serie-b/matchups/#period:0")
                                        .eventCompetition(BRAZIL_LEAGUE_2)
                                        .build(),

                                /* BULGARIA */
                                PinnacleThreeWayBetOfferSource.builder()
                                        .url("https://www.pinnacle.bet/en/soccer/bulgaria-first-league/matchups/#period:0")
                                        .eventCompetition(BULGARIA_LEAGUE_1)
                                        .build(),
                                PinnacleThreeWayBetOfferSource.builder()
                                        .url("https://www.pinnacle.bet/en/soccer/bulgaria-second-league/matchups/#period:0")
                                        .eventCompetition(BULGARIA_LEAGUE_2)
                                        .build(),

                                /* CROATIA */
                                PinnacleThreeWayBetOfferSource.builder()
                                        .url("https://www.pinnacle.bet/en/soccer/croatia-hnl/matchups/#period:0")
                                        .eventCompetition(CROATIA_LEAGUE_1)
                                        .build(),
                                PinnacleThreeWayBetOfferSource.builder()
                                        .url("https://www.pinnacle.bet/en/soccer/croatia-prva-nl/matchups/#period:0")
                                        .eventCompetition(CROATIA_LEAGUE_2)
                                        .build(),

                                /* CYPRUS */
                                PinnacleThreeWayBetOfferSource.builder()
                                        .url("https://www.pinnacle.bet/en/soccer/cyprus-1st-division/matchups/#period:0")
                                        .eventCompetition(CYPRUS_LEAGUE_1)
                                        .build(),

                                /* CZECH REPUBLIC */
                                PinnacleThreeWayBetOfferSource.builder()
                                        .url("https://www.pinnacle.bet/en/soccer/czech-republic-czech-liga/matchups/#period:0")
                                        .eventCompetition(CZECH_REPUBLIC_LEAGUE_1)
                                        .build(),
                                PinnacleThreeWayBetOfferSource.builder()
                                        .url("https://www.pinnacle.bet/en/soccer/czech-republic-fnl/matchups/#period:0")
                                        .eventCompetition(CZECH_REPUBLIC_LEAGUE_2)
                                        .build(),

                                /* DENMARK */
                                PinnacleThreeWayBetOfferSource.builder()
                                        .url("https://www.pinnacle.bet/en/soccer/denmark-superliga/matchups/#period:0")
                                        .eventCompetition(DENMARK_LEAGUE_1)
                                        .build(),
                                PinnacleThreeWayBetOfferSource.builder()
                                        .url("https://www.pinnacle.bet/en/soccer/denmark-division-1/matchups/#period:0")
                                        .eventCompetition(DENMARK_LEAGUE_2)
                                        .build(),
                                PinnacleThreeWayBetOfferSource.builder()
                                        .url("https://www.pinnacle.bet/en/soccer/denmark-cup/matchups/#period:0")
                                        .eventCompetition(DENMARK_CUP)
                                        .build(),

                                /* ENGLAND */
                                PinnacleThreeWayBetOfferSource.builder()
                                        .url("https://www.pinnacle.bet/en/soccer/england-premier-league/matchups/#period:0")
                                        .eventCompetition(PREMIER_LEAGUE)
                                        .build(),
                                PinnacleThreeWayBetOfferSource.builder()
                                        .url("https://www.pinnacle.bet/en/soccer/england-championship/matchups/#period:0")
                                        .eventCompetition(CHAMPIONSHIP)
                                        .build(),
                                PinnacleThreeWayBetOfferSource.builder()
                                        .url("https://www.pinnacle.bet/en/soccer/england-fa-cup/matchups/#all")
                                        .eventCompetition(FA_CUP)
                                        .build(),
                                PinnacleThreeWayBetOfferSource.builder()
                                        .url("https://www.pinnacle.bet/en/soccer/england-league-1/matchups/#all")
                                        .eventCompetition(LEAGUE_ONE)
                                        .build(),
                                PinnacleThreeWayBetOfferSource.builder()
                                        .url("https://www.pinnacle.bet/en/soccer/england-league-2/matchups/#all")
                                        .eventCompetition(LEAGUE_TWO)
                                        .build(),

                                /* FRANCE */
                                PinnacleThreeWayBetOfferSource.builder()
                                        .url("https://www.pinnacle.bet/en/soccer/france-ligue-1/matchups/#period:0")
                                        .eventCompetition(LIGUE_1)
                                        .build(),
                                PinnacleThreeWayBetOfferSource.builder()
                                        .url("https://www.pinnacle.bet/en/soccer/france-ligue-2/matchups/#period:0")
                                        .eventCompetition(LIGUE_2)
                                        .build(),
                                // TODO missing france cup

                                /* GERMANY */
                                PinnacleThreeWayBetOfferSource.builder()
                                        .url("https://www.pinnacle.bet/en/soccer/germany-bundesliga/matchups/#period:0")
                                        .eventCompetition(BUNDESLIGA)
                                        .build(),
                                PinnacleThreeWayBetOfferSource.builder()
                                        .url("https://www.pinnacle.bet/en/soccer/germany-bundesliga-2/matchups/#period:0")
                                        .eventCompetition(BUNDESLIGA_2)
                                        .build(),
                                // TODO missing germany cup

                                /* GREECE */
                                PinnacleThreeWayBetOfferSource.builder()
                                        .url("https://www.pinnacle.bet/en/soccer/greece-super-league/matchups/#period:0")
                                        .eventCompetition(GREECE_LEAGUE_1)
                                        .build(),
                                PinnacleThreeWayBetOfferSource.builder()
                                        .url("https://www.pinnacle.bet/en/soccer/greece-super-league-2/matchups/#period:0")
                                        .eventCompetition(GREECE_LEAGUE_2)
                                        .build(),

                                /* IRELAND */
                                PinnacleThreeWayBetOfferSource.builder()
                                        .url("https://www.pinnacle.bet/en/soccer/ireland-premier/matchups/#period:0")
                                        .eventCompetition(IRELAND_LEAGUE_1)
                                        .build(),
                                PinnacleThreeWayBetOfferSource.builder()
                                        .url("https://www.pinnacle.bet/en/soccer/ireland-division-1/matchups/#period:0")
                                        .eventCompetition(IRELAND_LEAGUE_2)
                                        .build(),

                                /* ISRAEL */
                                PinnacleThreeWayBetOfferSource.builder()
                                        .url("https://www.pinnacle.bet/en/soccer/israel-premier-league/matchups/#period:0")
                                        .eventCompetition(ISRAEL_LEAGUE_1)
                                        .build(),

                                /* ITALY */
                                PinnacleThreeWayBetOfferSource.builder()
                                        .url("https://www.pinnacle.bet/en/soccer/italy-serie-a/matchups/#period:0")
                                        .eventCompetition(SERIE_A)
                                        .build(),
                                PinnacleThreeWayBetOfferSource.builder()
                                        .url("https://www.pinnacle.bet/en/soccer/italy-serie-b/matchups/#period:0")
                                        .eventCompetition(SERIE_B)
                                        .build(),
                                PinnacleThreeWayBetOfferSource.builder()
                                        .url("https://www.pinnacle.bet/en/soccer/italy-cup/matchups/#period:0")
                                        .eventCompetition(COPPA_ITALIA)
                                        .build(),

                                /* JAPAN */
                                PinnacleThreeWayBetOfferSource.builder()
                                        .url("https://www.pinnacle.bet/en/soccer/japan-j-league/matchups/#period:0")
                                        .eventCompetition(JAPAN_LEAGUE_1)
                                        .build(),
                                PinnacleThreeWayBetOfferSource.builder()
                                        .url("https://www.pinnacle.bet/en/soccer/japan-j2-league/matchups/#period:0")
                                        .eventCompetition(JAPAN_LEAGUE_2)
                                        .build(),
                                // TODO missing Japan league 3

                                /* MALTA */
                                // Missing Malta Cup

                                /* NETHERLANDS */
                                PinnacleThreeWayBetOfferSource.builder()
                                        .url("https://www.pinnacle.bet/en/soccer/netherlands-eredivisie/matchups/#period:0")
                                        .eventCompetition(EVERDISIE)
                                        .build(),
                                PinnacleThreeWayBetOfferSource.builder()
                                        .url("https://www.pinnacle.bet/en/soccer/netherlands-eerste-divisie/matchups/#period:0")
                                        .eventCompetition(EERSTE_DIVISIE)
                                        .build(),
                                // TODO missing netherlands cup

                                /* NORWAY */
                                PinnacleThreeWayBetOfferSource.builder()
                                        .url("https://www.pinnacle.bet/en/soccer/norway-eliteserien/matchups/#period:0")
                                        .eventCompetition(NORWAY_LEAGUE_1)
                                        .build(),
                                // TODO missing norawy league 2

                                /* POLAND */
                                PinnacleThreeWayBetOfferSource.builder()
                                        .url("https://www.pinnacle.bet/en/soccer/poland-ekstraklasa/matchups/#period:0")
                                        .eventCompetition(POLAND_LEAGUE_1)
                                        .build(),
                                PinnacleThreeWayBetOfferSource.builder()
                                        .url("https://www.pinnacle.bet/en/soccer/poland-1st-liga/matchups/#all")
                                        .eventCompetition(POLAND_LEAGUE_2)
                                        .build(),
                                // TODO missing poland cup

                                /* PORTUGAL */
                                PinnacleThreeWayBetOfferSource.builder()
                                        .url("https://www.pinnacle.bet/en/soccer/portugal-primeira-liga/matchups/#period:0")
                                        .eventCompetition(PRIMIERA_LIGA_PORTUGAL)
                                        .build(),
                                PinnacleThreeWayBetOfferSource.builder()
                                        .url("https://www.pinnacle.bet/en/soccer/portugal-liga-2/matchups/#period:0")
                                        .eventCompetition(PORTUGAL_LEAGUE_2)
                                        .build(),
                                PinnacleThreeWayBetOfferSource.builder()
                                        .url("https://www.pinnacle.bet/en/soccer/portugal-cup/matchups/#period:0")
                                        .eventCompetition(PORTUGAL_CUP)
                                        .build(),

                                /* SCOTLAND */
                                PinnacleThreeWayBetOfferSource.builder()
                                        .url("https://www.pinnacle.bet/en/soccer/scotland-premier-league/matchups/#period:0")
                                        .eventCompetition(SCOTLAND_PREMIER_LEAGUE)
                                        .build(),
                                PinnacleThreeWayBetOfferSource.builder()
                                        .url("https://www.pinnacle.bet/en/soccer/scotland-championship/matchups/#period:0")
                                        .eventCompetition(SCOTLAND_CHAMPIONSHIP)
                                        .build(),
                                PinnacleThreeWayBetOfferSource.builder()
                                        .url("https://www.pinnacle.bet/en/soccer/scotland-league-one/matchups/#period:0")
                                        .eventCompetition(SCOTLAND_LEAGUE_ONE)
                                        .build(),
                                // TODO missing scotland league 2, cup

                                /* SPAIN */
                                PinnacleThreeWayBetOfferSource.builder()
                                        .url("https://www.pinnacle.bet/en/soccer/spain-la-liga/matchups/#period:0")
                                        .eventCompetition(LA_LIGA)
                                        .build(),
                                PinnacleThreeWayBetOfferSource.builder()
                                        .url("https://www.pinnacle.bet/en/soccer/spain-segunda-division/matchups/#period:0")
                                        .eventCompetition(LA_LIGA_2)
                                        .build(),
                                PinnacleThreeWayBetOfferSource.builder()
                                        .url("https://www.pinnacle.bet/en/soccer/spain-cup/matchups/#period:0")
                                        .eventCompetition(COPA_DEL_REY)
                                        .build(),

                                /* SWEDEN */
                                PinnacleThreeWayBetOfferSource.builder()
                                        .url("https://www.pinnacle.bet/en/soccer/sweden-allsvenskan/matchups/#period:0")
                                        .eventCompetition(SWEDEN_LEAGUE_1)
                                        .build(),
                                PinnacleThreeWayBetOfferSource.builder()
                                        .url("https://www.pinnacle.bet/en/soccer/sweden-superettan/matchups/#period:0")
                                        .eventCompetition(SWEDEN_LEAGUE_2)
                                        .build(),
                                // TODO missing sweden cup

                                /* SWITZERLAND */
                                PinnacleThreeWayBetOfferSource.builder()
                                        .url("https://www.pinnacle.bet/en/soccer/switzerland-super-league/matchups/#all")
                                        .eventCompetition(SWITZERLAND_SUPER_LEAGUE_1)
                                        .build(),
                                PinnacleThreeWayBetOfferSource.builder()
                                        .url("https://www.pinnacle.bet/en/soccer/switzerland-challenge-league/matchups/#all")
                                        .eventCompetition(SWITZERLAND_CHALLENGE_LEAGUE_2)
                                        .build(),
                                // TODO missing switzerland promotion league

                                /* TURKEY */
                                PinnacleThreeWayBetOfferSource.builder()
                                        .url("https://www.pinnacle.bet/en/soccer/turkey-super-league/matchups/#period:0")
                                        .eventCompetition(SUPER_LIG_TURKEY)
                                        .build(),
                                PinnacleThreeWayBetOfferSource.builder()
                                        .url("https://www.pinnacle.bet/en/soccer/turkey-1st-league/matchups/#period:0")
                                        .eventCompetition(TURKEY_LEAGUE_2)
                                        .build(),
                                PinnacleThreeWayBetOfferSource.builder()
                                        .url("https://www.pinnacle.bet/en/soccer/turkey-cup/matchups/#period:0")
                                        .eventCompetition(TURKEY_CUP)
                                        .build(),

                                /* UKRAINE */
                                PinnacleThreeWayBetOfferSource.builder()
                                        .url("https://www.pinnacle.bet/en/soccer/ukraine-premier-league/matchups/#period:0")
                                        .eventCompetition(UKRAINE_LEAGUE_1)
                                        .build(),

                                /* MLS */
                                PinnacleThreeWayBetOfferSource.builder()
                                        .url("https://www.pinnacle.bet/en/soccer/usa-major-league-soccer/matchups/#period:0")
                                        .eventCompetition(MLS)
                                        .build()

                        )
                    .build();

    @Override
    public BettingSourceType getType() {
        return PINNACLE;
    }

    @Override
    public List<BetOfferSource<?>> sources() {
        return SOURCES;
    }
}
