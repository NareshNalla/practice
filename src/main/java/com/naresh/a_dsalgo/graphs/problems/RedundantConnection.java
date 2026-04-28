package com.naresh.a_dsalgo.graphs.problems;

/**
 * Problem: Redundant Connection
 * Description: Find an edge that can be removed so that the resulting graph is a tree of n nodes.
 */
public class RedundantConnection {
    /**
     * Algorithm: Use Union-Find to detect the first edge that connects two nodes already in the same component.
     */
    public int[] findRedundantConnection(int[][] edges) {
        // Pattern: Union-Find | Time: O(V + Eα(V)), Space: O(V)
        var parent = new int[edges.length + 1];
        for (int i = 0; i <= edges.length; i++) parent[i] = i;

        for (int[] edge : edges) {
            int root1 = find(parent, edge[0]);
            int root2 = find(parent, edge[1]);
            if (root1 == root2) return edge; // Found the redundant edge
            parent[root1] = root2;
        }
        return new int[0];
    }

    private int find(int[] parent, int i) {
        if (parent[i] == i) return i;
        return parent[i] = find(parent, parent[i]);
    }
    // FAANG Tip: Union-Find is the most efficient way to detect cycles in an undirected graph.
}
