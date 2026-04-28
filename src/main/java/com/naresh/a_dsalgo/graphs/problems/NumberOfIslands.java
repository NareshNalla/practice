package com.naresh.a_dsalgo.graphs.problems;

/**
 * Problem: Number of Islands
 * Description: Given an m x n 2D binary grid which represents a map of '1's (land) and '0's (water), return the number of islands.
 */
public class NumberOfIslands {
    /**
     * Algorithm: Traverse the grid. When a '1' is found, increment island count and use DFS to sink the entire island (turn '1's to '0's).
     */
    public int numIslands(char[][] grid) {
        // Pattern: DFS (Grid Traversal) | Time: O(m * n), Space: O(m * n)
        if (grid == null || grid.length == 0) return 0;
        var count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int r, int c) {
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == '0') return;
        grid[r][c] = '0'; // Sink land
        dfs(grid, r + 1, c);
        dfs(grid, r - 1, c);
        dfs(grid, r, c + 1);
        dfs(grid, r, c - 1);
    }
    // FAANG Tip: Modifying the grid in-place (sinking) avoids using an extra 'visited' set, saving space.
}
