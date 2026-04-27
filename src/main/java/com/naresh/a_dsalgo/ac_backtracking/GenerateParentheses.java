package com.naresh.a_dsalgo.ac_backtracking;

import java.util.*;

/**
 * Problem: Generate Parentheses
 * Description: Given n pairs of parentheses, generate all combinations of well-formed parentheses.
 */
public class GenerateParentheses {
    /**
     * Algorithm: Backtracking with count-based pruning. Add '(' if open < n, add ')' if close < open.
     */
    public List<String> generateParenthesis(int n) {
        // Pattern: Backtracking (Pruning) | Time: O(4^n / sqrt(n)), Space: O(n)
        var res = new ArrayList<String>();
        backtrack(new StringBuilder(), 0, 0, n, res);
        return res;
    }

    private void backtrack(StringBuilder sb, int open, int close, int n, List<String> res) {
        if (sb.length() == n * 2) {
            res.add(sb.toString()); // Base case: all pairs used
            return;
        }
        if (open < n) {
            sb.append('('); // Choose '('
            backtrack(sb, open + 1, close, n, res); // Explore
            sb.setLength(sb.length() - 1); // Backtrack
        }
        if (close < open) {
            sb.append(')'); // Choose ')'
            backtrack(sb, open, close + 1, n, res); // Explore
            sb.setLength(sb.length() - 1); // Backtrack
        }
    }
    // FAANG Tip: Valid parentheses require 'open count >= close count' at every step. Use StringBuilder to save space.

    public static void main(String[] args) {
        var solution = new GenerateParentheses();
        System.out.println("n=3: " + solution.generateParenthesis(3));
    }
}
