package soln;

import java.util.List;
import java.util.Random;

public class MazeGenerator {

    public static Maze getRandomMaze(int n) {
        Maze m = new Maze(n);
        randomizeMaze(m, 0, 0);
        return m;
    }

    // Convert a Maze object to a Graph
    public static UndirectedGraph mazeToGraph(Maze m) {

        UndirectedGraph g = new UndirectedGraph(m.n * m.n);
        for (int y = 0; y < m.n; y++) {
            for (int x = 0; x < m.n; x++) {
                int currentVertex = y*m.n + x;
                if (!m.north[x][y]) {
                    g.addEdge(currentVertex, currentVertex + m.n);
                }
                if (!m.east[x][y])
                    g.addEdge(currentVertex, currentVertex + 1);
                if (!m.south[x][y])
                    g.addEdge(currentVertex, currentVertex - m.n);
                if (!m.west[x][y])
                    g.addEdge(currentVertex, currentVertex - 1);
            }
        }
        return g;
    }

    // Converts a graph vertex number to an x-coordinate
    private static int vertexToX(int v, int mazeSize) {
        return v % mazeSize;
    }

    // Converts a graph vertex number to a y-coordinate
    private static int vertexToY(int v, int mazeSize) {
        return v / mazeSize;
    }

    // Checks if x, y coordinates are in the bounds of a Maze
    private static boolean valid(Maze m, int x, int y) {
        return ((x >= 0) && (x < m.n) && (y >= 0) && (y < m.n));
    }

    // Checks if x, y coordinates are in the bounds of a Maze,
    // and they have not been visited
    private static boolean validAndUnvisited(Maze m, int x, int y) {
        return valid(m, x, y) && !m.visited[x][y];
    }

    // Use DFS to generate a Maze.
    private static void randomizeMaze(Maze maze, int x, int y) {
        maze.visited[x][y] = true;
        int[][] neighbors = getNeighbors(x, y);
        while (hasUnvisitedNeighbors(maze, x, y)) {
            int choice = new Random().nextInt(neighbors.length);
            int[] neighbor = neighbors[choice];
            int nX = neighbor[0];
            int nY = neighbor[1];
            if (validAndUnvisited(maze, nX, nY)) {
                switch (choice) {
                    case 0:
                        maze.north[x][y] = false;
                        maze.south[nX][nY] = false;
                        break;
                    case 1:
                        maze.east[x][y] = false;
                        maze.west[nX][nY] = false;
                        break;
                    case 2:
                        maze.south[x][y] = false;
                        maze.north[nX][nY] = false;
                        break;
                    case 3:
                        maze.west[x][y] = false;
                        maze.east[nX][nY] = false;
                        break;
                }
                randomizeMaze(maze, nX, nY);
            }
        }
    }

    // Returns coordinates of neighbors in N, E, S, W order
    private static int[][] getNeighbors(int x, int y) {
        return new int[][] {
                {x, y+1},
                {x+1, y},
                {x, y-1},
                {x-1, y}
        };
    }

    // Returns if there are unvisited neighbors to an x, y coordinate in a Maze
    private static boolean hasUnvisitedNeighbors(Maze m, int x, int y) {
        int[][] neighbors = getNeighbors(x, y);
        boolean unvisitedNeighbors = false;
        for (int[] n : neighbors)
            unvisitedNeighbors |= validAndUnvisited(m, n[0], n[1]);
        return unvisitedNeighbors;
    }

    public static void main(String[] args) {
        // Generate a 50x50 random Maze
        Maze maze = getRandomMaze(50);
        StdDraw.enableDoubleBuffering();
        maze.draw();

        // Convert to maze a graph
        UndirectedGraph g = mazeToGraph(maze);

        // Choose a from and to point in the bottom left and top right
        // corners
        int from = new Random().nextInt(maze.n * maze.n / 4);
        int to = new Random().nextInt(3 * maze.n * maze.n / 4);

        // use BFS to solve shortest path
        List<Integer> path = BFS.shortestPath(g, from, to);
        StdDraw.pause(1000);

        // Convert back into x-y coordinates and plot points from solution on maze
        maze.drawPoint(vertexToX(from, maze.n), vertexToY(from, maze.n), StdDraw.BLUE);
        maze.drawPoint(vertexToX(to, maze.n), vertexToY(to, maze.n), StdDraw.BLUE);
        for (int i : path) {
            maze.drawPoint(vertexToX(i, maze.n), vertexToY(i, maze.n));
            StdDraw.pause(10);
        }
    }

}
