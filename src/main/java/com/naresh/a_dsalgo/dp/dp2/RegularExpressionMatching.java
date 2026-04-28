package com.naresh.a_dsalgo.dp.dp2;

/**
 * Problem: Regular Expression Matching
 * Description: Given an input string s and a pattern p, implement regular expression matching with support for '.' and '*'.
 */
public class RegularExpressionMatching {
    /**
     * Algorithm: 2D DP. `dp[i][j]` is true if `s[0...i-1]` matches `p[0...j-1]`.
     */
    public boolean isMatch(String s, String p) {
        // Pattern: DP (2D) | Time: O(m * n), Space: O(m * n)
        int m = s.length(), n = p.length();
        var dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;

        // Base case for patterns like a*, a*b*, a*b*c*
        for (int j = 2; j <= n; j++) {
            if (p.charAt(j - 1) == '*') dp[0][j] = dp[0][j - 2];
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) == '.' || p.charAt(j - 1) == s.charAt(i - 1)) {
                    dp[i][j] = dp[i - 1][j - 1]; // Direct match
                } else if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 2]; // Case 1: * represents 0 occurrences
                    if (p.charAt(j - 2) == '.' || p.charAt(j - 2) == s.charAt(i - 1)) {
                        dp[i][j] |= dp[i - 1][j]; // Case 2: * represents 1 or more occurrences
                    }
                }
            }
        }
        return dp[m][n];
    }
    // FAANG Tip: Handling '*' is the most complex part. It can either skip the preceding character or match it multiple times.
}
