import java.util.ArrayList;

public class GenericStack2<T> {
    private final ArrayList<T> elements;

    public GenericStack2() {
        elements = new ArrayList<>();
    }

    public boolean isEmpty() {
        return elements.size() == 0;
    }

    public int size() {
        return elements.size();
    }

    public void push(T value) {
        elements.add(value);
    }

    public T pop() {
        if (isEmpty()) {
            throw new StackEmptyException("Stack is empty, cannot pop");
        }
        return elements.remove(elements.size() - 1);
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
        return elements.get(elements.size() - 1);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("[");
        for (int i = 0; i < elements.size(); i++) {
            sb.append(elements.get(i));
            if (i < elements.size() - 1) {
                sb.append(",");
            }
        }
        sb.append("]");

        return sb.toString();
    }

    public static void main(String[] args) {
        GenericStack2<Integer> intStack = new GenericStack2<>();
        intStack.push(10);
        intStack.push(20);
        intStack.push(30);
        System.out.println(intStack);
        System.out.println();

        GenericStack2<Double> doubleStack = new GenericStack2<>();
        doubleStack.push(Math.PI);
        doubleStack.push(Math.E);
        System.out.println(doubleStack);
    }
}
