/**
 * Uma fila com duas terminações.
 *
 * @param <T> o tipo genérico
 */
public class GenericDeque<T> implements Stack<T>, Queue<T> {
    private final GenericLinkedList<T> deque;
    private final int capacity;

    /**
     * Create an instance of GenericDeque.
     *
     * @param capacity the deque capacity
     */
    public GenericDeque(int capacity) {
        this.deque = new GenericLinkedList<T>();
        if (capacity < 0) {
            throw new IllegalArgumentException("Capacity must be non negative number: " + capacity);
        }
        this.capacity = capacity;
    }

    @Override
    public void enqueue(T value) throws QueueFullException {
        if (isFull()) {
            throw new QueueFullException("Cannot enqueue the element, the deque is full");
        }
        deque.addLast(value);
    }

    @Override
    public T dequeue() throws QueueEmptyException {
        if (isEmpty()) {
            throw new QueueEmptyException("Cannot dequeue the element, the deque is empty");
        }
        try {
            return deque.removeFirst();
        } catch (ListEmptyException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public T front() throws QueueEmptyException {
        if (isEmpty()) {
            throw new QueueEmptyException("Cannot front the element, the deque is empty");
        }
        try {
            return deque.peekFirst();
        } catch (ListEmptyException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public T rear() throws QueueEmptyException {
        if (isEmpty()) {
            throw new QueueEmptyException("Cannot rear the element, the deque is empty");
        }
        try {
            return deque.peekLast();
        } catch (ListEmptyException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int size() {
        return deque.size();
    }

    @Override
    public int capacity() {
        return capacity;
    }

    @Override
    public void push(T value) throws StackFullException {
        if (isFull()) {
            throw new StackFullException("Cannot push the value, the deque is full");
        }
        deque.addLast(value);
    }

    @Override
    public T pop() throws StackEmptyException {
        if (isEmpty()) {
            throw new StackEmptyException("Cannot peek the element, the deque is empty");
        }
        try {
            return deque.removeLast();
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
            return deque.peekLast();
        } catch (ListEmptyException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void clear() {
        deque.clear();
    }

    @Override
    public boolean isFull() {
        return size() == capacity();
    }

    @Override
    public boolean isEmpty() {
        return deque.isEmpty();
    }
}
