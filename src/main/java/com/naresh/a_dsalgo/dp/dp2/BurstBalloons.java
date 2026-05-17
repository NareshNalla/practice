package com.naresh.a_dsalgo.dp.dp2;

/**
 * Problem: Burst Balloons
 * Description: Given n balloons, each with a number of coins. Bursting balloon i gives nums[i-1] * nums[i] * nums[i+1] coins.
 * Find the maximum coins you can collect by bursting all balloons wisely.
 */
public class BurstBalloons {
    /**
     * Algorithm: Range DP. `dp[i][j]` is the max coins from bursting balloons in range `(i, j)`.
     * Key: Think about which balloon is burst *last* in the range.
     */
    public int maxCoins(int[] nums) {
        // Pattern: Range DP | Time: O(n^3), Space: O(n^2)
        int n = nums.length;
        var newNums = new int[n + 2];
        newNums[0] = newNums[n + 1] = 1;
        System.arraycopy(nums, 0, newNums, 1, n);

        var dp = new int[n + 2][n + 2];
        for (int len = 1; len <= n; len++) {
            for (int left = 1; left <= n - len + 1; left++) {
                int right = left + len - 1;
                for (int k = left; k <= right; k++) {
                    dp[left][right] = Math.max(dp[left][right], 
                        newNums[left - 1] * newNums[k] * newNums[right + 1] + dp[left][k - 1] + dp[k + 1][right]);
                }
            }
        }
        return dp[1][n];
    }
    // FAANG Tip: Range DP often involves three loops: length, left boundary, and an internal split point.

    public static void main(String[] args) {
        var nums = new int[]{3, 1, 5, 8};
        var result = new BurstBalloons().maxCoins(nums);
        System.out.println("Max coins from burst: " + result); // Output: 167
    }

    /*
     * Dry Run:
     * Input: nums = {3,1,5,8}, padded = {1,3,1,5,8,1}
     * Single balloons: dp[1][1]=3, dp[2][2]=1, dp[3][3]=5, dp[4][4]=8
     * Two adjacent: dp[1][2]=1+3+1=1*3*1=3, etc.
     * Result: dp[1][4] (all balloons burst)
     */
}
