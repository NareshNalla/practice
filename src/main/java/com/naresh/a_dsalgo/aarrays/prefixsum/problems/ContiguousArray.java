package com.naresh.a_dsalgo.aarrays.prefixsum.problems;

import java.util.HashMap;
import java.util.Map;

public class ContiguousArray {

    /**
     * Finds the maximum length of a contiguous subarray with an equal number of 0 and 1.
     * 
     * Approach: Prefix Sum + HashMap
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     *
     * Logic:
     * 1. Treat 0 as -1 and 1 as +1.
     * 2. The problem becomes finding the longest subarray with a sum of 0.
     * 3. Use a HashMap to store the FIRST occurrence of a cumulative sum.
     * 4. If the same sum is encountered again, the subarray between those indices has a net sum of 0.
     */
    public static int findMaxLength(int[] nums) {
        if (nums == null || nums.length < 2) return 0;

        int maxLength = 0,  currentSum = 0;
        // Key: cumulative sum, Value: first index where this sum occurred
        Map<Integer, Integer> map = new HashMap<>();
        // Base case: a sum of 0 occurs before index 0 (at index -1)
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            // Treat 0 as -1
            currentSum += (nums[i] == 1) ? 1 : -1;
            if (map.containsKey(currentSum)) {
                // We've seen this sum before. Calculate length between first occurrence and current.
                maxLength = Math.max(maxLength, i - map.get(currentSum));
            } else {
                // Store only the FIRST occurrence to maximize subarray length
                map.put(currentSum, i);
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        // Test cases
        int[] nums1 = {0, 1};
        System.out.println("Input: [0, 1] | Max Length: " + findMaxLength(nums1)); // Expected: 2

        int[] nums2 = {0, 1, 0};
        System.out.println("Input: [0, 1, 0] | Max Length: " + findMaxLength(nums2)); // Expected: 2

        int[] nums3 = {0, 0, 1, 0, 0, 0, 1, 1};
        System.out.println("Input: [0, 0, 1, 0, 0, 0, 1, 1] | Max Length: " + findMaxLength(nums3)); // Expected: 6 ([1, 0, 0, 0, 1, 1] or others)
        
        int[] nums4 = {0, 1, 1, 0, 1, 1, 1, 0};
        System.out.println("Input: [0, 1, 1, 0, 1, 1, 1, 0] | Max Length: " + findMaxLength(nums4)); // Expected: 4
    }
}
