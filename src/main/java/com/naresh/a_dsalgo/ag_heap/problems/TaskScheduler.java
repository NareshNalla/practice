package com.naresh.a_dsalgo.ag_heap.problems;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Problem: Task Scheduler (LeetCode 621)
 * Description: Given a character array `tasks` representing CPU tasks and a non-negative integer `n`
 * representing the cooldown period between two same tasks. Return the minimum number of units of time
 * the CPU will take to finish all the given tasks.
 */
public class TaskScheduler {

    /**
     * Algorithm: Greedy approach. The minimum time is determined by the most frequent task.
     * Calculate the frequency of each task. Find the maximum frequency (`maxFreq`).
     * The minimum time will be at least `(maxFreq - 1) * (n + 1) + (count of tasks with maxFreq)`.
     * This accounts for the slots created by the most frequent tasks and their cooldowns.
     * The total time cannot be less than the total number of tasks.
     *
     * @param tasks A character array representing the types of tasks.
     * @param n The non-negative cooldown period between two same tasks.
     * @return The minimum number of units of time to finish all tasks.
     */
    public int leastInterval(char[] tasks, int n) {
        // Pattern: Greedy (Frequency Count) | Time: O(N), Space: O(1)
        if (tasks == null || tasks.length == 0) return 0;

        var frequencies = new int[26]; // Store frequencies of 'A' through 'Z'
        for (var task : tasks) frequencies[task - 'A']++; // Count frequencies

        Arrays.sort(frequencies); // Sort frequencies to easily find maxFreq
        var maxFreq = frequencies[25]; // Highest frequency
        var idleSlots = (maxFreq - 1) * n; // Minimum idle slots required by maxFreq task

        for (var i = 24; i >= 0; i--) { // Iterate from second highest frequency
            idleSlots -= Math.min(maxFreq - 1, frequencies[i]); // Fill idle slots with other tasks
        }

        idleSlots = Math.max(0, idleSlots); // Idle slots cannot be negative
        return tasks.length + idleSlots; // Total time = total tasks + remaining idle slots
    }
    // FAANG Tip: The key insight is that the most frequent task dictates the minimum length of the schedule. Other tasks fill the idle slots.

    public static void main(String[] args) {
        var solution = new TaskScheduler();

        // Test Case 1: Example from LeetCode
        var tasks1 = new char[]{'A', 'A', 'A', 'B', 'B', 'B'};
        var n1 = 2;
        // Expected: 8 (A -> B -> idle -> A -> B -> idle -> A -> B)
        System.out.println("Tasks: " + Arrays.toString(tasks1) + ", n: " + n1 +
                           " -> Least Interval: " + solution.leastInterval(tasks1, n1));

        // Test Case 2: No cooldown needed
        var tasks2 = new char[]{'A', 'A', 'A', 'B', 'B', 'B'};
        var n2 = 0;
        // Expected: 6 (A -> B -> A -> B -> A -> B)
        System.out.println("Tasks: " + Arrays.toString(tasks2) + ", n: " + n2 +
                           " -> Least Interval: " + solution.leastInterval(tasks2, n2));

        // Test Case 3: More tasks than cooldown slots
        var tasks3 = new char[]{'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        var n3 = 2;
        // Expected: 12 (Total tasks, as enough diverse tasks to fill idle slots)
        System.out.println("Tasks: " + Arrays.toString(tasks3) + ", n: " + n3 +
                           " -> Least Interval: " + solution.leastInterval(tasks3, n3));

        // Test Case 4: Single task type
        var tasks4 = new char[]{'A', 'A', 'A'};
        var n4 = 2;
        // Expected: 7 (A -> idle -> idle -> A -> idle -> idle -> A)
        System.out.println("Tasks: " + Arrays.toString(tasks4) + ", n: " + n4 +
                           " -> Least Interval: " + solution.leastInterval(tasks4, n4));

        // Test Case 5: Two task types, one much more frequent
        var tasks5 = new char[]{'A', 'A', 'A', 'A', 'B'};
        var n5 = 2;
        // Expected: 10 (A -> B -> idle -> A -> idle -> idle -> A -> idle -> idle -> A)
        System.out.println("Tasks: " + Arrays.toString(tasks5) + ", n: " + n5 +
                           " -> Least Interval: " + solution.leastInterval(tasks5, n5));
    }
}
