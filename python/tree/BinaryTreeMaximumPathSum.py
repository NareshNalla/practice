'''
A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them. A node can only appear in the sequence at most once. Note that the path does not need to pass through the root.
The path sum of a path is the sum of the node's values in the path.
Given the root of a binary tree, return the maximum path sum of any non-empty path.

Input: root = [1,2,3]
Output: 6
Explanation: The optimal path is 2 -> 1 -> 3 with a path sum of 2 + 1 + 3 = 6.

Input: root = [-10,9,20,null,null,15,7]
Output: 42
Explanation: The optimal path is 15 -> 20 -> 7 with a path sum of 15 + 20 + 7 = 42.
'''
from typing import Optional
from TreeNode import TreeNode, print_tree

class BinaryTreeMaximumPathSum:
    def maxPathSum(self, root: Optional[TreeNode]) -> int:
        # Pattern: DFS (Post-order Traversal)
        # Time Complexity: O(N) - Visit every node once
        # Space Complexity: O(H) - Recursion stack height
        self.res = float('-inf') #res = [root.val] res[0]
        def dfs(node):
            if not node:
                return 0
            # Step 1: Recursively get max path sum from left and right children
            # If a child returns negative, we ignore it (take 0) as it decreases the sum
            leftMax = max(dfs(node.left), 0)
            rightMax = max(dfs(node.right), 0)

            # Step 2: Calculate max path sum WITH split at current node (Left + Node + Right)
            # This path does NOT go up to the parent, it "turns" at this node
            self.res = max(self.res, node.val + leftMax + rightMax)

            # Step 3: Return max path sum extending from current node to parent
            # Can only choose one branch (Left or Right) + Node to extend the path
            return node.val + max(leftMax, rightMax)

        dfs(root)
        return self.res

if __name__ == "__main__":
    solution = BinaryTreeMaximumPathSum()
    
    # Test Case 1
    root1 = TreeNode(1)
    root1.left = TreeNode(2)
    root1.right = TreeNode(3)
    print(f"Tree 1: {print_tree(root1)}")
    print(f"Max Path Sum: {solution.maxPathSum(root1)}") # Expected: 6
    print("-" * 20)

    # Test Case 2
    root2 = TreeNode(-10)
    root2.left = TreeNode(9)
    root2.right = TreeNode(20)
    root2.right.left = TreeNode(15)
    root2.right.right = TreeNode(7)
    print(f"Tree 2: {print_tree(root2)}")
    print(f"Max Path Sum: {solution.maxPathSum(root2)}") # Expected: 42
