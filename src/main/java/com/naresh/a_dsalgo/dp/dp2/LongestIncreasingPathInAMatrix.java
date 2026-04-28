package com.naresh.a_dsalgo.dp.dp2;

/**
 * Problem: Longest Increasing Path in a Matrix
 * Description: Given an m x n integers matrix, return the length of the longest increasing path in the matrix.
 */
public class LongestIncreasingPathInAMatrix {
    private static final int[][] DIRS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    /**
     * Algorithm: DFS with Memoization. For each cell, explore neighbors with strictly larger values.
     */
    public int longestIncreasingPath(int[][] matrix) {
        // Pattern: DFS + Memoization | Time: O(m * n), Space: O(m * n)
        if (matrix == null || matrix.length == 0) return 0;
        int m = matrix.length, n = matrix[0].length;
        var memo = new int[m][n];
        var maxPath = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                maxPath = Math.max(maxPath, dfs(matrix, i, j, memo));
            }
        }
        return maxPath;
    }

    private int dfs(int[][] matrix, int r, int c, int[][] memo) {
        if (memo[r][c] != 0) return memo[r][c];
        var max = 1;
        for (int[] d : DIRS) {
            int nr = r + d[0], nc = c + d[1];
            if (nr >= 0 && nr < matrix.length && nc >= 0 && nc < matrix[0].length && matrix[nr][nc] > matrix[r][c]) {
                max = Math.max(max, 1 + dfs(matrix, nr, nc, memo));
            }
        }
        return memo[r][c] = max;
    }
    // FAANG Tip: Memoization is essential here to avoid exponential time complexity. Each cell is computed only once.
}
