package com.naresh.a_dsalgo.ac_backtracking;

import java.util.*;

/**
 * Problem: Letter Combinations of a Phone Number
 * Description: Given a string containing digits from 2-9 inclusive, return all possible letter combinations.
 */
public class LetterCombinationsOfAPhoneNumber {
    private static final String[] MAP = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    /**
     * Algorithm: Backtracking to explore all character combinations mapping to digits.
     */
    public List<String> letterCombinations(String digits) {
        // Pattern: Backtracking (DFS) | Time: O(4^n), Space: O(n)
        var res = new ArrayList<String>();
        if (digits == null || digits.length()==0){
            return res;
        }
        backtrack(res,  digits, new StringBuilder(), 0);
        return res;
    }

    private void backtrack(List<String> res, String digits, StringBuilder path, int index) {
        if (index == digits.length()) {
            res.add(path.toString()); // Base case: end of digits reached
            return;
        }
        var letters = MAP[digits.charAt(index) - '0'];
        for (char letter : letters.toCharArray()) {
            path.append(letter); // Add
            backtrack(res, digits,  path , index + 1 ); // Explore
            path.setLength(path.length() - 1);  // Remove (Backtrack)
        }
    }
    // FAANG Tip: Use StringBuilder for path construction to avoid immutable String overhead in O(4^n) operations.

    /**
     * Algorithm: Backtracking using String concatenation. New String is created for each call, handling backtrack implicitly.
     */
    public List<String> letterCombinationsString(String digits) {
        // Pattern: Recursive String Concatenation | Time: O(4^n), Space: O(n^2)
        List<String> res = new ArrayList<>();
        if (digits == null || digits.isEmpty()) return res;
        backtrackString(res, digits, "", 0);
        return res;
    }

    private void backtrackString(List<String> res, String digits, String path, int index) {
        if (index == digits.length()) {
            res.add(path); // Base case reached
            return;
        }
        var letters = MAP[digits.charAt(index) - '0'];
        for (char letter : letters.toCharArray()) {
            backtrackString(res, digits, path + letter, index + 1); // New string passed to next call
        }
    }
    // FAANG Tip: Passing 'path + letter' creates a new String, so no explicit backtracking is needed. Note O(n^2) space due to string immutability.

    public static void main(String[] args) {
        var solution = new LetterCombinationsOfAPhoneNumber();
        System.out.println("Digits '23' (SB): " + solution.letterCombinations("23"));
        System.out.println("Digits '23' (String): " + solution.letterCombinationsString("23"));
    }
}
