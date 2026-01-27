package com.naresh.concepts.collections.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 🔹 Q10. How do you print the top 3 longest Strings from a list using Java 8
 * Streams?
 */
public class Q10_Top3LongestStrings {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("apple", "banana", "cherry", "watermelon", "kiwi", "strawberry");

        // Logic:
        // 1. Create a stream from the list.
        // 2. Sort the stream by string length in descending order.
        //    - Comparator.comparingInt(String::length) creates a comparator based on length.
        //    - .reversed() reverses the natural (ascending) order.
        // 3. Limit the stream to the first 3 elements.
        // 4. Print each of the remaining elements.
        list.stream()
                .sorted(Comparator.comparingInt(String::length).reversed())
                .limit(3)
                .forEach(System.out::println);
    }
}
