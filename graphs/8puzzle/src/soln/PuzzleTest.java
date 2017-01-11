/**
 * Test for 8 Puzzle functionality
 */

package soln;

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
	    assertThat(board.manhattan(), is(1));
	}

    /**
     * Test method for boolean isGoal().
     */
    @Test
    public void testGoal() {
        assertThat(board.isGoal(), is(false));
    }

    // Test solver with several initial board states

    /**
     * Test method for Solver - Unsolvable puzzle
     */
    @Test
    public void testSolverUnsolvable() {
        // Unsolvable puzzle
        int[][] initState = {{1, 2, 3}, {4, 5, 6}, {8, 7, 0}};
        Board initial = new Board(initState);
        Solver solver = new Solver(initial);
        assertThat(solver.isSolvable(), is(false));
    }

    /**
     * Test method for Solver - Easy puzzle
     */
    @Test
    public void testSolverEasy() {
        // Easy solve puzzle
        int[][] initState = {{1, 2, 3}, {4, 5, 6}, {7, 0, 8}};
        Board initial = new Board(initState);
        Solver solver = new Solver(initial);
        assertThat(solver.isSolvable(), is(true));
        // Create solution boards list
        int solns[][][] = {{{1, 2, 3}, {4, 5, 6}, {7, 8, 0}},
                            {{1, 2, 3}, {4, 5, 6}, {7, 0, 8}}};
        //Compare to output
        int i = 0;
        for (Board board : solver.solution()) {
            assertThat(board.tiles, is(solns[i]));
            i++;
        }
    }

    /**
     * Test method for Solver - Hard puzzle
     */
    @Test
    public void testSolverHard() {

        // Hard solve puzzle
        int[][] initState = {{0, 1, 3}, {4, 2, 5}, {7, 8, 6}};
        Board initial = new Board(initState);
        Solver solver = new Solver(initial);
        assertThat(solver.isSolvable(), is(true));
        // Create solution boards list
        int solns[][][] = {{{1, 2, 3}, {4, 5, 6}, {7, 8, 0}},
                                {{1, 2, 3}, {4, 5, 0}, {7, 8, 6}},
                                {{1, 2, 3}, {4, 0, 5}, {7, 8, 6}},
                                {{1, 0, 3}, {4, 2, 5}, {7, 8, 6}},
                                {{0, 1, 3}, {4, 2, 5}, {7, 8, 6}}};
        //Compare to output
        int i = 0;
        for (Board board : solver.solution()) {
            assertThat(board.tiles, is(solns[i]));
            i++;
        }
    }

}