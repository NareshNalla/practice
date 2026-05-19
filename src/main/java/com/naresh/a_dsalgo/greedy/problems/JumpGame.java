package com.naresh.a_dsalgo.greedy.problems;

import java.util.Arrays;

/**
 * Problem: Jump Game (LeetCode 55)
 * Description: Given an array of non-negative integers `nums`, where `nums[i]` represents
 * the maximum jump length from index `i`. Determine if you are able to reach the last index.
 */
public class JumpGame {

    /**
     * Algorithm: Greedy approach. Track the maximum reachable index (`maxReach`).
     * If current index `i` exceeds `maxReach`, return false. Update `maxReach` with `i + nums[i]`.
     * If `maxReach` covers the last index, return true.
     *
     * @param nums An array of non-negative integers representing maximum jump lengths.
     * @return True if the last index can be reached, false otherwise.
     */
    public boolean canJump(int[] nums) {
        // Pattern: Greedy (Single Pass) | Time: O(N), Space: O(1)
        if (nums == null || nums.length == 0) return false;
        if (nums.length == 1) return true; // Already at the last index

        var maxReach = 0; // Stores the maximum index reachable so far

        for (var i = 0; i < nums.length; i++) {
            if (i > maxReach) return false; // Current index unreachable
            maxReach = Math.max(maxReach, i + nums[i]); // Update max reachable point
            if (maxReach >= nums.length - 1) return true; // Last index reachable
        }
        return true; // Should be covered by the above return, but as a safeguard
    }
    // FAANG Tip: The greedy choice is to always extend the maximum reachable point. No need to explore all paths.

    public static void main(String[] args) {
        var solution = new JumpGame();

        var nums1 = new int[]{2, 3, 1, 1, 4};
        System.out.println("Nums: " + Arrays.toString(nums1) + " -> Can reach end: " + solution.canJump(nums1)); // Expected: true

        var nums2 = new int[]{3, 2, 1, 0, 4};
        System.out.println("Nums: " + Arrays.toString(nums2) + " -> Can reach end: " + solution.canJump(nums2)); // Expected: false

        var nums3 = new int[]{0};
        System.out.println("Nums: " + Arrays.toString(nums3) + " -> Can reach end: " + solution.canJump(nums3)); // Expected: true

        var nums4 = new int[]{0, 1};
        System.out.println("Nums: " + Arrays.toString(nums4) + " -> Can reach end: " + solution.canJump(nums4)); // Expected: false

        var nums5 = new int[]{5, 0, 0, 0, 0, 0};
        System.out.println("Nums: " + Arrays.toString(nums5) + " -> Can reach end: " + solution.canJump(nums5)); // Expected: true

        var nums6 = new int[]{2, 0, 0};
        System.out.println("Nums: " + Arrays.toString(nums6) + " -> Can reach end: " + solution.canJump(nums6)); // Expected: true
    }
}
