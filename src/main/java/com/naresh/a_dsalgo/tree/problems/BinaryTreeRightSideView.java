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
     */
    public List<Integer> rightSideView(TreeNode root) {
        // Pattern: DFS (Root-Right-Left) | Time: O(n), Space: O(h)
        var res = new ArrayList<Integer>();
        dfs(root, 0, res);
        return res;
    }

    private void dfs(TreeNode node, int depth, List<Integer> res) {
        if (node == null) return;
        if (depth == res.size()) res.add(node.value); // First node at this depth
        dfs(node.right, depth + 1, res); // Prioritize right
        dfs(node.left, depth + 1, res);
    }
    // FAANG Tip: DFS (Root-Right-Left) is more memory efficient than BFS for this problem (O(h) vs O(w)).
}
