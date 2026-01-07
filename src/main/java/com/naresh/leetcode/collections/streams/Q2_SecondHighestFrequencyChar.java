package com.naresh.leetcode.collections.streams;

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
        String s = "abbcccd";

        // Logic:
        // 1. Create a frequency map of characters.
        Map<Character, Long> frequencyMap = s.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        // 2. Find the character with the second-highest frequency.
        //    - Get the entry set of the map.
        //    - Sort the entries by value (frequency) in descending order.
        //    - Skip the first entry (which is the highest).
        //    - Find the next entry (which is the second highest).
        frequencyMap.entrySet().stream()
                .sorted(Map.Entry.<Character, Long>comparingByValue().reversed())
                .skip(1)
                .findFirst()
                .ifPresent(entry -> System.out.println(entry.getKey() + "=" + entry.getValue()));
    }
}
