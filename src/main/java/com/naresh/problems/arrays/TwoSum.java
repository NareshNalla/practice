package com.naresh.problems.arrays;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        // Optimized HashMap approach (O(n))
        int[] optimized = twoSum(nums, target);
        System.out.println("Optimized result:   [" + optimized[0] + ", " + optimized[1] + "]");
    }
    
    /**
     * Optimized Two Sum using a HashMap (value -> index).
     * Thinking: for each number x, check if target-x was seen before. If so, we have a pair.
     * Time: O(n), Space: O(n).
     */
    public static int[] twoSum(int[] nums, int target) {
        // Use a HashMap to achieve O(n) time: value -> index
        Map<Integer, Integer> indexByValue = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (indexByValue.containsKey(complement)) {
                return new int[]{indexByValue.get(complement), i};
            }
            indexByValue.put(nums[i], i);
        }
        // If no solution, throw an exception to explicitly signal the problem
        throw new IllegalArgumentException("No two sum solution for target: " + target);
    }
}
