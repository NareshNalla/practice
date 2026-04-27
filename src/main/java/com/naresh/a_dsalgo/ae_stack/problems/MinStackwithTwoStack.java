package com.naresh.a_dsalgo.ae_stack.problems;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Problem: Min Stack (Two-Stack Implementation)
 * Description: Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * 
 * Strategy: Maintain two stacks:
 * 1. Main Stack: Stores all elements.
 * 2. Min Stack: Tracks the minimums. We only push to Min Stack if the new value is <= current min.
 * 
 * Time Complexity: O(1) for all operations.
 * Space Complexity: O(n) to store elements.
 * 
 * FAANG Pattern: "Auxiliary State Tracking"
 * This approach is space-optimized compared to storing pairs because the min-stack only grows
 * when a new minimum (or equal to current min) is encountered.
 */
public class MinStackwithTwoStack {

    // Using Deque/ArrayDeque over legacy Stack class
    private Deque<Integer> stack;
    private Deque<Integer> minStack;

    public MinStackwithTwoStack() {
        this.stack = new ArrayDeque<>();
        this.minStack = new ArrayDeque<>();
    }

    /**
     * Pushes the element val onto the stack.
     * Always push to the main stack. Push to minStack only if it's the first element
     * or if the value is less than or equal to the current minimum.
     */
    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    /**
     * Removes the element on the top of the stack.
     * If the value being popped is the current minimum, pop it from minStack too.
     */
    public void pop() {
        if (stack.isEmpty()) return;
        
        int top = stack.pop();
        // Use .equals() or ensure int comparison if using Integer objects
        if (top == minStack.peek()) {
            minStack.pop();
        }
    }

    /**
     * Gets the top element of the stack.
     */
    public int top() {
        return stack.isEmpty() ? -1 : stack.peek();
    }

    /**
     * Retrieves the minimum element in the stack.
     */
    public int getMin() {
        return minStack.isEmpty() ? -1 : minStack.peek();
    }

    public static void main(String[] args) {
        MinStackwithTwoStack ms = new MinStackwithTwoStack();
        
        System.out.println("--- MinStack (Two Stacks) Validation ---");
        
        ms.push(-2);
        ms.push(0);
        ms.push(-3);
        System.out.println("Min: " + ms.getMin()); // -3
        
        ms.pop();
        System.out.println("Top: " + ms.top());    // 0
        System.out.println("Min: " + ms.getMin()); // -2
        
        // Testing duplicate minimums
        ms.push(-2);
        ms.push(-2);
        System.out.println("Min after duplicates: " + ms.getMin()); // -2
        ms.pop();
        System.out.println("Min after one pop: " + ms.getMin());      // -2
    }
}
