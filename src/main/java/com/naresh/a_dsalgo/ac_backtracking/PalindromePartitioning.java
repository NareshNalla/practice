package com.naresh.a_dsalgo.ac_backtracking;

import java.util.*;

/**
 * Problem: Palindrome Partitioning
 * Description: Given a string s, partition s such that every substring of the partition is a palindrome.
 */
public class PalindromePartitioning {
    /**
     * Algorithm: Backtracking to explore all possible partitions. Use a helper to check palindromes.
     */
    public List<List<String>> partition(String s) {
        // Pattern: Backtracking (DFS) | Time: O(n * 2^n), Space: O(n)
        var result = new ArrayList<List<String>>();
        backtrack(result, new ArrayList<>(),  s, 0);
        return result;
    }

    private void backtrack(List<List<String>> res,  List<String> current, String s,  int start) {
        if (start == s.length()) {
            res.add(new ArrayList<>(current)); // Found a valid partition
            return;
        }
        for (var end = start; end < s.length(); end++) {
            if (isPalindrome(s, start, end)) {
                current.add(s.substring(start, end + 1)); // Choose
                backtrack(res, current, s , end + 1); // Explore
                current.remove(current.size() - 1); // Un-choose (Backtrack)
            }
        }
    }

    private boolean isPalindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--)) {
                return false;
            }
        }
        return true;
    }
    // FAANG Tip: Pre-calculating palindrome status using DP can optimize from O(n * 2^n) to O(2^n).

    public static void main(String[] args) {
        PalindromePartitioning solution = new PalindromePartitioning();
        String s = "aab";
        System.out.println("Partitions of 'aab': " + solution.partition(s));
    }
}
