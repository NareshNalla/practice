package com.naresh.a_dsalgo.greedy.problems;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Problem: Fractional Knapsack
 * Description: Given a set of items, each with a weight and a value, determine which items
 * to include in a collection so that the total weight is less than or equal to a given capacity
 * and the total value is as large as possible. Items can be broken into fractions.
 */
public class FractionalKnapsack {

    /**
     * Represents an item with a value, weight, and its value-to-weight ratio.
     */
    public static class Item {
        int value;
        int weight;
        double ratio;

        public Item(int value, int weight) {
            this.value = value;
            this.weight = weight;
            this.ratio = (weight == 0) ? 0 : (double) value / weight; // Handle zero weight
        }

        @Override
        public String toString() {
            return "Item{value=" + value + ", weight=" + weight + ", ratio=" + String.format("%.2f", ratio) + "}";
        }
    }

    /**
     * Algorithm: Calculate value-to-weight ratio for each item. Sort items by ratio (descending).
     * Iterate through sorted items, taking whole items if capacity allows, or a fraction if not.
     *
     * @param items An array of Item objects.
     * @param capacity The maximum weight the knapsack can hold.
     * @return The maximum total value that can be obtained.
     */
    public static double getMaxProfit(Item[] items, int capacity) {
        // Pattern: Greedy (Sorting) | Time: O(N log N), Space: O(N)
        if (items == null || items.length == 0 || capacity <= 0) return 0.0; // Handle edge cases

        // Sort items by value-to-weight ratio in descending order
        Arrays.sort(items, (item1, item2) -> Double.compare(item2.ratio, item1.ratio));

        var totalValue = 0.0;
        var remainingCapacity = capacity;

        for (var item : items) {
            if (remainingCapacity == 0) break; // Knapsack is full

            if (item.weight <= remainingCapacity) { // Take the whole item
                totalValue += item.value;
                remainingCapacity -= item.weight;
            } else { // Take a fraction of the item
                var fraction = (double) remainingCapacity / item.weight;
                totalValue += (item.value * fraction);
                remainingCapacity = 0; // Knapsack is now full
            }
        }
        return totalValue;
    }
    // FAANG Tip: Fractional Knapsack is greedy due to divisibility; 0/1 Knapsack requires DP.

    public static void main(String[] args) {
        // Test Case 1
        Item[] items1 = {
            new Item(60, 10), new Item(100, 20), new Item(120, 30), new Item(40, 40)
        };
        var capacity1 = 50;
        System.out.println("Items: " + Arrays.toString(items1) + ", Capacity: " + capacity1 +
                           " -> Max Profit: " + getMaxProfit(items1, capacity1)); // Expected: 240.0

        // Test Case 2
        Item[] items2 = {
            new Item(10, 2), new Item(20, 3), new Item(30, 5)
        };
        var capacity2 = 10;
        System.out.println("Items: " + Arrays.toString(items2) + ", Capacity: " + capacity2 +
                           " -> Max Profit: " + getMaxProfit(items2, capacity2)); // Expected: 60.0

        // Test Case 3: Capacity less than smallest item
        Item[] items3 = { new Item(100, 50) };
        var capacity3 = 25;
        System.out.println("Items: " + Arrays.toString(items3) + ", Capacity: " + capacity3 +
                           " -> Max Profit: " + getMaxProfit(items3, capacity3)); // Expected: 50.0

        // Test Case 4: Empty items array
        Item[] items4 = {};
        var capacity4 = 10;
        System.out.println("Items: " + Arrays.toString(items4) + ", Capacity: " + capacity4 +
                           " -> Max Profit: " + getMaxProfit(items4, capacity4)); // Expected: 0.0
    }
}
