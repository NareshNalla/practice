package com.naresh.a_dsalgo.tree.problems;

import com.naresh.a_dsalgo.tree.implementation.TreeNode;

/**
 * Problem: Validate Binary Search Tree
 * Description: Determine if a binary tree is a valid binary search tree (BST).
 * A valid BST is defined as follows:
 * - The left subtree of a node contains only nodes with values less than the node's value.
 * - The right subtree of a node contains only nodes with values greater than the node's value.
 * - Both the left and right subtrees must also be binary search trees.
 */
public class ValidateBinarySearchTree {
    /**
     * Algorithm: Recursively validate each node by ensuring its value falls within a specific range [min, max].
     * For the left child, the upper bound (max) becomes the parent's value.
     * For the right child, the lower bound (min) becomes the parent's value.
     * Initial call uses null for min and max, representing unbounded range.
     */
    public boolean isValidBST(TreeNode root) {
        // Pattern: DFS (Range Validation) | Time: O(n), Space: O(h)
        return validate(root, null, null);
    }
    private boolean validate(TreeNode node, Integer min, Integer max) {
        if (node == null) return true; // An empty tree is a valid BST
        // Check if current node's value violates the min/max constraints
        if ((min != null && node.value <= min) || (max != null && node.value >= max)) {
            return false;
        }
        // Recursively validate left and right subtrees with updated constraints
        // For left child: value must be < node.value (so node.value becomes new max)
        // For right child: value must be > node.value (so node.value becomes new min)
        return validate(node.left, min, node.value) && validate(node.right, node.value, max);
    }
    // FAANG Tip: Use Integer objects or Long.MIN_VALUE/MAX_VALUE for min/max bounds to handle tree values equal to Integer extremes. Iterative in-order traversal is another valid O(N) approach.

    public static void main(String[] args) {
        var sol = new ValidateBinarySearchTree();

        // Test Case 1: Valid BST
        //      2
        //     / \
        //    1   3
        TreeNode root1 = new TreeNode(2);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(3);
        System.out.println("Test Case 1 (Valid BST): " + sol.isValidBST(root1)); // Expected: true

        // Test Case 2: Invalid BST (right child of 5 is 4, which is not > 5)
        //      5
        //     / \
        //    1   4
        //       / \
        //      3   6
        TreeNode root2 = new TreeNode(5);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(4);
        root2.right.left = new TreeNode(3);
        root2.right.right = new TreeNode(6);
        System.out.println("Test Case 2 (Invalid BST): " + sol.isValidBST(root2)); // Expected: false

        // Test Case 3: Single Node
        TreeNode root3 = new TreeNode(0);
        System.out.println("Test Case 3 (Single Node): " + sol.isValidBST(root3)); // Expected: true

        // Test Case 4: Empty Tree
        System.out.println("Test Case 4 (Empty Tree): " + sol.isValidBST(null)); // Expected: true

        // Test Case 5: Invalid BST (left child of 2 is 3, which is not < 2)
        //      2
        //     / \
        //    3   1
        TreeNode root5 = new TreeNode(2);
        root5.left = new TreeNode(3);
        root5.right = new TreeNode(1);
        System.out.println("Test Case 5 (Invalid BST): " + sol.isValidBST(root5)); // Expected: false
    }
}

/**
 * Dry Run:
 * Input: root = [5,1,4,null,null,3,6] (Invalid BST from Test Case 2)
 *
 * 1. Call isValidBST(root=5) -> calls validate(node=5, min=null, max=null)
 *
 * 2. validate(node=5, min=null, max=null):
 *    - node is not null.
 *    - (min != null && 5 <= min) is false. (max != null && 5 >= max) is false. No violation.
 *    - Calls validate(node.left=1, min=null, max=5) AND validate(node.right=4, min=5, max=null)
 *
 * 3. validate(node=1, min=null, max=5):
 *    - node is not null.
 *    - (min != null && 1 <= min) is false. (max != null && 1 >= 5) is false. No violation.
 *    - Calls validate(node.left=null, min=null, max=1) AND validate(node.right=null, min=1, max=5)
 *      - validate(node=null, ...) -> returns true
 *      - validate(node=null, ...) -> returns true
 *    - Returns true && true -> true
 *
 * 4. Back to validate(node=5, min=null, max=null):
 *    - The left part of the AND (validate(node.left=1, ...)) returned true.
 *    - Now calls validate(node.right=4, min=5, max=null)
 *
 * 5. validate(node=4, min=5, max=null):
 *    - node is not null.
 *    - (min != null && 4 <= 5) is true. (4 is not <= 5, it should be > 5 for right child of 5).
 *      - Correction: The condition is `node.value <= min`. Here `node.value` is 4 and `min` is 5. So `4 <= 5` is true. This means the node's value (4) is NOT greater than the minimum allowed value (5), which is a violation.
 *    - Returns false.
 *
 * 6. Back to validate(node=5, min=null, max=null):
 *    - The right part of the AND (validate(node.right=4, ...)) returned false.
 *    - The entire expression `true && false` returns false.
 *
 * Final Result: false
 */
