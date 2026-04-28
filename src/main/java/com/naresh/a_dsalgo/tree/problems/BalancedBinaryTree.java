package com.naresh.a_dsalgo.tree.problems;

import com.naresh.a_dsalgo.tree.implementation.TreeNode;

/**
 * Problem: Balanced Binary Tree
 * Description: Given a binary tree, determine if it is height-balanced.
 */
public class BalancedBinaryTree {
    /**
     * Algorithm: Use post-order DFS to get height of subtrees. Return -1 if unbalanced to short-circuit.
     */
    public boolean isBalanced(TreeNode root) {
        // Pattern: DFS (Post-order) | Time: O(n), Space: O(h)
        return getHeight(root) != -1;
    }

    private int getHeight(TreeNode root) {
        if (root == null) return 0;
        var left = getHeight(root.left);
        if (left == -1) return -1; // Propagate imbalance
        var right = getHeight(root.right);
        if (right == -1 || Math.abs(left - right) > 1) return -1; // Unbalanced
        return Math.max(left, right) + 1;
    }
    // FAANG Tip: Bottom-up approach (O(n)) is superior to top-down (O(n^2)) which recomputes heights repeatedly.
}
