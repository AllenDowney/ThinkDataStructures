import java.util.*;

public class DFS {

    /**
     * Use DFS to mark all vertices connected to v.
     *
     * @param marked  marked[v] is whether v has been marked.
     */
    private static void dfsConnected(Graph g, int v, boolean[] marked) {
        marked[v] = true;
        for (int n : g.getNeighbors(v))
            if (!marked[n])
                dfsConnected(g, n, marked);
    }

    public static boolean connected(Graph g, int v, int u) {
        // Use a boolean array to keep track of which vertices have been visited
        boolean[] marked = new boolean[g.numVertices()];
        dfsConnected(g, v, marked);
        return marked[u];
    }

    public static List<Integer> topologicalOrder(Digraph g) {
        LinkedList<Integer> topoOrder = new LinkedList<>();
        int startingEdge = g.vertices().iterator().next();
        boolean[] marked = new boolean[g.numVertices()];
        for (int v : g.vertices()) {
            if (!marked[v]) {
                dfsTopo(g, v, topoOrder, marked);
            }
        }
        return topoOrder;
    }

    private static void dfsTopo(Digraph g, int v, LinkedList<Integer> topoOrder, boolean[] marked) {
        marked[v] = true;
        for (int n : g.getNeighbors(v)) {
            if (!marked[n]) {
                dfsTopo(g, n, topoOrder, marked);
            }
        }
        // Add the current vertex to the head of a LinkedList
        topoOrder.addFirst(v);
    }

    public static boolean hasCycle(Graph g) {

        int startingEdge = g.vertices().iterator().next();
        boolean[] marked = new boolean[g.numVertices()];
        // Check if there's a cycle starting from each vertex using DFS
        for (int i : g.vertices()) {
            if (!marked[i]) {
                if (dfsCycle(g, i, -1, marked)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * @param cameFrom the previous vertex visited.
     */
    private static boolean dfsCycle(Graph g, int v, int cameFrom, boolean[] marked) {
        marked[v] = true;
        for (int n : g.getNeighbors(v)) {
            if (!marked[n]) {
                if (dfsCycle(g, n, v, marked)) {
                    return true;
                }
            }
            // if we reach a marked vertex and it's not the one we came from, we've found
            // a cycle.
            else if (n != cameFrom) {
                return true;
            }
        }
        return false;
    }

}