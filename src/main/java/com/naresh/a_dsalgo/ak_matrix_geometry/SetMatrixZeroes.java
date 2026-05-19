package com.naresh.a_dsalgo.ak_matrix_geometry;

import java.util.Arrays; // For Arrays.deepToString in main method

/**
 * Problem: Set Matrix Zeroes (LeetCode 73)
 * Description: Given an `m x n` integer matrix, if an element is 0, set its entire row and column to 0's.
 * You must do this in-place.
 */
public class SetMatrixZeroes {

    /**
     * Algorithm: In-place modification using the first row and first column as markers.
     * 1. Determine if the first row or first column originally contains a zero. Store this information.
     * 2. Iterate through the rest of the matrix (from `(1,1)` to `(m-1, n-1)`). If `matrix[i][j]` is 0,
     *    mark `matrix[i][0]` and `matrix[0][j]` as 0.
     * 3. Iterate through the matrix again (from `(1,1)`). If `matrix[i][0]` or `matrix[0][j]` is 0,
     *    set `matrix[i][j]` to 0.
     * 4. Finally, if the first row or first column originally contained a zero (from step 1),
     *    set the entire first row/column to zeros.
     *
     * @param matrix The `m x n` integer matrix to be modified.
     */
    public void setZeroes(int[][] matrix) {
        // Pattern: In-place Matrix Modification (Marker Rows/Cols) | Time: O(M*N), Space: O(1)
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return;

        var m = matrix.length;
        var n = matrix[0].length;

        var firstRowHasZero = false;
        var firstColHasZero = false;

        // Step 1: Check if first row has any zero
        for (var j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                firstRowHasZero = true;
                break;
            }
        }

        // Step 1: Check if first column has any zero
        for (var i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                firstColHasZero = true;
                break;
            }
        }

        // Step 2: Use first row and column as markers
        for (var i = 1; i < m; i++) {
            for (var j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0; // Mark corresponding first column cell
                    matrix[0][j] = 0; // Mark corresponding first row cell
                }
            }
        }

        // Step 3: Set zeroes based on markers (excluding first row/col for now)
        for (var i = 1; i < m; i++) {
            for (var j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // Step 4: Set first row/column to zeroes if they originally contained a zero
        if (firstRowHasZero) {
            for (var j = 0; j < n; j++) matrix[0][j] = 0;
        }
        if (firstColHasZero) {
            for (var i = 0; i < m; i++) matrix[i][0] = 0;
        }
    }
    // FAANG Tip: This O(1) space solution is a classic. The trick is using the first row/column as auxiliary space, but handling their original state separately.

    public static void main(String[] args) {
        var solution = new SetMatrixZeroes();

        // Test Case 1: Example from LeetCode
        var matrix1 = new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        // Expected: {{1, 0, 1}, {0, 0, 0}, {1, 0, 1}}
        System.out.println("Original Matrix 1:\n" + Arrays.deepToString(matrix1));
        solution.setZeroes(matrix1);
        System.out.println("Modified Matrix 1:\n" + Arrays.deepToString(matrix1));

        // Test Case 2: Example from LeetCode
        var matrix2 = new int[][]{{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        // Expected: {{0, 0, 0, 0}, {0, 4, 5, 0}, {0, 3, 1, 0}}
        System.out.println("\nOriginal Matrix 2:\n" + Arrays.deepToString(matrix2));
        solution.setZeroes(matrix2);
        System.out.println("Modified Matrix 2:\n" + Arrays.deepToString(matrix2));

        // Test Case 3: Matrix with zero in first row and first column
        var matrix3 = new int[][]{{1, 2, 3}, {4, 0, 6}, {7, 8, 9}};
        // Expected: {{1, 0, 3}, {0, 0, 0}, {7, 0, 9}}
        System.out.println("\nOriginal Matrix 3:\n" + Arrays.deepToString(matrix3));
        solution.setZeroes(matrix3);
        System.out.println("Modified Matrix 3:\n" + Arrays.deepToString(matrix3));

        // Test Case 4: All zeros
        var matrix4 = new int[][]{{0, 0}, {0, 0}};
        // Expected: {{0, 0}, {0, 0}}
        System.out.println("\nOriginal Matrix 4:\n" + Arrays.deepToString(matrix4));
        solution.setZeroes(matrix4);
        System.out.println("Modified Matrix 4:\n" + Arrays.deepToString(matrix4));

        // Test Case 5: No zeros
        var matrix5 = new int[][]{{1, 2}, {3, 4}};
        // Expected: {{1, 2}, {3, 4}}
        System.out.println("\nOriginal Matrix 5:\n" + Arrays.deepToString(matrix5));
        solution.setZeroes(matrix5);
        System.out.println("Modified Matrix 5:\n" + Arrays.deepToString(matrix5));
    }
}
