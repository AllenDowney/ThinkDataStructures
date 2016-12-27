import java.util.Collection;
import java.util.List;

public interface Graph {

    public void addEdge(int v, int w);

    public Iterable<Integer> vertices();

    public int numVertices();

    public int numEdges();

    public Collection<Integer> getNeighbors(int v);

    public boolean hasEdgeBetween(int v, int w);
}
