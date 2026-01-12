'''
https://leetcode.com/problems/same-tree/description/
Given the roots of two binary trees p and q, write a function to check if they are the same or not.
Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
Input: p = [1,2,3], q = [1,2,3]
Output: true
Input: p = [1,2], q = [1,null,2]
Output: false
'''
from TreeNode import TreeNode , print_tree

class SameTree:
    def isSameTree(self, p: TreeNode, q: TreeNode) -> bool:
        if not p and not q:
            return True
        if not p or not q or p.val != q.val:
            return False

        return (self.isSameTree(p.left, q.left) and self.isSameTree(p.right, q.right))

if __name__ == "__main__":
    # Input: p = [1,2,3] q = [1,2,3]
    # Output: True
    p = TreeNode(1)
    p.left = TreeNode(2)
    p.right = TreeNode(3)

    q = TreeNode(1)
    q.left = TreeNode(2)
    q.right = TreeNode(3)


    print(f"i/p Tree1 : {print_tree(p)} i/pTree2: {print_tree(q)}")
    solution = SameTree()

    print(f"result Tree: {solution.isSameTree(p,q)}")
