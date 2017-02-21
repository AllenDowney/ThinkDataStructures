public abstract class SortAlgorithm {

    abstract int[] sort(int[] array);

    void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

}
