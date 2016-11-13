package soln;

public class Node<T> {

    private T data;
    private Node<T> next;
    private Node<T> prevMax;

    public Node(T data) {
        this.data = data;
        this.next = null;
    }

    public Node<T> getPrevMax() {
        return prevMax;
    }

    public void setPrevMax(Node<T> prevMax) {
        this.prevMax = prevMax;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node<T> getNext() {
        return this.next;
    }

    public T getData() {
        return data;
    }
}
