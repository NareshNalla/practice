package com.naresh.a_dsalgo.dp.dp1;

/**
 * Problem: House Robber II
 * Description: Same as House Robber, but houses are arranged in a circle. Robbing the first house means you cannot rob the last.
 */
public class HouseRobberII {
    /**
     * Algorithm: Split the circle into two linear arrays: one excluding the first house, one excluding the last. Return max of both.
     */
    public int rob(int[] nums) {
        // Pattern: DP (Split Linear) | Time: O(n), Space: O(1)
        if (nums.length == 1) return nums[0];
        return Math.max(robRange(nums, 0, nums.length - 2), 
                        robRange(nums, 1, nums.length - 1));
    }

    private int robRange(int[] nums, int start, int end) {
        int rob1 = 0, rob2 = 0;
        for (int i = start; i <= end; i++) {
            var temp = Math.max(nums[i] + rob1, rob2);
            rob1 = rob2;
            rob2 = temp;
        }
        return rob2;
    }
    // FAANG Tip: Circular constraint is handled by solving two subproblems. Corner case: single house.
}
