package soln;

import java.awt.*;

/**
 * Created by david on 12/27/16.
 */
public class Maze {

    public int n;
    public boolean[][] north;  // is there a wall to north of cell i, j
    public boolean[][] east;
    public boolean[][] south;
    public boolean[][] west;
    public boolean[][] visited;

    public Maze(int n) {
        this.n = n;
        north = new boolean[n][n];
        east = new boolean[n][n];
        south = new boolean[n][n];
        west = new boolean[n][n];
        visited = new boolean[n][n];

        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                north[x][y] = true;
                east[x][y]  = true;
                south[x][y] = true;
                west[x][y]  = true;
                visited[x][y] = false;
            }
        }
    }


    public void draw() {

        StdDraw.setXscale(0, n+2);
        StdDraw.setYscale(0, n+2);

        StdDraw.setPenColor(StdDraw.BLACK);
        for (int x = 1; x <= n; x++) {
            for (int y = 1; y <= n; y++) {
                if (south[x-1][y-1]) StdDraw.line(x, y, x+1, y);
                if (north[x-1][y-1]) StdDraw.line(x, y+1, x+1, y+1);
                if (west[x-1][y-1])  StdDraw.line(x, y, x, y+1);
                if (east[x-1][y-1])  StdDraw.line(x+1, y, x+1, y+1);
            }
        }
        StdDraw.show();
    }

    public void drawPoint(int x, int y) {
        drawPoint(x, y, StdDraw.RED);
    }


    public void drawPoint(int x, int y, Color color) {
        StdDraw.setPenColor(color);
        StdDraw.filledCircle(x+1.5, y+1.5, 0.375);
        StdDraw.show();
    }

}

