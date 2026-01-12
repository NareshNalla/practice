from typing import Optional, List
from collections import deque

class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

def print_tree(root: Optional[TreeNode]) -> List[int]:
    if not root:
        return []
    result = []
    queue = deque([root])
    while queue:
        node = queue.popleft()
        result.append(node.val)
        if node.left: queue.append(node.left)
        if node.right: queue.append(node.right)
    return result