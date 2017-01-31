package soln;

import java.util.ArrayList;
import java.util.List;

/**
 * An implementation of a priority Queue
 */
public class MyPriorityQueue<T extends Comparable<? super T>> {

    private List<T> l;

    public MyPriorityQueue() {
        l = new ArrayList<>();
    }

    public void enqueue(T item) {
        for (int i = 0; i < l.size(); i++) {
            if (l.get(i).compareTo(item) > 0) {
                l.add(i, item);
                return;
            }
        }
        l.add(item);
    }

    public T dequeueMax() {
        return l.remove(l.size() - 1);
    }

}