package soln;

import java.util.Arrays;

public class SlidingWindow {

    /*
     * This solution uses an implementation of a Queue that supports a max operation,
     * which is implemented using two Stacks.
     */
    public static int[] maxInWindows(int[] arr, int k)
    {
        int i = 0;
        int j = 0;
        int[] res = new int[arr.length-k+1];
        MyMaxQueue<Integer> maxQueue = new MyMaxQueue<>();
        while (i < k) {
            maxQueue.enqueue(arr[i]);
            i++;
        }
        res[j] = maxQueue.maxElement();
        j++;
        while (i < arr.length) {
            maxQueue.enqueue(arr[i]);
            maxQueue.dequeue();
            res[j] = maxQueue.maxElement();
            j++;
            i++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(maxInWindows(new int[]{5, 3, 2, 6, 5, 2, 9, 10, 2}, 3)));
    }
}
