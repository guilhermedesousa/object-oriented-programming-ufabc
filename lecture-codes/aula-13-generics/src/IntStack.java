public class IntStack {
    private final int[] elements;
    private int top;

    public static final class StackFullException extends Error {
        public StackFullException(String message) {
            super(message);
        }
    }

    public static final class StackEmptyException extends Error {
        public StackEmptyException(String message) {
            super(message);
        }
    }

    public IntStack(int size) {
        if (size < 0) {
            throw new IllegalArgumentException("Size must be positive");
        }
        this.elements = new int[size];
        top = -1;
    }

    public boolean isEmpty() {
        return top < 0;
    }

    public boolean isFull() {
        return top == elements.length - 1;
    }

    public int size() {
        return top + 1;
    }

    public void push(int value) {
        if (isFull()) {
            throw new StackFullException(
                String.format("Stack is full with %d elements", size()));
        }
        elements[++top] = value;
    }

    public int pop() {
        if (isEmpty()) {
            throw new StackEmptyException("Stack is empty, cannot pop");
        }
        return elements[top--];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("[");
        for (int i = 0; i <= top; i++) {
            sb.append(elements[i]);
            if (i < top) {
                sb.append(",");
            }
        }
        sb.append("]");

        return sb.toString();
    }

    public static void main(String[] args) {
        // TODO: demonstration
        IntStack stack = new IntStack(5);

        // stack.pop();
        System.out.println(stack);
        stack.push(4);
        System.out.println(stack);
        stack.push(4);
        stack.push(3);
        stack.push(1);
        stack.push(0);
        System.out.println(stack);

        System.out.println(stack.pop());
        System.out.println(stack);
        System.out.println(stack.pop());
        System.out.println(stack);
        System.out.println(stack.pop());
        System.out.println(stack);

        // stack.push(5);
    }
}
