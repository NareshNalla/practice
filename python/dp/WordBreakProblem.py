'''
Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.

Note that the same word in the dictionary may be reused multiple times in the segmentation.

Input: s = "leetcode", wordDict = ["leet","code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".

Input: s = "applepenapple", wordDict = ["apple","pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
Note that you are allowed to reuse a dictionary word.

Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
Output: false
'''
from typing import List

class WordBreakProblem:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        # Convert list to set for O(1) lookups
        word_set = set(wordDict)
        n = len(s)
        
        # dp[i] means s[0:i] can be segmented into words from the dictionary
        dp = [False] * (n + 1)
        dp[0] = True  # Base case: empty string is valid
        
        for i in range(1, n + 1):
            for j in range(i):
                # If s[0:j] is valid AND s[j:i] is a valid word
                if dp[j] and s[j:i] in word_set:
                    dp[i] = True
                    break # Found a valid split for s[0:i], move to next i
                    
        return dp[n]

if __name__ == "__main__":
    solution = WordBreakProblem()
    
    # Test Case 1
    s1 = "leetcode"
    wordDict1 = ["leet", "code"]
    print(f"Test 1 ('{s1}'): {solution.wordBreak(s1, wordDict1)}") # Expected: True

    # Test Case 2
    s2 = "applepenapple"
    wordDict2 = ["apple", "pen"]
    print(f"Test 2 ('{s2}'): {solution.wordBreak(s2, wordDict2)}") # Expected: True

    # Test Case 3
    s3 = "catsandog"
    wordDict3 = ["cats", "dog", "sand", "and", "cat"]
    print(f"Test 3 ('{s3}'): {solution.wordBreak(s3, wordDict3)}") # Expected: False
