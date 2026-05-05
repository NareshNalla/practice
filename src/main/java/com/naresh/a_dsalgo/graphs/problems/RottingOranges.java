package com.naresh.a_dsalgo.graphs.problems;

import java.util.*;

/**
 * Problem: Rotting Oranges
 * Description: Find the minimum time until no fresh orange is left.
 */
public class RottingOranges {
    /**
     * Algorithm: Multi-source BFS. Start with all rotten oranges in a queue. Spread to fresh neighbors level by level.
     */
    public int orangesRotting(int[][] grid) {
        // Pattern: Multi-source BFS | Time: O(m * n), Space: O(m * n)
        int m = grid.length, n = grid[0].length, fresh = 0;
        var q = new ArrayDeque<int[]>();
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 2) q.offer(new int[]{r, c});
                else if (grid[r][c] == 1) fresh++;
            }
        }
        if (fresh == 0) return 0;
        var minutes = -1;
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (!q.isEmpty()) {
            minutes++;
            var size = q.size();
            for (int i = 0; i < size; i++) {
                var curr = q.poll();
                for (int[] d : dirs) {
                    int nr = curr[0] + d[0], nc = curr[1] + d[1];
                    if (nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == 1) {
                        grid[nr][nc] = 2; // Infect
                        fresh--;
                        q.offer(new int[]{nr, nc});
                    }
                }
            }
        }
        return fresh == 0 ? minutes : -1;
    }
    // FAANG Tip: BFS is ideal for "minimum time" or "shortest path" in unweighted graphs/grids.

    public static void main(String[] args) {
        var sol = new RottingOranges();

        // Test Case 1: Some oranges will rot after 4 minutes
        // Grid: [[2,1,1],
        //        [1,1,0],
        //        [0,1,1]]
        // 2 = rotten, 1 = fresh, 0 = empty
        int[][] grid1 = {
            {2, 1, 1},
            {1, 1, 0},
            {0, 1, 1}
        };
        System.out.println("Test Case 1 (All Rotten in 4 min): " + (sol.orangesRotting(deepCopy(grid1)) == 4 ? "PASS" : "FAIL"));

        // Test Case 2: All oranges are rotten
        int[][] grid2 = {
            {2, 2},
            {2, 2}
        };
        System.out.println("Test Case 2 (Already All Rotten): " + (sol.orangesRotting(deepCopy(grid2)) == 0 ? "PASS" : "FAIL"));

        // Test Case 3: Some oranges can never rot (isolated fresh oranges)
        int[][] grid3 = {
            {2, 1},
            {1, 1}
        };
        int result3 = sol.orangesRotting(deepCopy(grid3));
        System.out.println("Test Case 3 (All Fresh Can Rot - 2 min): " + (result3 == 2 ? "PASS" : "FAIL"));

        // Test Case 4: No fresh oranges
        int[][] grid4 = {
            {2, 0},
            {0, 0}
        };
        System.out.println("Test Case 4 (No Fresh): " + (sol.orangesRotting(deepCopy(grid4)) == 0 ? "PASS" : "FAIL"));
    }

    private static int[][] deepCopy(int[][] grid) {
        int[][] copy = new int[grid.length][];
        for (int i = 0; i < grid.length; i++) {
            copy[i] = grid[i].clone();
        }
        return copy;
    }
}
