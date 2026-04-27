package com.naresh.a_dsalgo.aa_arrays.problems;

import java.util.Arrays;

public class RotateArrayByK {

    /**
     * Rotates an array to the right by k steps.
     * Approach: Using Reversals
     * Time Complexity: O(N) - Each element is reversed at most K times.
     * Space Complexity: O(1) - In-place rotation.
     *
     * Algorithm:
     * 1. Normalize k: k can be greater than n, so k = k % n.
     * 2. Reverse the entire array.
     * 3. Reverse the first k elements.
     * 4. Reverse the remaining n-k elements.
     *
     * Example: nums = [1,2,3,4,5,6,7], k = 3
     * 1. Original: [1,2,3,4,5,6,7]
     * 2. Reverse all: [7,6,5,4,3,2,1]
     * 3. Reverse first k (3) elements: [5,6,7,4,3,2,1]
     * 4. Reverse remaining n-k (4) elements: [5,6,7,1,2,3,4] -> Result
     */
    public static void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0) {
            return;
        }
        int n = nums.length;
        k = k % n; // Normalize k
        // If k is 0 after normalization, no rotation needed
        if (k == 0) {
            return;
        }
        // Step 1: Reverse the entire array
        reverse(nums, 0, n - 1);
        // Step 2: Reverse the first k elements
        reverse(nums, 0, k - 1);
        // Step 3: Reverse the remaining n-k elements
        reverse(nums, k, n - 1);
    }

    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        // Test cases
        int[] nums1 = {1, 2, 3, 4, 5, 6, 7};
        int k1 = 3;
        System.out.println("Original: " + Arrays.toString(nums1) + ", k = " + k1);
        rotate(nums1, k1);
        System.out.println("Rotated:  " + Arrays.toString(nums1)); // Expected: [5, 6, 7, 1, 2, 3, 4]
        System.out.println("---");

        int[] nums2 = {-1, -100, 3, 99};
        int k2 = 2;
        System.out.println("Original: " + Arrays.toString(nums2) + ", k = " + k2);
        rotate(nums2, k2);
        System.out.println("Rotated:  " + Arrays.toString(nums2)); // Expected: [3, 99, -1, -100]
        System.out.println("---");

        int[] nums3 = {1, 2};
        int k3 = 3; // k > n
        System.out.println("Original: " + Arrays.toString(nums3) + ", k = " + k3);
        rotate(nums3, k3);
        System.out.println("Rotated:  " + Arrays.toString(nums3)); // Expected: [2, 1]
        System.out.println("---");

        int[] nums4 = {1};
        int k4 = 0;
        System.out.println("Original: " + Arrays.toString(nums4) + ", k = " + k4);
        rotate(nums4, k4);
        System.out.println("Rotated:  " + Arrays.toString(nums4)); // Expected: [1]
        System.out.println("---");

        int[] nums5 = {1, 2, 3, 4, 5};
        int k5 = 5; // k = n
        System.out.println("Original: " + Arrays.toString(nums5) + ", k = " + k5);
        rotate(nums5, k5);
        System.out.println("Rotated:  " + Arrays.toString(nums5)); // Expected: [1, 2, 3, 4, 5]
        System.out.println("---");
    }
}
