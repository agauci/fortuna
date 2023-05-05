package fortuna.bettingsource.stake;

import fortuna.bettingsource.BettingOfferSourceTest;
import fortuna.bettingsource.BettingSource;
import fortuna.bettingsource.pinnacle.PinnacleBettingSource;
import fortuna.models.offer.ThreeWayBetOffer;
import org.junit.Test;

import static fortuna.models.competition.FootballCompetition.*;

public class StakeThreeWayBettingOfferSourceTest extends BettingOfferSourceTest<ThreeWayBetOffer> {

    @Test
    public void run_extraction() {
        run(SERIE_B);
    }

    @Override
    protected BettingSource bettingSource() {
        return StakeBettingSource.builder().build();
    }
}
