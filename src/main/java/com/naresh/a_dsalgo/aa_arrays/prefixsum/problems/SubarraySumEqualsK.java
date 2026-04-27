package com.naresh.a_dsalgo.aa_arrays.prefixsum.problems;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {

    /**
     * Finds the total number of continuous subarrays whose sum equals k.
     * 
     * Optimal Approach: Prefix Sum + HashMap
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     *
     * Logic:
     * sum[i] - sum[j] = k  =>  sum[j] = sum[i] - k
     * If we store the count of prefix sums in a map, we can check how many times 
     * 'currentSum - k' has occurred before.
     */
    public static int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        int count = 0 ,  currentSum = 0;
        // Key: Prefix Sum, Value: Count of occurrences
        Map<Integer, Integer> prefixSumMap = new HashMap<>();
        // Base case: a prefix sum of 0 has occurred once (empty subarray)
        prefixSumMap.put(0, 1);
        for (int num : nums) {
            currentSum += num; //currentSum = currentSum + num;
            // If (currentSum - k) exists in map, it means there's a subarray ending at
            // the current index that sums to k.
            if (prefixSumMap.containsKey(currentSum - k)) {
                count += prefixSumMap.get(currentSum - k);
            }
            // Update the map with the current prefix sum
            prefixSumMap.merge(currentSum, 1, Integer::sum);
        }
        return count;
    }

    /**
     * Brute Force Approach (for comparison)
     * Time Complexity: O(N^2)
     * Space Complexity: O(1)
     */
    public static int subarraySumBruteForce(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        // Test cases
        int[] nums1 = {1, 1, 1};
        int k1 = 2;
        System.out.println("Input: nums = [1,1,1], k = 2 | Output: " + subarraySum(nums1, k1)); // Expected: 2

        int[] nums2 = {1, 2, 3};
        int k2 = 3;
        System.out.println("Input: nums = [1,2,3], k = 3 | Output: " + subarraySum(nums2, k2)); // Expected: 2 ( [1,2] and [3] )

        int[] nums3 = {3, 4, 7, 2, -3, 1, 4, 2};
        int k3 = 7;
        System.out.println("Input: nums = [3,4,7,2,-3,1,4,2], k = 7 | Output: " + subarraySum(nums3, k3)); // Expected: 4
    }
}
