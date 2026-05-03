package com.naresh.a_dsalgo.tree.problems;

import com.naresh.a_dsalgo.tree.implementation.TreeNode;
import java.util.*;
import java.util.function.Consumer; // For printTree helper

/**
 * Problem: Serialize and Deserialize Binary Tree
 * Description: Design an algorithm to serialize and deserialize a binary tree.
 * The algorithm should convert a tree to a string and reconstruct the tree from the string.
 */
public class SerializeAndDeserializeBinaryTree {
    /**
     * Algorithm (Serialization): Use pre-order DFS traversal. Append node values to a string,
     * separating them with commas. Use a special marker (e.g., "null") for null nodes to
     * preserve the tree structure.
     */
    public String serialize(TreeNode root) {
        // Pattern: Pre-order DFS | Time: O(n), Space: O(n)
        if (root == null) return "null";
        var sb = new StringBuilder();
        serializeHelper(root, sb);
        return sb.substring(0, sb.length() - 1); // Remove trailing comma
    }

    private void serializeHelper(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("null").append(",");
            return;
        }
        sb.append(node.value).append(",");
        serializeHelper(node.left, sb);
        serializeHelper(node.right, sb);
    }

    /**
     * Algorithm (Deserialization): Use a Queue to process the serialized string (split by comma).
     * Since it's pre-order, the first element is the root. Recursively build left and right children.
     * If "null" is encountered, return null.
     */
    public TreeNode deserialize(String data) {
        // Pattern: Recursive Reconstruction | Time: O(n), Space: O(n)
        var nodes = new ArrayDeque<>(Arrays.asList(data.split(",")));
        return deserializeHelper(nodes);
    }

    private TreeNode deserializeHelper(Queue<String> nodes) {
        var val = nodes.poll();
        if (val.equals("null")) return null;
        var node = new TreeNode(Integer.parseInt(val));
        node.left = deserializeHelper(nodes);
        node.right = deserializeHelper(nodes);
        return node;
    }
    // FAANG Tip: Pre-order is ideal for serialization as the root comes first. Using StringBuilder for serialization is more efficient than string concatenation.

    // Helper to print tree in-order for verification
    private static void printInorder(TreeNode node, Consumer<Integer> printer) {
        if (node == null) return;
        printInorder(node.left, printer);
        printer.accept(node.value);
        printInorder(node.right, printer);
    }

    public static void main(String[] args) {
        var sol = new SerializeAndDeserializeBinaryTree();

        // Test Case 1: Example Tree
        //      1
        //     / \
        //    2   3
        //       / \
        //      4   5
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.right.left = new TreeNode(4);
        root1.right.right = new TreeNode(5);

        String serialized1 = sol.serialize(root1);
        System.out.println("Test Case 1 Serialized: " + serialized1); // Expected: 1,2,null,null,3,4,null,null,5,null,null
        TreeNode deserialized1 = sol.deserialize(serialized1);
        System.out.print("Test Case 1 Deserialized Inorder: ");
        printInorder(deserialized1, val -> System.out.print(val + " ")); // Expected: 2 1 4 3 5
        System.out.println();

        // Test Case 2: Single Node
        TreeNode root2 = new TreeNode(1);
        String serialized2 = sol.serialize(root2);
        System.out.println("Test Case 2 Serialized: " + serialized2); // Expected: 1,null,null
        TreeNode deserialized2 = sol.deserialize(serialized2);
        System.out.print("Test Case 2 Deserialized Inorder: ");
        printInorder(deserialized2, val -> System.out.print(val + " ")); // Expected: 1
        System.out.println();

        // Test Case 3: Empty Tree
        String serialized3 = sol.serialize(null);
        System.out.println("Test Case 3 Serialized: " + serialized3); // Expected: null
        TreeNode deserialized3 = sol.deserialize(serialized3);
        System.out.print("Test Case 3 Deserialized Inorder: ");
        printInorder(deserialized3, val -> System.out.print(val + " ")); // Expected: (empty line)
        System.out.println();
    }
}

/**
 * Dry Run (Serialization):
 * Input: root = [1,2,3,null,null,4,5] (Tree from Test Case 1)
 *
 * 1. Call serialize(root=1) -> calls serializeHelper(node=1, sb=new StringBuilder())
 *
 * 2. serializeHelper(node=1, sb=""):
 *    - sb.append(1).append(",") -> sb="1,"
 *    - serializeHelper(node=2, sb="1,")
 *      - serializeHelper(node=2, sb="1,"):
 *        - sb.append(2).append(",") -> sb="1,2,"
 *        - serializeHelper(node=null, sb="1,2,")
 *          - sb.append("null").append(",") -> sb="1,2,null,"
 *          - Returns
 *        - serializeHelper(node=null, sb="1,2,null,")
 *          - sb.append("null").append(",") -> sb="1,2,null,null,"
 *          - Returns
 *        - Returns
 *    - serializeHelper(node=3, sb="1,2,null,null,")
 *      - serializeHelper(node=3, sb="1,2,null,null,"):
 *        - sb.append(3).append(",") -> sb="1,2,null,null,3,"
 *        - serializeHelper(node=4, sb="1,2,null,null,3,")
 *          - serializeHelper(node=4, sb="1,2,null,null,3,"):
 *            - sb.append(4).append(",") -> sb="1,2,null,null,3,4,"
 *            - serializeHelper(node=null, sb="1,2,null,null,3,4,")
 *              - sb.append("null").append(",") -> sb="1,2,null,null,3,4,null,"
 *              - Returns
 *            - serializeHelper(node=null, sb="1,2,null,null,3,4,null,")
 *              - sb.append("null").append(",") -> sb="1,2,null,null,3,4,null,null,"
 *              - Returns
 *            - Returns
 *        - serializeHelper(node=5, sb="1,2,null,null,3,4,null,null,")
 *          - serializeHelper(node=5, sb="1,2,null,null,3,4,null,null,"):
 *            - sb.append(5).append(",") -> sb="1,2,null,null,3,4,null,null,5,"
 *            - serializeHelper(node=null, sb="1,2,null,null,3,4,null,null,5,")
 *              - sb.append("null").append(",") -> sb="1,2,null,null,3,4,null,null,5,null,"
 *              - Returns
 *            - serializeHelper(node=null, sb="1,2,null,null,3,4,null,null,5,null,")
 *              - sb.append("null").append(",") -> sb="1,2,null,null,3,4,null,null,5,null,null,"
 *              - Returns
 *            - Returns
 *        - Returns
 *    - Returns
 *
 * 3. Final step in serialize: sb.substring(0, sb.length() - 1)
 *    - Removes the last comma.
 *
 * Final Serialized String: "1,2,null,null,3,4,null,null,5,null,null"
 *
 * Dry Run (Deserialization):
 * Input: data = "1,2,null,null,3,4,null,null,5,null,null"
 *
 * 1. Call deserialize(data)
 *    - nodes = ["1", "2", "null", "null", "3", "4", "null", "null", "5", "null", "null"] (ArrayDeque)
 *    - Calls deserializeHelper(nodes)
 *
 * 2. deserializeHelper(nodes):
 *    - val = nodes.poll() -> "1". nodes=["2", "null", ...]
 *    - node = new TreeNode(1)
 *    - node.left = deserializeHelper(nodes)
 *      - deserializeHelper(nodes):
 *        - val = nodes.poll() -> "2". nodes=["null", "null", ...]
 *        - node = new TreeNode(2)
 *        - node.left = deserializeHelper(nodes)
 *          - deserializeHelper(nodes):
 *            - val = nodes.poll() -> "null". nodes=["null", ...]
 *            - Returns null
 *          - node.left = null
 *        - node.right = deserializeHelper(nodes)
 *          - deserializeHelper(nodes):
 *            - val = nodes.poll() -> "null". nodes=["3", ...]
 *            - Returns null
 *          - node.right = null
 *        - Returns TreeNode(2)
 *      - node.left = TreeNode(2)
 *    - node.right = deserializeHelper(nodes)
 *      - deserializeHelper(nodes):
 *        - val = nodes.poll() -> "3". nodes=["4", ...]
 *        - node = new TreeNode(3)
 *        - node.left = deserializeHelper(nodes)
 *          - deserializeHelper(nodes):
 *            - val = nodes.poll() -> "4". nodes=["null", ...]
 *            - node = new TreeNode(4)
 *            - node.left = deserializeHelper(nodes)
 *              - deserializeHelper(nodes):
 *                - val = nodes.poll() -> "null". nodes=["null", ...]
 *                - Returns null
 *              - node.left = null
 *            - node.right = deserializeHelper(nodes)
 *              - deserializeHelper(nodes):
 *                - val = nodes.poll() -> "null". nodes=["5", ...]
 *                - Returns null
 *              - node.right = null
 *            - Returns TreeNode(4)
 *          - node.left = TreeNode(4)
 *        - node.right = deserializeHelper(nodes)
 *          - deserializeHelper(nodes):
 *            - val = nodes.poll() -> "5". nodes=["null", ...]
 *            - node = new TreeNode(5)
 *            - node.left = deserializeHelper(nodes)
 *              - deserializeHelper(nodes):
 *                - val = nodes.poll() -> "null". nodes=["null", ...]
 *                - Returns null
 *              - node.left = null
 *            - node.right = deserializeHelper(nodes)
 *              - deserializeHelper(nodes):
 *                - val = nodes.poll() -> "null". nodes=[]
 *                - Returns null
 *              - node.right = null
 *            - Returns TreeNode(5)
 *          - node.right = TreeNode(5)
 *        - Returns TreeNode(3)
 *      - node.right = TreeNode(3)
 *    - Returns TreeNode(1)
 *
 * Final Deserialized Tree: Reconstructed tree matching the input.
 */
