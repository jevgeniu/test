package ee.jevgeniu;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    private static List<ComparatorBase> strategies () {
        var comparators = new ArrayList<ComparatorBase>();
        comparators.add(new ExactComparator());
        comparators.add(new LevenshteinComparator());
        return comparators;
    }
    public static void main(String[] args) {
        try {
            if ( Arrays.stream(args).count() != 3 )
                throw new Exception("Wrong set of arguments");
            var sanctions = Files.readAllLines(Paths.get(args[0]));
            var noise = Files.readAllLines(Paths.get(args[1]));
            var targetName = args[2];

            for (var strategy : strategies()) {
                var found = strategy.investigate(sanctions, noise, targetName);
                if (!found.isEmpty()) {
                    found.forEach(System.out::println);
                    break;
                }
            }
        }
        catch (IOException e) {
            System.err.println("Can't read or open a file");
            e.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
