package soln;

import ADTs.QueueADT;

import java.util.LinkedList;

/**
 * An implementation of the Queue interface.
 */
public class MyQueue<T> implements QueueADT<T> {

    private LinkedList<T> ll;

    public MyQueue() {
        ll = new LinkedList<>();
    }

    @Override
    public void enqueue(T item) {
        ll.add(item);
    }

    @Override
    public T dequeue() {
        return ll.removeFirst();
    }

    @Override
    public boolean isEmpty() {
        return ll.isEmpty();
    }

    @Override
    public T front() {
        return ll.getFirst();
    }
}