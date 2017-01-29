package ADTs;

/**
 * The Queue Abstract Data Type, which has these methods:
 * enqueue(T e) adds an element to the "back" of the queue
 * dequeue() removes the element at the "front" of the queue
 * isEmpty() checks if the queue size is zero
 * size() returns the size of the queue
 *
 * @param <T>
 */
public interface QueueADT<T> {
    void enqueue(T item);
    T dequeue();
    boolean isEmpty();
    T front();
}
