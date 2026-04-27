package com.naresh.a_dsalgo.aa_arrays.problems;

import java.util.Arrays;

/**
 * Problem: Product of Array Except Self
 * Description: Return an array where each element is the product of all elements except nums[i].
 */
public class ProductOfArrayExceptSelf {
    /**
     * Algorithm: Two-pass accumulation using preFix and postFix running products.
     */
    public int[] productExceptSelf(int[] nums) {
        // Pattern: Prefix & Postfix Product | Time: O(n), Space: O(1)
        var n = nums.length;
        var res = new int[n];
        var preFix = 1;
        for (var i = 0; i < n; i++) {
            res[i] = preFix; // Store product of all left elements
            preFix *= nums[i];
        }
        var postFix = 1;
        for (var i = n - 1; i >= 0; i--) {
            res[i] *= postFix; // Multiply by product of all right elements
            postFix *= nums[i];
        }
        return res;
    }
    // FAANG Tip: Avoid division to handle zeros. Output array doesn't count towards space complexity.

    public static void main(String[] args) {
        var solution = new ProductOfArrayExceptSelf();
        int[] nums = {1, 2, 3, 4};
        System.out.println("Output: " + Arrays.toString(solution.productExceptSelf(nums)));
    }
}
