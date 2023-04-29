package fortuna.bettingsource.betsafe;

import com.google.common.collect.ImmutableList;
import fortuna.bettingsource.BetOfferSource;
import fortuna.bettingsource.BettingSource;
import fortuna.models.source.BettingSourceType;
import lombok.Builder;

import java.util.List;

import static fortuna.models.competition.FootballCompetition.*;
import static fortuna.models.source.Bookmaker.BETSAFE;

@Builder
public class BetsafeBettingSource extends BettingSource {

    private static List<BetOfferSource<?>> SOURCES =
                ImmutableList.<BetOfferSource<?>>builder()
                        .add(
                            /* ENGLAND */
                                BetsafeThreeWayBetOfferSource.builder()
                                        .url("https://www.betsafe.com/en/sportsbook/football/england/england-premier-league-epl")
                                        .eventCompetition(PREMIER_LEAGUE)
                                        .build(),
                                BetsafeThreeWayBetOfferSource.builder()
                                        .url("https://www.betsafe.com/en/sportsbook/football/england/england-efl-championship")
                                        .eventCompetition(CHAMPIONSHIP)
                                        .build(),
                                BetsafeThreeWayBetOfferSource.builder()
                                        .url("https://www.betsafe.com/en/sportsbook/football/england/england-league-one")
                                        .eventCompetition(LEAGUE_ONE)
                                        .build(),
                                BetsafeThreeWayBetOfferSource.builder()
                                        .url("https://www.betsafe.com/en/sportsbook/football/england/england-league-two")
                                        .eventCompetition(LEAGUE_TWO)
                                        .build(),
                                BetsafeThreeWayBetOfferSource.builder()
                                        .url("https://www.betsafe.com/en/sportsbook/football/england/england-fa-cup")
                                        .eventCompetition(FA_CUP)
                                        .build(),

                            /* ITALY */
                            BetsafeThreeWayBetOfferSource.builder()
                                    .url("https://www.betsafe.com/en/sportsbook/football/italy/italy-serie-a")
                                    .description("SERIE_A")
                                    .eventCompetition(SERIE_A)
                                    .build(),
                            BetsafeThreeWayBetOfferSource.builder()
                                    .url("https://www.betsafe.com/en/sportsbook/football/italy/italy-coppa-italia")
                                    .description("COPPA_ITALIA")
                                    .eventCompetition(COPPA_ITALIA)
                                    .build(),
                            BetsafeThreeWayBetOfferSource.builder()
                                    .url("https://www.betsafe.com/en/sportsbook/football/italy/italy-serie-b")
                                    .description("SERIE_B")
                                    .eventCompetition(SERIE_B)
                                    .build(),

                            /* EUROPE */
                            BetsafeThreeWayBetOfferSource.builder()
                                    .url("https://www.betsafe.com/en/sportsbook/football/champions-league/champions-league")
                                    .description("CHAMPIONS_LEAGUE")
                                    .eventCompetition(CHAMPIONS_LEAGUE)
                                    .build(),
                            BetsafeThreeWayBetOfferSource.builder()
                                    .url("https://www.betsafe.com/en/sportsbook/football/europa-league/europa-league")
                                    .description("EUROPA_LEAGUE")
                                    .eventCompetition(EUROPA_LEAGUE)
                                    .build(),
                            BetsafeThreeWayBetOfferSource.builder()
                                    .url("https://www.betsafe.com/en/sportsbook/football/europa-conference-league/europa-conference-league")
                                    .description("CONFERENCE_LEAGUE")
                                    .eventCompetition(CONFERENCE_LEAGUE)
                                    .build(),

                            /* SPAIN */
                            BetsafeThreeWayBetOfferSource.builder()
                                    .url("https://www.betsafe.com/en/sportsbook/football/spain/spain-la-liga")
                                    .description("LA_LIGA")
                                    .eventCompetition(LA_LIGA)
                                    .build(),
                            BetsafeThreeWayBetOfferSource.builder()
                                    .url("https://www.betsafe.com/en/sportsbook/football/spain/spain-segunda-division")
                                    .description("LA_LIGA_2")
                                    .eventCompetition(LA_LIGA_2)
                                    .build(),
                            BetsafeThreeWayBetOfferSource.builder()
                                    .url("https://www.betsafe.com/en/sportsbook/football/spain/spain-copa-del-rey")
                                    .description("COPA_DEL_REY")
                                    .eventCompetition(COPA_DEL_REY)
                                    .build(),

                            /* FRANCE */
                            BetsafeThreeWayBetOfferSource.builder()
                                    .url("https://www.betsafe.com/en/sportsbook/football/france/france-ligue-1")
                                    .description("LIGUE_1")
                                    .eventCompetition(LIGUE_1)
                                    .build(),
                            BetsafeThreeWayBetOfferSource.builder()
                                    .url("https://www.betsafe.com/en/sportsbook/football/france/france-ligue-2")
                                    .description("LIGUE_2")
                                    .eventCompetition(LIGUE_2)
                                    .build(),
                            BetsafeThreeWayBetOfferSource.builder()
                                    .url("https://www.betsafe.com/en/sportsbook/football/france/france-coupe-de-france")
                                    .description("COUPE_DE_FRANCE")
                                    .eventCompetition(COUPE_DE_FRANCE)
                                    .build(),

                            /* GERMANY */
                            BetsafeThreeWayBetOfferSource.builder()
                                    .url("https://www.betsafe.com/en/sportsbook/football/germany/germany-bundesliga")
                                    .description("BUNDESLIGA")
                                    .eventCompetition(BUNDESLIGA)
                                    .build(),
                            BetsafeThreeWayBetOfferSource.builder()
                                    .url("https://www.betsafe.com/en/sportsbook/football/germany/germany-2-bundesliga")
                                    .description("BUNDESLIGA_2")
                                    .eventCompetition(BUNDESLIGA_2)
                                    .build(),
                            BetsafeThreeWayBetOfferSource.builder()
                                    .url("https://www.betsafe.com/en/sportsbook/football/germany/germany-dfb-pokal")
                                    .description("DFB_POKAL")
                                    .eventCompetition(DFB_POKAL)
                                    .build(),

                            /* TURKEY */
                            BetsafeThreeWayBetOfferSource.builder()
                                    .url("https://www.betsafe.com/en/sportsbook/football/turkey/turkey-super-lig")
                                    .description("SUPER_LIG_TURKEY")
                                    .eventCompetition(SUPER_LIG_TURKEY)
                                    .build(),
                                BetsafeThreeWayBetOfferSource.builder()
                                        .url("https://www.betsafe.com/en/sportsbook/football/turkey/turkey-1-lig")
                                        .eventCompetition(TURKEY_LEAGUE_2)
                                        .build(),
                                BetsafeThreeWayBetOfferSource.builder()
                                        .url("https://www.betsafe.com/en/sportsbook/football/turkey/turkish-cup")
                                        .eventCompetition(TURKEY_CUP)
                                        .build(),

                            /* PORTUGAL */
                            BetsafeThreeWayBetOfferSource.builder()
                                    .url("https://www.betsafe.com/en/sportsbook/football/portugal/portugal-primeira-liga")
                                    .description("PRIMIERA_LIGA_PORTUGAL")
                                    .eventCompetition(PRIMIERA_LIGA_PORTUGAL)
                                    .build(),
                                BetsafeThreeWayBetOfferSource.builder()
                                        .url("https://www.betsafe.com/en/sportsbook/football/portugal/portugal-segunda-liga")
                                        .eventCompetition(PORTUGAL_LEAGUE_2)
                                        .build(),
                                BetsafeThreeWayBetOfferSource.builder()
                                        .url("https://www.betsafe.com/en/sportsbook/football/portugal/portugal-cup")
                                        .eventCompetition(PORTUGAL_CUP)
                                        .build(),

                            /* NETHERLANDS */
                            BetsafeThreeWayBetOfferSource.builder()
                                    .url("https://www.betsafe.com/en/sportsbook/football/netherlands/netherlands-eredivisie")
                                    .description("EVERDISIE")
                                    .eventCompetition(EVERDISIE)
                                    .build(),
                            BetsafeThreeWayBetOfferSource.builder()
                                    .url("https://www.betsafe.com/en/sportsbook/football/netherlands/netherlands-eerste-divisie")
                                    .description("EERSTE_DIVISIE")
                                    .eventCompetition(EERSTE_DIVISIE)
                                    .build(),
                            BetsafeThreeWayBetOfferSource.builder()
                                    .url("https://www.betsafe.com/en/sportsbook/football/netherlands/netherlands-knvb-beker")
                                    .description("KNVB_CUP")
                                    .eventCompetition(KNVB_CUP)
                                    .build(),

                                /* AUSTRIA */
                                BetsafeThreeWayBetOfferSource.builder()
                                        .url("https://www.betsafe.com/en/sportsbook/football/europe/austria-bundesliga")
                                        .eventCompetition(AUSTRIA_LEAGUE_1)
                                        .build(),
                                BetsafeThreeWayBetOfferSource.builder()
                                        .url("https://www.betsafe.com/en/sportsbook/football/europe/austria-2-liga")
                                        .eventCompetition(AUSTRIA_LEAGUE_2)
                                        .build(),
                                BetsafeThreeWayBetOfferSource.builder()
                                        .url("https://www.betsafe.com/en/sportsbook/football/europe/austria-ofb-cup")
                                        .eventCompetition(AUSTRIA_OFB_CUP)
                                        .build(),

                                /* ARGENTINA */
                                BetsafeThreeWayBetOfferSource.builder()
                                        .url("https://www.betsafe.com/en/sportsbook/football/south-america/argentina-liga-profesional")
                                        .eventCompetition(ARGENTINA_LEAGUE_1)
                                        .build(),
                                BetsafeThreeWayBetOfferSource.builder()
                                        .url("https://www.betsafe.com/en/sportsbook/football/south-america/argentina-primera-nacional")
                                        .eventCompetition(ARGENTINA_LEAGUE_2)
                                        .build(),

                                /* BELGIUM */
                                BetsafeThreeWayBetOfferSource.builder()
                                        .url("https://www.betsafe.com/en/sportsbook/football/europe/belgian-jupiler-league")
                                        .eventCompetition(BELGIUM_FIRST_DIVISION_A_1)
                                        .build(),
                                BetsafeThreeWayBetOfferSource.builder()
                                        .url("https://www.betsafe.com/en/sportsbook/football/europe/belgian-cup")
                                        .eventCompetition(BELGIUM_CUP)
                                        .build(),

                                /* BULGARIA */
                                BetsafeThreeWayBetOfferSource.builder()
                                        .url("https://www.betsafe.com/en/sportsbook/football/europe/bulgaria-1-league")
                                        .eventCompetition(BULGARIA_LEAGUE_1)
                                        .build(),
                                BetsafeThreeWayBetOfferSource.builder()
                                        .url("https://www.betsafe.com/en/sportsbook/football/europe/bulgaria-2-league")
                                        .eventCompetition(BULGARIA_LEAGUE_2)
                                        .build(),

                                /* BRAZIL */
                                BetsafeThreeWayBetOfferSource.builder()
                                        .url("https://www.betsafe.com/en/sportsbook/football/south-america/brazil-serie-a")
                                        .eventCompetition(BRAZIL_LEAGUE_1)
                                        .build(),
                                BetsafeThreeWayBetOfferSource.builder()
                                        .url("https://www.betsafe.com/en/sportsbook/football/south-america/brazil-serie-b")
                                        .eventCompetition(BRAZIL_LEAGUE_2)
                                        .build(),

                                /* CROATIA */
                                BetsafeThreeWayBetOfferSource.builder()
                                        .url("https://www.betsafe.com/en/sportsbook/football/europe/croatia-1-nl")
                                        .eventCompetition(CROATIA_LEAGUE_1)
                                        .build(),
                                BetsafeThreeWayBetOfferSource.builder()
                                        .url("https://www.betsafe.com/en/sportsbook/football/europe/croatia-2-nl")
                                        .eventCompetition(CROATIA_LEAGUE_2)
                                        .build(),

                                /* CYPRUS */
                                BetsafeThreeWayBetOfferSource.builder()
                                        .url("https://www.betsafe.com/en/sportsbook/football/europe/cyprus-1st-division")
                                        .eventCompetition(CYPRUS_LEAGUE_1)
                                        .build(),

                                /* CZECH REPUBLIC */
                                BetsafeThreeWayBetOfferSource.builder()
                                        .url("https://www.betsafe.com/en/sportsbook/football/europe/czech-republic-1-league")
                                        .eventCompetition(CZECH_REPUBLIC_LEAGUE_1)
                                        .build(),
                                BetsafeThreeWayBetOfferSource.builder()
                                        .url("https://www.betsafe.com/en/sportsbook/football/europe/czech-republic-fnl")
                                        .eventCompetition(CZECH_REPUBLIC_LEAGUE_2)
                                        .build(),

                                /* DENMARK */
                                BetsafeThreeWayBetOfferSource.builder()
                                        .url("https://www.betsafe.com/en/sportsbook/football/denmark/denmark-super-league")
                                        .eventCompetition(DENMARK_LEAGUE_1)
                                        .build(),
                                BetsafeThreeWayBetOfferSource.builder()
                                        .url("https://www.betsafe.com/en/sportsbook/football/denmark/denmark-division-1")
                                        .eventCompetition(DENMARK_LEAGUE_2)
                                        .build(),

                                /* GREECE */
                                BetsafeThreeWayBetOfferSource.builder()
                                        .url("https://www.betsafe.com/en/sportsbook/football/europe/greece-super-league-1")
                                        .eventCompetition(GREECE_LEAGUE_1)
                                        .build(),
                                BetsafeThreeWayBetOfferSource.builder()
                                        .url("https://www.betsafe.com/en/sportsbook/football/europe/greece-betsson-super-league-2")
                                        .eventCompetition(GREECE_LEAGUE_2)
                                        .build(),

                                /* IRELAND */
                                BetsafeThreeWayBetOfferSource.builder()
                                        .url("https://www.betsafe.com/en/sportsbook/football/europe/irish-airtricity-premier-division")
                                        .eventCompetition(IRELAND_LEAGUE_1)
                                        .build(),
                                BetsafeThreeWayBetOfferSource.builder()
                                        .url("https://www.betsafe.com/en/sportsbook/football/europe/irish-airtricity-division-1")
                                        .eventCompetition(IRELAND_LEAGUE_2)
                                        .build(),

                                /* ISRAEL */
                                BetsafeThreeWayBetOfferSource.builder()
                                        .url("https://www.betsafe.com/en/sportsbook/football/europe/israel-ligat-haal")
                                        .eventCompetition(ISRAEL_LEAGUE_1)
                                        .build(),

                                /* JAPAN */
                                BetsafeThreeWayBetOfferSource.builder()
                                        .url("https://www.betsafe.com/en/sportsbook/football/asia/japan-j1-league")
                                        .eventCompetition(JAPAN_LEAGUE_1)
                                        .build(),
                                BetsafeThreeWayBetOfferSource.builder()
                                        .url("https://www.betsafe.com/en/sportsbook/football/asia/japan-j2-league")
                                        .eventCompetition(JAPAN_LEAGUE_2)
                                        .build(),
                                BetsafeThreeWayBetOfferSource.builder()
                                        .url("https://www.betsafe.com/en/sportsbook/football/asia/japan-j3-league")
                                        .eventCompetition(JAPAN_LEAGUE_3)
                                        .build(),

                                /* NORWAY */
                                // TODO missing Norway

                                /* POLAND */
                                BetsafeThreeWayBetOfferSource.builder()
                                        .url("https://www.betsafe.com/en/sportsbook/football/europe/poland-ekstraklasa")
                                        .eventCompetition(POLAND_LEAGUE_1)
                                        .build(),
                                BetsafeThreeWayBetOfferSource.builder()
                                        .url("https://www.betsafe.com/en/sportsbook/football/europe/poland-i-liga")
                                        .eventCompetition(POLAND_LEAGUE_2)
                                        .build(),
                                BetsafeThreeWayBetOfferSource.builder()
                                        .url("https://www.betsafe.com/en/sportsbook/football/europe/poland-cup")
                                        .eventCompetition(POLAND_CUP)
                                        .build(),

                                /* SCOTLAND */
                                // TODO missing scottish premiership
                                BetsafeThreeWayBetOfferSource.builder()
                                        .url("https://www.betsafe.com/en/sportsbook/football/europe/scottish-championship")
                                        .eventCompetition(SCOTLAND_CHAMPIONSHIP)
                                        .build(),
                                BetsafeThreeWayBetOfferSource.builder()
                                        .url("https://www.betsafe.com/en/sportsbook/football/europe/scottish-league-1")
                                        .eventCompetition(SCOTLAND_LEAGUE_ONE)
                                        .build(),
                                BetsafeThreeWayBetOfferSource.builder()
                                        .url("https://www.betsafe.com/en/sportsbook/football/europe/scottish-league-2")
                                        .eventCompetition(SCOTLAND_LEAGUE_TWO)
                                        .build(),
                                BetsafeThreeWayBetOfferSource.builder()
                                        .url("https://www.betsafe.com/en/sportsbook/football/europe/scottish-cup")
                                        .eventCompetition(SCOTLAND_FA_CUP)
                                        .build(),

                                /* SWEDEN */
                                BetsafeThreeWayBetOfferSource.builder()
                                        .url("https://www.betsafe.com/en/sportsbook/football/sweden/swedish-allsvenskan")
                                        .eventCompetition(SWEDEN_LEAGUE_1)
                                        .build(),
                                BetsafeThreeWayBetOfferSource.builder()
                                        .url("https://www.betsafe.com/en/sportsbook/football/sweden/swedish-superettan")
                                        .eventCompetition(SWEDEN_LEAGUE_2)
                                        .build(),
                                BetsafeThreeWayBetOfferSource.builder()
                                        .url("https://www.betsafe.com/en/sportsbook/football/sweden/swedish-cup")
                                        .eventCompetition(SWEDEN_CUP)
                                        .build(),

                                /* SWITZERLAND */
                                BetsafeThreeWayBetOfferSource.builder()
                                        .url("https://www.betsafe.com/en/sportsbook/football/europe/switzerland-super-league")
                                        .eventCompetition(SWITZERLAND_SUPER_LEAGUE_1)
                                        .build(),
                                BetsafeThreeWayBetOfferSource.builder()
                                        .url("https://www.betsafe.com/en/sportsbook/football/europe/switzerland-challenge-league")
                                        .eventCompetition(SWITZERLAND_CHALLENGE_LEAGUE_2)
                                        .build(),
                                // TODO missing swiss 3rd league

                                /* UKRAINE */
                                BetsafeThreeWayBetOfferSource.builder()
                                        .url("https://www.betsafe.com/en/sportsbook/football/europe/ukraine-premier-league")
                                        .eventCompetition(UKRAINE_LEAGUE_1)
                                        .build(),

                                /* USA */
                                BetsafeThreeWayBetOfferSource.builder()
                                        .url("https://www.betsafe.com/en/sportsbook/football/north-america/usa-mls")
                                        .eventCompetition(MLS)
                                        .build()
                    )
                    .build();

    @Override
    public BettingSourceType getType() {
        return BETSAFE;
    }

    @Override
    public List<BetOfferSource<?>> sources() {
        return SOURCES;
    }
}
