package com.naresh.a_dsalgo.greedy.problems;

import java.util.Arrays;

/**
 * Problem: Gas Station
 * Description: Find the starting gas station index to complete a circular trip, given gas amounts and travel costs.
 */
public class GasStation {

    /**
     * Algorithm: Calculate net gas difference. If total is negative, return -1. Otherwise, iterate
     * to find a starting point where current tank never drops below zero.
     *
     * @param gas An array where `gas[i]` is the amount of gas at station `i`.
     * @param cost An array where `cost[i]` is the amount of gas to travel from station `i` to `i+1`.
     * @return The starting station's index if a circuit can be completed, otherwise -1.
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // Pattern: Greedy (Single Pass) | Time: O(N), Space: O(1)
        var totalGasDiff = 0; // Total net gas change over the entire circuit
        var currentTank = 0;  // Gas in the tank starting from current potential start_station
        var startStation = 0; // Potential starting station index

        for (var i = 0; i < gas.length; i++) {
            var diff = gas[i] - cost[i]; // Net gas change at current station
            totalGasDiff += diff;
            currentTank += diff;

            if (currentTank < 0) { // Cannot reach next station from current start
                currentTank = 0; // Reset tank
                startStation = i + 1; // Try next station as start
            }
        }
        return totalGasDiff >= 0 ? startStation : -1; // If total diff is non-negative, solution exists
    }
    // FAANG Tip: If total gas >= total cost, a unique solution always exists. The key is finding it by resetting the start point.

    public static void main(String[] args) {
        var solution = new GasStation();

        var gas1 = new int[]{1, 2, 3, 4, 5};
        var cost1 = new int[]{3, 4, 5, 1, 2};
        System.out.println("Gas: " + Arrays.toString(gas1) + ", Cost: " + Arrays.toString(cost1) +
                           " -> Start Station: " + solution.canCompleteCircuit(gas1, cost1)); // Expected: 3

        var gas2 = new int[]{2, 3, 4};
        var cost2 = new int[]{3, 4, 3};
        System.out.println("Gas: " + Arrays.toString(gas2) + ", Cost: " + Arrays.toString(cost2) +
                           " -> Start Station: " + solution.canCompleteCircuit(gas2, cost2)); // Expected: -1

        var gas3 = new int[]{5, 1, 2, 3, 4};
        var cost3 = new int[]{4, 4, 1, 5, 1};
        System.out.println("Gas: " + Arrays.toString(gas3) + ", Cost: " + Arrays.toString(cost3) +
                           " -> Start Station: " + solution.canCompleteCircuit(gas3, cost3)); // Expected: 4

        var gas4 = new int[]{10};
        var cost4 = new int[]{5};
        System.out.println("Gas: " + Arrays.toString(gas4) + ", Cost: " + Arrays.toString(cost4) +
                           " -> Start Station: " + solution.canCompleteCircuit(gas4, cost4)); // Expected: 0

        var gas5 = new int[]{5};
        var cost5 = new int[]{10};
        System.out.println("Gas: " + Arrays.toString(gas5) + ", Cost: " + Arrays.toString(cost5) +
                           " -> Start Station: " + solution.canCompleteCircuit(gas5, cost5)); // Expected: -1
    }
}
