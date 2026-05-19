package com.naresh.a_dsalgo.ak_matrix_geometry;

/**
 * Problem: Pow(x, n) (LeetCode 50)
 * Description: Implement `pow(x, n)`, which calculates `x` raised to the power `n` (`x^n`).
 */
public class PowXANDN {

    /**
     * Algorithm: Optimized exponentiation using binary exponentiation (exponentiation by squaring).
     * Handle negative exponent by taking reciprocal of `x` and making `n` positive.
     * Iterate while `n > 0`: if `n` is odd, multiply `ans` by `x`; always square `x` and halve `n`.
     *
     * @param x The base number.
     * @param n The exponent.
     * @return `x` raised to the power `n`.
     */
    public double myPow(double x, int n) {
        // Pattern: Binary Exponentiation | Time: O(log N), Space: O(1)
        if (x == 0.0) return 0.0; // 0 raised to any positive power is 0

        var ans = 1.0;
        var N = (long) n; // Use long to handle Integer.MIN_VALUE for n

        if (N < 0) { // Handle negative exponent
            x = 1 / x;
            N = -N;
        }

        while (N > 0) {
            if ((N % 2) == 1) ans *= x; // If N is odd, multiply ans by x
            x *= x; // Square x
            N /= 2; // Halve N
        }
        return ans;
    }
    // FAANG Tip: Binary exponentiation is a standard optimization for calculating powers, reducing complexity from O(N) to O(log N). Handle `n = Integer.MIN_VALUE` carefully.

    public static void main(String[] args) {
        var solution = new PowXANDN();

        // Test Case 1: Positive exponent
        var x1 = 2.0;
        var n1 = 10;
        System.out.println(x1 + " raised to " + n1 + ": " + solution.myPow(x1, n1)); // Expected: 1024.0

        // Test Case 2: Negative exponent
        var x2 = 2.0;
        var n2 = -2;
        System.out.println(x2 + " raised to " + n2 + ": " + solution.myPow(x2, n2)); // Expected: 0.25

        // Test Case 3: Zero exponent
        var x3 = 2.0;
        var n3 = 0;
        System.out.println(x3 + " raised to " + n3 + ": " + solution.myPow(x3, n3)); // Expected: 1.0

        // Test Case 4: Fractional base
        var x4 = 2.1;
        var n4 = 3;
        System.out.println(x4 + " raised to " + n4 + ": " + solution.myPow(x4, n4)); // Expected: 9.261000000000001

        // Test Case 5: Large negative exponent (Integer.MIN_VALUE)
        var x5 = 2.0;
        var n5 = Integer.MIN_VALUE; // -2147483648
        System.out.println(x5 + " raised to " + n5 + ": " + solution.myPow(x5, n5)); // Expected: 0.0 (very small number)
    }
}
