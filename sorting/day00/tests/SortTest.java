import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class SortTest {
    private int[] emptyCase;
    private int[] oneCase;
    private int[] twoCase;
    private int[] fastCase;
    private int[] slowCase;

    private final int RANGE = 100;

    @Before
    public void setup() {
        emptyCase = generateRandomArrayOfSize(0);
        oneCase = generateRandomArrayOfSize(1);
        twoCase = generateRandomArrayOfSize(2);
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
        assertArrayEquals(sorter.sort(oneCase), sort(oneCase));
        assertArrayEquals(sorter.sort(twoCase), sort(twoCase));
        assertArrayEquals(sorter.sort(fastCase), sort(fastCase));
        assertArrayEquals(sorter.sort(slowCase), sort(slowCase));
    }

    private int[] sort(int[] array) {
        int[] copy = Arrays.copyOf(array, array.length);
        Arrays.sort(copy);
        return copy;
    }

    @Test
    public void testMerge() {
        MergeSort mergeSort = new MergeSort();
        int[] a, b, merged;

        a = new int[] {1,3,5,7};
        b = new int[] {2,4,6};
        merged = new int[] {1,2,3,4,5,6,7};
        assertArrayEquals(mergeSort.merge(a, b), merged);

        a = new int[] {1};
        b = new int[] {2};
        merged = new int[] {1,2};
        assertArrayEquals(mergeSort.merge(a, b), merged);

        a = new int[] {1};
        b = new int[0];
        assertArrayEquals(mergeSort.merge(a, b), a);
    }


    @Test
    public void testQuick() {
        QuickSort quickSort = new QuickSort();
        int[] a, b, c;

        a = new int[] {8, 3, 4, 6, 7, 2, 1, 2};
        int[] a_sorted = sort(a);
        quickSort.quickSort(a, 0, a.length-1);
        assertArrayEquals(a, a_sorted);

        a = new int[] {8, 3, 4, 6, 7, 2, 1, 2};
        quickSort.quickSort(a, 1, a.length-2);
        assertArrayEquals(a, new int[] {8, 1, 2, 3, 4, 6, 7, 2});

        // Quicksort the middle of a an array
        a = generateRandomArrayOfSize(984);
        b = generateRandomArrayOfSize(1593);
        c = generateRandomArrayOfSize(48);

        List<Integer> inputAL = new ArrayList<>();
        for (int i: a)
            inputAL.add(i);
        for (int i: b)
            inputAL.add(i);
        for (int i: c)
            inputAL.add(i);
        List<Integer> outputAL = new ArrayList<>();
        for (int i: a)
            outputAL.add(i);
        for (int i: sort(b))
            outputAL.add(i);
        for (int i: c)
            outputAL.add(i);
        int[] in = inputAL.stream().mapToInt(i -> i).toArray();
        int[] out = outputAL.stream().mapToInt(i -> i).toArray();
        quickSort.quickSort(in, a.length, a.length+b.length-1);
        assertArrayEquals(in, out);

    }

    /**
     * NOTE: Depending on how you implement partition, you may need to change
     * the `partitioned` variable below accordingly. If you do change it, mention
     * that you did so the your checkoff NINJA.
     */
    @Test
    public void testPartition() {
        QuickSort quickSort = new QuickSort();
        int[] a, partitioned;
        int finalIndex;

        a = new int[] {5,6,8,3,1,10,2,5};
        partitioned = new int[] {2,3,1,5,8,10,6,5};
        finalIndex = quickSort.partition(a, 0, 7);
        assertThat(finalIndex, is(3));
        assertArrayEquals(a, partitioned);

        a = new int[] {5,6,8,3,1,10,2,5};
        partitioned = new int[] {5,6,2,3,1,8,10,5};
        finalIndex = quickSort.partition(a, 2, 6);
        assertThat(finalIndex, is(5));
        assertArrayEquals(a, partitioned);
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
