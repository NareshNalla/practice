package com.naresh.a_dsalgo.tree.problems;

import com.naresh.a_dsalgo.tree.implementation.TreeNode;

/**
 * Problem: Lowest Common Ancestor of a BST
 * Description: Find the lowest common ancestor (LCA) node of two given nodes p and q in a BST.
 */
public class LowestCommonAncestorOfABST {
    /**
     * Algorithm: Traverse from root. If both p and q are smaller than curr, move left. If both are larger, move right.
     * Otherwise, curr is the split point (LCA).
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Pattern: BST Traversal | Time: O(h), Space: O(1)
        var curr = root;
        while (curr != null) {
            if (p.value < curr.value && q.value < curr.value) curr = curr.left;
            else if (p.value > curr.value && q.value > curr.value) curr = curr.right;
            else return curr; // LCA found
        }
        return null;
    }
    // FAANG Tip: Leverage BST properties for O(h) time and O(1) space (iterative). Mention this works because of sorted property.
}
