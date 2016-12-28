/**
 * Board definition for the 8 Puzzle challenge
 */

import java.util.Stack;

public class Board {

    public Board(int[][] b) {
        // Set the global board size and initial tiles
    }

    public int size() {
        // Size of the board
        return 0;
    }

    public int manhattan() {
        // Sum of the manhattan distances between the tiles and the goal
        // Estimated cost from the current node to the goal
        return 0;
    }

    public boolean isGoal() {
        // Compare the goal to the current state
        return false;
    }

    public boolean equals(Object y) {
        // does this board equal y?
        return false;
    }

    public Iterable<Board> neighbors() {
        // Return the neighboring boards in the state tree
        return null;
    }

    public Board twin() {
        // Flip two blocks in same row
        return null;
    }

    void printBoard() {
        // Print out the board state nicely
    }

    static void printArray(int[][] grid) {
        // Print out a given tile set nicely
    }

    public static void main(String[] args) {
        // DEBUG
    }

}
