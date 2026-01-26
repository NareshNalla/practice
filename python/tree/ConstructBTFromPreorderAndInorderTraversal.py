'''
Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.

Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
Output: [3,9,20,null,null,15,7]

Input: preorder = [-1], inorder = [-1]
Output: [-1]
'''
from typing import List, Optional
from TreeNode import TreeNode, print_tree

class ConstructBTFromPreorderAndInorderTraversal:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        # Pattern: Recursive Tree Construction with Hash Map
        # Time Complexity: O(N) - Visit every node once, O(1) lookups
        # Space Complexity: O(N) - Hash Map + Recursion Stack
        # Step 1: Map inorder values to their indices for O(1) access
        inorder_map = {val: i for i, val in enumerate(inorder)}
        # Global pointer for preorder traversal
        self.pre_idx = 0
        def helper(left, right):
            # Step 2: Base case - if no elements to construct subtree
            if left > right:
                return None
            # Step 3: Get root value from preorder and increment pointer
            root_val = preorder[self.pre_idx]
            self.pre_idx += 1
            root = TreeNode(root_val)
            # Step 4: Find split point in inorder array
            mid = inorder_map[root_val]
            # Step 5: Recursively build left and right subtrees
            # Note: Left subtree is built first because preorder is Root -> Left -> Right
            root.left = helper(left, mid - 1)
            root.right = helper(mid + 1, right)
            return root

        return helper(0, len(inorder) - 1)

    def buildTreeNeet(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        if not preorder or not inorder:
            return None
        root = TreeNode(preorder[0])
        mid = inorder.index(preorder[0])
        root.left = self.buildTree(preorder[1:mid + 1], inorder[:mid])
        root.right = self.buildTree(preorder[mid + 1:], inorder[mid + 1:])
        return root
        #null missing

if __name__ == "__main__":
    solution = ConstructBTFromPreorderAndInorderTraversal()

    # Test Case 1
    preorder1 = [3, 9, 20, 15, 7]
    inorder1 = [9, 3, 15, 20, 7]
    print(f"Preorder: {preorder1}, Inorder: {inorder1}")
    root1 = solution.buildTreeNeet(preorder1, inorder1)
    print(f"Built Tree: {print_tree(root1)}") # Expected: [3, 9, 20, None, None, 15, 7]
    print("-" * 20)

    # Test Case 2
    preorder2 = [-1]
    inorder2 = [-1]
    print(f"Preorder: {preorder2}, Inorder: {inorder2}")
    root2 = solution.buildTreeNeet(preorder2, inorder2)
    print(f"Built Tree: {print_tree(root2)}") # Expected: [-1]