'''
Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.

Input: root = [1,2,3,null,null,4,5]
Output: [1,2,3,null,null,4,5]
'''
from typing import Optional
from TreeNode import TreeNode, print_tree

class Codec:
    """Encodes a tree to a single string.
        Pattern: Preorder DFS (Root -> Left -> Right)
        Time Complexity: O(N) - Visit every node once
        Space Complexity: O(N) - String construction
        """
    def serialize(self, root: Optional[TreeNode]) -> str:
        res = []
        def dfs(node):
            # Step 1: Base case - if node is None, append "N" marker
            if not node:
                res.append("N")
                return
            # Step 2: Append current node value
            res.append(str(node.val))
            dfs(node.left)  # Step 3: Recurse Left
            dfs(node.right)  # Step 4: Recurse Right
        dfs(root)
        # Join with comma delimiter
        return ",".join(res)

    def deserialize(self, data: str) -> Optional[TreeNode]:
        """Decodes your encoded data to tree.
        Pattern: Preorder DFS (Root -> Left -> Right)
        Time Complexity: O(N) - Process every value once
        Space Complexity: O(N) - Recursion stack + values list
        """
        vals = data.split(",")
        self.i = 0 # Global index pointer
        def dfs():
            # Step 1: Get current value and increment pointer
            if self.i >= len(vals):   #this not in neet
                return None
            val = vals[self.i]
            self.i += 1
            # Step 2: Base case - if value is "N", return None
            if val == "N":
                return None
            # Step 3: Create node
            node = TreeNode(int(val))
            # Step 4: Recursively build left subtree
            node.left = dfs()
            # Step 5: Recursively build right subtree
            node.right = dfs()
            return node
        return dfs()

if __name__ == "__main__":
    codec = Codec()
    
    # Test Case 1
    root1 = TreeNode(1)
    root1.left = TreeNode(2)
    root1.right = TreeNode(3)
    root1.right.left = TreeNode(4)
    root1.right.right = TreeNode(5)
    print(f"Original Tree: {print_tree(root1)}")
    serialized = codec.serialize(root1)
    print(f"Serialized: {serialized}")
    deserialized = codec.deserialize(serialized)
    print(f"Deserialized: {print_tree(deserialized)}")
    # Verify structure match (simple check via print_tree output)
    assert print_tree(root1) == print_tree(deserialized)
    print("Verification: Success")
    print("-" * 20)
    # Test Case 2: Empty Tree
    root2 = None
    print(f"Original Tree: {print_tree(root2)}")
    serialized2 = codec.serialize(root2)
    print(f"Serialized: {serialized2}")
    deserialized2 = codec.deserialize(serialized2)
    print(f"Deserialized: {print_tree(deserialized2)}")
