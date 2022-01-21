package ee.jevgeniu;

import java.util.List;
import java.util.stream.Collectors;

public abstract class ComparatorBase {
    abstract boolean compareTokens(String s1, String s2, List<String> noise);
    public List<String> investigate(List<String> sanctions, List<String> noise, String targetName) {
        return sanctions.stream().filter(e -> {
            return compareTokens(e.toUpperCase(), targetName.toUpperCase(),
                    noise.stream().map(String::toUpperCase).collect(Collectors.toList()));
        }).collect(Collectors.toList());
    }
}
