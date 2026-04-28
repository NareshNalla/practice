package com.naresh.a_dsalgo.tree.problems;

import com.naresh.a_dsalgo.tree.implementation.TreeNode;
import java.util.ArrayDeque;

/**
 * Problem: Kth Smallest Element in a BST
 * Description: Given the root of a binary search tree and an integer k, return the kth smallest value (1-indexed).
 */
public class KthSmallestElementInBST {
    /**
     * Algorithm: Use iterative in-order traversal (Left-Root-Right). Stop and return at kth element.
     */
    public int kthSmallest(TreeNode root, int k) {
        // Pattern: Iterative In-order | Time: O(h + k), Space: O(h)
        var stack = new ArrayDeque<TreeNode>();
        var curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left; // Go deep left
            }
            curr = stack.pop(); // Process
            if (--k == 0) return curr.value; // Found kth
            curr = curr.right; // Move right
        }
        return -1;
    }
    // FAANG Tip: BST properties ensure in-order traversal is sorted. Iterative approach allows early exit.
}
