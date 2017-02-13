import ADTs.QueueADT;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * An implementation of the Queue Abstract Data Type using an ArrayList
 * @param <T>
 */

public class MyQueueAL<T> implements QueueADT<T> {
    ArrayList<T> items;
    private int size;

    public MyQueueAL() {
        this.items = new ArrayList<T>();
        this.size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void enqueue(T newItem) {
        // TODO: Implement this method
        items.add(newItem);
        size++;
    }

    @Override
    public T dequeue() {
        // TODO: Implement this method
        int toRemove = size - 1;
        T e = items.remove(toRemove);
        size--;
        return e;
    }

    @Override
    public boolean isEmpty() {
        // TODO: Implement this method
        return size == 0;
    }
}
