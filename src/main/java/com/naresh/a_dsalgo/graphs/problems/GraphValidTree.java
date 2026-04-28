package com.naresh.a_dsalgo.graphs.problems;

import java.util.*;

/**
 * Problem: Graph Valid Tree
 * Description: Given n nodes and a list of edges, check if these edges form a valid tree.
 * A tree is valid if it is connected and has no cycles.
 */
public class GraphValidTree {
    /**
     * Algorithm: Use Union-Find to detect cycles and ensure all nodes are connected (edges == n - 1).
     */
    public boolean validTree(int n, int[][] edges) {
        // Pattern: Union-Find | Time: O(V + Eα(V)), Space: O(V)
        if (edges.length != n - 1) return false; // Tree must have exactly n-1 edges
        var parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;

        for (int[] edge : edges) {
            int root1 = find(parent, edge[0]);
            int root2 = find(parent, edge[1]);
            if (root1 == root2) return false; // Cycle detected
            parent[root1] = root2; // Union
        }
        return true;
    }

    private int find(int[] parent, int i) {
        if (parent[i] == i) return i;
        return parent[i] = find(parent, parent[i]); // Path compression
    }
    // FAANG Tip: A valid tree with n nodes must have exactly n-1 edges. Union-Find with path compression is optimal for cycle detection.
}
