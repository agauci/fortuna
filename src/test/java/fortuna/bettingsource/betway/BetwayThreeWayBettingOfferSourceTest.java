package fortuna.bettingsource.betway;

import fortuna.bettingsource.BettingOfferSourceTest;
import fortuna.bettingsource.BettingSource;
import fortuna.bettingsource.bwin.BwinBettingSource;
import fortuna.models.offer.ThreeWayBetOffer;
import org.junit.Test;

import static fortuna.models.competition.FootballCompetition.PREMIER_LEAGUE;

public class BetwayThreeWayBettingOfferSourceTest extends BettingOfferSourceTest<ThreeWayBetOffer> {

    @Test
    public void run_extraction() {
        run(PREMIER_LEAGUE);
    }

    @Override
    protected BettingSource bettingSource() {
        return BetwayBettingSource.builder().build();
    }
}
