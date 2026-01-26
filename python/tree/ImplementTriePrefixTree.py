'''
A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and retrieve keys in a dataset of strings. There are various applications of this data structure, such as autocomplete and spellchecker.

Implement the Trie class:
Trie() Initializes the trie object.
void insert(String word) Inserts the string word into the trie.
boolean search(String word) Returns true if the string word is in the trie (i.e., was inserted before), and false otherwise.
boolean startsWith(String prefix) Returns true if there is a previously inserted string word that has the prefix prefix, and false otherwise.

Input
["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
[[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
Output
[null, null, true, false, true, null, true]
'''
from TrieNode import TrieNode

class Trie:
    def __init__(self):
        # Pattern: Trie (Prefix Tree)
        # Time Complexity: O(1) for init
        # Space Complexity: O(1)
        self.root = TrieNode()

    def insert(self, word: str) -> None:
        # Time Complexity: O(L) where L is length of word
        # Space Complexity: O(L) in worst case (new nodes)
        curr = self.root
        for char in word:
            # Step 1: If char not in children, create new node
            if char not in curr.children:
                curr.children[char] = TrieNode()
            # Step 2: Move to next node
            curr = curr.children[char]
        # Step 3: Mark end of word
        curr.isEndOfWord = True

    def search(self, word: str) -> bool:
        # Time Complexity: O(L)
        # Space Complexity: O(1)
        curr = self.root
        for char in word:
            # Step 1: If char not found, word doesn't exist
            if char not in curr.children:
                return False
            curr = curr.children[char]
        # Step 2: Check if it's marked as end of word
        return curr.isEndOfWord

    def startsWith(self, prefix: str) -> bool:
        # Time Complexity: O(L)
        # Space Complexity: O(1)
        curr = self.root
        for char in prefix:
            # Step 1: If char not found, prefix doesn't exist
            if char not in curr.children:
                return False
            curr = curr.children[char]
        # Step 2: If we traversed the whole prefix, it exists
        return True

if __name__ == "__main__":
    trie = Trie()
    
    # Test Case 1
    print("Insert 'apple'")
    trie.insert("apple")
    
    print(f"Search 'apple': {trie.search('apple')}")   # Expected: True
    print(f"Search 'app': {trie.search('app')}")       # Expected: False
    print(f"StartsWith 'app': {trie.startsWith('app')}") # Expected: True
    
    print("Insert 'app'")
    trie.insert("app")
    print(f"Search 'app': {trie.search('app')}")       # Expected: True
