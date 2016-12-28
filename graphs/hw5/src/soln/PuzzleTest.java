/**
 * Test for 8 Puzzle functionality
 */

import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;

public class PuzzleTest {

	private Board board;

	@Before
	public void setUp() throws Exception {
        int[][] initState = {{1, 2, 3}, {4, 5, 6}, {7, 0, 8}};
        board = new Board(initState);
    }

    // Test board methods

	/**
 	* Test method for void manhattan().
 	*/
	@Test
	public void testManhattan() {
		assertThat(board.manhattan(), is(0));
	}

    /**
     * Test method for boolean isGoal().
     */
    @Test
    public void testGoal() {
        assertThat(board.isGoal(), is(false));
    }

    /**
     * Test method for Iterable<Board> neighbors().
     */
    @Test
    public void testNeighbors() {

    }

    // Test solver with several initial board states

    /**
     * Test method for Solver
     */
    @Test
    public void testSolver() {
        // Unsolvable puzzle
        int[][] initState = {{1, 2, 3}, {4, 5, 6}, {8, 7, 0}};
        Board initial = new Board(initState);
        Solver solver = new Solver(initial);
        assertThat(solver.isSolvable(), is(false));

        // Easy solve puzzle
        int[][] initState = {{1, 2, 3}, {4, 5, 6}, {7, 0, 8}};
        Board initial = new Board(initState);
        Solver solver = new Solver(initial);
        assertThat(solver.isSolvable(), is(true));
        assertThat(solver.solution(), is(0)); // Update soln

        // Hard solve puzzle
    }

}