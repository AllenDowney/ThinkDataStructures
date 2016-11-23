import java.util.HashMap;
import java.util.Map;

/**
 * Created by david on 11/22/16.
 */
public class WeightedGraph extends Graph {

    private Map<Integer, Map<Integer, Double>> adjacency;

    public WeightedGraph() {
        super();
    }

    public void addVertex(int v) {
        super.addVertex(v);
        adjacency.put(v, new HashMap<>());
    }

    public void addEdge(int v, int w) {
        addEdge(v, w, 1.0);
    }

    public void addEdge(int v, int w, double weight) {
        super.addEdge(v, w);
        Map<Integer, Double> map1 = adjacency.get(v);
        Map<Integer, Double> map2 = adjacency.get(w);
        map1.put(w, weight);
        map2.put(v, weight);
    }

    public Map<Integer, Double> getWeightedNeighbors(int v) {
        return adjacency.get(v);
    }

}
