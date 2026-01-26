'''
Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values of the nodes in the tree.

Input: root = [3,1,4,null,2], k = 1
Output: 1

Input: root = [5,3,6,2,4,null,null,1], k = 3
Output: 3
'''
from typing import Optional
from TreeNode import TreeNode, print_tree

class KthSmallestElementInBST:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        # Pattern: Iterative Inorder Traversal (DFS)
        # Time Complexity: O(H + k) - We traverse down to the leftmost node (H) and then process k nodes.
        # Space Complexity: O(H) - Stack size is proportional to the height of the tree.
        
        stack = []
        curr = root
        while stack or curr:
            # Step 1: Go as left as possible
            while curr:
                stack.append(curr)
                curr = curr.left
            # Step 2: Process the node (this is the next smallest)
            curr = stack.pop()
            k -= 1
            # Step 3: If k == 0, we found our target
            if k == 0:
                return curr.val
            # Step 4: Move to right subtree
            curr = curr.right
            
        return -1 # Should not reach here if k is valid

    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        # Pattern: Iterative Inorder Traversal (DFS)
        # Time Complexity: O(H + k) - We traverse down to the leftmost node (H) and then process k nodes.
        # Space Complexity: O(H) - Stack size is proportional to the height of the tree.
        n = 0
        stack = []
        curr = root
        while curr and stack:
            # Step 1: Go as left as possible
            while curr:
                stack.append(curr)
                curr = curr.left
            # Step 2: Process the node (this is the next smallest)
            curr = stack.pop()
            n += 1
            # Step 3: If k == 0, we found our target
            if n == k:
                return curr.val
            # Step 4: Move to right subtree
            curr = curr.right

if __name__ == "__main__":
    solution = KthSmallestElementInBST()
    
    # Test Case 1
    root1 = TreeNode(3)
    root1.left = TreeNode(1)
    root1.right = TreeNode(4)
    root1.left.right = TreeNode(2)
    
    print(f"Tree 1: {print_tree(root1)}")
    print(f"1st Smallest: {solution.kthSmallest(root1, 1)}") # Expected: 1
    print("-" * 20)

    # Test Case 2
    root2 = TreeNode(5)
    root2.left = TreeNode(3)
    root2.right = TreeNode(6)
    root2.left.left = TreeNode(2)
    root2.left.right = TreeNode(4)
    root2.left.left.left = TreeNode(1)
    
    print(f"Tree 2: {print_tree(root2)}")
    print(f"3rd Smallest: {solution.kthSmallest(root2, 3)}") # Expected: 3
