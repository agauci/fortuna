package fortuna.bettingsource.paddypower;

import com.google.common.collect.ImmutableList;
import fortuna.bettingsource.BetOfferSource;
import fortuna.bettingsource.BettingSource;
import fortuna.models.source.BettingSourceType;
import lombok.Builder;

import java.util.List;

import static fortuna.models.competition.FootballCompetition.*;
import static fortuna.models.source.Bookmaker.PADDY_POWER;
import static fortuna.models.source.Bookmaker.UNIBET;

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
