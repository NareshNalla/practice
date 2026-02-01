package com.naresh.dsalgo.strings.problems;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * An optimized string compression implementation using a Java Stream pipeline.
 */
public class StringCompressionCollections2 {

    public static void main(String[] args) {
        String str1 = "AABBCCCCDAA";
        String compressed1 = compressString(str1);
        System.out.println("Original: " + str1);
        System.out.println("Compressed: " + compressed1); // Expected: A2B2C4D1A2

        String str2 = "ABCDE";
        String compressed2 = compressString(str2);
        System.out.println("Original: " + str2);
        System.out.println("Compressed: " + compressed2); // Expected: ABCDE

        String str3 = "AAABBA";
        String compressed3 = compressString(str3);
        System.out.println("Original: " + str3);
        System.out.println("Compressed: " + compressed3); // Expected: A3B2A1
    }

    /**
     * Compresses a string using an optimized stream pipeline.
     * This version avoids creating intermediate substrings for better performance.
     *
     * @param str The string to compress.
     * @return The compressed string, or the original if compression is not smaller.
     */
    public static String compressString(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }

        // This stream identifies the start of each character group and processes it.
        String compressedResult = IntStream.range(0, str.length())
                // Find the starting index of each new character group.
                .filter(i -> i == 0 || str.charAt(i) != str.charAt(i - 1))
                // For each starting index, determine the group's character and length.
                .mapToObj(startIndex -> {
                    char ch = str.charAt(startIndex);
                    int endIndex = startIndex + 1;
                    // More efficient: loop forward to find the end of the group
                    // instead of creating a new substring/stream.
                    while (endIndex < str.length() && str.charAt(endIndex) == ch) {
                        endIndex++;
                    }
                    return Map.entry(ch, (long) endIndex - startIndex);
                })
                // Convert each group (e.g., Entry<'A', 2>) into a string ("A2").
                .map(entry -> entry.getKey() + String.valueOf(entry.getValue()))
                // Join all the group strings together.
                .collect(Collectors.joining());

        // Return the original string if the compressed version is not smaller.
        return compressedResult.length() < str.length() ? compressedResult : str;
    }
}
