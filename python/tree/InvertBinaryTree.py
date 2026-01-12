'''
Given the root of a binary tree, invert the tree, and return its root
Input: root = [4,2,7,1,3,6,9]
Output: [4,7,2,9,6,3,1]
'''
from typing import Optional
from TreeNode import TreeNode, print_tree

class InvertBinaryTree:
     def invertTree(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
         if not root:
             return None
         temp = root.left
         root.left = root.right
         root.right = temp
         
         self.invertTree(root.left)
         self.invertTree(root.right)
         return root

if __name__ == "__main__":
    # Input: root = [4,2,7,1,3,6,9]
    # Output: [4,7,2,9,6,3,1]
    root = TreeNode(4)
    root.left = TreeNode(2)
    root.right = TreeNode(7)
    root.left.left = TreeNode(1)
    root.left.right = TreeNode(3)
    root.right.left = TreeNode(6)
    root.right.right = TreeNode(9)
    print(f"Inverted Tree: {print_tree(root)}")
    solution = InvertBinaryTree()
    inverted_root = solution.invertTree(root)

    print(f"Inverted Tree: {print_tree(inverted_root)}")