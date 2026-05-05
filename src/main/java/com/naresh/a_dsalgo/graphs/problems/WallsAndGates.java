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

    public static void main(String[] args) {
        var sol = new WallsAndGates();

        // Test Case 1: Simple room grid with gates
        // Input:  [[2147483647,  -1, 0, 2147483647],
        //         [2147483647, 2147483647, 2147483647,  -1],
        //         [2147483647,  -1, 2147483647,  -1],
        //         [0,  -1, 2147483647, 2147483647]]
        int INF = 2147483647;
        int[][] rooms1 = {
            {INF, -1, 0, INF},
            {INF, INF, INF, -1},
            {INF, -1, INF, -1},
            {0, -1, INF, INF}
        };
        sol.wallsAndGates(rooms1);
        System.out.println("Test Case 1 Top-left corner: " + (rooms1[0][0] == 3 ? "PASS" : "FAIL"));

        // Test Case 2: Single empty room with adjacent gate
        int[][] rooms2 = {
            {0, INF},
            {INF, INF}
        };
        sol.wallsAndGates(rooms2);
        System.out.println("Test Case 2 Adjacent to Gate: " + (rooms2[0][1] == 1 && rooms2[1][0] == 1 ? "PASS" : "FAIL"));

        // Test Case 3: Empty grid with multiple gates
        int[][] rooms3 = {
            {0, INF, INF},
            {INF, INF, INF},
            {INF, INF, 0}
        };
        sol.wallsAndGates(rooms3);
        System.out.println("Test Case 3 Center Distance: " + (rooms3[1][1] == 2 ? "PASS" : "FAIL"));

        // Test Case 4: All gates
        int[][] rooms4 = {
            {0, 0},
            {0, 0}
        };
        sol.wallsAndGates(rooms4);
        System.out.println("Test Case 4 (All Gates): " + (rooms4[0][0] == 0 ? "PASS" : "FAIL"));
    }
}
