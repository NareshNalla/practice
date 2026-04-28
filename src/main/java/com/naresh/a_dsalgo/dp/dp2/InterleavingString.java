package com.naresh.a_dsalgo.dp.dp2;

/**
 * Problem: Interleaving String
 * Description: Given strings s1, s2, and s3, find whether s3 is formed by an interleaving of s1 and s2.
 */
public class InterleavingString {
    /**
     * Algorithm: 2D DP. `dp[i][j]` is true if `s3[0...i+j-1]` is an interleaving of `s1[0...i-1]` and `s2[0...j-1]`.
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        // Pattern: DP (2D) | Time: O(m * n), Space: O(n)
        if (s1.length() + s2.length() != s3.length()) return false;
        var dp = new boolean[s2.length() + 1];
        dp[0] = true; // Base case: two empty strings interleave into an empty string

        for (int j = 1; j <= s2.length(); j++) { // Initialize first row
            dp[j] = dp[j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
        }

        for (int i = 1; i <= s1.length(); i++) {
            dp[0] = dp[0] && s1.charAt(i - 1) == s3.charAt(i - 1);
            for (int j = 1; j <= s2.length(); j++) {
                dp[j] = (dp[j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) ||
                        (dp[j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
            }
        }
        return dp[s2.length()];
    }
    // FAANG Tip: 2D DP can be optimized to 1D because each state only depends on the previous row/column.
}
