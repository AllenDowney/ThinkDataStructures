import java.util.List;
import java.util.Random;

public class MazeGenerator {

    // Returns coordinates of neighbors in N, E, S, W order
    private static int[][] getNeighbors(int x, int y) {
        return new int[][] {
                {x, y+1},
                {x+1, y},
                {x, y-1},
                {x-1, y}
        };
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

    // Returns if there are unvisited neighbors to an x, y coordinate in a Maze
    private static boolean hasUnvisitedNeighbors(Maze m, int x, int y) {
        int[][] neighbors = getNeighbors(x, y);
        boolean unvisitedNeighbors = false;
        for (int[] n : neighbors)
            unvisitedNeighbors |= validAndUnvisited(m, n[0], n[1]);
        return unvisitedNeighbors;
    }

    public static Maze getRandomMaze(int n) {
        // TODO: YOUR CODE HERE
        return null;
    }

    // Convert a Maze object to a Graph
    public static UndirectedGraph mazeToGraph(Maze m) {
        // TODO: YOUR CODE HERE
        return null;
    }

    // Converts a graph vertex number to an x-coordinate
    private static int vertexToX(int v, int mazeSize) {
        // TODO: YOUR CODE HERE
        return -1;
    }

    // Converts a graph vertex number to a y-coordinate
    private static int vertexToY(int v, int mazeSize) {
        // TODO: YOUR CODE HERE
        return -1;
    }

    public static void main(String[] args) {
        // Generate a 50x50 random Maze
        Maze maze = getRandomMaze(50);
        StdDraw.enableDoubleBuffering();
        maze.draw();

        // Convert to a graph
        UndirectedGraph g = mazeToGraph(maze);

        // Choose a from and to point in the bottom left and top right
        // corners
        int from = new Random().nextInt(maze.n * maze.n / 4);
        int to = new Random().nextInt(3 * maze.n * maze.n / 4);

        // use BFS to solve shortest path
        List<Integer> path = BFS.shortestPath(g, from, to);
        StdDraw.pause(1000);

        // Convert back into x-y coordinates and plot points on maze
        maze.drawPoint(vertexToX(from, maze.n), vertexToY(from, maze.n), StdDraw.BLUE);
        maze.drawPoint(vertexToX(to, maze.n), vertexToY(to, maze.n), StdDraw.BLUE);
        for (int i : path) {
            maze.drawPoint(vertexToX(i, maze.n), vertexToY(i, maze.n));
            StdDraw.pause(10);
        }
    }

}
