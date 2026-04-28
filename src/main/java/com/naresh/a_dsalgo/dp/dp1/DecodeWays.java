package com.naresh.a_dsalgo.dp.dp1;

/**
 * Problem: Decode Ways
 * Description: A message containing letters from A-Z can be encoded into numbers using A=1, B=2, ..., Z=26.
 * Given a string s containing only digits, return the number of ways to decode it.
 */
public class DecodeWays {
    /**
     * Algorithm: Iterative DP with two variables. dp[i] depends on s[i] and s[i-1:i+1].
     */
    public int numDecodings(String s) {
        // Pattern: DP (Space Optimized) | Time: O(n), Space: O(1)
        if (s == null || s.isEmpty() || s.charAt(0) == '0') return 0;
        int prev2 = 1, prev1 = 1; // Base cases: dp[i-2], dp[i-1]
        for (int i = 1; i < s.length(); i++) {
            var curr = 0;
            if (s.charAt(i) != '0') curr += prev1; // Valid single digit
            var twoDigit = Integer.parseInt(s.substring(i - 1, i + 1));
            if (twoDigit >= 10 && twoDigit <= 26) curr += prev2; // Valid double digit
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
    // FAANG Tip: Handle '0' carefully. A leading '0' or an invalid '0' (like '30') makes the string undecodable.
}
