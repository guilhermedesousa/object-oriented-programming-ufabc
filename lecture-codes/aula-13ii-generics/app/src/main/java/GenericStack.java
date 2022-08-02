public class GenericStack<T> {
    private final T[] elements;
    private int top;

    public GenericStack(int size) {
        if (size < 0) {
            throw new IllegalArgumentException("Size must be positive");
        }
        // XXX: workaroung for generic arrays
        elements = (T[]) new Object[size];
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

    public void push(T value) {
        if (isFull()) {
            throw new StackFullException(
                String.format("Stack is full with %d elements", size()));
        }
        elements[++top] = value;
    }

    public T pop() {
        if (isEmpty()) {
            throw new StackEmptyException("Stack is empty, cannot pop");
        }
        return elements[top--];
    }

    public void clear() {
        while (!isEmpty()) {
            pop();
        }
    }

    public T peek() {
        if (isEmpty()) {
            throw new StackEmptyException("Stack is empty, cannot peek");
        }
        return elements[top];
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
        GenericStack<Integer> intStack = new GenericStack<>(3);
        intStack.push(10);
        intStack.push(20);
        intStack.push(30);
        System.out.println(intStack);
        System.out.println();

        GenericStack<Double> doubleStack = new GenericStack<>(3);
        doubleStack.push(Math.PI);
        doubleStack.push(Math.E);
        System.out.println(doubleStack);
    }
}
