# Graphs Homework 2

Make a class `DFS.java`

Methods:
- `connected(Graph g, int v, int u)` Returns whether you can, starting from `v`, traverse the graph and reach `u`.
- `List<Integer> topologicalOrder(Digraph g)` Returns the vertices in a graph, in topological order. If there is an edge pointing from `u` to `v`, then `u` comes before `v` in the topological ordering.
- `boolean hasCycle(Graph g)` Return whether or not a graph has a cycle.
