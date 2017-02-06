import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

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

    @Test
    public void caseSix() {
        // Case 6: 8 boomerangs, lots of points
        int[][] p = new int[][]{{35, 27}, {-37, -8}, {17, 49}, {-12, -1}, {20, -30}, {-11, -9}, {-5, 18}, {15, -49}, {-32, -42}, {47, -30}, {-43, 47}, {-25, -22}, {-15, -2}, {13, 30}, {36, 5}, {21, -50}, {26, 27}, {13, 11}, {49, -22}, {34, 37}, {40, 28}, {-9, 24}, {24, -48}, {-27, 23}, {29, 48}, {-9, 9}, {40, -41}, {18, -17}, {-29, 16}, {6, -35}};
        assertThat(Boomerang.numberOfBoomerangs(p), is(8));
    }

    @Test
    public void caseSeven() {
        // Case 6: 34 boomerangs, not a lot of points
        int[][] p = new int[][]{{-5, -1}, {-5, -5}, {-2, -2}, {-5, 1}, {-1, -5}, {-1, 0}, {-4, 1}, {-2, 0}, {-3, -2}, {-2, 1}};
        assertThat(Boomerang.numberOfBoomerangs(p), is(34));
    }

    @Test
    public void caseEight() {
        // Case 6: 6 boomerangs, 6 points
        int[][] p = new int[][]{{-3, 1}, {-1, -3}, {-3, -3}, {2, 0}, {1, 0}, {-2, 1}};
        assertThat(Boomerang.numberOfBoomerangs(p), is(6));
    }
}
