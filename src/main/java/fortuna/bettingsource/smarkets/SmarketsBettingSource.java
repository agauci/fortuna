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

                            /* PORTUGAL */
                            SmarketsThreeWayBetOfferSource.builder()
                                    .url("https://smarkets.com/listing/sport/football/portugal-primeira-liga")
                                    .description("PRIMIERA_LIGA_PORTUGAL")
                                    .eventCompetition(PRIMIERA_LIGA_PORTUGAL)
                                    .build(),

                            /* NETHERLANDS */
                            // TODO missing everdisie
                            SmarketsThreeWayBetOfferSource.builder()
                                    .url("https://smarkets.com/listing/sport/football/netherlands-eerste-divisie")
                                    .description("EERSTE_DIVISIE")
                                    .eventCompetition(EERSTE_DIVISIE)
                                    .build(),
                            SmarketsThreeWayBetOfferSource.builder()
                                    .url("https://smarkets.com/listing/sport/football/netherlands-knvb-beker")
                                    .description("KNVB_CUP")
                                    .eventCompetition(KNVB_CUP)
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
