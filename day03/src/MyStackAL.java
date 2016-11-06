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
        return 0;
    }

    @Override
    public void push(T newItem) {
        // TODO: Implement this method
    }

    @Override
    public T pop() {
        // TODO: Implement this method
        return null;
    }

    @Override
    public boolean isEmpty() {
        // TODO: Implement this method
        return false;
    }
}
