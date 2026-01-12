'''
Given two strings text1 and text2, return the length of their longest common subsequence. If there is no common subsequence, return 0.

A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.

For example, "ace" is a subsequence of "abcde".
A common subsequence of two strings is a subsequence that is common to both strings.

Input: text1 = "abcde", text2 = "ace" 
Output: 3  
Explanation: The longest common subsequence is "ace" and its length is 3.
'''

class LongestCommonSubsequence:
    def longestCommonSubsequence(self, text1: str, text2: str) -> int:
        # Get lengths of both strings
        m, n = len(text1), len(text2)
        
        # Create a 2D DP table with dimensions (m+1) x (n+1)
        # dp[i][j] will store the length of LCS for text1[0...i-1] and text2[0...j-1]
        dp = [[0] * (n + 1) for _ in range(m + 1)]
        
        # Iterate through each character of both strings
        for i in range(1, m + 1):
            for j in range(1, n + 1):
                # If characters match, add 1 to the result from the previous diagonal cell
                if text1[i - 1] == text2[j - 1]:
                    dp[i][j] = 1 + dp[i - 1][j - 1]
                else:
                    # If characters don't match, take the maximum from the top or left cell
                    dp[i][j] = max(dp[i - 1][j], dp[i][j - 1])
        
        # The bottom-right cell contains the length of the LCS for the full strings
        return dp[m][n]

if __name__ == "__main__":
    solution = LongestCommonSubsequence()
    
    # Test Case 1
    text1 = "abcde"
    text2 = "ace"
    print(f"LCS of '{text1}' and '{text2}': {solution.longestCommonSubsequence(text1, text2)}") # Expected: 3

    # Test Case 2
    text1 = "abc"
    text2 = "abc"
    print(f"LCS of '{text1}' and '{text2}': {solution.longestCommonSubsequence(text1, text2)}") # Expected: 3

    # Test Case 3
    text1 = "abc"
    text2 = "def"
    print(f"LCS of '{text1}' and '{text2}': {solution.longestCommonSubsequence(text1, text2)}") # Expected: 0
