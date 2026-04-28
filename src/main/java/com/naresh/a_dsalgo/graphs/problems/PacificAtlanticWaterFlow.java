package com.naresh.a_dsalgo.graphs.problems;

import java.util.*;

/**
 * Problem: Pacific Atlantic Water Flow
 * Description: Find all cells where water can flow to both the Pacific and Atlantic oceans.
 */
public class PacificAtlanticWaterFlow {
    /**
     * Algorithm: Perform two DFS traversals, one from Pacific-reachable cells and one from Atlantic-reachable cells.
     * Intersect the results.
     */
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        // Pattern: Multi-source DFS | Time: O(m * n), Space: O(m * n)
        int m = heights.length, n = heights[0].length;
        var pacific = new boolean[m][n];
        var atlantic = new boolean[m][n];

        // DFS from borders
        for (int i = 0; i < m; i++) {
            dfs(heights, i, 0, Integer.MIN_VALUE, pacific); // Pacific left border
            dfs(heights, i, n - 1, Integer.MIN_VALUE, atlantic); // Atlantic right border
        }
        for (int j = 0; j < n; j++) {
            dfs(heights, 0, j, Integer.MIN_VALUE, pacific); // Pacific top border
            dfs(heights, m - 1, j, Integer.MIN_VALUE, atlantic); // Atlantic bottom border
        }

        var res = new ArrayList<List<Integer>>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    res.add(List.of(i, j));
                }
            }
        }
        return res;
    }

    private void dfs(int[][] heights, int r, int c, int prevHeight, boolean[][] visited) {
        if (r < 0 || c < 0 || r >= heights.length || c >= heights[0].length || visited[r][c] || heights[r][c] < prevHeight) {
            return;
        }
        visited[r][c] = true;
        dfs(heights, r + 1, c, heights[r][c], visited);
        dfs(heights, r - 1, c, heights[r][c], visited);
        dfs(heights, r, c + 1, heights[r][c], visited);
        dfs(heights, r, c - 1, heights[r][c], visited);
    }
    // FAANG Tip: Instead of flowing from inside out, flow from the oceans inwards. This simplifies the logic.
}
