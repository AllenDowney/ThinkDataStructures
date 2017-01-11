/**
 * Board definition for the 8 Puzzle challenge
 */

package soln;

import java.util.LinkedList;
import java.util.List;
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
            System.arraycopy(b[i], 0, tiles[i], 0, n);
        }
    }

    public int size() {
        // Size of the board (equal to 3 for 8 puzzle)
        return n;
    }

    private int getDistance(int x1, int x2, int y1, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);

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
                    sum += getDistance(i, initialX, j, initialY);
                }
            }
        }
        return sum;
    }

    // Helper for manhattan
    private int goalValueAt(int i, int j) {
        if (isEnd(i, j)) return 0;
        return 1 + i * n + j;
    }

    // Helper for manhattan
    private boolean isEnd(int i, int j) {
        return (i == n - 1) && (j == n - 1);
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

        List<Board> boards = new LinkedList<>(); // accumulate the neighbors

        // Try moving the blank space up, down, left, and right, and if the
        // resulting board state is valid, add it to the accumulator.
        Board board = new Board(tiles);
        if (board.swap(i0, j0, i0 - 1, j0))
            boards.add(board);
        board = new Board(tiles);
        if (board.swap(i0, j0, i0, j0 - 1))
            boards.add(board);
        board = new Board(tiles);
        if (board.swap(i0, j0, i0 + 1, j0))
            boards.add(board);
        if (board.swap(i0, j0, i0, j0 + 1))
            boards.add(board);

        return boards;
    }

    // Neighbors helper. Tries to swap the tile at i-j with the tile at it, jt
    // if it or jt are out of bounds, return false.
    // otherwise, return true, and swap the tile.
    public boolean swap(int i, int j, int it, int jt) {
        if (it < 0 || it >= n || jt < 0 || jt >= n) {
            return false;
        }
        int temp = tiles[i][j];
        tiles[i][j] = tiles[it][jt];
        tiles[it][jt] = temp;
        return true;
    }

    public void printBoard() {
        // Print out the board state nicely
        for (int[] tile : tiles) {
            for (int aTile : tile) System.out.print(aTile + " ");
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // DEBUG - Your solution can be whatever output you found useful
        int[][] initState = {{1, 2, 3}, {4, 5, 6}, {7, 0, 8}};
        Board board = new Board(initState);


        board.printBoard();
        System.out.print("Size: ");
        System.out.println(board.size());
        System.out.print("Manhattan: ");
        System.out.println(board.manhattan());
        System.out.print("Is goal: ");
        System.out.println(board.isGoal());
        System.out.println("Neighbors:");
        Iterable<Board> it = board.neighbors();
        for (Board b : it)
            b.printBoard();
    }

}
