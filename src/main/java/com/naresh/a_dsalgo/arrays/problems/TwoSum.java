package com.naresh.a_dsalgo.arrays.problems;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        // 1) Brute-force approach (for thinking and correctness validation)
        int[] brute = twoSumBruteForce(nums, target);
        System.out.println("Brute-force result: [" + brute[0] + ", " + brute[1] + "]");
        // 2)  Optimized HashMap approach (O(n))
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

    /**
     * Brute-force Two Sum
     * Thinking: try every pair (i, j) with i < j and check if nums[i] + nums[j] == target.
     * Time: O(n^2), Space: O(1).
     * Use this when n is small or to validate correctness of optimized solutions.
     */
    public static int[] twoSumBruteForce(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution for target: " + target);
    }
}
