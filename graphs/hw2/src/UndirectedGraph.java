
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class UndirectedGraph extends Digraph {

    private int numEdges;

    public UndirectedGraph(int n) {
        super(n);
        this.numEdges = 0;
    }

    public void addEdge(int v, int w) {
        super.addEdge(v, w);
        super.addEdge(w, v);
        numEdges++;
    }

    public int numEdges() {
        return numEdges;
    }

    public boolean hasEdgeBetween(int v, int w) {
        return getNeighbors(v).contains(w);
    }

    public static void main(String[] args) {
        // write your code here
    }

}
