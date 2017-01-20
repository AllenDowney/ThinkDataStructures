# Mazes

For this assignment, you are given `Maze.java`, as well as the solutions to previous assignments.

## The coordinate system

Mazes are represented as an x-y grid. **(0, 0) is in the bottom left corner.** **2-d arrays are indexed using the notation: `array[x][y]`.**

## The `Maze` class

Take time to investigate the `Maze` class. It contains the following fields:

* 2-d arrays `north`, `east`, `south`, and `west`. `north[x][y]` represents whether there is a wall north of the (x. y) cell. All walls default to true.
* `visited`, which you can use to mark cells as visited.
* `n` is the size of the maze.

Methods:

* `draw()` plots the maze
* `drawPoint(int x, int y)` plots an x y point on the maze.

## `MazeGenerator`

Read the `main` method. You will be writing the methods so it functions. The `main` method creates a random 50x50 maze, converts it to a Graph in order to solve it, then plots the solution.

There are four helper functions provided for you in `MazeGenerator`. Read the comments to see what they do. You may find them helpful when implementing the following functions:

## Assignment

- `Maze getRandomMaze(int n)`

Create an nxn maze, randomize the walls using recursive backtracking, and return the maze.

- `UndirectedGraph mazeToGraph(Maze m)`

Convert a Maze object to an UndirectedGraph. Each cell should have a unique associated vertex, labled between [0, n^2 - 1]. You will have to choose how you will number each cell.

- `int vertexToX(int v, int mazeSize)`

Convert a vertex number back to an x-coordinate in a maze. For example, if the Graph vertex 5 represents the X-Y coordinate (5, 0), this function should return `5`.

- `int vertexToY(int v, int mazeSize)`

Convert a vertex number back to an x-coordinate in a maze. For example, if the Graph vertex 5 represents the X-Y coordinate (5, 0), this function should return `0`.