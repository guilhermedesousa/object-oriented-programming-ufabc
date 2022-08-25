import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Test whether NameNotFoundException is thrown at the proper places.
 */
public class NameNotFoundExceptionTest extends GenericExceptionTest {
    private static final Class<NameNotFoundException> exception = NameNotFoundException.class;

    @Test
    public void doesNotThrowAtGetRanking() {
        final var year = 2010;
        final var gender = 'm';
        final var names = new String[] {"Jacob", "Shane", "Finn", "Izaiah", "Dorian",
            "Mohammed", "Kareem", "Bronson", "Alfred", "Crew"};
        for (var name : names) {
            Assertions.assertDoesNotThrow(
                () -> namesPopularity.getRanking(year, gender, name),
                buildDoesNotThrowMessage(year, gender, name));
        }
    }

    @Test
    public void throwsAtGetRanking() {
        final var year = 2001;
        final var gender = 'm';
        final var names = new String[] {"Jaco", "Joao", "Fabio", "Igor", "Danilo",
            "Maome", "Henrique", "Napoleao", "Timoteo", "Caio"};

        for (String name : names) {
            Assertions.assertThrows(exception,
                () -> namesPopularity.getRanking(year, gender, name),
                buildThrowsMessage(exception.getName(), year, gender, name));
        }
    }

    @Test
    public void throwsAtGetCount() {
        final var year = 2001;
        final var gender = 'm';
        final var names = new String[] {"Jaco", "Joao", "Fabio", "Igor", "Danilo",
            "Maome", "Henrique", "Napoleao", "Timoteo", "Caio"};

        for (String name : names) {
            Assertions.assertThrows(exception,
                () -> namesPopularity.getCount(year, gender, name),
                buildThrowsMessage(exception.getName(), year, gender, name));
        }
    }

    @Test
    public void doesNotThrowAtGetCount() {
        final var gender = 'm';
        final var year = 2010;
        final var names = new String[] {"Jacob", "Shane", "Finn", "Izaiah", "Dorian",
            "Mohammed", "Kareem", "Bronson", "Alfred", "Crew"};

        for (String name : names) {
            Assertions.assertDoesNotThrow(
                () -> namesPopularity.getCount(year, gender, name),
                buildDoesNotThrowMessage(year, gender, name));
        }
    }
}
