class TrieNode:
    def __init__(self):
        # Map char -> TrieNode
        self.children = {}
        # Flag to mark end of a word
        self.isEndOfWord = False
