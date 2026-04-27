package com.naresh.a_dsalgo.ab_strings.problems;
public class AnagramCheck {
    public static void main(String[] args) {
        System.out.println("Anagram: " + isAnagram("listen", "silent"));
    }
    public static boolean isAnagram(String s1, String s2) {
        // Time: O(n), Space: O(1)
        if (s1 == null || s2 == null || s1.length() != s2.length()) return false;
        int[] counts = new int[256];
        for (int i = 0; i < s1.length(); i++) {
            counts[s1.charAt(i)]++;
            counts[s2.charAt(i)]--;
        }
        for (int count : counts)
            if (count != 0) return false;
        return true;
    }
    public static boolean isAnagramEarlyExit(String s1, String s2) {
        // Time: O(n), Space: O(1)
        if (s1 == null || s2 == null || s1.length() != s2.length()) return false;
        int[] counts = new int[256];
        for (char c : s1.toCharArray())
            counts[c]++;
        for (char c : s2.toCharArray())
            if (--counts[c] < 0) return false;
        return true;
    }
}
