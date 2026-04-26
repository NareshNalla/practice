package com.naresh.a_dsalgo.aarrays.problems;

import java.util.HashMap;
import java.util.Objects;

public class TwoSum {

    /**
     * Optimized Two Sum using a HashMap (value -> index).
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     *
     * @param nums   The input array of integers.
     * @param target The target sum to find.
     * @return An array of two indices that sum to the target.
     * @throws NullPointerException     if nums is null.
     * @throws IllegalArgumentException if no solution is found.
     */
    public static int[] twoSum(final int[] nums, final int target) {
        Objects.requireNonNull(nums, "Input array 'nums' cannot be null");
        var indexByValue = new HashMap<Integer, Integer>((int) (nums.length / 0.75) + 1);

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            // Single lookup using get() is more efficient than containsKey() followed by get().
            Integer complementIndex = indexByValue.getOrDefault(complement, -1);
            if (complementIndex != -1 && complementIndex != i) {
                return new int[]{complementIndex, i};
            }
            indexByValue.put(nums[i], i);
        }

        throw new IllegalArgumentException(String.format("No two sum solution found for target: %d", target));
    }

    /**
     * Brute-force Two Sum
     * Time: O(n^2), Space: O(1).
     */
//    public static int[] twoSumBruteForce(int[] nums, int target) {
//        Objects.requireNonNull(nums, "Input array 'nums' cannot be null");
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                if (nums[i] + nums[j] == target) {
//                    return new int[]{i, j};
//                }
//            }
//        }
//        throw new IllegalArgumentException("No two sum solution for target: " + target);
//    }
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        // 1) Brute-force approach (for thinking and correctness validation)
        //int[] brute = twoSumBruteForce(nums, target);
       // System.out.println("Brute-force result: [" + brute[0] + ", " + brute[1] + "]");
        // 2)  Optimized HashMap approach (O(n))
        int[] optimized = twoSum(nums, target);
        System.out.println("Optimized result:   [" + optimized[0] + ", " + optimized[1] + "]");
    }
}
