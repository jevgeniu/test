package ee.jevgeniu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toCollection;

public class LevenshteinComparator extends ComparatorBase {
    private static final Integer similarity = 70;
    private boolean applyLevenshtein(List<String> l1, List<String> l2) {
        if (l1.size() != l2.size())
            return false;
        if (l1.size() == 0 || l2.size() == 0)
            return true;
        for (int j = 0; j < l1.size(); ++j) {
            if (Levenshtein.Similarity(l1.get(0).toCharArray(), l2.get(j).toCharArray()) >= similarity) {
                l1.remove(0);
                l2.remove(j);
                return applyLevenshtein(l1, l2);
            }
        }
        return false;
    }
    boolean compareTokens(String s1, String s2, List<String> noise) {
        var al1 = Arrays.stream(s1.split("[\\W]+")).filter(e -> !noise.contains(e)).sorted().collect(toCollection(ArrayList::new));
        var al2 = Arrays.stream(s2.split("[\\W]+")).filter(e -> !noise.contains(e)).sorted().collect(toCollection(ArrayList::new));
        return applyLevenshtein(al1, al2);
    }
}
