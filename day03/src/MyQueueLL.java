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
        return size;
    }

    @Override
    public void enqueue(T newItem) {
        items.addLast(newItem);
        size++;
        // TODO: Implement this method
    }

    @Override
    public T dequeue() {
        // TODO: Implement this method
        T e = items.removeLast();
        size--;
        return e;
    }

    @Override
    public boolean isEmpty() {
        // TODO: Implement this method
        return size == 0;
    }
}
