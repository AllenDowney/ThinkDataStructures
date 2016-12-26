import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class Graph {

    private List<Collection<Integer>> adj;
    private Collection<Integer> vertices;
    private int numEdges;

    public Graph(int n) {
        this.numEdges = 0;
        adj = new ArrayList<>();
        vertices = new LinkedList<>();
        for (int v = 0; v < n; v++) {
            adj.add(new LinkedList<>());
            vertices.add(v);
        }
    }

    public void addEdge(int v, int w) {
        adj.get(v).add(w);
        adj.get(w).add(v);
        numEdges++;
    }

    public Iterable<Integer> vertices() {
        return vertices;
    }

    public int numVertices() {
        return vertices.size();
    }

    public int numEdges() {
        return numEdges;
    }

    public Collection<Integer> getNeighbors(int v) {
        return adj.get(v);
    }

    public boolean hasEdgeBetween(int v, int w) {
        return adj.get(v).contains(w);
    }

    public static void main(String[] args) {
        // write your code here
    }

}
