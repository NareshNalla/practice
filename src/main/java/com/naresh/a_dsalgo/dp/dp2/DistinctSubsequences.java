package com.naresh.a_dsalgo.dp.dp2;

/**
 * Problem: Distinct Subsequences
 * Description: Given two strings s and t, return the number of distinct subsequences of s which equal t.
 */
public class DistinctSubsequences {
    /**
     * Algorithm: 2D DP. `dp[i][j]` is the number of ways to form `t[0...j]` from `s[0...i]`.
     */
    public int numDistinct(String s, String t) {
        // Pattern: DP (2D) | Time: O(s * t), Space: O(t)
        int sl = s.length(), tl = t.length();
        var dp = new int[tl + 1];
        dp[0] = 1; // Base case: an empty 't' can be formed from any prefix of 's'
        for (int i = 1; i <= sl; i++) {
            for (int j = tl; j >= 1; j--) { // Traverse backwards for space optimization
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[j] += dp[j - 1]; // We can either include s[i-1] or skip it (but dp[j] already has skip count)
                }
            }
        }
        return dp[tl];
    }
    // FAANG Tip: Space optimization from 2D to 1D is possible by iterating 'j' backwards.
}
