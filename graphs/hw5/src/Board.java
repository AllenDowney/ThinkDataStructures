/**
 * Board definition for the 8 Puzzle challenge
 */

import java.util.Stack;

public class Board {

    private int n;
    private int[][] tiles;
    private int[][] goal = {{1, 2, 3}, {4, 5, 6}, {7, 8, 0}};

    public Board(int[][] b) {
        // Set the global board size and initial tiles
        n = b.length;
        tiles = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                tiles[i][j] = b[i][j];
            }
        }
    }

    public int size() {
        return n;
    }

    public int manhattan() {
        // Might use hamming instead ...
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
        // does this board equal y?
        if (y == this) return true;
        if (y == null) return false;
        if (y.getClass() != this.getClass()) return false;
        Board that = (Board) y;
        if (that.tiles.length != n || that.tiles[0].length != n) {
            return false;
        }
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
    private boolean swap(int i, int j, int it, int jt) {
        if (it < 0 || it >= n || jt < 0 || jt >= n) {
            return false;
        }
        int temp = tiles[i][j];
        tiles[i][j] = tiles[it][jt];
        tiles[it][jt] = temp;
        return true;
    }

    public Board twin() {
        // Flip two blocks in same row
        Board newBoard = new Board(tiles);
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                if (newBoard.tiles[i][j] != 0 && newBoard.tiles[i][j + 1] != 0) {
                    newBoard.swap(i, j, i, j + 1);
                    return newBoard;
                }
            }
        }
        return null;
    }

    // Print out the board state nicely
    void printBoard() {
        for(int r=0; r<this.tiles.length; r++) {
            for(int c=0; c<this.tiles[r].length; c++)
                System.out.print(this.tiles[r][c] + " ");
            System.out.println();
        }
        System.out.println();
    }

    // Print out tiles nicely
    static void printArray(int[][] grid) {
        for(int r=0; r<grid.length; r++) {
            for(int c=0; c<grid[r].length; c++)
                System.out.print(grid[r][c] + " ");
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // DEBUG (will remove)
        int[][] initState = {{1, 2, 3}, {4, 5, 6}, {7, 0, 8}};
        Board board = new Board(initState);

        printArray(board.tiles);
        System.out.print("Size: ");
        System.out.println(board.size());
        System.out.print("Manhattan: ");
        System.out.println(board.manhattan());
        System.out.print("Is goal: ");
        System.out.println(board.isGoal());
        System.out.println("Neighbors:");
        Iterable<Board> it = board.neighbors();
        for (Board b : it) {
            printArray(b.tiles);
        }
    }

}
