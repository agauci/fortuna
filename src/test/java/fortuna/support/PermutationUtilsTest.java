package fortuna.support;

import fortuna.UnitTest;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;


public class PermutationUtilsTest extends UnitTest {

    @Test
    public void test_successful_permutations() {
        assertThat(PermutationUtils.generatePermutations(IntStream.range(0, 5).boxed().collect(Collectors.toSet()), 2))
                .hasSize(20)
                .contains(
                      List.of(0, 1),
                      List.of(1, 0),
                      List.of(0, 2),
                      List.of(2, 0),
                      List.of(0, 3),
                      List.of(3, 0),
                      List.of(0, 4),
                      List.of(4, 0),
                      List.of(1, 2),
                      List.of(2, 1),
                      List.of(1, 3),
                      List.of(3, 1),
                      List.of(1, 4),
                      List.of(4, 1),
                      List.of(2, 3),
                      List.of(3, 2),
                      List.of(2, 4),
                      List.of(4, 2),
                      List.of(3, 4),
                      List.of(4, 3)
                );
    }

    @Test
    public void test_successful_permutations_speed() {
        long timestamp = System.currentTimeMillis();
        PermutationUtils.generatePermutations(IntStream.range(0, 20).boxed().collect(Collectors.toSet()), 2);
        assertThat(System.currentTimeMillis() - timestamp).isLessThanOrEqualTo(100);
    }

}
