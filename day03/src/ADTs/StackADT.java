package ADTs;

/**
 * The Stack Abstract Data Type, with the following methods:
 * push(T e) puts an element on top of the stack
 * pop() removes the element on top of the stack
 * isEmpty() checks if the stack size is zero.
 * peek() returns element on top of the stack
 *
 * @param <T>
 */
public interface StackADT<T> {
    void push(T e);
    T pop();
    boolean isEmpty();
    T peek();
}
