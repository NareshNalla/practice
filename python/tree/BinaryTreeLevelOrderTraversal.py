'''
Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).

Input: root = [3,9,20,null,null,15,7]
Output: [[3],[9,20],[15,7]]

Input: root = [1]
Output: [[1]]

Input: root = []
Output: []
'''
from typing import Optional, List
from collections import deque
from TreeNode import TreeNode, print_tree

class BinaryTreeLevelOrderTraversal:
    # Pattern: BFS (Breadth-First Search)
    # Time Complexity: O(N) - Visit every node once
    # Space Complexity: O(N) - Queue can hold up to N/2 nodes (last level)

    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        res = []
        if not root:
            return res
        q = deque([root])
        while q:
            level = []
            # Step 1: Iterate through all nodes in the current level
            # We snapshot the length of the queue to process only current level nodes
            for _ in range(len(q)):
                node = q.popleft()
                if node:
                    level.append(node.val)
                    # Step 2: Add children to queue for next level
                    if node.left:
                        q.append(node.left)
                    if node.right:
                        q.append(node.right)
            # Step 3: Add the current level's values to result
            if level:
                res.append(level)
        return res
    def levelOrderNeet(self, root: Optional[TreeNode]) -> List[List[int]]:
        res = []
        q = collections.deque()
        q.append(root)
        while q:
            qLen = len(q)
            level = []
            for i in range(qLen):
                node = q.popleft()
                if node:
                    level.append(node.val)
                    q.append(node.left)
                    q.append(node.right)
            if level:
                res.append(level)
        return res

if __name__ == "__main__":
    solution = BinaryTreeLevelOrderTraversal()
    
    # Test Case 1
    root1 = TreeNode(3)
    root1.left = TreeNode(9)
    root1.right = TreeNode(20)
    root1.right.left = TreeNode(15)
    root1.right.right = TreeNode(7)
    
    print(f"Tree 1: {print_tree(root1)}")
    print(f"Level Order: {solution.levelOrder(root1)}") # Expected: [[3], [9, 20], [15, 7]]
    print("-" * 20)

    # Test Case 2
    root2 = TreeNode(1)
    print(f"Tree 2: {print_tree(root2)}")
    print(f"Level Order: {solution.levelOrder(root2)}") # Expected: [[1]]
    print("-" * 20)
    
    # Test Case 3
    root3 = None
    print(f"Tree 3: {print_tree(root3)}")
    print(f"Level Order: {solution.levelOrder(root3)}") # Expected: []
