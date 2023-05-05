package fortuna.bettingsource.sbobet;

import fortuna.bettingsource.BettingOfferSourceTest;
import fortuna.bettingsource.BettingSource;
import fortuna.bettingsource.pinnacle.PinnacleBettingSource;
import fortuna.models.offer.ThreeWayBetOffer;
import org.junit.Test;

import static fortuna.models.competition.FootballCompetition.*;

public class SbobetThreeWayBettingOfferSourceTest extends BettingOfferSourceTest<ThreeWayBetOffer> {

    @Test
    public void run_extraction() {
        run(PORTUGAL_CUP);
    }

    @Override
    protected BettingSource bettingSource() {
        return SbobetBettingSource.builder().build();
    }
}
