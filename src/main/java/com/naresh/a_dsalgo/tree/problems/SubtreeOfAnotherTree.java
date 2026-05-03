package com.naresh.a_dsalgo.tree.problems;

import com.naresh.a_dsalgo.tree.implementation.TreeNode;

/**
 * Problem: Subtree of Another Tree
 * Description: Given the roots of two binary trees `root` and `subRoot`, return `true` if there is a subtree of `root` with the same structure and node values of `subRoot` and `false` otherwise.
 * A subtree of a binary tree `tree` is `tree` with some node of `tree` and all of its descendants. The tree `tree` itself is also a subtree.
 */
public class SubtreeOfAnotherTree {
    /**
     * Algorithm: This problem involves two main parts:
     * 1. Traverse the `root` tree (e.g., using DFS).
     * 2. At each node in `root`, check if the subtree rooted at that node is identical to `subRoot` using a helper function (`isSame`).
     */
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        // Pattern: Recursive Comparison | Time: O(n*m), Space: O(h)
        if (root == null) return false; // If root is null, subRoot cannot be found

        // Check if the current subtree (rooted at 'root') is identical to 'subRoot'
        if (isSame(root, subRoot)) return true;

        // Otherwise, recursively check if 'subRoot' is a subtree of the left or right child
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    /**
     * Helper function to check if two trees are identical.
     * This is the same logic as the "Same Tree" problem (LeetCode 100).
     */
    private boolean isSame(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true; // Both null, identical
        if (p == null || q == null || p.value != q.value) return false; // One null or values differ, not identical
        
        // Recursively check left and right subtrees for identity
        return isSame(p.left, q.left) && isSame(p.right, q.right);
    }
    // FAANG Tip: Mention that this can be optimized to O(n+m) using string serialization (e.g., with pre-order traversal and null markers) or tree hashing (Merkle Tree) to avoid repeated tree comparisons.

    public static void main(String[] args) {
        var sol = new SubtreeOfAnotherTree();

        // Test Case 1: subRoot is a subtree
        // root:      3
        //           / \
        //          4   5
        //         / \
        //        1   2
        // subRoot: 4
        //         / \
        //        1   2
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(4);
        root1.right = new TreeNode(5);
        root1.left.left = new TreeNode(1);
        root1.left.right = new TreeNode(2);

        TreeNode subRoot1 = new TreeNode(4);
        subRoot1.left = new TreeNode(1);
        subRoot1.right = new TreeNode(2);
        System.out.println("Test Case 1: " + sol.isSubtree(root1, subRoot1)); // Expected: true

        // Test Case 2: subRoot is NOT a subtree (different value)
        // root:      3
        //           / \
        //          4   5
        //         / \
        //        1   2
        // subRoot: 4
        //         / \
        //        1   0 (different from 2)
        TreeNode subRoot2 = new TreeNode(4);
        subRoot2.left = new TreeNode(1);
        subRoot2.right = new TreeNode(0);
        System.out.println("Test Case 2: " + sol.isSubtree(root1, subRoot2)); // Expected: false

        // Test Case 3: subRoot is NOT a subtree (different structure)
        // root:      3
        //           / \
        //          4   5
        //         / \
        //        1   2
        // subRoot: 4
        //         /
        //        1
        TreeNode subRoot3 = new TreeNode(4);
        subRoot3.left = new TreeNode(1);
        System.out.println("Test Case 3: " + sol.isSubtree(root1, subRoot3)); // Expected: false

        // Test Case 4: Empty subRoot (always true if root is not null)
        System.out.println("Test Case 4 (Empty subRoot): " + sol.isSubtree(root1, null)); // Expected: true

        // Test Case 5: Empty root (false unless subRoot is also empty)
        System.out.println("Test Case 5 (Empty root, non-empty subRoot): " + sol.isSubtree(null, subRoot1)); // Expected: false
        System.out.println("Test Case 5 (Both empty): " + sol.isSubtree(null, null)); // Expected: true
    }
}

/**
 * Dry Run:
 * Input: root = [3,4,5,1,2], subRoot = [4,1,2] (Test Case 1)
 *
 * 1. Call isSubtree(root=3, subRoot=4)
 *
 * 2. isSubtree(root=3, subRoot=4):
 *    - isSame(p=3, q=4):
 *      - p.value (3) != q.value (4). Returns false.
 *    - isSame returned false.
 *    - Calls isSubtree(root.left=4, subRoot=4) OR isSubtree(root.right=5, subRoot=4)
 *
 * 3. isSubtree(root=4, subRoot=4):
 *    - isSame(p=4, q=4):
 *      - p.value (4) == q.value (4).
 *      - Calls isSame(p.left=1, q.left=1) AND isSame(p.right=2, q.right=2)
 *
 * 4. isSame(p=1, q=1):
 *    - p.value (1) == q.value (1).
 *    - Calls isSame(p.left=null, q.left=null) AND isSame(p.right=null, q.right=null)
 *      - isSame(null, null) -> returns true
 *      - isSame(null, null) -> returns true
 *    - Returns true && true -> true
 *
 * 5. isSame(p=2, q=2):
 *    - p.value (2) == q.value (2).
 *    - Calls isSame(p.left=null, q.left=null) AND isSame(p.right=null, q.right=null)
 *      - isSame(null, null) -> returns true
 *      - isSame(null, null) -> returns true
 *    - Returns true && true -> true
 *
 * 6. Back to isSame(p=4, q=4):
 *    - Returns true && true -> true
 *
 * 7. Back to isSubtree(root=4, subRoot=4):
 *    - isSame returned true.
 *    - Returns true.
 *
 * 8. Back to isSubtree(root=3, subRoot=4):
 *    - The first part of the OR (isSubtree(root.left=4, subRoot=4)) returned true.
 *    - The entire expression `true || isSubtree(...)` short-circuits to true.
 *
 * Final Result: true
 */
