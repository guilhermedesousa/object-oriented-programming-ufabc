import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Test conformance of Exception hierarchy.
 */
public class TestExceptionsApi {

    @Test
    public void testApi() {
        Assertions.assertEquals(GenderNotFoundException.class.getSuperclass(), Exception.class,
            "GenderNotFoundException should extend Exception");
        Assertions.assertEquals(NameNotFoundException.class.getSuperclass(), Exception.class,
            "NameNotFoundException should extend Exception");
        Assertions.assertEquals(YearNotFoundException.class.getSuperclass(), Exception.class,
            "YearNotFoundException should extend Exception");
        Assertions.assertEquals(RankingOutOfBoundsException.class.getSuperclass(), Exception.class,
            "RankOutOfBoundsException should extend Exception");
    }
}
