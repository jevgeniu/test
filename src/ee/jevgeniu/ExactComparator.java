package ee.jevgeniu;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ExactComparator extends ComparatorBase {
    boolean compareTokens(String s1, String s2, List<String> noise) {
        var sl1 = Arrays.stream(s1.split("[\\W]+")).filter(e -> !noise.contains(e)).sorted().collect(Collectors.toList());
        var sl2 = Arrays.stream(s2.split("[\\W]+")).filter(e -> !noise.contains(e)).sorted().collect(Collectors.toList());
        return sl1.equals(sl2);
    }
}
