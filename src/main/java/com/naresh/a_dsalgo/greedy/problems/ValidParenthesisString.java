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
     * Determines if a given string `s` is a valid parenthesis string according to the rules.
     *
     * Algorithm: Greedy Approach (Single Pass with Two Counters)
     * This solution uses a single pass through the string while maintaining two counters: `low` and `high`.
     *
     * - `low`: Represents the minimum possible count of open parentheses that are currently unmatched
     *          and *must* eventually be closed. When encountering a `*`, we treat it as a `)` to minimize
     *          the open count.
     * - `high`: Represents the maximum possible count of open parentheses that are currently unmatched
     *           and *could* eventually be closed. When encountering a `*`, we treat it as a `(` to maximize
     *           the open count.
     *
     * The logic is as follows:
     * 1. Initialize `low = 0` and `high = 0`.
     * 2. Iterate through each character `c` in the input string `s`:
     *    a. If `c == '('`:
     *       - Both `low` and `high` must increase, as we have an open parenthesis that needs a match.
     *       - `low++`, `high++`.
     *    b. If `c == ')'`:
     *       - Both `low` and `high` must decrease, as we are trying to match an open parenthesis.
     *       - `low--`, `high--`.
     *    c. If `c == '*'`:
     *       - To minimize `low`, we treat `*` as a closing parenthesis `)` (if it helps balance).
     *         So, `low` decreases.
     *       - To maximize `high`, we treat `*` as an opening parenthesis `(`.
     *         So, `high` increases.
     *
     * 3. After updating `low` and `high` for each character, apply these crucial constraints:
     *    a. `low = Math.max(low, 0)`: The number of open parentheses that *must* be balanced can never be negative.
     *       If `low` drops below 0, it means we've encountered an excess of ')' that *could* be matched by
     *       a preceding `*` acting as an empty string. We effectively cap `low` at 0, as any deficit
     *       before this point can be "ignored" by `*` acting as empty.
     *    b. If `high < 0`: This is a critical check. If `high` (the maximum possible open parentheses)
     *       becomes negative, it means we have an excess of ')' that cannot be balanced even if all
     *       `*` were treated as '('. In this case, the string is invalid, and we return `false`.
     *
     * 4. After iterating through the entire string:
     *    - If `low == 0`, it means that all parentheses that *must* be balanced have been successfully balanced.
     *      If `low > 0`, it implies there are still unmatched '(' that cannot be covered by any remaining `*`
     *      (as `*` was already used to maximize `high` and minimize `low` appropriately).
     *    - Therefore, the final condition for validity is `low == 0`.
     *
     * Time Complexity: O(N), where N is the length of the string `s`.
     *   - We iterate through the string once. Each character involves constant time operations.
     * Space Complexity: O(1)
     *   - Only a few extra variables (`low`, `high`) are used.
     *
     * FAANG Tip: This greedy approach is a highly efficient and clever solution. It avoids complex
     * backtracking or stack-based solutions by tracking the *range* of possible open parenthesis counts.
     * The key insight is that `high` helps detect if you have *too many closing* parentheses, and `low`
     * helps detect if you have *too many opening* parentheses that *must* be matched.
     *
     * @param s The input string containing '(', ')', and '*'.
     * @return True if the string is a valid parenthesis string, false otherwise.
     */
    public boolean checkValidString(String s) {
        // low: minimum number of open parentheses that MUST be balanced
        // high: maximum number of open parentheses that COULD be balanced
        int low = 0;
        int high = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                low++;
                high++;
            } else if (c == ')') {
                low--;
                high--;
            } else { // c == '*'
                // When '*' is encountered:
                // To minimize 'low', treat '*' as a closing parenthesis ')' (if it helps balance).
                // If low is already 0, treating '*' as ')' would make it -1, which is invalid for 'low'
                // (as we can't have negative required open parens). So, we decrement low, but then cap it at 0.
                low--;
                // To maximize 'high', treat '*' as an opening parenthesis '('.
                high++;
            }

            // The number of open parentheses that MUST be balanced cannot be negative.
            // If 'low' drops below 0, it means we've encountered an excess ')' that *could* be matched
            // by a preceding '*' acting as an empty string. We effectively reset 'low' to 0.
            low = Math.max(low, 0);

            // If 'high' drops below 0, it means we have too many ')' that cannot be balanced
            // even if all '*' were treated as '('. Thus, the string is invalid.
            if (high < 0) {
                return false;
            }
        }

        // After iterating through the string, if 'low' is 0, it means all required open parentheses
        // have been successfully balanced. If 'low' > 0, it implies there are still unmatched '('
        // that cannot be balanced.
        return low == 0;
    }

    public static void main(String[] args) {
        var solution = new ValidParenthesisString();

        // Test Case 1: Example from LeetCode
        String s1 = "()";
        // Expected: true
        System.out.println("String: \"" + s1 + "\" -> Is valid: " + solution.checkValidString(s1));

        // Test Case 2: Example from LeetCode
        String s2 = "(*)";
        // Expected: true (can treat '*' as '(' or empty)
        System.out.println("String: \"" + s2 + "\" -> Is valid: " + solution.checkValidString(s2));

        // Test Case 3: Example from LeetCode
        String s3 = "(*))";
        // Expected: true (first '*' as '(', second '*' as ')')
        System.out.println("String: \"" + s3 + "\" -> Is valid: " + solution.checkValidString(s3));

        // Test Case 4: Invalid - too many ')'
        String s4 = "())";
        // Expected: false
        System.out.println("String: \"" + s4 + "\" -> Is valid: " + solution.checkValidString(s4));

        // Test Case 5: Invalid - too many '('
        String s5 = "((*)";
        // Expected: false (even if '*' is ')', still one '(' unmatched)
        System.out.println("String: \"" + s5 + "\" -> Is valid: " + solution.checkValidString(s5));

        // Test Case 6: Complex valid case
        String s6 = "(((((*(()((((*((**(((()()*)()()()*((((**)())*()()(((()((()*(())*(()*)(()))))())())*((()))))))))((*)()";
        // Expected: true
        System.out.println("String: \"" + s6 + "\" -> Is valid: " + solution.checkValidString(s6));

        // Test Case 7: Empty string
        String s7 = "";
        // Expected: true
        System.out.println("String: \"" + s7 + "\" -> Is valid: " + solution.checkValidString(s7));

        // Test Case 8: Only '*'
        String s8 = "***";
        // Expected: true
        System.out.println("String: \"" + s8 + "\" -> Is valid: " + solution.checkValidString(s8));

        // Test Case 9: Invalid - high becomes negative
        String s9 = "())(";
        // Expected: false
        System.out.println("String: \"" + s9 + "\" -> Is valid: " + solution.checkValidString(s9));

        // Test Case 10: Invalid - low > 0 at end
        String s10 = "(((";
        // Expected: false
        System.out.println("String: \"" + s10 + "\" -> Is valid: " + solution.checkValidString(s10));

        // Test Case 11: Another valid case
        String s11 = "(*)(*";
        // Expected: true
        System.out.println("String: \"" + s11 + "\" -> Is valid: " + solution.checkValidString(s11));

        // Test Case 12: Invalid - low > 0 at end
        String s12 = "((()))*(";
        // Expected: false
        System.out.println("String: \"" + s12 + "\" -> Is valid: " + solution.checkValidString(s12));
    }
}
