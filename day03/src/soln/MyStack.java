package soln;

import ADTs.StackADT;

/**
 * An implementation of the Stack interface.
 */
public class MyStack<T extends Comparable<? super T>> implements StackADT<T> {

    private Node<T> headNode;
    private Node<T> maxNode;
    private int size = 0;

    @Override
    public void push(T e) {
        size++;
        if (headNode == null) {
            headNode = new Node<>(e);
            maxNode = headNode;
        }
        else {
            Node<T> temp = new Node<>(e);
            temp.setNext(headNode);
            if (maxNode.getData().compareTo(e) < 0) {
                temp.setPrevMax(maxNode);
                maxNode = temp;
            }
            headNode = temp;
        }
    }

    @Override
    public T pop() {
        size--;
        Node<T> temp = headNode;
        if (temp == maxNode)
            maxNode = temp.getPrevMax();
        headNode = temp.getNext();
        return temp.getData();
    }

    @Override
    public boolean isEmpty() {
        return headNode == null;
    }

    @Override
    public int size() {
        return size;
    }

    public T maxElement() {
        return maxNode.getData();
    }

}
