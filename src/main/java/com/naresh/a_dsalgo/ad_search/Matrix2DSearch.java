package com.naresh.a_dsalgo.ad_search;

/**
 * Problem: Search a 2D Matrix
 * Description: Efficiently search for a target value in an m x n sorted integer matrix.
 */
public class Matrix2DSearch {

    /**
     * Algorithm: Treat the m x n matrix as a single 1D sorted array of size m * n.
     * Perform a standard binary search on this virtual 1D array by mapping the 
     * 1D 'mid' index back to 2D coordinates (row = mid / n, col = mid % n).
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        // Pattern: Index Mapping / Binary Search on 2D Space | Time: O(log(m * n)), Space: O(1)
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        var m = matrix.length;
        var n = matrix[0].length;
        var left = 0;
        var right = m * n - 1;
        while (left <= right) {
            var mid = left + (right - left) / 2;
            var midValue = matrix[mid / n][mid % n];
            if (midValue == target) return true;
            if (midValue < target) left = mid + 1;
            else right = mid - 1;
        }
        return false;
    }

    public static void main(String[] args) {
        var sol = new Matrix2DSearch();
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        System.out.println("Result (Target 3): " + sol.searchMatrix(matrix, 3));  // true
        System.out.println("Result (Target 13): " + sol.searchMatrix(matrix, 13)); // false
    }
}
