package com.naresh.arrays.brute;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        // 1) Brute-force approach (for thinking and correctness validation)
        int[] brute = twoSumBruteForce(nums, target);
        System.out.println("Brute-force result: [" + brute[0] + ", " + brute[1] + "]");

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
