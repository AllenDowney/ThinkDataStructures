import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertTrue;

public class ProblemsTest {
    private int[] emptyCase;
    private int[] oneCase;
    private int[] twoCase;
    private int[] fastCase;
    private int[] slowCase;

    @Before
    public void setup() {
        emptyCase = SortTest.generateRandomArrayOfSize(0);
        oneCase = SortTest.generateRandomArrayOfSize(1);
        twoCase = SortTest.generateRandomArrayOfSize(2);
        fastCase = SortTest.generateRandomArrayOfSize(1000);
        slowCase = SortTest.generateRandomArrayOfSize(10000);
    }

    @Test
    public void testRunningMedian() {
        assertTrue(Arrays.equals(Problems.runningMedian(emptyCase), Problems.runningMedianReallySlow(emptyCase)));
        assertTrue(Arrays.equals(Problems.runningMedian(oneCase), Problems.runningMedianReallySlow(oneCase)));
        assertTrue(Arrays.equals(Problems.runningMedian(twoCase), Problems.runningMedianReallySlow(twoCase)));
        assertTrue(Arrays.equals(Problems.runningMedian(fastCase), Problems.runningMedianReallySlow(fastCase)));
        assertTrue(Arrays.equals(Problems.runningMedian(slowCase), Problems.runningMedianReallySlow(slowCase)));
    }

}
