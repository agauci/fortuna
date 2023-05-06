package fortuna.bettingsource;

import com.google.common.collect.ImmutableList;
import fortuna.bettingsource.betathome.BetAtHomeBettingSource;
import fortuna.bettingsource.betfair.BetfairBettingSource;
import fortuna.bettingsource.betfair.BetfairExchangeBettingSource;
import fortuna.bettingsource.betsafe.BetsafeBettingSource;
import fortuna.bettingsource.betway.BetwayBettingSource;
import fortuna.bettingsource.bwin.BwinBettingSource;
import fortuna.bettingsource.eighteighteight.EightEightEightBettingSource;
import fortuna.bettingsource.ejjabet.EjjabetBettingSource;
import fortuna.bettingsource.izibet.IzibetBettingSource;
import fortuna.bettingsource.lvbet.LvbetEightBettingSource;
import fortuna.bettingsource.paddypower.PaddyPowerBettingSource;
import fortuna.bettingsource.pinnacle.PinnacleBettingSource;
import fortuna.bettingsource.sbobet.SbobetBettingSource;
import fortuna.bettingsource.smarkets.SmarketsBettingSource;
import fortuna.bettingsource.stake.StakeBettingSource;
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
            //.add(UnibetBettingSource.builder().build())
            //.add(BwinBettingSource.builder().build())
            //.add(BetwayBettingSource.builder().build())
            .add(BetfairBettingSource.builder().build())
            .add(WilliamHillBettingSource.builder().build())
            //.add(PaddyPowerBettingSource.builder().build())
            //.add(EightEightEightBettingSource.builder().build())
            //.add(BetsafeBettingSource.builder().build())
            //.add(LvbetEightBettingSource.builder().build())
            //.add(BetAtHomeBettingSource.builder().build())
            //.add(IzibetBettingSource.builder().build())
            //.add(EjjabetBettingSource.builder().build())
            .add(SmarketsBettingSource.builder().build())
            .add(PinnacleBettingSource.builder().build())
            //.add(StakeBettingSource.builder().build())
            .add(BetfairExchangeBettingSource.builder().build())
            .add(SbobetBettingSource.builder().build())
            .build();

    public static String resolveUrl(final BetOffer<?> offer) {
        return BETTING_SOURCES.stream().filter(source -> source.getType().equals(offer.getBettingSourceType())).findFirst().flatMap(bettingSource -> bettingSource.sources().stream()
                .filter(offerSource -> offerSource.getEventCompetition().isPresent() && offerSource.getEventCompetition().get().equals(offer.getEventCompetition())).map(BetOfferSource::getUrl).findFirst()).orElse(null);
    }

}
