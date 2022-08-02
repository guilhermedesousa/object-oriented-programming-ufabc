/**
 * A stack which uses subtype polymorphism to provide generic programming
 * features over its data elements.
 */
public class PolymorphicStack {
    private final Object[] elements;
    private int top;

    public PolymorphicStack(int size) {
        if (size < 0) {
            throw new IllegalArgumentException("Size must be positive");
        }
        this.elements = new Object[size];
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

    public void push(Object value) {
        if (isFull()) {
            throw new StackFullException(
                String.format("Stack is full with %d elements", size()));
        }
        elements[++top] = value;
    }

    public Object pop() {
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

    public Object peek() {
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
        PolymorphicStack stackInt = new PolymorphicStack(5);

        stackInt.push(1);
        stackInt.push(2);
        stackInt.push(3);

        System.out.println(stackInt);

        int a = (Integer) stackInt.pop();
        int b = (Integer) stackInt.pop();
        System.out.println(a + b);
        System.out.println(stackInt);
        System.out.println();

        PolymorphicStack stackDouble = new PolymorphicStack(5);

        stackDouble.push(10.2);
        stackDouble.push(11.1);
        double top = (Double) stackDouble.pop();
        System.out.println(stackDouble);
        System.out.println(top);
        System.out.println();

        PolymorphicStack stackString = new PolymorphicStack(4);
        stackString.push("hello");
        stackString.push("world");
        System.out.println(stackString);
        System.out.println();

        PolymorphicStack stackUniversal = new PolymorphicStack(6);

        stackUniversal.push(1);
        stackUniversal.push(2.0);
        stackUniversal.push(true);
        stackUniversal.push("hello");
        stackUniversal.push(new PolymorphicStack(2));
        System.out.println(stackUniversal);
    }
}
