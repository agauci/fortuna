package fortuna.bettingsource.betway;

import com.google.common.collect.ImmutableList;
import fortuna.bettingsource.BetOfferSource;
import fortuna.bettingsource.BettingSource;
import fortuna.bettingsource.bwin.BwinThreeWayBetOfferSource;
import fortuna.models.source.BettingSourceType;
import lombok.Builder;

import java.util.List;

import static fortuna.models.competition.FootballCompetition.*;
import static fortuna.models.source.Bookmaker.BETWAY;
import static fortuna.models.source.Bookmaker.UNIBET;

@Builder
public class BetwayBettingSource extends BettingSource {
    @Override
    public BettingSourceType getType() {
        return BETWAY;
    }

    @Override
    public List<BetOfferSource<?>> sources() {
        return ImmutableList.<BetOfferSource<?>>builder()
                .add(
                        /* ENGLAND */
                        BetwayThreeWayBetOfferSource.builder()
                                .url("https://betway.com/en/sports/grp/soccer/england/premier-league")
                                .description("PREMIER_LEAGUE")
                                .eventCompetition(PREMIER_LEAGUE)
                                .build(),
                        BetwayThreeWayBetOfferSource.builder()
                                .url("https://betway.com/en/sports/grp/soccer/england/fa-cup")
                                .description("FA_CUP")
                                .eventCompetition(FA_CUP)
                                .build(),
                        BetwayThreeWayBetOfferSource.builder()
                                .url("https://betway.com/en/sports/grp/soccer/england/championship")
                                .description("CHAMPIONSHIP")
                                .eventCompetition(CHAMPIONSHIP)
                                .build(),
                        BetwayThreeWayBetOfferSource.builder()
                                .url("https://betway.com/en/sports/grp/soccer/england/league-one")
                                .description("LEAGUE_ONE")
                                .eventCompetition(LEAGUE_ONE)
                                .build(),
                        BetwayThreeWayBetOfferSource.builder()
                                .url("https://betway.com/en/sports/grp/soccer/england/league-two")
                                .description("LEAGUE_TWO")
                                .eventCompetition(LEAGUE_TWO)
                                .build(),

                        /* ITALY */
                        BetwayThreeWayBetOfferSource.builder()
                                .url("https://betway.com/en/sports/grp/soccer/italy/serie-a")
                                .description("CHAMPIONSHIP")
                                .eventCompetition(SERIE_A)
                                .build(),
                        BetwayThreeWayBetOfferSource.builder()
                                .url("https://betway.com/en/sports/grp/soccer/italy/serie-b")
                                .description("LEAGUE_ONE")
                                .eventCompetition(SERIE_B)
                                .build(),
                        BetwayThreeWayBetOfferSource.builder()
                                .url("https://betway.com/en/sports/grp/soccer/italy/coppa-italia")
                                .description("LEAGUE_TWO")
                                .eventCompetition(COPPA_ITALIA)
                                .build()
                )
           .build();
    }
}
