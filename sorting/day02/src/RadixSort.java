public class RadixSort {

    /**
     * @param b The base to use for radix sort
     * @param k The upper bound for integers in A, exclusive
     */
    static void radixSort(int[] A, int b, int k) {
        int d = (int) Math.ceil(Math.log(k) / Math.log(b)); // d = log base b of k
        for (int i = 0; i < d; i++)
            CountingSort.countingSortByDigit(A, b, i);
    }

}
