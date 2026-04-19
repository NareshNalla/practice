package com.naresh.a_dsalgo.strings.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * A brute-force String Compresses,  a string using a List to store characters and counts.
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

    public static String compressString(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }

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
