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
public class MapProblemsTest {

    /*
     * Converts a Map of int:appearance-count to a List of appearance counts,
     * in the order the ints appear.
     */
    private static List<Integer> countInts(int[] arr) {
        List<Integer> res = new ArrayList<>();
        Set<Integer> appearingInts = new LinkedHashSet<>();
        Map<Integer, Integer> countMap = MapProblems.getCountMap(arr);
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
     * Test method for {@link MapProblems#getCountMap(int[])}.
     */
    @Test
    public void testCountInts() {
        int[] in = new int[] {1, 1, 3, 4, 1, 4, 5};
        assertThat(countInts(in).toArray(), is(new int[] {3, 1, 2, 1}));

        int[] in2 = new int[] {3, 4, 1, 4, 4};
        assertThat(countInts(in2).toArray(), is(new int[] {1, 3, 1}));

        int[] in3 = new int[] {1, 2, 3, 4};
        assertThat(countInts(in3).toArray(), is(new int[] {1, 1, 1, 1}));

        int[] in4 = new int[] {2, 3, 2, 3, 2, 3, 2};
        assertThat(countInts(in4).toArray(), is(new int[] {4, 3}));

    }

    /**
     * Test method for {@link MapProblems#pairsThatAddTo(int[], int)}.
     */
    @Test
    public void pairsThatAddTo() {
        int[] in1 = new int[] {1, 4, 6, 5, 0, 5, 1, 2, 3, 5};
        List<int[]> temp1 =  MapProblems.pairsThatAddTo(in1, 6);
        int[][] out1 = temp1.toArray(new int[0][0]);
        Arrays.sort(out1, (o1, o2) -> Integer.compare(o1[0], o2[0]));
        assertThat(out1, is(new int[][] {new int[]{0,6},new int[]{1,5},new int[]{1,5},new int[]{2,4}}));

        int[] in2 = new int[] {-2, 7, 5, 5, 0};
        List<int[]> temp2 =  MapProblems.pairsThatAddTo(in2, 5);
        int[][] out2 = temp2.toArray(new int[0][0]);
        Arrays.sort(out2, (o1, o2) -> Integer.compare(o1[0], o2[0]));
        assertThat(out2, is(new int[][] {new int[]{-2,7},new int[]{0,5}}));

    }

}
