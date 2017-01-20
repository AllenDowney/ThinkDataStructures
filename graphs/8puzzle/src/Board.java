/**
 * Board definition for the 8 Puzzle challenge
 */

import java.util.Stack;

public class Board {

    public Board(int[][] b) {
        // Set the global board size and initial tiles

        // TODO: YOUR CODE HERE
    }

    public int size() {
        // Size of the board (equal to 3 for 8 puzzle)

        // TODO: YOUR CODE HERE
        return 0;
    }

    public int manhattan() {
        // Sum of the manhattan distances between the tiles and the goal
        // Estimated cost from the current node to the goal for A*

        // TODO: YOUR CODE HERE
        return 0;
    }

    public boolean isGoal() {
        // Compare the goal to the current state

        // TODO: YOUR CODE HERE
        return false;
    }

    public boolean equals(Object y) {
        // Check if the board equals an input Board object

        // TODO: YOUR CODE HERE
        return false;
    }

    public Iterable<Board> neighbors() {
        // Return the neighboring boards in the state tree
        // This can be done in a variety of ways

        // TODO: YOUR CODE HERE
        return null;
    }

    public void printBoard() {
        // Print out the board state nicely

        // TODO: YOUR CODE HERE
    }

    public static void main(String[] args) {
        // DEBUGGING SPACE
    }

}
