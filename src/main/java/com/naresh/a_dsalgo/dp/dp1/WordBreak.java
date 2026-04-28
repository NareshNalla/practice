package com.naresh.a_dsalgo.dp.dp1;

import java.util.*;

/**
 * Problem: Word Break
 * Description: Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.
 */
public class WordBreak {
    /**
     * Algorithm: Bottom-up DP. dp[i] is true if s[0...i] can be segmented.
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        // Pattern: DP (1D) | Time: O(n^3), Space: O(n)
        var dict = new HashSet<>(wordDict); // O(1) lookups
        var dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && dict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
    // FAANG Tip: O(n^3) time due to two loops and substring operation. Using a Trie can optimize dictionary lookups.
}
