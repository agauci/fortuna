package fortuna.support;

import akka.japi.Pair;
import fortuna.engine.ArbitrageEngineSupervisor;
import fortuna.engine.ArbitrageEngineSupervisor.WorkerInfo;
import fortuna.models.competition.EventCompetition;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.text.similarity.FuzzyScore;
import org.apache.commons.text.similarity.LevenshteinDistance;

import java.util.*;
import java.util.stream.Collectors;

import static fortuna.support.EventIdentifierUtils.processString;

@Slf4j
public class NameSimilarityUtils {

    private static final Integer FUZZY_SCORE_MIDDLE_LENGTH_LIMIT = 15;
    private static final Integer FUZZY_SCORE_LOW_LENGTH_LIMIT = 10;
    private static final Integer FUZZY_SCORE_LOW_THRESHOLD = 4;
    private static final Integer FUZZY_SCORE_MIDDLE_THRESHOLD = 10;
    private static final Integer FUZZY_SCORE_HIGH_THRESHOLD = 20;
    private static final FuzzyScore FUZZY_SCORE = new FuzzyScore(Locale.getDefault());
    private static final LevenshteinDistance LEV_DISTANCE = new LevenshteinDistance();
//
//    public static Pair<Set<String>, Set<Set<String>>> similarNames(Set<String> names, Set<Set<String>> currentMatches, String extractedName) {
//
//        Set<String> similarNames = new HashSet<>();
//        for (String name : names) {
//            if (extractedName.length() > 5 && name.length() > 5 && !extractedName.substring(0, 5).equals(name.substring(0, 5))) {
//                if (LEV_DISTANCE.apply(name, extractedName) <= LEV_SCORE_THRESHOLD) {
//                    similarNames.add(name);
//                    similarNames.add(extractedName);
//                }
//            } else {
//                if (name.length() > FUZZY_SCORE_LOW_LENGTH_LIMIT || extractedName.length() > FUZZY_SCORE_LOW_LENGTH_LIMIT) {
//                    if (FUZZY_SCORE.fuzzyScore(name, extractedName) > FUZZY_SCORE_HIGH_THRESHOLD) {
//                        similarNames.add(name);
//                        similarNames.add(extractedName);
//                    }
//                } else {
//                    if (FUZZY_SCORE.fuzzyScore(name, extractedName) > FUZZY_SCORE_LOW_THRESHOLD) {
//                        similarNames.add(name);
//                        similarNames.add(extractedName);
//                    }
//                }
//            }
//        }
//
//        if (similarNames.isEmpty()) {
//            return Pair.apply(Collections.emptySet(), currentMatches);
//        }
//
//        Set<Set<String>> finalMatchSet = new HashSet<>();
//        boolean newSetAdded = false;
//        for (Set<String> currentMatchSet : currentMatches) {
//            if (similarNames.containsAll(currentMatchSet)) {
//                finalMatchSet.add(similarNames);
//                newSetAdded = true;
//            } else {
//                finalMatchSet.add(currentMatchSet);
//            }
//        }
//
//        if (!newSetAdded) {
//            finalMatchSet.add(similarNames);
//        }
//
//        return Pair.apply(similarNames, finalMatchSet);
//    }

    public static Optional<WorkerInfo> findSimilarWorker(Set<WorkerInfo> currentEntries, List<String> participants, String eventIdentifier, EventCompetition eventCompetition) {
        for (WorkerInfo workerInfo : currentEntries) {
            if (workerInfo.getEventCompetition() == null || workerInfo.getParticipants() == null || workerInfo.getEventIdentifier() == null) {
                log.warn("Encountered incomplete worker info {}!", workerInfo);
            }

            if (workerInfo.getEventIdentifier().equals(eventIdentifier)) {
                return Optional.of(workerInfo);
            }

            if (isSimilar(workerInfo.getParticipants().get(0), participants.get(0)) && isSimilar(workerInfo.getParticipants().get(1), participants.get(1)) && workerInfo.getEventCompetition().equals(eventCompetition)) {
                return Optional.of(workerInfo);
            }
        }

        return Optional.empty();
    }

    public static Optional<Pair<Pair<String, String>, Pair<String, EventCompetition>>> eventIdentifierMismatch(Map<Pair<String, String>, Pair<String, EventCompetition>> currentEntries, Pair<String, String> participants, String eventIdentifier, EventCompetition eventCompetition) {
        for (Map.Entry<Pair<String, String>, Pair<String, EventCompetition>> entry : currentEntries.entrySet()) {
            Pair<String, String> key = entry.getKey();
            Pair<String, EventCompetition> value = entry.getValue();

            if (isSimilar(key.first(), participants.first()) && isSimilar(key.second(), participants.second()) && value.second().equals(eventCompetition) && !value.first().equals(eventIdentifier)) {
                return Optional.of(Pair.apply(key, value));
            }
        }

        return Optional.empty();
    }

    private static boolean isSimilar(String str1, String str2) {
        str1 = processString(str1);
        str2 = processString(str2);

        if (str1.equals(str2)) {
            return true;
        }

        List<String> str1Parts = List.of(str1.split("_"));
        List<String> str2Parts = List.of(str2.split("_"));

        Set<String> intersection = new HashSet<>(str1Parts);
        intersection.retainAll(str2Parts);

        str1 = str1Parts.stream()
                .filter(part -> !intersection.contains(part))
                .collect(Collectors.joining("_"));
        str2 = str2Parts.stream()
                .filter(part -> !intersection.contains(part))
                .collect(Collectors.joining("_"));

        if (str1.length() > 3 && str2.length() > 3 && !str1.substring(0, 3).equals(str2.substring(0, 3))) {
            int levTreshold = Double.valueOf(Math.ceil((double) Math.min(str1.length(), str2.length()) / 2)).intValue();

            return LEV_DISTANCE.apply(str1, str2) < levTreshold;
        } else {
            int averageLength = Double.valueOf(Math.ceil((double) (str1.length() + str2.length()) / 2)).intValue();
            Integer fuzzyScore = FUZZY_SCORE.fuzzyScore(str1, str2);

            if ((averageLength >= FUZZY_SCORE_MIDDLE_LENGTH_LIMIT) && (fuzzyScore > FUZZY_SCORE_HIGH_THRESHOLD)) {
                return true;
            } else if ((averageLength < FUZZY_SCORE_MIDDLE_LENGTH_LIMIT && averageLength >= FUZZY_SCORE_LOW_LENGTH_LIMIT) && (fuzzyScore > FUZZY_SCORE_MIDDLE_THRESHOLD)) {
                return true;
            } else if ((averageLength < FUZZY_SCORE_LOW_LENGTH_LIMIT) && fuzzyScore > FUZZY_SCORE_LOW_THRESHOLD) {
                return true;
            }
        }

        return false;
    }

}
