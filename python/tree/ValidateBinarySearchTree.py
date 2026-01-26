'''
Given the root of a binary tree, determine if it is a valid binary search tree (BST).
A valid BST is defined as follows:
The left subtree of a node contains only nodes with keys strictly less than the node's key.
The right subtree of a node contains only nodes with keys strictly greater than the node's key.
Both the left and right subtrees must also be binary search trees.

Input: root = [2,1,3]
Output: true

Input: root = [5,1,4,null,null,3,6]
Output: false
'''
from typing import Optional
from TreeNode import TreeNode, print_tree

class ValidateBinarySearchTree:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        # Pattern: Recursive DFS with Range Validation (Min/Max constraints)
        # Time Complexity: O(N) - Visit every node once
        # Space Complexity: O(H) - Recursion stack height
        
        def validate(node, low, high):
            # Step 1: Base case - empty node is valid
            if not node:
                return True
            # Step 2: Check current node value against constraints
            if not (low < node.val < high): #(node.val<right and node.val >val)
                return False
            
            # Step 3: Recursively validate subtrees with updated constraints
            # Left child must be < current node value
            # Right child must be > current node value
            return (validate(node.left, low, node.val) and
                    validate(node.right, node.val, high))

        # Initial call with infinite range
        return validate(root, float('-inf'), float('inf'))

if __name__ == "__main__":
    solution = ValidateBinarySearchTree()
    
    # Test Case 1
    root1 = TreeNode(2)
    root1.left = TreeNode(1)
    root1.right = TreeNode(3)
    print(f"Tree 1: {print_tree(root1)}")
    print(f"Is Valid BST: {solution.isValidBST(root1)}") # Expected: True
    print("-" * 20)

    # Test Case 2
    root2 = TreeNode(5)
    root2.left = TreeNode(1)
    root2.right = TreeNode(4)
    root2.right.left = TreeNode(3)
    root2.right.right = TreeNode(6)
    print(f"Tree 2: {print_tree(root2)}")
    print(f"Is Valid BST: {solution.isValidBST(root2)}") # Expected: False
