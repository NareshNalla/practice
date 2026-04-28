package com.naresh.a_dsalgo.dp.dp2;

/**
 * Problem: Longest Common Subsequence
 * Description: Given two strings text1 and text2, return the length of their longest common subsequence.
 */
public class LongestCommonSubsequence {
    /**
     * Algorithm: 2D DP table where dp[i][j] stores LCS of text1[0...i] and text2[0...j].
     */
    public int longestCommonSubsequence(String text1, String text2) {
        // Pattern: DP (2D) | Time: O(m * n), Space: O(m * n)
        int m = text1.length(), n = text2.length();
        var dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1]; // Character match
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]); // Skip one
                }
            }
        }
        return dp[m][n];
    }
    // FAANG Tip: Space can be optimized to O(min(m, n)) using only two rows. Mention LCS is the basis for the 'diff' utility.
}
