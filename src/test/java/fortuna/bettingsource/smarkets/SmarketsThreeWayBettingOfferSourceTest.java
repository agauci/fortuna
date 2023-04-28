package fortuna.bettingsource.smarkets;

import fortuna.bettingsource.BettingOfferSourceTest;
import fortuna.bettingsource.BettingSource;
import fortuna.bettingsource.paddypower.PaddyPowerBettingSource;
import fortuna.models.offer.ThreeWayBetOffer;
import org.junit.Test;

import static fortuna.models.competition.FootballCompetition.*;

public class SmarketsThreeWayBettingOfferSourceTest extends BettingOfferSourceTest<ThreeWayBetOffer> {

    @Test
    public void run_extraction() {
        run(LIGUE_1);
    }

    @Override
    protected BettingSource bettingSource() {
        return SmarketsBettingSource.builder().build();
    }
}
