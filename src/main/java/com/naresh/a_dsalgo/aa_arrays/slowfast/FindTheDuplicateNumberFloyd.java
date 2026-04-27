package com.naresh.a_dsalgo.aa_arrays.slowfast;

import java.util.Arrays;

/**
 * Problem: Find the Duplicate Number
 * Description: Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive),
 * prove that at least one duplicate number must exist. Assume that there is only one duplicate number,
 * find the duplicate one.
 * Constraints: Do not modify the array, use O(1) extra space, runtime < O(n^2).
 */
public class FindTheDuplicateNumberFloyd {
    /**
     * Algorithm: Uses Floyd's Cycle-Finding Algorithm (Tortoise and Hare).
     * Treat the array as a linked list where `nums[i]` points to the next element.
     * Since there's a duplicate, there must be a cycle.
     * Phase 1: Find intersection point. Move slow by 1 step, fast by 2 steps.
     * Phase 2: Find cycle entrance. Reset slow to start, move both slow and fast by 1 step.
     * The meeting point is the duplicate number.
     */
    public int findDuplicate(int[] nums) {
        // Pattern: Slow & Fast Pointers | Time: O(n), Space: O(1)
        if (nums == null || nums.length <= 1) {
            throw new IllegalArgumentException("Invalid input array.");
        }

        // Phase 1: Find the intersection point of the two pointers
        var slow = nums[0]; // Start at the first element
        var fast = nums[nums[0]]; // Start at the element pointed to by the first element

        while (slow != fast) {
            slow = nums[slow]; // Move slow by one step
            fast = nums[nums[fast]]; // Move fast by two steps
        }

        // Phase 2: Find the entrance to the cycle (the duplicate number)
        slow = 0; // Reset slow pointer to the beginning of the array (index 0)
        while (slow != fast) {
            slow = nums[slow]; // Move slow by one step
            fast = nums[fast]; // Move fast by one step
        }

        return slow; // Both pointers meet at the duplicate number
    }
    // FAANG Tip: This problem is a classic application of Floyd's Cycle-Finding Algorithm.
    // Emphasize how the array can be modeled as a linked list and why a cycle must exist due to the duplicate. Highlight the O(1) space complexity.

    public static void main(String[] args) {
        var sol = new FindTheDuplicateNumberFloyd();

        // Test Case 1
        var nums1 = new int[]{1, 3, 4, 2, 2};
        System.out.println("Array: " + Arrays.toString(nums1) + " -> Duplicate: " + sol.findDuplicate(nums1)); // Expected: 2

        // Test Case 2
        var nums2 = new int[]{3, 1, 3, 4, 2};
        System.out.println("Array: " + Arrays.toString(nums2) + " -> Duplicate: " + sol.findDuplicate(nums2)); // Expected: 3

        // Test Case 3
        var nums3 = new int[]{1, 1};
        System.out.println("Array: " + Arrays.toString(nums3) + " -> Duplicate: " + sol.findDuplicate(nums3)); // Expected: 1

        // Test Case 4
        var nums4 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 9};
        System.out.println("Array: " + Arrays.toString(nums4) + " -> Duplicate: " + sol.findDuplicate(nums4)); // Expected: 9
    }
}
