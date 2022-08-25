import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Test proper implementation of the proposed API.
 */
@DisplayName("Tests for ArrayUtils.isSorted")
public class TestApi {

    private <T1, T2> boolean hasType(Class<T1> a, Class<T2> b) {
        var types = new ArrayList<>(Arrays.asList(a.getInterfaces()));

        types.add(a.getSuperclass());

        return types.contains(b);
    }

    @Test
    public void testApi() {
        Assertions.assertTrue(hasType(GenericStack.class, Stack.class),
            "GenericStack should implement Stack");
        Assertions.assertTrue(
            hasType(GenericQueue.class, Queue.class),
            "GenericQueue should implement Queue");

        Assertions.assertTrue(
            hasType(GenericDeque.class, Stack.class) && hasType(GenericDeque.class, Queue.class),
            "GenericDeque should implement both Queue and Stack");
    }
}
