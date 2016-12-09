# Graphs Homework 3

Extend your `Graph` class and create `WeightedGraph.java` (`class WeightedGraph extends Graph`)

Methods: 
- `void addEdge(int v, int w)` Adds an edge between `v` and `w`, with a weight of `1.0`
- `void addEdge(int v, int w, double weight)` Adds an edge between `v` and `w` with a given weight
- `Map<Integer, Double> getWeightedNeighbors(int v)` Returns a `Map` from neighboring vertices to their weights from the input vertex, `v`.
- `double edgeWeight(int v, int w)` Returns the value of the edge weight between two vertices (what this function does if they are not connected is up to you.)
Make a class `WeightedSearch.java`

Methods:
- `List<Integers> shortestPath(WeightedGraph g, int v, int w)` Returns a list of vertices that is the shortest path from `v` to `w` (the first element in the `List` should be `v`, the last element should be `w`). Return `null` if there is no path.
- `double distanceBetween (WeightedGraph g, int v, int w)` Returns the distance between two nodes (answer should be the weight of the edge between them if they are directly connected). Return `-1` if the distance is infinite (the vertices are not connected).