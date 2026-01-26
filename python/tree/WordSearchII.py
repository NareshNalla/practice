'''
Given an m x n board of characters and a list of strings words, return all words on the board.
Each word must be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.

Input: board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]], words = ["oath","pea","eat","rain"]
Output: ["eat","oath"]
'''
from typing import List
from TrieNode import TrieNode

class WordSearchII:
    def addWord(self, root: TrieNode, word: str):
        curr = root
        for c in word:
            if c not in curr.children:
                curr.children[c] = TrieNode()
            curr = curr.children[c]
        curr.isEndOfWord = True
        # Optimization: Store the word at the leaf node to avoid reconstructing it
        curr.word = word

    def findWords(self, board: List[List[str]], words: List[str]) -> List[str]:
        # Pattern: Trie + Backtracking (DFS)
        # Time Complexity: O(M * N * 4^L) where L is max word length (pruned by Trie)
        # Space Complexity: O(Total characters in words) for Trie
        
        # Step 1: Build Trie
        root = TrieNode()
        for w in words:
            self.addWord(root, w)

        ROWS, COLS = len(board), len(board[0])
        res = set()
        visited = set()

        def dfs(r, c, node):
            # Step 2: Base checks
            if (r < 0 or c < 0 or r >= ROWS or c >= COLS or 
                (r, c) in visited or board[r][c] not in node.children):
                return

            visited.add((r, c))
            node = node.children[board[r][c]]

            # Step 3: Check if we found a word
            if node.isEndOfWord:
                res.add(node.word)
                # Optimization: Remove word from Trie to prevent duplicate processing
                node.isEndOfWord = False 

            # Step 4: Recurse in 4 directions
            dfs(r + 1, c, node)
            dfs(r - 1, c, node)
            dfs(r, c + 1, node)
            dfs(r, c - 1, node)
            
            visited.remove((r, c))

        # Step 5: Iterate through every cell
        for r in range(ROWS):
            for c in range(COLS):
                dfs(r, c, root)

        return list(res)

if __name__ == "__main__":
    solution = WordSearchII()
    
    # Test Case 1
    board1 = [
        ["o","a","a","n"],
        ["e","t","a","e"],
        ["i","h","k","r"],
        ["i","f","l","v"]
    ]
    words1 = ["oath","pea","eat","rain"]
    print(f"Board: {board1}")
    print(f"Words: {words1}")
    print(f"Found: {solution.findWords(board1, words1)}") # Expected: ["oath", "eat"] (order may vary)
    print("-" * 20)

    # Test Case 2
    board2 = [["a","b"],["c","d"]]
    words2 = ["abcb"]
    print(f"Board: {board2}")
    print(f"Words: {words2}")
    print(f"Found: {solution.findWords(board2, words2)}") # Expected: []
