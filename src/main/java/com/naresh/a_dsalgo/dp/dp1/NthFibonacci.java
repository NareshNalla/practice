package com.naresh.a_dsalgo.dp.dp1;

/**
 * Problem: N-th Fibonacci Number
 * Description: Calculate the n-th Fibonacci number.
 */
public class NthFibonacci {
    /**
     * Algorithm: Use iterative approach with two variables to store previous values.
     */
    public int fib(int n) {
        // Pattern: Iterative DP | Time: O(n), Space: O(1)
        if (n <= 1) return n;
        int a = 0, b = 1;
        for (int i = 2; i <= n; i++) {
            var sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }
    // FAANG Tip: Memoization (O(n) space) is fine, but O(1) space iterative solution is superior.
}
