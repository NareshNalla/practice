package com.naresh.concepts.collections.streams;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 🔹 Q9. Given a sentence, how do you find duplicate words along with their
 * occurrence count, sorted by frequency in descending order?
 */
public class Q9_DuplicateWordsByFrequency {
    public static void main(String[] args) {
        String sentence = "Java is great and Java is popular and Java is powerful";

        // Logic:
        // 1. Split the sentence into words.
        // 2. Create a frequency map of the words.
        // 3. Stream the entry set of the map.
        // 4. Filter to keep only the words with a count greater than 1 (duplicates).
        // 5. Sort the remaining entries by value (frequency) in descending order.
        // 6. Print each resulting entry.
        Arrays.stream(sentence.split(" "))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .forEach(entry -> System.out.println(entry.getKey() + "=" + entry.getValue()));
    }
}
