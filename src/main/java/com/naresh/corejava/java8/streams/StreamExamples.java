package com.naresh.corejava.java8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamExamples {

    public static void main(String[] args) {
        // Example 1: Filter a list and collect the results
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David", "Eve");
        List<String> longNames = names.stream()
                .filter(name -> name.length() > 4)
                .collect(Collectors.toList());
        System.out.println("Names with more than 4 characters: " + longNames);

        // Example 2: Map elements to a different type
        List<Integer> nameLengths = names.stream()
                .map(String::length)
                .collect(Collectors.toList());
        System.out.println("Lengths of names: " + nameLengths);

        // Example 3: Find the first element that matches a condition
        String firstNameWithD = names.stream()
                .filter(name -> name.startsWith("D"))
                .findFirst()
                .orElse("No name found");
        System.out.println("First name starting with 'D': " + firstNameWithD);

        // Example 4: Check if any element matches a condition
        boolean anyNameStartsWithA = names.stream()
                .anyMatch(name -> name.startsWith("A"));
        System.out.println("Any name starts with 'A': " + anyNameStartsWithA);

        // Example 5: Count elements that match a condition
        long countOfNamesWithE = names.stream()
                .filter(name -> name.contains("e"))
                .count();
        System.out.println("Number of names containing 'e': " + countOfNamesWithE);

        // Example 6: Reduce a list to a single value
        String concatenatedNames = names.stream()
                .reduce("", (a, b) -> a + " " + b);
        System.out.println("Concatenated names: " + concatenatedNames.trim());
    }
}
