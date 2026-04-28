package com.naresh.a_dsalgo.ab_strings.problems;

import java.util.*;

/**
 * Problem: String Encode and Decode
 * Description: Design an algorithm to encode a list of strings to a string. The encoded string is then sent over the network and is decoded back to the original list of strings.
 */
public class EncodeDecode {
    public static void main(String[] args) {
        var list = List.of("hello", "world", "encode#decode", "123");
        String encoded = encode(list);
        System.out.println("Encoded: " + encoded);
        System.out.println("Decoded: " + decodeString(encoded));
    }

    /**
     * Algorithm: Use length-prefixing (length + '#' + string) to handle delimiters within strings.
     */
    public static String encode(List<String> strs) {
        // Pattern: Length-Prefixing | Time: O(n), Space: O(n)
        if (strs == null || strs.isEmpty()) return "";
        var sb = new StringBuilder();
        for (String s : strs)
            sb.append(s.length()).append("#").append(s);
        return sb.toString();
    }

    /**
     * Algorithm: Find the '#' delimiter to extract length, then read exactly 'length' characters for the string.
     */
    public static List<String> decodeString(String s) {
        // Pattern: Length-Prefixing Parsing | Time: O(n), Space: O(n)
        if (s == null || s.isEmpty()) return new ArrayList<>();
        var res = new ArrayList<String>();
        int i = 0;
        while (i < s.length()) {
            int j = i;
            while (s.charAt(j) != '#') { // Find delimiter
                j++;
            }
            int len = Integer.parseInt(s.substring(i, j)); // Extract length
            i = j + 1; // Start of string
            j = i + len; // End of string
            res.add(s.substring(i, j));
            i = j; // Move to next prefix
        }
        return res;
    }
    // FAANG Tip: Length-prefixing is robust against delimiters appearing in the data. Using '#' as a separator for length allows strings of any length.
}

/**
 * Dry Run:
 * Input: s = "5#hello5#world13#encode#decode3#123"
 *
 * 1. Initialization:
 *    res = []
 *    i = 0
 *
 * 2. First Iteration (Processing "5#hello"):
 *    - i = 0, j = 0
 *    - s.charAt(0) = '5' (not '#'), j = 1
 *    - s.charAt(1) = '#' (loop ends)
 *    - len = Integer.parseInt(s.substring(0, 1)) = 5
 *    - i = 1 + 1 = 2
 *    - j = 2 + 5 = 7
 *    - res.add(s.substring(2, 7)) -> res.add("hello")
 *    - i = 7
 *    - res = ["hello"]
 *
 * 3. Second Iteration (Processing "5#world"):
 *    - i = 7, j = 7
 *    - s.charAt(7) = '5' (not '#'), j = 8
 *    - s.charAt(8) = '#' (loop ends)
 *    - len = Integer.parseInt(s.substring(7, 8)) = 5
 *    - i = 8 + 1 = 9
 *    - j = 9 + 5 = 14
 *    - res.add(s.substring(9, 14)) -> res.add("world")
 *    - i = 14
 *    - res = ["hello", "world"]
 *
 * 4. Third Iteration (Processing "13#encode#decode"):
 *    - i = 14, j = 14
 *    - s.charAt(14) = '1' (not '#'), j = 15
 *    - s.charAt(15) = '3' (not '#'), j = 16
 *    - s.charAt(16) = '#' (loop ends)
 *    - len = Integer.parseInt(s.substring(14, 16)) = 13
 *    - i = 16 + 1 = 17
 *    - j = 17 + 13 = 30
 *    - res.add(s.substring(17, 30)) -> res.add("encode#decode")
 *    - i = 30
 *    - res = ["hello", "world", "encode#decode"]
 *
 * 5. Fourth Iteration (Processing "3#123"):
 *    - i = 30, j = 30
 *    - s.charAt(30) = '3' (not '#'), j = 31
 *    - s.charAt(31) = '#' (loop ends)
 *    - len = Integer.parseInt(s.substring(30, 31)) = 3
 *    - i = 31 + 1 = 32
 *    - j = 32 + 3 = 35
 *    - res.add(s.substring(32, 35)) -> res.add("123")
 *    - i = 35
 *    - res = ["hello", "world", "encode#decode", "123"]
 *
 * 6. Loop End: i (35) is not less than s.length() (35).
 *
 * 7. Final Result: ["hello", "world", "encode#decode", "123"]
 */
