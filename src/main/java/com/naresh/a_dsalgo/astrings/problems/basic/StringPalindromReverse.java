package com.naresh.a_dsalgo.astrings.problems.basic;

public class StringPalindromReverse {
    public static void main(String[] args) {
        String s = "abcba";
        System.out.println("Reverse: " + reverse(s));
        System.out.println("Is Palindrome: " + isPalindrome(s));
    }

    public static boolean isPalindrome(String s) {
        // Time: O(n), Space: O(1)
        if (s == null) return false;
        for (int i = 0, j = s.length() - 1; i < j; i++, j--)
            if (s.charAt(i) != s.charAt(j)) return false;
        return true;
    }

    public static String reverse(String s) {
        // Time: O(n), Space: O(n)
        if (s == null || s.length() <= 1) return s;
        char[] ca = s.toCharArray();
        for (int i = 0, j = ca.length - 1; i < j; i++, j--) {
            char t = ca[i]; ca[i] = ca[j]; ca[j] = t;
        }
        return new String(ca);
    }
}
