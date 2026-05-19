package com.naresh.a_dsalgo.ak_matrix_geometry;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects; // For Objects.requireNonNull

/**
 * Problem: Detect Squares (LeetCode 2013)
 * Description: Design a data structure that supports adding points and counting axis-aligned squares.
 * An axis-aligned square has all four sides parallel or perpendicular to the x-axis and y-axis.
 */
public class DetectSquares {

    // Stores the frequency of each point (x, y)
    // Map<x_coord, Map<y_coord, count>>
    private final Map<Integer, Map<Integer, Integer>> pointsMap;

    /**
     * Constructor for DetectSquares.
     */
    public DetectSquares() {
        // Pattern: Initialization | Time: O(1), Space: O(1)
        pointsMap = new HashMap<>();
    }
    // FAANG Tip: Using nested HashMaps allows efficient storage and lookup for 2D points.

    /**
     * Algorithm: Add a point `[x, y]` to the data structure by incrementing its count.
     *
     * @param point An array `[x, y]` representing the coordinates of the point.
     */
    public void add(int[] point) {
        // Pattern: HashMap Update | Time: O(1) average, Space: O(1) amortized
        Objects.requireNonNull(point, "Point cannot be null.");
        if (point.length != 2) throw new IllegalArgumentException("Point must have exactly two coordinates.");

        var x = point[0];
        var y = point[1];

        pointsMap.computeIfAbsent(x, k -> new HashMap<>()) // Get or create inner map for x
                 .merge(y, 1, Integer::sum); // Increment count for y
    }
    // FAANG Tip: `computeIfAbsent` and `merge` are modern Java ways to handle map updates concisely.

    /**
     * Algorithm: Given a query point `P1 = (x1, y1)`, iterate through all other points `P2 = (x1, y_other)`
     * that share the same x-coordinate as `P1`. For each such `P2`, calculate the side length `s = |y1 - y_other|`.
     * If `s > 0`, then check for the existence of `P3 = (x1 + s, y1)` and `P4 = (x1 + s, y_other)`,
     * and `P3' = (x1 - s, y1)` and `P4' = (x1 - s, y_other)`.
     * The number of squares formed is the product of the counts of `P2`, `P3`, and `P4`.
     *
     * @param point An array `[x, y]` representing the coordinates of the query point.
     * @return The number of ways to form an axis-aligned square with this query point as one corner.
     */
    public int count(int[] point) {
        // Pattern: Geometry (HashMap Lookup) | Time: O(N_x), Space: O(1)
        // N_x is the number of distinct y-coordinates for the query point's x-coordinate.
        Objects.requireNonNull(point, "Point cannot be null.");
        if (point.length != 2) throw new IllegalArgumentException("Point must have exactly two coordinates.");

        var x1 = point[0];
        var y1 = point[1];
        var totalSquares = 0;

        // If x1 doesn't exist in our map, no squares can be formed with it as a corner
        if (!pointsMap.containsKey(x1)) return 0;

        // Get all points (x1, y_other) that share the same x-coordinate as P1
        // We iterate through the y-coordinates present for x1
        for (Map.Entry<Integer, Integer> entryP2 : pointsMap.get(x1).entrySet()) {
            var y_other = entryP2.getKey();
            var countP2 = entryP2.getValue();

            // P1 and P2 must be distinct points, so y1 != y_other
            // Also, side length 's' must be positive
            var s = Math.abs(y1 - y_other);
            if (s == 0) continue; // P1 and P2 are the same point

            // Now check for the other two corners:
            // Case 1: P3 = (x1 + s, y1) and P4 = (x1 + s, y_other)
            var x_candidate_1 = x1 + s;
            if (pointsMap.containsKey(x_candidate_1)) {
                var mapForXCandidate1 = pointsMap.get(x_candidate_1);
                if (mapForXCandidate1.containsKey(y1) && mapForXCandidate1.containsKey(y_other)) {
                    var countP3 = mapForXCandidate1.get(y1);
                    var countP4 = mapForXCandidate1.get(y_other);
                    totalSquares += countP2 * countP3 * countP4;
                }
            }

            // Case 2: P3 = (x1 - s, y1) and P4 = (x1 - s, y_other)
            var x_candidate_2 = x1 - s;
            if (pointsMap.containsKey(x_candidate_2)) {
                var mapForXCandidate2 = pointsMap.get(x_candidate_2);
                if (mapForXCandidate2.containsKey(y1) && mapForXCandidate2.containsKey(y_other)) {
                    var countP3 = mapForXCandidate2.get(y1);
                    var countP4 = mapForXCandidate2.get(y_other);
                    totalSquares += countP2 * countP3 * countP4;
                }
            }
        }
        return totalSquares;
    }
    // FAANG Tip: The key is to fix two points (P1 and P2) that share an x-coordinate, determine the side length, and then check for the other two possible corners.

    public static void main(String[] args) {
        var ds = new DetectSquares();

        // Example 1 from LeetCode
        System.out.println("--- Test Case 1 ---");
        ds.add(new int[]{3, 10});
        ds.add(new int[]{11, 2});
        ds.add(new int[]{3, 2});
        System.out.println("Added: (3,10), (11,2), (3,2)");
        System.out.println("Count (11,10): " + ds.count(new int[]{11, 10})); // Expected: 1 (Square: (3,10), (11,10), (3,2), (11,2))
        System.out.println("Count (14,8): " + ds.count(new int[]{14, 8}));   // Expected: 0
        ds.add(new int[]{11, 10});
        System.out.println("Added: (11,10)");
        System.out.println("Count (11,10): " + ds.count(new int[]{11, 10})); // Expected: 2 (Two squares: one with (3,2) and one with (3,10) as opposite corners)

        // Custom Test Case 2: Multiple points forming squares
        System.out.println("\n--- Test Case 2 ---");
        var ds2 = new DetectSquares();
        ds2.add(new int[]{0, 0});
        ds2.add(new int[]{0, 1});
        ds2.add(new int[]{1, 0});
        ds2.add(new int[]{1, 1});
        System.out.println("Added: (0,0), (0,1), (1,0), (1,1)");
        System.out.println("Count (0,0): " + ds2.count(new int[]{0, 0})); // Expected: 1 (Square: (0,0), (0,1), (1,0), (1,1))
        System.out.println("Count (0,1): " + ds2.count(new int[]{0, 1})); // Expected: 1
        System.out.println("Count (1,0): " + ds2.count(new int[]{1, 0})); // Expected: 1

        System.out.println("Count (1,1): " + ds2.count(new int[]{1, 1})); // Expected: 1

        ds2.add(new int[]{0, 0}); // Add (0,0) again
        System.out.println("Added: (0,0) again");
        System.out.println("Count (0,0): " + ds2.count(new int[]{0, 0})); // Expected: 1 (Still one square, but (0,0) has count 2)
        System.out.println("Count (1,1): " + ds2.count(new int[]{1, 1})); // Expected: 2 (Square (0,0) (count 2), (0,1) (count 1), (1,0) (count 1), (1,1) (count 1))
                                                                          // (0,0) (0,1) (1,0) (1,1)
                                                                          // (0,0) (0,1) (1,0) (1,1)
                                                                          // If query is (1,1), P2=(1,0), s=1.
                                                                          // Check (1-1, 1) = (0,1) and (1-1, 0) = (0,0)
                                                                          // count(1,0) * count(0,1) * count(0,0) = 1 * 1 * 2 = 2

        // Custom Test Case 3: No squares
        System.out.println("\n--- Test Case 3 ---");
        var ds3 = new DetectSquares();
        ds3.add(new int[]{0, 0});
        ds3.add(new int[]{0, 2});
        ds3.add(new int[]{1, 0});
        System.out.println("Added: (0,0), (0,2), (1,0)");
        System.out.println("Count (1,2): " + ds3.count(new int[]{1, 2})); // Expected: 1 (Square: (0,0), (0,2), (1,0), (1,2))
        System.out.println("Count (0,0): " + ds3.count(new int[]{0, 0})); // Expected: 0
    }
}
