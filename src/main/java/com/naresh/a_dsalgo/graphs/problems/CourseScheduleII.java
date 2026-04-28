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
}
