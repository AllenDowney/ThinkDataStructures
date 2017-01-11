/**
 * Solver definition for the 8 Puzzle challenge
 * Construct a tree of board states using A* to 
 */

import java.util.Stack;

public class Solver {

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

    public Solver(Board initial) {
        // Find a solution to the initial board using Dijkstra or A*
    }

    public boolean isSolvable() {
        // Is the board a solvable state
        return false;
    }

    public int moves() {
        // Min number of moves to solve the initial board
        return 0;
    }

    public Iterable<Board> solution() {
        // Sequence of boards in a shortest solution; null if unsolvable
        return null;
    }

    public static void main(String[] args) {
        // DEBUG
    }


}
