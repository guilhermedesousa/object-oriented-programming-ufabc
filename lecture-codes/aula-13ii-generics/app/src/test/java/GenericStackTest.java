import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GenericStackTest {
    private GenericStack<Integer> stack;

    @BeforeEach
    public void setUp() {
        stack = new GenericStack<>(5);
    }

    @Test
    public void testEmptyExceptionsOnPop() {
        Assertions.assertThrows(StackEmptyException.class, () -> {
            stack.pop();
        });
    }

    @Test
    public void testFullExceptionsOnPush() {
        Assertions.assertThrows(StackFullException.class, () -> {
            for (int i = 1; i <= 6; i++) {
                stack.push(i);
            }
        });
    }

    @Test
    public void testEmptyExceptionsOnPeek() {
        Assertions.assertThrows(StackEmptyException.class, () -> {
            stack.peek();
        });
    }

    @Test
    public void testIsEmpty() {
        Assertions.assertTrue(stack.isEmpty());
        stack.push(1);
        Assertions.assertFalse(stack.isEmpty());
    }

    @Test
    public void testIsFull() {
        for (int i = 1; i <= 5; i++) {
            Assertions.assertFalse(stack.isFull());
            stack.push(i);
        }
        Assertions.assertTrue(stack.isFull());
    }

    @Test
    public void testClear() {
        stack.push(1);
        stack.push(2);
        stack.clear();
        Assertions.assertTrue(stack.isEmpty());
    }

    @Test
    public void testPeek() {
        for (int i = 1; i <= 5; i++) {
            stack.push(i);
        }

        for (int i = 5; i >= 1; i--) {
            Assertions.assertEquals(i, stack.peek());
            stack.pop();
        }
    }

    @Test
    public void testPush() {
        for (int i = 0; i < 5; i++) {
            stack.push(i);
            Assertions.assertEquals(i+1, stack.size());
        }
    }

    @Test
    public void testPop() {
        for (int i = 1; i <= 5; i++) {
            stack.push(i);
        }

        for (int i = 5; i >= 1; i--) {
            Assertions.assertEquals(i, stack.size());
            Assertions.assertEquals(i, stack.pop());
        }
        Assertions.assertEquals(0, stack.size());
    }

    @Test
    public void testToString() {
        Assertions.assertEquals("[]", stack.toString());

        for (int i = 1; i <= 5; i++) {
            stack.push(i);
        }
        Assertions.assertEquals("[1,2,3,4,5]", stack.toString());
    }
}
