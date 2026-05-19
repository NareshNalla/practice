package com.naresh.a_dsalgo.ak_matrix_geometry;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Problem: Spiral Matrix (LeetCode 54)
 * Description: Given an `m x n` matrix, return all elements of the matrix in spiral order.
 */
public class SpiralMatrix {

    /**
     * Algorithm: Simulate traversal using four boundary pointers: `top`, `bottom`, `left`, `right`.
     * Traverse layer by layer: right, down, left, up. Adjust boundaries after each traversal.
     * Crucially, check boundary conditions (`top <= bottom` and `left <= right`) before each horizontal/vertical pass
     * to handle non-square matrices and prevent duplicate elements.
     *
     * @param matrix The `m x n` integer matrix.
     * @return A list of all elements in the matrix in spiral order.
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        // Pattern: Matrix Traversal (Boundary Pointers) | Time: O(M*N), Space: O(1)
        var result = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return result;

        var m = matrix.length;
        var n = matrix[0].length;

        var top = 0;
        var bottom = m - 1;
        var left = 0;
        var right = n - 1;

        while (top <= bottom && left <= right) {
            // Traverse right along top row
            for (var j = left; j <= right; j++) result.add(matrix[top][j]);
            top++; // Move top boundary down

            // Traverse down along right column
            for (var i = top; i <= bottom; i++) result.add(matrix[i][right]);
            right--; // Move right boundary left

            // Check if boundaries still valid before traversing left and up (important for non-square matrices)
            if (top <= bottom) { // Ensure there's still a row to traverse left
                // Traverse left along bottom row
                for (var j = right; j >= left; j--) result.add(matrix[bottom][j]);
                bottom--; // Move bottom boundary up
            }

            if (left <= right) { // Ensure there's still a column to traverse up
                // Traverse up along left column
                for (var i = bottom; i >= top; i--) result.add(matrix[i][left]);
                left++; // Move left boundary right
            }
        }
        return result;
    }
    // FAANG Tip: The key to spiral traversal is managing the four boundaries and handling edge cases for non-square matrices by checking boundary conditions before each pass.

    public static void main(String[] args) {
        var solution = new SpiralMatrix();

        // Test Case 1: Example from LeetCode (3x3)
        var matrix1 = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        // Expected: [1, 2, 3, 6, 9, 8, 7, 4, 5]
        System.out.println("Matrix:\n" + Arrays.deepToString(matrix1) + "\nSpiral Order: " + solution.spiralOrder(matrix1));

        // Test Case 2: Example from LeetCode (3x4)
        var matrix2 = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        // Expected: [1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7]
        System.out.println("\nMatrix:\n" + Arrays.deepToString(matrix2) + "\nSpiral Order: " + solution.spiralOrder(matrix2));

        // Test Case 3: Single row
        var matrix3 = new int[][]{{1, 2, 3, 4, 5}};
        // Expected: [1, 2, 3, 4, 5]
        System.out.println("\nMatrix:\n" + Arrays.deepToString(matrix3) + "\nSpiral Order: " + solution.spiralOrder(matrix3));

        // Test Case 4: Single column
        var matrix4 = new int[][]{{1}, {2}, {3}, {4}, {5}};
        // Expected: [1, 2, 3, 4, 5]
        System.out.println("\nMatrix:\n" + Arrays.deepToString(matrix4) + "\nSpiral Order: " + solution.spiralOrder(matrix4));

        // Test Case 5: 1x1 matrix
        var matrix5 = new int[][]{{1}};
        // Expected: [1]
        System.out.println("\nMatrix:\n" + Arrays.deepToString(matrix5) + "\nSpiral Order: " + solution.spiralOrder(matrix5));

        // Test Case 6: Empty matrix
        var matrix6 = new int[][]{{}};
        // Expected: []
        System.out.println("\nMatrix:\n" + Arrays.deepToString(matrix6) + "\nSpiral Order: " + solution.spiralOrder(matrix6));
    }
}
