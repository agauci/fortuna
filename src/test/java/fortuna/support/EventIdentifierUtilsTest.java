package fortuna.support;

import org.junit.Test;

import java.util.List;

import static fortuna.models.competition.FootballCompetition.JAPAN_LEAGUE_3;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class EventIdentifierUtilsTest {

    @Test
    public void test_event_identifier_extraction() {
        assertThat(EventIdentifierUtils.buildIdentifier(List.of("Azul Claro Numazu","Ehime FC"), JAPAN_LEAGUE_3))
                .isEqualTo("AZUL_CLARO_NUMAZU_EHIME_JAPAN_LEAGUE_3");
    }

    @Test
    public void test_processString() {
        assertThat(EventIdentifierUtils.processString("1. FC Koln")).isEqualTo("KOLN");

        assertThat(EventIdentifierUtils.processString("VVV-Venlo")).isEqualTo("VENLO");

        assertThat(EventIdentifierUtils.processString("Shamrock Rovers FC")).isEqualTo("SHAMROCK");

        assertThat(EventIdentifierUtils.processString("Swansea City")).isEqualTo("SWANSEA");

        assertThat(EventIdentifierUtils.processString("Manchester United")).isEqualTo("MAN_UTD");

        assertThat(EventIdentifierUtils.processString("ABC Manchester")).isEqualTo("MAN");

        assertThat(EventIdentifierUtils.processString("Manchester AB")).isEqualTo("MAN");

        assertThat(EventIdentifierUtils.processString("Manchester ABC")).isEqualTo("MAN");

        assertThat(EventIdentifierUtils.processString("Goias EC GO")).isEqualTo("GOIAS");
    }

}
