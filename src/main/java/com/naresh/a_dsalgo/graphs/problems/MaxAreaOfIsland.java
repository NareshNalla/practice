package com.naresh.a_dsalgo.graphs.problems;

/**
 * Problem: Max Area of Island
 * Description: Find the maximum area of an island in a 2D binary grid.
 */
public class MaxAreaOfIsland {
    /**
     * Algorithm: Traverse grid. For each '1', perform DFS to calculate area while sinking visited land.
     */
    public int maxAreaOfIsland(int[][] grid) {
        // Pattern: DFS (Area Calculation) | Time: O(m * n), Space: O(m * n)
        var maxArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, dfs(grid, i, j));
                }
            }
        }
        return maxArea;
    }

    private int dfs(int[][] grid, int r, int c) {
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == 0) return 0;
        grid[r][c] = 0; // Sink
        return 1 + dfs(grid, r + 1, c) + dfs(grid, r - 1, c) + dfs(grid, r, c + 1) + dfs(grid, r, c - 1);
    }
    // FAANG Tip: DFS naturally returns the sum of component sizes. Mention that space is O(m*n) for the recursion stack in the worst case.
}
