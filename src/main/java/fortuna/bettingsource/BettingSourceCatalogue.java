package fortuna.bettingsource;

import com.google.common.collect.ImmutableList;
import fortuna.bettingsource.betathome.BetAtHomeBettingSource;
import fortuna.bettingsource.betfair.BetfairBettingSource;
import fortuna.bettingsource.betsafe.BetsafeBettingSource;
import fortuna.bettingsource.betway.BetwayBettingSource;
import fortuna.bettingsource.bwin.BwinBettingSource;
import fortuna.bettingsource.eighteighteight.EightEightEightBettingSource;
import fortuna.bettingsource.lvbet.LvbetEightBettingSource;
import fortuna.bettingsource.paddypower.PaddyPowerBettingSource;
import fortuna.bettingsource.unibet.UnibetBettingSource;
import fortuna.bettingsource.williamhill.WilliamHillBettingSource;
import fortuna.models.competition.EventCompetition;
import fortuna.models.offer.BetOffer;
import fortuna.models.source.BettingSourceType;
import lombok.experimental.UtilityClass;

import java.util.List;

@UtilityClass
public class BettingSourceCatalogue {

    public static List<BettingSource> BETTING_SOURCES = ImmutableList.<BettingSource>builder()
            .add(UnibetBettingSource.builder().build())
            .add(BwinBettingSource.builder().build())
            .add(BetwayBettingSource.builder().build())
            .add(BetfairBettingSource.builder().build())
            .add(WilliamHillBettingSource.builder().build())
            .add(PaddyPowerBettingSource.builder().build())
            .add(EightEightEightBettingSource.builder().build())
            .add(BetsafeBettingSource.builder().build())
            .add(LvbetEightBettingSource.builder().build())
            .add(BetAtHomeBettingSource.builder().build())
            .build();

    public static String resolveUrl(final BetOffer<?> offer) {
        return BETTING_SOURCES.stream().filter(source -> source.getType().equals(offer.getBettingSourceType())).findFirst()
                .map(bettingSource -> bettingSource.sources().stream()
                        .filter(offerSource -> offerSource.getEventCompetition().orElseThrow().equals(offer.getEventCompetition())).map(BetOfferSource::getUrl).findFirst().orElse(null)).orElse(null);
    }

}
