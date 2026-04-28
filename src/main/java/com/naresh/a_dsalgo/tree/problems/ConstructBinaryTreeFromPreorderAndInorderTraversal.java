package com.naresh.a_dsalgo.tree.problems;

import com.naresh.a_dsalgo.tree.implementation.TreeNode;
import java.util.HashMap;
import java.util.Map;

/**
 * Problem: Construct Binary Tree from Preorder and Inorder Traversal
 * Description: Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    private int preIdx = 0;
    private Map<Integer, Integer> inMap;

    /**
     * Algorithm: Preorder's first element is root. Find it in Inorder to split into left and right subtrees.
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Pattern: Recursive Construction | Time: O(n), Space: O(n)
        inMap = HashMap.newHashMap(inorder.length); // Java 19+
        for (int i = 0; i < inorder.length; i++) inMap.put(inorder[i], i); // Fast lookups
        return build(preorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int left, int right) {
        if (left > right) return null;
        var rootVal = preorder[preIdx++];
        var root = new TreeNode(rootVal);
        var mid = inMap.get(rootVal);

        root.left = build(preorder, left, mid - 1); // Sub-range left of mid
        root.right = build(preorder, mid + 1, right); // Sub-range right of mid
        return root;
    }
    // FAANG Tip: Use a HashMap for O(1) inorder index lookups to achieve overall O(n) time complexity.
}
