package com.naresh.a_dsalgo.dp.dp2;

import java.util.Arrays;

/**
 * Problem: Unique Paths
 * Description: Find the number of possible unique paths from the top-left corner to the bottom-right corner of an m x n grid.
 * You can only move either down or right at any point in time.
 */
public class UniquePaths {
    /**
     * Algorithm: Bottom-up DP using a 2D array.
     * The number of paths to cell (i, j) is the sum of paths to (i-1, j) and (i, j-1).
     * Time: O(m * n), Space: O(m * n)
     */
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        // Initialize the first row and first column with 1s,
        // as there's only one way to reach any cell in them (by moving only right or only down).
        for (int[] row : dp) {
            Arrays.fill(row, 1);
        }

        // Fill the rest of the DP table
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];
    }

    /**
     * Algorithm: Bottom-up DP with space optimization.
     * The number of paths to cell (i, j) is the sum of paths to (i-1, j) and (i, j-1).
     * This version optimizes space to O(n) by only keeping track of the previous row.
     * Time: O(m * n), Space: O(n)
     */
    public int uniquePaths_SpaceOptimized(int m, int n) {
        // Pattern: DP (2D Space Optimized) | Time: O(m * n), Space: O(n)
        var row = new int[n];
        Arrays.fill(row, 1); // Initialize the first row (or current row acting as previous) with 1s
        for (int i = 1; i < m; i++) { // Iterate through rows starting from the second row
            for (int j = 1; j < n; j++) { // Iterate through columns starting from the second column
                row[j] += row[j - 1]; // Current cell's paths = paths from top (row[j]) + paths from left (row[j-1])
            }
        }
        return row[n - 1];
    }
    // FAANG Tip: Space can be optimized to O(min(m, n)). Mention the Combinatorics solution C(m+n-2, n-1) for O(1) space if applicable.

    public static void main(String[] args) {
        var m = 3;
        var n = 7;
        var solution = new UniquePaths();

        var result1 = solution.uniquePaths(m, n);
        System.out.println("Unique paths (O(m*n) DP) in " + m + "x" + n + " grid: " + result1); // Output: 28

        var result2 = solution.uniquePaths_SpaceOptimized(m, n);
        System.out.println("Unique paths (O(n) Space Optimized DP) in " + m + "x" + n + " grid: " + result2); // Output: 28
    }

    /*
     * Dry Run for uniquePaths_SpaceOptimized:
     * Input: m=3, n=7
     * Initialize row: [1,1,1,1,1,1,1]
     * After i=1 (second row calculation): [1,2,3,4,5,6,7]
     * After i=2 (third row calculation): [1,3,6,10,15,21,28]
     * Result: row[6]=28
     */
}
