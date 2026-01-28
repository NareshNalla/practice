package com.naresh.interview.coding;

import java.util.*;
import java.util.regex.Pattern;

/**
 * Finds the maximum integer value embedded within a string.
 * Time Complexity: O(N)
 * Space Complexity: O(N) due to split array
 */
public class MaxIntValueInString {

    public static void main(String[] args) {
        System.out.println(findMaxIntValueAlt("a12b34c5")); // 34
        System.out.println(findMaxIntValueAlt("50abc5")); // 50
        System.out.println(findMaxIntValue("100abc200")); // 200
        System.out.println(findMaxIntValueOptimized("a12b34c5")); // 34
    }

    public static int findMaxIntValue(String input) {
        if (input == null || input.isEmpty()) return Integer.MIN_VALUE;

        return Arrays.stream(input.split("\\D+")) // Split by non-digits
                .filter(s -> !s.isEmpty())        // Remove empty strings
                .mapToInt(Integer::parseInt)      // Convert to int
                .max()                            // Find max
                .orElse(Integer.MIN_VALUE);       // Default if no numbers
    }
    public static int findMaxIntValueAlt(String input) {
        if (input == null || input.isEmpty()) return Integer.MIN_VALUE;

        // 1. Initialize HashMap with 0-9
        Set<Character> digits = new HashSet<>();
        for (char c = '0'; c <= '9'; c++) {
            digits.add(c);
        }

        int maxVal = Integer.MIN_VALUE;
        String temp = ""; // Holds the current number string

        // 2. Loop through char array
        for (char c : input.toCharArray()) {
            // 3. Find char in map
            if (digits.contains(c)) {
                temp += c; // Concat
                if (Integer.parseInt(temp) > maxVal) {
                    maxVal = Integer.parseInt(temp);
                }
            } else {
                temp = ""; // Reset to empty string
            }
        }

        return maxVal;
    }

    public static int findMaxIntValueOptimized(String input) {
        if (input == null || input.isEmpty()) return Integer.MIN_VALUE;

        // Using ArrayList for validation (O(1) lookup effectively since size is small and fixed)
        List<Character> digits = new ArrayList<>();
        for (char c = '0'; c <= '9'; c++) {
            digits.add(c);
        }

        int maxVal = Integer.MIN_VALUE;
        StringBuilder temp = new StringBuilder(); // StringBuilder is O(N) vs String += which is O(N^2)

        for (char c : input.toCharArray()) {
            if (digits.contains(c)) {
                temp.append(c);
            } else {
                if (temp.length() > 0) {
                    try {
                        int val = Integer.parseInt(temp.toString());
                        if (val > maxVal) maxVal = val;
                    } catch (NumberFormatException e) {
                        maxVal = Integer.MAX_VALUE;
                    }
                    temp.setLength(0); // Clear builder
                }
            }
        }
        
        // Check last number
        if (temp.length() > 0) {
            try {
                int val = Integer.parseInt(temp.toString());
                if (val > maxVal) maxVal = val;
            } catch (NumberFormatException e) {
                maxVal = Integer.MAX_VALUE;
            }
        }

        return maxVal;
    }
}
