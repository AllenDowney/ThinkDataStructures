package soln;

import ADTs.QueueADT;

/**
 * An implementation of the Queue interface.
 */
public class MyQueue<T> implements QueueADT<T> {

    private Node<T> headNode;
    private Node<T> tailNode;

    @Override
    public void enqueue(T e) {
        if (headNode == null) {
            headNode = new Node<>(e);
            tailNode = headNode;
        }
        else {
            Node<T> temp = new Node<>(e);
            tailNode.setNext(temp);
            tailNode = temp;
        }
    }

    @Override
    public T dequeue() {
        Node<T> temp = headNode;
        headNode = temp.getNext();
        if (headNode == null) {
            tailNode = null;
        }
        return temp.getData();
    }

    @Override
    public boolean isEmpty() {
        return headNode == null;
    }

    @Override
    public T front() {
        return headNode.getData();
    }

}