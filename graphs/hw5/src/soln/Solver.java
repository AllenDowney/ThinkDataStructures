/**
 * Solver definition for the 8 Puzzle challenge
 * Construct a tree of board states using A* to 
 */

package soln;

import java.util.Stack;

public class Solver {

    private MinPQ<State> pq = new MinPQ<State>();
    private int minMoves = -1;
    private State bestState;
    private boolean solved;

    private class State implements Comparable<State> {
        // Each state needs to keep track of it's cost and the previous state
        private Board board;
        private int moves;
        private int cost;
        private State prev;

        public State(Board board, int moves, State prev) {
            this.board = board;
            this.moves = moves;
            this.prev = prev;
            // Compute cost of board state according to A*
            cost = this.moves + board.manhattan();
        }

        @Override
        public int compareTo(State s) {
            int stateComparison = this.cost - s.cost;
            return stateComparison;
        }
    }

    private State root(State state) {
        State current = state;
        while (current.prev != null) {
            current = current.prev;
        }
        return current;
    }

    // A* Solver
    public Solver(Board initial) {
        // Find a solution to the initial board using Dijkstra or A*
        if (initial == null) {
            throw new NullPointerException();
        }
        pq.insert(new State(initial, 0, null));
        pq.insert(new State(initial.twin(), 0, null));
        while (!pq.isEmpty()) {
            State current = pq.delMin();
            if (current.board.isGoal()) {
                State root = root(current);
                if (!root.board.equals(initial)) {
                    break;
                }
                solved = true;
                if (minMoves == -1 || current.moves < minMoves) {
                    minMoves = current.moves;
                    bestState = current;
                }
            }
            if (minMoves == -1 || current.cost < minMoves) {
                Iterable<Board> it = current.board.neighbors();
                for (Board b : it) {
                    if (current.prev == null || !b.equals(current.prev.board)) {
                        pq.insert(new State(b, current.moves + 1, current));
                    }
                }
            } else {
                break;
            }
        }
    }

    public boolean isSolvable() {
        // Is the board a solvable state
        return solved;
    }

    public Iterable<Board> solution() {
        // Sequence of boards in a shortest solution; null if unsolvable
        if (isSolvable()) {
            Stack<Board> sol = new Stack<Board>();
            State current = bestState;
            while (current != null) {
                sol.push(current.board);
                current = current.prev;
            }
            return sol;
        }
        return null;
    }

    public static void main(String[] args) {
        // DEBUG - Your solution can be whatever output you found useful
        // Create initial board
        int[][] initState = {{0, 1, 3}, {4, 2, 5}, {7, 8, 6}};
        Board initial = new Board(initState);

        // Solve the puzzle
        Solver solver = new Solver(initial);
        if (!solver.isSolvable())
            System.out.println("No solution");
        else {
            for (Board board : solver.solution())
                board.printBoard(board.tiles);
        }
    }


}
