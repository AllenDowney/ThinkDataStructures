
public interface Graph {

    void addEdge(int v, int w);
    Iterable<Integer> vertices();
    int numVertices();
    int numEdges();
    Iterable<Integer> getNeighbors(int v);
    boolean hasEdgeBetween(int v, int w);

}
