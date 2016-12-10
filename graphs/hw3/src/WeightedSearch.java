import java.util.*;


public class WeightedSearch {

    public static List<Integer> shortestPath(WeightedGraph g, int v, int w) {

        List<Double> distTo = new ArrayList<>();
        Map<Integer, Integer> vertexFrom = new HashMap<>();
        Iterable<Integer> vertices = g.vertices();
        Set<Integer> visited = new HashSet<>();
        MinPQ<Double> pq = new MinPQ<>(g.numVertices());

        for (int u : vertices) {
            distTo.add(Double.POSITIVE_INFINITY);
            pq.insert(u, Double.POSITIVE_INFINITY);
        }


        distTo.set(w, 0.0);
        pq.decreaseKey(w, distTo.get(w));

        while (!pq.isEmpty()) {
            int currVertex = pq.delMin();
            System.out.println("Visiting " + currVertex);
            for (Map.Entry<Integer, Double> entry : g.getWeightedNeighbors(currVertex).entrySet()) {
                int neighbor = entry.getKey();
                double weight = entry.getValue();
                double newDistance = distTo.get(currVertex) + weight;
                double oldDistance = distTo.get(neighbor);
                if (newDistance < oldDistance) {
                    distTo.set(neighbor, newDistance);
                    vertexFrom.put(neighbor, currVertex);
                    pq.decreaseKey(neighbor, newDistance);
                    System.out.println("Updating distance to " + neighbor + " to " + newDistance);
                }
            }
            visited.add(currVertex);
        }

        if (!visited.contains(w))
            return null;

        List<Integer> path = new ArrayList<>();
        path.add(v);
        int next = v;
        while (next != w) {
            next = vertexFrom.get(next);
            path.add(next);
        }
        return path;
    }

    public static double distanceBetween (WeightedGraph g, int v, int w) {
        List<Integer> path = shortestPath(g, v, w);
        double dist = 0.0;
        for (int i = 1; i < path.size(); i++) {
            dist += g.distanceBetween(path.get(i - 1), path.get(i));
        }
        return dist;
    }

}
