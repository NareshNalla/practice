package com.naresh.a_dsalgo.ab_strings.problems.basic;

/**
 * Problem: Valid Palindrome
 * Description: Determine if a string is a palindrome, ignoring non-alphanumeric characters and case.
 */
public class ValidPalindromStringReverse {
    /**
     * Algorithm: Two pointers move inward, skipping non-alphanumeric chars using a custom filter.
     */
    public boolean isPalindrome(String s) {
        // Pattern: Two Pointers (Custom Filter) | Time: O(n), Space: O(1)
        if (s == null) return false;
        int l = 0, r = s.length() - 1;
        while (l < r) {
            while (l < r && !isAlphaNum(s.charAt(l))) l++; // Skip non-alphanum
            while (l < r && !isAlphaNum(s.charAt(r))) r--;
            if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))){
                return false;
            }
            l++; r--;
        }
        return true;
    }
    // FAANG Tip: Custom alphanumeric checks avoid the overhead of Character.isLetterOrDigit which handles Unicode.

    public boolean isAlphaNum(char c) {
        return (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9');
    }

    public static void main(String[] args) {
        var solution = new ValidPalindromStringReverse();
        String s = "Was it a car or a cat I saw?";
        System.out.println("Is Palindrome: " + solution.isPalindrome(s));
    }

    public static String reverse(String s) {
        // Pattern: String Reverse | Time: O(n), Space: O(n)
        if (s == null || s.length() <= 1) return s;
        char[] ca = s.toCharArray();
        for (int i = 0, j = ca.length - 1; i < j; i++, j--) {
            char t = ca[i]; ca[i] = ca[j]; ca[j] = t;
        }
        return new String(ca);
    }
}
