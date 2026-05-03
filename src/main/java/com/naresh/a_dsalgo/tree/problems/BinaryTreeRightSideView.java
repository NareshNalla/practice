package com.naresh.a_dsalgo.tree.problems;

import com.naresh.a_dsalgo.tree.implementation.TreeNode;
import java.util.*;

/**
 * Problem: Binary Tree Right Side View
 * Description: Imagine standing on the right side of a binary tree, return the values of the nodes you can see ordered from top to bottom.
 */
public class BinaryTreeRightSideView {
    /**
     * Algorithm: Perform a modified DFS (Root -> Right -> Left). Track depth and add the first node seen at each level.
     * By prioritizing the right child, the first node encountered at any new depth will always be the rightmost node.
     */
    public List<Integer> rightSideView(TreeNode root) {
        // Pattern: DFS (Root-Right-Left) | Time: O(n), Space: O(h)
        var res = new ArrayList<Integer>();
        dfs(root, 0, res);
        return res;
    }

    private void dfs(TreeNode node, int depth, List<Integer> res) {
        if (node == null) return;

        // If this is the first time we are visiting a node at this depth, it must be the rightmost one
        if (depth == res.size()) {
            res.add(node.value);
        }

        // Traverse right child first to ensure rightmost node is processed first for each level
        dfs(node.right, depth + 1, res);
        dfs(node.left, depth + 1, res);
    }
    // FAANG Tip: DFS (Root-Right-Left) is more memory efficient than BFS for this problem (O(h) vs O(w)). BFS is also a valid approach.

    public static void main(String[] args) {
        var sol = new BinaryTreeRightSideView();

        // Test Case 1: Example Tree
        //      1
        //     / \
        //    2   3
        //     \   \
        //      5   4
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.right = new TreeNode(5);
        root1.right.right = new TreeNode(4);
        System.out.println("Test Case 1: " + sol.rightSideView(root1)); // Expected: [1, 3, 4]

        // Test Case 2: Skewed Left Tree
        //      1
        //     /
        //    2
        //   /
        //  3
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.left.left = new TreeNode(3);
        System.out.println("Test Case 2: " + sol.rightSideView(root2)); // Expected: [1, 2, 3]

        // Test Case 3: Empty Tree
        System.out.println("Test Case 3: " + sol.rightSideView(null)); // Expected: []
    }
}

/**
 * Dry Run:
 * Input: root = [1,2,3,null,5,null,4] (Tree from Test Case 1)
 *
 * 1. Initialization:
 *    res = []
 *    Call rightSideView(root=1) -> calls dfs(node=1, depth=0, res=[])
 *
 * 2. dfs(node=1, depth=0, res=[]):
 *    - node is not null.
 *    - depth (0) == res.size() (0) is true. res.add(1). res = [1]
 *    - Call dfs(node=3, depth=1, res=[1]) (Prioritize right)
 *      - dfs(node=3, depth=1, res=[1]):
 *        - node is not null.
 *        - depth (1) == res.size() (1) is true. res.add(3). res = [1, 3]
 *        - Call dfs(node=4, depth=2, res=[1, 3]) (Prioritize right)
 *          - dfs(node=4, depth=2, res=[1, 3]):
 *            - node is not null.
 *            - depth (2) == res.size() (2) is true. res.add(4). res = [1, 3, 4]
 *            - Call dfs(null, depth=3, res=[1, 3, 4]) -> returns
 *            - Call dfs(null, depth=3, res=[1, 3, 4]) -> returns
 *          - Returns from dfs(node=4)
 *        - Call dfs(null, depth=2, res=[1, 3, 4]) -> returns
 *      - Returns from dfs(node=3)
 *    - Call dfs(node=2, depth=1, res=[1, 3, 4])
 *      - dfs(node=2, depth=1, res=[1, 3, 4]):
 *        - node is not null.
 *        - depth (1) == res.size() (3) is false. (res already has 3 elements)
 *        - Call dfs(node=5, depth=2, res=[1, 3, 4]) (Prioritize right)
 *          - dfs(node=5, depth=2, res=[1, 3, 4]):
 *            - node is not null.
 *            - depth (2) == res.size() (3) is false.
 *            - Call dfs(null, depth=3, res=[1, 3, 4]) -> returns
 *            - Call dfs(null, depth=3, res=[1, 3, 4]) -> returns
 *          - Returns from dfs(node=5)
 *        - Call dfs(null, depth=2, res=[1, 3, 4]) -> returns
 *      - Returns from dfs(node=2)
 *    - Returns from dfs(node=1)
 *
 * Final Result: [1, 3, 4]
 */
