package com.naresh.a_dsalgo.ag_heap.problems;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Problem: K Closest Points to Origin (LeetCode 973)
 * Description: Given an array of points `points[i] = [xi, yi]` and an integer `k`,
 * return the `k` closest points to the origin `(0, 0)`. The Euclidean distance
 * is used. The answer can be returned in any order.
 */
public class KClosestPointsToOrigin {

    /**
     * Algorithm: Use a max-priority queue (max-heap) of size `k`. Iterate through all points,
     * calculate squared Euclidean distance. Add point to heap. If heap size exceeds `k`,
     * remove the point with the largest distance (heap's root). The heap will contain the `k` closest points.
     *
     * @param points An array of points, where each point is `[x, y]`.
     * @param k The number of closest points to find.
     * @return A 2D array containing the `k` closest points to the origin.
     */
    public int[][] kClosest(int[][] points, int k) {
        // Pattern: Max-Heap | Time: O(N log K), Space: O(K)
        // Max-heap stores points, ordered by distance (largest distance at top)
        var maxHeap = new PriorityQueue<int[]>(
            (p1, p2) -> (p2[0] * p2[0] + p2[1] * p2[1]) - (p1[0] * p1[0] + p1[1] * p1[1])
        ); // Compare by squared Euclidean distance

        for (var point : points) {
            maxHeap.offer(point); // Add current point to heap
            if (maxHeap.size() > k) maxHeap.poll(); // If heap size > k, remove the farthest point
        }

        var result = new int[k][2];
        for (var i = 0; i < k; i++) result[i] = maxHeap.poll(); // Extract k closest points
        return result;
    }
    // FAANG Tip: Using squared Euclidean distance (x^2 + y^2) avoids sqrt for comparison, improving performance. Max-heap of size K is efficient for "top K" problems.

    public static void main(String[] args) {
        var solution = new KClosestPointsToOrigin();

        // Test Case 1: Example from LeetCode
        var points1 = new int[][]{{1, 3}, {-2, 2}};
        var k1 = 1;
        // Expected: [[-2, 2]] (Distance of [1,3] is 10, [-2,2] is 8)
        System.out.println("Points: " + Arrays.deepToString(points1) + ", k: " + k1 +
                           " -> K Closest: " + Arrays.deepToString(solution.kClosest(points1, k1)));

        // Test Case 2: Example from LeetCode
        var points2 = new int[][]{{3, 3}, {5, -1}, {-2, 4}};
        var k2 = 2;
        // Expected: [[3, 3], [-2, 4]] (Distances: [3,3]=18, [5,-1]=26, [-2,4]=20)
        System.out.println("Points: " + Arrays.deepToString(points2) + ", k: " + k2 +
                           " -> K Closest: " + Arrays.deepToString(solution.kClosest(points2, k2)));

        // Test Case 3: All points are the same
        var points3 = new int[][]{{1, 1}, {1, 1}, {1, 1}};
        var k3 = 2;
        // Expected: [[1, 1], [1, 1]] (Order may vary)
        System.out.println("Points: " + Arrays.deepToString(points3) + ", k: " + k3 +
                           " -> K Closest: " + Arrays.deepToString(solution.kClosest(points3, k3)));

        // Test Case 4: k equals total number of points
        var points4 = new int[][]{{1, 0}, {0, 1}, {2, 0}};
        var k4 = 3;
        // Expected: [[1, 0], [0, 1], [2, 0]] (Order may vary)
        System.out.println("Points: " + Arrays.deepToString(points4) + ", k: " + k4 +
                           " -> K Closest: " + Arrays.deepToString(solution.kClosest(points4, k4)));
    }
}
