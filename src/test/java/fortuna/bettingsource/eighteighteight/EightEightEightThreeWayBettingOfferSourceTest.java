package fortuna.bettingsource.eighteighteight;

import fortuna.bettingsource.BettingOfferSourceTest;
import fortuna.bettingsource.BettingSource;
import fortuna.bettingsource.unibet.UnibetBettingSource;
import fortuna.models.offer.ThreeWayBetOffer;
import org.junit.Test;

import static fortuna.models.competition.FootballCompetition.LIGUE_1;
import static fortuna.models.competition.FootballCompetition.PREMIER_LEAGUE;

public class EightEightEightThreeWayBettingOfferSourceTest extends BettingOfferSourceTest<ThreeWayBetOffer> {

    @Test
    public void run_extraction() {
        run(LIGUE_1);
    }

    @Override
    protected BettingSource bettingSource() {
        return EightEightEightBettingSource.builder().build();
    }
}
