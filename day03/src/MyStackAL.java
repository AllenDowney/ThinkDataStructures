import ADTs.StackADT;

import java.util.ArrayList;

/**
 * An implementation of the Stack Abstract Data Type using an ArrayList
 * @param <T>
 */

public class MyStackAL<T> implements StackADT<T> {
    private ArrayList<T> items;
    private int size;

    public MyStackAL() {
        this.items = new ArrayList<T>();
        this.size = 0;
    }

    @Override
    public int size() {
        // TODO: Implement this method
        return size;
    }

    @Override
    public void push(T newItem) {
        items.add(newItem);
        size++;
        // TODO: Implement this method
    }

    @Override
    public T pop() {
        // TODO: Implement this method
        T e = items.remove(size-1);
        size--;
        return e;
    }

    @Override
    public boolean isEmpty() {
        // TODO: Implement this method
        return size == 0;
    }
}
