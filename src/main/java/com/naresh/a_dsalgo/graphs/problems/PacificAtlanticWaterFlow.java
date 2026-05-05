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
        // Pattern: Multi-source DFS | Time: O(row * col), Space: O(row * col)
        int row = heights.length, col = heights[0].length;
        var pacificReachable = new boolean[row][col];
        var atlanticReachable = new boolean[row][col];
        // DFS from borders
        for (int i = 0; i < row; i++) {
            dfs(heights, i, 0, Integer.MIN_VALUE, pacificReachable); // Pacific left border
            dfs(heights, i, col - 1, Integer.MIN_VALUE, atlanticReachable); // Atlantic right border
        }
        for (int j = 0; j < col; j++) {
            dfs(heights, 0, j, Integer.MIN_VALUE, pacificReachable); // Pacific top border
            dfs(heights, row - 1, j, Integer.MIN_VALUE, atlanticReachable); // Atlantic bottom border
        }
        var res = new ArrayList<List<Integer>>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (pacificReachable[i][j] && atlanticReachable[i][j]) {
                    res.add(List.of(i, j));
                }
            }
        }
        return res;
    }

    private void dfs(int[][] heights, int row, int col, int prevHeight, boolean[][] reachable) {
        if (row < 0 || col < 0 || row >= heights.length ||
                col >= heights[0].length || reachable[row][col] || heights[row][col] < prevHeight) {
            return;
        }
        reachable[row][col] = true;
        dfs(heights, row + 1, col, heights[row][col], reachable);
        dfs(heights, row - 1, col, heights[row][col], reachable);
        dfs(heights, row, col + 1, heights[row][col], reachable);
        dfs(heights, row, col - 1, heights[row][col], reachable);
    }
    /*
    private void dfs(int[][] heights, int row, int col, int prevHeight, boolean[][] reachable) {
        int [][] directions = new int[][]{{0,1},{1,0},{-1,0}, {0,-1}};

        reachable[row][col] = true;

        for(int[] dir: directions){
            int newRow = row+dir[0];
            int newCol = col+dir[1];

            if(newRow < 0 || newRow >= heights.length || newCol < 0 || newCol >= heights[0].length){
                continue;
            }

            if (reachable[newRow][newCol]){
                continue;
            }

            if(heights[newRow][newCol] < heights[row][col]){
                continue;
            }

            dfs(heights, newRow, newCol, reachable);
        }
    }
     */
    // FAANG Tip: Instead of flowing from inside out, flow from the oceans inwards. This simplifies the logic.

    public static void main(String[] args) {
        var sol = new PacificAtlanticWaterFlow();

        // Test Case 1: Simple 3x3 grid
        // Heights: [[4,2,7,6],
        //           [5,1,6,2],
        //           [3,2,4,8]]
        int[][] heights1 = {
            {4, 2, 7, 6},
            {5, 1, 6, 2},
            {3, 2, 4, 8}
        };
        List<List<Integer>> result1 = sol.pacificAtlantic(heights1);
        System.out.println("Test Case 1 Count: " + result1.size() + " (Expected >= 1)");

        // Test Case 2: Smaller grid 1x1
        int[][] heights2 = {{1}};
        List<List<Integer>> result2 = sol.pacificAtlantic(heights2);
        System.out.println("Test Case 2 (1x1 Grid): " + (result2.size() == 1 ? "PASS" : "FAIL"));

        // Test Case 3: Border cells should flow to both
        // Heights: [[1,1],
        //           [1,1]]
        int[][] heights3 = {
            {1, 1},
            {1, 1}
        };
        List<List<Integer>> result3 = sol.pacificAtlantic(heights3);
        System.out.println("Test Case 3 (All Border): " + (result3.size() == 4 ? "PASS" : "FAIL"));

        // Test Case 4: High corner walls
        // Heights: [[100,100],
        //           [100,100]]
        int[][] heights4 = {
            {100, 100},
            {100, 100}
        };
        List<List<Integer>> result4 = sol.pacificAtlantic(heights4);
        System.out.println("Test Case 4 (High Corners): " + (result4.size() == 4 ? "PASS" : "FAIL"));
    }
}
