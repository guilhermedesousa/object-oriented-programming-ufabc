import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Test whether NameNotFoundException is thrown at the proper places.
 */
public class YearNotFoundExceptionTest extends GenericExceptionTest {

    private static final Class<YearNotFoundException> exception = YearNotFoundException.class;
    private static final String name = "Jacob";
    private static final char gender = 'm';
    private static final int[] validYears = new int[]{2001, 2002, 2003, 2004, 2005, 2006, 2007,
        2008, 2009, 2010};
    private static final int[] invalidYears = new int[]{-10, 0, 1000, 2000, 2011, 2020};
    private static final int ranking = 1;

    @Test
    public void throwsAtGetName() {
        for (var year : invalidYears) {
            Assertions.assertThrows(exception,
                () -> namesPopularity.getName(year, gender, ranking),
                buildThrowsMessage(exception.getName(), year, gender, ranking));
        }
    }

    @Test
    public void doesNotThrowAtGetName() {
        for (var year : validYears) {
            Assertions.assertDoesNotThrow(() -> namesPopularity.getName(year, gender, ranking),
                buildDoesNotThrowMessage(year, gender, ranking));
        }
    }

    @Test
    public void throwsAtGetRanking() {
        for (var year : invalidYears) {
            Assertions.assertThrows(exception,
                () -> namesPopularity.getRanking(year, gender, name),
                buildThrowsMessage(exception.getName(), year, gender, name));
        }
    }

    @Test
    public void doesNotThrowAtGetRanking() {
        for (var year : validYears) {
            final int finalYear = year;
            Assertions.assertDoesNotThrow(
                () -> namesPopularity.getRanking(finalYear, gender, name),
                buildDoesNotThrowMessage(year, gender, name));
        }
    }

    @Test
    public void throwsAtGetCount() {
        for (var year : invalidYears) {
            Assertions.assertThrows(exception,
                () -> namesPopularity.getCount(year, gender, name),
                buildThrowsMessage(exception.getName(), year, gender, name));
        }
    }

    @Test
    public void doesNotThrowAtGetCount() {
        for (var year : validYears) {
            final int finalYear = year;
            Assertions.assertDoesNotThrow(
                () -> namesPopularity.getCount(finalYear, gender, name),
                buildDoesNotThrowMessage(finalYear, gender, name));
        }
    }

    @Test
    public void throwsAtGetTotal() {
        for (var year : invalidYears) {
            Assertions.assertThrows(exception,
                () -> namesPopularity.getTotal(year, gender),
                buildThrowsMessage(exception.getName(), year, gender));
        }
    }

    @Test
    public void doesNotThrowAtGetTotal() {
        for (var year : validYears) {
            final int finalYear = year;
            Assertions.assertDoesNotThrow(() -> namesPopularity.getTotal(finalYear, gender),
                buildDoesNotThrowMessage(finalYear, gender));
        }
    }
}
