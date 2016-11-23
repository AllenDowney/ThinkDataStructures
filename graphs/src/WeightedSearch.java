import java.util.*;

/**
 * Created by david on 11/22/16.
 */
public class WeightedSearch {

    public List<Integer> shortestPath(WeightedGraph g, int v, int w) {

        Map<Integer, Double> distTo = new HashMap<>();
        Map<Integer, Integer> vertexFrom = new HashMap<>();
        Map<Integer, Integer> vertexToIndex = new HashMap<>();
        List<Integer> vertices = g.vertices();
        Set<Integer> visited = new HashSet();

        for (int i = 0; i < g.numVertices(); i++) {
            distTo.put(vertices.get(i), Double.POSITIVE_INFINITY);
            vertexToIndex.put(vertices.get(i), i);
        }
        distTo.put(v, 0.0);
        MinPQ<Double> pq = new MinPQ<>(g.numVertices());
        pq.insert(vertexToIndex.get(v), distTo.get(v));

        while (!pq.isEmpty()) {
            int currVertex = vertices.get(pq.delMin());
            for (Map.Entry<Integer, Double> entry : g.getWeightedNeighbors(currVertex).entrySet()) {
                int neighbor = entry.getKey();
                double weight = entry.getValue();
                double newDistance = distTo.get(currVertex) + weight;
                double oldDistance = distTo.get(neighbor);
                if (newDistance < oldDistance) {
                    distTo.put(neighbor, newDistance);
                    vertexFrom.put(neighbor, currVertex);
                    if (pq.contains(w)) {
                        pq.decreaseKey(vertexToIndex.get(neighbor), newDistance);
                    } else {
                        pq.insert(vertexToIndex.get(neighbor), newDistance);
                    }
                }
            }
            visited.add(currVertex);
        }

        if (!visited.contains(w))
            return null;

        List<Integer> path = new ArrayList<>();
        path.add(w);
        int next = w;
        while (next != v) {
            next = vertexFrom.get(path.get(path.size() - 1));
            path.add(next);
        }
        Collections.reverse(path);
        return path;
    }

    public double distanceBetween (WeightedGraph g, int v, int w) {
        List<Integer> path = shortestPath(g, v, w);
        double dist = 0.0;
        for (int i = 1; i < path.size(); i++) {
            dist += g.distanceBetween(path.get(i - 1), path.get(i));
        }
        return dist;
    }

}
