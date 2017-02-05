import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class BoomerangTest {

    @Test
    public void caseOne() {
        // Case 1: Empty list of points
        int[][] p = {};
        assertThat(Boomerang.numberOfBoomerangs(p), is(0));
    }

	@Test
	public void caseTwo() {
        // Case 2: 2 boomerangs
        int[][] p = new int[][]{{0, 0}, {0, 1}, {1, 1}};
        assertThat(Boomerang.numberOfBoomerangs(p), is(2));
	}

	@Test
	public void caseThree() {
        // Case 3: 12 boomerangs in middle, 4*2 boomerangs on edges, 20 total
        int[][] p = new int[][]{{0, 0}, {2, 0}, {0, 2}, {0, -2}, {-2, 0}};
        assertThat(Boomerang.numberOfBoomerangs(p), is(20));
	}


	@Test
	public void caseFour() {
        // Case 4: 8 boomerangs
        int[][] p = new int[][]{{0, 0}, {1, 0}, {2, 0}, {1, 1}};
        assertThat(Boomerang.numberOfBoomerangs(p), is(8));
	}

	@Test
	public void caseFive() {
        // Case 5: 24 boomerangs
        int[][] p = new int[][]{{0,2},{1,0},{1,3},{1,4},{2, 3},{2,4},{3, 1}};
        assertThat(Boomerang.numberOfBoomerangs(p), is(24));
    }
}
