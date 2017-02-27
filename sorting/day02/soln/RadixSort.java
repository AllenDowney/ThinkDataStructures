public class RadixSort {

    /**
     * Runtime: O((n+b)w) -> O(nc), when b=n, where k<= n^c
     *
     * n: length of array
     * w: word length of integers A in base b (equal to log base b of k (log_b k) )
     *
     * @param b The base to use for radix sort
     * @param k The upper bound for integers in A, exclusive
     */
    static void radixSort(int[] A, int b, int k) {
        int w = (int) Math.ceil(Math.log(k) / Math.log(b)); // w = log base b of k
        for (int i = 0; i < w; i++)
            CountingSort.countingSortByDigit(A, b, i);
    }

}
