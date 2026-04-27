package com.naresh.a_dsalgo.ae_stack.problems;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Set;
import java.util.Stack;

/**
 * Problem: Evaluate Reverse Polish Notation (Postfix Expression)
 * Description: Evaluate the value of an arithmetic expression in RPN.
 * Valid operators are '+', '-', '*', and '/'. Each operand may be an integer or another expression.
 */
public class EvaluateReversePolishNotation {

    /**
     * Primary solution using Deque and modern Switch expressions.
     * <p>
     * FAANG Pattern: "Postfix Evaluation / Stack Processing"
     * Strategy: Use a stack to store operands. When an operator is encountered, pop the top two elements (b then a),
     * apply the operator (a op b), and push the result back.
     * <p>
     * Time Complexity: O(n) - Single pass through tokens.
     * Space Complexity: O(n) - Max depth of stack in worst case.
     */
    public int evalRPN(String[] tokens) {
        // ArrayDeque is the standard for stack implementations in modern Java
        Deque<Integer> stack = new ArrayDeque<>();
        Set ops = Set.of("+", "-", "*", "/");
        for (String t : tokens) {
            if (!ops.contains(t)) {
                stack.push(Integer.parseInt(t));
                continue;
            }
            int b = stack.pop();
            int a = stack.pop();
            switch (t) {
                case "+" -> stack.push(a + b);
                case "*" -> stack.push(a * b);
                case "-" -> stack.push(a - b);
                case "/" -> stack.push(a / b);
            }
        }
        return stack.pop();
    }

    /**
     * Secondary solution using legacy Stack class and if-else logic.
     * <p>
     * FAANG Pattern: "Postfix Evaluation / Stack Processing"
     * Strategy: Similar stack-based processing, using manual string comparison and legacy Stack class.
     * <p>
     * Time Complexity: O(n) - Single pass through tokens.
     * Space Complexity: O(n) - Stack stores operands.
     */
    public int evalRPN2nd(String[] tokens) {

        Stack<Integer> stack = new Stack<>();
        for (String s1 : tokens) {

            if (s1.equals("+")) {
                stack.push(stack.pop() + stack.pop());
            } else if (s1.equals("-")) {
                int first = stack.pop();
                int second = stack.pop();

                stack.push(second - first);
            } else if (s1.equals("*")) {
                stack.push(stack.pop() * stack.pop());
            } else if (s1.equals("/")) {
                int first = stack.pop();
                int second = stack.pop();
                stack.push(second / first);
            } else {
                stack.push(Integer.parseInt(s1));
            }
        }

        return stack.pop();
    }

    public static void main(String[] args) {
        EvaluateReversePolishNotation evaluator = new EvaluateReversePolishNotation();

        // Example: ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) = 9
        String[] tokens1 = {"2", "1", "+", "3", "*"};
        System.out.println("Result 1: " + evaluator.evalRPN(tokens1));
        System.out.println("Result 2: " + evaluator.evalRPN2nd(tokens1));

    }
    /*
      // Java 14+ switch expressions
        int result = switch (token) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            case "/" -> a / b;
            default -> throw new IllegalArgumentException("Invalid operator: " + token);
        };
     */
}
