package fortuna.bettingsource.ejjabet;

import fortuna.bettingsource.BettingOfferSourceTest;
import fortuna.bettingsource.BettingSource;
import fortuna.bettingsource.izibet.IzibetBettingSource;
import fortuna.models.offer.ThreeWayBetOffer;
import org.junit.Test;

import static fortuna.models.competition.FootballCompetition.CYPRUS_LEAGUE_1;
import static fortuna.models.competition.FootballCompetition.PREMIER_LEAGUE;

public class EjjabetThreeWayBettingOfferSourceTest extends BettingOfferSourceTest<ThreeWayBetOffer> {

    @Test
    public void run_extraction() {
        run(CYPRUS_LEAGUE_1);
    }

    @Override
    protected BettingSource bettingSource() {
        return EjjabetBettingSource.builder().build();
    }
}
