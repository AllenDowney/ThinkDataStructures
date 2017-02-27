import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static org.junit.Assert.assertArrayEquals;

public class Tests {
    @Before
    public void setup() {
    }

    private int[] sort(int[] array) {
        int[] copy = Arrays.copyOf(array, array.length);
        Arrays.sort(copy);
        return copy;
    }

    private String[] sort(String[] array) {
        String[] copy = Arrays.copyOf(array, array.length);
        Arrays.sort(copy);
        return copy;
    }

    /**
     * Test method for {@link CountingSort#countingSort(int[], int)}.
     */
    @Test
    public void testCountingSort() {
        int[] max_values = new int[]{10, 100, 1000};
        for (int m : max_values) {
            int[] A = generateRandomArrayOfSize(100000, m);
            int[] sorted = sort(A);
            CountingSort.countingSort(A, m);
            assertArrayEquals(A, sorted);
        }
    }

    /**
     * Test method for {@link SortNumsUnder100#sortNumsUnder100(int[])}.
     */
    @Test
    public void testSortNumsUnder100() {
        int[] array_lengths = new int[]{10, 100, 1000, 100000};
        for (int l : array_lengths) {
            int[] A = generateRandomArrayOfSize(l, 100);
            int[] sorted = sort(A);
            SortNumsUnder100.sortNumsUnder100(A);
            assertArrayEquals(A, sorted);
        }
    }

    /**
     * Test method for {@link RadixSort#radixSort(int[], int, int)}.
     */
    @Test
    public void testRadixSort() {
        int[] max_values = new int[]{10, 100, 1000, 10000};
        int[] bases = new int[]{2, 3, 5, 10, 13, 17, 26};
        for (int m : max_values) {
            for (int b : bases) {
                int[] A = generateRandomArrayOfSize(10000, m);
                int[] sorted = sort(A);
                RadixSort.radixSort(A, b, m);
                assertArrayEquals(A, sorted);
            }
        }
    }

    /**
     * Test method for {@link SortStrings#sortStrings(String[], int)}.
     */
    @Test
    public void testSortString() {
        int[] lengths = new int[]{5, 10, 20};
        for (int l : lengths) {
            String[] S = generateRandomStringArrayOfSize(10000, l);
            String[] sorted = sort(S);
            SortStrings.sortStrings(S, l);
            assertArrayEquals(S, sorted);

        }
    }


    private static int[] generateRandomArrayOfSize(int n, int max) {
        int[] random = new int[n];
        for (int i = 0; i < n; i++)
            random[i] = ThreadLocalRandom.current().nextInt(max);
        return random;
    }


    private static String[] generateRandomStringArrayOfSize(int n, int stringLength) {
        String[] random = new String[n];
        for (int i = 0; i < n; i++)
            random[i] = randomString(stringLength);
        return random;
    }


    private static String randomString(int length) {
        int i = ThreadLocalRandom.current().nextInt((int) Math.pow(26, length));
        char[] chars = new char[length];
        int j = 0;
        while (j < chars.length) {
            chars[j++] = (char) (i % 26 + 'a');
            i /= 26;
        }
        return new String(chars);
    }

}
