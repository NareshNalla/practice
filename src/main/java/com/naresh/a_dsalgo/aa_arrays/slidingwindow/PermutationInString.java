package com.naresh.a_dsalgo.aa_arrays.slidingwindow;

import java.util.Arrays;

/**
 * Problem: Permutation in String
 * Description: Given two strings s1 and s2, return true if s2 contains a permutation of s1.
 */
public class PermutationInString {
    /**
     * Algorithm: Sliding window of fixed size s1.length(). Use frequency arrays to compare character counts.
     */
    public boolean checkInclusion(String s1, String s2) {
        // Pattern: Sliding Window (Fixed) | Time: O(n), Space: O(1)
        if (s1.length() > s2.length()) return false;
        var s1Counts = new int[26];
        var s2Counts = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            s1Counts[s1.charAt(i) - 'a']++;
            s2Counts[s2.charAt(i) - 'a']++;
        }
        if (Arrays.equals(s1Counts, s2Counts)) return true;

        for (int i = s1.length(); i < s2.length(); i++) {
            s2Counts[s2.charAt(i) - 'a']++; // Slide in
            s2Counts[s2.charAt(i - s1.length()) - 'a']--; // Slide out
            if (Arrays.equals(s1Counts, s2Counts)) return true;
        }
        return false;
    }
    // FAANG Tip: Array comparison takes O(26) = O(1). Mention that for larger alphabets, tracking a 'matches' count can optimize to O(n).

    public static void main(String[] args) {
        var sol = new PermutationInString();
        System.out.println(sol.checkInclusion("ab", "eidbaooo")); // Expected: true
        System.out.println(sol.checkInclusion("ab", "eidboaoo")); // Expected: false
    }
}

/**
 * Dry Run:
 * Input: s1 = "ab", s2 = "eidbaooo"
 *
 * 1. Initialization:
 *    s1Len = 2, s2Len = 8
 *    s1Counts: [a:1, b:1, ...] (all others 0)
 *    s2Counts (first window "ei"): [e:1, i:1, ...]
 *    Arrays.equals(s1Counts, s2Counts) -> false
 *
 * 2. Sliding Window:
 *    i = 2 ('d'):
 *      Slide in 'd', slide out 'e'
 *      s2Counts: [i:1, d:1, ...]
 *      Arrays.equals -> false
 *
 *    i = 3 ('b'):
 *      Slide in 'b', slide out 'i'
 *      s2Counts: [d:1, b:1, ...]
 *      Arrays.equals -> false
 *
 *    i = 4 ('a'):
 *      Slide in 'a', slide out 'd'
 *      s2Counts: [b:1, a:1, ...]
 *      Arrays.equals -> true
 *
 * 3. Result: true
 */

/**
 * Dry Run:
 * Input: s1 = "ab", s2 = "eidboaoo"
 *
 * 1. Initialization:
 *    s1Len = 2, s2Len = 8
 *    s1Counts: [a:1, b:1, ...] (all others 0)
 *    s2Counts (first window "ei"): [e:1, i:1, ...]
 *    Arrays.equals(s1Counts, s2Counts) -> false
 *
 * 2. Sliding Window:
 *    i = 2 ('d'):
 *      Slide in 'd', slide out 'e'
 *      s2Counts: [i:1, d:1, ...]
 *      Arrays.equals -> false
 *
 *    i = 3 ('b'):
 *      Slide in 'b', slide out 'i'
 *      s2Counts: [d:1, b:1, ...]
 *      Arrays.equals -> false
 *
 *    i = 4 ('o'):
 *      Slide in 'o', slide out 'd'
 *      s2Counts: [b:1, o:1, ...]
 *      Arrays.equals -> false
 *
 *    i = 5 ('a'):
 *      Slide in 'a', slide out 'b'
 *      s2Counts: [o:1, a:1, ...]
 *      Arrays.equals -> false
 *
 *    i = 6 ('o'):
 *      Slide in 'o', slide out 'o'
 *      s2Counts: [a:1, o:1, ...]
 *      Arrays.equals -> false
 *
 * 3. Loop finishes. No permutation found.
 * 4. Result: false
 */
