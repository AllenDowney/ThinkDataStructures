import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

public class SortTest {
    private int[] emptyCase;
    private int[] fastCase;
    private int[] slowCase;

    private final int RANGE = 100;

    @Before
    public void setup() {
        emptyCase = generateRandomArrayOfSize(0);
        fastCase = generateRandomArrayOfSize(1000);
        slowCase = generateRandomArrayOfSize(100000);
    }

    private int[] generateRandomArrayOfSize(int n) {
        int[] random = new int[n];

        for (int i=0; i < n; i++) {
            random[i] = (int) (Math.random() * (2 * RANGE) - RANGE);
        }

        return random;
    }

    private void testSort(SortAlgorithm sorter) {
        assertArrayEquals(sorter.sort(emptyCase), emptyCase);
        assertArrayEquals(sorter.sort(fastCase), sort(fastCase));
        assertArrayEquals(sorter.sort(slowCase), sort(slowCase));
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

    @Test
    public void testQuickSort() {
        testSort(new QuickSort());
    }

}
