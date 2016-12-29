# Graphs Homework 3

Make a class `WeightedSearch.java`

Methods:
- `List<Integers> shortestPath(WeightedGraph g, int v, int w)` Returns a list of vertices that is the shortest path from `v` to `w` (the first element in the `List` should be `v`, the last element should be `w`). Return `null` if there is no path.
- `double distanceBetween (WeightedGraph g, int v, int w)` Returns the distance between two nodes (answer should be the weight of the edge between them if they are directly connected). Return `-1` if the distance is infinite (the vertices are not connected).