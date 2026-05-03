package com.naresh.a_dsalgo.tree.problems;

import com.naresh.a_dsalgo.tree.implementation.TreeNode;

/**
 * Problem: Lowest Common Ancestor of a BST
 * Description: Find the lowest common ancestor (LCA) node of two given nodes p and q in a BST.
 * The LCA is defined as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).
 */
public class LowestCommonAncestorOfABST {
    /**
     * Algorithm: Leverage the BST property. Start from the root.
     * If both p and q are smaller than the current node, then the LCA must be in the left subtree.
     * If both p and q are larger than the current node, then the LCA must be in the right subtree.
     * Otherwise (one is smaller, one is larger, or one is equal to the current node), the current node is the LCA.
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Pattern: BST Traversal | Time: O(h), Space: O(1)
        var curr = root;
        while (curr != null) {
            if (p.value < curr.value && q.value < curr.value) {
                curr = curr.left; // Both p and q are in the left subtree
            } else if (p.value > curr.value && q.value > curr.value) {
                curr = curr.right; // Both p and q are in the right subtree
            } else {
                return curr; // Current node is the split point or one of p/q
            }
        }
        return null; // Should not be reached if p and q are guaranteed to be in the BST
    }
    // FAANG Tip: Leverage BST properties for O(h) time and O(1) space (iterative). Mention this works because of sorted property.

    public static void main(String[] args) {
        var sol = new LowestCommonAncestorOfABST();

        // Test Case 1: Example BST
        //        6
        //       / \
        //      2   8
        //     / \ / \
        //    0  4 7  9
        //      / \
        //     3   5
        TreeNode root1 = new TreeNode(6);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(8);
        root1.left.left = new TreeNode(0);
        root1.left.right = new TreeNode(4);
        root1.right.left = new TreeNode(7);
        root1.right.right = new TreeNode(9);
        root1.left.right.left = new TreeNode(3);
        root1.left.right.right = new TreeNode(5);

        // LCA(2, 8) -> 6
        System.out.println("LCA(2, 8): " + sol.lowestCommonAncestor(root1, root1.left, root1.right).value); // Expected: 6
        // LCA(2, 4) -> 2
        System.out.println("LCA(2, 4): " + sol.lowestCommonAncestor(root1, root1.left, root1.left.right).value); // Expected: 2
        // LCA(3, 5) -> 4
        System.out.println("LCA(3, 5): " + sol.lowestCommonAncestor(root1, root1.left.right.left, root1.left.right.right).value); // Expected: 4
        // LCA(0, 5) -> 2
        System.out.println("LCA(0, 5): " + sol.lowestCommonAncestor(root1, root1.left.left, root1.left.right.right).value); // Expected: 2
    }
}

/**
 * Dry Run:
 * Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8 (Test Case 1, first example)
 *
 * 1. Initialization:
 *    curr = root (6)
 *    p = TreeNode(2), q = TreeNode(8)
 *
 * 2. Loop Iteration 1 (curr = 6):
 *    - p.value (2) < curr.value (6) is true.
 *    - q.value (8) < curr.value (6) is false.
 *    - p.value (2) > curr.value (6) is false.
 *    - Else branch: One is smaller, one is larger.
 *    - Return curr (6).
 *
 * Final Result: 6
 *
 * Dry Run:
 * Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 0, q = 5 (Test Case 1, fourth example)
 *
 * 1. Initialization:
 *    curr = root (6)
 *    p = TreeNode(0), q = TreeNode(5)
 *
 * 2. Loop Iteration 1 (curr = 6):
 *    - p.value (0) < curr.value (6) is true.
 *    - q.value (5) < curr.value (6) is true.
 *    - Both are smaller. curr = curr.left (2).
 *
 * 3. Loop Iteration 2 (curr = 2):
 *    - p.value (0) < curr.value (2) is true.
 *    - q.value (5) < curr.value (2) is false.
 *    - p.value (0) > curr.value (2) is false.
 *    - Else branch: One is smaller, one is larger.
 *    - Return curr (2).
 *
 * Final Result: 2
 */
