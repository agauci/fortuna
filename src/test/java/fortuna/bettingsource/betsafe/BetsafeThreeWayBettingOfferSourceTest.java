package fortuna.bettingsource.betsafe;

import fortuna.bettingsource.BettingOfferSourceTest;
import fortuna.bettingsource.BettingSource;
import fortuna.bettingsource.betfair.BetfairBettingSource;
import fortuna.bettingsource.betsafe.BetsafeBettingSource;
import fortuna.models.offer.ThreeWayBetOffer;
import org.junit.Test;

import static fortuna.models.competition.FootballCompetition.*;

public class BetsafeThreeWayBettingOfferSourceTest extends BettingOfferSourceTest<ThreeWayBetOffer> {

    @Test
    public void run_extraction() {
        run(SUPER_LIG_TURKEY);
    }

    @Override
    protected BettingSource bettingSource() {
        return BetsafeBettingSource.builder().build();
    }
}
