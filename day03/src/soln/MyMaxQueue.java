package soln;

import ADTs.QueueADT;

/**
 * An implementation of the Queue interface using two Stacks. Supports a max operation
 */
public class MyMaxQueue<T extends Comparable<? super T>> implements QueueADT<T> {

    private MyStack<T> inStack;
    private MyStack<T> outStack;

    public MyMaxQueue() {
        inStack = new MyStack<>();
        outStack = new MyStack<>();
    }

    @Override
    public void enqueue(T e) {
        inStack.push(e);
    }

    private void shift() {
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
    }

    @Override
    public T dequeue() {
        shift();
        return outStack.pop();
    }

    @Override
    public boolean isEmpty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }

    @Override
    public T front() {
        shift();
        return outStack.peek();
    }

    public T maxElement() {
        if (inStack.isEmpty())
            return outStack.maxElement();
        if (outStack.isEmpty())
            return inStack.maxElement();
        if (inStack.maxElement().compareTo(outStack.maxElement()) < 0)
            return outStack.maxElement();
        return inStack.maxElement();
    }


}