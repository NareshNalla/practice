package com.naresh.a_dsalgo.aa_arrays.problems;

import java.util.Arrays;

/**
 * Dutch National Flag Algorithm - Sort Colors (0s, 1s, and 2s)
 * Time Complexity: O(N) - Single pass
 * Space Complexity: O(1)
 */
public class SortColors {

    public static void sortColors(int[] nums) {
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
