package com.naresh.a_dsalgo.tree.problems;

import com.naresh.a_dsalgo.tree.implementation.TreeNode;

/**
 * Problem: Maximum Depth of Binary Tree
 * Description: Find the number of nodes along the longest path from the root node down to the farthest leaf node.
 */
public class MaximumDepthOfBinaryTree {
    /**
     * Algorithm: Recursively find max depth of left and right subtrees and return max + 1.
     */
    public int maxDepth(TreeNode root) {
        // Pattern: DFS (Recursive) | Time: O(n), Space: O(h)
        if (root == null) return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
    // FAANG Tip: DFS is simpler to implement. BFS (level-order) can also be used but requires extra queue space.
}
