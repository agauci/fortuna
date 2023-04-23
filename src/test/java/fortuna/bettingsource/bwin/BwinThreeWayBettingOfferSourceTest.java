package fortuna.bettingsource.bwin;

import fortuna.bettingsource.BetOfferSource;
import fortuna.bettingsource.BettingOfferSourceTest;
import fortuna.bettingsource.BettingSource;
import fortuna.bettingsource.unibet.UnibetThreeWayBetOfferSource;
import fortuna.models.offer.ThreeWayBetOffer;
import org.junit.Test;

import static fortuna.models.competition.FootballCompetition.CHAMPIONSHIP;
import static fortuna.models.competition.FootballCompetition.PREMIER_LEAGUE;

public class BwinThreeWayBettingOfferSourceTest extends BettingOfferSourceTest<ThreeWayBetOffer> {

    @Test
    public void run_extraction() {
        run(PREMIER_LEAGUE);
    }

    @Override
    protected BettingSource bettingSource() {
        return BwinBettingSource.builder().build();
    }
}
