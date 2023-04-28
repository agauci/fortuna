package fortuna.bettingsource.lvbet;

import fortuna.bettingsource.BettingOfferSourceTest;
import fortuna.bettingsource.BettingSource;
import fortuna.bettingsource.eighteighteight.EightEightEightBettingSource;
import fortuna.models.offer.ThreeWayBetOffer;
import org.junit.Test;

import static fortuna.models.competition.FootballCompetition.*;

public class LvbetThreeWayBettingOfferSourceTest extends BettingOfferSourceTest<ThreeWayBetOffer> {

    @Test
    public void run_extraction() {
        run(LIGUE_1);
    }

    @Override
    protected BettingSource bettingSource() {
        return LvbetEightBettingSource.builder().build();
    }
}
