package com.naresh.a_dsalgo.sorting.implementation;

import java.util.Arrays;

/**
 * Selection Sort Implementation.
 * 
 * Thinking: In each iteration, find the minimum element from the unsorted part 
 * and put it at the beginning.
 * 
 * Time Complexity: 
 * - Best Case: O(n^2) 
 * - Average Case: O(n^2)
 * - Worst Case: O(n^2)
 * 
 * Space Complexity: O(1) - Sorting is done in-place.
 */
public class SelectionSort {

    public static void main(String[] args) {
        int[] a = {2, 4, 3, 7, 5, 1};
        sort(a);
        System.out.println("Sorted array: " + Arrays.toString(a));
    }

    /**
     * Sorts the array using Selection Sort algorithm.
     *
     * @param a The array to be sorted in-place.
     * @return The sorted array.
     */
    public static int[] sort(int[] a) {
        if (a == null || a.length <= 1) {
            return a;
        }

        int n = a.length;
        
        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n - 1; i++) {
            // Find the minimum element in unsorted array
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (a[j] < a[minIndex]) {
                    minIndex = j;
                }
            }

            // Swap the found minimum element with the first element of the unsorted part
            if (minIndex != i) {
                int temp = a[minIndex];
                a[minIndex] = a[i];
                a[i] = temp;
            }
        }
        return a;
    }
}
