package com.naresh.a_dsalgo.dp.dp1;

/**
 * Problem: Decode Ways
 * Description: A message containing letters from A-Z can be encoded into numbers using A=1, B=2, ..., Z=26.
 * Given a string s containing only digits, return the number of ways to decode it.
 */
public class DecodeWays {
    /**
     * Algorithm: Iterative DP with two variables. dp[i] depends on s[i] and s[i-1:i+1].
     */
    public int numDecodings(String s) {
        // Pattern: DP (Space Optimized) | Time: O(n), Space: O(1)
        if (s.charAt(0) == '0') return 0; // Leading zero is invalid
        
        int one = 1;  // Ways to decode up to current position
        int two = 1;  // Ways to decode up to previous position
        
        for (int i = 1; i < s.length(); i++) {
            int current = 0;
            
            if (s.charAt(i) != '0') {
                current = one; // Single digit decode
            }
            
            int twoDigitValue = Integer.parseInt(s.substring(i - 1, i + 1));
            if (twoDigitValue >= 10 && twoDigitValue <= 26) {
                current = current + two; // Two digit decode
            }
            
            two = one;
            one = current;
        }
        
        return one;
    }

    public static void main(String[] args) {
        var s = "226";
        var result = new DecodeWays().numDecodings(s);
        System.out.println("Decodings for '" + s + "': " + result);
    }

    /*
     * Dry Run:
     * Input: s = "226"
     *
     * 1. Initialization: one=1, two=1
     * 2. i=1 (char='2'): current = one (since '2' != '0') + two (since 22 valid) = 2
     *    i=2 (char='6'): current = one (since '6' != '0') + two (since 26 valid) = 2 + 1 = 3
     * 3. Result: 3
     */
    // FAANG Tip: Handle '0' carefully. A leading '0' or an invalid '0' (like '30') makes the string undecodable.
}
