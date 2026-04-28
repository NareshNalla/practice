package com.naresh.a_dsalgo.tree.problems;

import com.naresh.a_dsalgo.tree.implementation.TreeNode;

/**
 * Problem: Diameter of Binary Tree
 * Description: Find the length of the longest path between any two nodes in a tree.
 */
public class DiameterOfBinaryTree {
    private int maxDiameter = 0;

    /**
     * Algorithm: Post-order DFS returns height. Update max diameter as left height + right height at each node.
     */
    public int diameterOfBinaryTree(TreeNode root) {
        // Pattern: DFS (Post-order) | Time: O(n), Space: O(h)
        getHeight(root);
        return maxDiameter;
    }

    private int getHeight(TreeNode root) {
        if (root == null) return 0;
        var left = getHeight(root.left);
        var right = getHeight(root.right);
        maxDiameter = Math.max(maxDiameter, left + right); // Update global max
        return Math.max(left, right) + 1;
    }
    // FAANG Tip: The path doesn't have to pass through the root. Use a global variable or an array to track the max.
}
