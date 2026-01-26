'''
Given the root of a binary tree, return its maximum depth.
A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

Input: root = [3,9,20,null,null,15,7]
Output: 3

Input: root = [1,null,2]
Output: 2
'''
from typing import Optional
from TreeNode import TreeNode, print_tree

class MaximumDepthOfBinaryTree:
    """
    Time Complexity: O(N) - Visit every node once.
    Space Complexity: O(H) - Height of the tree (recursion stack).
    """
    def maxDepth(self, root: Optional[TreeNode]) -> int:
        if not root:
            return 0
        
        return 1 + max(self.maxDepth(root.left), self.maxDepth(root.right))

    """
    Iterative DFS 
    Time Complexity: O(N) - Visit every node once.
    Space Complexity: O(N) - Worst case (skewed tree), stack holds all nodes. O(H) generally.
    """
    def maxDepthNeet(self, root: Optional[TreeNode]) -> int:
        if not root:
            return 0
        stack = [[root, 1]]
        res = 0
        while stack:
            node, depth = stack.pop()
            if node:
                res = max(res, depth)
                stack.append([node.left, depth + 1])
                stack.append([node.right, depth + 1])
        return res

'''
for calculating Maximum Depth, the order (Preorder, Inorder, Postorder) does not matter. We just need to visit every node and track its depth.
Preorder fashion (Node -> Left -> Right) 
'''
if __name__ == "__main__":
    solution = MaximumDepthOfBinaryTree()
    
    # Test Case 1
    root1 = TreeNode(3)
    root1.left = TreeNode(9)
    root1.right = TreeNode(20)
    root1.right.left = TreeNode(15)
    root1.right.right = TreeNode(7)
    
    print(f"Tree 1: {print_tree(root1)}")
    print(f"Max Depth (Recursive): {solution.maxDepth(root1)}") # Expected: 3
    print(f"Max Depth (Iterative): {solution.maxDepthNeet(root1)}") # Expected: 3
    print("-" * 20)

    # Test Case 2
    root2 = TreeNode(1)
    root2.right = TreeNode(2)
    
    print(f"Tree 2: {print_tree(root2)}")
    print(f"Max Depth (Recursive): {solution.maxDepth(root2)}") # Expected: 2
    print(f"Max Depth (Iterative): {solution.maxDepthNeet(root2)}") # Expected: 2
