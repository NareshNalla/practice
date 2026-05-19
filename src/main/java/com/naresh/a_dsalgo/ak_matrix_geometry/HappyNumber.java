package com.naresh.a_dsalgo.ak_matrix_geometry;

import java.util.HashSet; // Not used in optimal solution, but common alternative
import java.util.Set;

/**
 * Problem: Happy Number (LeetCode 202)
 * Description: A happy number is a number defined by the following process:
 * Starting with any positive integer, replace the number by the sum of the squares of its digits.
 * Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle
 * which does not include 1. Those numbers for which this process ends in 1 are happy.
 * Return `true` if `n` is a happy number, and `false` if not.
 */
public class HappyNumber {

    /**
     * Helper method to calculate the sum of the squares of the digits of a number.
     *
     * @param n The input integer.
     * @return The sum of the squares of its digits.
     */
    private int getNext(int n) {
        var totalSum = 0;
        while (n > 0) {
            var digit = n % 10; // Get last digit
            totalSum += digit * digit; // Add square of digit
            n /= 10; // Remove last digit
        }
        return totalSum;
    }

    /**
     * Algorithm: Use Floyd's Cycle-Finding Algorithm (tortoise and hare).
     * Initialize `slow` to `n` and `fast` to `getNext(n)`.
     * In each step, `slow` moves one step (`getNext(slow)`) and `fast` moves two steps (`getNext(getNext(fast))`).
     * If `slow` and `fast` meet, a cycle is detected. If they meet at 1, it's a happy number.
     * If `fast` reaches 1, it's also a happy number.
     *
     * @param n The positive integer to check.
     * @return True if `n` is a happy number, false otherwise.
     */
    public boolean isHappy(int n) {
        // Pattern: Floyd's Cycle-Finding (Two Pointers) | Time: O(log N), Space: O(1)
        var slow = n;
        var fast = getNext(n); // Fast starts one step ahead

        while (fast != 1 && slow != fast) { // Continue until 1 is reached or cycle detected
            slow = getNext(slow); // Slow moves one step
            fast = getNext(getNext(fast)); // Fast moves two steps
        }
        return fast == 1; // If fast reached 1, it's happy
    }
    // FAANG Tip: Floyd's cycle-finding algorithm is an elegant O(1) space solution for cycle detection in sequences.

    public static void main(String[] args) {
        var solution = new HappyNumber();

        // Test Case 1: Happy number
        var n1 = 19;
        // 19 -> 1^2 + 9^2 = 82
        // 82 -> 8^2 + 2^2 = 68
        // 68 -> 6^2 + 8^2 = 100
        // 100 -> 1^2 + 0^2 + 0^2 = 1
        System.out.println("Is " + n1 + " a happy number? " + solution.isHappy(n1)); // Expected: true

        // Test Case 2: Not a happy number (enters cycle 4 -> 16 -> 37 -> 58 -> 89 -> 145 -> 42 -> 20 -> 4)
        var n2 = 2;
        System.out.println("Is " + n2 + " a happy number? " + solution.isHappy(n2)); // Expected: false

        // Test Case 3: Happy number (single digit)
        var n3 = 1;
        System.out.println("Is " + n3 + " a happy number? " + solution.isHappy(n3)); // Expected: true

        // Test Case 4: Not a happy number (single digit)
        var n4 = 4;
        System.out.println("Is " + n4 + " a happy number? " + solution.isHappy(n4)); // Expected: false

        // Test Case 5: Larger happy number
        var n5 = 7;
        // 7 -> 49 -> 16 + 81 = 97 -> 81 + 49 = 130 -> 1 + 9 + 0 = 10 -> 1 + 0 = 1
        System.out.println("Is " + n5 + " a happy number? " + solution.isHappy(n5)); // Expected: true
    }
}
