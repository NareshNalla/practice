package com.naresh.a_dsalgo.greedy.problems;

import java.util.Arrays;

/**
 * Problem: Gas Station
 * Description: Find the starting gas station index to complete a circular trip, given gas amounts and travel costs.
 */
public class GasStation {

    /**
     * Algorithm: Iterate through stations, tracking `totalGas`, `totalCost`, `tank` balance, and `startIndex`.
     * If `tank` drops below zero, reset `startIndex` to the next station and `tank` to zero.
     * Finally, if `totalGas < totalCost`, return -1; otherwise, return `startIndex`.
     *
     * @param gas An array where `gas[i]` is the amount of gas at station `i`.
     * @param cost An array where `cost[i]` is the amount of gas to travel from station `i` to `i+1`.
     * @return The starting station's index if a circuit can be completed, otherwise -1.
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // Pattern: Greedy (Single Pass) | Time: O(N), Space: O(1)
        var totalGas = 0;
        var totalCost = 0;
        var tank = 0; // Current gas in tank
        var startIndex = 0; // Potential starting station

        for (var i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
            tank += gas[i] - cost[i]; // Update tank balance

            if (tank < 0) { // If tank is negative, current path is invalid
                startIndex = i + 1; // Try next station as start
                tank = 0; // Reset tank balance
            }
        }

        return totalGas < totalCost ? -1 : startIndex; // If total gas < total cost, impossible
    }
    // FAANG Tip: The problem guarantees a unique solution if one exists. The key is that if total gas is sufficient, the `startIndex` found by resetting `tank` is the answer.

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
