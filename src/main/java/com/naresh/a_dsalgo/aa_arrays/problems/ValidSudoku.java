package com.naresh.a_dsalgo.aa_arrays.problems;

import java.util.*;

/**
 * Problem: Valid Sudoku
 * Description: Determine if a 9x9 Sudoku board is valid based on rows, columns, and 3x3 sub-boxes.
 */
public class ValidSudoku {
    /**
     * Algorithm: Single pass using bitmasks to track digits 1-9 in each row, column, and 3x3 box.
     */
    public boolean isValidSudoku(char[][] board) {
        // Pattern: Bitmasking | Time: O(1), Space: O(1)
        int[] rowMasks = new int[9], colMasks = new int[9], boxMasks = new int[9];
        for (var r = 0; r < 9; r++) {
            for (var c = 0; c < 9; c++) {
                if (board[r][c] == '.') continue;
                var val = board[r][c] - '1'; // Map '1'-'9' to 0-8
                var mask = 1 << val; // Bit position for the digit
                var b = (r / 3) * 3 + (c / 3); // Box index
                if ((rowMasks[r] & mask) != 0 || (colMasks[c] & mask) != 0 || (boxMasks[b] & mask) != 0) return false;
                rowMasks[r] |= mask; colMasks[c] |= mask; boxMasks[b] |= mask;
            }
        }
        return true;
    }
    // FAANG Tip: Bitmasks are highly efficient as they avoid object creation and use O(1) auxiliary space.

    /**
     * Algorithm: Use Maps of Sets to track seen characters for each row, column, and 3x3 square.
     */
    public boolean isValidSudokuHashing(char[][] board) {
        // Pattern: Hashing (Multi-Set Tracking) | Time: O(1), Space: O(1)
        Map<Integer, Set<Character>> rows = new HashMap<>(), cols = new HashMap<>();
        Map<String, Set<Character>> squares = new HashMap<>();
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (board[r][c] == '.') continue;
                var val = board[r][c];
                var squareKey = (r / 3) + "," + (c / 3);
                if (rows.computeIfAbsent(r, k -> new HashSet<>()).contains(val) ||
                    cols.computeIfAbsent(c, k -> new HashSet<>()).contains(val) ||
                    squares.computeIfAbsent(squareKey, k -> new HashSet<>()).contains(val)) return false;
                rows.get(r).add(val); cols.get(c).add(val); squares.get(squareKey).add(val);
            }
        }
        return true;
    }
    // FAANG Tip: Maps of Sets are flexible but incur higher memory overhead due to object boxing and hashing.

    /**
     * Algorithm: Single pass using a HashSet with unique string descriptors for each digit's placement.
     */
    public boolean isValidSudokuHashSet(char[][] board) {
        // Pattern: HashSet (One Pass) | Time: O(1), Space: O(1)
        var seen = new HashSet<String>();
        for (var r = 0; r < 9; r++) {
            for (var c = 0; c < 9; c++) {
                if (board[r][c] == '.') continue;
                var val = board[r][c];
                if (!seen.add(val + " in row " + r) || 
                    !seen.add(val + " in col " + c) || 
                    !seen.add(val + " in box " + r/3 + "-" + c/3)) return false;
            }
        }
        return true;
    }
    // FAANG Tip: String encoding in a single HashSet is concise and demonstrates creative problem-solving.

    /**
     * Algorithm: Initialize arrays of HashSets for rows, columns, and 3x3 boxes. Iterate through the board,
     * adding each number to the corresponding HashSet. If a number is already present, the Sudoku is invalid.
     */
    public boolean isValidSudokuArrayOfHashSets(char[][] board) {
        // Pattern: Array of HashSets | Time: O(1), Space: O(1)
        var N = 9;
        HashSet<Character>[] rows = new HashSet[N];
        HashSet<Character>[] cols = new HashSet[N];
        HashSet<Character>[] boxes = new HashSet[N];
        for (var r = 0; r < N; r++) { // Initialize all HashSets
            rows[r] = new HashSet<>();
            cols[r] = new HashSet<>();
            boxes[r] = new HashSet<>();
        }
        for (var r = 0; r < N; r++) {
            for (var c = 0; c < N; c++) {
                var val = board[r][c];
                if (val == '.') continue; // Skip empty cells
                // Check the row
                if (rows[r].contains(val)) {
                    return false;
                }
                rows[r].add(val);
                // Check the column
                if (cols[c].contains(val)) {
                    return false;
                }
                cols[c].add(val);

                var boxIdx = (r / 3) * 3 + c / 3; // Calculate 3x3 box index
                if ( boxes[boxIdx].contains(val)){
                    return false; // Duplicate found
                }
                boxes[boxIdx].add(val); // Add to respective sets
            }
        }
        return true;
    }
    // FAANG Tip: This approach is clear and avoids string concatenation overhead of the single HashSet method.
}
