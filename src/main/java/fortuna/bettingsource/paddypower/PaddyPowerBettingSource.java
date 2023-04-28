package fortuna.bettingsource.paddypower;

import com.google.common.collect.ImmutableList;
import fortuna.bettingsource.BetOfferSource;
import fortuna.bettingsource.BettingSource;
import fortuna.models.source.BettingSourceType;
import lombok.Builder;

import java.util.List;

import static fortuna.models.competition.FootballCompetition.*;
import static fortuna.models.source.Bookmaker.PADDY_POWER;

@Builder
public class PaddyPowerBettingSource extends BettingSource {

    private static List<BetOfferSource<?>> SOURCES =
                ImmutableList.<BetOfferSource<?>>builder()
                        .add(
                            /* ENGLAND */
                            PaddyPowerThreeWayBetOfferSource.builder()
                                    .url("https://www.paddypower.com/english-premier-league")
                                    .description("PREMIER_LEAGUE")
                                    .eventCompetition(PREMIER_LEAGUE)
                                    .build(),
                            PaddyPowerThreeWayBetOfferSource.builder()
                                    .url("https://www.paddypower.com/english-fa-cup")
                                    .description("FA_CUP")
                                    .eventCompetition(FA_CUP)
                                    .build(),
                            PaddyPowerThreeWayBetOfferSource.builder()
                                    .url("https://www.paddypower.com/football/english-championship")
                                    .description("CHAMPIONSHIP")
                                    .eventCompetition(CHAMPIONSHIP)
                                    .build(),
                            PaddyPowerThreeWayBetOfferSource.builder()
                                    .url("https://www.paddypower.com/football/english-league-1")
                                    .description("LEAGUE_ONE")
                                    .eventCompetition(LEAGUE_ONE)
                                    .build(),
                            PaddyPowerThreeWayBetOfferSource.builder()
                                    .url("https://www.paddypower.com/football/english-league-2")
                                    .description("LEAGUE_TWO")
                                    .eventCompetition(LEAGUE_TWO)
                                    .build(),

                            /* ITALY */
                            PaddyPowerThreeWayBetOfferSource.builder()
                                    .url("https://www.paddypower.com/football/italian-serie-a")
                                    .description("SERIE_A")
                                    .eventCompetition(SERIE_A)
                                    .build(),
                            PaddyPowerThreeWayBetOfferSource.builder()
                                    .url("https://www.paddypower.com/football/italian-serie-b")
                                    .description("SERIE_B")
                                    .eventCompetition(SERIE_B)
                                    .build(),
                            PaddyPowerThreeWayBetOfferSource.builder()
                                    .url("https://www.paddypower.com/football/italian-cup")
                                    .description("COPPA_ITALIA")
                                    .eventCompetition(COPPA_ITALIA)
                                    .build(),

                            /* EUROPE */
                            PaddyPowerThreeWayBetOfferSource.builder()
                                    .url("https://www.paddypower.com/uefa-champions-league")
                                    .description("CHAMPIONS_LEAGUE")
                                    .eventCompetition(CHAMPIONS_LEAGUE)
                                    .build(),
                            PaddyPowerThreeWayBetOfferSource.builder()
                                    .url("https://www.paddypower.com/football/uefa-europa-league")
                                    .description("EUROPA_LEAGUE")
                                    .eventCompetition(EUROPA_LEAGUE)
                                    .build(),
                            PaddyPowerThreeWayBetOfferSource.builder()
                                    .url("https://www.paddypower.com/football/uefa-europa-conference-league")
                                    .description("CONFERENCE_LEAGUE")
                                    .eventCompetition(CONFERENCE_LEAGUE)
                                    .build(),

                            /* SPAIN */
                            PaddyPowerThreeWayBetOfferSource.builder()
                                    .url("https://www.paddypower.com/football/spanish-la-liga")
                                    .description("LA_LIGA")
                                    .eventCompetition(LA_LIGA)
                                    .build(),
                            PaddyPowerThreeWayBetOfferSource.builder()
                                    .url("https://www.paddypower.com/football/spanish-segunda-division")
                                    .description("LA_LIGA_2")
                                    .eventCompetition(LA_LIGA_2)
                                    .build(),
                            PaddyPowerThreeWayBetOfferSource.builder()
                                    .url("https://www.paddypower.com/football/spanish-copa-del-rey")
                                    .description("COPA_DEL_REY")
                                    .eventCompetition(COPA_DEL_REY)
                                    .build(),

                            /* FRANCE */
                            PaddyPowerThreeWayBetOfferSource.builder()
                                    .url("https://www.paddypower.com/football/french-ligue-1")
                                    .description("LIGUE_1")
                                    .eventCompetition(LIGUE_1)
                                    .build(),
                            PaddyPowerThreeWayBetOfferSource.builder()
                                    .url("https://www.paddypower.com/football/french-ligue-2")
                                    .description("LIGUE_2")
                                    .eventCompetition(LIGUE_2)
                                    .build(),
                            PaddyPowerThreeWayBetOfferSource.builder()
                                    .url("https://www.paddypower.com/football/french-cup")
                                    .description("COUPE_DE_FRANCE")
                                    .eventCompetition(COUPE_DE_FRANCE)
                                    .build(),

                            /* GERMANY */
                            PaddyPowerThreeWayBetOfferSource.builder()
                                    .url("https://www.paddypower.com/football/german-bundesliga")
                                    .description("BUNDESLIGA")
                                    .eventCompetition(BUNDESLIGA)
                                    .build(),
                            PaddyPowerThreeWayBetOfferSource.builder()
                                    .url("https://www.paddypower.com/football/german-bundesliga-2")
                                    .description("BUNDESLIGA_2")
                                    .eventCompetition(BUNDESLIGA_2)
                                    .build(),
                            PaddyPowerThreeWayBetOfferSource.builder()
                                    .url("https://www.paddypower.com/football/german-cup")
                                    .description("DFB_POKAL")
                                    .eventCompetition(DFB_POKAL)
                                    .build(),

                            /* TURKEY */
                            PaddyPowerThreeWayBetOfferSource.builder()
                                    .url("https://www.paddypower.com/football/turkish-1-lig")
                                    .description("SUPER_LIG_TURKEY")
                                    .eventCompetition(SUPER_LIG_TURKEY)
                                    .build(),

                            /* PORTUGAL */
                            PaddyPowerThreeWayBetOfferSource.builder()
                                    .url("https://www.paddypower.com/football/portuguese-primeira-liga")
                                    .description("PRIMIERA_LIGA_PORTUGAL")
                                    .eventCompetition(PRIMIERA_LIGA_PORTUGAL)
                                    .build(),

                            /* NETHERLANDS */
                            // TODO add everdisie
                            PaddyPowerThreeWayBetOfferSource.builder()
                                    .url("https://www.paddypower.com/football/dutch-eerste-divisie")
                                    .description("EERSTE_DIVISIE")
                                    .eventCompetition(EERSTE_DIVISIE)
                                    .build(),
                            PaddyPowerThreeWayBetOfferSource.builder()
                                    .url("https://www.paddypower.com/football/dutch-cup")
                                    .description("KNVB_CUP")
                                    .eventCompetition(KNVB_CUP)
                                    .build()    
                    )
                    .build();

    @Override
    public BettingSourceType getType() {
        return PADDY_POWER;
    }

    @Override
    public List<BetOfferSource<?>> sources() {
        return SOURCES;
    }
}
