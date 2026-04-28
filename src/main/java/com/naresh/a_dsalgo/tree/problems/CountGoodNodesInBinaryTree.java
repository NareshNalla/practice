package com.naresh.a_dsalgo.tree.problems;

import com.naresh.a_dsalgo.tree.implementation.TreeNode;

/**
 * Problem: Count Good Nodes in Binary Tree
 * Description: A node X is "good" if in the path from root to X, there are no nodes with a value greater than X.
 */
public class CountGoodNodesInBinaryTree {
    /**
     * Algorithm: DFS traversal while keeping track of the maximum value seen so far on the path.
     */
    public int goodNodes(TreeNode root) {
        // Pattern: DFS (Path Tracking) | Time: O(n), Space: O(h)
        return dfs(root, Integer.MIN_VALUE);
    }

    private int dfs(TreeNode node, int maxVal) {
        if (node == null) return 0;
        int res = (node.value >= maxVal) ? 1 : 0; // Current node is good
        int currentMax = Math.max(maxVal, node.value);
        res += dfs(node.left, currentMax);
        res += dfs(node.right, currentMax);
        return res;
    }
    // FAANG Tip: Passing state (maxVal) down the recursion stack avoids global variables and simplifies logic.
}
