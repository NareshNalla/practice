package com.naresh.a_dsalgo.tree.problems;

import com.naresh.a_dsalgo.tree.implementation.TreeNode;

/**
 * Problem: Balanced Binary Tree
 * Description: Given a binary tree, determine if it is height-balanced.
 * A height-balanced binary tree is a binary tree in which the depth of the two subtrees of every node never differs by more than one.
 */
public class BalancedBinaryTree {
    /**
     * Algorithm: Use post-order DFS to get height of subtrees. For each node, calculate the height of its left and right subtrees.
     * If at any point the difference in heights is greater than 1, or if a subtree is already unbalanced, propagate -1 up to signify imbalance.
     * Otherwise, return the current node's height (max of children's heights + 1).
     */
    public boolean isBalanced(TreeNode root) {
        // Pattern: DFS (Post-order) | Time: O(n), Space: O(h)
        return getHeight(root) != -1;
    }

    private int getHeight(TreeNode root) {
        if (root == null) return 0;

        var leftHeight = getHeight(root.left);
        if (leftHeight == -1) return -1; // Propagate imbalance from left subtree

        var rightHeight = getHeight(root.right);
        if (rightHeight == -1) return -1; // Propagate imbalance from right subtree

        if (Math.abs(leftHeight - rightHeight) > 1) return -1; // Current node is unbalanced

        return Math.max(leftHeight, rightHeight) + 1; // Return current node's height
    }
    // FAANG Tip: Bottom-up approach (O(n)) is superior to top-down (O(n^2)) which recomputes heights repeatedly. The -1 propagation is key for efficiency.

    public static void main(String[] args) {
        var sol = new BalancedBinaryTree();

        // Test Case 1: Balanced Tree
        //      3
        //     / \
        //    9  20
        //      /  \
        //     15   7
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(9);
        root1.right = new TreeNode(20);
        root1.right.left = new TreeNode(15);
        root1.right.right = new TreeNode(7);
        System.out.println("Test Case 1 (Balanced): " + sol.isBalanced(root1)); // Expected: true

        // Test Case 2: Unbalanced Tree
        //        1
        //       /
        //      2
        //     /
        //    3
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.left.left = new TreeNode(3);
        System.out.println("Test Case 2 (Unbalanced): " + sol.isBalanced(root2)); // Expected: false

        // Test Case 3: Empty Tree
        System.out.println("Test Case 3 (Empty): " + sol.isBalanced(null)); // Expected: true
    }
}

/**
 * Dry Run:
 * Input: root = [1,2,null,3,null,null,null] (Unbalanced Tree from Test Case 2)
 *
 * 1. Call isBalanced(root=1)
 *    - Calls getHeight(root=1)
 *
 * 2. getHeight(node=1):
 *    - leftHeight = getHeight(node=2)
 *      - getHeight(node=2):
 *        - leftHeight = getHeight(node=3)
 *          - getHeight(node=3):
 *            - leftHeight = getHeight(null) -> returns 0
 *            - rightHeight = getHeight(null) -> returns 0
 *            - Math.abs(0 - 0) <= 1. Returns Math.max(0,0) + 1 = 1.
 *        - leftHeight = 1
 *        - rightHeight = getHeight(null) -> returns 0
 *        - Math.abs(1 - 0) <= 1. Returns Math.max(1,0) + 1 = 2.
 *    - leftHeight = 2
 *    - rightHeight = getHeight(null) -> returns 0
 *    - Math.abs(leftHeight - rightHeight) = Math.abs(2 - 0) = 2.
 *    - 2 > 1. Returns -1. (Node 1 is unbalanced)
 *
 * 3. isBalanced(root=1) receives -1.
 *    - Returns -1 != -1 -> false.
 *
 * Final Result: false
 */
