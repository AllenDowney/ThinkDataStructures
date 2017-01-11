# Graphs Homework 4

Create the necessary classes to implement the 8-puzzle solver.  If you need a reminder of the puzzle details or any of the solve methods that we talked about in class, refer back to the 8-Puzzle power point.

## Step 1:

Make a class Board.java that represent the puzzle board.  It should have the following methods:

Constructor:
- `Board(int[][] b)`, creates an 8 Puzzle board state with the tiles 1-8 and a zero for the empty space from the 3x3 2D array input.

Methods:
- `int size()`, return the board size (our challenge is the 8 puzzle, but in theory you should be able to expand this to any size)
- `int manhattan()`, return the sum of the Manhattan distances between the tiles and the goal, this is the estimated cost from the current state to the goal for A*
- `boolean isGoal()`, return true if the board is the solved puzzle
- `boolean equals(Object y)`, return true if the board equals an input Board object
- `Iterable<Board> neighbors()`, reteurn the neighbor boards in the tree
- `void printBoard(int[][] grid)`, prints out the board state 2D array nicely for debugging
- Plus: whatever helper methods you need to make your code readable ...

## Step 2:

Make a class Solver.java that represents the state tree and game solver for the puzzle board.  It should have the following methods:

Constructor:
- `Solver(Board initState)`, finds a solution to an intial 8 puzzle board state using Dijkstra or A*

Methods:
- `boolean isSolvable()`, returns false if the board is determined to be unsolvable
- `Iterable<Board> solution()`, return the sequence of boards in a shortest solution, return null if unsolvable

## Step 3:

In your Solver.java file, write a comment describing which of the path finding algorithms that you used (dijkstra or A*) and detail the runtime complexity of your solution.
