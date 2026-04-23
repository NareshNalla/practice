package com.naresh.a_dsalgo.stack.implementation.problems;

import java.util.*;

public class ValidParenthesis {

    public boolean isValidStackMap(String s) {
        Stack<Character> stack = new Stack<>(); // Use generics for type safety
        char[] ch = s.toCharArray();

        Map<Character , Character> closeToOpenMap = new HashMap<>();
        closeToOpenMap.put(')' , '(');
        closeToOpenMap.put('}', '{');
        closeToOpenMap.put(']', '[');

        for (char c : ch) {
            // Use logical OR (||) instead of bitwise OR (|)
            if (closeToOpenMap.containsKey(c)) {
                if (stack.isEmpty() && stack.peek() == closeToOpenMap.get(c)) {
                    stack.pop();
                } else{
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty(); // All opening brackets must have been closed
    }
    // Solution using java.util.Stack (corrected version)
    public boolean isValidStack(String s) {
        Stack<Character> stack = new Stack<>(); // Use generics for type safety
        char[] ch = s.toCharArray();

        for (char c : ch) {
            // Use logical OR (||) instead of bitwise OR (|)
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false; // Closing bracket without a matching opening bracket
                }
                char top = stack.pop(); // No need for cast with generics
                // Corrected matching logic
                if (c == ')' && top != '(') return false;
                if (c == '}' && top != '{') return false; // Corrected: top should be '{'
                if (c == ']' && top != '[') return false; // Corrected: top should be '['
            }
        }
        return stack.isEmpty(); // All opening brackets must have been closed
    }

    // Solution using java.util.Deque (ArrayDeque implementation)
    public boolean isValidDeque(String s) {
        // ArrayDeque is generally preferred over Stack as it's faster and not synchronized
        Deque<Character> stack = new ArrayDeque<>();
        char[] ch = s.toCharArray();

        for (char c : ch) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c); // push() adds to the front (top of stack)
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop(); // pop() removes from the front (top of stack)
                if (c == ')' && top != '(') return false;
                if (c == '}' && top != '{') return false;
                if (c == ']' && top != '[') return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        ValidParenthesis validator = new ValidParenthesis();

        // Test cases for isValidStack
        System.out.println("--- Testing isValidStack ---");
        System.out.println("()[]{} is valid: " + validator.isValidStackMap("()[]{}")); // Expected: true
        System.out.println("([{}]) is valid: " + validator.isValidStack("([{}])")); // Expected: true
        System.out.println("({[()]}) is valid: " + validator.isValidStack("({[()]})")); // Expected: true
        System.out.println("([)] is valid: " + validator.isValidStack("([)]"));     // Expected: false
        System.out.println("{[} is valid: " + validator.isValidStack("{[}"));       // Expected: false
        System.out.println("( is valid: " + validator.isValidStack("("));           // Expected: false
        System.out.println("} is valid: " + validator.isValidStack("}"));           // Expected: false
        System.out.println("'' is valid: " + validator.isValidStack(""));           // Expected: true

        // Test cases for isValidDeque
        System.out.println("\n--- Testing isValidDeque ---");
        System.out.println("()[]{} is valid: " + validator.isValidDeque("()[]{}")); // Expected: true
        System.out.println("([{}]) is valid: " + validator.isValidDeque("([{}])")); // Expected: true
        System.out.println("({[()]}) is valid: " + validator.isValidDeque("({[()]})")); // Expected: true
        System.out.println("([)] is valid: " + validator.isValidDeque("([)]"));     // Expected: false
        System.out.println("{[} is valid: " + validator.isValidDeque("{[}"));       // Expected: false
        System.out.println("( is valid: " + validator.isValidDeque("("));           // Expected: false
        System.out.println("} is valid: " + validator.isValidDeque("}"));           // Expected: false
        System.out.println("'' is valid: " + validator.isValidDeque(""));           // Expected: true
    }
}
