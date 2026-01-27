package com.naresh.concepts.collections;

import java.util.ArrayList;
import java.util.List;

/**
 * Demonstrates the most performant, "manual" way to convert an ArrayList to a String,
 * and explains the trade-offs for an interview context.
 */
public class ArrayListToStringOptimized {

    public static void main(String[] args) {
        List<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Cherry");

        // The "manual" but most performant way using StringBuilder
        String result = convertWithStringBuilder(fruits, ", ");
        System.out.println("Manually converted with StringBuilder:");
        System.out.println(result);
    }

    /**
     * Converts a list of strings to a single string with a delimiter using a StringBuilder.
     * This is the most performant "from-scratch" implementation because it avoids
     * creating intermediate string objects.
     *
     * @param list The list of strings to join.
     * @param delimiter The delimiter to place between elements.
     * @return The joined string.
     */
    public static String convertWithStringBuilder(List<String> list, String delimiter) {
        // Handle edge cases
        if (list == null || list.isEmpty()) {
            return "";
        }

        // Use StringBuilder for efficient string construction
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
            // IMPORTANT: Only append delimiter if it's not the last element
            if (i < list.size() - 1) {
                sb.append(delimiter);
            }
        }
        return sb.toString();
    }
}
