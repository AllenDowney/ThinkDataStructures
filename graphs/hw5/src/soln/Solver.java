/**
 * Solver definition for the 8 Puzzle challenge
 * Construct a tree of board states using A* to 
 */

import java.util.Stack;

public class Solver {

    private MinPQ<Node> pq = new MinPQ<Node>();
    private int minMoves = -1;
    private Node bestNode;
    private boolean solved;

    private class Node implements Comparable<Node> {
        private Board board;
        private int moves, dist;
        private Node prev;

        public Node(Board board, int moves, Node prev) {
            this.board = board;
            this.moves = moves;
            this.prev = prev;
            dist = board.manhattan();
        }

        @Override
        public int compareTo(Node that) {
            return this.moves + this.dist - that.moves - that.dist;
        }
    }

    private Node root(Node node) {
        Node current = node;
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
        pq.insert(new Node(initial, 0, null));
        pq.insert(new Node(initial.twin(), 0, null));
        while (!pq.isEmpty()) {
            Node current = pq.delMin();
            if (current.board.isGoal()) {
                Node root = root(current);
                if (!root.board.equals(initial)) {
                    break;
                }
                solved = true;
                if (minMoves == -1 || current.moves < minMoves) {
                    minMoves = current.moves;
                    bestNode = current;
                }
            }
            if (minMoves == -1 || current.moves + current.dist < minMoves) {
                Iterable<Board> it = current.board.neighbors();
                for (Board b : it) {
                    if (current.prev == null || !b.equals(current.prev.board)) {
                        pq.insert(new Node(b, current.moves + 1, current));
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

    public int moves() {
        // Min number of moves to solve the initial board
        return minMoves;
    }

    public Iterable<Board> solution() {
        // Sequence of boards in a shortest solution; null if unsolvable
        if (isSolvable()) {
            Stack<Board> sol = new Stack<Board>();
            Node current = bestNode;
            while (current != null) {
                sol.push(current.board);
                current = current.prev;
            }
            return sol;
        }
        return null;
    }

    public static void main(String[] args) {
        // Move to test
        // Create initial board
        int[][] initState = {{1, 2, 3}, {4, 5, 6}, {7, 0, 8}};
        Board initial = new Board(initState);

        // solve the puzzle
        Solver solver = new Solver(initial);
        // Print solution to standard output
        if (!solver.isSolvable())
            System.out.println("No solution possible");
        else {
            System.out.println("Minimum number of moves = " + solver.moves());
            for (Board board : solver.solution())
                board.printBoard();
        }
    }


}
