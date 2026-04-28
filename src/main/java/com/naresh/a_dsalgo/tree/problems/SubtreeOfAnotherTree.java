package com.naresh.a_dsalgo.tree.problems;

import com.naresh.a_dsalgo.tree.implementation.TreeNode;

/**
 * Problem: Subtree of Another Tree
 * Description: Check if a tree 'subRoot' is a subtree of tree 'root'.
 */
public class SubtreeOfAnotherTree {
    /**
     * Algorithm: Traverse 'root' and for each node, check if it matches 'subRoot' using a helper isSameTree.
     */
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        // Pattern: Recursive Comparison | Time: O(n*m), Space: O(h)
        if (root == null) return false;
        if (isSame(root, subRoot)) return true; // Found match
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean isSame(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null || p.value != q.value) return false;
        return isSame(p.left, q.left) && isSame(p.right, q.right);
    }
    // FAANG Tip: Mention that this can be optimized to O(n+m) using string serialization or tree hashing (Merkle Tree).
}
