package com.naresh.a_dsalgo.ae_stack.problems;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 *
 * Two stacks: main stack + min-tracker stack. Push current min alongside every push. O(1) getMin.
 */
public class MinStack {

    /*1.
    Time Complexity: O(1) for all operations (push, pop, top, getMin).
 * Space Complexity: O(n) to store elements.
 *
 * FAANG Pattern: "Value-Min Synchronization"
 * By storing the state of the minimum at every level, we eliminate the need
 * for complex conditional logic during pops.
 Tip: Push to minStack only when new val ≤ current min, or always push — both work. Always-push is simpler.
   FAANG tip: Follow-up: do it with one stack storing pairs (val, currentMin). Shows you understand space trade-offs.
     */
    private Deque<int[]> stack;
    public MinStack() {
        this.stack = new ArrayDeque<>();
    }

    public void push(int val) {
        int currMin = stack.isEmpty() ? val : Math.min(val, stack.peek()[1]);
        stack.push(new int[]{val, currMin});
    }

    public void pop() {
        if (!stack.isEmpty()) {
            stack.pop();
        }
    }

    public int top() {
        return stack.isEmpty() ? -1 : stack.peek()[0];
    }

    public int getMin() {
        return stack.isEmpty() ? -1 : stack.peek()[1];
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        
        System.out.println("--- MinStack Validation ---");
        
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        
        System.out.println("1. getMin() after [-2, 0, -3]: " + minStack.getMin()); // Expected: -3
        
        minStack.pop();
        System.out.println("2. top() after one pop: " + minStack.top());           // Expected: 0
        System.out.println("3. getMin() after one pop: " + minStack.getMin());    // Expected: -2
        
        minStack.push(-1);
        System.out.println("4. getMin() after pushing -1: " + minStack.getMin());  // Expected: -2
        
        minStack.push(-5);
        System.out.println("5. getMin() after pushing -5: " + minStack.getMin());  // Expected: -5
    }
}
