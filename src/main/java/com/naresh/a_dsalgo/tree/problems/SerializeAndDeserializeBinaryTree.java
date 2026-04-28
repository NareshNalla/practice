package com.naresh.a_dsalgo.tree.problems;

import com.naresh.a_dsalgo.tree.implementation.TreeNode;
import java.util.*;

/**
 * Problem: Serialize and Deserialize Binary Tree
 * Description: Design an algorithm to serialize and deserialize a binary tree.
 */
public class SerializeAndDeserializeBinaryTree {
    /**
     * Algorithm: Use pre-order traversal with "null" markers for serialization. Use a Queue for reconstruction.
     */
    public String serialize(TreeNode root) {
        // Pattern: Pre-order DFS | Time: O(n), Space: O(n)
        if (root == null) return "null";
        return root.value + "," + serialize(root.left) + "," + serialize(root.right);
    }

    public TreeNode deserialize(String data) {
        // Pattern: Recursive Reconstruction | Time: O(n), Space: O(n)
        var queue = new ArrayDeque<>(Arrays.asList(data.split(",")));
        return build(queue);
    }

    private TreeNode build(Queue<String> q) {
        var val = q.poll();
        if (val.equals("null")) return null;
        var node = new TreeNode(Integer.parseInt(val));
        node.left = build(q);
        node.right = build(q);
        return node;
    }
    // FAANG Tip: Pre-order is ideal for serialization as the root comes first. Use StringBuilder for better performance in iterative versions.
}
