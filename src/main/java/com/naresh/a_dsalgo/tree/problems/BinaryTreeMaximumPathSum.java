package com.naresh.a_dsalgo.tree.problems;

import com.naresh.a_dsalgo.tree.implementation.TreeNode;

/**
 * Problem: Binary Tree Maximum Path Sum
 * Description: Find the maximum path sum in a binary tree. A path is any sequence of nodes from some starting node to any node in the tree along the parent-child connections.
 */
public class BinaryTreeMaximumPathSum {
    private int maxSum = Integer.MIN_VALUE;

    /**
     * Algorithm: Post-order DFS. For each node, calculate max path sum *through* it and max path sum *starting* from it.
     */
    public int maxPathSum(TreeNode root) {
        // Pattern: DFS (Post-order) | Time: O(n), Space: O(h)
        dfs(root);
        return maxSum;
    }

    private int dfs(TreeNode node) {
        if (node == null) return 0;
        var leftSum = Math.max(0, dfs(node.left)); // Ignore negative paths
        var rightSum = Math.max(0, dfs(node.right)); // Ignore negative paths

        maxSum = Math.max(maxSum, node.value + leftSum + rightSum); // Path through current node

        return node.value + Math.max(leftSum, rightSum); // Path starting from current node
    }
    // FAANG Tip: The path can start and end anywhere. Need to track two types of sums: one for global max, one for parent.
}
