import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertThat;

public class SortTest {
    private static final int[] FIRST = new int[] {1,2,3,4,5,7,6};
    private static final int[] SECOND = new int[] {7,6,5,4,3,2,1};
    private static final int[] THIRD = new int[] {7,1,6,2,5,3,4};

    private static final int[] RESULT = new int[] {1,2,3,4,5,6,7};

    @Test
    public void testMergeSort() {
        testSort(new MergeSort());
    }

    @Test
    public void testBubbleSort() {
        testSort(new BubbleSort());
    }

    @Test
    public void testInsertionSort() {
        testSort(new InsertionSort());
    }

    private void testSort(Sorter sorter) {
        assertArrayEquals(sorter.sort(FIRST), RESULT);
        assertArrayEquals(sorter.sort(SECOND), RESULT);
        assertArrayEquals(sorter.sort(THIRD), RESULT);
    }
}
