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

    public static void main(String[] args) {
        var sol = new MaxAreaOfIsland();

        // Test Case 1: Multiple islands
        // Grid: [[1,1,0,0,0],
        //        [1,1,0,0,0],
        //        [0,0,1,0,0],
        //        [0,0,0,1,1]]
        int[][] grid1 = {
            {1, 1, 0, 0, 0},
            {1, 1, 0, 0, 0},
            {0, 0, 1, 0, 0},
            {0, 0, 0, 1, 1}
        };
        System.out.println("Test Case 1 (Max Area 4): " + (sol.maxAreaOfIsland(deepCopy(grid1)) == 4 ? "PASS" : "FAIL"));

        // Test Case 2: Single large island
        // Grid: [[0,0,1,1,0],
        //        [1,1,1,1,1],
        //        [0,0,1,1,0]]
        int[][] grid2 = {
            {0, 0, 1, 1, 0},
            {1, 1, 1, 1, 1},
            {0, 0, 1, 1, 0}
        };
        System.out.println("Test Case 2 (Max Area 9): " + (sol.maxAreaOfIsland(deepCopy(grid2)) == 9 ? "PASS" : "FAIL"));

        // Test Case 3: No islands
        int[][] grid3 = {{0, 0}, {0, 0}};
        System.out.println("Test Case 3 (No Islands): " + (sol.maxAreaOfIsland(deepCopy(grid3)) == 0 ? "PASS" : "FAIL"));

        // Test Case 4: Full island
        int[][] grid4 = {{1, 1}, {1, 1}};
        System.out.println("Test Case 4 (Full Island): " + (sol.maxAreaOfIsland(deepCopy(grid4)) == 4 ? "PASS" : "FAIL"));
    }

    private static int[][] deepCopy(int[][] grid) {
        int[][] copy = new int[grid.length][];
        for (int i = 0; i < grid.length; i++) {
            copy[i] = grid[i].clone();
        }
        return copy;
    }
}
