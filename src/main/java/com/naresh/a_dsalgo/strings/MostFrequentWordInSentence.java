package com.naresh.a_dsalgo.strings;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Find the most frequent word in a sentence using Java Streams.
 * Demonstrates efficient stream-based approach vs traditional approach.
 */
public class MostFrequentWordInSentence {

    /**
     * Pattern: Stream API with Collectors
     * Time: O(n), Space: O(k) where k is number of unique words
     * Best Practice: Efficient, concise, and leverages Java Streams
     */
    public static String mostFrequentWordStream(String sentence) {
        // Steps:
        // 1. Split sentence into words using regex pattern (non-word characters as delimiters)
        // 2. Convert to lowercase for case-insensitive comparison
        // 3. Group words by their value and count occurrences
        // 4. Find the word with maximum frequency
        // 5. Return the word or handle empty case

        return Arrays.stream(sentence.toLowerCase().split("\\W+"))  // Split by non-word characters
                .filter(word -> !word.isEmpty())                     // Filter out empty strings
                .collect(Collectors.groupingBy(                       // Group words
                        String::toString,
                        Collectors.counting()                         // Count frequency
                ))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())                   // Find max by frequency
                .map(Map.Entry::getKey)
                .orElse("");                                          // Return empty string if no words
    }

    /**
     * Alternative 1: Using toMap for more explicit control
     * Time: O(n), Space: O(k)
     */
    public static String mostFrequentWordToMap(String sentence) {
        // Steps:
        // 1. Split and filter words
        // 2. Collect into a Map with word as key and frequency as value
        // 3. Find entry with max frequency
        // 4. Return the word

        return Arrays.stream(sentence.toLowerCase().split("\\W+"))
                .filter(word -> !word.isEmpty())
                .collect(Collectors.toMap(
                        String::toString,
                        w -> 1L,
                        Long::sum                                     // Merge function: sum frequencies
                ))
                .entrySet()
                .stream()
                .max(Comparator.comparingLong(Map.Entry::getValue))
                .map(Map.Entry::getKey)
                .orElse("");
    }

    /**
     * Alternative 2: Manual HashMap (Traditional approach for comparison)
     * Time: O(n), Space: O(k)
     * Useful: When you need more control or not using streams
     */
    public static String mostFrequentWordTraditional(String sentence) {
        // Steps:
        // 1. Split sentence into words
        // 2. Iterate through words and count in HashMap
        // 3. Track word with max frequency
        // 4. Return the word with highest frequency

        String[] words = sentence.toLowerCase().split("\\W+");
        Map<String, Integer> wordFreq = new HashMap<>();

        for (String word : words) {
            if (!word.isEmpty()) {
                wordFreq.put(word, wordFreq.getOrDefault(word, 0) + 1);
            }
        }

        return wordFreq.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("");
    }

    /**
     * Alternative 3: Using LinkedHashMap for frequency ordering
     * Time: O(n log k), Space: O(k)
     * Useful: When you need sorted output
     */
    public static String mostFrequentWordSorted(String sentence) {
        // Steps:
        // 1. Group and count words
        // 2. Sort by frequency in descending order
        // 3. Return first word (most frequent)

        return Arrays.stream(sentence.toLowerCase().split("\\W+"))
                .filter(word -> !word.isEmpty())
                .collect(Collectors.groupingBy(
                        String::toString,
                        Collectors.counting()
                ))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse("");
    }

    /**
     * Alternative 4: Get Top K most frequent words
     * Time: O(n + k log n), Space: O(k)
     * Useful: Interview extension question
     */
    public static List<String> topKFrequentWords(String sentence, int k) {
        // Steps:
        // 1. Group and count words
        // 2. Sort by frequency in descending order
        // 3. Take first k words
        // 4. Return as list

        return Arrays.stream(sentence.toLowerCase().split("\\W+"))
                .filter(word -> !word.isEmpty())
                .collect(Collectors.groupingBy(
                        String::toString,
                        Collectors.counting()
                ))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(k)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        String sentence = "Hello world hello java world java java streams are powerful streams";

        System.out.println("Input Sentence: " + sentence);
        System.out.println();

        // Method 1: Stream Grouping (Best Practice)
        System.out.println("Most Frequent Word (Stream Grouping): " + mostFrequentWordStream(sentence));

        // Method 2: ToMap
        System.out.println("Most Frequent Word (ToMap): " + mostFrequentWordToMap(sentence));

        // Method 3: Traditional HashMap
        System.out.println("Most Frequent Word (Traditional): " + mostFrequentWordTraditional(sentence));

        // Method 4: Sorted
        System.out.println("Most Frequent Word (Sorted): " + mostFrequentWordSorted(sentence));

        // Method 5: Top K (Extension)
        System.out.println("Top 3 Most Frequent Words: " + topKFrequentWords(sentence, 3));

        // Edge Cases
        System.out.println("\n--- Edge Cases ---");
        System.out.println("Empty String: " + mostFrequentWordStream(""));
        System.out.println("Single Word: " + mostFrequentWordStream("hello"));
        System.out.println("Special Chars: " + mostFrequentWordStream("hello!!! world??? hello..."));
    }
}

/**
 * KEY POINTS FOR INTERVIEWS:
 *
 * 1. REGEX PATTERN: "\\W+" splits by any non-word character (spaces, punctuation, etc.)
 *    - More robust than simple split(" ")
 *
 * 2. COLLECTORS.GROUPING_BY: Perfect for frequency counting
 *    - Groups elements and counts occurrences
 *    - Returns Map<String, Long>
 *
 * 3. STREAM CHAINING: Powerful and concise
 *    - Easier to read and maintain than nested loops
 *
 * 4. TIME COMPLEXITY: O(n) for single pass with streams
 *
 * 5. SPACE COMPLEXITY: O(k) for unique words storage
 *
 * 6. EXTENSION: Can be modified to return top K frequent words
 *
 * 7. LIMITATION: Streams are lazy but collect() forces terminal operation
 *    - For very large datasets, consider chunking or parallel streams
 *
 * 8. CASE SENSITIVITY: toLowerCase() ensures case-insensitive matching
 *    - Remove if case matters
 *
 * 9. BEST PRACTICE: mostFrequentWordStream() using groupingBy + max
 *    - Clean, idiomatic Java
 *    - Easy to understand and explain
 *
 * 10. INTERVIEWER QUESTIONS:
 *     - "Can you handle special characters?" ✓ Using \\W+
 *     - "What about case sensitivity?" ✓ Using toLowerCase()
 *     - "Time and space complexity?" ✓ O(n) time, O(k) space
 *     - "Can you get top K?" ✓ See topKFrequentWords
 *     - "Without streams?" ✓ See mostFrequentWordTraditional
 */

