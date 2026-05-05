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

    public static void main(String[] args) {
        var sol = new RedundantConnection();

        // Test Case 1: Simple redundant edge
        // Edges: [[1,2],[1,3],[2,3]]
        // Redundant edge: [2,3]
        int[][] edges1 = {{1, 2}, {1, 3}, {2, 3}};
        int[] result1 = sol.findRedundantConnection(edges1);
        System.out.println("Test Case 1 (Simple): " + (result1[0] == 2 && result1[1] == 3 ? "PASS" : "FAIL"));

        // Test Case 2: Self-loop
        // Edges: [[1,1]]
        int[][] edges2 = {{1, 1}};
        int[] result2 = sol.findRedundantConnection(edges2);
        System.out.println("Test Case 2 (Self-Loop): " + (result2[0] == 1 && result2[1] == 1 ? "PASS" : "FAIL"));

        // Test Case 3: Larger connected graph
        // Edges: [[1,2],[2,3],[3,4],[1,4],[1,5]]
        // Redundant edge: [1,4]
        int[][] edges3 = {{1, 2}, {2, 3}, {3, 4}, {1, 4}, {1, 5}};
        int[] result3 = sol.findRedundantConnection(edges3);
        System.out.println("Test Case 3 (Larger Graph): " + (result3[0] == 1 && result3[1] == 4 ? "PASS" : "FAIL"));

        // Test Case 4: Last edge creates redundancy
        // Edges: [[1,2],[2,3],[3,4],[4,5],[1,5]]
        int[][] edges4 = {{1, 2}, {2, 3}, {3, 4}, {4, 5}, {1, 5}};
        int[] result4 = sol.findRedundantConnection(edges4);
        System.out.println("Test Case 4 (Last Edge): " + (result4[0] == 1 && result4[1] == 5 ? "PASS" : "FAIL"));
    }
}
