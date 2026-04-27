package com.naresh.a_dsalgo.aa_arrays.slidingwindow;

import java.util.HashMap;

/**
 * Problem: Longest Substring Without Repeating Characters
 * Description: Find the length of the longest substring in a given string that does not contain any repeating characters.
 */
public class LongestSubstringWithoutRepeatingCharacters {
    /**
     * Algorithm: Use a sliding window with two pointers (left and right) and a HashMap to store
     * the last seen index of each character. Expand the right pointer. If a character is
     * already in the map and its last seen index is within the current window (>= left),
     * then move the left pointer to `index + 1` to exclude the repeating character.
     * Update the maximum length at each step.
     */
    public int lengthOfLongestSubstring(String s) {
        // Pattern: Sliding Window | Time: O(n), Space: O(min(n, alphabet_size))
        if (s == null || s.length() == 0) return 0;

        var charIndexMap = new HashMap<Character, Integer>(); // Stores char -> last seen index
        var maxLength = 0;
        var left = 0; // Left pointer of the sliding window

        for (int right = 0; right < s.length(); right++) {
            var currentChar = s.charAt(right);
            if (charIndexMap.containsKey(currentChar)) {
                // If character is already in the window, move left pointer past its last occurrence
                left = Math.max(left, charIndexMap.get(currentChar) + 1); // Ensure left only moves forward
            }
            charIndexMap.put(currentChar, right); // Update last seen index of current character
            maxLength = Math.max(maxLength, right - left + 1); // Calculate current window length and update max
        }
        return maxLength;
    }
    // FAANG Tip: Discuss the choice between HashMap (for Unicode) and a fixed-size array (for ASCII/extended ASCII). Emphasize O(N) time due to each character being visited by left and right pointers at most twice.

    public static void main(String[] args) {
        var sol = new LongestSubstringWithoutRepeatingCharacters();

        // Test Case 1
        var s1 = "abcabcbb";
        System.out.println("String: \"" + s1 + "\" -> Longest Substring Length: " + sol.lengthOfLongestSubstring(s1)); // Expected: 3 ("abc")

        // Test Case 2
        var s2 = "bbbbb";
        System.out.println("String: \"" + s2 + "\" -> Longest Substring Length: " + sol.lengthOfLongestSubstring(s2)); // Expected: 1 ("b")

        // Test Case 3
        var s3 = "pwwkew";
        System.out.println("String: \"" + s3 + "\" -> Longest Substring Length: " + sol.lengthOfLongestSubstring(s3)); // Expected: 3 ("wke")

        // Test Case 4
        var s4 = "";
        System.out.println("String: \"" + s4 + "\" -> Longest Substring Length: " + sol.lengthOfLongestSubstring(s4)); // Expected: 0

        // Test Case 5
        var s5 = "au";
        System.out.println("String: \"" + s5 + "\" -> Longest Substring Length: " + sol.lengthOfLongestSubstring(s5)); // Expected: 2 ("au")
    }
}
