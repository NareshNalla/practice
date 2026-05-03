package com.naresh.a_dsalgo.tree.problems;

import com.naresh.a_dsalgo.tree.implementation.TreeNode;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer; // For printTree helper

/**
 * Problem: Construct Binary Tree from Preorder and Inorder Traversal
 * Description: Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    private int preIdx = 0; // Pointer for current element in preorder array
    private Map<Integer, Integer> inMap; // Stores value -> index mapping for inorder array

    /**
     * Algorithm: The first element in preorder traversal is always the root. Find this root in the inorder traversal
     * to determine the boundaries of its left and right subtrees. Recursively build the left and right subtrees.
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Pattern: Recursive Construction | Time: O(n), Space: O(n)
        preIdx = 0; // Reset preIdx for each call
        inMap = new HashMap<>(); // Use new HashMap() for broader Java compatibility
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i); // Populate map for O(1) inorder index lookups
        }
        return build(preorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int inStart, int inEnd) {
        // Base case: if the inorder segment is invalid, return null
        if (inStart > inEnd) return null;

        // The current root's value is at preIdx in the preorder array
        var rootVal = preorder[preIdx++];
        var root = new TreeNode(rootVal);

        // Find the root's index in the inorder array
        var rootInorderIndex = inMap.get(rootVal);

        // Recursively build the left subtree using the left segment of inorder
        root.left = build(preorder, inStart, rootInorderIndex - 1);
        // Recursively build the right subtree using the right segment of inorder
        root.right = build(preorder, rootInorderIndex + 1, inEnd);

        return root;
    }
    // FAANG Tip: Using a HashMap for O(1) inorder index lookups is crucial to achieve overall O(n) time complexity. Without it, finding the root in inorder would be O(n) for each node, leading to O(n^2).

    // Helper to print tree in-order for verification
    private static void printInorder(TreeNode node, Consumer<Integer> printer) {
        if (node == null) return;
        printInorder(node.left, printer);
        printer.accept(node.value);
        printInorder(node.right, printer);
    }

    public static void main(String[] args) {
        var sol = new ConstructBinaryTreeFromPreorderAndInorderTraversal();

        // Test Case 1: Example Tree
        // Preorder: [3, 9, 20, 15, 7]
        // Inorder:  [9, 3, 15, 20, 7]
        // Expected Tree:
        //      3
        //     / \
        //    9  20
        //      /  \
        //     15   7
        int[] preorder1 = {3, 9, 20, 15, 7};
        int[] inorder1 = {9, 3, 15, 20, 7};
        TreeNode tree1 = sol.buildTree(preorder1, inorder1);
        System.out.print("Test Case 1 (Inorder Traversal): ");
        printInorder(tree1, val -> System.out.print(val + " ")); // Expected: 9 3 15 20 7
        System.out.println();

        // Test Case 2: Single Node
        int[] preorder2 = {1};
        int[] inorder2 = {1};
        TreeNode tree2 = sol.buildTree(preorder2, inorder2);
        System.out.print("Test Case 2 (Inorder Traversal): ");
        printInorder(tree2, val -> System.out.print(val + " ")); // Expected: 1
        System.out.println();

        // Test Case 3: Left Skewed
        // Preorder: [1, 2, 3]
        // Inorder:  [3, 2, 1]
        // Expected Tree:
        //        1
        //       /
        //      2
        //     /
        //    3
        int[] preorder3 = {1, 2, 3};
        int[] inorder3 = {3, 2, 1};
        TreeNode tree3 = sol.buildTree(preorder3, inorder3);
        System.out.print("Test Case 3 (Inorder Traversal): ");
        printInorder(tree3, val -> System.out.print(val + " ")); // Expected: 3 2 1
        System.out.println();
    }
}

/**
 * Dry Run:
 * Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 *
 * 1. Initialization (buildTree method):
 *    - preIdx = 0
 *    - inMap = {9:0, 3:1, 15:2, 20:3, 7:4}
 *    - Calls build(preorder, inStart=0, inEnd=4)
 *
 * 2. build(preorder, inStart=0, inEnd=4): (Building root 3)
 *    - inStart (0) <= inEnd (4) is true.
 *    - rootVal = preorder[preIdx++] = preorder[0] = 3. preIdx = 1.
 *    - root = new TreeNode(3)
 *    - rootInorderIndex = inMap.get(3) = 1
 *    - root.left = build(preorder, inStart=0, inEnd=0)
 *      - build(preorder, inStart=0, inEnd=0): (Building root 9)
 *        - inStart (0) <= inEnd (0) is true.
 *        - rootVal = preorder[preIdx++] = preorder[1] = 9. preIdx = 2.
 *        - root = new TreeNode(9)
 *        - rootInorderIndex = inMap.get(9) = 0
 *        - root.left = build(preorder, inStart=0, inEnd=-1) -> returns null
 *        - root.right = build(preorder, inStart=1, inEnd=0) -> returns null
 *        - Returns TreeNode(9)
 *    - root.left = TreeNode(9)
 *    - root.right = build(preorder, inStart=2, inEnd=4)
 *      - build(preorder, inStart=2, inEnd=4): (Building root 20)
 *        - inStart (2) <= inEnd (4) is true.
 *        - rootVal = preorder[preIdx++] = preorder[2] = 20. preIdx = 3.
 *        - root = new TreeNode(20)
 *        - rootInorderIndex = inMap.get(20) = 3
 *        - root.left = build(preorder, inStart=2, inEnd=2)
 *          - build(preorder, inStart=2, inEnd=2): (Building root 15)
 *            - inStart (2) <= inEnd (2) is true.
 *            - rootVal = preorder[preIdx++] = preorder[3] = 15. preIdx = 4.
 *            - root = new TreeNode(15)
 *            - rootInorderIndex = inMap.get(15) = 2
 *            - root.left = build(preorder, inStart=2, inEnd=1) -> returns null
 *            - root.right = build(preorder, inStart=3, inEnd=2) -> returns null
 *            - Returns TreeNode(15)
 *        - root.left = TreeNode(15)
 *        - root.right = build(preorder, inStart=4, inEnd=4)
 *          - build(preorder, inStart=4, inEnd=4): (Building root 7)
 *            - inStart (4) <= inEnd (4) is true.
 *            - rootVal = preorder[preIdx++] = preorder[4] = 7. preIdx = 5.
 *            - root = new TreeNode(7)
 *            - rootInorderIndex = inMap.get(7) = 4
 *            - root.left = build(preorder, inStart=4, inEnd=3) -> returns null
 *            - root.right = build(preorder, inStart=5, inEnd=4) -> returns null
 *            - Returns TreeNode(7)
 *        - root.right = TreeNode(7)
 *        - Returns TreeNode(20) with left=15, right=7
 *    - root.right = TreeNode(20)
 *    - Returns TreeNode(3) with left=9, right=20
 *
 * Final Result: Tree constructed successfully. Inorder traversal: 9 3 15 20 7
 */
