package com.naresh.a_dsalgo.graphs.problems;

import java.util.*;

/**
 * Problem: Course Schedule
 * Description: Determine if it's possible to finish all courses given prerequisite dependencies.
 * Essentially: check if the graph contains a cycle.
 */
public class CourseSchedule {
    /**
     * Algorithm: Kahn's Algorithm (BFS-based Topological Sort). Track in-degrees; if topological sort contains all nodes, no cycle exists.
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Pattern: BFS (Topological Sort) | Time: O(V + E), Space: O(V + E)
        var adj = new ArrayList<List<Integer>>(numCourses);
        for (int i = 0; i < numCourses; i++) adj.add(new ArrayList<>());
        var inDegree = new int[numCourses];
        
        for (int[] pre : prerequisites) {
            adj.get(pre[1]).add(pre[0]);
            inDegree[pre[0]]++; // Build adj list and in-degrees
        }

        var queue = new ArrayDeque<Integer>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) queue.offer(i); // Start with nodes having no prerequisites
        }

        var count = 0;
        while (!queue.isEmpty()) {
            var curr = queue.poll();
            count++;
            for (int neighbor : adj.get(curr)) {
                if (--inDegree[neighbor] == 0) queue.offer(neighbor); // Reduce in-degree and add if zero
            }
        }
        return count == numCourses; // All courses processed
    }
    // FAANG Tip: Cycle detection can also be done via DFS with recursion stack tracking. BFS is more robust against deep recursion.
}
