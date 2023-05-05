package fortuna.models.source;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public enum BettingExchange implements BettingSourceType {
    BETFAIR_EXCHANGE(BigDecimal.valueOf(0.05)),
    SMARKETS(BigDecimal.valueOf(0.02));

    private BigDecimal commission;

    BettingExchange(BigDecimal commission) {
        this.commission = commission;
    }

    public BigDecimal calculateTrueOdds(BigDecimal originalOdds) {
        // Retain the same precision as the original odds
        return BigDecimal.ONE.add(BigDecimal.ONE.subtract(commission).multiply(originalOdds.subtract(BigDecimal.ONE))).round(new MathContext(originalOdds.precision(), RoundingMode.DOWN));
    }

}
