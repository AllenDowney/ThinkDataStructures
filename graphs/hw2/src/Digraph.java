import soln.Graph;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class Digraph extends Graph {

    private List<Collection<Integer>> adj;
    private int numEdges;

    public Digraph(int n) {
        super(n);
        adj = new ArrayList<>();
        for (int v = 0; v < n; v++)
            adj.add(new LinkedList<>());
    }

    public void addEdge(int v, int w) {
        adj.get(v).add(w);
        numEdges++;
    }

    public int numEdges() {
        return numEdges;
    }

    public Collection<Integer> getNeighbors(int v) {
        return adj.get(v);
    }

    public boolean hasEdgeBetween(int v, int w) {
        throw new UnsupportedOperationException();
    }


}
