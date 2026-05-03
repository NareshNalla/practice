package com.naresh.a_dsalgo.tree.problems;

import com.naresh.a_dsalgo.tree.implementation.TreeNode;

/**
 * Problem: Count Good Nodes in Binary Tree
 * Description: A node X is "good" if in the path from root to X, there are no nodes with a value greater than X.
 */
public class CountGoodNodesInBinaryTree {
    /**
     * Algorithm: Perform a DFS traversal. For each node, pass down the maximum value encountered so far on the path
     * from the root to the current node. If the current node's value is greater than or equal to this maximum,
     * it's a "good" node, and we increment the count. Update the maximum value for subsequent recursive calls.
     */
    public int goodNodes(TreeNode root) {
        // Pattern: DFS (Path Tracking) | Time: O(n), Space: O(h)
        return dfs(root, Integer.MIN_VALUE); // Start with smallest possible max value
    }

    private int dfs(TreeNode node, int maxVal) {
        if (node == null) return 0;

        int count = 0;
        if (node.value >= maxVal) { // Current node is good
            count = 1;
            maxVal = node.value; // Update max value for children
        }

        // Recursively count good nodes in left and right subtrees
        count += dfs(node.left, maxVal);
        count += dfs(node.right, maxVal);

        return count;
    }
    // FAANG Tip: Passing state (maxVal) down the recursion stack avoids global variables and simplifies logic. This is a common pattern for path-dependent properties.

    public static void main(String[] args) {
        var sol = new CountGoodNodesInBinaryTree();

        // Test Case 1: Example 1
        //      3
        //     / \
        //    1   4
        //   /   / \
        //  3   1   5
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(1);
        root1.left.left = new TreeNode(3);
        root1.right = new TreeNode(4);
        root1.right.left = new TreeNode(1);
        root1.right.right = new TreeNode(5);
        System.out.println("Test Case 1: " + sol.goodNodes(root1)); // Expected: 4 (3, 4, 5, 3)

        // Test Case 2: Example 2
        //      3
        //       \
        //        3
        //       /
        //      4
        TreeNode root2 = new TreeNode(3);
        root2.right = new TreeNode(3);
        root2.right.left = new TreeNode(4);
        System.out.println("Test Case 2: " + sol.goodNodes(root2)); // Expected: 3 (3, 3, 4)

        // Test Case 3: Single Node
        TreeNode root3 = new TreeNode(1);
        System.out.println("Test Case 3: " + sol.goodNodes(root3)); // Expected: 1

        // Test Case 4: Empty Tree
        System.out.println("Test Case 4: " + sol.goodNodes(null)); // Expected: 0
    }
}

/**
 * Dry Run:
 * Input: root = [3,1,4,3,null,1,5] (Tree from Test Case 1)
 *
 * 1. Call goodNodes(root=3) -> calls dfs(node=3, maxVal=Integer.MIN_VALUE)
 *
 * 2. dfs(node=3, maxVal=MIN_VALUE):
 *    - node.value (3) >= maxVal (MIN_VALUE). count = 1. maxVal = 3.
 *    - count += dfs(node=1, maxVal=3)
 *      - dfs(node=1, maxVal=3):
 *        - node.value (1) >= maxVal (3) is false. count = 0. maxVal remains 3.
 *        - count += dfs(node=3, maxVal=3)
 *          - dfs(node=3, maxVal=3):
 *            - node.value (3) >= maxVal (3). count = 1. maxVal = 3.
 *            - count += dfs(null, maxVal=3) -> 0
 *            - count += dfs(null, maxVal=3) -> 0
 *            - Returns 1
 *        - count (0) += 1 -> count = 1
 *        - count += dfs(null, maxVal=3) -> 0
 *        - Returns 1
 *    - count (1) += 1 -> count = 2
 *    - count += dfs(node=4, maxVal=3)
 *      - dfs(node=4, maxVal=3):
 *        - node.value (4) >= maxVal (3). count = 1. maxVal = 4.
 *        - count += dfs(node=1, maxVal=4)
 *          - dfs(node=1, maxVal=4):
 *            - node.value (1) >= maxVal (4) is false. count = 0. maxVal remains 4.
 *            - count += dfs(null, maxVal=4) -> 0
 *            - count += dfs(null, maxVal=4) -> 0
 *            - Returns 0
 *        - count (1) += 0 -> count = 1
 *        - count += dfs(node=5, maxVal=4)
 *          - dfs(node=5, maxVal=4):
 *            - node.value (5) >= maxVal (4). count = 1. maxVal = 5.
 *            - count += dfs(null, maxVal=5) -> 0
 *            - count += dfs(null, maxVal=5) -> 0
 *            - Returns 1
 *        - count (1) += 1 -> count = 2
 *        - Returns 2
 *    - count (2) += 2 -> count = 4
 *    - Returns 4
 *
 * Final Result: 4
 */
