package com.naresh.collections.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 🔹 Q7. From a list of Strings, how do you remove the words that contain
 * any numeric digits using Java 8?
 * (Example: "ab1c" should be removed)
 */
public class Q7_RemoveStringsWithDigits {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("abc", "ab1c", "hello", "h3i");

        // Logic:
        // 1. Create a stream from the list.
        // 2. Filter the stream, keeping only the strings that do NOT match the regex.
        //    The regex ".*\\d.*" means "any characters, followed by a digit, followed by any characters".
        // 3. Collect the results into a new list.
        List<String> result = list.stream()
                .filter(s -> !s.matches(".*\\d.*"))
                .collect(Collectors.toList());

        System.out.println("Original List: " + list);
        System.out.println("Filtered List: " + result);
    }
}
