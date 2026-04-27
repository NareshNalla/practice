package com.naresh.a_dsalgo.aa_arrays.twopointers;

import java.util.Arrays;
import java.util.Objects;

/**
 * Problem: Move all zeros in an array to the right while maintaining relative order of non-zero elements.
 */
public class MoveAllZeroRight {
    public static void main(String[] args) {
        int[] nums1 = {1, 0, 30, 40, 0, 25, 0};
        int[] nums2 = {1, 0, 30, 40, 0, 25, 0};

        System.out.println("Original: " + Arrays.toString(nums1));
        System.out.println("Swapping Approach: " + Arrays.toString(moveZerosRight(nums1)));
        System.out.println("Overwriting Approach: " + Arrays.toString(moveZeros(nums2)));
    }

    /**
     * Time Complexity: O(n) - Iterates through the array once.
     * Space Complexity: O(1) - Performs operations in-place.
     */
    private static int[] moveZerosRight(final int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        
        // j tracks the position where the next non-zero element should be swapped.
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                // Swap current non-zero element with the element at position j
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }
        }
        return nums;
    }

    /**
     * Approach 2: Overwrite non-zero elements and fill the rest with zeros.
     * Maintains relative order. Two passes (one for non-zeros, one for zeros).
     *
     * Time Complexity: O(n) - Total work is proportional to the size of the array.
     * Space Complexity: O(1) - Performs operations in-place.
     */
    private static int[] moveZeros(final int[] nums) {
        Objects.requireNonNull(nums, "Input array cannot be null");
        
        int insertPos = 0;
        // First pass: shift non-zero values to the front
        for (int num : nums) {
            if (num != 0) {
                nums[insertPos++] = num;
            }
        }
        
        // Second pass: fill the remaining indices with zeros
        while (insertPos < nums.length) {
            nums[insertPos++] = 0;
        }
        return nums;
    }
}
