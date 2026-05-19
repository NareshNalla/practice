package com.naresh.a_dsalgo.ak_matrix_geometry;

import java.util.Arrays; // For Arrays.deepToString in main method

/**
 * Problem: Rotate Image (LeetCode 48)
 * Description: You are given an `n x n` 2D `matrix` representing an image, rotate the image by 90 degrees (clockwise).
 * You have to rotate the image in-place, which means you modify the input 2D matrix directly.
 * DO NOT allocate another 2D matrix.
 */
public class RotateImage {

    /**
     * Algorithm: In-place rotation of an N x N matrix by 90 degrees clockwise.
     * This can be achieved by two transformations:
     * 1. Transpose the matrix (swap `matrix[i][j]` with `matrix[j][i]`).
     * 2. Reverse each row of the transposed matrix.
     *
     * @param matrix The N x N 2D array representing the image to be rotated.
     */
    public void rotate(int[][] matrix) {
        // Pattern: In-place Matrix Transformation | Time: O(N^2), Space: O(1)
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return;

        var n = matrix.length;

        // Step 1: Transpose the matrix
        for (var i = 0; i < n; i++) {
            for (var j = i; j < n; j++) { // Iterate j from i to avoid double swapping
                var temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Step 2: Reverse each row
        for (var i = 0; i < n; i++) {
            // Use two pointers to reverse the row
            var left = 0;
            var right = n - 1;
            while (left < right) {
                var temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                left++;
                right--;
            }
        }
    }
    // FAANG Tip: In-place matrix transformations are common. Transpose + Reverse Rows is a standard and efficient technique for 90-degree clockwise rotation.

    public static void main(String[] args) {
        var solution = new RotateImage();

        // Test Case 1: Example from LeetCode (3x3 matrix)
        var matrix1 = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        // Expected: {{7, 4, 1}, {8, 5, 2}, {9, 6, 3}}
        System.out.println("Original Matrix 1:\n" + Arrays.deepToString(matrix1));
        solution.rotate(matrix1);
        System.out.println("Rotated Matrix 1:\n" + Arrays.deepToString(matrix1));

        // Test Case 2: Example from LeetCode (4x4 matrix)
        var matrix2 = new int[][]{{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
        // Expected: {{15, 13, 2, 5}, {14, 3, 4, 1}, {12, 6, 8, 9}, {16, 7, 10, 11}}
        System.out.println("\nOriginal Matrix 2:\n" + Arrays.deepToString(matrix2));
        solution.rotate(matrix2);
        System.out.println("Rotated Matrix 2:\n" + Arrays.deepToString(matrix2));

        // Test Case 3: 1x1 matrix
        var matrix3 = new int[][]{{1}};
        // Expected: {{1}}
        System.out.println("\nOriginal Matrix 3:\n" + Arrays.deepToString(matrix3));
        solution.rotate(matrix3);
        System.out.println("Rotated Matrix 3:\n" + Arrays.deepToString(matrix3));

        // Test Case 4: 2x2 matrix
        var matrix4 = new int[][]{{1, 2}, {3, 4}};
        // Expected: {{3, 1}, {4, 2}}
        System.out.println("\nOriginal Matrix 4:\n" + Arrays.deepToString(matrix4));
        solution.rotate(matrix4);
        System.out.println("Rotated Matrix 4:\n" + Arrays.deepToString(matrix4));
    }
}
