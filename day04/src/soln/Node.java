package soln;

public class Node<T> {
    T val;
    Node<T> next;

    public Node(T data) {
        this.val = data;
        this.next = null;
    }
}
