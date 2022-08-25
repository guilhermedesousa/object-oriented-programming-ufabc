/**
 * Uma fila genérica.
 *
 * @param <T> o tipo genérico
 */
public class GenericQueue<T> implements Queue<T> {
    private final GenericLinkedList<T> queue;
    private final int capacity;

    /**
     * Create an instance of GenericQueue.
     *
     * @param capacity the queue capacity
     */
    public GenericQueue(int capacity) {
        this.queue = new GenericLinkedList<T>();
        if (capacity < 0) {
            throw new IllegalArgumentException("Capacity must be non negative number: " + capacity);
        }
        this.capacity = capacity;
    }

    @Override
    public boolean isFull() {
        return size() == capacity();
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    @Override
    public int size() {
        return queue.size();
    }

    @Override
    public int capacity() {
        return capacity;
    }

    @Override
    public void enqueue(T value) throws QueueFullException {
        if (isFull()) {
            throw new QueueFullException("Cannot enqueue the element, the queue is full");
        }
        queue.addLast(value);
    }

    @Override
    public T dequeue() throws QueueEmptyException {
        if (isEmpty()) {
            throw new QueueEmptyException("Cannot dequeue the element, the queue is empty");
        }
        try {
            return queue.removeFirst();
        } catch (ListEmptyException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public T front() throws QueueEmptyException {
        if (isEmpty()) {
            throw new QueueEmptyException("Cannot front the element, the queue is empty");
        }
        try {
            return queue.peekFirst();
        } catch (ListEmptyException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public T rear() throws QueueEmptyException {
        if (isEmpty()) {
            throw new QueueEmptyException("Cannot rear the element, the queue is empty");
        }
        try {
            return queue.peekLast();
        } catch (ListEmptyException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void clear() {
        queue.clear();
    }
}
