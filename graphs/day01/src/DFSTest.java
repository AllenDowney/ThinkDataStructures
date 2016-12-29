/**
 * 
 */

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class DFSTest {

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
     * Test method for {@link DFS#topologicalOrder(Digraph)}.
     */
    @Test
    public void testTopologicalOrder() {
        assertThat(DFS.topologicalOrder(g2).toArray(), is(new int[]{4, 0, 3, 1, 2}));
    }


    /**
     * Test method for {@link DFS#hasCycle(Graph)}.
     */
    @Test
    public void testHasCycle() {
        assertThat(DFS.hasCycle(g1), is(true));
        assertThat(DFS.hasCycle(g2), is(true));
        assertThat(DFS.hasCycle(g3), is(true));
        assertThat(DFS.hasCycle(g4), is(false));
    }

}
