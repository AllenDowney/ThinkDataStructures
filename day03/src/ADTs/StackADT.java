package ADTs;

/**
 * The Stack Abstract Data Type, with the following methods:
 * push(T e) puts an element on to the stack
 * pop() removes the last added element from the stack
 * isEmpty() checks if the stack size is zero.
 * size() returns size of the stack
 *
 * @param <T>
 */
public interface StackADT<T> {
    void push(T e);

    T pop();

    boolean isEmpty();

    int size();
}
