package com.naresh.a_dsalgo.dp.dp1;

/**
 * Problem: Palindromic Substrings
 * Description: Given a string s, return the number of palindromic substrings in it.
 */
public class PalindromicSubstrings {
    /**
     * Algorithm: Expand around each character (odd and even centers) and count valid palindromes.
     */
    public int countSubstrings(String s) {
        // Pattern: Expand Around Center | Time: O(n^2), Space: O(1)
        var count = 0;
        for (int i = 0; i < s.length(); i++) {
            count += expand(s, i, i);     // Odd center
            count += expand(s, i, i + 1); // Even center
        }
        return count;
    }

    private int expand(String s, int l, int r) {
        var count = 0;
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            count++; l--; r++; // Found a palindrome
        }
        return count;
    }
    // FAANG Tip: Similar to "Longest Palindromic Substring". O(1) space is the key differentiator from DP approach.
}
