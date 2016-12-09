/**
 * 
 */

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

/**
 * @author downey
 *
 */
public class GraphTest {

    private soln.Graph g;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
        g = new soln.Graph(5);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 4);
        g.addEdge(3, 4);
    }

	/**
	 * Test method for {@link Graph#hasEdgeBetween(int, int)}.
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
     * Test method for {@link Graph#vertices()}.
     */
    @Test
    public void testVertices() {
        int counter = 0;
        for (int v : g.vertices()) {
            assertThat(v, is(counter++));
        }
    }


    /**
     * Test method for {@link Graph#numVertices()}.
     */
    @Test
    public void testNumVertices() {
        assertThat(g.numVertices(), is(5));
    }

    /**
     * Test method for {@link Graph#numEdges()}.
     */
    @Test
    public void testNumEdges() {
        assertThat(g.numEdges(), is(6));
    }

    /**
     * Test method for {@link Graph#getNeighbors(int)}.
     */
    @Test
    public void testGetNeighbors() {
        Collection neighbors0 = g.getNeighbors(0);
        assertThat(neighbors0.contains(1), is(true));
        assertThat(neighbors0.contains(2), is(true));
        assertThat(neighbors0.contains(3), is(false));


        Collection neighbors1 = g.getNeighbors(1);
        assertThat(neighbors1.contains(0), is(true));
        assertThat(neighbors1.contains(3), is(true));
        assertThat(neighbors1.contains(2), is(true));
        assertThat(neighbors1.contains(1), is(false));
        assertThat(neighbors1.contains(4), is(false));
    }
}
