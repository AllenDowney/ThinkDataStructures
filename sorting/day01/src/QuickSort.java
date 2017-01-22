public class QuickSort extends Sorter {

    @Override
    public int[] sort(int[] array) {
        // TODO: Fill this in
    }

    /**
     * Partition the array around a pivot, then recursively sort the left and right
     * portions of the array.
     */
    private void quickSort(int[] a, int lo, int hi) {
        // TODO: Fill this in
    }

    /**
     * Select a "pivot" element in the array, from lo:hi (inclusive). Place all elements less
     * than the pivot before the pivot, and all others after the pivot.
     * Return the index of the pivot in the array after partitioning.
     */
    private int partition(int[] a, int lo, int hi) {
        // TODO: Fill this in
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
