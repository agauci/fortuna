package fortuna.support;

import akka.japi.Pair;
import com.google.common.base.CharMatcher;
import com.google.common.collect.ImmutableMap;
import fortuna.models.competition.EventCompetition;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.experimental.UtilityClass;
import org.apache.commons.lang3.StringUtils;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static fortuna.support.EventIdentifierUtils.Operation.of;
import static fortuna.support.EventIdentifierUtils.OperationType.*;


@UtilityClass
public class EventIdentifierUtils {

    private static final Map<String, Pair<String, Operation>> REPLACEMENTS = ImmutableMap.<String, Pair<String, Operation>>builder()
            .put("STRIP_INITIAL_STR_OF_LENGTH", Pair.apply("N/A", of(STRIP_INITIAL_STR_OF_LENGTH, List.of(2, 3), List.of("ST", "AZ", "MAN"))))

            .put("POFC_", Pair.apply("", of(REPLACE_START_WITH)))
            .put("CWKS_", Pair.apply("", of(REPLACE_START_WITH)))
            .put("STADE_", Pair.apply("", of(REPLACE_START_WITH)))
            .put("SLAVEN_", Pair.apply("", of(REPLACE_START_WITH)))
            .put("OLYMPIQUE_DE_", Pair.apply("", of(REPLACE_START_WITH)))
            .put("MFK_", Pair.apply("", of(REPLACE_START_WITH)))
            .put("RACING_", Pair.apply("", of(REPLACE_START_WITH)))
            .put("CLUB_", Pair.apply("", of(REPLACE_START_WITH)))
            .put("SPVGG_", Pair.apply("", of(REPLACE_START_WITH)))

            .put(" ", Pair.apply("_", of(REPLACE)))
            .put("&", Pair.apply("AND", of(REPLACE)))
            .put("__", Pair.apply("_", of(REPLACE)))
            .put("_CF_", Pair.apply("_", of(REPLACE)))
            .put("_FC_", Pair.apply("_", of(REPLACE)))
            .put("_SK_", Pair.apply("_", of(REPLACE)))
            .put("_DE_", Pair.apply("_", of(REPLACE)))
            .put("_AC_", Pair.apply("_", of(REPLACE)))
            .put("_DO_", Pair.apply("_", of(REPLACE)))
            .put("_S_C_", Pair.apply("_", of(REPLACE)))
            .put("_B_B_", Pair.apply("_", of(REPLACE)))
            .put("_CLUB_", Pair.apply("_", of(REPLACE)))
            .put("_CLUBE_", Pair.apply("_", of(REPLACE)))

            .put("MANCHESTER", Pair.apply("MAN", of(REPLACE)))
            .put("UNITED", Pair.apply("UTD", of(REPLACE)))
            .put("SAINT", Pair.apply("ST", of(REPLACE)))
            .put("SPORTS", Pair.apply("SPORT", of(REPLACE)))
            .put("BRIGHTON_AND_HOVE_ALBION", Pair.apply("BRIGHTON", of(REPLACE)))
            .put("MUNCHEN", Pair.apply("MUNICH", of(REPLACE)))
            .put("INTERNAZIONALE", Pair.apply("INTER", of(REPLACE)))
            .put("INTER_MILANO", Pair.apply("INTER", of(REPLACE)))
            .put("INTER_MILAN", Pair.apply("INTER", of(REPLACE)))
            .put("RED_BULLS", Pair.apply("RB", of(REPLACE)))
            .put("RED_BULL", Pair.apply("RB", of(REPLACE)))
            .put("PRAHA", Pair.apply("PRAGUE", of(REPLACE)))
            .put("AAB_AALBORG", Pair.apply("AAB", of(REPLACE)))
            .put("_WANDERERS", Pair.apply("", of(REPLACE)))
            .put("WOLVERHAMPTON", Pair.apply("WOLVES", of(REPLACE)))
            .put("MATSUMOTO_YAMAGA", Pair.apply("MATSUMOTO", of(REPLACE)))
            .put("URBS_SPORTIVA_REGGINA", Pair.apply("REGGINA", of(REPLACE)))
            .put("BELGRANO_CORDOBA", Pair.apply("BELGRANO", of(REPLACE)))
            .put("GRENOBLE_FOOT", Pair.apply("GRENOBLE", of(REPLACE)))
            .put("CHAMOIS_NIORTAIS", Pair.apply("NIORT", of(REPLACE)))
            .put("YOUNG_BOYS_BERN", Pair.apply("YOUNG_BOYS", of(REPLACE)))
            .put("ATLETICO_LANUS", Pair.apply("LANUS", of(REPLACE)))
            .put("LEVADEIAKOS", Pair.apply("LEVADIAKOS", of(REPLACE)))
            .put("COLORADO_RAPIDS", Pair.apply("COLORADO", of(REPLACE)))
            .put("NEW_ENGLAND_REVOLUTION", Pair.apply("NEW_ENGLAND", of(REPLACE)))
            .put("HELLAS_VERONA", Pair.apply("VERONA", of(REPLACE)))
            .put("CHOJNICZANKA", Pair.apply("CHOJ", of(REPLACE)))
            .put("PODBESKIDZIE_BIELSKOBIALA", Pair.apply("PODBESKIDZIE", of(REPLACE)))
            .put("HAMILTON_ACADEMICALS", Pair.apply("HAMILTON", of(REPLACE)))
            .put("HAMILTON_ACADEMICAL", Pair.apply("HAMILTON", of(REPLACE)))
            .put("INVERNESS_CALEDONIAN", Pair.apply("INVERNESS", of(REPLACE)))
            .put("HERTHA_BSC_BERLIN", Pair.apply("HERTHA_BERLIN", of(REPLACE)))
            .put("HERTHA_BERLIN", Pair.apply("HERTHA", of(REPLACE)))
            .put("REAL_SPORTING_DE_GIJON", Pair.apply("SPORTING_GIJON", of(REPLACE)))
            .put("KARLSRUHER", Pair.apply("KARLSRUHE", of(REPLACE)))
            .put("WATERFORD_UTD", Pair.apply("WATERFORD", of(REPLACE)))
            .put("LEGIA_WARSZAWA", Pair.apply("LEGIA_WARSAW", of(REPLACE)))
            .put("NAGOYA_GRAMPUS_EIGHT", Pair.apply("NAGOYA_GRAMPUS", of(REPLACE)))
            .put("CRACOVIA_KRAKOW", Pair.apply("CRACOVIA", of(REPLACE)))
            .put("LOKOMOTIVA_ZAGREB", Pair.apply("LOKOMOTIVA", of(REPLACE)))
            .put("ADMIRA_WACKER_MODLING", Pair.apply("ADMIRA", of(REPLACE)))
            .put("START_KRISTIANSAND", Pair.apply("START", of(REPLACE)))
            .put("ASANE_IL_ULSET", Pair.apply("ASANE", of(REPLACE)))
            .put("SKEID_OSLO", Pair.apply("SKEID", of(REPLACE)))
            .put("ATALANTA_BERGAMO", Pair.apply("ATALANTA", of(REPLACE)))
            .put("FUKUSHIMA_UTD", Pair.apply("FUKUSHIMA", of(REPLACE)))
            .put("SANTOS_FC_SAO_PAULO", Pair.apply("SANTOS", of(REPLACE)))
            .put("BRAGANTINO_RB", Pair.apply("BRAGANTINO", of(REPLACE)))
            .put("CORINTHIANS_PAULISTA", Pair.apply("CORINTHIANS", of(REPLACE)))
            .put("SPORTING_DA_COVILHA", Pair.apply("SPORTING_COVILHA", of(REPLACE)))
            .put("UNION_SAINTGILLOISE", Pair.apply("UNION_STGILLOISE", of(REPLACE)))
            .put("BRIGHTON_HOVE_ALBION", Pair.apply("BRIGHTON", of(REPLACE)))
            .put("NEWCASTLE_UTD", Pair.apply("NEWCASTLE", of(REPLACE)))
            .put("LEEDS_UTD", Pair.apply("LEEDS", of(REPLACE)))
            .put("TOTTENHAM_HOTSPUR", Pair.apply("TOTTENHAM", of(REPLACE)))
            .put("HAMBURGER", Pair.apply("HAMBURG", of(REPLACE)))
            .put("NURNBERG", Pair.apply("NUREMBERG", of(REPLACE)))
            .put("MONZA_BRIANZA", Pair.apply("MONZA", of(REPLACE)))
            .put("NOTTM_FOREST", Pair.apply("NOTTINGHAM_FOREST", of(REPLACE)))
            .put("REAL_VALLADOLID", Pair.apply("VALLADOLID", of(REPLACE)))
            .put("SLAVEN_BELUPO_KOPRIVNICA_RIJEKA", Pair.apply("SLAVEN", of(REPLACE)))
            .put("FIRST_VIENNA_FERNWARME", Pair.apply("FIRST_VIENNA", of(REPLACE)))
            .put("WIEN", Pair.apply("VIENNA", of(REPLACE)))
            .put("SION_SITTEN", Pair.apply("SION", of(REPLACE)))
            .put("SERVETTE_GENEVE", Pair.apply("SERVETTE", of(REPLACE)))
            .put("GREMIO_FB_PORTO_ALEGRENSE", Pair.apply("GREMIO", of(REPLACE)))
            .put("BOHEMIAN_", Pair.apply("BOHEMIANS_", of(REPLACE)))
            .put("SHELBOURNE_DUBLIN", Pair.apply("SHELBOURNE", of(REPLACE)))
            .put("ERZURUMSPOR", Pair.apply("ERZURUM", of(REPLACE)))
            .put("ESTORIL_PRAIA", Pair.apply("ESTORIL", of(REPLACE)))
            .put("ALBACETE_BALOMPIE", Pair.apply("ALBACETE", of(REPLACE)))
            .put("LUTON_TOWN", Pair.apply("LUTON", of(REPLACE)))
            .put("PRESTON_NORTH_END", Pair.apply("PRESTON", of(REPLACE)))
            .put("WEST_BROMWICH_ALBION", Pair.apply("WEST_BROM", of(REPLACE)))
            .put("MAKEDONIKOS_NEAPOLIS", Pair.apply("MAKEDONIKOS", of(REPLACE)))
            .put("ANAGENNISI_KARDITSAS", Pair.apply("ANAGENNISI_KARDITSA", of(REPLACE)))
            .put("HERACLES_ALMELO", Pair.apply("HERACLES", of(REPLACE)))
            .put("RODA_JC_KERKRADE", Pair.apply("RODA", of(REPLACE)))
            .put("WILLEM_II_TILBURG", Pair.apply("WILLEM_B", of(REPLACE)))
            .put("ALMERE_CITY", Pair.apply("ALMERE", of(REPLACE)))
            .put("SLAVEN_BELUPO", Pair.apply("SLAVEN", of(REPLACE)))
            .put("OMONIA_NICOSIA", Pair.apply("OMONIA", of(REPLACE)))
            .put("PAFOS", Pair.apply("PAPHOS", of(REPLACE)))
            .put("NEA_SALAMIS_FAMAGUSTA", Pair.apply("NEA_SALAMIS", of(REPLACE)))
            .put("KARMIOTISSA_PANO_POLEMIDION", Pair.apply("KARMIOTISSA", of(REPLACE)))
            .put("AKRITAS_CHLORAKA", Pair.apply("AKRITAS_CHLORAKAS", of(REPLACE)))
            .put("ANORTHOSIS_FAMAGUSTA", Pair.apply("ANORTHOSIS", of(REPLACE)))
            .put("LIMMASOL", Pair.apply("LIMASSOL", of(REPLACE)))
            .put("KYOTO_PURPLE_SANGA", Pair.apply("KYOTO_SANGA", of(REPLACE)))
            .put("LILLESTRM", Pair.apply("LILLESTROM", of(REPLACE)))
            .put("BOD_", Pair.apply("BODO_", of(REPLACE)))
            .put("VASCO_DA_GAMA", Pair.apply("VASCO", of(REPLACE)))
            .put("BIALYSTOCK", Pair.apply("BIALYSTOK", of(REPLACE)))
            .put("VEJLE_BOLDKLUB", Pair.apply("VEJLE", of(REPLACE)))
            .put("QUEVILLY_ROUEN", Pair.apply("QUEVILLY", of(REPLACE)))
            .put("QUEVILLY_METROPOLE", Pair.apply("QUEVILLY", of(REPLACE)))
            .put("HILLEROD_FODBOLD", Pair.apply("HILLEROD", of(REPLACE)))
            .put("INDEPENDIENTE_AVELLANEDA", Pair.apply("INDEPENDIENTE", of(REPLACE)))
            .put("OLYMPIACOS", Pair.apply("OLYMPIAKOS", of(REPLACE)))
            .put("PANAITOLIKOS", Pair.apply("PANETOLIKOS", of(REPLACE)))
            .put("OFI_CRETE", Pair.apply("OFI", of(REPLACE)))
            .put("IBIZA_EIVISSA", Pair.apply("IBIZA", of(REPLACE)))
            .put("CR_BRASIL", Pair.apply("CRB", of(REPLACE)))
            .put("GREMIO_NOVORIZONTINO", Pair.apply("NOVORIZONTINO", of(REPLACE)))
            .put("SPORT_CLUB_DO_RECIFE", Pair.apply("SPORT", of(REPLACE)))
            .put("RESOVIA_RZESZOW", Pair.apply("RESOVIA", of(REPLACE)))
            .put("CEARA_SC_FORTALEZA", Pair.apply("CEARA", of(REPLACE)))
            .put("SPORT_CLUB", Pair.apply("SPORT", of(REPLACE)))
            .put("GOTEBORG", Pair.apply("GOTHENBURG", of(REPLACE)))
            .put("CHLORAKAS", Pair.apply("CHLORAKA", of(REPLACE)))
            .put("BOHEMIANS_DUBLIN", Pair.apply("BOHEMIANS", of(REPLACE)))
            .put("HACKEN_GOTHENBURG", Pair.apply("HACKEN", of(REPLACE)))
            .put("SPORTING_CLUBE_PORTUGAL", Pair.apply("SPORTING_LISBON", of(REPLACE)))
            .put("ICHIHARA_CHIBA", Pair.apply("CHIBA", of(REPLACE)))
            .put("SHEFFIELD", Pair.apply("SHEFF", of(REPLACE)))
            .put("RB_SALZBURG", Pair.apply("SALZBURG", Operation.of(REPLACE)))
            .put("SOCHAUX_MONTBELIARD", Pair.apply("SOCHAUX", Operation.of(REPLACE)))
            .put("NIMES_OLYMPIQUE", Pair.apply("NIMES", Operation.of(REPLACE)))
            .put("WATTENS_SWAROVSKI_TIROL", Pair.apply("WATTENS", Operation.of(REPLACE)))
            .put("BRESTOIS", Pair.apply("BREST", Operation.of(REPLACE)))
            .put("STRASBOURG_ALSACE", Pair.apply("STRASBOURG", Operation.of(REPLACE)))
            .put("RENNAIS", Pair.apply("RENNES", Operation.of(REPLACE)))
            .put("NEWELLS_OLD_BOYS", Pair.apply("NEWELLS", Operation.of(REPLACE)))
            .put("BURTON_ALBION", Pair.apply("BURTON", Operation.of(REPLACE)))
            .put("GRASSHOPPER_", Pair.apply("GRASSHOPPERS_", Operation.of(REPLACE)))
            .put("ACCRINGTON_STANLEY", Pair.apply("ACCRINGTON", Operation.of(REPLACE)))
            .put("PLYMOUTH_ARGYLE", Pair.apply("PLYMOUTH", Operation.of(REPLACE)))
            .put("ARDA_KARDZHALI", Pair.apply("ARDA", Operation.of(REPLACE)))
            .put("CHERNO_MORE_VARNA", Pair.apply("CHERNO", Operation.of(REPLACE)))
            .put("BEROE_STARA_ZAGORA", Pair.apply("BEROE", Operation.of(REPLACE)))
            .put("HEART_OF_MIDLOTHIAN", Pair.apply("HEARTS", Operation.of(REPLACE)))
            .put("ATLETICO CLUBE GOIANENSE", Pair.apply("ATLETICO", Operation.of(REPLACE)))
            .put("GUARANI_CAMPINAS", Pair.apply("GUARANI", Operation.of(REPLACE)))
            .put("ODDS_BALLKLUBB", Pair.apply("ODD", Operation.of(REPLACE)))
            .put("AALESUNDS", Pair.apply("AALESUND", Operation.of(REPLACE)))
            .put("BRANN_BERGEN", Pair.apply("BRANN", Operation.of(REPLACE)))
            .put("VIKING_STAVANGER", Pair.apply("VIKING", Operation.of(REPLACE)))
            .put("IWATE_GRULLA_MORIOKA", Pair.apply("GRULLA_MORIOKA", Operation.of(REPLACE)))
            .put("AIRDRIEONIANS", Pair.apply("AIRDRIE", Operation.of(REPLACE)))
            .put("LAVALLOIS_MAYENNE", Pair.apply("LAVAL", Operation.of(REPLACE)))
            .put("CREWE_ALEXANDRIA", Pair.apply("CREWE", Operation.of(REPLACE)))
            .put("ATLETICO_GOIANIENSE", Pair.apply("ATLETICO_GO", Operation.of(REPLACE)))
            .put("SANTOS_SAO_PAULO", Pair.apply("SANTOS", Operation.of(REPLACE)))
            .put("ATLETICO_MG", Pair.apply("ATLETICO_MINEIRO", Operation.of(REPLACE)))
            .put("CUIABA_ESPORTE", Pair.apply("CUIABA", Operation.of(REPLACE)))
            .put("CAMBUUR_LEEUWARDEN", Pair.apply("CAMBUUR", Operation.of(REPLACE)))
            .put("AJAX_AMSTERDAM", Pair.apply("AJAX", Operation.of(REPLACE)))
            .put("TWENTE_ENSCHEDE", Pair.apply("TWENTE", Operation.of(REPLACE)))
            .put("VITESSE_ARNHEM", Pair.apply("VITESSE", Operation.of(REPLACE)))
            .put("ATHINON", Pair.apply("ATHENS", Operation.of(REPLACE)))
            .put("MONTREAL_IMPACT", Pair.apply("MONTREAL", Operation.of(REPLACE)))
            .put("_BIELSKO_BIALA_", Pair.apply("_", Operation.of(REPLACE)))
            //.put("NURNBERG", Pair.apply("NUREMBERG", Operation.of(REPLACE)))
            //.put("NURNBERG", Pair.apply("NUREMBERG", Operation.of(REPLACE)))
            //.put("NURNBERG", Pair.apply("NUREMBERG", Operation.of(REPLACE)))
            //.put("NURNBERG", Pair.apply("NUREMBERG", Operation.of(REPLACE)))
            //.put("NURNBERG", Pair.apply("NUREMBERG", Operation.of(REPLACE)))
            //.put("NURNBERG", Pair.apply("NUREMBERG", Operation.of(REPLACE)))
            //.put("NURNBERG", Pair.apply("NUREMBERG", Operation.of(REPLACE)))
            //.put("NURNBERG", Pair.apply("NUREMBERG", Operation.of(REPLACE)))
            //.put("NURNBERG", Pair.apply("NUREMBERG", Operation.of(REPLACE)))

            .put("_II", Pair.apply("_B", of(REPLACE_END_WITH)))
            .put("_A", Pair.apply("_B", of(REPLACE_END_WITH)))
            .put("_AM", Pair.apply("_B", of(REPLACE_END_WITH)))
            .put("_S_CC", Pair.apply("_SCC", of(REPLACE_END_WITH)))
            .put("_F_C", Pair.apply("", of(REPLACE_END_WITH)))
            .put("_OSLO", Pair.apply("", of(REPLACE_END_WITH)))
            .put("_DUBLIN", Pair.apply("", of(REPLACE_END_WITH)))
            .put("_ROTTERDAM", Pair.apply("", of(REPLACE_END_WITH)))
            .put("_NICOSIA", Pair.apply("", of(REPLACE_END_WITH)))
            .put("_AGRINIO", Pair.apply("", of(REPLACE_END_WITH)))
            .put("_PIRAEUS", Pair.apply("", of(REPLACE_END_WITH)))
            .put("_NIKEA", Pair.apply("", of(REPLACE_END_WITH)))



            .put("STRIP_END_STR_OF_LENGTH", Pair.apply("N/A", of(STRIP_END_STR_OF_LENGTH, List.of(2, 3), List.of("UTD", "FE", "HAM", "PIA", "WED"))))

            .put("_CALCIO", Pair.apply("", of(REPLACE_END_WITH)))
            .put("_FUTEBOL", Pair.apply("", of(REPLACE_END_WITH)))
            .put("_FOTBALL", Pair.apply("", of(REPLACE_END_WITH)))
            .put("_SPORT", Pair.apply("", of(REPLACE_END_WITH)))
            .put("_ROVERS", Pair.apply("", of(REPLACE_END_WITH)))
            .put("_TOWN", Pair.apply("", of(REPLACE_END_WITH)))
            .put("_COUNTY", Pair.apply("", of(REPLACE_END_WITH)))
            .put("_CLUBE", Pair.apply("", of(REPLACE_END_WITH)))
            .put("_ATHLETIC", Pair.apply("", of(REPLACE_END_WITH)))
            .put("_ATLETICO", Pair.apply("", of(REPLACE_END_WITH)))
            .put("_S_PULSE", Pair.apply("", Operation.of(REPLACE_END_WITH)))
            .put("_THISTLE", Pair.apply("", of(REPLACE_END_WITH)))
            .put("_DE_CORDOBA", Pair.apply("", of(REPLACE_END_WITH)))
            .put("_DE_SANTA_FE", Pair.apply("", of(REPLACE_END_WITH)))
            .put("_AMATEURE", Pair.apply("_B", of(REPLACE_END_WITH)))
            .put("_AMAT", Pair.apply("_B", of(REPLACE_END_WITH)))
            .put("_DEVENTER", Pair.apply("_B", of(REPLACE_END_WITH)))
            .put("_VORTIS", Pair.apply("_B", of(REPLACE_END_WITH)))

            .put("_CITY", Pair.apply("", of(REPLACE_END_WITH_EXCLUDING, "MAN_CITY")))
            .put("_UTD", Pair.apply("", of(REPLACE_END_WITH_EXCLUDING, "MAN_UTD", "SHEFF_UTD")))
            .build();

    public static String buildIdentifier(final List<String> participants, final EventCompetition eventCompetition) {
        return Stream.of(cleanString(participants.get(0)), cleanString(participants.get(1)), eventCompetition.toString())
                .map(EventIdentifierUtils::performReplacement)
                .collect(Collectors.joining("_"))
                .replace("__", "_");
    }

    public static String processString(String str) {
        return performReplacement(cleanString(str));
    }

    private static String performReplacement(final String str) {
        String replacedString = str;
        for (var entry : REPLACEMENTS.entrySet()) {
            switch (entry.getValue().second().operationType) {
                case REPLACE -> {
                    replacedString = replacedString.replace(entry.getKey(), entry.getValue().first());
                }
                case REPLACE_END_WITH -> {
                    if (replacedString.endsWith(entry.getKey())) {
                        replacedString = replacedString.replace(entry.getKey(), entry.getValue().first());
                    }
                }
                case REPLACE_END_WITH_EXCLUDING -> {
                    if (!entry.getValue().second().params.contains(replacedString) && replacedString.endsWith(entry.getKey())) {
                        replacedString = replacedString.replace(entry.getKey(), entry.getValue().first());
                    }
                }
                case REPLACE_START_WITH -> {
                    if (replacedString.startsWith(entry.getKey())) {
                        replacedString = replacedString.replace(entry.getKey(), entry.getValue().first());
                    }
                }
                case STRIP_INITIAL_STR_OF_LENGTH -> {
                    boolean done = false;

                    while (!done) {
                        String[] splitName = replacedString.split("_");
                        List<Integer> lengths = (List<Integer>) entry.getValue().second().params.get(0);
                        List<String> exclusions = (entry.getValue().second().params.size() > 1) ? (List<String>) entry.getValue().second().params.get(1) : Collections.emptyList();

                        if (splitName.length >= 2 && lengths.contains(splitName[0].length()) && !exclusions.contains(splitName[0])) {
                            replacedString = replacedString.substring(splitName[0].length() + 1);
                        } else {
                            done = true;
                        }
                    }
                }
                case STRIP_END_STR_OF_LENGTH -> {
                    boolean done = false;

                    while (!done) {
                        String[] splitName = replacedString.split("_");
                        List<Integer> lengths = (List<Integer>) entry.getValue().second().params.get(0);
                        List<String> exclusions = (entry.getValue().second().params.size() > 1) ? (List<String>) entry.getValue().second().params.get(1) : Collections.emptyList();

                        if (splitName.length >= 2 && lengths.contains(splitName[splitName.length - 1].length()) && !exclusions.contains(splitName[splitName.length - 1])) {
                            replacedString = Stream.of(splitName).limit(splitName.length - 1).collect(Collectors.joining("_"));
                        } else {
                            done = true;
                        }
                    }
                }
            }
        }

        return replacedString;
    }

    private static String cleanString(final String str) {
        // Replace .,- with white space
        String newStr = str.replaceAll("[-,./]", " ")
                .replace("°", "o")
                .replace("ø", "o")
                .replace("æ", "ae");

        // Remove non-alphabetic symbols
        newStr = StringUtils.stripAccents(CharMatcher.inRange('a', 'z').or(CharMatcher.inRange('A', 'Z')).or(CharMatcher.is(' ')).retainFrom(newStr));

        // convert to uppercase, replace white spaces with "_"
        return newStr.toUpperCase().trim().replace(" ", "_");
    }

    enum OperationType {REPLACE, REPLACE_END_WITH, REPLACE_START_WITH, REPLACE_END_WITH_EXCLUDING, STRIP_INITIAL_STR_OF_LENGTH, STRIP_END_STR_OF_LENGTH}

    @AllArgsConstructor
    @Data
    protected static class Operation {
        OperationType operationType;
        List<Object> params;

        public static Operation of(OperationType operationType, Object... params) {
            return new Operation(operationType, List.of(params));
        }
    }
}
