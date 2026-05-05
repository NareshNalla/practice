package com.naresh.a_dsalgo.graphs.problems;

import java.util.*;

/**
 * Problem: Course Schedule
 * Description: Determine if it's possible to finish all courses given prerequisite dependencies.
 * Essentially: check if the graph contains a cycle.
 */
public class CourseSchedule {
    /**
     * Algorithm: DFS with 3-state visited array for cycle detection.
     * States: 0=not visited, 1=visiting (in current path), 2=visited (processed)
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Pattern: DFS (Cycle Detection) | Time: O(V + E), Space: O(V + E)
        // Build adjacency list: course -> list of courses that depend on it
        List<List<Integer>> courseGraph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) courseGraph.add(new ArrayList<>());
        for (int[] pre : prerequisites) {
            courseGraph.get(pre[1]).add(pre[0]); // pre[1] must be taken before pre[0]
        }
        // 0: not visited, 1: visiting (in current path), 2: visited (processed)
        int[] visited = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0 && courseSChedule(i, courseGraph, visited)) {
                return false; // Cycle detected
            }
        }
        return true; // No cycles found
    }
    
    private boolean courseSChedule(int course, List<List<Integer>> graph, int[] visited) {
        visited[course] = 1; // Mark as visiting (in current path)
        
        for (int next : graph.get(course)) {
            if (visited[next] == 1) return true; // Cycle detected - back edge to visiting node
            if (visited[next] == 0 && courseSChedule(next, graph, visited)) {
                return true; // Cycle in recursive call
            }
        }
        visited[course] = 2; // Mark as fully processed
        return false;
    }
    // FAANG Tip: DFS cycle detection is preferred in interviews as it demonstrates deeper understanding of graph traversal and recursion. The 3-state visited array prevents false positives.

    public static void main(String[] args) {
        var sol = new CourseSchedule();

        // Test Case 1: Courses with circular dependency (cycle exists)
        // Prerequisites: [[1,0],[0,1]] -> 0 and 1 depend on each other
        int[][] prerequisites1 = {{1, 0}, {0, 1}};
        System.out.println("Test Case 1 (Cycle Exists): " + (sol.canFinish(2, prerequisites1) ? "FAIL" : "PASS"));

        // Test Case 2: Linear dependency chain (no cycle)
        // Prerequisites: [[1,0]] -> 0 before 1
        int[][] prerequisites2 = {{1, 0}};
        System.out.println("Test Case 2 (No Cycle): " + (sol.canFinish(2, prerequisites2) ? "PASS" : "FAIL"));

        // Test Case 3: Complex with no cycle
        // Prerequisites: [[1,0],[2,0],[3,1],[3,2]]
        int[][] prerequisites3 = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        System.out.println("Test Case 3 (Complex No Cycle): " + (sol.canFinish(4, prerequisites3) ? "PASS" : "FAIL"));

        // Test Case 4: Single course
        int[][] prerequisites4 = {};
        System.out.println("Test Case 4 (Single Course): " + (sol.canFinish(1, prerequisites4) ? "PASS" : "FAIL"));
        
        // Test Case 5: Multiple cycles
        int[][] prerequisites5 = {{1, 0}, {2, 1}, {0, 2}};
        System.out.println("Test Case 5 (Multiple Cycles): " + (sol.canFinish(3, prerequisites5) ? "FAIL" : "PASS"));
    }

    // =============================================================================
    // ALTERNATIVE IMPLEMENTATION: Kahn's Algorithm (BFS Topological Sort)
    // =============================================================================
    /**
     * Alternative implementation using Kahn's Algorithm (BFS-based Topological Sort).
     * This is more suitable for production systems due to no recursion stack issues.
     */
    public boolean canFinishKahns(int numCourses, int[][] prerequisites) {
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
    // FAANG Tip: Kahn's algorithm is preferred for production systems as it avoids recursion stack overflow. DFS is better for interviews to show algorithmic depth.
}
