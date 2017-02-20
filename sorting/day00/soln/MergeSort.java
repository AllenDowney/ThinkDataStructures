public class MergeSort extends SortAlgorithm {
    private static final int INSERTION_THRESHOLD = 10;
    private InsertionSort insertionSort = new InsertionSort();

    @Override
    public int[] sort(int[] array) {
        if (array.length < INSERTION_THRESHOLD) return insertionSort.sort(array);

        int m = array.length / 2;

        int[] tempLeft = new int[m];
        int[] tempRight = new int[array.length - m];

        System.arraycopy(array, 0, tempLeft, 0, m);
        System.arraycopy(array, m, tempRight, 0, array.length - m);

        int[] left = sort(tempLeft);
        int[] right = sort(tempRight);

        return merge(left, right);
    }

    public int[] merge(int[] left, int[] right) {

        int[] out = new int[left.length + right.length];

        int i=0, j=0, k=0;

        while (k < out.length) {
            if (chooseLeft(i, j, left, right)) {
                out[k] = left[i];
                i++;
            } else {
                out[k] = right[j];
                j++;
            }
            k++;
        }
        return out;
    }

    // Helper function that determines if the next item to merge should be from
    // the left array
    private boolean chooseLeft(int i, int j, int[] left, int[] right) {
        if (j==right.length)
            return true;
        if (i==left.length)
            return false;
        return left[i] < right[j];
    }
}
