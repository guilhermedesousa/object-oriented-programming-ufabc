import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Functional tests for Baby Name Popularity.
 */
public class BabyNamesPopularityQueryTest {
    private static final String rankingCases = "src/test/resources/ranking-small.txt";
    private static final String countCases = "src/test/resources/count-small.txt";
    private static final String totalCases = "src/test/resources/total.txt";

    private BabyNamesPopularityQuery namesPopularity;

    @BeforeEach
    public void setup() {
        namesPopularity = new BabyNamesPopularityQuery();
    }

    @Test
    public void testGetName() {
        try (var scanner = new Scanner(new BufferedReader(new FileReader(rankingCases)))) {
            while (scanner.hasNext()) {
                var year = scanner.nextInt();
                var gender = scanner.next().charAt(0);
                var name = scanner.next();
                var ranking = scanner.nextInt();

                try {
                    var message = String.format("Parameter (%d %c %d) should "
                        + "generate name %s", year, gender, ranking, name);
                    Assertions.assertEquals(name,
                        namesPopularity.getName(year, gender, ranking), message);
                } catch (YearNotFoundException | GenderNotFoundException
                         | NameNotFoundException | RankingOutOfBoundsException e) {
                    Assertions.fail("Client generated unexpected exception", e);
                }
            }
        } catch (FileNotFoundException e) {
            Assertions.fail("Failed to open cases file: " + rankingCases, e);
        }
    }

    @Test
    public void testGetRanking() {
        try (var scanner = new Scanner(new BufferedReader(new FileReader(rankingCases)))) {
            while (scanner.hasNext()) {
                var year = scanner.nextInt();
                var gender = scanner.next().charAt(0);
                var name = scanner.next();
                var ranking = scanner.nextInt();

                try {
                    var message = String.format("Parameter (%d %c %s) should "
                        + "generate ranking %d", year, gender, name, ranking);
                    Assertions.assertEquals(ranking,
                        namesPopularity.getRanking(year, gender, name), message);
                } catch (YearNotFoundException | GenderNotFoundException
                    | NameNotFoundException e) {
                    Assertions.fail("Client generated unexpected exception", e);
                }
            }
        } catch (FileNotFoundException e) {
            Assertions.fail("Failed to open cases file: " + rankingCases, e);
        }
    }

    @Test
    public void testGetCount() {
        try (var scanner = new Scanner(new BufferedReader(new FileReader(countCases)))) {
            while (scanner.hasNext()) {
                var year = scanner.nextInt();
                var gender = scanner.next().charAt(0);
                var name = scanner.next();
                var count = scanner.nextInt();

                try {
                    var message = String.format("Parameter (%d %c %s) should "
                        + "generate count %d", year, gender, name, count);
                    Assertions.assertEquals(count,
                        namesPopularity.getCount(year, gender, name), message);
                } catch (YearNotFoundException | GenderNotFoundException
                    | NameNotFoundException e) {
                    Assertions.fail("Client generated unexpected exception", e);
                }
            }
        } catch (FileNotFoundException e) {
            Assertions.fail("Failed to open cases file: " + countCases, e);
        }
    }

    @Test
    public void testGetTotal() {
        try (var scanner = new Scanner(new BufferedReader(new FileReader(totalCases)))) {
            while (scanner.hasNext()) {
                var year = scanner.nextInt();
                var gender = scanner.next().charAt(0);
                var total = scanner.nextInt();

                try {
                    var message = String.format("Parameter (%d %c) should "
                        + "generate count %d", year, gender, total);
                    Assertions.assertEquals(total,
                        namesPopularity.getTotal(year, gender), message);
                } catch (YearNotFoundException | GenderNotFoundException e) {
                    Assertions.fail("Client generated unexpected exception", e);
                }
            }
        } catch (FileNotFoundException e) {
            Assertions.fail("Failed to open cases file: " + totalCases, e);
        }
    }
}
