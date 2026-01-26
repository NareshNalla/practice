'''
Given the roots of two binary trees root and subRoot, return true if there is a subtree of root with the same structure and node values of subRoot and false otherwise.
A subtree of a binary tree tree is a tree that consists of a node in tree and all of this node's descendants. The tree tree could also be considered as a subtree of itself.

Input: root = [3,4,5,1,2], subRoot = [4,1,2]
Output: true

Input: root = [3,4,5,1,2,null,null,null,null,0], subRoot = [4,1,2]
Output: false
'''
from typing import Optional
from TreeNode import TreeNode, print_tree

class SubtreeOfAnotherTree:
    def isSubtree(self, root: Optional[TreeNode], subRoot: Optional[TreeNode]) -> bool:
        # Pattern: Recursive DFS
        # Time Complexity: O(N * M) - For every node in root (N), we might check equality with subRoot (M)
        # Space Complexity: O(H) - Height of root tree
        
        # Step 1: If subRoot is None, it's always a subtree (empty tree is subtree of any tree)
        if not subRoot:
            return True
        # Step 2: If root is None but subRoot isn't, it can't be a subtree
        if not root:
            return False
        # Step 3: Check if trees are identical starting at current root
        if self.isSameTree(root, subRoot):
            return True
            
        # Step 4: Recurse - check if subRoot is a subtree of left OR right child
        return (self.isSubtree(root.left, subRoot) or 
                self.isSubtree(root.right, subRoot))

    def isSameTree(self, p: Optional[TreeNode], q: Optional[TreeNode]) -> bool:
        # Helper function to check if two trees are identical
        if not p and not q:
            return True
        if not p or not q or p.val != q.val:
            return False
        return (self.isSameTree(p.left, q.left) and 
                self.isSameTree(p.right, q.right))

    def isSameTreeNeet(self, root: Optional[TreeNode], subRoot: Optional[TreeNode]) -> bool:
        # Helper function to check if two trees are identical
        if not root and not subRoot:
            return True
        if root and subRoot and root.val == subRoot.val:
            return (self.isSameTree(root.left, subRoot.left) and
                self.isSameTree(root.right, subRoot.right))

if __name__ == "__main__":
    solution = SubtreeOfAnotherTree()
    
    # Test Case 1
    root1 = TreeNode(3)
    root1.left = TreeNode(4)
    root1.right = TreeNode(5)
    root1.left.left = TreeNode(1)
    root1.left.right = TreeNode(2)
    
    subRoot1 = TreeNode(4)
    subRoot1.left = TreeNode(1)
    subRoot1.right = TreeNode(2)
    
    print(f"Root 1: {print_tree(root1)}")
    print(f"SubRoot 1: {print_tree(subRoot1)}")
    print(f"Is Subtree: {solution.isSubtree(root1, subRoot1)}") # Expected: True
    print("-" * 20)

    # Test Case 2
    root2 = TreeNode(3)
    root2.left = TreeNode(4)
    root2.right = TreeNode(5)
    root2.left.left = TreeNode(1)
    root2.left.right = TreeNode(2)
    root2.left.right.left = TreeNode(0) # Extra node
    
    subRoot2 = TreeNode(4)
    subRoot2.left = TreeNode(1)
    subRoot2.right = TreeNode(2)
    
    print(f"Root 2: {print_tree(root2)}")
    print(f"SubRoot 2: {print_tree(subRoot2)}")
    print(f"Is Subtree: {solution.isSubtree(root2, subRoot2)}") # Expected: False
