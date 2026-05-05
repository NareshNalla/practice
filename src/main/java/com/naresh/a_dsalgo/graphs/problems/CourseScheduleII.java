package com.naresh.a_dsalgo.graphs.problems;

import java.util.*;

/**
 * Problem: Course Schedule II
 * Description: Return the ordering of courses you should take to finish all courses. Return empty array if impossible.
 */
public class CourseScheduleII {
    /**
     * Algorithm: Kahn's Algorithm (BFS-based Topological Sort). Record order while processing nodes with zero in-degree.
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Pattern: BFS (Topological Sort) | Time: O(V + E), Space: O(V + E)
        var adj = new ArrayList<List<Integer>>(numCourses);
        for (int i = 0; i < numCourses; i++) adj.add(new ArrayList<>());
        var inDegree = new int[numCourses];

        for (int[] pre : prerequisites) {
            adj.get(pre[1]).add(pre[0]);
            inDegree[pre[0]]++;
        }

        var queue = new ArrayDeque<Integer>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) queue.offer(i);
        }

        var res = new int[numCourses];
        var idx = 0;
        while (!queue.isEmpty()) {
            var curr = queue.poll();
            res[idx++] = curr;
            for (int neighbor : adj.get(curr)) {
                if (--inDegree[neighbor] == 0) queue.offer(neighbor);
            }
        }
        return idx == numCourses ? res : new int[0];
    }
    // FAANG Tip: Kahn's algorithm is preferred for returning the actual order as it processes nodes in "ready" state.

    public static void main(String[] args) {
        var sol = new CourseScheduleII();

        // Test Case 1: Valid ordering exists
        // Prerequisites: [[1,0]] -> 0 before 1
        int[][] prerequisites1 = {{1, 0}};
        int[] order1 = sol.findOrder(2, prerequisites1);
        System.out.println("Test Case 1 (Valid Order): " + (order1.length == 2 && order1[1] == 1 ? "PASS" : "FAIL"));

        // Test Case 2: Complex valid ordering
        // Prerequisites: [[1,0],[2,0],[3,1],[3,2]]
        int[][] prerequisites2 = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        int[] order2 = sol.findOrder(4, prerequisites2);
        System.out.println("Test Case 2 (Complex Valid): " + (order2.length == 4 ? "PASS" : "FAIL"));

        // Test Case 3: Cycle exists (no valid ordering)
        // Prerequisites: [[1,0],[0,1]]
        int[][] prerequisites3 = {{1, 0}, {0, 1}};
        int[] order3 = sol.findOrder(2, prerequisites3);
        System.out.println("Test Case 3 (Cycle/Invalid): " + (order3.length == 0 ? "PASS" : "FAIL"));

        // Test Case 4: No prerequisites
        int[][] prerequisites4 = {};
        int[] order4 = sol.findOrder(3, prerequisites4);
        System.out.println("Test Case 4 (No Prerequisites): " + (order4.length == 3 ? "PASS" : "FAIL"));
    }
}
