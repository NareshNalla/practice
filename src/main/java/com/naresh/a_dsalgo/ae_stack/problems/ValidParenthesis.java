package com.naresh.a_dsalgo.ae_stack.problems;

import java.util.*;

/**
 * Problem: Valid Parentheses
 * Description: Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', 
 * determine if the input string is valid.
 * 
 * An input string is valid if:
 * 1. Open brackets must be closed by the same type of brackets.
 * 2. Open brackets must be closed in the correct order.
 * 3. Every close bracket has a corresponding open bracket of the same type.
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * 
 * FAANG Pattern: "Mirror Matching with Stack"
 */
public class ValidParenthesis {

    /**
     * Optimal Solution using a Map and Deque (preferred over Stack).
     * This approach is highly scalable for additional bracket types.
     */
    public boolean isValid(String s) {
        // Map to store closing-to-opening bracket relationships
        Map<Character, Character> bracketMap = new HashMap<>();
        bracketMap.put(')', '(');
        bracketMap.put('}', '{');
        bracketMap.put(']', '[');

        // Deque is faster and more modern than Stack class
        Deque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if (bracketMap.containsKey(c)) {
                // Current char is a closing bracket
                if (stack.isEmpty() || stack.pop() != bracketMap.get(c)) {
                    return false;
                }
            } else {
                // Current char is an opening bracket
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    /**
     * Version using legacy Stack class and manual equality checks.
     */
    public boolean isValidStack(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                char top = stack.pop();
                if (c == ')' && top != '(') return false;
                if (c == '}' && top != '{') return false;
                if (c == ']' && top != '[') return false;
            }
        }
        return stack.isEmpty();
    }

    /**
     * Alternative 'Mirror Push' version: pushes the EXPECTED closer.
     */
    public boolean isValidMirror(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '(') stack.push(')');
            else if (c == '{') stack.push('}');
            else if (c == '[') stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c) return false;
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        ValidParenthesis validator = new ValidParenthesis();

        System.out.println("--- Valid Parentheses Validation ---");
        String[] testCases = {"()", "()[]{}", "(]", "([)]", "{[]}"};
        
        for (String test : testCases) {
            System.out.printf("Input: %-10s | Result: %b%n", test, validator.isValid(test));
        }
    }
}
