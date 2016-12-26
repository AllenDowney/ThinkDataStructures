import java.util.*;

/**
 * Created by david on 11/22/16.
 */
public class WeightedGraph extends Graph {

    private List<Map<Integer, Double>> adj;

    public WeightedGraph(int n) {
        super(n);
        adj = new ArrayList<>();
        for (int v = 0; v < n; v++) {
            adj.add(new HashMap<>());
        }
    }

    public void addEdge(int v, int w) {
        addEdge(v, w, 1.0);
    }

    public void addEdge(int v, int w, double weight) {
        super.addEdge(v, w);
        Map<Integer, Double> map1 = adj.get(v);
        Map<Integer, Double> map2 = adj.get(w);
        map1.put(w, weight);
        map2.put(v, weight);
    }

    public double distanceBetween(int v, int w) {

        if (!hasEdgeBetween(v, w))
            throw new IllegalArgumentException("There is no edge connecting " + v + " and " + w);

        return adj.get(v).get(w);

    }

    public Map<Integer, Double> getWeightedNeighbors(int v) {
        return adj.get(v);
    }

}
