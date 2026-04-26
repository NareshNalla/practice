package com.naresh.a_dsalgo.aarrays.slidingwindow;

import java.util.HashMap;

/**
 * Problem: Minimum Window Substring
 * Description: Find the minimum window in 's' which contains all characters from 't'.
 */
public class MinimumWindowSubstring {
    /**
     * Algorithm: Use a sliding window with two pointers. First, build a frequency map of 't'. 
     * Expand 'right' to include all required characters. Once valid, shrink 'left' to 
     * minimize the window while maintaining validity. Update min window throughout.
     */
    public String minWindow(String s, String t) {
        // Pattern: Sliding Window | Time: O(s + t), Space: O(t)
        if (s == null || t == null || s.length() < t.length()) return "";
        var targetMap = new HashMap<Character, Integer>();
        for (char c : t.toCharArray()) targetMap.put(c, targetMap.getOrDefault(c, 0) + 1); // Frequency of T

        var windowMap = new HashMap<Character, Integer>();
        int left = 0, right = 0, matchedCount = 0;
        int minLen = Integer.MAX_VALUE, minStart = 0;

        while (right < s.length()) {
            char c = s.charAt(right);
            if (targetMap.containsKey(c)) {
                windowMap.put(c, windowMap.getOrDefault(c, 0) + 1);
                if (windowMap.get(c).intValue() == targetMap.get(c).intValue()) matchedCount++; // Character requirement met
            }

            while (matchedCount == targetMap.size()) { // Window is valid
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    minStart = left;
                }
                char leftChar = s.charAt(left);
                if (targetMap.containsKey(leftChar)) {
                    if (windowMap.get(leftChar).intValue() == targetMap.get(leftChar).intValue()) matchedCount--; // Breaking validity
                    windowMap.put(leftChar, windowMap.get(leftChar) - 1);
                }
                left++; // Shrink window
            }
            right++; // Expand window
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }
    // FAANG Tip: Explain the 'matchedCount' optimization to avoid O(26) map comparison in each step. Mention substring overhead and memory-safe alternatives like returning indices.

    public static void main(String[] args) {
        var sol = new MinimumWindowSubstring();
        System.out.println("Test 1 ADOBECODEBANC , ABC: " + sol.minWindow("ADOBECODEBANC", "ABC")); // "BANC"
        System.out.println("Test 2  a , a  : " + sol.minWindow("a", "a")); // "a"
        System.out.println("Test 3  a, aa :  " + sol.minWindow("a", "aa")); // ""
    }
}
