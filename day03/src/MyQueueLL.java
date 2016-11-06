import ADTs.QueueADT;

import java.util.LinkedList;

/**
 * An implementation of the Queue Abstract Data Type using a Linked List
 */
public class MyQueueLL<T> implements QueueADT<T> {
    private LinkedList<T> items;
    private int size;

    public MyQueueLL() {
        this.items = new LinkedList<T>();
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
