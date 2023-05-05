package fortuna.bettingsource.betfair;

import fortuna.bettingsource.BettingOfferSourceTest;
import fortuna.bettingsource.BettingSource;
import fortuna.bettingsource.betway.BetwayBettingSource;
import fortuna.models.offer.ThreeWayBetOffer;
import org.junit.Test;

import static fortuna.models.competition.FootballCompetition.*;

public class BetfairThreeWayBettingOfferSourceTest extends BettingOfferSourceTest<ThreeWayBetOffer> {

    @Test
    public void run_extraction() {
        run(BULGARIA_LEAGUE_1);
    }

    @Override
    protected BettingSource bettingSource() {
        return BetfairBettingSource.builder().build();
    }
}
