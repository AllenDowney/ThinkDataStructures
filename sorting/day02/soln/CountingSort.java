import java.util.LinkedList;

public class CountingSort {

    /**
     * @param n the digit number, 0 is least significant
     * @return
     */
    private static int getNthDigit(int number, int base, int n) {
        return number / ((int) Math.pow(base, n)) % base;
    }

    /**
     * @param n the character number, 0 is the rightmost character
     * @return
     */
    private static int getNthCharacter(String s, int n) {
        return s.charAt(s.length() - 1 - n) - 'a';
    }

    /**
     * Use counting sort to sort positive integer array A.
     *
     * Runtime: O(k+n)
     *
     * @param k The upper bound for the integers in A, exclusive
     */
    static void countingSort(int[] A, int k) {
        int[] counts = new int[k];
        for (int i : A)
            counts[i]++;
        int m = 0;
        for (int i = 0; i < k; i++)
            for (int j = 0; j < counts[i]; j++)
                A[m++] = i;
    }

    /**
     * Use counting sort to sort the integer array according to a digit
     *
     * @param b The base used in radix sort
     * @param n The digit number (where 0 is the least significant digit)
     */
    static void countingSortByDigit(int[] A, int b, int n) {
        LinkedList<Integer>[] counts = new LinkedList[b];
        for (int i = 0; i < b; i++)
            counts[i] = new LinkedList<>();
        for (int i : A) {
            int nthDigit = getNthDigit(i, b, n);
            counts[nthDigit].add(i);
        }
        int m = 0;
        for (LinkedList<Integer> list : counts)
            while (!list.isEmpty())
                A[m++] = list.removeFirst();
    }


    /**
     * Use counting sort to sort the String array according to a character
     *
     * @param n The digit number (where 0 is the least significant digit)
     */
    static void countingSortByCharacter(String[] A, int n) {
        int b = 26;
        LinkedList<String>[] counts = new LinkedList[b];
        for (int i = 0; i < b; i++)
            counts[i] = new LinkedList<>();
        for (String s : A) {
            int nthDigit = getNthCharacter(s, n);
            counts[nthDigit].add(s);
        }
        int m = 0;
        for (LinkedList<String> list : counts)
            while (!list.isEmpty())
                A[m++] = list.removeFirst();
    }

}
