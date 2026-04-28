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
}
