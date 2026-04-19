package com.naresh.a_dsalgo.sorting.implementation;

import java.util.Arrays;
import java.util.Objects;

/**
 * Counting Sort implementation.
 * Best used when the range of input values (k) is not significantly larger than the number of elements (n).
 * 
 * Time Complexity: O(n + k)
 * Space Complexity: O(k)
 */
public class CountingSort {

    public static void main(String[] args) {
        int[] a = {3, 2, 1, 5, 4, 1, 2};
        sort(a);
        System.out.println("Sorted integers: " + Arrays.toString(a));

        String s = "nareshnalla";
        char[] r = sortString(s);
        System.out.println("Sorted string:   " + new String(r));
    }

    /**
     * Sorts an integer array using Counting Sort.
     * This version handles any range of integers (including negative numbers) by finding min and max.
     *
     * @param a The array to be sorted in-place.
     */
    public static void sort(int[] a) {
        if (a == null || a.length <= 1) {
            return;
        }

        // 1. Find min and max to determine the range
        int min = a[0];
        int max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] < min) min = a[i];
            else if (a[i] > max) max = a[i];
        }

        int range = max - min + 1;
        // Use 'var' (Java 10+) for local variables
        var count = new int[range];

        // 2. Store count of each element
        for (int num : a) {
            count[num - min]++;
        }

        // 3. Reconstruct the original array (Stable for primitives)
        int current = 0;
        for (int i = 0; i < range; i++) {
            while (count[i] > 0) {
                a[current++] = i + min;
                count[i]--;
            }
        }
    }

    /**
     * Sorts characters in a string using Counting Sort.
     * Assumes standard ASCII/Extended ASCII (0-255).
     *
     * @param s The input string.
     * @return A new char array with sorted characters.
     */
    public static char[] sortString(String s) {
        Objects.requireNonNull(s, "Input string cannot be null");
        char[] ca = s.toCharArray();
        if (ca.length <= 1) {
            return ca;
        }

        // Standard ASCII range
        var count = new int[256];

        // Count character frequencies
        for (char c : ca) {
            count[c]++;
        }

        // Build the sorted char array
        int index = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                ca[index++] = (char) i;
                count[i]--;
            }
        }
        return ca;
    }
}
