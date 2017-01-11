import java.util.*;

public class BFS {

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

}