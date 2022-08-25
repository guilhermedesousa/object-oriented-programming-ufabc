/**
 * Uma pilha genérica.
 *
 * @param <T> o tipo genérico
 */
public class GenericStack<T> implements Stack<T> {
    private final GenericLinkedList<T> stack;
    private final int capacity;

    /**
     * Create an instance of GenericStack.
     *
     * @param capacity the stack capacity
     */
    public GenericStack(int capacity) {
        this.stack = new GenericLinkedList<T>();
        if (capacity < 0) {
            throw new IllegalArgumentException("Capacity must be non negative number: " + capacity);
        }
        this.capacity = capacity;
    }

    @Override
    public int size() {
        return stack.size();
    }

    @Override
    public int capacity() {
        return capacity;
    }

    @Override
    public void push(T value) throws StackFullException {
        if (isFull()) {
            throw new StackFullException("Cannot push the value, the stack is full");
        }
        stack.addLast(value);
    }

    @Override
    public T pop() throws StackEmptyException {
        if (isEmpty()) {
            throw new StackEmptyException("Cannot pop the element, the stack is empty");
        }
        try {
            return stack.removeLast();
        } catch (ListEmptyException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public T peek() throws StackEmptyException {
        if (isEmpty()) {
            throw new StackEmptyException("Cannot peek the element, the stack is empty");
        }
        try {
            return stack.peekLast();
        } catch (ListEmptyException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void clear() {
        stack.clear();
    }

    @Override
    public boolean isFull() {
        return size() == capacity();
    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }
}
