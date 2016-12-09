package soln;

import java.util.*;

public class Search {

    public static List<Integer> shortestPath(Graph g, int v, int w) {
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

    public static int distanceBetween(Graph g, int v, int w) {
        List<Integer> path = shortestPath(g, v, w);
        if (path == null)
            return -1;
        return path.size() - 1;
    }

    public static List<Integer> topologicalOrder(Digraph g) {
        List<Integer> topoOrder = new LinkedList<>();
        int startingEdge = g.vertices().iterator().next();
        boolean[] marked = new boolean[g.numVertices()];
        dfsTopo(g, startingEdge, topoOrder, marked);
        return topoOrder;
    }

    private static void dfsTopo(Digraph g, int v, List<Integer> topoOrder, boolean[] marked) {
        marked[v] = true;
        topoOrder.add(v);
        for (int neigh : g.getNeighbors(v)) {
            if (!marked[neigh]) {
                dfsTopo(g, neigh, topoOrder, marked);
            }
        }
    }

    public static boolean hasCycle(Graph g) {


        int startingEdge = g.vertices().iterator().next();
        boolean[] marked = new boolean[g.numVertices()];

        return dfsCycle(g, startingEdge, -1, marked);
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
