# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        """
        Finds the Lowest Common Ancestor (LCA) of two nodes in a Binary Search Tree (BST).
        
        Time Complexity: O(h), where h is the height of the tree.
        Space Complexity: O(h) for recursion stack (or O(1) if iterative).
        """
        # Base case: if root is None, we can't find LCA
        if not root:
            return None
        
        # If both p and q are smaller than root, LCA is in the left subtree
        if p.val < root.val and q.val < root.val:
            return self.lowestCommonAncestor(root.left, p, q)
        
        # If both p and q are greater than root, LCA is in the right subtree
        if p.val > root.val and q.val > root.val:
            return self.lowestCommonAncestor(root.right, p, q)
            
        # If we reach here, it means:
        # 1. One node is on the left and the other is on the right (split point)
        # 2. OR one of the nodes IS the root itself
        # In either case, the current root is the LCA.
        return root


    def lowestCommonAncestor1(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        cur = root
        while cur:
            if p.val > cur.val and q.val > cur.val:
                cur = cur.right
            elif p.val < cur.val and q.val < cur.val:
                cur = cur.left
            else:
                return cur

# Test Runner
if __name__ == "__main__":
    # Constructing the BST from the example: [6,2,8,0,4,7,9,null,null,3,5]
    #        6
    #      /   \
    #     2     8
    #    / \   / \
    #   0   4 7   9
    #      / \
    #     3   5
    
    root = TreeNode(6)
    root.left = TreeNode(2)
    root.right = TreeNode(8)
    root.left.left = TreeNode(0)
    root.left.right = TreeNode(4)
    root.right.left = TreeNode(7)
    root.right.right = TreeNode(9)
    root.left.right.left = TreeNode(3)
    root.left.right.right = TreeNode(5)

    solution = Solution()

    # Test Case 1: LCA of 2 and 8
    # Expected: 6 (the root itself)
    p1 = root.left  # Node 2
    q1 = root.right # Node 8
    lca1 = solution.lowestCommonAncestor(root, p1, q1)
    lca12 = solution.lowestCommonAncestor1(root, p1, q1)
    print(f"LCA of {p1.val} and {q1.val} is: {lca1.val}")

    # Test Case 2: LCA of 2 and 4
    # Expected: 2 (since 2 is the parent of 4, and a node can be its own descendant)
    p2 = root.left       # Node 2
    q2 = root.left.right # Node 4
    lca2 = solution.lowestCommonAncestor(root, p2, q2)
    print(f"LCA of {p2.val} and {q2.val} is: {lca2.val}")

    # Test Case 3: LCA of 3 and 5
    # Expected: 4 (parent of both 3 and 5)
    p3 = root.left.right.left  # Node 3
    q3 = root.left.right.right # Node 5
    lca3 = solution.lowestCommonAncestor(root, p3, q3)
    print(f"LCA of {p3.val} and {q3.val} is: {lca3.val}")

    print(f"LCA2 of {p1.val} and {q1.val} is: {lca12.val}")
