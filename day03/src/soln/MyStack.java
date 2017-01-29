package soln;

import ADTs.StackADT;

/**
 * An implementation of the Stack interface.
 */
public class MyStack<T extends Comparable<? super T>> implements StackADT<T> {

    private Node<T> headNode;
    private Node<T> maxNode;

    @Override
    public void push(T e) {
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
    public T peek() {
        return headNode.getData();
    }

    public T maxElement() {
        return maxNode.getData();
    }

}
