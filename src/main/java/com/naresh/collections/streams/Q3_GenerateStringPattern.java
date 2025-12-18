package com.naresh.collections.streams;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 🔹 Q3. Given s = "abcd", how do you generate the pattern
 * "abbcccdddd" using Java 8 Streams?
 */
public class Q3_GenerateStringPattern {
    public static void main(String[] args) {
        String s = "abcd";

        // Logic:
        // 1. Generate an IntStream of indices from 0 to length-1.
        // 2. For each index `i`, get the character `s.charAt(i)`.
        // 3. Repeat that character `i + 1` times.
        // 4. Collect all the resulting strings and join them together.
        String result = IntStream.range(0, s.length())
                .mapToObj(i -> String.valueOf(s.charAt(i)).repeat(i + 1))
                .collect(Collectors.joining());

        System.out.println(result);
    }
}
SOLID principles are five design guidelines that help developers avoid 'code rot.' By ensuring that each class has a single responsibility, is extensible without modification, maintains substitutable inheritance, uses lean interfaces, and depends on abstractions rather than concrete details, we create software that is robust, easy to maintain, and simple to scale."