package com.naresh.a_dsalgo.tree.problems;

import com.naresh.a_dsalgo.tree.implementation.TreeNode;
import java.util.function.Consumer; // For printTree helper

/**
 * Problem: Invert Binary Tree
 * Description: Given the root of a binary tree, invert the tree, and return its root.
 * Inverting a binary tree means for every node, swapping its left and right children.
 */
public class InvertBinaryTree {
    /**
     * Algorithm: Recursively traverse the tree. For each node, swap its left and right children.
     * The base case is when a node is null, in which case we return null.
     * The process is: invert left subtree, invert right subtree, then swap the (now inverted) children.
     */
    public TreeNode invertTree(TreeNode root) {
        // Pattern: DFS (Recursive) | Time: O(n), Space: O(h)
        if (root == null) return null;

        // Invert left and right subtrees first
        var leftInverted = invertTree(root.left);
        var rightInverted = invertTree(root.right);

        // Then swap the inverted subtrees
        root.left = rightInverted;
        root.right = leftInverted;

        return root;
    }
    // FAANG Tip: Mention that O(h) space is due to the recursion stack, where h is height of the tree. This is a classic recursive tree problem.

    // Helper to print tree in-order for verification
    private static void printInorder(TreeNode node, Consumer<Integer> printer) {
        if (node == null) return;
        printInorder(node.left, printer);
        printer.accept(node.value);
        printInorder(node.right, printer);
    }

    public static void main(String[] args) {
        var sol = new InvertBinaryTree();

        // Test Case 1: Example Tree
        // Original:
        //      4
        //     / \
        //    2   7
        //   / \ / \
        //  1  3 6  9
        // Inverted:
        //      4
        //     / \
        //    7   2
        //   / \ / \
        //  9  6 3  1
        TreeNode root1 = new TreeNode(4);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(7);
        root1.left.left = new TreeNode(1);
        root1.left.right = new TreeNode(3);
        root1.right.left = new TreeNode(6);
        root1.right.right = new TreeNode(9);

        System.out.print("Test Case 1 Original Inorder: ");
        printInorder(root1, val -> System.out.print(val + " ")); // Expected: 1 2 3 4 6 7 9
        System.out.println();
        TreeNode inverted1 = sol.invertTree(root1);
        System.out.print("Test Case 1 Inverted Inorder: ");
        printInorder(inverted1, val -> System.out.print(val + " ")); // Expected: 9 7 6 4 3 2 1
        System.out.println();

        // Test Case 2: Single Node
        TreeNode root2 = new TreeNode(1);
        System.out.print("Test Case 2 Original Inorder: ");
        printInorder(root2, val -> System.out.print(val + " ")); // Expected: 1
        System.out.println();
        TreeNode inverted2 = sol.invertTree(root2);
        System.out.print("Test Case 2 Inverted Inorder: ");
        printInorder(inverted2, val -> System.out.print(val + " ")); // Expected: 1
        System.out.println();

        // Test Case 3: Empty Tree
        System.out.print("Test Case 3 Original Inorder: ");
        printInorder(null, val -> System.out.print(val + " ")); // Expected: (empty line)
        System.out.println();
        TreeNode inverted3 = sol.invertTree(null);
        System.out.print("Test Case 3 Inverted Inorder: ");
        printInorder(inverted3, val -> System.out.print(val + " ")); // Expected: (empty line)
        System.out.println();
    }
}

/**
 * Dry Run:
 * Input: root = [4,2,7,1,3,6,9] (Tree from Test Case 1)
 *
 * 1. Call invertTree(root=4)
 *
 * 2. invertTree(node=4):
 *    - leftInverted = invertTree(node=2)
 *      - invertTree(node=2):
 *        - leftInverted = invertTree(node=1)
 *          - invertTree(node=1):
 *            - leftInverted = invertTree(null) -> null
 *            - rightInverted = invertTree(null) -> null
 *            - node.left = null, node.right = null
 *            - Returns TreeNode(1)
 *        - leftInverted = TreeNode(1)
 *        - rightInverted = invertTree(node=3)
 *          - invertTree(node=3):
 *            - leftInverted = invertTree(null) -> null
 *            - rightInverted = invertTree(null) -> null
 *            - node.left = null, node.right = null
 *            - Returns TreeNode(3)
 *        - rightInverted = TreeNode(3)
 *        - node.left (2.left) = rightInverted (3)
 *        - node.right (2.right) = leftInverted (1)
 *        - Returns TreeNode(2) with left=3, right=1
 *    - leftInverted = TreeNode(2) with left=3, right=1
 *
 *    - rightInverted = invertTree(node=7)
 *      - invertTree(node=7):
 *        - leftInverted = invertTree(node=6)
 *          - invertTree(node=6):
 *            - leftInverted = invertTree(null) -> null
 *            - rightInverted = invertTree(null) -> null
 *            - node.left = null, node.right = null
 *            - Returns TreeNode(6)
 *        - leftInverted = TreeNode(6)
 *        - rightInverted = invertTree(node=9)
 *          - invertTree(node=9):
 *            - leftInverted = invertTree(null) -> null
 *            - rightInverted = invertTree(null) -> null
 *            - node.left = null, node.right = null
 *            - Returns TreeNode(9)
 *        - rightInverted = TreeNode(9)
 *        - node.left (7.left) = rightInverted (9)
 *        - node.right (7.right) = leftInverted (6)
 *        - Returns TreeNode(7) with left=9, right=6
 *    - rightInverted = TreeNode(7) with left=9, right=6
 *
 *    - node.left (4.left) = rightInverted (7)
 *    - node.right (4.right) = leftInverted (2)
 *    - Returns TreeNode(4) with left=7, right=2
 *
 * Final Result: Inverted Tree (Inorder: 9 7 6 4 3 2 1)
 */
