/**
 * Board definition for the 8 Puzzle challenge
 */

import java.util.Arrays;

public class Board {

    public Board(int[][] b) {
        printBoard(b);
    }

    // Print out the board state nicely
    static void printBoard(int[][] grid) {
        for(int r=0; r<grid.length; r++) {
            for(int c=0; c<grid[r].length; c++)
                System.out.print(grid[r][c] + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] initState = {{1, 2, 3}, {4, 5, 6}, {7, 8, 0}};
        Board board = new Board(initState);
    }

}
