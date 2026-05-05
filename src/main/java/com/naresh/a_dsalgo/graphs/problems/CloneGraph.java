package com.naresh.a_dsalgo.graphs.problems;

import java.util.*;

// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

/**
 * Problem: Clone Graph
 * Description: Given a reference of a node in a connected undirected graph, return a deep copy (clone) of the graph.
 */
public class CloneGraph {
    private Map<Integer, Node> visited = new HashMap<>();

    /**
     * Algorithm: DFS traversal. Create a copy of the current node, add it to visited map, then recursively clone its neighbors.
     */
    public Node cloneGraph(Node node) {
        // Pattern: DFS + HashMap | Time: O(V + E), Space: O(V)
        if (node == null) return null;
        if (visited.containsKey(node.val)) return visited.get(node.val); // Already cloned

        var clone = new Node(node.val); // Create copy
        visited.put(node.val, clone);   // Add to visited map

        for (Node neighbor : node.neighbors) {
            clone.neighbors.add(cloneGraph(neighbor)); // Recursively clone neighbors
        }
        return clone;
    }
    // FAANG Tip: The HashMap is crucial to handle cycles and avoid redundant work. BFS can also be used.

    public static void main(String[] args) {
        var sol = new CloneGraph();

        // Test Case 1: Simple connected graph [1,2,4],[1,3],[2,4],[3,4]
        // 1 -> 2, 4
        // 2 -> 1, 4
        // 3 -> 2, 4
        // 4 -> 1, 3
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        
        node1.neighbors.add(node2);
        node1.neighbors.add(node4);
        node2.neighbors.add(node1);
        node2.neighbors.add(node3);
        node3.neighbors.add(node2);
        node3.neighbors.add(node4);
        node4.neighbors.add(node1);
        node4.neighbors.add(node3);
        
        Node clonedGraph1 = sol.cloneGraph(node1);
        System.out.println("Test Case 1 (Cloned Graph): " + (clonedGraph1.val == 1 && !clonedGraph1.equals(node1) ? "PASS" : "FAIL"));
        
        // Test Case 2: Single node
        sol.visited.clear();
        Node singleNode = new Node(1);
        Node clonedSingleNode = sol.cloneGraph(singleNode);
        System.out.println("Test Case 2 (Single Node): " + (clonedSingleNode.val == 1 && clonedSingleNode.neighbors.isEmpty() ? "PASS" : "FAIL"));
        
        // Test Case 3: Null graph
        sol.visited.clear();
        Node clonedNull = sol.cloneGraph(null);
        System.out.println("Test Case 3 (Null Graph): " + (clonedNull == null ? "PASS" : "FAIL"));
    }
}
