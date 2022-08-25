import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Test whether RankingOutOfBoundsException is thrown at the proper places.
 */
public class RankOutOfBoundsExceptionTest extends GenericExceptionTest {
    private static final Class<RankingOutOfBoundsException> exception
        = RankingOutOfBoundsException.class;
    private static final int year = 2001;
    private static final char gender = 'f';

    @Test
    public void doesNotThrowAtGetName() {
        final var rankings = new int[]{1, 234, 387, 861, 1000};

        for (var ranking : rankings) {
            Assertions.assertDoesNotThrow(() -> namesPopularity.getName(year, gender, ranking),
                buildDoesNotThrowMessage(year, gender, ranking));
        }
    }

    @Test
    public void throwsAtGetName() {
        final var rankings = new int[]{-1, 0, 1001, 1002, -1000};

        for (var ranking : rankings) {
            Assertions.assertThrows(exception, () -> namesPopularity.getName(year, gender, ranking),
                buildThrowsMessage(exception.getName(), year, gender, ranking));
        }
    }
}
