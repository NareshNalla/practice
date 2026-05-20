package com.naresh.a_dsalgo.greedy.problems;

import java.util.Arrays; // Not strictly needed for this problem, but good for main method output

/**
 * Problem: Valid Parenthesis String (LeetCode 678)
 * Description: Given a string `s` containing only three types of characters: '(', ')', and '*',
 * return `true` if `s` is a valid parenthesis string.
 *
 * Rules for validity:
 * 1. Any left parenthesis '(' must have a corresponding right parenthesis ')'.
 * 2. Any right parenthesis ')' must have a corresponding left parenthesis '('.
 * 3. Left parentheses '(' must appear before the corresponding right parentheses ')'.
 * 4. '*' could be treated as a single right parenthesis ')', a single left parenthesis '(', or an empty string "".
 * 5. An empty string is also considered valid.
 */
public class ValidParenthesisString {

    /**
     * Algorithm: Greedy approach using two counters: `minOpen` and `maxOpen`.
     * `minOpen` tracks the minimum possible count of open parentheses that must be balanced.
     * `maxOpen` tracks the maximum possible count of open parentheses that could be balanced.
     * Iterate through the string, updating `minOpen` and `maxOpen` based on the character.
     * Ensure `minOpen` never goes below 0 and `maxOpen` never goes below 0 (returning false if it does).
     * Finally, the string is valid if `minOpen` is 0.
     *
     * @param s The input string containing '(', ')', and '*'.
     * @return True if the string is a valid parenthesis string, false otherwise.
     */
    public boolean checkValidString(String s) {
        // Pattern: Greedy (Two Counters) | Time: O(N), Space: O(1)
        var minOpen = 0; // Minimum possible open parentheses
        var maxOpen = 0; // Maximum possible open parentheses

        for (var c : s.toCharArray()) {
            if (c == '(') {
                minOpen++;
                maxOpen++;
            } else if (c == ')') {
                minOpen--;
                maxOpen--;
            } else { // c == '*'
                minOpen--; // Treat '*' as ')' to minimize open count
                maxOpen++; // Treat '*' as '(' to maximize open count
            }

            minOpen = Math.max(minOpen, 0); // minOpen cannot be negative
            if (maxOpen < 0) return false; // Too many ')' even with '*' as '('
        }
        return minOpen == 0; // All required '(' must be balanced
    }
    // FAANG Tip: This greedy approach tracks the valid range of open parentheses. `maxOpen < 0` catches excess ')' and `minOpen == 0` ensures all mandatory '(' are matched.

    public static void main(String[] args) {
        var solution = new ValidParenthesisString();

        var s1 = "()";
        System.out.println("String: \"" + s1 + "\" -> Is valid: " + solution.checkValidString(s1)); // Expected: true

        var s2 = "(*)";
        System.out.println("String: \"" + s2 + "\" -> Is valid: " + solution.checkValidString(s2)); // Expected: true

        var s3 = "(*))";
        System.out.println("String: \"" + s3 + "\" -> Is valid: " + solution.checkValidString(s3)); // Expected: true

        var s4 = "())";
        System.out.println("String: \"" + s4 + "\" -> Is valid: " + solution.checkValidString(s4)); // Expected: false

        var s5 = "((*)";
        System.out.println("String: \"" + s5 + "\" -> Is valid: " + solution.checkValidString(s5)); // Expected: false

        var s6 = "(((((*(()((((*((**(((()()*)()()()*((((**)())*()()(((()((()*(())*(()*)(()))))())())*((()))))))))((*)()";
        System.out.println("String: \"" + s6 + "\" -> Is valid: " + solution.checkValidString(s6)); // Expected: true

        var s7 = "";
        System.out.println("String: \"" + s7 + "\" -> Is valid: " + solution.checkValidString(s7)); // Expected: true

        var s8 = "***";
        System.out.println("String: \"" + s8 + "\" -> Is valid: " + solution.checkValidString(s8)); // Expected: true

        var s9 = "())(";
        System.out.println("String: \"" + s9 + "\" -> Is valid: " + solution.checkValidString(s9)); // Expected: false

        var s10 = "(((";
        System.out.println("String: \"" + s10 + "\" -> Is valid: " + solution.checkValidString(s10)); // Expected: false

        var s11 = "(*)(*";
        System.out.println("String: \"" + s11 + "\" -> Is valid: " + solution.checkValidString(s11)); // Expected: true

        var s12 = "((()))*(";
        System.out.println("String: \"" + s12 + "\" -> Is valid: " + solution.checkValidString(s12)); // Expected: false
    }
}
