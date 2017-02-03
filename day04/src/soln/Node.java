package soln;

/**
 * Created by kghite on 2/3/17.
 */
public class Node<T> {
    T val;
    Node<T> next;

    public Node(T data) {
        this.val = data;
        this.next = null;
    }
}
