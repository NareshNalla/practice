package com.naresh.a_dsalgo.graphs.problems;

import java.util.*;

/**
 * Problem: Walls and Gates
 * Description: Fill each empty room with the distance to its nearest gate.
 */
public class WallsAndGates {
    /**
     * Algorithm: Multi-source BFS starting from all gates simultaneously.
     */
    public void wallsAndGates(int[][] rooms) {
        // Pattern: Multi-source BFS | Time: O(m * n), Space: O(m * n)
        if (rooms == null || rooms.length == 0) return;
        int m = rooms.length, n = rooms[0].length;
        var q = new ArrayDeque<int[]>();
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (rooms[r][c] == 0) q.offer(new int[]{r, c});
            }
        }
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (!q.isEmpty()) {
            var curr = q.poll();
            int r = curr[0], c = curr[1];
            for (int[] d : dirs) {
                int nr = r + d[0], nc = c + d[1];
                if (nr >= 0 && nr < m && nc >= 0 && nc < n && rooms[nr][nc] == 2147483647) {
                    rooms[nr][nc] = rooms[r][c] + 1;
                    q.offer(new int[]{nr, nc});
                }
            }
        }
    }
    // FAANG Tip: Starting BFS from gates (multi-source) is more efficient than starting from each empty room.
}
