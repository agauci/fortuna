package fortuna.models.source;

import lombok.experimental.UtilityClass;
import org.apache.commons.lang3.EnumUtils;

import java.util.Optional;

@UtilityClass
public class BettingSourceTypeResolver {

    public final BettingSourceType resolve(String string) {
        return Optional.<BettingSourceType>ofNullable(EnumUtils.getEnum(Bookmaker.class, string))
                .orElse(EnumUtils.getEnum(BettingExchange.class, string));
    }

}
