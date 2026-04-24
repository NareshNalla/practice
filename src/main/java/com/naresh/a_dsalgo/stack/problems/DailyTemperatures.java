package com.naresh.a_dsalgo.stack.problems;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * Problem: Daily Temperatures
 * Description: Given an array of integers temperatures represents the daily temperatures, 
 * return an array answer such that answer[i] is the number of days you have to wait 
 * after the i-th day to get a warmer temperature.
 * 
 * Strategy:
 * 1. Use a Monotonic Decreasing Stack to store indices of temperatures.
 * 2. As we iterate, if the current temperature is warmer than the temperature at 
 *    the index on top of the stack:
 *    - Pop the index and calculate the difference (current_index - popped_index).
 *    - Store this difference in the answer array.
 * 3. Push the current index onto the stack and repeat.
 */
public class DailyTemperatures {

    /**
     * Primary solution using a Monotonic Stack.
     * <p>
     * FAANG Pattern: "Monotonic Stack (Next Greater Element)"
     * Strategy: Store indices in a stack. When a warmer temperature is found, resolve 
     * all previous days in the stack that are colder than the current day.
     * <p>
     * Time Complexity: O(n) - Each element is pushed and popped at most once.
     * Space Complexity: O(n) - To store indices in the stack.
     */
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];
        
        // Deque/ArrayDeque is preferred over the legacy Stack class
        Deque<Integer> stack = new ArrayDeque<>();
        
        for (int i = 0; i < n; i++) {
            // While current temperature is warmer than the temperature at the top of the stack
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int index = stack.pop();
                answer[index] = i - index; // Distance to the next warmer day
            }
            stack.push(i);
        }
        
        return answer;
    }

    public static void main(String[] args) {
        DailyTemperatures sol = new DailyTemperatures();
        
        System.out.println("--- Daily Temperatures Validation ---");
        
        // Test Case 1: Standard case
        int[] temp1 = {73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println("Input:  " + Arrays.toString(temp1));
        System.out.println("Output: " + Arrays.toString(sol.dailyTemperatures(temp1)));
        // Expected: [1, 1, 4, 2, 1, 1, 0, 0]

        // Test Case 2: Always increasing
        int[] temp2 = {30, 40, 50, 60};
        System.out.println("\nInput:  " + Arrays.toString(temp2));
        System.out.println("Output: " + Arrays.toString(sol.dailyTemperatures(temp2)));
        // Expected: [1, 1, 1, 0]

        // Test Case 3: Always decreasing
        int[] temp3 = {90, 80, 70};
        System.out.println("\nInput:  " + Arrays.toString(temp3));
        System.out.println("Output: " + Arrays.toString(sol.dailyTemperatures(temp3)));
        // Expected: [0, 0, 0]
    }
}
