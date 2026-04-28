package com.naresh.a_dsalgo.tree.problems;

import com.naresh.a_dsalgo.tree.implementation.TreeNode;

/**
 * Problem: Validate Binary Search Tree
 * Description: Determine if a binary tree is a valid binary search tree (BST).
 */
public class ValidateBinarySearchTree {
    /**
     * Algorithm: Recursively validate each node with a range [min, max]. Update ranges for children.
     */
    public boolean isValidBST(TreeNode root) {
        // Pattern: DFS (Range Validation) | Time: O(n), Space: O(h)
        return validate(root, null, null);
    }

    private boolean validate(TreeNode node, Integer min, Integer max) {
        if (node == null) return true;
        if ((min != null && node.value <= min) || (max != null && node.value >= max)) return false;
        return validate(node.left, min, node.value) && validate(node.right, node.value, max);
    }
    // FAANG Tip: Use Integer objects or Long.MIN/MAX to handle tree values equal to Integer extremes.
}
