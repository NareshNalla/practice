'''
Design a data structure that supports adding new words and finding if a string matches any previously added string.
Implement the WordDictionary class:
- WordDictionary() Initializes the object.
- void addWord(word) Adds word to the data structure, it can be matched later.
- bool search(word) Returns true if there is any string in the data structure that matches word or false otherwise. word may contain dots '.' where dots can be matched with any letter.

Example:
Input
["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
[[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
Output
[null,null,null,null,false,true,true,true]
'''
        # Pattern: Trie (Prefix Tree)
from TrieNode import TrieNode

class WordDictionary:
    def __init__(self):
        self.root = TrieNode()

    def addWord(self, word: str) -> None:
        curr = self.root
        # Time: O(L), Space: O(L)
        for char in word:
            if char not in curr.children:
                curr.children[char] = TrieNode()
            curr = curr.children[char]
        curr.isEndOfWord = True

    def search(self, word: str) -> bool:
        # Pattern: Recursive DFS (Backtracking) on Trie
        # Time: O(M) where M is total chars in trie (worst case: "...")
        # Space: O(L) for recursion stack

        def dfs(j, root):
            curr = root
            for i in range(j, len(word)):

                # Step 1: If char is '.', recursively check all children
                char = word[i]

                # Step 2: If char not in children, no match
                if char == ".":

                    for child in curr.children.values():

            # Step 3: After iterating, check if it's a complete word
                        if dfs(i + 1, child):
                            return True
                    return False


                else:
                    if char not in curr.children:
                        return False
                    curr = curr.children[char]
            return curr.isEndOfWord
        return dfs(0, self.root)

if __name__ == "__main__":
    wordDictionary = WordDictionary()
    wordDictionary.addWord("bad")
    wordDictionary.addWord("dad")
    wordDictionary.addWord("mad")
    print(f"search('pad'): {wordDictionary.search('pad')}") # Expected: False
    print(f"search('bad'): {wordDictionary.search('bad')}") # Expected: True
    print(f"search('.ad'): {wordDictionary.search('.ad')}") # Expected: True
    print(f"search('b..'): {wordDictionary.search('b..')}") # Expected: True
