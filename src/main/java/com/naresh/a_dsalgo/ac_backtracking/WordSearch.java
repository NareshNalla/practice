package com.naresh.a_dsalgo.ac_backtracking;

/**
 * Problem: Word Search
 * Description: Check if a word exists in a 2D grid of characters. Word must be formed by adjacent cells.
 */
public class WordSearch {
    private char[][] board;
    private int rows;
    private int cols;

    /**
     * Algorithm: Grid-based backtracking using instance members to reduce parameter passing and direction arrays for cleaner traversal.
     */
    public boolean exist(char[][] board, String word) {
        // Pattern: Matrix DFS (Backtracking) | Time: O(N * M * 4^L), Space: O(L)
        this.board = board;
        this.rows = board.length;
        this.cols = board[0].length;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (backtrack(r, c, word, 0)) return true;
            }
        }
        return false;
    }

    private boolean backtrack(int row, int col, String word, int index) {
        if (index >= word.length()) return true;
        if (row < 0 || row >= rows || col < 0 || col >= cols || board[row][col] != word.charAt(index)) {
            return false;
        }

        board[row][col] = '#'; // Mark as visited (Choose)
        int[] rowDir = {0, 1, 0, -1};
        int[] colDir = {1, 0, -1, 0};

        boolean found = false;
        // Explore all 4 adjacent directions (Right, Down, Left, Up)
        for (int d = 0; d < 4; d++) {
            if (backtrack(row + rowDir[d], col + colDir[d], word, index + 1)) {
                found = true;
                break;
            }
        }
        board[row][col] = word.charAt(index); // Restore (Backtrack)
        return found;
    }
    // FAANG Tip: Using direction arrays and instance fields makes the code modular and cleaner during a live interview.

    public static void main(String[] args) {
        WordSearch solution = new WordSearch();
        char[][] board = {
            {'A','B','C','E'},
            {'S','F','C','S'},
            {'A','D','E','E'}
        };
        System.out.println("Exists 'ABCCED': " + solution.exist(board, "ABCCED"));
        System.out.println("Exists 'SEE': " + solution.exist(board, "SEE"));
    }
}
