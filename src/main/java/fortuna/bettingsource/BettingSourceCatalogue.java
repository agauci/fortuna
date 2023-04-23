package fortuna.bettingsource;

import com.google.common.collect.ImmutableList;
import fortuna.bettingsource.betway.BetwayBettingSource;
import fortuna.bettingsource.bwin.BwinBettingSource;
import fortuna.bettingsource.unibet.UnibetBettingSource;
import lombok.experimental.UtilityClass;

import java.util.List;

@UtilityClass
public class BettingSourceCatalogue {

    public static List<BettingSource> BETTING_SOURCES = ImmutableList.<BettingSource>builder()
            .add(UnibetBettingSource.builder().build())
            .add(BwinBettingSource.builder().build())
            .add(BetwayBettingSource.builder().build())
            .build();

}
