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
        int left = 0, right = 0;
        for (int i = 0; i < s.length(); i++) {
            var len1 = expand(s, i, i);     // Odd length
            var len2 = expand(s, i, i + 1); // Even length
            var len = Math.max(len1, len2);
            if (len > right - left) {
                left = i - (len - 1) / 2; // Calculate new left
                right = i + len / 2;         // Calculate new right
            }
        }
        return s.substring(left, right + 1);
    }

    private int expand(String s, int left, int right) {
        int L = left; int R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--; R++;
        }
        return R - L - 1; // Return length
    }
    // FAANG Tip: Expanding around center is O(n^2) time but O(1) space, making it better than O(n^2) DP in practice.

    public static void main(String[] args) {
        var s = "babad";
        var result = new LongestPalindromicSubstring().longestPalindrome(s);
        System.out.println("Longest palindrome of '" + s + "': " + result);
    }

    /*
     * Dry Run:
     * Input: s = "babad"
     * Centers expanded at i=0..4; longest found could be "bab" or "aba" depending on expansion order. Example found: "bab".
     * Result: "bab"
     */
}
