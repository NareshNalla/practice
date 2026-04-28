package com.naresh.a_dsalgo.dp.dp2;

/**
 * Problem: Minimum Path Sum / Maximum Path Sum in Grid
 * Description: Given a grid, find a path from top-left to bottom-right that minimizes/maximizes the sum of all numbers along its path.
 */
public class GridPaths {
    /**
     * Algorithm: Bottom-up DP. Each cell's max value depends on the max of its top and left neighbors.
     */
    public int maxPathSum(int[][] grid) {
        // Pattern: DP (2D Space Optimized) | Time: O(m * n), Space: O(n)
        int m = grid.length, n = grid[0].length;
        var dp = new int[n];
        dp[0] = grid[0][0];
        
        // Initialize first row
        for (int j = 1; j < n; j++) dp[j] = dp[j - 1] + grid[0][j];
        
        for (int i = 1; i < m; i++) {
            dp[0] += grid[i][0]; // Update first column
            for (int j = 1; j < n; j++) {
                dp[j] = Math.max(dp[j], dp[j - 1]) + grid[i][j]; // Max from top or left
            }
        }
        return dp[n - 1];
    }
    // FAANG Tip: Always check if you can modify the input grid in-place to achieve O(1) space if memory is constrained.
}
