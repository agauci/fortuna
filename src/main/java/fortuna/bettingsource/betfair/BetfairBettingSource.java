package fortuna.bettingsource.betfair;

import com.google.common.collect.ImmutableList;
import fortuna.bettingsource.BetOfferSource;
import fortuna.bettingsource.BettingSource;
import fortuna.models.source.BettingSourceType;
import lombok.Builder;

import java.util.List;

import static fortuna.models.competition.FootballCompetition.*;
import static fortuna.models.source.BettingExchange.BETFAIR;

@Builder
public class BetfairBettingSource extends BettingSource {

    private static List<BetOfferSource<?>> SOURCES =
                ImmutableList.<BetOfferSource<?>>builder()
                        .add(
                            /* ENGLAND */
                            BetfairThreeWayBetOfferSource.builder()
                                    .url("https://www.betfair.com/sport/football/english-premier-league/10932509")
                                    .description("PREMIER_LEAGUE")
                                    .eventCompetition(PREMIER_LEAGUE)
                                    .build(),
                            BetfairThreeWayBetOfferSource.builder()
                                    .url("https://www.betfair.com/sport/football/english-championship/7129730")
                                    .description("CHAMPIONSHIP")
                                    .eventCompetition(CHAMPIONSHIP)
                                    .build(),
                            BetfairThreeWayBetOfferSource.builder()
                                    .url("https://www.betfair.com/sport/football/english-fa-cup/30558")
                                    .description("FA_CUP")
                                    .eventCompetition(FA_CUP)
                                    .build(),
                            BetfairThreeWayBetOfferSource.builder()
                                    .url("https://www.betfair.com/sport/football/english-league-1/35")
                                    .description("LEAGUE_1")
                                    .eventCompetition(LEAGUE_ONE)
                                    .build(),
                            BetfairThreeWayBetOfferSource.builder()
                                    .url("https://www.betfair.com/sport/football/english-league-2/37")
                                    .description("LEAGUE_TWO")
                                    .eventCompetition(LEAGUE_TWO)
                                    .build(),

                            /* ITALY */
                            BetfairThreeWayBetOfferSource.builder()
                                    .url("https://www.betfair.com/sport/football/italian-serie-a/81")
                                    .description("SERIE_A")
                                    .eventCompetition(SERIE_A)
                                    .build(),
                            BetfairThreeWayBetOfferSource.builder()
                                    .url("https://www.betfair.com/sport/football/italian-serie-b/12199689")
                                    .description("SERIE_B")
                                    .eventCompetition(SERIE_B)
                                    .build(),
                            BetfairThreeWayBetOfferSource.builder()
                                    .url("https://www.betfair.com/sport/football/italian-cup/12214429")
                                    .description("COPPA_ITALIA")
                                    .eventCompetition(COPPA_ITALIA)
                                    .build()
                    )
                    .build();

    @Override
    public BettingSourceType getType() {
        return BETFAIR;
    }

    @Override
    public List<BetOfferSource<?>> sources() {
        return SOURCES;
    }
}
