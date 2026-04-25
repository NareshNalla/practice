package com.naresh.a_dsalgo.search;

/**
 * Problem: Koko Eating Bananas
 * Description: Koko loves to eat bananas. There are n piles of bananas, the i-th pile has piles[i] bananas.
 * Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile and eats k bananas.
 * Find the minimum integer k such that she can eat all the bananas within h hours.
 * 
 * FAANG Pattern: "Binary Search on Answer Range"
 * Strategy:
 * 1. The possible speed k ranges from 1 to max(piles).
 * 2. Perform binary search on this range [1, max_pile].
 * 3. For each mid value, calculate total hours needed.
 * 4. If total hours <= h, we might have found a valid speed, but we try smaller ones (right = mid).
 * 5. Otherwise, we need a higher speed (left = mid + 1).
 * 
 * Time Complexity: O(n * log(max(piles))) where n is the number of piles.
 * Space Complexity: O(1)
 */
public class KokoEatingSpeed {

    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 0;
        for (int pile : piles) {
            right = Math.max(right, pile);
        }

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canFinish(piles, mid, h)) {
                right = mid; // Try smaller speed
            } else {
                left = mid + 1; // Need more speed
            }
        }
        return left;
    }

    private boolean canFinish(int[] piles, int speed, int h) {
        long totalHours = 0; // Use long to prevent potential overflow
        for (int pile : piles) {
            // Equivalent to Math.ceil((double) pile / speed) without floating point issues
            totalHours += (pile + speed - 1) / speed;
        }
        return totalHours <= h;
    }

    public static void main(String[] args) {
        KokoEatingSpeed sol = new KokoEatingSpeed();
        
        System.out.println("--- Koko Eating Speed Validation ---");
        
        int[] piles1 = {3, 6, 7, 11};
        int h1 = 8;
        System.out.println("Test Case 1 (Expected 4): " + sol.minEatingSpeed(piles1, h1));

        int[] piles2 = {30, 11, 23, 4, 20};
        int h2 = 5;
        System.out.println("Test Case 2 (Expected 30): " + sol.minEatingSpeed(piles2, h2));

        int[] piles3 = {30, 11, 23, 4, 20};
        int h3 = 6;
        System.out.println("Test Case 3 (Expected 23): " + sol.minEatingSpeed(piles3, h3));
    }
}
