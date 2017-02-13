import ADTs.StackADT;

import java.util.LinkedList;

/**
 * An implementation of the Stack Abstract Data Type using a LinkedList
 * @param <T>
 */
public class MyStackLL<T> implements StackADT<T> {
    private LinkedList<T> items;
    private int size;

    public MyStackLL() {
        this.items = new LinkedList<T>();
        this.size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void push(T newItem) {
        // TODO: Implement this method
        items.addLast(newItem);
        size++;
    }

    @Override
    public T pop() {
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
