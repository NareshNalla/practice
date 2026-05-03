package com.naresh.a_dsalgo.tree.problems;

import com.naresh.a_dsalgo.tree.implementation.TreeNode;

/**
 * Problem: Same Tree
 * Description: Given the roots of two binary trees p and q, return true if they are the same or false otherwise.
 * Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
 */
public class SameTree {

    /**
     * Algorithm: Recursively compare nodes.
     * Base cases:
     * 1. If both nodes are null, they are the same (return true).
     * 2. If one node is null and the other is not, or if their values differ, they are not the same (return false).
     * Recursive step:
     * Otherwise, check if their left subtrees are the same AND their right subtrees are the same.
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // Pattern: Recursion | Time: O(min(N, M)), Space: O(min(H1, H2)) where N, M are number of nodes and H1, H2 are heights
        if (p == null && q == null) return true; // Both null, they are the same
        if (p == null || q == null || p.value != q.value) return false; // One is null or values differ, not same
        
        // Recursively check left and right subtrees
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
    // FAANG Tip: This is a classic recursive tree traversal. Time complexity is bounded by the smaller tree's nodes.
    // Space complexity is due to recursion stack, bounded by the smaller tree's height.

    public static void main(String[] args) {
        var sol = new SameTree();

        // Test Case 1: Identical Trees
        //   1       1
        //  / \     / \
        // 2   3   2   3
        TreeNode p1 = new TreeNode(1);
        p1.left = new TreeNode(2);
        p1.right = new TreeNode(3);
        TreeNode q1 = new TreeNode(1);
        q1.left = new TreeNode(2);
        q1.right = new TreeNode(3);
        System.out.println("Test Case 1 (Identical): " + sol.isSameTree(p1, q1)); // Expected: true

        // Test Case 2: Different Structure
        //   1       1
        //  /         \
        // 2           2
        TreeNode p2 = new TreeNode(1);
        p2.left = new TreeNode(2);
        TreeNode q2 = new TreeNode(1);
        q2.right = new TreeNode(2);
        System.out.println("Test Case 2 (Different Structure): " + sol.isSameTree(p2, q2)); // Expected: false

        // Test Case 3: Different Values
        //   1       1
        //  / \     / \
        // 2   1   2   3
        TreeNode p3 = new TreeNode(1);
        p3.left = new TreeNode(2);
        p3.right = new TreeNode(1);
        TreeNode q3 = new TreeNode(1);
        q3.left = new TreeNode(2);
        q3.right = new TreeNode(3);
        System.out.println("Test Case 3 (Different Values): " + sol.isSameTree(p3, q3)); // Expected: false

        // Test Case 4: Both Empty
        System.out.println("Test Case 4 (Both Empty): " + sol.isSameTree(null, null)); // Expected: true
    }
}

/**
 * Dry Run:
 * Input: p = [1,2,3], q = [1,2,3] (Test Case 1)
 *
 * 1. Call isSameTree(p=1, q=1)
 *
 * 2. isSameTree(p=1, q=1):
 *    - p and q are not null, p.value (1) == q.value (1).
 *    - Calls isSameTree(p.left=2, q.left=2) AND isSameTree(p.right=3, q.right=3)
 *
 * 3. isSameTree(p=2, q=2):
 *    - p and q are not null, p.value (2) == q.value (2).
 *    - Calls isSameTree(p.left=null, q.left=null) AND isSameTree(p.right=null, q.right=null)
 *      - isSameTree(p=null, q=null) -> returns true
 *      - isSameTree(p=null, q=null) -> returns true
 *    - Returns true && true -> true
 *
 * 4. isSameTree(p=3, q=3):
 *    - p and q are not null, p.value (3) == q.value (3).
 *    - Calls isSameTree(p.left=null, q.left=null) AND isSameTree(p.right=null, q.right=null)
 *      - isSameTree(p=null, q=null) -> returns true
 *      - isSameTree(p=null, q=null) -> returns true
 *    - Returns true && true -> true
 *
 * 5. Back to isSameTree(p=1, q=1):
 *    - Returns true && true -> true
 *
 * Final Result: true
 *
 * Dry Run:
 * Input: p = [1,2], q = [1,null,2] (Test Case 2)
 *
 * 1. Call isSameTree(p=1, q=1)
 *
 * 2. isSameTree(p=1, q=1):
 *    - p and q are not null, p.value (1) == q.value (1).
 *    - Calls isSameTree(p.left=2, q.left=null) AND isSameTree(p.right=null, q.right=2)
 *
 * 3. isSameTree(p=2, q=null):
 *    - p is not null, q is null.
 *    - Returns false.
 *
 * 4. Back to isSameTree(p=1, q=1):
 *    - The first part of the AND (isSameTree(p.left=2, q.left=null)) returned false.
 *    - The entire expression `false && isSameTree(...)` short-circuits to false.
 *
 * Final Result: false
 */
