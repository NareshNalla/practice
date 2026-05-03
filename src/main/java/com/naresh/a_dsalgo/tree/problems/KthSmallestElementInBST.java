package com.naresh.a_dsalgo.tree.problems;

import com.naresh.a_dsalgo.tree.implementation.TreeNode;
import java.util.ArrayDeque;
import java.util.Deque; // Prefer Deque interface

/**
 * Problem: Kth Smallest Element in a BST
 * Description: Given the root of a binary search tree and an integer k, return the kth smallest value (1-indexed).
 */
public class KthSmallestElementInBST {
    /**
     * Algorithm: Use iterative in-order traversal (Left-Root-Right). In-order traversal of a BST visits nodes in ascending order.
     * Maintain a stack to simulate recursion. Push left children onto the stack until null, then pop, process, and move to right child.
     * Decrement k for each processed node; when k becomes 0, the current node is the kth smallest.
     */
    public int kthSmallest(TreeNode root, int k) {
        // Pattern: Iterative In-order | Time: O(h + k), Space: O(h)
        var stack = new ArrayDeque<TreeNode>(); // Use Deque as a stack
        var curr = root;

        while (curr != null || !stack.isEmpty()) {
            // Traverse to the leftmost node, pushing all visited nodes onto the stack
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            // Pop the top node (which is the smallest in the current subtree)
            curr = stack.pop();

            // Process the node: decrement k
            if (--k == 0) {
                return curr.value; // Found the kth smallest element
            }

            // Move to the right subtree
            curr = curr.right;
        }
        return -1; // Should not be reached for valid BST and k
    }
    // FAANG Tip: BST properties ensure in-order traversal is sorted. Iterative approach allows early exit and avoids deep recursion stack overflow for skewed trees.

    public static void main(String[] args) {
        var sol = new KthSmallestElementInBST();

        // Test Case 1: Example BST
        //      5
        //     / \
        //    3   6
        //   / \
        //  2   4
        // /
        //1
        TreeNode root1 = new TreeNode(5);
        root1.left = new TreeNode(3);
        root1.right = new TreeNode(6);
        root1.left.left = new TreeNode(2);
        root1.left.right = new TreeNode(4);
        root1.left.left.left = new TreeNode(1);
        System.out.println("Test Case 1 (k=3): " + sol.kthSmallest(root1, 3)); // Expected: 3
        System.out.println("Test Case 1 (k=1): " + sol.kthSmallest(root1, 1)); // Expected: 1
        System.out.println("Test Case 1 (k=6): " + sol.kthSmallest(root1, 6)); // Expected: 6

        // Test Case 2: Smaller BST
        //      3
        //     / \
        //    1   4
        //     \
        //      2
        TreeNode root2 = new TreeNode(3);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(4);
        root2.left.right = new TreeNode(2);
        System.out.println("Test Case 2 (k=1): " + sol.kthSmallest(root2, 1)); // Expected: 1
        System.out.println("Test Case 2 (k=2): " + sol.kthSmallest(root2, 2)); // Expected: 2
        System.out.println("Test Case 2 (k=4): " + sol.kthSmallest(root2, 4)); // Expected: 4

        // Test Case 3: Empty Tree
        System.out.println("Test Case 3 (k=1): " + sol.kthSmallest(null, 1)); // Expected: -1 (or handle error)
    }
}

/**
 * Dry Run:
 * Input: root = [5,3,6,2,4,null,null,1], k = 3 (Tree from Test Case 1)
 *
 * 1. Initialization:
 *    stack = []
 *    curr = root (5)
 *    k = 3
 *
 * 2. Loop (curr != null || !stack.isEmpty()):
 *    - **Phase 1: Go Left (from 5):**
 *      - curr=5: stack.push(5), curr=3. stack=[5]
 *      - curr=3: stack.push(3), curr=2. stack=[5,3]
 *      - curr=2: stack.push(2), curr=1. stack=[5,3,2]
 *      - curr=1: stack.push(1), curr=null. stack=[5,3,2,1]
 *      - curr is null. Inner while loop ends.
 *
 *    - **Phase 2: Pop and Process (1st smallest):**
 *      - curr = stack.pop() -> 1. stack=[5,3,2]
 *      - k = 3-1 = 2. k != 0.
 *      - curr = curr.right (1.right is null). curr=null.
 *
 *    - **Phase 3: Pop and Process (2nd smallest):**
 *      - curr is null, stack is not empty.
 *      - curr = stack.pop() -> 2. stack=[5,3]
 *      - k = 2-1 = 1. k != 0.
 *      - curr = curr.right (2.right is null). curr=null.
 *
 *    - **Phase 4: Pop and Process (3rd smallest):**
 *      - curr is null, stack is not empty.
 *      - curr = stack.pop() -> 3. stack=[5]
 *      - k = 1-1 = 0. k == 0.
 *      - Return curr.value (3).
 *
 * Final Result: 3
 */
