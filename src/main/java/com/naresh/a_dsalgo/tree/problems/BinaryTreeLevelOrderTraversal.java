package com.naresh.a_dsalgo.tree.problems;

import com.naresh.a_dsalgo.tree.implementation.TreeNode;
import java.util.*;

/**
 * Problem: Binary Tree Level Order Traversal
 * Description: Return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
 */
public class BinaryTreeLevelOrderTraversal {
    /**
     * Algorithm: Use a queue for BFS. Process nodes level by level, adding children to the queue.
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        // Pattern: BFS | Time: O(n), Space: O(n)
        var res = new ArrayList<List<Integer>>();
        if (root == null) return res;
        var q = new ArrayDeque<TreeNode>();
        q.offer(root);
        while (!q.isEmpty()) {
            var size = q.size();
            var level = new ArrayList<Integer>(size);
            for (int i = 0; i < size; i++) {
                var node = q.poll();
                level.add(node.value);
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }
            res.add(level);
        }
        return res;
    }
    // FAANG Tip: ArrayDeque is faster than LinkedList for queues. Mention O(n) space for the widest level of the tree.
}
