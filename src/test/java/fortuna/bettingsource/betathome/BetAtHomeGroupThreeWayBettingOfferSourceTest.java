package fortuna.bettingsource.betathome;

import fortuna.bettingsource.BettingOfferSourceTest;
import fortuna.bettingsource.BettingSource;
import fortuna.models.offer.ThreeWayBetOffer;
import org.junit.Test;

import static fortuna.models.competition.FootballCompetition.LIGUE_1;

public class BetAtHomeGroupThreeWayBettingOfferSourceTest extends BettingOfferSourceTest<ThreeWayBetOffer> {

    @Test
    public void run_extraction() {
        run("BELGIUM");
    }

    @Override
    protected BettingSource bettingSource() {
        return BetAtHomeBettingSource.builder().build();
    }
}
