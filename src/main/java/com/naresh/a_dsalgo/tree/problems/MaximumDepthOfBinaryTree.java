package com.naresh.a_dsalgo.tree.problems;

import com.naresh.a_dsalgo.tree.implementation.TreeNode;

/**
 * Problem: Maximum Depth of Binary Tree
 * Description: Find the number of nodes along the longest path from the root node down to the farthest leaf node.
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 */
public class MaximumDepthOfBinaryTree {
    /**
     * Algorithm: Recursively calculate the maximum depth. The depth of a node is 1 plus the maximum depth of its children.
     * The base case is a null node, which has a depth of 0.
     */
    public int maxDepth(TreeNode root) {
        // Pattern: DFS (Recursive) | Time: O(n), Space: O(h)
        if (root == null) return 0; // Base case: empty tree has depth 0
        
        // Recursively find the maximum depth of left and right subtrees
        var leftDepth = maxDepth(root.left);
        var rightDepth = maxDepth(root.right);
        
        // The depth of the current node is 1 (for the node itself) plus the maximum of its children's depths
        return 1 + Math.max(leftDepth, rightDepth);
    }
    // FAANG Tip: DFS is simpler to implement. BFS (level-order) can also be used but requires extra queue space. This is a fundamental tree traversal problem.

    public static void main(String[] args) {
        var sol = new MaximumDepthOfBinaryTree();

        // Test Case 1: Example Tree
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
        System.out.println("Test Case 1: " + sol.maxDepth(root1)); // Expected: 3

        // Test Case 2: Single Node
        TreeNode root2 = new TreeNode(1);
        System.out.println("Test Case 2: " + sol.maxDepth(root2)); // Expected: 1

        // Test Case 3: Empty Tree
        System.out.println("Test Case 3: " + sol.maxDepth(null)); // Expected: 0

        // Test Case 4: Skewed Tree
        //        1
        //       /
        //      2
        //     /
        //    3
        TreeNode root4 = new TreeNode(1);
        root4.left = new TreeNode(2);
        root4.left.left = new TreeNode(3);
        System.out.println("Test Case 4: " + sol.maxDepth(root4)); // Expected: 3
    }
}

/**
 * Dry Run:
 * Input: root = [3,9,20,null,null,15,7] (Tree from Test Case 1)
 *
 * 1. Call maxDepth(root=3)
 *
 * 2. maxDepth(node=3):
 *    - leftDepth = maxDepth(node=9)
 *      - maxDepth(node=9):
 *        - leftDepth = maxDepth(null) -> 0
 *        - rightDepth = maxDepth(null) -> 0
 *        - Returns 1 + Math.max(0, 0) = 1
 *      - leftDepth = 1
 *    - rightDepth = maxDepth(node=20)
 *      - maxDepth(node=20):
 *        - leftDepth = maxDepth(node=15)
 *          - maxDepth(node=15):
 *            - leftDepth = maxDepth(null) -> 0
 *            - rightDepth = maxDepth(null) -> 0
 *            - Returns 1 + Math.max(0, 0) = 1
 *          - leftDepth = 1
 *        - rightDepth = maxDepth(node=7)
 *          - maxDepth(node=7):
 *            - leftDepth = maxDepth(null) -> 0
 *            - rightDepth = maxDepth(null) -> 0
 *            - Returns 1 + Math.max(0, 0) = 1
 *          - rightDepth = 1
 *        - Returns 1 + Math.max(leftDepth(1), rightDepth(1)) = 1 + 1 = 2
 *      - rightDepth = 2
 *    - Returns 1 + Math.max(leftDepth(1), rightDepth(2)) = 1 + 2 = 3
 *
 * Final Result: 3
 */
