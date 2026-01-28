package com.naresh.problems.strings;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * A brute-force string compression implementation using Java Collections.
 */
public class StringCompressionCollections {

    public static void main(String[] args) {
        String str1 = "AABBCCCCDAA";
        String compressed1 = compressString(str1);
        System.out.println("Original: " + str1);
        System.out.println("Compressed: " + compressed1); // Expected: A2B2C4D1A2

        String str2 = "ABCDE";
        String compressed2 = compressString(str2);
        System.out.println("Original: " + str2);
        System.out.println("Compressed: " + compressed2); // Expected: ABCDE (since compressed is longer)
    }

    /**
     * Compresses a string using a List to store characters and counts.
     * This is a brute-force approach demonstrating the use of collections.
     *
     * @param str The string to compress.
     * @return The compressed string, or the original if compression is not smaller.
     */
    public static String compressString(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }

        // This list will store alternating characters and their integer counts.
        // e.g., for "AAB", it will become ['A', 2, 'B', 1]
        List<Object> compressedList = new ArrayList<>();

        for (char c : str.toCharArray()) {
            // Check if the list is not empty and the last character added is the same as the current one.
            if (!compressedList.isEmpty() && compressedList.get(compressedList.size() - 2).equals(c)) {
                // If so, increment the count.
                int lastCountIndex = compressedList.size() - 1;
                int currentCount = (int) compressedList.get(lastCountIndex);
                compressedList.set(lastCountIndex, currentCount + 1);
            } else {
                // Otherwise, add the new character and a count of 1.
                compressedList.add(c);
                compressedList.add(1);
            }
        }

        // Use a stream to join the list of objects (Characters and Integers) into a final string.
        return compressedList.stream()
                .map(Object::toString)
                .collect(Collectors.joining());


    }
}
