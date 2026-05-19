package com.naresh.a_dsalgo.ag_heap.problems;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Arrays; // For Arrays.toString in main method

/**
 * Problem: Last Stone Weight (LeetCode 1046)
 * Description: You are given an array of integers `stones` where `stones[i]` is the weight of the i-th stone.
 * We are playing a game with the stones. On each turn, we choose the two heaviest stones and smash them together.
 * Suppose the stones have weights `x` and `y` with `x <= y`. The result of this smash is:
 * - If `x == y`, both stones are destroyed.ju
 * - If `x != y`, the stone of weight `x` is destroyed, and the stone of weight `y` has new weight `y - x`.
 * At the end of the game, there is at most one stone left. Return the weight of the last remaining stone (or 0 if no stones remain).
 */
public class LastStoneWeight {

    /**
     * Algorithm: Use a max-priority queue to efficiently retrieve the two heaviest stones.
     * Repeatedly extract the two largest, smash them, and re-insert the remainder (if any)
     * until one or zero stones are left.
     *
     * @param stones An array of integers representing the weights of the stones.
     * @return The weight of the last remaining stone, or 0 if no stones remain.
     */
    public int lastStoneWeight(int[] stones) {
        // Pattern: Max-Heap | Time: O(N log N), Space: O(N)
        var pq = new PriorityQueue<Integer>(Collections.reverseOrder()); // Max-heap
        for (var s : stones) pq.offer(s); // Add all stones to heap

        while (pq.size() > 1) { // Smash until one or zero stones remain
            var y = pq.poll(); // Heaviest stone
            var x = pq.poll(); // Second heaviest stone
            if (x != y) pq.offer(y - x); // If weights differ, re-insert remainder
        }
        return pq.isEmpty() ? 0 : pq.poll(); // Return last stone's weight or 0
    }
    // FAANG Tip: Max-heap is ideal for "largest K" or "two largest" problems. Each smash involves O(log N) heap operations.

    public static void main(String[] args) {
        var sol = new LastStoneWeight();

        var stones1 = new int[]{2, 7, 4, 1, 8, 1};
        System.out.println("Stones: " + Arrays.toString(stones1) + " -> Last Stone Weight: " + sol.lastStoneWeight(stones1)); // Expected: 1

        var stones2 = new int[]{1};
        System.out.println("Stones: " + Arrays.toString(stones2) + " -> Last Stone Weight: " + sol.lastStoneWeight(stones2)); // Expected: 1

        var stones3 = new int[]{2, 2};
        System.out.println("Stones: " + Arrays.toString(stones3) + " -> Last Stone Weight: " + sol.lastStoneWeight(stones3)); // Expected: 0

        var stones4 = new int[]{1, 1, 1, 1};
        System.out.println("Stones: " + Arrays.toString(stones4) + " -> Last Stone Weight: " + sol.lastStoneWeight(stones4)); // Expected: 0

        var stones5 = new int[]{10, 4, 2, 1};
        System.out.println("Stones: " + Arrays.toString(stones5) + " -> Last Stone Weight: " + sol.lastStoneWeight(stones5)); // Expected: 1
    }
}
