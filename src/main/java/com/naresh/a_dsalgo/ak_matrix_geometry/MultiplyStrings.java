package com.naresh.a_dsalgo.ak_matrix_geometry;

import java.util.Arrays; // For Arrays.toString in main method

/**
 * Problem: Multiply Strings (LeetCode 43)
 * Description: Given two non-negative integers `num1` and `num2` represented as strings,
 * return the product of `num1` and `num2`, also represented as a string.
 * You must not use any built-in BigInteger library or convert the inputs to integers directly.
 */
public class MultiplyStrings {

    /**
     * Algorithm: Simulate manual long multiplication.
     * 1. Handle edge cases: If either `num1` or `num2` is "0", the product is "0".
     * 2. Initialize an integer array `res` of size `num1.length() + num2.length()` with zeros.
     *    This array will store the intermediate products and carries.
     * 3. Iterate through `num1` from right to left (index `i`).
     * 4. Iterate through `num2` from right to left (index `j`).
     * 5. For each pair of digits `num1[i]` and `num2[j]`:
     *    a. Calculate their product: `product = (num1.charAt(i) - '0') * (num2.charAt(j) - '0')`.
     *    b. Determine the positions in `res` where this product contributes: `pos1 = i + j` and `pos2 = i + j + 1`.
     *       `pos1` is for the carry, `pos2` is for the current digit.
     *    c. Add the `product` to `res[pos2]` (which might already contain a carry from previous calculations).
     *       `sum = product + res[pos2]`.
     *    d. Update `res[pos2]` with the unit digit of `sum`: `res[pos2] = sum % 10`.
     *    e. Add the carry to `res[pos1]`: `res[pos1] += sum / 10`.
     * 6. After all multiplications, `res` contains the digits of the product.
     * 7. Construct the result string from `res`, skipping leading zeros.
     *
     * Time Complexity: O(M * N), where M and N are the lengths of `num1` and `num2`.
     *   - Two nested loops iterate M and N times respectively.
     * Space Complexity: O(M + N)
     *   - For the `res` array to store the product digits.
     *
     * FAANG Tip: This problem tests your ability to handle large number arithmetic without
     * built-in types. The key is correctly managing carries and digit placement, similar to
     * how you'd do manual multiplication. The `res` array's indices are crucial.
     *
     * @param num1 The first non-negative integer as a string.
     * @param num2 The second non-negative integer as a string.
     * @return The product of `num1` and `num2` as a string.
     */
    public String multiply(String num1, String num2) {
        // Pattern: Array Simulation (Long Multiplication) | Time: O(M*N), Space: O(M+N)
        if ("0".equals(num1) || "0".equals(num2)) return "0"; // Edge case: product is 0

        var m = num1.length();
        var n = num2.length();
        var res = new int[m + n]; // Array to store product digits and carries

        for (var i = m - 1; i >= 0; i--) {
            for (var j = n - 1; j >= 0; j--) {
                var product = (num1.charAt(i) - '0') * (num2.charAt(j) - '0'); // Current digit product

                var pos1 = i + j;     // Position for carry
                var pos2 = i + j + 1; // Position for current digit

                var sum = product + res[pos2]; // Add product to existing value at pos2 (which might be a carry)

                res[pos2] = sum % 10; // Update current digit
                res[pos1] += sum / 10; // Add carry to next position
            }
        }

        // Build result string, skipping leading zeros
        var sb = new StringBuilder();
        var leadingZero = true;
        for (var digit : res) {
            if (digit == 0 && leadingZero) continue; // Skip leading zeros
            leadingZero = false;
            sb.append(digit);
        }
        return sb.toString();
    }
    // FAANG Tip: Pay attention to array indexing for `res` (i+j and i+j+1) and handling leading zeros.

    public static void main(String[] args) {
        var solution = new MultiplyStrings();

        // Test Case 1: Basic multiplication
        var num1_1 = "2";
        var num2_1 = "3";
        System.out.println("Multiply \"" + num1_1 + "\" and \"" + num2_1 + "\": " + solution.multiply(num1_1, num2_1)); // Expected: "6"

        // Test Case 2: Larger numbers
        var num1_2 = "123";
        var num2_2 = "456";
        System.out.println("Multiply \"" + num1_2 + "\" and \"" + num2_2 + "\": " + solution.multiply(num1_2, num2_2)); // Expected: "56088"

        // Test Case 3: One number is zero
        var num1_3 = "0";
        var num2_3 = "123";
        System.out.println("Multiply \"" + num1_3 + "\" and \"" + num2_3 + "\": " + solution.multiply(num1_3, num2_3)); // Expected: "0"

        // Test Case 4: Both numbers are zero
        var num1_4 = "0";
        var num2_4 = "0";
        System.out.println("Multiply \"" + num1_4 + "\" and \"" + num2_4 + "\": " + solution.multiply(num1_4, num2_4)); // Expected: "0"

        // Test Case 5: Large numbers resulting in many digits
        var num1_5 = "999";
        var num2_5 = "99";
        System.out.println("Multiply \"" + num1_5 + "\" and \"" + num2_5 + "\": " + solution.multiply(num1_5, num2_5)); // Expected: "98901"

        // Test Case 6: One digit number with multi-digit
        var num1_6 = "7";
        var num2_6 = "123";
        System.out.println("Multiply \"" + num1_6 + "\" and \"" + num2_6 + "\": " + solution.multiply(num1_6, num2_6)); // Expected: "861"
    }
}
