package com.naresh.a_dsalgo.greedy.problems;

import java.util.Arrays;

/**
 * Problem: Jump Game II (LeetCode 45)
 * Description: Find the minimum number of jumps to reach the last index of an array,
 * where `nums[i]` is the maximum jump length from index `i`.
 */
public class JumpGameII {

    /**
     * Algorithm: Greedy approach (BFS-like). Track `jumps`, `currentJumpEnd` (end of current jump's range),
     * and `farthestReach` (max reach from current jump's range). Increment `jumps` when `i` reaches `currentJumpEnd`.
     *
     * @param nums An array of non-negative integers representing maximum jump lengths.
     * @return The minimum number of jumps to reach the last index.
     */
    public int jump(int[] nums) {
        // Pattern: Greedy (BFS-like) | Time: O(N), Space: O(1)
        if (nums == null || nums.length <= 1) return 0; // Already at end or no jumps needed

        var jumps = 0;
        var currentJumpEnd = 0; // Farthest index reachable with current jumps
        var farthestReach = 0;  // Farthest point reachable from any index within current jump's range

        for (var i = 0; i < nums.length - 1; i++) { // Iterate up to second to last element
            farthestReach = Math.max(farthestReach, i + nums[i]); // Update max reach
            if (i == currentJumpEnd) { // Reached end of current jump's range
                jumps++; // Increment jump count
                currentJumpEnd = farthestReach; // Set new end for next jump
            }
        }
        return jumps;
    }
    // FAANG Tip: This is a classic greedy problem, often visualized as BFS. `currentJumpEnd` is the level boundary, `farthestReach` is the next level's boundary.

    public static void main(String[] args) {
        var solution = new JumpGameII();

        var nums1 = new int[]{2, 3, 1, 1, 4};
        System.out.println("Nums: " + Arrays.toString(nums1) + " -> Min Jumps: " + solution.jump(nums1)); // Expected: 2

        var nums2 = new int[]{2, 3, 0, 1, 4};
        System.out.println("Nums: " + Arrays.toString(nums2) + " -> Min Jumps: " + solution.jump(nums2)); // Expected: 2

        var nums3 = new int[]{1, 1, 1, 1, 1};
        System.out.println("Nums: " + Arrays.toString(nums3) + " -> Min Jumps: " + solution.jump(nums3)); // Expected: 4

        var nums4 = new int[]{0};
        System.out.println("Nums: " + Arrays.toString(nums4) + " -> Min Jumps: " + solution.jump(nums4)); // Expected: 0

        var nums5 = new int[]{3, 2, 1};
        System.out.println("Nums: " + Arrays.toString(nums5) + " -> Min Jumps: " + solution.jump(nums5)); // Expected: 1

        var nums6 = new int[]{5, 0, 0, 0, 0, 0};
        System.out.println("Nums: " + Arrays.toString(nums6) + " -> Min Jumps: " + solution.jump(nums6)); // Expected: 1
    }
}
