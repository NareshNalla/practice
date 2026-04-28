package com.naresh.a_dsalgo.dp.dp2;

import java.util.Arrays;

/**
 * Problem: Unique Paths
 * Description: Find the number of possible unique paths from the top-left corner to the bottom-right corner of an m x n grid.
 * You can only move either down or right at any point in time.
 */
public class UniquePaths {
    /**
     * Algorithm: Bottom-up DP. The number of paths to cell (i, j) is the sum of paths to (i-1, j) and (i, j-1).
     */
    public int uniquePaths(int m, int n) {
        // Pattern: DP (2D Space Optimized) | Time: O(m * n), Space: O(n)
        var row = new int[n];
        Arrays.fill(row, 1); // Top row base case
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                row[j] += row[j - 1]; // Current = top + left
            }
        }
        return row[n - 1];
    }
    // FAANG Tip: Space can be optimized to O(min(m, n)). Mention the Combinatorics solution C(m+n-2, n-1) for O(1) space if applicable.
}
