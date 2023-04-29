package fortuna.bettingsource.smarkets;

import com.google.common.collect.ImmutableList;
import fortuna.bettingsource.BetOfferSource;
import fortuna.bettingsource.BettingSource;
import fortuna.models.source.BettingSourceType;
import lombok.Builder;

import java.util.List;

import static fortuna.models.competition.FootballCompetition.*;
import static fortuna.models.source.BettingExchange.SMARKETS;

@Builder
public class SmarketsBettingSource extends BettingSource {

    private static List<BetOfferSource<?>> SOURCES =
                ImmutableList.<BetOfferSource<?>>builder()
                        .add(
                            /* EUROPE */
                            // TODO missing european competitions
                                
                            /* ENGLAND */
                            SmarketsThreeWayBetOfferSource.builder()
                                    .url("https://smarkets.com/listing/sport/football/england-premier-league")
                                    .description("PREMIER_LEAGUE")
                                    .eventCompetition(PREMIER_LEAGUE)
                                    .build(),
                            SmarketsThreeWayBetOfferSource.builder()
                                    .url("https://smarkets.com/listing/sport/football/england-championship")
                                    .description("CHAMPIONSHIP")
                                    .eventCompetition(CHAMPIONSHIP)
                                    .build(),
                            // TODO missing FA cup
                            SmarketsThreeWayBetOfferSource.builder()
                                    .url("https://smarkets.com/listing/sport/football/england-league-1")
                                    .description("LEAGUE_1")
                                    .eventCompetition(LEAGUE_ONE)
                                    .build(),
                            SmarketsThreeWayBetOfferSource.builder()
                                    .url("https://smarkets.com/listing/sport/football/england-league-2")
                                    .description("LEAGUE_TWO")
                                    .eventCompetition(LEAGUE_TWO)
                                    .build(),

                            /* ITALY */
                            SmarketsThreeWayBetOfferSource.builder()
                                    .url("https://smarkets.com/listing/sport/football/italy-serie-a")
                                    .description("SERIE_A")
                                    .eventCompetition(SERIE_A)
                                    .build(),
                            SmarketsThreeWayBetOfferSource.builder()
                                    .url("https://smarkets.com/listing/sport/football/italy-serie-b")
                                    .description("SERIE_B")
                                    .eventCompetition(SERIE_B)
                                    .build(),
                            // TODO missing Coppa Italia

                            /* SPAIN */
                            SmarketsThreeWayBetOfferSource.builder()
                                    .url("https://smarkets.com/listing/sport/football/spain-la-liga")
                                    .description("LA_LIGA")
                                    .eventCompetition(LA_LIGA)
                                    .build(),
                            SmarketsThreeWayBetOfferSource.builder()
                                    .url("https://smarkets.com/listing/sport/football/spain-la-liga-2")
                                    .description("LA_LIGA_2")
                                    .eventCompetition(LA_LIGA_2)
                                    .build(),
                            // TODO missing Copa Del Rey

                            /* FRANCE */
                            SmarketsThreeWayBetOfferSource.builder()
                                    .url("https://smarkets.com/listing/sport/football/france-ligue-1")
                                    .description("LIGUE_1")
                                    .eventCompetition(LIGUE_1)
                                    .build(),
                            SmarketsThreeWayBetOfferSource.builder()
                                    .url("https://smarkets.com/listing/sport/football/spain-la-liga-2")
                                    .description("LIGUE_2")
                                    .eventCompetition(LIGUE_2)
                                    .build(),
                            SmarketsThreeWayBetOfferSource.builder()
                                    .url("https://smarkets.com/listing/sport/football/france-cup")
                                    .description("COUPE_DE_FRANCE")
                                    .eventCompetition(COUPE_DE_FRANCE)
                                    .build(),

                            /* GERMANY */
                            SmarketsThreeWayBetOfferSource.builder()
                                    .url("https://smarkets.com/listing/sport/football/germany-bundesliga")
                                    .description("BUNDESLIGA")
                                    .eventCompetition(BUNDESLIGA)
                                    .build(),
                            SmarketsThreeWayBetOfferSource.builder()
                                    .url("https://smarkets.com/listing/sport/football/germany-2-bundesliga")
                                    .description("BUNDESLIGA_2")
                                    .eventCompetition(BUNDESLIGA_2)
                                    .build(),
                            SmarketsThreeWayBetOfferSource.builder()
                                    .url("https://smarkets.com/listing/sport/football/germany-dfb-pokal")
                                    .description("DFB_POKAL")
                                    .eventCompetition(DFB_POKAL)
                                    .build(),

                            /* TURKEY */
                            SmarketsThreeWayBetOfferSource.builder()
                                    .url("https://smarkets.com/listing/sport/football/turkey-1-lig")
                                    .description("SUPER_LIG_TURKEY")
                                    .eventCompetition(SUPER_LIG_TURKEY)
                                    .build(),
                                SmarketsThreeWayBetOfferSource.builder()
                                        .url("https://smarkets.com/listing/sport/football/turkey-1-lig")
                                        .eventCompetition(TURKEY_LEAGUE_2)
                                        .build(),

                            /* PORTUGAL */
                            SmarketsThreeWayBetOfferSource.builder()
                                    .url("https://smarkets.com/listing/sport/football/portugal-primeira-liga")
                                    .description("PRIMIERA_LIGA_PORTUGAL")
                                    .eventCompetition(PRIMIERA_LIGA_PORTUGAL)
                                    .build(),
                                SmarketsThreeWayBetOfferSource.builder()
                                        .url("https://smarkets.com/listing/sport/football/portugal-liga-2")
                                        .eventCompetition(PORTUGAL_LEAGUE_2)
                                        .build(),

                            /* NETHERLANDS */
                                SmarketsThreeWayBetOfferSource.builder()
                                        .url("https://smarkets.com/listing/sport/football/netherlands-eredivisie")
                                        .eventCompetition(EVERDISIE)
                                        .build(),
                                SmarketsThreeWayBetOfferSource.builder()
                                    .url("https://smarkets.com/listing/sport/football/netherlands-eerste-divisie")
                                    .description("EERSTE_DIVISIE")
                                    .eventCompetition(EERSTE_DIVISIE)
                                    .build(),
                            SmarketsThreeWayBetOfferSource.builder()
                                    .url("https://smarkets.com/listing/sport/football/netherlands-knvb-beker")
                                    .description("KNVB_CUP")
                                    .eventCompetition(KNVB_CUP)
                                    .build(),

                                /* AUSTRIA */
                                SmarketsThreeWayBetOfferSource.builder()
                                        .url("https://smarkets.com/listing/sport/football/austria-bundesliga")
                                        .eventCompetition(AUSTRIA_LEAGUE_1)
                                        .build(),
                                SmarketsThreeWayBetOfferSource.builder()
                                        .url("https://smarkets.com/listing/sport/football/austria-2-liga")
                                        .eventCompetition(AUSTRIA_LEAGUE_2)
                                        .build(),
                                SmarketsThreeWayBetOfferSource.builder()
                                        .url("https://smarkets.com/listing/sport/football/austria-ofb-cup")
                                        .eventCompetition(AUSTRIA_OFB_CUP)
                                        .build(),

                                /* ARGENTINA */
                                SmarketsThreeWayBetOfferSource.builder()
                                        .url("https://smarkets.com/listing/sport/football/austria-ofb-cup")
                                        .eventCompetition(ARGENTINA_LEAGUE_1)
                                        .build(),
                                SmarketsThreeWayBetOfferSource.builder()
                                        .url("https://smarkets.com/listing/sport/football/argentina-primera-nacional")
                                        .eventCompetition(ARGENTINA_LEAGUE_2)
                                        .build(),

                                /* BELGIUM */
                                SmarketsThreeWayBetOfferSource.builder()
                                        .url("https://smarkets.com/listing/sport/football/belgium-first-division-a")
                                        .eventCompetition(BELGIUM_FIRST_DIVISION_A_1)
                                        .build(),
                                // TODO missing belgium league 2
                                SmarketsThreeWayBetOfferSource.builder()
                                        .url("https://smarkets.com/listing/sport/football/belgium-cup")
                                        .eventCompetition(BELGIUM_CUP)
                                        .build(),

                                /* BULGARIA */
                                SmarketsThreeWayBetOfferSource.builder()
                                        .url("https://smarkets.com/listing/sport/football/bulgaria-first-division")
                                        .eventCompetition(BULGARIA_LEAGUE_1)
                                        .build(),
                                // TODO missing bulgaria league 2

                                /* BRAZIL */
                                SmarketsThreeWayBetOfferSource.builder()
                                        .url("https://smarkets.com/listing/sport/football/brazil-serie-a")
                                        .eventCompetition(BRAZIL_LEAGUE_1)
                                        .build(),
                                SmarketsThreeWayBetOfferSource.builder()
                                        .url("https://smarkets.com/listing/sport/football/brazil-serie-b")
                                        .eventCompetition(BRAZIL_LEAGUE_2)
                                        .build(),

                                /* CROATIA */
                                SmarketsThreeWayBetOfferSource.builder()
                                        .url("https://smarkets.com/listing/sport/football/croatia-hnl")
                                        .eventCompetition(CROATIA_LEAGUE_1)
                                        .build(),
                                // TODO missing croatia league 2

                                /* CYPRUS */
                                SmarketsThreeWayBetOfferSource.builder()
                                        .url("https://smarkets.com/listing/sport/football/cyprus-1-division")
                                        .eventCompetition(CYPRUS_LEAGUE_1)
                                        .build(),

                                /* CZECH REPUBLIC */
                                SmarketsThreeWayBetOfferSource.builder()
                                        .url("https://smarkets.com/listing/sport/football/czech-republic-premier-league")
                                        .eventCompetition(CZECH_REPUBLIC_LEAGUE_1)
                                        .build(),
                                SmarketsThreeWayBetOfferSource.builder()
                                        .url("https://smarkets.com/listing/sport/football/czech-republic-second-division")
                                        .eventCompetition(CZECH_REPUBLIC_LEAGUE_2)
                                        .build(),
                                // TODO missing czech republic cup

                                /* DENMARK */
                                SmarketsThreeWayBetOfferSource.builder()
                                        .url("https://smarkets.com/listing/sport/football/denmark-superliga")
                                        .eventCompetition(DENMARK_LEAGUE_1)
                                        .build(),
                                SmarketsThreeWayBetOfferSource.builder()
                                        .url("https://smarkets.com/listing/sport/football/denmark-1-division")
                                        .eventCompetition(DENMARK_LEAGUE_2)
                                        .build(),

                                /* GREECE */
                                SmarketsThreeWayBetOfferSource.builder()
                                        .url("https://smarkets.com/listing/sport/football/greece-super-league")
                                        .eventCompetition(GREECE_LEAGUE_1)
                                        .build(),
                                SmarketsThreeWayBetOfferSource.builder()
                                        .url("https://smarkets.com/listing/sport/football/greece-super-league-2")
                                        .eventCompetition(GREECE_LEAGUE_2)
                                        .build(),

                                /* IRELAND */
                                SmarketsThreeWayBetOfferSource.builder()
                                        .url("https://smarkets.com/listing/sport/football/ireland-premier-division")
                                        .eventCompetition(IRELAND_LEAGUE_1)
                                        .build(),
                                SmarketsThreeWayBetOfferSource.builder()
                                        .url("https://smarkets.com/listing/sport/football/ireland-first-division")
                                        .eventCompetition(IRELAND_LEAGUE_2)
                                        .build(),

                                /* ISRAEL */
                                SmarketsThreeWayBetOfferSource.builder()
                                        .url("https://smarkets.com/listing/sport/football/israel-ligat-al")
                                        .eventCompetition(ISRAEL_LEAGUE_1)
                                        .build(),

                                /* JAPAN */
                                // TODO missing japan j1, j2, j3

                                /* MALTA */
                                // TODO missing malta cup

                                /* NORWAY */
                                SmarketsThreeWayBetOfferSource.builder()
                                        .url("https://smarkets.com/listing/sport/football/norway-premier-league")
                                        .eventCompetition(NORWAY_LEAGUE_1)
                                        .build(),
                                SmarketsThreeWayBetOfferSource.builder()
                                        .url("https://smarkets.com/listing/sport/football/norway-first-division")
                                        .eventCompetition(NORWAY_LEAGUE_2)
                                        .build(),

                                /* POLAND */
                                SmarketsThreeWayBetOfferSource.builder()
                                        .url("https://smarkets.com/listing/sport/football/poland-ekstraklasa")
                                        .eventCompetition(POLAND_LEAGUE_1)
                                        .build(),
                                // TODO missing polish league 2, cup

                                /* SCOTLAND */
                                // TODO missing scottish premier league, championship, league 1 and 2
                                SmarketsThreeWayBetOfferSource.builder()
                                        .url("https://smarkets.com/listing/sport/football/scotland-fa-cup")
                                        .eventCompetition(SCOTLAND_FA_CUP)
                                        .build(),

                                /* SWEDEN */
                                SmarketsThreeWayBetOfferSource.builder()
                                        .url("https://smarkets.com/listing/sport/football/sweden-allsvenskan")
                                        .eventCompetition(SWEDEN_LEAGUE_1)
                                        .build(),
                                SmarketsThreeWayBetOfferSource.builder()
                                        .url("https://smarkets.com/listing/sport/football/sweden-superettan")
                                        .eventCompetition(SWEDEN_LEAGUE_2)
                                        .build(),
                                // TODO missing swedish cup

                                /* SWITZERLAND */
                                SmarketsThreeWayBetOfferSource.builder()
                                        .url("https://smarkets.com/listing/sport/football/switzerland-super-league")
                                        .eventCompetition(SWITZERLAND_SUPER_LEAGUE_1)
                                        .build(),
                                SmarketsThreeWayBetOfferSource.builder()
                                        .url("https://smarkets.com/listing/sport/football/switzerland-challenge-league")
                                        .eventCompetition(SWITZERLAND_CHALLENGE_LEAGUE_2)
                                        .build(),
                                // TODO missing switzerland league 3

                                /* UKRAINE */
                                SmarketsThreeWayBetOfferSource.builder()
                                        .url("https://smarkets.com/listing/sport/football/ukraine-premier-league")
                                        .eventCompetition(UKRAINE_LEAGUE_1)
                                        .build(),

                                /* USA */
                                SmarketsThreeWayBetOfferSource.builder()
                                        .url("https://smarkets.com/listing/sport/football/us-major-league-soccer")
                                        .eventCompetition(MLS)
                                        .build()
                    )
                    .build();

    @Override
    public BettingSourceType getType() {
        return SMARKETS;
    }

    @Override
    public List<BetOfferSource<?>> sources() {
        return SOURCES;
    }
}
