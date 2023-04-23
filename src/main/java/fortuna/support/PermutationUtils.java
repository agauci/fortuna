package fortuna.support;

import com.google.common.collect.Collections2;
import com.google.common.collect.Sets;
import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@UtilityClass
public class PermutationUtils {

    public static <T> Set<List<T>> generatePermutations(Set<T> items, Integer n) {
        return Sets.combinations(items, n).stream()
                .flatMap(candidateSet -> Collections2.permutations(candidateSet).stream())
                .collect(Collectors.toSet());
    }

}
