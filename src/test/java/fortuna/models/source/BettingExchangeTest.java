package fortuna.models.source;

import fortuna.UnitTest;
import org.junit.Test;

import java.math.BigDecimal;

import static fortuna.models.source.BettingExchange.SMARKETS;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BettingExchangeTest extends UnitTest {

    @Test
    public void test_correct_true_odds_calculation() {
        assertThat(SMARKETS.calculateTrueOdds(new BigDecimal("1.20"))).isEqualByComparingTo(BigDecimal.valueOf(1.19));
        assertThat(SMARKETS.calculateTrueOdds(new BigDecimal("5.50"))).isEqualByComparingTo(BigDecimal.valueOf(5.41));
    }


}
