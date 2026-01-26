'''
Given the roots of two binary trees p and q, write a function to check if they are the same or not.
Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.

Input: p = [1,2,3], q = [1,2,3]
Output: true

Input: p = [1,2], q = [1,null,2]
Output: false
'''
from typing import Optional
from TreeNode import TreeNode, print_tree

class SameTree:
    """
    Pattern: Recursive DFS (Preorder Traversal)
    Time Complexity: O(N) - We visit every node exactly once.
    Space Complexity: O(H) - Height of the tree due to recursion stack.
    """
    def isSameTree(self, p: Optional[TreeNode], q: Optional[TreeNode]) -> bool:
        # Base Case 1: Both are None -> Identical
        if not p and not q:
            return True
        
        # Base Case 2: One is None or values differ -> Not Identical
        if not p or not q or p.val != q.val:
            return False

        # Recursive Step: Check left subtrees AND right subtrees
        return (self.isSameTree(p.left, q.left) and 
                self.isSameTree(p.right, q.right))

if __name__ == "__main__":
    solution = SameTree()
    
    # Test Case 1
    p1 = TreeNode(1)
    p1.left = TreeNode(2)
    p1.right = TreeNode(3)
    
    q1 = TreeNode(1)
    q1.left = TreeNode(2)
    q1.right = TreeNode(3)
    
    print(f"Tree P: {print_tree(p1)}")
    print(f"Tree Q: {print_tree(q1)}")
    print(f"Is Same: {solution.isSameTree(p1, q1)}") # Expected: True
    print("-" * 20)

    # Test Case 2
    p2 = TreeNode(1)
    p2.left = TreeNode(2)
    
    q2 = TreeNode(1)
    q2.right = TreeNode(2)
    
    print(f"Tree P: {print_tree(p2)}")
    print(f"Tree Q: {print_tree(q2)}")
    print(f"Is Same: {solution.isSameTree(p2, q2)}") # Expected: False
