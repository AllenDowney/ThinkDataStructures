import java.util.*;


public class Dijkstra {

    public static List<Integer> shortestPath(WeightedGraph g, int v, int w) {

        double[] distTo = new double[g.numVertices()];
        int[] vertexFrom = new int[g.numVertices()];
        Iterable<Integer> vertices = g.vertices();
        Set<Integer> visited = new HashSet<>();
        MinPQ<Double> pq = new MinPQ<>(g.numVertices());

        for (int u : vertices) {
            distTo[u] = Double.POSITIVE_INFINITY;
            vertexFrom[u] = -1;
            pq.insert(u, distTo[u]);
        }


        distTo[w] = 0;
        pq.decreaseKey(w, distTo[w]);

        while (!pq.isEmpty()) {
            int currVertex = pq.delMin();
            for (Map.Entry<Integer, Double> entry : g.getWeightedNeighbors(currVertex).entrySet()) {
                int neighbor = entry.getKey();
                double weight = entry.getValue();
                double newDistance = distTo[currVertex] + weight;
                double oldDistance = distTo[neighbor];
                if (newDistance < oldDistance) {
                    distTo[neighbor] = newDistance;
                    vertexFrom[neighbor] = currVertex;
                    pq.decreaseKey(neighbor, newDistance);
                }
            }
            visited.add(currVertex);
        }

        if (vertexFrom[v] == -1)
            return null;

        List<Integer> path = new ArrayList<>();
        path.add(v);
        int next = v;
        while (next != w) {
            next = vertexFrom[next];
            path.add(next);
        }
        return path;
    }

    public static double distanceBetween (WeightedGraph g, int v, int w) {
        List<Integer> path = shortestPath(g, v, w);

        if (path == null)
            return -1;

        double dist = 0.0;
        for (int i = 1; i < path.size(); i++) {
            dist += g.distanceBetween(path.get(i - 1), path.get(i));
        }
        return dist;
    }

}
