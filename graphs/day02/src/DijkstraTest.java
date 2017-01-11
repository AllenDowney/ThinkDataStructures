/**
 * 
 */

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Before;
import org.junit.Test;

public class DijkstraTest {

    private WeightedGraph g1, g2;


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


        g2 = new WeightedGraph(7);
        g2.addEdge(0, 1, 3);
        g2.addEdge(0, 4, 3);
        g2.addEdge(1, 4, 1);
        g2.addEdge(3, 4, 1);
        g2.addEdge(2, 3, 1);
        g2.addEdge(4, 2, 3);
        g2.addEdge(2, 5, 5);
        g2.addEdge(0, 5, 2);
    }

    /**
     * Test method for {@link Dijkstra#shortestPath(WeightedGraph, int, int)}.
     */
    @Test
    public void testShortestPath() {
        assertThat(Dijkstra.shortestPath(g1, 0, 5).toArray(), is(new int[]{0, 2, 5}));
        assertThat(Dijkstra.shortestPath(g2, 0, 2).toArray(), is(new int[]{0, 4, 3, 2}));
        assertThat(Dijkstra.shortestPath(g2, 4, 5).toArray(), is(new int[]{4, 0, 5}));
        assertThat(Dijkstra.shortestPath(g2, 0, 6), nullValue());
    }



    /**
     * Test method for {@link Dijkstra#distanceBetween(WeightedGraph, int, int)}.
     */
    @Test
    public void testDistanceBetween() {
        assertThat(Dijkstra.distanceBetween(g1, 0, 5), is(4.0));
        assertThat(Dijkstra.distanceBetween(g2, 1, 5), is(5.0));
        assertThat(Dijkstra.distanceBetween(g2, 0, 6), is(-1.0));

    }

}
