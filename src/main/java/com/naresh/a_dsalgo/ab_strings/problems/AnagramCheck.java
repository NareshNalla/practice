package com.naresh.a_dsalgo.ab_strings.problems;

import java.util.Arrays; // Added for potential future use or clarity

/**
 * Problem: Anagram Check
 * Description: Given two strings s1 and s2, determine if s2 is an anagram of s1.
 * An anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
 * typically using all the original letters exactly once.
 */
public class AnagramCheck {
    public static void main(String[] args) {
        System.out.println("Anagram (listen, silent): " + isAnagram("listen", "silent")); // Expected: true
        System.out.println("Anagram (hello, world): " + isAnagram("hello", "world"));   // Expected: false
        System.out.println("Anagram (anagram, nagaram): " + isAnagram("anagram", "nagaram")); // Expected: true
        System.out.println("Anagram (rat, car): " + isAnagram("rat", "car")); // Expected: false
    }

    /**
     * Algorithm: Use a frequency array (counts) to store character counts. Increment for s1, decrement for s2.
     * If all counts are zero at the end, they are anagrams.
     */
    public static boolean isAnagram(String s1, String s2) {
        // Pattern: Frequency Array | Time: O(n), Space: O(1)
        if (s1 == null || s2 == null || s1.length() != s2.length()) return false;
        var counts = new int[256]; // Assuming ASCII characters
        for (int i = 0; i < s1.length(); i++) {
            counts[s1.charAt(i)]++;
            counts[s2.charAt(i)]--;
        }
        for (int count : counts)
            if (count != 0) return false;
        return true;
    }
    // FAANG Tip: This method is robust for any character set (ASCII/Unicode) if array size is adjusted.

    /**
     * Algorithm: Use a frequency array. Increment for s1. Decrement for s2, with an early exit if count drops below zero.
     */
    public static boolean isAnagramEarlyExit(String s1, String s2) {
        // Pattern: Frequency Array (Early Exit) | Time: O(n), Space: O(1)
        if (s1 == null || s2 == null || s1.length() != s2.length()) return false;
        var counts = new int[256]; // Assuming ASCII characters
        for (char c : s1.toCharArray())
            counts[c]++;
        for (char c : s2.toCharArray())
            if (--counts[c] < 0) return false; // If a char in s2 appears more than in s1
        return true;
    }
    // FAANG Tip: The early exit can provide performance benefits in cases where strings are not anagrams.
}

/**
 * Dry Run (isAnagram):
 * Input: s1 = "listen", s2 = "silent"
 *
 * 1. Initialization:
 *    s1.length() = 6, s2.length() = 6. Lengths match.
 *    counts = new int[256] (all zeros)
 *
 * 2. First Loop (Populating/Depopulating counts):
 *    - i = 0: s1.charAt(0)='l', s2.charAt(0)='s'
 *      counts['l']++, counts['s']--
 *      counts = {..., 'l':1, 's':-1, ...}
 *    - i = 1: s1.charAt(1)='i', s2.charAt(1)='i'
 *      counts['i']++, counts['i']--
 *      counts = {..., 'l':1, 's':-1, 'i':0, ...}
 *    - i = 2: s1.charAt(2)='s', s2.charAt(2)='l'
 *      counts['s']++, counts['l']--
 *      counts = {..., 'l':0, 's':0, 'i':0, ...}
 *    - i = 3: s1.charAt(3)='t', s2.charAt(3)='e'
 *      counts['t']++, counts['e']--
 *      counts = {..., 'l':0, 's':0, 'i':0, 't':1, 'e':-1, ...}
 *    - i = 4: s1.charAt(4)='e', s2.charAt(4)='n'
 *      counts['e']++, counts['n']--
 *      counts = {..., 'l':0, 's':0, 'i':0, 't':1, 'e':0, 'n':-1, ...}
 *    - i = 5: s1.charAt(5)='n', s2.charAt(5)='t'
 *      counts['n']++, counts['t']--
 *      counts = {..., 'l':0, 's':0, 'i':0, 't':0, 'e':0, 'n':0, ...}
 *
 * 3. Second Loop (Checking counts):
 *    - All values in 'counts' array are 0.
 *
 * 4. Result: true
 */
