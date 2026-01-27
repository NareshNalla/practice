package com.naresh.concepts.collections.streams;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 🔹 Q8. Given a String, how do you find the character with the highest
 * frequency?
 */
public class Q8_HighestFrequencyChar {
    public static void main(String[] args) {
        String s = "bbaaac";

        // Logic:
        // 1. Create a frequency map of characters.
        Map<Character, Long> frequencyMap = s.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        // 2. Find the entry with the maximum value (frequency).
        frequencyMap.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .ifPresent(entry -> System.out.println(entry.getKey() + "=" + entry.getValue()));
    }
}
