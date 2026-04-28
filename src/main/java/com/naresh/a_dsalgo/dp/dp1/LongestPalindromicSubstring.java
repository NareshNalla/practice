package com.naresh.a_dsalgo.dp.dp1;

/**
 * Problem: Longest Palindromic Substring
 * Description: Given a string s, return the longest palindromic substring in s.
 */
public class LongestPalindromicSubstring {
    /**
     * Algorithm: Expand around each index as a potential center (odd and even lengths). Track max length and start index.
     */
    public String longestPalindrome(String s) {
        // Pattern: Expand Around Center | Time: O(n^2), Space: O(1)
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            var len1 = expand(s, i, i);     // Odd length
            var len2 = expand(s, i, i + 1); // Even length
            var len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2; // Calculate new start
                end = i + len / 2;         // Calculate new end
            }
        }
        return s.substring(start, end + 1);
    }

    private int expand(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--; r++;
        }
        return r - l - 1; // Return length
    }
    // FAANG Tip: Expanding around center is O(n^2) time but O(1) space, making it better than O(n^2) DP in practice.
}
