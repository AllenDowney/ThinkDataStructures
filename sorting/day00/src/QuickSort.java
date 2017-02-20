public class QuickSort extends SortAlgorithm {

    private static final int INSERTION_THRESHOLD = 10;

    /**
     * Best-case runtime:
     * Worst-case runtime:
     * Average-case runtime:
     *
     * Space-complexity:
     */
    @Override
    public int[] sort(int[] array) {
        // TODO
        return new int[0];
    }

    /**
     * Partition the array around a pivot, then recursively sort the left and right
     * portions of the array. A test for this method is provided in `SortTest.java`
     * Optional: use Insertion Sort if the length of the array is <= INSERTION_THRESHOLD
     */
    public void quickSort(int[] a, int low, int high) {
        // TODO
    }


    /**
     * Given an array, choose the array[low] element as the "pivot" element.
     * Place all elements smaller than "pivot" on "pivot"'s left, and all others
     * on its right. Return the final position of "pivot" in the partitioned array.
     *
     * @param low The beginning index of the subarray being considered (inclusive)
     * @param high The ending index of the subarray being considered (inclusive)
     */
    public int partition(int[] array, int low, int high) {
        // TODO
        return 0;
    }

}
