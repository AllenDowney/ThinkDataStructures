/**
 * 
 */

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class WeightedSearchTest {

    private WeightedGraph g1;


    /**
     * @throws Exception
     */
    @Before
	public void setUp() throws Exception {
        g1 = new WeightedGraph(6);
        g1.addEdge(0, 1);
        g1.addEdge(0, 2);
        g1.addEdge(1, 3, 2.0);
        g1.addEdge(3, 4, 1.5);
        g1.addEdge(2, 5, 3.0);
        g1.addEdge(4, 5);
    }


    /**
     * Test method for {@link WeightedGraph#distanceBetween(int, int)}.
     */
    @Test
    public void testDistanceBetween() {

        assertThat(g1.distanceBetween(0, 1), is(1.0));
        assertThat(g1.distanceBetween(1, 3), is(2.0));
        assertThat(g1.distanceBetween(2, 5), is(3.0));
    }

    /**
     * Test method for {@link WeightedSearch#shortestPath(WeightedGraph, int, int)}.
     */
    @Test
    public void testShortestPath() {
        assertThat(WeightedSearch.shortestPath(g1, 0, 5).toArray(), is(new int[]{0, 2, 5}));
    }



    /**
     * Test method for {@link WeightedSearch#distanceBetween(WeightedGraph, int, int)}.
     */
    @Test
    public void testDistanceBetweenSearch() {
        assertThat(WeightedSearch.distanceBetween(g1, 0, 5), is(4.0));
    }

}
