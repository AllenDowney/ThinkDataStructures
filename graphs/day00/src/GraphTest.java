
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Before;
import org.junit.Test;

public class GraphTest {

    private UndirectedGraph g;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
        g = new UndirectedGraph(5);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 4);
        g.addEdge(3, 4);
    }

	/**
	 * Test method for {@link UndirectedGraph#hasEdgeBetween(int, int)}.
	 */
	@Test
	public void testEdges() {

        assertThat(g.hasEdgeBetween(0, 1), is(true));
        assertThat(g.hasEdgeBetween(2, 0), is(true));
        assertThat(g.hasEdgeBetween(1, 2), is(true));
        assertThat(g.hasEdgeBetween(3, 1), is(true));
        assertThat(g.hasEdgeBetween(2, 4), is(true));
        assertThat(g.hasEdgeBetween(4, 3), is(true));

        assertThat(g.hasEdgeBetween(0, 3), is(false));
        assertThat(g.hasEdgeBetween(2, 3), is(false));
        assertThat(g.hasEdgeBetween(4, 1), is(false));

	}


    /**
     * Test method for {@link UndirectedGraph#vertices()}.
     */
    @Test
    public void testVertices() {
        int counter = 0;
        for (int v : g.vertices()) {
            assertThat(v, is(counter++));
        }
    }


    /**
     * Test method for {@link UndirectedGraph#numVertices()}.
     */
    @Test
    public void testNumVertices() {
        assertThat(g.numVertices(), is(5));
    }

    /**
     * Test method for {@link UndirectedGraph#numEdges()}.
     */
    @Test
    public void testNumEdges() {
        assertThat(g.numEdges(), is(6));
    }

    /**
     * Test method for {@link UndirectedGraph#getNeighbors(int)}.
     */
    @Test
    public void testGetNeighbors() {
        Iterable<Integer> neighbors0 = g.getNeighbors(0);
        assertThat(iterableContains(neighbors0, 1), is(true));
        assertThat(iterableContains(neighbors0, 2), is(true));
        assertThat(iterableContains(neighbors0, 3), is(false));


        Iterable<Integer> neighbors1 = g.getNeighbors(1);
        assertThat(iterableContains(neighbors1, 0), is(true));
        assertThat(iterableContains(neighbors1, 3), is(true));
        assertThat(iterableContains(neighbors1, 2), is(true));
        assertThat(iterableContains(neighbors1, 1), is(false));
        assertThat(iterableContains(neighbors1, 4), is(false));
    }

    private boolean iterableContains(Iterable iterable, Object item) {
        for (Object o : iterable) {
            if (o.equals(item))
                return true;
        }
        return false;
    }
}
