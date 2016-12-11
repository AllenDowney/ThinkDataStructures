/**
 * 
 */

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class SearchTest {

    private UndirectedGraph g1, g3, g4;
    private Digraph g2;


    /**
     * @throws Exception
     */
    @Before
	public void setUp() throws Exception {
        g1 = new UndirectedGraph(9);
        g1.addEdge(0, 1);
        g1.addEdge(0, 2);
        g1.addEdge(1, 2);
        g1.addEdge(1, 3);
        g1.addEdge(2, 4);
        g1.addEdge(3, 4);
        g1.addEdge(4, 5);
        g1.addEdge(5, 6);
        g1.addEdge(3, 7);
        g1.addEdge(6, 7);

        g2 = new Digraph(5);
        g2.addEdge(4, 0);
        g2.addEdge(0, 2);
        g2.addEdge(0, 3);
        g2.addEdge(1, 2);
        g2.addEdge(3, 1);

        g3 = new UndirectedGraph(5);
        g3.addEdge(0, 2);
        g3.addEdge(1, 3);
        g3.addEdge(1, 4);
        g3.addEdge(3, 4);

        g4 = new UndirectedGraph(4);
        g4.addEdge(0, 1);
        g4.addEdge(1, 2);
        g4.addEdge(0, 3);
    }


    /**
     * Test method for {@link Search#shortestPath(UndirectedGraph, int, int)}.
     */
    @Test
    public void testShortestPath() {

        List<Integer> path1 = Search.shortestPath(g1, 0, 6);
        assertThat(path1.toArray(), is(new int[]{0, 2, 4, 5, 6}));


        List<Integer> path2 = Search.shortestPath(g1, 0, 7);
        assertThat(path2.toArray(), is(new int[]{0, 1, 3, 7}));

        assertThat(Search.shortestPath(g1, 0, 8), nullValue());
    }


    /**
     * Test method for {@link Search#topologicalOrder(Digraph)}.
     */
    @Test
    public void testTopologicalOrder() {
        assertThat(Search.topologicalOrder(g2).toArray(), is(new int[]{4, 0, 3, 1, 2}));
    }


    /**
     * Test method for {@link Search#hasCycle(UndirectedGraph)}.
     */
    @Test
    public void testHasCycle() {
        assertThat(Search.hasCycle(g1), is(true));
        assertThat(Search.hasCycle(g2), is(true));
        assertThat(Search.hasCycle(g3), is(true));
        assertThat(Search.hasCycle(g4), is(false));
    }

}
