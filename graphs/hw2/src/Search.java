import java.util.*;

public class Search {

    public static List<Integer> shortestPath(UndirectedGraph g, int v, int w) {
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        boolean[] marked = new boolean[g.numVertices()];
        int[] cameFrom = new int[g.numVertices()];
        q.add(w);
        marked[w] = true;

        while (!q.isEmpty()) {
            int current = q.remove();
            for (int neigh : g.getNeighbors(current)) {
                if (!marked[neigh]) {
                    cameFrom[neigh] = current;
                    marked[neigh] = true;
                    q.add(neigh);
                }
            }
        }

        if (!marked[v])
            return null;

        List<Integer> path = new LinkedList<>();
        int curr = v;
        path.add(v);
        while (curr != w) {
            curr = cameFrom[curr];
            path.add(curr);
        }
        return path;
    }

    public static int distanceBetween(UndirectedGraph g, int v, int w) {
        List<Integer> path = shortestPath(g, v, w);
        if (path == null)
            return -1;
        return path.size() - 1;
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

    public static boolean hasCycle(Digraph g) {

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

    private static boolean dfsCycle(Digraph g, int v, int cameFrom, boolean[] marked) {
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