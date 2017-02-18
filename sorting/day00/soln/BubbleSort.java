package soln;

public class BubbleSort extends Sorter {
    /**
     * Use the bubble sort algorithm to sort the array
     *
     * Best-case runtime:
     * Worst-case runtime:
     * Average-case runtime:
     *
     * Space-complexity:
     */
    @Override
    public int[] sort(int[] array) {
        int n = array.length;
        while (n > 1) {
            for (int i = 1; i < n; i++) {
                if (array[i] < array[i-1]) {
                    swap(array, i, i-1);
                }
            }
            n--;
        }
        return array;
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
