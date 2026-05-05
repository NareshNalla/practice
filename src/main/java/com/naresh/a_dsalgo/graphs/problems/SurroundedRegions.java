package com.naresh.a_dsalgo.graphs.problems;

/**
 * Problem: Surrounded Regions
 * Description: Replace all 'O's with 'X's if they are surrounded by 'X's. An 'O' is not surrounded if it is on the border or connected to a border 'O'.
 */
public class SurroundedRegions {
    /**
     * Algorithm: Start DFS from border 'O's to mark all non-surrounded regions (e.g., with 'T'). 
     * Then traverse grid: 'O' -> 'X', 'T' -> 'O'.
     */
    public void solve(char[][] board) {
        // Pattern: Boundary DFS | Time: O(m * n), Space: O(m * n)
        if (board == null || board.length == 0) return;
        int m = board.length, n = board[0].length;

        // DFS from top and bottom borders
        for (int j = 0; j < n; j++) {
            dfs(board, 0, j);
            dfs(board, m - 1, j);
        }
        // DFS from left and right borders
        for (int i = 0; i < m; i++) {
            dfs(board, i, 0);
            dfs(board, i, n - 1);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X'; // Surrounded
                else if (board[i][j] == 'T') board[i][j] = 'O'; // Not surrounded
            }
        }
    }

    private void dfs(char[][] board, int r, int c) {
        if (r < 0 || c < 0 || r >= board.length || c >= board[0].length || board[r][c] != 'O') return;
        board[r][c] = 'T'; // Mark as connected to border
        dfs(board, r + 1, c);
        dfs(board, r - 1, c);
        dfs(board, r, c + 1);
        dfs(board, r, c - 1);
    }
    // FAANG Tip: Focus on the "escape" condition (border connectivity). DFS from borders is a common pattern for grid problems.

    public static void main(String[] args) {
        var sol = new SurroundedRegions();

        // Test Case 1: Classic surrounded regions
        // Input:  [['X','X','X','X'],
        //         ['X','O','O','X'],
        //         ['X','X','O','X'],
        //         ['X','O','X','X']]
        char[][] board1 = {
            {'X', 'X', 'X', 'X'},
            {'X', 'O', 'O', 'X'},
            {'X', 'X', 'O', 'X'},
            {'X', 'O', 'X', 'X'}
        };
        sol.solve(board1);
        System.out.println("Test Case 1 (Surrounded): " + (board1[1][1] == 'X' && board1[1][2] == 'X' ? "PASS" : "FAIL"));

        // Test Case 2: O on border (should not be surrounded)
        char[][] board2 = {
            {'X', 'X', 'X'},
            {'X', 'O', 'X'},
            {'X', 'X', 'X'}
        };
        sol.solve(board2);
        System.out.println("Test Case 2 (Border O): " + (board2[1][1] == 'X' ? "PASS" : "FAIL"));

        // Test Case 3: All X's
        char[][] board3 = {
            {'X', 'X'},
            {'X', 'X'}
        };
        sol.solve(board3);
        System.out.println("Test Case 3 (All X): " + (board3[0][0] == 'X' ? "PASS" : "FAIL"));

        // Test Case 4: Single cell
        char[][] board4 = {{'O'}};
        sol.solve(board4);
        System.out.println("Test Case 4 (Single O Border): " + (board4[0][0] == 'O' ? "PASS" : "FAIL"));
    }
}
