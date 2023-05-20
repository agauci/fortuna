package fortuna.bettingsource.pinnacle;

import fortuna.bettingsource.BettingOfferSourceTest;
import fortuna.bettingsource.BettingSource;
import fortuna.bettingsource.paddypower.PaddyPowerBettingSource;
import fortuna.models.offer.ThreeWayBetOffer;
import org.junit.Test;

import static fortuna.models.competition.FootballCompetition.*;

public class PinnacleThreeWayBettingOfferSourceTest extends BettingOfferSourceTest<ThreeWayBetOffer> {

    @Test
    public void run_extraction() {
        run(LIGUE_2);
    }

    @Override
    protected BettingSource bettingSource() {
        return PinnacleBettingSource.builder().build();
    }
}
