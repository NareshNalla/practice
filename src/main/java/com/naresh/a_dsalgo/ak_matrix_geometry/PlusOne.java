package com.naresh.a_dsalgo.ak_matrix_geometry;

import java.util.Arrays; // For Arrays.toString in main method

/**
 * Problem: Plus One (LeetCode 66)
 * Description: Given a large integer represented as an integer array `digits`, where each `digits[i]`
 * is the i-th digit of the integer. The digits are ordered from most significant to least significant
 * in left-to-right order. The large integer does not contain any leading zeros.
 * Increment the large integer by one and return the resulting array of digits.
 */
public class PlusOne {

    /**
     * Algorithm: Simulate manual addition of one. Iterate from the rightmost digit.
     * Add 1 to the last digit. If there's a carry, propagate it to the left.
     * If a carry remains after processing the most significant digit, a new digit (1)
     * needs to be prepended to the array.
     *
     * @param digits An array of integers representing the large integer.
     * @return The resulting array of digits after incrementing by one.
     */
    public int[] plusOne(int[] digits) {
        // Pattern: Array Manipulation (Carry Propagation) | Time: O(N), Space: O(1) (or O(N) in worst case)
        if (digits == null || digits.length == 0) return new int[]{1}; // Handle empty array case

        var n = digits.length;
        for (var i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) { // No carry needed, simply increment and return
                digits[i]++;
                return digits;
            }
            digits[i] = 0; // Digit is 9, set to 0 and propagate carry
        }

        // If loop finishes, it means all digits were 9 (e.g., [9,9,9] -> [1,0,0,0])
        var newDigits = new int[n + 1];
        newDigits[0] = 1; // Prepend 1
        // Other elements are already 0 by default
        return newDigits;
    }
    // FAANG Tip: Handle the all-nines case carefully, as it requires creating a new, larger array.

    public static void main(String[] args) {
        var solution = new PlusOne();

        // Test Case 1: No carry propagation beyond last digit
        var digits1 = new int[]{1, 2, 3};
        System.out.println("Digits: " + Arrays.toString(digits1) + " -> Plus One: " + Arrays.toString(solution.plusOne(digits1))); // Expected: [1, 2, 4]

        // Test Case 2: Carry propagation within the array
        var digits2 = new int[]{4, 3, 2, 1};
        System.out.println("Digits: " + Arrays.toString(digits2) + " -> Plus One: " + Arrays.toString(solution.plusOne(digits2))); // Expected: [4, 3, 2, 2]

        // Test Case 3: All nines, requiring new array
        var digits3 = new int[]{9, 9, 9};
        System.out.println("Digits: " + Arrays.toString(digits3) + " -> Plus One: " + Arrays.toString(solution.plusOne(digits3))); // Expected: [1, 0, 0, 0]

        // Test Case 4: Single digit, no carry
        var digits4 = new int[]{7};
        System.out.println("Digits: " + Arrays.toString(digits4) + " -> Plus One: " + Arrays.toString(solution.plusOne(digits4))); // Expected: [8]

        // Test Case 5: Single digit, carry
        var digits5 = new int[]{9};
        System.out.println("Digits: " + Arrays.toString(digits5) + " -> Plus One: " + Arrays.toString(solution.plusOne(digits5))); // Expected: [1, 0]

        // Test Case 6: Mixed nines
        var digits6 = new int[]{1, 9, 9};
        System.out.println("Digits: " + Arrays.toString(digits6) + " -> Plus One: " + Arrays.toString(solution.plusOne(digits6))); // Expected: [2, 0, 0]
    }
}
