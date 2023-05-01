package fortuna.support;

import akka.japi.Pair;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Map;
import java.util.Set;

import static fortuna.models.competition.FootballCompetition.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class NameSimilarityUtilsTest {

//    @Test
//    @Ignore
//    public void test_similarity() {
//        assertThat(NameSimilarityUtils.similarNames(Set.of("Manchester United"), Set.of(), "Manchester City")).isEqualTo(
//                Pair.apply(Set.of("Manchester United", "Manchester City"), Set.of(Set.of("Manchester United", "Manchester City")))
//        );
//
//        assertThat(NameSimilarityUtils.similarNames(Set.of("AAB"), Set.of(), "AAB Aalborg")).isEqualTo(
//                Pair.apply(Set.of("AAB", "AAB Aalborg"), Set.of(Set.of("AAB", "AAB Aalborg")))
//        );
//
//        assertThat(NameSimilarityUtils.similarNames(Set.of("Inter"), Set.of(), "Internazionale")).isEqualTo(
//                Pair.apply(Set.of("Inter", "Internazionale"), Set.of(Set.of("Inter", "Internazionale")))
//        );
//
//        assertThat(NameSimilarityUtils.similarNames(Set.of("Manchester United", "Manchester City"), Set.of(Set.of("Manchester United", "Manchester City")), "Tottenham")).isEqualTo(
//                Pair.apply(Set.of(), Set.of(Set.of("Manchester United", "Manchester City")))
//        );
//
//        assertThat(NameSimilarityUtils.similarNames(Set.of("Manchester United", "Manchester City"), Set.of(Set.of("Manchester United", "Manchester City")), "Man Utd B")).isEqualTo(
//                Pair.apply(Set.of("Manchester United", "Manchester City", "Man Utd B"), Set.of(Set.of("Manchester United", "Manchester City", "Man Utd B")))
//        );
//
//        assertThat(NameSimilarityUtils.similarNames(Set.of("Manchester United", "Manchester City", "Milan"), Set.of(Set.of("Manchester United", "Manchester City")), "AC Milan")).isEqualTo(
//                Pair.apply(Set.of("Milan", "AC Milan"), Set.of(Set.of("Manchester United", "Manchester City"), Set.of("Milan", "AC Milan")))
//        );
//    }

    @Test
    public void test_similarity_map() {
        assertThat(NameSimilarityUtils.eventIdentifierMismatch(Map.of(Pair.apply("Manchester United", "Manchester City"), Pair.apply("MANCHESTER_UTD_MANCHESTER_CITY", PREMIER_LEAGUE)), Pair.apply("Man Utd", "Man City"), "MAN_UTD_MAN_CITY", PREMIER_LEAGUE))
                .isPresent()
                .contains(Pair.apply(Pair.apply("Manchester United", "Manchester City"), Pair.apply("MANCHESTER_UTD_MANCHESTER_CITY", PREMIER_LEAGUE)));

        assertThat(NameSimilarityUtils.eventIdentifierMismatch(Map.of(Pair.apply("Manchester United", "Manchester City"), Pair.apply("MANCHESTER_UTD_MANCHESTER_CITY", PREMIER_LEAGUE)), Pair.apply("Tottenham", "Arsenal"), "TOTTENHAM_ARSENAL", PREMIER_LEAGUE))
                .isEmpty();

        assertThat(NameSimilarityUtils.eventIdentifierMismatch(Map.of(Pair.apply("AC Milan", "Napoli"), Pair.apply("AC_MILAN_NAPOLI", SERIE_A)), Pair.apply("Milan", "Napoli"), "MILAN_NAPOLI", SERIE_A))
                .isPresent()
                .contains(Pair.apply(Pair.apply("AC Milan", "Napoli"), Pair.apply("AC_MILAN_NAPOLI", SERIE_A)));

        assertThat(NameSimilarityUtils.eventIdentifierMismatch(Map.of(Pair.apply("Manchester United", "Manchester City"), Pair.apply("MAN_UTD_MAN_CITY", PREMIER_LEAGUE)), Pair.apply("Man Utd", "Man City"), "MAN_UTD_MAN_CITY", PREMIER_LEAGUE))
                .isEmpty();

        assertThat(NameSimilarityUtils.eventIdentifierMismatch(Map.of(Pair.apply("FC Nurnberg", "FC Kaiserslautern"),  Pair.apply("NURNBERG_KAISERSLAUTERN_BUNDESLIGA_2", BUNDESLIGA_2)), Pair.apply("FC Slovacko", "FC Zbrojovka Brno"), "SLOVACKO_ZBROJOVKA_BRNO_CZECH_REPUBLIC_LEAGUE_1", CZECH_REPUBLIC_LEAGUE_1))
                .isEmpty();

        assertThat(NameSimilarityUtils.eventIdentifierMismatch(Map.of(Pair.apply("Manchester United", "Manchester City"), Pair.apply("MAN_UTD_MAN_CITY_PREMIER_LEAGUE", PREMIER_LEAGUE)), Pair.apply("Man Utd", "Man City"), "MAN_UTD_MAN_CITY_FA_CUP", FA_CUP))
                .isEmpty();

        assertThat(NameSimilarityUtils.eventIdentifierMismatch(Map.of(Pair.apply("Skeid", "Moss"), Pair.apply("SKEID_MOSS_NORWAY_LEAGUE_2", NORWAY_LEAGUE_2)), Pair.apply("Start", "Raufoss"), "START_RAUFOSS_NORWAY_LEAGUE_2", NORWAY_LEAGUE_2))
                .isEmpty();

        assertThat(NameSimilarityUtils.eventIdentifierMismatch(Map.of(Pair.apply("Udinese", "Sampdoria"), Pair.apply("UDINESE_SAMPDORIA_SERIE_A", SERIE_A)), Pair.apply("Udinese", "Napoli"), "UDINESE_NAPOLI_SERIE_A", SERIE_A))
                .isEmpty();

        assertThat(NameSimilarityUtils.eventIdentifierMismatch(Map.of(Pair.apply("Lens", "Stade Reims"), Pair.apply("LENS_STADE_REIMS_LIGUE_1", LIGUE_1)), Pair.apply("Lorient", "Stade Brestois"), "LORIENT_STADE_BRESTOIS_LIGUE_1", LIGUE_1))
                .isEmpty();

        assertThat(NameSimilarityUtils.eventIdentifierMismatch(Map.of(Pair.apply("CA Union de Santa Fe","CA Lanus"), Pair.apply("UNION_LANUS_ARGENTINA_LEAGUE_1", ARGENTINA_LEAGUE_1)), Pair.apply("CA Independiente Avellaneda", "CA Belgrano Cordoba"), "INDEPENDIENTE_AVELLANEDA_BELGRANO_ARGENTINA_LEAGUE_1", ARGENTINA_LEAGUE_1))
                .isEmpty();

        assertThat(NameSimilarityUtils.eventIdentifierMismatch(Map.of(Pair.apply("Hapoel Bnei Sakhnin","Hapoel Hadera"), Pair.apply("HAPOEL_BNEI_SAKHNIN_HAPOEL_HADERA_ISRAEL_LEAGUE_1", ISRAEL_LEAGUE_1)), Pair.apply("Hapoel Tel-Aviv", "Hapoel Ironi Kiryat Shmona"), "HAPOEL_TEL_AVIV_HAPOEL_IRONI_KIRYAT_SHMONA_ISRAEL_LEAGUE_1", ISRAEL_LEAGUE_1))
                .isEmpty();
    }

}
