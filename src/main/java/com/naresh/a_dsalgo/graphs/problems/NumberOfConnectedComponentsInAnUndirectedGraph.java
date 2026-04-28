package com.naresh.a_dsalgo.graphs.problems;

/**
 * Problem: Number of Connected Components in an Undirected Graph
 * Description: Given n nodes and a list of undirected edges, return the number of connected components.
 */
public class NumberOfConnectedComponentsInAnUndirectedGraph {
    /**
     * Algorithm: Use Union-Find to group nodes. Start with n components and decrement for each successful union.
     */
    public int countComponents(int n, int[][] edges) {
        // Pattern: Union-Find | Time: O(V + Eα(V)), Space: O(V)
        var parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;

        var components = n;
        for (int[] edge : edges) {
            int root1 = find(parent, edge[0]);
            int root2 = find(parent, edge[1]);
            if (root1 != root2) {
                parent[root1] = root2; // Union
                components--;
            }
        }
        return components;
    }

    private int find(int[] parent, int i) {
        if (parent[i] == i) return i;
        return parent[i] = find(parent, parent[i]);
    }
    // FAANG Tip: Union-Find is particularly well-suited for counting components.
}
