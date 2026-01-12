'''
https://leetcode.com/problems/encode-and-decode-strings/

'''
class TreeNode:
    def __init__(self):
        self.val = 0
        self.left = None
        self.right = None

class LowestCommonAncestorOfBST:
    def lowestCommoAncestorOfBST(self, root:TreeNode, left:TreeNode, right:TreeNode) -> TreeNode:
        if not root:
            return None
        cur = root
        while cur:
            if cur.val > left.val and cur.val > right.val:
                cur = cur.left
            elif cur.val < left.val and cur.val < right.val:
                cur = cur.right
            else:
                return cur

