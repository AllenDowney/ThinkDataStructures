package soln;
import ADTs.StackADT;

import java.util.LinkedList;

/**
 * An implementation of the Stack interface.
 */
public class MyStack<T extends Comparable<? super T>> implements StackADT<T> {

    private LinkedList<T> ll;
    private LinkedList<T> max;

    public MyStack() {
        ll = new LinkedList<>();
        max = new LinkedList<>();
    }

    @Override
    public void push(T e) {
        ll.addFirst(e);
        if (max.isEmpty() || (max.getFirst().compareTo(e) <= 0))
            max.addFirst(e);
    }

    @Override
    public T pop() {
        T pop = ll.removeFirst();
        if (!max.isEmpty() && (pop.equals(max.getFirst())))
            max.removeFirst();
        return pop;
    }

    @Override
    public boolean isEmpty() {
        return ll.isEmpty();
    }

    @Override
    public T peek() {
        return ll.getFirst();
    }

    public T maxElement() {
        return max.getFirst();
    }
}
