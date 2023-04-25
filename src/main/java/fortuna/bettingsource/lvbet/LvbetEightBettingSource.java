package fortuna.bettingsource.lvbet;

import com.google.common.collect.ImmutableList;
import fortuna.bettingsource.BetOfferSource;
import fortuna.bettingsource.BettingSource;
import fortuna.models.source.BettingSourceType;
import lombok.Builder;

import java.util.List;

import static fortuna.models.competition.FootballCompetition.*;
import static fortuna.models.source.Bookmaker.LVBET;

@Builder
public class LvbetEightBettingSource extends BettingSource {

    private static List<BetOfferSource<?>> SOURCES =
            ImmutableList.<BetOfferSource<?>>builder()
                    .add(
                            /* ENGLAND */
                            LvbetThreeWayBetOfferSource.builder()
                                    .url("https://lvbet.com/sports/en/pre-matches/multiple--?leagues=37685")
                                    .description("PREMIER_LEAGUE")
                                    .eventCompetition(PREMIER_LEAGUE)
                                    .build(),
                            LvbetThreeWayBetOfferSource.builder()
                                    .url("https://lvbet.com/sports/en/pre-matches/multiple--?leagues=37558")
                                    .description("FA_CUP")
                                    .eventCompetition(FA_CUP)
                                    .build(),
                            LvbetThreeWayBetOfferSource.builder()
                                    .url("https://lvbet.com/sports/en/pre-matches/multiple--?leagues=37684")
                                    .description("CHAMPIONSHIP")
                                    .eventCompetition(CHAMPIONSHIP)
                                    .build(),
                            LvbetThreeWayBetOfferSource.builder()
                                    .url("https://lvbet.com/sports/en/pre-matches/multiple--?leagues=37555")
                                    .description("LEAGUE_ONE")
                                    .eventCompetition(LEAGUE_ONE)
                                    .build(),
                            LvbetThreeWayBetOfferSource.builder()
                                    .url("https://lvbet.com/sports/en/pre-matches/multiple--?leagues=37554")
                                    .description("LEAGUE_TWO")
                                    .eventCompetition(LEAGUE_TWO)
                                    .build(),

                            /* ITALY */
                            LvbetThreeWayBetOfferSource.builder()
                                    .url("https://lvbet.com/sports/en/pre-matches/multiple--?leagues=37680")
                                    .description("SERIE_A")
                                    .eventCompetition(SERIE_A)
                                    .build(),
                            LvbetThreeWayBetOfferSource.builder()
                                    .url("https://lvbet.com/sports/en/pre-matches/multiple--?leagues=37679")
                                    .description("SERIE_B")
                                    .eventCompetition(SERIE_B)
                                    .build(),
                            LvbetThreeWayBetOfferSource.builder()
                                    .url("https://lvbet.com/sports/en/pre-matches/multiple--?leagues=37655")
                                    .description("COPPA_ITALIA")
                                    .eventCompetition(COPPA_ITALIA)
                                    .build()
                    )
                    .build();

    @Override
    public BettingSourceType getType() {
        return LVBET;
    }

    @Override
    public List<BetOfferSource<?>> sources() {
        return SOURCES;
    }
}
