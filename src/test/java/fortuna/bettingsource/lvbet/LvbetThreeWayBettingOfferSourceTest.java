package fortuna.bettingsource.lvbet;

import fortuna.bettingsource.BettingOfferSourceTest;
import fortuna.bettingsource.BettingSource;
import fortuna.bettingsource.eighteighteight.EightEightEightBettingSource;
import fortuna.models.offer.ThreeWayBetOffer;
import org.junit.Test;

import static fortuna.models.competition.FootballCompetition.PREMIER_LEAGUE;
import static fortuna.models.competition.FootballCompetition.SERIE_B;

public class LvbetThreeWayBettingOfferSourceTest extends BettingOfferSourceTest<ThreeWayBetOffer> {

    @Test
    public void run_extraction() {
        run(SERIE_B);
    }

    @Override
    protected BettingSource bettingSource() {
        return LvbetEightBettingSource.builder().build();
    }
}
