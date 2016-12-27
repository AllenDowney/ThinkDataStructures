# Graphs Homework 5

Create the necessary classes to implement the 8-puzzle solver.  If you need a reminder of the puzzle details or any of the solve methods that we talked about in class, refer back to the 8-Puzzle power point.

## Step 1:

Make a class Board.java that represent the puzzle board.  It should have the following methods:

Constructor:
- `Board(int[][] b)`, creates an 8 Puzzle board state with the tiles 1-8 and a zero for the empty space from the 3x3 2D array input.

Methods:
`printBoard(int[][] grid)`, prints out the board state 2D array nicely for debugging

## Step 2:

Make a class Solver.java that represents the state tree and game solver for the puzzle board.  It should have the following methods:

Constructor:

Methods:

## Step 3:

In your Solver.java file, write a comment describing which of the path finding algorithms that you used (dijkstra or A*) and detail the runtime complexity of your solution.