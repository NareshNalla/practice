package com.naresh.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Demonstrates modern ways to convert an ArrayList to a String in Java.
 */
public class ArrayListToStringConverter {

    public static void main(String[] args) {
        List<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Cherry");

        System.out.println("Original ArrayList: " + fruits);
        System.out.println("---");

        // --- Method 1: String.join() (Java 8+) ---
        // Clean, simple, and highly readable. Best for direct conversion.
        String result1 = String.join(", ", fruits);
        System.out.println("1. Using String.join():");
        System.out.println(result1); // Output: Apple, Banana, Cherry
        System.out.println("---");


        // --- Method 2: Collectors.joining() (Java 8+ Streams) ---
        // Very powerful when you are already working with a stream and need to join.
        String result2 = fruits.stream()
                               .map(String::toUpperCase) // Example of an intermediate stream operation
                               .collect(Collectors.joining(" | "));
        System.out.println("2. Using Stream Collectors.joining():");
        System.out.println(result2); // Output: APPLE | BANANA | CHERRY
        System.out.println("---");


        // --- Method 3: The Default toString() Method ---
        // Quick for debugging, but the format is fixed and includes brackets.
        String result3 = fruits.toString();
        System.out.println("3. Using default toString():");
        System.out.println(result3); // Output: [Apple, Banana, Cherry]
        System.out.println("---");
    }
}
