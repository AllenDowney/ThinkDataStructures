/**
 *
 */

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;

import java.util.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author David Abrahams
 *
 */
public class ProblemsTest {

    /*
     * Converts a Map of int:appearance-count to a List of appearance counts,
     * in the order the ints appear.
     */
    private static List<Integer> countInts(int[] arr) {
        List<Integer> res = new ArrayList<>();
        Set<Integer> appearingInts = new LinkedHashSet<>();
        Map<Integer, Integer> countMap = Problems.getCountMap(arr);
        for (int i : arr) {
            if (!appearingInts.contains(i)) {
                appearingInts.add(i);
            }
        }
        for (int i : appearingInts)
            res.add(countMap.get(i));
        return res;
    }

    /**
     * Test method for {@link Problems#getCountMap(int[])}.
     */
    @Test
    public void testCountInts() {
        int[] in = new int[]{1, 1, 3, 4, 1, 4, 5};
        assertThat(countInts(in).toArray(), is(new int[]{3, 1, 2, 1}));

        int[] in2 = new int[]{3, 4, 1, 4, 4};
        assertThat(countInts(in2).toArray(), is(new int[]{1, 3, 1}));

        int[] in3 = new int[]{1, 2, 3, 4};
        assertThat(countInts(in3).toArray(), is(new int[]{1, 1, 1, 1}));

        int[] in4 = new int[]{2, 3, 2, 3, 2, 3, 2};
        assertThat(countInts(in4).toArray(), is(new int[]{4, 3}));

    }

}
