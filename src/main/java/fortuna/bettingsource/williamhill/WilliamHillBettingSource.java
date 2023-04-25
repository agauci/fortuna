package fortuna.bettingsource.williamhill;

import com.google.common.collect.ImmutableList;
import fortuna.bettingsource.BetOfferSource;
import fortuna.bettingsource.BettingSource;
import fortuna.bettingsource.betfair.BetfairThreeWayBetOfferSource;
import fortuna.models.source.BettingSourceType;
import lombok.Builder;

import java.util.List;

import static fortuna.models.competition.FootballCompetition.*;
import static fortuna.models.source.BettingExchange.BETFAIR;
import static fortuna.models.source.Bookmaker.WILLIAM_HILL;

@Builder
public class WilliamHillBettingSource extends BettingSource {

    private static List<BetOfferSource<?>> SOURCES =
                ImmutableList.<BetOfferSource<?>>builder()
                        .add(
                            /* ENGLAND */
                            WilliamHillThreeWayBetOfferSource.builder()
                                    .url("https://sports.williamhill.com/betting/en-gb/football/competitions/OB_TY295/english-premier-league/matches/OB_MGMB/Match-Betting9")
                                    .description("PREMIER_LEAGUE")
                                    .eventCompetition(PREMIER_LEAGUE)
                                    .build(),
                            WilliamHillThreeWayBetOfferSource.builder()
                                    .url("https://sports.williamhill.com/betting/en-gb/football/competitions/OB_TY292/English-Championship/matches/OB_MGMB/Match-Betting")
                                    .description("CHAMPIONSHIP")
                                    .eventCompetition(CHAMPIONSHIP)
                                    .build(),
                            WilliamHillThreeWayBetOfferSource.builder()
                                    .url("https://sports.williamhill.com/betting/en-gb/football/competitions/OB_TY129/English-FA-Cup/matches/OB_MGMB/Match-Betting8")
                                    .description("FA_CUP")
                                    .eventCompetition(FA_CUP)
                                    .build(),
                            WilliamHillThreeWayBetOfferSource.builder()
                                    .url("https://sports.williamhill.com/betting/en-gb/football/competitions/OB_TY293/English-League-1/matches/OB_MGMB/Match-Betting")
                                    .description("LEAGUE_1")
                                    .eventCompetition(LEAGUE_ONE)
                                    .build(),
                            WilliamHillThreeWayBetOfferSource.builder()
                                    .url("https://sports.williamhill.com/betting/en-gb/football/competitions/OB_TY294/English-League-2/matches/OB_MGMB/Match-Betting")
                                    .description("LEAGUE_TWO")
                                    .eventCompetition(LEAGUE_TWO)
                                    .build(),

                            /* ITALY */
                            WilliamHillThreeWayBetOfferSource.builder()
                                    .url("https://sports.williamhill.com/betting/en-gb/football/competitions/OB_TY321/Italian-Serie-A/matches/OB_MGMB/Match-Betting")
                                    .description("SERIE_A")
                                    .eventCompetition(SERIE_A)
                                    .build(),
                            WilliamHillThreeWayBetOfferSource.builder()
                                    .url("https://sports.williamhill.com/betting/en-gb/football/competitions/OB_TY23532/Italian-Serie-B/matches/OB_MGMB/Match-Betting")
                                    .description("SERIE_B")
                                    .eventCompetition(SERIE_B)
                                    .build(),
                            WilliamHillThreeWayBetOfferSource.builder()
                                    .url("https://sports.williamhill.com/betting/en-gb/football/competitions/OB_TY181/Coppa-Italia/matches/OB_MGMB/Match-Betting")
                                    .description("COPPA_ITALIA")
                                    .eventCompetition(COPPA_ITALIA)
                                    .build()
                    )
                    .build();

    @Override
    public BettingSourceType getType() {
        return WILLIAM_HILL;
    }

    @Override
    public List<BetOfferSource<?>> sources() {
        return SOURCES;
    }
}
