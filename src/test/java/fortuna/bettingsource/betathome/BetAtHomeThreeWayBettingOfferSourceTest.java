package fortuna.bettingsource.betathome;

import fortuna.bettingsource.BettingOfferSourceTest;
import fortuna.bettingsource.BettingSource;
import fortuna.models.offer.ThreeWayBetOffer;
import org.junit.Test;

import static fortuna.models.competition.FootballCompetition.LIGUE_1;
import static fortuna.models.competition.FootballCompetition.PREMIER_LEAGUE;

public class BetAtHomeThreeWayBettingOfferSourceTest extends BettingOfferSourceTest<ThreeWayBetOffer> {

    @Test
    public void run_extraction() {
        run(LIGUE_1);
    }

    @Override
    protected BettingSource bettingSource() {
        return BetAtHomeBettingSource.builder().build();
    }
}
