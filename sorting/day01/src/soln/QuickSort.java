public class QuickSort extends Sorter {

    @Override
    public int[] sort(int[] array) {
        quickSort(array, 0, array.length-1);
        return array;
    }

    /**
     * Partition the array around a pivot, then recursively sort the left and right
     * portions of the array.
     */
    private void quickSort(int[] a, int lo, int hi) {
        System.out.println(Arrays.toString(a));

        if (lo < hi) {
            int p = partition(a, lo, hi);
            quickSort(a, lo, p-1);
            quickSort(a, p+1, hi);
        }

    }

    /**
     * Select a "pivot" element in the array, from lo:hi (inclusive). Place all elements less
     * than the pivot before the pivot, and all others after the pivot.
     * Return the index of the pivot in the array after partitioning.
     */
    private int partition(int[] a, int lo, int hi) {
        int pivot = a[lo];

        int i = lo + 1;

        for (int j = lo + 1; j <= hi; j++) {
            if (a[j] < pivot) {
                swap(a, j, i);
                i++;
            }
        }

        swap(a, lo, i-1);
        return i-1;
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        QuickSort q = new QuickSort();
        int[] a = new int[]{4, 3, 7, 5, 4, 3, 4654,6, 23, 2, 4,6 ,56, 45, 96};
        q.sort(a);
        System.out.println(Arrays.toString(a));
    }

}
