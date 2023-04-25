package fortuna.bettingsource.betsafe;

import fortuna.bettingsource.BettingOfferSourceTest;
import fortuna.bettingsource.BettingSource;
import fortuna.bettingsource.betfair.BetfairBettingSource;
import fortuna.bettingsource.betsafe.BetsafeBettingSource;
import fortuna.models.offer.ThreeWayBetOffer;
import org.junit.Test;

import static fortuna.models.competition.FootballCompetition.CHAMPIONSHIP;
import static fortuna.models.competition.FootballCompetition.SERIE_A;

public class BetsafeThreeWayBettingOfferSourceTest extends BettingOfferSourceTest<ThreeWayBetOffer> {

    @Test
    public void run_extraction() {
        run(SERIE_A);
    }

    @Override
    protected BettingSource bettingSource() {
        return BetsafeBettingSource.builder().build();
    }
}
