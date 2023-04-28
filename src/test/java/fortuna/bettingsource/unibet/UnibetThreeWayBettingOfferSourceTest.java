package fortuna.bettingsource.unibet;

import fortuna.bettingsource.BetOfferSource;
import fortuna.bettingsource.BettingOfferSourceTest;
import fortuna.bettingsource.BettingSource;
import fortuna.models.offer.ThreeWayBetOffer;
import org.junit.Test;

import static fortuna.models.competition.FootballCompetition.LA_LIGA;
import static fortuna.models.competition.FootballCompetition.PREMIER_LEAGUE;

public class UnibetThreeWayBettingOfferSourceTest extends BettingOfferSourceTest<ThreeWayBetOffer> {

    @Test
    public void run_extraction() {
        run(LA_LIGA);
    }

    @Override
    protected BettingSource bettingSource() {
        return UnibetBettingSource.builder().build();
    }
}
