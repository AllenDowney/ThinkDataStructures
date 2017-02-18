import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;

public class SortTest {
    private static List<Integer[]> testArrays;

    private static final int NUM_TESTS = 3;
    private static final int RANGE = 100;

    @Before
    public void setup() {
        for (int i=0; i < NUM_TESTS; i++) {
            testArrays.add(generateRandomArrayOfSize(i*100));
        }
    }

    private int[] generateRandomArrayOfSize(int n) {
        int[] random = new int[n];

        for (int i=0; i < n; i++) {
            random[i] = (int) (Math.random() * (2 * RANGE) - RANGE);
        }

        return random;
    }

    private void testSort(SortAlgorithm sorter) {
        for (int i=0; i < NUM_TESTS; i++) {
            assertArrayEquals(sorter.sort(testArrays[i]), sort(testArrays[i]));
        }
    }

    private int[] sort(int[] array) {
        Arrays.sort(array);
        return array;
    }


    @Test
    public void testMergeSort() {
        testSort(new MergeSort());
    }

    @Test
    public void testInsertionSort() {
        testSort(new InsertionSort());
    }


}
