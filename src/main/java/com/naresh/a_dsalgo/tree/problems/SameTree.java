package com.naresh.a_dsalgo.tree.problems;

import com.naresh.a_dsalgo.tree.implementation.TreeNode;

/**
 * Problem: Same Tree
 * Description: Given the roots of two binary trees p and q, return true if they are the same or false otherwise.
 * Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
 */
public class SameTree {

    /**
     * Algorithm: Recursively compare nodes. If both are null, they are same. If one is null or values differ, not same.
     * Otherwise, check left and right subtrees.
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // Pattern: Recursion | Time: O(min(N, M)), Space: O(min(H1, H2)) where N, M are number of nodes and H1, H2 are heights
        if (p == null && q == null) return true; // Both null, same
        if (p == null || q == null || p.value != q.value) return false; // One null or values differ, not same
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right); // Recurse
    }
    // FAANG Tip: This is a classic recursive tree traversal. Time complexity is bounded by the smaller tree's nodes.
    // Space complexity is due to recursion stack, bounded by the smaller tree's height.
}
