import ADTs.QueueADT;

import java.awt.font.NumericShaper;
import java.util.ArrayList;

/**
 * Challenge: can you implement a Queue using two Stacks?
 */
public class WeirdQueue<T> implements QueueADT<T> {
    private MyStackAL<T> s1;
    private MyStackAL<T> s2;
    private int size;

    public WeirdQueue() {
        s1 = new MyStackAL<T>();
        s2 = new MyStackAL<T>();
        size = 0;
    }

    @Override
    public int size() {
        // TODO optional: Implement this method
        return 0;
    }

    @Override
    public void enqueue(T item) {
        // TODO optional: Implement this method
    }

    @Override
    public T dequeue() {
        // TODO optional: Implement this method
        return null;
    }

    @Override
    public boolean isEmpty() {
        // TODO optional: Implement this method
        return false;
    }

}
