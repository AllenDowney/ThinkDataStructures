import java.util.*;

public class DFS {

    private static void dfsConnected(Graph g, int v, boolean[] marked) {
        marked[v] = true;
        for (int neigh : g.getNeighbors(v))
            if (!marked[neigh])
                dfsConnected(g, neigh, marked);
    }

    public static boolean connected(Graph g, int v, int u) {
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
        for (int neigh : g.getNeighbors(v)) {
            if (!marked[neigh]) {
                dfsTopo(g, neigh, topoOrder, marked);
            }
        }
        topoOrder.addFirst(v);
    }

    public static boolean hasCycle(Graph g) {

        int startingEdge = g.vertices().iterator().next();
        boolean[] marked = new boolean[g.numVertices()];
        for (int i : g.vertices()) {
            if (!marked[i]) {
                if (dfsCycle(g, i, -1, marked)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean dfsCycle(Graph g, int v, int cameFrom, boolean[] marked) {
        marked[v] = true;
        for (int neigh : g.getNeighbors(v)) {
            if (!marked[neigh]) {
                if (dfsCycle(g, neigh, v, marked)) {
                    return true;
                }
            } else if (neigh != cameFrom) {
                return true;
            }
        }
        return false;
    }

}