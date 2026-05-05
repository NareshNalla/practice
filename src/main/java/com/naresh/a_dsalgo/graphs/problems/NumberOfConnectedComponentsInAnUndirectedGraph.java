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

        var counter = n;
        for (int[] edge : edges) {
            int root1 = find(parent, edge[0]);
            int root2 = find(parent, edge[1]);
            if (root1 != root2) {
                parent[root1] = root2; // Union
                counter--;
            }
        }
        return counter;
    }

    private int find(int[] parent, int i) {
        if (parent[i] == i) return i;
        return parent[i] = find(parent, parent[i]);
    }
    // FAANG Tip: Union-Find is particularly well-suited for counting components.

    public static void main(String[] args) {
        var sol = new NumberOfConnectedComponentsInAnUndirectedGraph();

        // Test Case 1: Two components
        // Edges: [0,1], [1,2], [3,4]
        int[][] edges1 = {{0, 1}, {1, 2}, {3, 4}};
        System.out.println("Test Case 1 (2 Components): " + (sol.countComponents(5, edges1) == 2 ? "PASS" : "FAIL"));

        // Test Case 2: Single connected component
        // Edges: [0,1], [1,2], [2,3], [3,0]
        int[][] edges2 = {{0, 1}, {1, 2}, {2, 3}, {3, 0}};
        System.out.println("Test Case 2 (1 Component): " + (sol.countComponents(4, edges2) == 1 ? "PASS" : "FAIL"));

        // Test Case 3: All isolated nodes
        int[][] edges3 = {};
        System.out.println("Test Case 3 (All Isolated): " + (sol.countComponents(4, edges3) == 4 ? "PASS" : "FAIL"));

        // Test Case 4: Single node graph
        int[][] edges4 = {};
        System.out.println("Test Case 4 (Single Node): " + (sol.countComponents(1, edges4) == 1 ? "PASS" : "FAIL"));
    }
}
