package com.naresh.a_dsalgo.astrings.problems;

import java.util.Arrays;

public class StringCompression {
    public static void main(String[] args) {
        String s = "AABBCCCCDAA";
        System.out.println("Result: " + compressStringBuilder(s));
        char[] chars = s.toCharArray();
        int len = compressInPlace(chars);
        System.out.println("In-Place: " + new String(Arrays.copyOf(chars, len)));
    }

    public static String compressStringBuilder(String s) {
        // Pattern: Two-Pointer / String Building | Time: O(n), Space: O(n)
        if (s == null || s.isEmpty()) return s;
        var sb = new StringBuilder();
        for (int i = 0; i < s.length(); ) {
            char c = s.charAt(i); int count = 0;
            while (i < s.length() && s.charAt(i) == c) {
                count++; i++;
            }
            sb.append(c).append(count);
        }
        return sb.length() < s.length() ? sb.toString() : s;
    }

    public static int compressInPlace(char[] chars) {
        // Pattern: Two-Pointer (Read/Write) | Time: O(n), Space: O(1)
        if (chars == null || chars.length == 0) return 0;
        int write = 0, read = 0;
        while (read < chars.length) {
            char c = chars[read]; int count = 0;
            while (read < chars.length && chars[read] == c) {
                read++; count++;
            }
            chars[write++] = c;
            if (count > 1)
                for (char digit : String.valueOf(count).toCharArray())
                    chars[write++] = digit;
        }
        return write;
    }
}
