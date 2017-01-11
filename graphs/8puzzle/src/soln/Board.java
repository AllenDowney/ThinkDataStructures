/**
 * Board definition for the 8 Puzzle challenge
 */

package soln;

import java.util.Stack;

public class Board {

    private int n;
    public int[][] tiles;
    private int[][] goal = {{1, 2, 3}, {4, 5, 6}, {7, 8, 0}};

    public Board(int[][] b) {
        // Set the global board size and initial tiles
        n = b.length;

        // Copy to avoid reference issues
        tiles = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                tiles[i][j] = b[i][j];
            }
        }
    }

    public int size() {
        // Size of the board (equal to 3 for 8 puzzle)
        return n;
    }

    public int manhattan() {
        // Sum of the manhattan distances between the tiles and the goal
        // Estimated cost from the current node to the goal for A*
        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int value = tiles[i][j];
                if (value != 0 && value != goalValueAt(i, j)) {
                    int initialX = (value - 1) / n;
                    int initialY = value - 1 - initialX * n;
                    int distance = Math.abs(i - initialX)
                            + Math.abs(j - initialY);
                    sum += distance;
                }
            }
        }
        return sum;
    }

    // Helper for manhattan
    private int goalValueAt(int i, int j) {
        if (isEnd(i, j)) {
            return 0;
        }
        return 1 + i * n + j;
    }

    // Helper for manhattan
    private boolean isEnd(int i, int j) {
        return i == n - 1 && j == n - 1;
    }

    public boolean isGoal() {
        // Compare the goal to the current state
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (goal[i][j] != tiles[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean equals(Object y) {
        // Check if the board equals an input Board object
        if (y == this) return true;
        if (y == null) return false;
        if (y.getClass() != this.getClass()) return false;
        Board that = (Board) y;
        // Check if the same size
        if (that.tiles.length != n || that.tiles[0].length != n) {
            return false;
        }
        // Check if the same tile configuration
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (this.tiles[i][j] != that.tiles[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public Iterable<Board> neighbors() {
        // Return the neighboring boards in the state tree
        // This can be done in a variety of ways
        int i0 = 0, j0 = 0;
        boolean found = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (tiles[i][j] == 0) {
                    i0 = i;
                    j0 = j;
                    found = true;
                    break;
                }
            }
            if (found) {
                break;
            }
        }

        Stack<Board> boards = new Stack<Board>();
        Board board = new Board(tiles);
        boolean isNeighbor = board.swap(i0, j0, i0 - 1, j0);
        if (isNeighbor) {
            boards.push(board);
        }
        board = new Board(tiles);
        isNeighbor = board.swap(i0, j0, i0, j0 - 1);
        if (isNeighbor) {
            boards.push(board);
        }
        board = new Board(tiles);
        isNeighbor = board.swap(i0, j0, i0 + 1, j0);
        if (isNeighbor) {
            boards.push(board);
        }
        board = new Board(tiles);
        isNeighbor = board.swap(i0, j0, i0, j0 + 1);
        if (isNeighbor) {
            boards.push(board);
        }

        return boards;
    }

    // Neighbors helper
    public boolean swap(int i, int j, int it, int jt) {
        if (it < 0 || it >= n || jt < 0 || jt >= n) {
            return false;
        }
        int temp = tiles[i][j];
        tiles[i][j] = tiles[it][jt];
        tiles[it][jt] = temp;
        return true;
    }

    static void printBoard(int[][] grid) {
        // Print out the board state nicely
        for(int r=0; r<grid.length; r++) {
            for(int c=0; c<grid[r].length; c++)
                System.out.print(grid[r][c] + " ");
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // DEBUG - Your solution can be whatever output you found useful
        int[][] initState = {{1, 2, 3}, {4, 5, 6}, {7, 0, 8}};
        Board board = new Board(initState);

        printBoard(board.tiles);
        System.out.print("Size: ");
        System.out.println(board.size());
        System.out.print("Manhattan: ");
        System.out.println(board.manhattan());
        System.out.print("Is goal: ");
        System.out.println(board.isGoal());
        System.out.println("Neighbors:");
        Iterable<Board> it = board.neighbors();
        for (Board b : it) {
            printBoard(b.tiles);
        }
    }

}
