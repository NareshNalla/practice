package com.naresh.concepts.collections.streams;

import java.util.Arrays;
import java.util.List;

/**
 * 🔹Q1. How do you retrieve the 5th element from a List in Java 8?
 */
public class Q1_FindFifthElement {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("a", "b", "c", "d", "e", "f");

        // Logic:
        // .skip(4) skips the first 4 elements (0, 1, 2, 3).
        // .findFirst() gets the next element, which is the 5th one (index 4).
        // .orElse(null) handles the case where the list has fewer than 5 elements.
        String result = list.stream()
                .skip(4)
                .findFirst()
                .orElse(null);

        System.out.println(result);
    }
}
