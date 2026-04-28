package com.naresh.a_dsalgo.aa_arrays.twopointers;

/**
 * Problem: Container With Most Water
 * Description: Find two lines that together with the x-axis form a container, such that the container contains the most water.
 */
public class ContainerWithMostWater {
    /**
     * Algorithm: Use two pointers at the start and end of the array. Calculate area at each step 
     * and move the pointer pointing to the shorter line inward to maximize potential area.
     */
    public int maxArea(int[] heights) {
        // Pattern: Two Pointers | Time: O(n), Space: O(1)
        if (heights == null || heights.length < 2) return 0;
        var maxArea = 0; var left = 0; var right = heights.length - 1;
        while (left < right) {
            var currentHeight = Math.min(heights[left], heights[right]);
            var currentWidth = right - left;
            maxArea = Math.max(maxArea, currentHeight * currentWidth);
            if (heights[left] < heights[right]) left++; else right--; // Move shorter line inward
        }
        return maxArea;
    }
    // FAANG Tip: Explain that moving the longer line cannot increase the area (constrained by shorter line), so moving the shorter line is the only way to potentially find a larger area.

    public static void main(String[] args) {
        var sol = new ContainerWithMostWater();
        var heights = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println("Max Area: " + sol.maxArea(heights)); // Expected: 49
    }
}
