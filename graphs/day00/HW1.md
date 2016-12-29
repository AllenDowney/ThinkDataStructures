# Graphs Homework 1

Make a class `UndirectedGraph.java` that represents a graph. It should have the following methods:

Constructor:
- `UndirectedGraph(int n)`, creates a graph with `n` vertices, labeled `[0, 1, 2, ... , n-1]`

Methods:
- `void addEdge(int v, int w)` Adds an edge between `v` and `w`
- `Iterable<Integer> vertices()` Returns all vertices in the graph.
- `int numVertices()` Returns the number of vertices in the graph
- `int numEdges()` Returns the number of edges in the graph
- `Iterable<Integer> getNeighbors(int v)` Returns the vertices connected to a given vertex
- `boolean hasEdgeBetween(int v, int w)` Returns whether two vertices have an edge between them.

Write a short comment at the beginning of each method detailing the runtime complexity in big-O notation. (runtime in graph problems is expressed in terms of `O(V)` and `O(E)`, where V and E are the number of vertices and edges).