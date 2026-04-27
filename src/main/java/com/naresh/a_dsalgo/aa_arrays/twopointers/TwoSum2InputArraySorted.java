package com.naresh.a_dsalgo.aa_arrays.twopointers;

import java.util.Arrays;

/**
 * Problem: Two Sum II - Input Array Is Sorted
 * Description: Find two numbers in a sorted array that add up to a specific target.
 */
public class TwoSum2InputArraySorted {
    /**
     * Algorithm: Initialize two pointers at start (left) and end (right). Move pointers 
     * inward based on the comparison of current sum vs target.
     */
    public static int[] twoSum(int[] numbers, int target) {
        // Pattern: Two Pointers | Time: O(n), Space: O(1)
        if (numbers == null || numbers.length < 2) return new int[]{-1, -1};
        var left = 0;
        var right = numbers.length - 1;
        while (left < right) {
            var currentSum = numbers[left] + numbers[right];
            if (currentSum == target) return new int[]{left + 1, right + 1};
            if (currentSum < target) left++; else right--; // Shrink window
        }
        return new int[]{-1, -1};
    }
    // FAANG Tip: Sorted input allows O(1) space optimization over hashing. Mention overflow handling and 1-based indexing requirements.

    public static void main(String[] args) {
        var nums1 = new int[]{2, 7, 11, 15};
        var target1 = 9;
        System.out.println("Test 1 Result: " + Arrays.toString(twoSum(nums1, target1)));
    }
}
