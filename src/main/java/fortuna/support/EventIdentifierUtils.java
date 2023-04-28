package fortuna.support;

import com.google.common.base.CharMatcher;
import com.google.common.collect.ImmutableMap;
import fortuna.models.competition.EventCompetition;
import lombok.experimental.UtilityClass;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@UtilityClass
public class EventIdentifierUtils {

    private static final Map<String, String> REPLACEMENTS = ImmutableMap.<String, String>builder()
            .put(" ", "_")
            .put("&", "AND")
            .put("_FC", "")
            .put("_AFC", "")
            .put("MANCHESTER", "MAN")
            .put("UNITED", "UTD")
            .put("BRIGHTON_AND_HOVE_ALBION", "BRIGHTON")
            .put("WEST_HAM_UNITED", "WEST_HAM")
            .put("LEEDS_UNITED", "LEEDS")
            .put("NEWCASTLE_UNITED", "NEWCASTLE")
            .put("MUNCHEN", "MUNICH")
            .put("INTERNAZIONALE", "INTER")
            .put("INTER_MILAN", "INTER")
            .put("SSD_MONZA_1912", "MONZA")
            .put("RED_BULL", "RB")
            .put("_WANDERERS", "")
            .put("WOLVERHAMPTON", "WOLVES")
            .put("__", "_")
            .build();

    public static String buildIdentifier(final List<String> participants, final EventCompetition eventCompetition) {
        return performReplacement(
                    CharMatcher.inRange('0', '9').or(CharMatcher.inRange('a', 'z')).or(CharMatcher.inRange('A', 'Z')).or(CharMatcher.is('_'))
                        .retainFrom(
                                StringUtils.stripAccents(
                                        Stream.of(participants.get(0), participants.get(1), eventCompetition.toString())
                                                .map(participant -> performReplacement(participant.toUpperCase()))
                                                .collect(Collectors.joining("_"))
                                )
                        )
              );
    }

    private static String performReplacement(final String str) {
        String replacedString = str;
        for (var entry : REPLACEMENTS.entrySet()) {
            replacedString = replacedString.replace(entry.getKey(), entry.getValue());
        }

        return replacedString.replaceAll("[0-9]","");
    }
}
