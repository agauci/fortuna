package fortuna.bettingsource.paddypower;

import fortuna.bettingsource.BettingOfferSourceTest;
import fortuna.bettingsource.BettingSource;
import fortuna.bettingsource.betfair.BetfairBettingSource;
import fortuna.models.offer.ThreeWayBetOffer;
import org.junit.Test;

import static fortuna.models.competition.FootballCompetition.*;

public class PaddyPowerThreeWayBettingOfferSourceTest extends BettingOfferSourceTest<ThreeWayBetOffer> {

    @Test
    public void run_extraction() {
        run(DFB_POKAL);
    }

    @Override
    protected BettingSource bettingSource() {
        return PaddyPowerBettingSource.builder().build();
    }
}
