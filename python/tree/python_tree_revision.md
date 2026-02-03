# Python Tree Problems Revision Notes

This document provides a quick revision guide for common tree-based problems, including the techniques and high-level steps to solve them.

---

### 1. Add and Search Word (Data Structure Design)

- **Problem**: Design a data structure that supports adding words and searching for words that may contain `.` as a wildcard.
- **Technique**: Trie + Recursive DFS (Backtracking)
- **Steps**:
    1.  **`addWord`**:
        -   Build a standard Trie. Traverse the Trie based on the characters of the word.
        -   Create new nodes for characters that don't exist in the path.
        -   Mark the final node as the end of a word.
    2.  **`search`**:
        -   Use a recursive DFS function that takes the current index in the word and the current Trie node.
        -   If the character is not a `.`, move to the corresponding child node. If it doesn't exist, return `False`.
        -   If the character is a `.`, recursively call the search function on all children of the current node. If any of these calls return `True`, then return `True`.
        -   After iterating through the word, return `True` only if the final node is marked as the end of a word.

---

### 2. Binary Tree Level Order Traversal

- **Problem**: Traverse a binary tree level by level.
- **Technique**: Breadth-First Search (BFS) using a Queue
- **Steps**:
    1.  Initialize a queue and add the root node.
    2.  While the queue is not empty:
        -   Get the number of nodes currently in the queue (this represents the number of nodes at the current level).
        -   Create a list to store the values of the current level.
        -   Loop that many times:
            -   Dequeue a node, add its value to the level list.
            -   Enqueue its left and right children if they exist.
        -   Add the level list to the final result.

---

### 3. Binary Tree Maximum Path Sum

- **Problem**: Find the maximum sum of a path between any two nodes in a binary tree. The path does not need to pass through the root.
- **Technique**: DFS (Post-order Traversal)
- **Steps**:
    1.  Use a recursive DFS function that returns the maximum path sum *without splitting* (i.e., the path can extend upwards).
    2.  Maintain a global variable to store the overall maximum path sum found so far.
    3.  In the DFS function for a node:
        -   Recursively find the max path sum from the left and right children. Ignore any negative results (treat them as `0`).
        -   Update the global maximum by considering the path that *splits* at the current node (i.e., `node.val + left_max + right_max`).
        -   Return `node.val + max(left_max, right_max)` to the parent, representing the best path that can be extended upwards.

---

### 4. Construct Binary Tree from Preorder and Inorder Traversal

- **Problem**: Reconstruct a binary tree from its preorder and inorder traversal arrays.
- **Technique**: Recursive Tree Construction with a Hash Map
- **Steps**:
    1.  Create a hash map from the `inorder` array to store the index of each value for O(1) lookup.
    2.  Use a recursive helper function that takes the left and right boundaries of the current segment of the `inorder` array.
    3.  The first element in the `preorder` array is always the root of the current (sub)tree.
    4.  Find the root's index in the `inorder` array using the hash map. This index splits the `inorder` array into the left and right subtrees.
    5.  Recursively call the helper function to build the left and right subtrees.

---

### 5. Implement Trie (Prefix Tree)

- **Problem**: Implement a Trie with `insert`, `search`, and `startsWith` methods.
- **Technique**: Trie
- **Steps**:
    1.  **`insert`**: Traverse the Trie, creating nodes for characters that are not present. Mark the final node as the end of a word.
    2.  **`search`**: Traverse the Trie. If any character is not found, return `False`. After the loop, return `True` only if the final node is marked as the end of a word.
    3.  **`startsWith`**: Traverse the Trie. If any character in the prefix is not found, return `False`. If the loop completes, return `True`.

---

### 6. Invert Binary Tree

- **Problem**: Invert a binary tree (swap all left and right children).
- **Technique**: Recursive DFS (Preorder, Inorder, or Postorder all work)
- **Steps**:
    1.  Base case: If the node is `None`, return.
    2.  Swap the `left` and `right` children of the current node.
    3.  Recursively call the function on the (new) left and right children.

---

### 7. Kth Smallest Element in a BST

- **Problem**: Find the kth smallest element in a Binary Search Tree.
- **Technique**: Iterative Inorder Traversal (DFS)
- **Steps**:
    1.  Use a stack for iterative inorder traversal.
    2.  While the current node is not `None` or the stack is not empty:
        -   Push all left children of the current node onto the stack until you reach the leftmost node.
        -   Pop a node from the stack. This is the next smallest element.
        -   Decrement `k`. If `k` becomes `0`, this node's value is the answer.
        -   Move to the right child of the popped node to process the next part of the tree.

---

### 8. Lowest Common Ancestor of a BST

- **Problem**: Find the lowest common ancestor of two given nodes in a Binary Search Tree.
- **Technique**: Binary Search Tree Properties
- **Steps**:
    1.  Start at the root.
    2.  If both target nodes' values are smaller than the current node's value, the LCA must be in the left subtree.
    3.  If both are larger, the LCA must be in the right subtree.
    4.  If one is smaller and one is larger (or if the current node is one of the targets), the current node is the "split point" and therefore the LCA.

---

### 9. Maximum Depth of Binary Tree

- **Problem**: Find the maximum depth (number of nodes on the longest path from root to a leaf) of a binary tree.
- **Technique**: Recursive DFS
- **Steps**:
    1.  Base case: If the node is `None`, the depth is `0`.
    2.  Recursively find the depth of the left and right subtrees.
    3.  The depth at the current node is `1 + max(left_depth, right_depth)`.

---

### 10. Same Tree

- **Problem**: Check if two binary trees are structurally identical and have the same node values.
- **Technique**: Recursive DFS
- **Steps**:
    1.  Base case: If both nodes are `None`, they are the same (`True`).
    2.  If one node is `None` or their values are different, they are not the same (`False`).
    3.  Recursively check if the left subtrees are the same AND the right subtrees are the same.

---

### 11. Serialize and Deserialize Binary Tree

- **Problem**: Convert a binary tree to a string and back.
- **Technique**: Preorder DFS
- **Steps**:
    1.  **`serialize`**:
        -   Use a preorder DFS traversal.
        -   For each node, append its value to a list. If a node is `None`, append a special marker (e.g., "N").
        -   Join the list into a single string with a delimiter.
    2.  **`deserialize`**:
        -   Split the string back into a list of values.
        -   Use a preorder DFS helper function that reads from the list sequentially.
        -   If the value is the null marker, return `None`.
        -   Otherwise, create a new node with the value, then recursively call the function to build its left and right children.

---

### 12. Subtree of Another Tree

- **Problem**: Check if one binary tree is a subtree of another.
- **Technique**: Recursive DFS
- **Steps**:
    1.  Create a helper function `isSameTree` that checks if two trees are identical.
    2.  The main function `isSubtree` will:
        -   Base cases: If the `subRoot` is `None`, it's always a subtree. If the `root` is `None` but `subRoot` isn't, it's not.
        -   Check if the tree starting at the current `root` is the same as `subRoot` using `isSameTree`.
        -   If not, recursively check if `subRoot` is a subtree of `root.left` OR `root.right`.

---

### 13. Validate Binary Search Tree

- **Problem**: Determine if a binary tree is a valid Binary Search Tree.
- **Technique**: Recursive DFS with Range Validation
- **Steps**:
    1.  Use a recursive helper function that takes a node and a `(min, max)` range.
    2.  Base case: An empty node is a valid BST.
    3.  For the current node, check if its value is within the `(min, max)` range. If not, return `False`.
    4.  Recursively call the function for the left child with an updated range of `(min, node.val)` and for the right child with `(node.val, max)`.

---

### 14. Word Search II

- **Problem**: Find all words from a dictionary that can be formed by adjacent letters in a grid.
- **Technique**: Trie + Backtracking (DFS)
- **Steps**:
    1.  Build a Trie from all the words in the dictionary.
    2.  Iterate through each cell of the board, using it as a starting point for a DFS search.
    3.  The DFS function will take the current cell coordinates and the current Trie node.
    4.  In the DFS:
        -   Mark the current cell as visited.
        -   Move to the next Trie node corresponding to the character in the cell.
        -   If the new Trie node marks the end of a word, add the word to the results.
        -   Recursively call DFS for all unvisited neighbors.
        -   Backtrack by un-marking the current cell as visited.
    5.  **Optimization**: To avoid re-adding the same word, either use a set for the results or remove the word from the Trie once it's found.
