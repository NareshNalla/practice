package com.naresh.a_dsalgo.greedy.problems;

import java.util.Arrays;

/**
 * Problem: Jump Game (LeetCode 55)
 * Description: Given an array of non-negative integers `nums`, where `nums[i]` represents
 * the maximum jump length from index `i`. Determine if you are able to reach the last index.
 */
public class JumpGame {

    /**
     * Algorithm: Greedy approach (working backwards). Start from the second to last index.
     * If a position `i` can reach or surpass the current `finall` (the furthest reachable index
     * from the right that can reach the end), then `i` becomes the new `finall`.
     * If `finall` becomes 0, it means the start can reach the end.
     *
     * @param nums An array of non-negative integers representing maximum jump lengths.
     * @return True if the last index can be reached, false otherwise.
     */
    public boolean canJump(int[] nums) {
        // Pattern: Greedy (Backward Traversal) | Time: O(N), Space: O(1)
        if (nums == null || nums.length == 0) return false;
        if (nums.length == 1) return true; // Already at the last index

        var finall = nums.length - 1; // Represents the "good" index that can reach the end

        for (var i = nums.length - 2; i >= 0; i--) { // Iterate backwards from second to last element
            if (i + nums[i] >= finall) { // If current position can reach or pass 'finall'
                finall = i; // This position 'i' becomes the new 'finall'
            }
        }
        return finall == 0; // If 'finall' is 0, it means we can reach the end from the start
    }
    // FAANG Tip: This backward greedy approach is often more intuitive for Jump Game. It simplifies the logic by finding the leftmost reachable "good" position.

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
