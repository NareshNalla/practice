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

    public static void main(String[] args) {
        var sol = new GraphValidTree();

        // Test Case 1: Valid tree (n=5, edges=4, no cycle)
        // Edges: [0,1], [0,2], [0,3], [1,4]
        int[][] edges1 = {{0, 1}, {0, 2}, {0, 3}, {1, 4}};
        System.out.println("Test Case 1 (Valid Tree): " + (sol.validTree(5, edges1) ? "PASS" : "FAIL"));

        // Test Case 2: Invalid tree (cycle exists)
        // Edges: [0,1], [1,2], [2,0]
        int[][] edges2 = {{0, 1}, {1, 2}, {2, 0}};
        System.out.println("Test Case 2 (Cycle Exists): " + (!sol.validTree(3, edges2) ? "PASS" : "FAIL"));

        // Test Case 3: Invalid tree (not enough edges)
        // Edges: [0,1] for n=3 (needs 2 edges)
        int[][] edges3 = {{0, 1}};
        System.out.println("Test Case 3 (Too Few Edges): " + (!sol.validTree(3, edges3) ? "PASS" : "FAIL"));

        // Test Case 4: Single node tree
        int[][] edges4 = {};
        System.out.println("Test Case 4 (Single Node): " + (sol.validTree(1, edges4) ? "PASS" : "FAIL"));
    }
}
