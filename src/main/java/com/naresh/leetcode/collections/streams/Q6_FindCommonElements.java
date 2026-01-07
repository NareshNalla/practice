package com.naresh.leetcode.collections.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 🔹 Q6. How do you find common elements between two integer lists
 * using Java 8 Streams?
 */
public class Q6_FindCommonElements {
    public static void main(String[] args) {
        List<Integer> listA = Arrays.asList(1, 2, 3, 4);
        List<Integer> listB = Arrays.asList(2, 4, 6);

        // Logic:
        // 1. Create a stream from the first list.
        // 2. Use a filter to keep only the elements that are also contained in the second list.
        //    The method reference `listB::contains` is a concise way of writing `x -> listB.contains(x)`.
        // 3. Collect the results into a new list.
        List<Integer> commonElements = listA.stream()
                .filter(listB::contains)
                .collect(Collectors.toList());

        System.out.println("List A: " + listA);
        System.out.println("List B: " + listB);
        System.out.println("Common Elements: " + commonElements);
    }
}
