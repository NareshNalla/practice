package com.naresh.b_concepts.collections.streams;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 🔹Q2. Given a String, how do you find the character with the
 * second-highest frequency using Java 8 Streams?
 * (For example: "abbcccd" → b=2)
 */
public class Q2_SecondHighestFrequencyChar {
    public static void main(String[] args) {
        // Test case 1: "abbcccd" → c=3, b=2, a=1, d=1 → Answer: b (second highest = 2)
        try {
            Character result = findSecondHighestFrequencyChar("abbcccd");
            System.out.println("Second highest frequency in 'abbcccd': " + result + " (expected: b)");
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }
        
        // Test case 2: "abcdeabca" → a=3, b=2, c=2, d=1, e=1 → Answer: b or c (tied at 2, first encountered)
        try {
            Character result = findSecondHighestFrequencyChar("abcdeabca");
            System.out.println("Second highest frequency in 'abcdeabca': " + result + " (expected: b or c)");
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }
        
        // Test case 3: Edge case - single character
        try {
            Character result = findSecondHighestFrequencyChar("a");
            System.out.println("Second highest frequency in 'a': " + result);
        } catch (IllegalArgumentException e) {
            System.err.println("✓ Edge case handled - Error: " + e.getMessage());
        }
    }

    /**
     * Find the character with the second-highest frequency.
     * Time: O(n log n), Space: O(n)
     * 
     * Interview Tips:
     * 1. Use orElseThrow() instead of .get() for safe null handling.
     * 2. Filter out impossible cases upfront (null, empty, single char).
     * 3. Use map() to extract only the key we need.
     * 4. Sort in descending order for clarity.
     * 
     * @param s Input string
     * @return Character with second-highest frequency
     * @throws IllegalArgumentException if string is null or has fewer than 2 unique characters
     */
    public static Character findSecondHighestFrequencyChar(String s) {
        if (s == null || s.isEmpty()) {
            throw new IllegalArgumentException("Input string cannot be null or empty");
        }
        
        // Pattern: Streams + Grouping | Time: O(n log n), Space: O(n)
        return s.chars()
                .mapToObj(c -> (char) c) // Convert IntStream to Stream<Character>
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())) // Group by char, count occurrences
                .entrySet()
                .stream()
                .sorted(Map.Entry.<Character, Long>comparingByValue().reversed()) // Sort by frequency descending
                .skip(1) // Skip the highest, move to second
                .map(Map.Entry::getKey) // Extract only the character key
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No second-highest frequency found")); // Safe extraction
    }
}
