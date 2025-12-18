package com.naresh.collections.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 🔹 Q5. Given a list of integers, how do you separate the elements into two
 * lists — one containing duplicates and the other containing unique elements
 * using Java 8?
 */
public class Q5_SeparateDuplicatesAndUniques {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 1, 2, 4, 5);

        // Logic:
        // 1. Create a frequency map of the elements.
        Map<Integer, Long> frequencyMap = list.stream()
                .collect(Collectors.groupingBy(i -> i, Collectors.counting()));

        // 2. Filter the map's entry set to find duplicates (count > 1).
        List<Integer> duplicates = frequencyMap.entrySet().stream()
                .filter(e -> e.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        // 3. Filter the map's entry set to find unique elements (count == 1).
        List<Integer> unique = frequencyMap.entrySet().stream()
                .filter(e -> e.getValue() == 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        System.out.println("Original List: " + list);
        System.out.println("Duplicates: " + duplicates);
        System.out.println("Unique: " + unique);
    }
}
