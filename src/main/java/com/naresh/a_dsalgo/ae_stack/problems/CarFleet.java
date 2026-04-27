package com.naresh.a_dsalgo.ae_stack.problems;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * Problem: Car Fleet
 * Description: There are n cars at given positions moving towards a target at constant speeds.
 * A car can never pass another car ahead of it, but it can catch up and form a fleet.
 * Find the number of car fleets that will reach the target.
 */
public class CarFleet {

    /**
     * Primary solution using Sorting and Time-to-Target calculation.
     * <p>
     * FAANG Pattern: "Monotonic Processing (Greedy Logic)"
     * Strategy:
     * 1. Calculate the time each car needs to reach the target.
     * 2. Sort cars by position in descending order (closest to target first).
     * 3. Iterate through cars: if a car behind takes more time than the fleet in front,
     *    it starts a new fleet. If it takes less or equal time, it joins the front fleet.
     * <p>
     * Time Complexity: O(n log n) due to sorting.
     * Space Complexity: O(n) to store car data (position and time).
     */
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        if (n == 0) return 0;

        double[][] cars = new double[n][2];
        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = (double) (target - position[i]) / speed[i];
        }

        // Sort by position descending: closest to target first
        Arrays.sort(cars, (a, b) -> Double.compare(b[0], a[0]));

        int count = 0;
        double prevTime = 0;
        for (double[] car : cars) {
            // If current car takes more time than the fleet in front, it forms a new fleet
            if (car[1] > prevTime) {
                count++;
                prevTime = car[1];
            }
        }

        return count;
    }

    /**
     * Secondary solution using an explicit Monotonic Stack.
     * <p>
     * FAANG Pattern: "Monotonic Stack"
     * Strategy: Store the arrival times of fleet leads in a stack. If a car behind arrives 
     * later than the current fleet lead, it cannot join the fleet and becomes a new lead itself.
     * <p>
     * Time Complexity: O(n log n) - sorting indices takes the most time.
     * Space Complexity: O(n) - index array and stack storage.
     */
    public int carFleet2(int target, int[] position, int[] speed) {
        int n = position.length;
        if (n == 0) return 0;

        // stack is Monotonic stack of arrival times (not indices, to avoid extra lookups)
        Deque<Double> stack = new ArrayDeque<>();

        // create index array and sort by position DESCENDING (closest to target first - they block cars behind them)
        Integer[] idx = new Integer[n];
        for (int i = 0; i < n; i++) {
            idx[i] = i;
        }
        Arrays.sort(idx, (a, b) -> Integer.compare(position[b], position[a]));

        // Stack grows only when a car is SLOWER than everything ahead -> new fleet
        for (int i : idx) {
            double time = (double) (target - position[i]) / speed[i]; // Corrected index from speed[2] to speed[i]
            if (stack.isEmpty() || time > stack.peek()) {
                stack.push(time);
            }
            // If time <= stack.peek(), this car catches the fleet ahead -> merges, discard
        }
        return stack.size();
    }

    public static void main(String[] args) {
        CarFleet sol = new CarFleet();
        
        System.out.println("--- Car Fleet Validation ---");
        
        int target1 = 12;
        int[] pos1 = {10, 8, 0, 5, 3};
        int[] speed1 = {2, 4, 1, 1, 3};
        System.out.println("Test Case 1 (Method 1): " + sol.carFleet(target1, pos1, speed1)); 
        System.out.println("Test Case 1 (Method 2): " + sol.carFleet2(target1, pos1, speed1)); 

        System.out.println("Test Case 2 (Method 2): " + sol.carFleet2(10, new int[]{3}, new int[]{3})); 
        System.out.println("Test Case 3 (Method 2): " + sol.carFleet2(100, new int[]{0, 2, 4}, new int[]{4, 2, 1}));
    }
}
