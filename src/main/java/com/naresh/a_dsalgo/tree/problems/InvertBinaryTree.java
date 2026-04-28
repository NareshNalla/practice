package com.naresh.a_dsalgo.tree.problems;

import com.naresh.a_dsalgo.tree.implementation.TreeNode;

/**
 * Problem: Invert Binary Tree
 * Description: Given the root of a binary tree, invert the tree, and return its root.
 */
public class InvertBinaryTree {
    /**
     * Algorithm: Recursively swap left and right children of every node in the tree.
     */
    public TreeNode invertTree(TreeNode root) {
        // Pattern: DFS (Recursive) | Time: O(n), Space: O(h)
        if (root == null) return null;
        var temp = root.left; // Temporary store
        root.left = invertTree(root.right);
        root.right = invertTree(temp);
        return root;
    }
    // FAANG Tip: Mention that O(h) space is due to the recursion stack, where h is height of the tree.
}
