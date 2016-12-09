# Graphs Homework 2

Make a class `Search.java`

Methods:
- `List<Integer> shortestPath(Graph g, int v, int w)` Returns a list of vertices that is the shortest path from `v` to `w` (the first element in the `List` should be `v`, the last element should be `w`). Return `null` if there is no path.
- `int distanceBetween(Graph g, int v, int w)` Returns the distance between two nodes (answer should be `1` if they are directly connected). Return `-1` if the distance is infinite (the vertices are not connected).
- `List<Integer> topologicalOrder(Graph g)` Returns the vertices in a graph, in topological order
- `boolean hasCycle(Graph g)` Return whether or not a graph has a cycle.
