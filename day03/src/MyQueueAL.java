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
    	// TODO: Implement this method
    	return 0;
    }

    @Override
    public void enqueue(T newItem) {
        // TODO: Implement this method
    }

    @Override
    public T dequeue() {
        // TODO: Implement this method
        return null;
    }

    @Override
    public boolean isEmpty() {
        // TODO: Implement this method
        return false;
    }
}
