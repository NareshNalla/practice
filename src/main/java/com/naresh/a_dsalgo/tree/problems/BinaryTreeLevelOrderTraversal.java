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
     * For each level, iterate 'size' times (where size is the number of nodes currently in the queue),
     * add node's value to current level list, and enqueue its children.
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

    public static void main(String[] args) {
        var sol = new BinaryTreeLevelOrderTraversal();

        // Test Case 1: Example Tree
        //      3
        //     / \
        //    9  20
        //      /  \
        //     15   7
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(9);
        root1.right = new TreeNode(20);
        root1.right.left = new TreeNode(15);
        root1.right.right = new TreeNode(7);
        System.out.println("Test Case 1: " + sol.levelOrder(root1)); // Expected: [[3], [9, 20], [15, 7]]

        // Test Case 2: Single Node Tree
        TreeNode root2 = new TreeNode(1);
        System.out.println("Test Case 2: " + sol.levelOrder(root2)); // Expected: [[1]]

        // Test Case 3: Empty Tree
        System.out.println("Test Case 3: " + sol.levelOrder(null)); // Expected: []
    }
}

/**
 * Dry Run:
 * Input: root = [3,9,20,null,null,15,7] (Tree from Test Case 1)
 *
 * 1. Initialization:
 *    res = []
 *    q = ArrayDeque (empty)
 *    root = TreeNode(3)
 *
 * 2. Initial Enqueue:
 *    - root is not null. q.offer(root=3).
 *    - q = [3]
 *
 * 3. While loop (q is not empty):
 *    - **Level 0 (root):**
 *      - size = q.size() = 1
 *      - level = []
 *      - i = 0:
 *        - node = q.poll() -> 3. q = []
 *        - level.add(3) -> level = [3]
 *        - node.left (9) is not null. q.offer(9). q = [9]
 *        - node.right (20) is not null. q.offer(20). q = [9, 20]
 *      - res.add(level) -> res = [[3]]
 *
 *    - **Level 1 (children of root):**
 *      - size = q.size() = 2
 *      - level = []
 *      - i = 0:
 *        - node = q.poll() -> 9. q = [20]
 *        - level.add(9) -> level = [9]
 *        - node.left (null), node.right (null). No children enqueued.
 *      - i = 1:
 *        - node = q.poll() -> 20. q = []
 *        - level.add(20) -> level = [9, 20]
 *        - node.left (15) is not null. q.offer(15). q = [15]
 *        - node.right (7) is not null. q.offer(7). q = [15, 7]
 *      - res.add(level) -> res = [[3], [9, 20]]
 *
 *    - **Level 2 (grandchildren of root):**
 *      - size = q.size() = 2
 *      - level = []
 *      - i = 0:
 *        - node = q.poll() -> 15. q = [7]
 *        - level.add(15) -> level = [15]
 *        - node.left (null), node.right (null). No children enqueued.
 *      - i = 1:
 *        - node = q.poll() -> 7. q = []
 *        - level.add(7) -> level = [15, 7]
 *        - node.left (null), node.right (null). No children enqueued.
 *      - res.add(level) -> res = [[3], [9, 20], [15, 7]]
 *
 * 4. While loop (q is empty). Loop ends.
 *
 * 5. Return res.
 *
 * Final Result: [[3], [9, 20], [15, 7]]
 */
