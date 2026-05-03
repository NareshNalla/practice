package com.naresh.a_dsalgo.tree.problems;

import com.naresh.a_dsalgo.tree.implementation.TreeNode;

/**
 * Problem: Diameter of Binary Tree
 * Description: Find the length of the longest path between any two nodes in a tree.
 * The diameter is the number of edges in the longest path between any two nodes in the tree.
 */
public class DiameterOfBinaryTree {
    private int maxDiameter = 0; // Global variable to store the maximum diameter found

    /**
     * Algorithm: Perform a post-order DFS traversal. For each node, recursively calculate the height of its left and right subtrees.
     * The diameter passing through the current node would be `leftHeight + rightHeight`. Update the global `maxDiameter` with this value.
     * The function returns the height of the current node (max of children's heights + 1) to its parent.
     */
    public int diameterOfBinaryTree(TreeNode root) {
        // Pattern: DFS (Post-order) | Time: O(n), Space: O(h)
        maxDiameter = 0; // Reset for multiple calls if needed
        getHeight(root);
        return maxDiameter;
    }

    private int getHeight(TreeNode node) {
        if (node == null) return 0;

        var leftHeight = getHeight(node.left);   // Height of left subtree
        var rightHeight = getHeight(node.right); // Height of right subtree

        // Update the global maximum diameter
        // The diameter through the current node is leftHeight + rightHeight
        maxDiameter = Math.max(maxDiameter, leftHeight + rightHeight);

        // Return the height of the current node to its parent
        return Math.max(leftHeight, rightHeight) + 1;
    }
    // FAANG Tip: The path doesn't have to pass through the root. Use a global variable or an array to track the max. This is a common pattern for problems requiring a global maximum from subtree calculations.

    public static void main(String[] args) {
        var sol = new DiameterOfBinaryTree();

        // Test Case 1: Example Tree
        //      1
        //     / \
        //    2   3
        //   / \
        //  4   5
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.left = new TreeNode(4);
        root1.left.right = new TreeNode(5);
        System.out.println("Test Case 1: " + sol.diameterOfBinaryTree(root1)); // Expected: 3 (Path: 4-2-1-3 or 5-2-1-3)

        // Test Case 2: Skewed Tree
        //      1
        //     /
        //    2
        //   /
        //  3
        // /
        //4
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.left.left = new TreeNode(3);
        root2.left.left.left = new TreeNode(4);
        System.out.println("Test Case 2: " + sol.diameterOfBinaryTree(root2)); // Expected: 3 (Path: 4-3-2-1)

        // Test Case 3: Single Node
        TreeNode root3 = new TreeNode(1);
        System.out.println("Test Case 3: " + sol.diameterOfBinaryTree(root3)); // Expected: 0

        // Test Case 4: Empty Tree
        System.out.println("Test Case 4: " + sol.diameterOfBinaryTree(null)); // Expected: 0
    }
}

/**
 * Dry Run:
 * Input: root = [1,2,3,4,5] (Tree from Test Case 1)
 *
 * 1. Initialization:
 *    maxDiameter = 0
 *    Call diameterOfBinaryTree(root=1) -> calls getHeight(node=1)
 *
 * 2. getHeight(node=1):
 *    - leftHeight = getHeight(node=2)
 *      - getHeight(node=2):
 *        - leftHeight = getHeight(node=4)
 *          - getHeight(node=4):
 *            - leftHeight = getHeight(null) -> 0
 *            - rightHeight = getHeight(null) -> 0
 *            - maxDiameter = Math.max(0, 0+0) = 0
 *            - Returns Math.max(0,0) + 1 = 1
 *          - leftHeight = 1
 *        - rightHeight = getHeight(node=5)
 *          - getHeight(node=5):
 *            - leftHeight = getHeight(null) -> 0
 *            - rightHeight = getHeight(null) -> 0
 *            - maxDiameter = Math.max(0, 0+0) = 0
 *            - Returns Math.max(0,0) + 1 = 1
 *          - rightHeight = 1
 *        - maxDiameter = Math.max(0, leftHeight(1) + rightHeight(1)) = Math.max(0, 2) = 2
 *        - Returns Math.max(leftHeight(1), rightHeight(1)) + 1 = 1 + 1 = 2
 *      - leftHeight = 2
 *    - rightHeight = getHeight(node=3)
 *      - getHeight(node=3):
 *        - leftHeight = getHeight(null) -> 0
 *        - rightHeight = getHeight(null) -> 0
 *        - maxDiameter = Math.max(2, 0+0) = 2
 *        - Returns Math.max(0,0) + 1 = 1
 *      - rightHeight = 1
 *    - maxDiameter = Math.max(2, leftHeight(2) + rightHeight(1)) = Math.max(2, 3) = 3
 *    - Returns Math.max(leftHeight(2), rightHeight(1)) + 1 = 2 + 1 = 3
 *
 * 3. diameterOfBinaryTree(root) returns maxDiameter.
 *
 * Final Result: 3
 */
