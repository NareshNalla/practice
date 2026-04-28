package com.naresh.a_dsalgo.ab_strings.problems;

import java.util.Arrays;

/**
 * Problem: String Compression
 * Description: Implement a method to perform basic string compression using the counts of repeated characters.
 * For example, the string "aabcccccaaa" would become "a2b1c5a3". If the compressed string is not smaller than the original string, return the original string.
 * Also includes an in-place version (LeetCode 443 style).
 */
public class StringCompression {
    public static void main(String[] args) {
        String s = "AABBCCCCDAA";
        System.out.println("StringBuilder Result: " + compressStringBuilder(s));
        char[] chars = s.toCharArray();
        int len = compressInPlace(chars);
        System.out.println("In-Place Result: " + new String(Arrays.copyOf(chars, len)));
    }

    /**
     * Algorithm: Traverse string once. Count consecutive characters and append to StringBuilder.
     */
    public static String compressStringBuilder(String s) {
        // Pattern: Two-Pointer / String Building | Time: O(n), Space: O(n)
        if (s == null || s.isEmpty()) return s;
        var sb = new StringBuilder();
        for (int i = 0; i < s.length(); ) {
            char c = s.charAt(i); int count = 0;
            while (i < s.length() && s.charAt(i) == c) { // Find run length
                count++; i++;
            }
            sb.append(c).append(count);
        }
        return sb.length() < s.length() ? sb.toString() : s;
    }
    // FAANG Tip: For immutable strings in Java, StringBuilder is essential to avoid O(n^2) time due to string concatenation.

    /**
     * Algorithm: Use 'read' and 'write' pointers. Read finds character runs, write updates the array in-place.
     */
    public static int compressInPlace(char[] chars) {
        // Pattern: Two-Pointer (Read/Write) | Time: O(n), Space: O(1)
        if (chars == null || chars.length == 0) return 0;
        int write = 0, read = 0;
        while (read < chars.length) {
            char c = chars[read]; int count = 0;
            while (read < chars.length && chars[read] == c) { // Count consecutive
                read++; count++;
            }
            chars[write++] = c;
            if (count > 1) { // Append count digits if > 1
                for (char digit : String.valueOf(count).toCharArray())
                    chars[write++] = digit;
            }
        }
        return write;
    }
    // FAANG Tip: In-place modification is a common constraint. Mention handling counts > 9 by converting to string/chars.
}

/**
 * Dry Run (StringBuilder):
 * Input: s = "AABBCCCCDAA"
 *
 * 1. Initialization:
 *    sb = "", i = 0
 *
 * 2. Iteration 1 (i = 0, char 'A'):
 *    - c = 'A', count = 0
 *    - Inner loop:
 *      - i=0, s.charAt(0)='A' == c. count=1, i=1.
 *      - i=1, s.charAt(1)='A' == c. count=2, i=2.
 *      - i=2, s.charAt(2)='B' != c. Loop ends.
 *    - sb.append('A').append(2) -> sb = "A2"
 *    - Current i = 2
 *
 * 3. Iteration 2 (i = 2, char 'B'):
 *    - c = 'B', count = 0
 *    - Inner loop:
 *      - i=2, s.charAt(2)='B' == c. count=1, i=3.
 *      - i=3, s.charAt(3)='B' == c. count=2, i=4.
 *      - i=4, s.charAt(4)='C' != c. Loop ends.
 *    - sb.append('B').append(2) -> sb = "A2B2"
 *    - Current i = 4
 *
 * 4. Iteration 3 (i = 4, char 'C'):
 *    - c = 'C', count = 0
 *    - Inner loop:
 *      - i=4, s.charAt(4)='C' == c. count=1, i=5.
 *      - i=5, s.charAt(5)='C' == c. count=2, i=6.
 *      - i=6, s.charAt(6)='C' == c. count=3, i=7.
 *      - i=7, s.charAt(7)='C' == c. count=4, i=8.
 *      - i=8, s.charAt(8)='D' != c. Loop ends.
 *    - sb.append('C').append(4) -> sb = "A2B2C4"
 *    - Current i = 8
 *
 * 5. Iteration 4 (i = 8, char 'D'):
 *    - c = 'D', count = 0
 *    - Inner loop:
 *      - i=8, s.charAt(8)='D' == c. count=1, i=9.
 *      - i=9, s.charAt(9)='A' != c. Loop ends.
 *    - sb.append('D').append(1) -> sb = "A2B2C4D1"
 *    - Current i = 9
 *
 * 6. Iteration 5 (i = 9, char 'A'):
 *    - c = 'A', count = 0
 *    - Inner loop:
 *      - i=9, s.charAt(9)='A' == c. count=1, i=10.
 *      - i=10, s.charAt(10)='A' == c. count=2, i=11.
 *      - i=11, i < s.length() (11 < 11) is false. Loop ends.
 *    - sb.append('A').append(2) -> sb = "A2B2C4D1A2"
 *    - Current i = 11
 *
 * 7. Outer loop ends (i = 11, s.length() = 11).
 *
 * 8. Final Check: sb.length() (10) < s.length() (11) is true.
 * 9. Result: "A2B2C4D1A2"
 */

/**
 * Dry Run (In-Place):
 * Input: chars = ['A', 'A', 'B', 'B', 'C', 'C', 'C', 'C', 'D', 'A', 'A']
 *
 * 1. Initialization:
 *    write = 0, read = 0
 *
 * 2. Process 'A' (Run 1):
 *    - c = 'A', count = 0
 *    - read loop: reads chars[0], chars[1]. read becomes 2, count becomes 2.
 *    - chars[write++] = 'A' -> chars[0] = 'A', write = 1
 *    - count (2) > 1: chars[write++] = '2' -> chars[1] = '2', write = 2
 *    - Current Array: ['A', '2', ...]
 *
 * 3. Process 'B' (Run 2):
 *    - c = 'B', count = 0
 *    - read loop: reads chars[2], chars[3]. read becomes 4, count becomes 2.
 *    - chars[write++] = 'B' -> chars[2] = 'B', write = 3
 *    - count (2) > 1: chars[write++] = '2' -> chars[3] = '2', write = 4
 *    - Current Array: ['A', '2', 'B', '2', ...]
 *
 * 4. Process 'C' (Run 3):
 *    - c = 'C', count = 0
 *    - read loop: reads chars[4..7]. read becomes 8, count becomes 4.
 *    - chars[write++] = 'C' -> chars[4] = 'C', write = 5
 *    - count (4) > 1: chars[write++] = '4' -> chars[5] = '4', write = 6
 *    - Current Array: ['A', '2', 'B', '2', 'C', '4', ...]
 *
 * 5. Process 'D' (Run 4):
 *    - c = 'D', count = 0
 *    - read loop: reads chars[8]. read becomes 9, count becomes 1.
 *    - chars[write++] = 'D' -> chars[6] = 'D', write = 7
 *    - count (1) !> 1.
 *    - Current Array: ['A', '2', 'B', '2', 'C', '4', 'D', ...]
 *
 * 6. Process 'A' (Run 5):
 *    - c = 'A', count = 0
 *    - read loop: reads chars[9], chars[10]. read becomes 11, count becomes 2.
 *    - chars[write++] = 'A' -> chars[7] = 'A', write = 8
 *    - count (2) > 1: chars[write++] = '2' -> chars[8] = '2', write = 9
 *    - Current Array: ['A', '2', 'B', '2', 'C', '4', 'D', 'A', '2']
 *
 * 7. Loop End: read (11) == chars.length
 * 8. Result: write = 9
 */
