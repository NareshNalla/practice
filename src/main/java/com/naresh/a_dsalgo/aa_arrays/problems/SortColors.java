package com.naresh.a_dsalgo.aa_arrays.problems;

import java.util.Arrays;

/**
 * Problem: Sort Colors (Dutch National Flag)
 * Description: Sort an array with 0s, 1s, and 2s in-place in a single pass.
 */
public class SortColors {

    /**
     * Algorithm: Three-way partitioning using low, mid, and high pointers.
     */
    public static void sortColors(int[] nums) {
        // Pattern: Three-way Partitioning | Time: O(n), Space: O(1)
        if (nums == null || nums.length <= 1) return;

        int low = 0;          // Position for next 0
        int mid = 0;          // Current element scanner
        int high = nums.length - 1; // Position for next 2

        while (mid <= high) {
            if (nums[mid] == 0) {
                swap(nums, low, mid);
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else { // nums[mid] == 2
                swap(nums, mid, high);
                high--;
                // Note: We don't increment mid here because the swapped element
                // from 'high' needs to be evaluated.
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    // FAANG Tip: Explain that 'mid' isn't incremented on high-swap because the new element at 'mid' is unknown.

    public static void main(String[] args) {
        int[][] tests = {
            {2, 0, 2, 1, 1, 0},
            {2, 0, 1},
            {0, 1, 2},
            {2, 1, 0},
            {1, 1, 1}
        };

        for (int[] test : tests) {
            System.out.print("Original: " + Arrays.toString(test));
            sortColors(test);
            System.out.println(" -> Sorted: " + Arrays.toString(test));
        }
    }
}
