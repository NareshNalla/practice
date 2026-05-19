package com.naresh.a_dsalgo.greedy.problems;

import java.util.PriorityQueue;
import java.util.Arrays; // For Arrays.toString in main method

/**
 * Problem: Huffman Coding
 * Description: Lossless data compression algorithm assigning variable-length codes to characters
 * based on their frequencies, minimizing total code length.
 */
public class HuffmanCode {

    /**
     * Represents a node in the Huffman tree.
     */
    static class TreeNode implements Comparable<TreeNode> {
        Character data; // Character for leaf nodes, null for internal nodes
        Integer freq;   // Frequency of character(s) in the subtree
        TreeNode left;
        TreeNode right;

        // Constructor for leaf nodes
        public TreeNode(Character data, Integer freq) {
            this.data = data;
            this.freq = freq;
        }

        // Constructor for internal nodes
        public TreeNode(Integer freq, TreeNode left, TreeNode right) {
            this.freq = freq;
            this.left = left;
            this.right = right;
        }

        @Override
        public int compareTo(TreeNode other) { return this.freq - other.freq; } // Compare by frequency
    }

    /**
     * Algorithm: Build Huffman tree by repeatedly merging two nodes with smallest frequencies
     * from a min-priority queue until only one node (root) remains.
     *
     * @param chars An array of characters.
     * @param freqs An array of frequencies corresponding to the characters.
     * @return The root node of the constructed Huffman tree.
     */
    public static TreeNode buildTree(char[] chars, int[] freqs) {
        // Pattern: Greedy (Priority Queue) | Time: O(N log N), Space: O(N)
        if (chars == null || freqs == null || chars.length == 0 || chars.length != freqs.length)
            throw new IllegalArgumentException("Invalid input: arrays must be non-empty and of same length.");

        var pq = new PriorityQueue<TreeNode>();
        for (var i = 0; i < chars.length; ++i) pq.add(new TreeNode(chars[i], freqs[i])); // Add leaf nodes

        while (pq.size() > 1) { // Merge until one root remains
            var small1 = pq.remove(); // Smallest freq node
            var small2 = pq.remove(); // Second smallest freq node
            var current = new TreeNode(small1.freq + small2.freq, small1, small2); // New internal node
            pq.add(current); // Add back to PQ
        }
        return pq.remove(); // The root of the Huffman tree
    }
    // FAANG Tip: Huffman coding is a classic greedy algorithm where local optimal choices (merging smallest) lead to global optimum (min total code length).

    /**
     * Algorithm: Traverse the Huffman tree recursively. Append '0' for left child, '1' for right.
     * When a leaf node is reached, print the character and its accumulated code.
     *
     * @param current The current node in the traversal.
     * @param code The binary string accumulated so far for the current path.
     */
    public static void printCodes(TreeNode current, String code) {
        // Pattern: Tree Traversal (DFS) | Time: O(N), Space: O(H)
        if (current.left == null && current.right == null) { // Leaf node found
            System.out.println("  '" + current.data + "': " + code);
            return;
        }
        if (current.left != null) printCodes(current.left, code + "0"); // Traverse left
        if (current.right != null) printCodes(current.right, code + "1"); // Traverse right
    }
    // FAANG Tip: Recursive tree traversals are common. Be mindful of stack depth for very deep trees.

    public static void main(String[] args) {
        var chars1 = new char[]{'a', 'b', 'c', 'd', 'e', 'f'};
        var freqs1 = new int[]{5, 9, 12, 13, 16, 45};
        System.out.println("--- Huffman Codes for Test Case 1 ---");
        System.out.println("Chars: " + Arrays.toString(chars1) + ", Freqs: " + Arrays.toString(freqs1));
        var root1 = buildTree(chars1, freqs1);
        System.out.println("Huffman Codes:");
        printCodes(root1, "");
        System.out.println("-------------------------------------\n");

        var chars2 = new char[]{'x', 'y', 'z'};
        var freqs2 = new int[]{1, 2, 3};
        System.out.println("--- Huffman Codes for Test Case 2 ---");
        System.out.println("Chars: " + Arrays.toString(chars2) + ", Freqs: " + Arrays.toString(freqs2));
        var root2 = buildTree(chars2, freqs2);
        System.out.println("Huffman Codes:");
        printCodes(root2, "");
        System.out.println("-------------------------------------\n");

        var chars3 = new char[]{'A', 'B'};
        var freqs3 = new int[]{10, 20};
        System.out.println("--- Huffman Codes for Test Case 3 ---");
        System.out.println("Chars: " + Arrays.toString(chars3) + ", Freqs: " + Arrays.toString(freqs3));
        var root3 = buildTree(chars3, freqs3);
        System.out.println("Huffman Codes:");
        printCodes(root3, "");
        System.out.println("-------------------------------------\n");
    }
}
