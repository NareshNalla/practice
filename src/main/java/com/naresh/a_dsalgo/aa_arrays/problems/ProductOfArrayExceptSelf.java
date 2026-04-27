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

/**
 * Dry Run:
 * Input: nums = {1, 2, 3, 4}
 *
 * 1. Initialization:
 *    n = 4, res = [0, 0, 0, 0], preFix = 1
 *
 * 2. First Pass (Prefix Products):
 *    i = 0: res[0] = 1, preFix = 1
 *    i = 1: res[1] = 1, preFix = 2
 *    i = 2: res[2] = 2, preFix = 6
 *    i = 3: res[3] = 6, preFix = 24
 *    Result: [1, 1, 2, 6]
 *
 * 3. Second Pass (Postfix Products):
 *    postFix = 1
 *    i = 3: res[3] = 6 * 1 = 6, postFix = 4
 *    i = 2: res[2] = 2 * 4 = 8, postFix = 12
 *    i = 1: res[1] = 1 * 12 = 12, postFix = 24
 *    i = 0: res[0] = 1 * 24 = 24, postFix = 24
 *    Result: [24, 12, 8, 6]
 */
