import org.junit.jupiter.api.BeforeEach;

/**
 * Generic methods for Exception Tests.
 */
public abstract class GenericExceptionTest {

    protected BabyNamesPopularityQuery namesPopularity;

    @BeforeEach
    public void setup() {
        namesPopularity = new BabyNamesPopularityQuery();
    }

    /**
     * Build a parameterized "exception should be thrown" message.
     *
     * @param exceptionName the name of the exception
     * @param year          the year
     * @param gender        the gender
     * @param name          the name parameter
     * @return the message string
     */
    public String buildThrowsMessage(String exceptionName, int year,
        char gender, String name) {
        return String.format("Should throw %s for year %d, gender %c "
            + "and name %s", exceptionName, year, gender, name);
    }

    /**
     * Build a parameterized "exception should be thrown" message.
     *
     * @param exceptionName the name of the exception
     * @param year          the year
     * @param gender        the gender
     * @param ranking       the ranking
     * @return the message string
     */
    public String buildThrowsMessage(String exceptionName, int year,
        char gender, int ranking) {
        return String.format("Should throw %s for year %d, gender %c "
            + "and ranking %d", exceptionName, year, gender, ranking);
    }

    /**
     * Build a parameterized "exception should be thrown" message.
     *
     * @param exceptionName the exception
     * @param year          the year
     * @param gender        the gender
     * @return the message string
     */
    public String buildThrowsMessage(String exceptionName, int year, char gender) {
        return String.format("Should throw %s with year %d and gender %c",
            exceptionName, year, gender);
    }


    /**
     * Build a parameterized "exception should not be thrown" message.
     *
     * @param year   the year
     * @param gender the gender
     * @param name   the name
     * @return the message string
     */
    public String buildDoesNotThrowMessage(int year, char gender, String name) {
        return String.format("Should not throw any exception for year %d, gender %c "
            + "and name %s", year, gender, name);
    }

    /**
     * Build a parameterized "exception should not be thrown" message.
     *
     * @param year   the year
     * @param gender the gender
     * @return the message string
     */
    public String buildDoesNotThrowMessage(int year, char gender) {
        return String.format("Should not throw any exception for year %d, gender %c", year, gender);
    }

    /**
     * Build a parameterized "exception should not be thrown" message.
     *
     * @param year   the year
     * @param gender the gender
     * @param ranking the ranking
     * @return the message string
     */
    public String buildDoesNotThrowMessage(int year, char gender, int ranking) {
        return String.format("Should not throw any exception for year %d, gender %c and ranking %d",
            year, gender, ranking);
    }
}
