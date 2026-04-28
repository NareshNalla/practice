package com.naresh.a_dsalgo.aa_arrays.slidingwindow;

/**
 * Problem: Longest Repeating Character Replacement
 * Description: Given a string s and an integer k, you can choose any character of the string and change it to any other uppercase English character.
 * You can perform this operation at most k times. Return the length of the longest substring containing the same letter.
 */
public class LongestRepeatingCharacterReplacement {
    /**
     * Algorithm: Sliding window. Maintain counts of characters in current window and track maxFrequency.
     * Window is valid if (windowLength - maxFrequency <= k).
     */
    public int characterReplacement(String s, int k) {
        // Pattern: Sliding Window (Variable) | Time: O(n), Space: O(1)
        var counts = new int[26];
        int l = 0, maxFreq = 0, maxLen = 0;
        for (int r = 0; r < s.length(); r++) {
            maxFreq = Math.max(maxFreq, ++counts[s.charAt(r) - 'A']);
            while ((r - l + 1) - maxFreq > k) { // Window invalid
                counts[s.charAt(l) - 'A']--;
                l++;
            }
            maxLen = Math.max(maxLen, r - l + 1);
        }
        return maxLen;
    }
    // FAANG Tip: Tracking maxFreq within the window allows O(n) instead of re-scanning counts. Space is O(1) as alphabet size is fixed.

    public static void main(String[] args) {
        var sol = new LongestRepeatingCharacterReplacement();
        System.out.println(sol.characterReplacement("ABAB", 2)); // Expected: 4
        System.out.println(sol.characterReplacement("AABABBA", 1)); // Expected: 4
    }
}
