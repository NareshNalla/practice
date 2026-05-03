package com.naresh.a_dsalgo.tree.problems;

import com.naresh.a_dsalgo.tree.implementation.TreeNode;

/**
 * Problem: Binary Tree Maximum Path Sum
 * Description: Find the maximum path sum in a binary tree. A path is any sequence of nodes from some starting node to any node in the tree along the parent-child connections.
 * The path does not need to pass through the root.
 */
public class BinaryTreeMaximumPathSum {
    private int maxSum = Integer.MIN_VALUE; // Global variable to store the maximum path sum found

    /**
     * Algorithm: Post-order DFS. For each node, recursively calculate the maximum path sum *starting* from that node
     * and going downwards (either left or right child). This value is returned to its parent.
     * Simultaneously, at each node, update a global `maxSum` by considering the path that *goes through* the current node
     * (i.e., current node's value + max path from left child + max path from right child).
     * Negative path sums from children are ignored (treated as 0).
     */
    public int maxPathSum(TreeNode root) {
        // Pattern: DFS (Post-order) | Time: O(n), Space: O(h)
        maxSum = Integer.MIN_VALUE; // Reset for multiple calls if needed
        dfs(root);
        return maxSum;
    }

    private int dfs(TreeNode node) {
        if (node == null) return 0;

        // Recursively get max path sum from left and right children
        // We take Math.max(0, ...) because we don't want to include negative path sums
        var leftSum = Math.max(0, dfs(node.left));
        var rightSum = Math.max(0, dfs(node.right));

        // Calculate the path sum that *goes through* the current node
        // This path can potentially be the global maximum
        maxSum = Math.max(maxSum, node.value + leftSum + rightSum);

        // Return the maximum path sum *starting* from the current node and going downwards
        // This is what the parent node will consider
        return node.value + Math.max(leftSum, rightSum);
    }
    // FAANG Tip: The path can start and end anywhere. Need to track two types of sums: one for global max (path through node), one for parent (path starting from node).

    public static void main(String[] args) {
        var sol = new BinaryTreeMaximumPathSum();

        // Test Case 1: Example from LeetCode
        //      1
        //     / \
        //    2   3
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        System.out.println("Test Case 1: " + sol.maxPathSum(root1)); // Expected: 6 (2 -> 1 -> 3)

        // Test Case 2: Negative values
        //     -10
        //     / \
        //    9  20
        //      /  \
        //     15   7
        TreeNode root2 = new TreeNode(-10);
        root2.left = new TreeNode(9);
        root2.right = new TreeNode(20);
        root2.right.left = new TreeNode(15);
        root2.right.right = new TreeNode(7);
        System.out.println("Test Case 2: " + sol.maxPathSum(root2)); // Expected: 42 (9 -> -10 -> 20 -> 15 or 9 -> -10 -> 20 -> 7) actually 20->15->7 is 42

        // Test Case 3: Single node
        TreeNode root3 = new TreeNode(-3);
        System.out.println("Test Case 3: " + sol.maxPathSum(root3)); // Expected: -3

        // Test Case 4: All negative
        //      -1
        //     / \
        //    -2  -3
        TreeNode root4 = new TreeNode(-1);
        root4.left = new TreeNode(-2);
        root4.right = new TreeNode(-3);
        System.out.println("Test Case 4: " + sol.maxPathSum(root4)); // Expected: -1 (path is just -1)
    }
}

/**
 * Dry Run:
 * Input: root = [-10,9,20,null,null,15,7] (Tree from Test Case 2)
 *
 * 1. Initialization:
 *    maxSum = Integer.MIN_VALUE
 *    Call maxPathSum(root = -10) -> calls dfs(root = -10)
 *
 * 2. dfs(node = -10):
 *    - leftSum = dfs(node = 9)
 *      - dfs(node = 9):
 *        - leftSum = dfs(null) -> 0
 *        - rightSum = dfs(null) -> 0
 *        - maxSum = Math.max(MIN_VALUE, 9 + 0 + 0) = 9
 *        - Returns 9 + Math.max(0, 0) = 9
 *      - leftSum = 9
 *    - rightSum = dfs(node = 20)
 *      - dfs(node = 20):
 *        - leftSum = dfs(node = 15)
 *          - dfs(node = 15):
 *            - leftSum = dfs(null) -> 0
 *            - rightSum = dfs(null) -> 0
 *            - maxSum = Math.max(9, 15 + 0 + 0) = 15
 *            - Returns 15 + Math.max(0, 0) = 15
 *          - leftSum = 15
 *        - rightSum = dfs(node = 7)
 *          - dfs(node = 7):
 *            - leftSum = dfs(null) -> 0
 *            - rightSum = dfs(null) -> 0
 *            - maxSum = Math.max(15, 7 + 0 + 0) = 15 (still 15)
 *            - Returns 7 + Math.max(0, 0) = 7
 *          - rightSum = 7
 *        - maxSum = Math.max(15, 20 + 15 + 7) = Math.max(15, 42) = 42
 *        - Returns 20 + Math.max(15, 7) = 20 + 15 = 35
 *      - rightSum = 35
 *    - maxSum = Math.max(42, -10 + 9 + 35) = Math.max(42, 34) = 42
 *    - Returns -10 + Math.max(9, 35) = -10 + 35 = 25
 *
 * 3. maxPathSum(root) returns maxSum.
 *
 * Final Result: 42
 */
