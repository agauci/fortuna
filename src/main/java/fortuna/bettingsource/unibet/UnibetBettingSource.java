package fortuna.bettingsource.unibet;

import com.google.common.collect.ImmutableList;
import fortuna.bettingsource.BetOfferSource;
import fortuna.bettingsource.BettingSource;
import fortuna.models.source.BettingSourceType;
import lombok.Builder;

import java.util.List;

import static fortuna.models.competition.FootballCompetition.*;
import static fortuna.models.source.Bookmaker.UNIBET;
@Builder
public class UnibetBettingSource extends BettingSource {
    @Override
    public BettingSourceType getType() {
        return UNIBET;
    }

    @Override
    public List<BetOfferSource<?>> sources() {
        return ImmutableList.<BetOfferSource<?>>builder()
                .add(
                        /* ENGLAND */
                        UnibetThreeWayBetOfferSource.builder()
                                .url("https://www.unibet.com/betting/sports/filter/football/england/premier_league/all/matches")
                                .description("PREMIER_LEAGUE")
                                .eventCompetition(PREMIER_LEAGUE)
                                .build(),
                        UnibetThreeWayBetOfferSource.builder()
                                .url("https://www.unibet.com/betting/sports/filter/football/england/fa_cup/all/matches")
                                .description("FA_CUP")
                                .eventCompetition(FA_CUP)
                                .build(),
                        UnibetThreeWayBetOfferSource.builder()
                                .url("https://www.unibet.com/betting/sports/filter/football/england/the_championship/all/matches")
                                .description("CHAMPIONSHIP")
                                .eventCompetition(CHAMPIONSHIP)
                                .build(),

                        /* ITALY */
                        UnibetThreeWayBetOfferSource.builder()
                                .url("https://www.unibet.com/betting/sports/filter/football/italy/serie_a/all/matches")
                                .description("SERIE_A")
                                .eventCompetition(SERIE_A)
                                .build(),
                        UnibetThreeWayBetOfferSource.builder()
                                .url("https://www.unibet.com/betting/sports/filter/football/italy/serie_b/all/matches")
                                .description("SERIE_B")
                                .eventCompetition(SERIE_B)
                                .build(),
                        UnibetThreeWayBetOfferSource.builder()
                                .url("https://www.unibet.com/betting/sports/filter/football/italy/coppa_italia/all/matches")
                                .description("COPPA_ITALIA")
                                .eventCompetition(COPPA_ITALIA)
                                .build()
                )
           .build();
    }
}
