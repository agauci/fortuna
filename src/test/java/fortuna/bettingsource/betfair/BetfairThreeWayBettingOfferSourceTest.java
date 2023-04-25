package fortuna.bettingsource.betfair;

import fortuna.bettingsource.BettingOfferSourceTest;
import fortuna.bettingsource.BettingSource;
import fortuna.bettingsource.betway.BetwayBettingSource;
import fortuna.models.offer.ThreeWayBetOffer;
import org.junit.Test;

import static fortuna.models.competition.FootballCompetition.CHAMPIONSHIP;
import static fortuna.models.competition.FootballCompetition.PREMIER_LEAGUE;

public class BetfairThreeWayBettingOfferSourceTest extends BettingOfferSourceTest<ThreeWayBetOffer> {

    @Test
    public void run_extraction() {
        run(CHAMPIONSHIP);
    }

    @Override
    protected BettingSource bettingSource() {
        return BetfairBettingSource.builder().build();
    }
}
