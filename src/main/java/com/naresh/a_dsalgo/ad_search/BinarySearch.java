package com.naresh.a_dsalgo.ad_search;

import java.util.Arrays;

/**
 * Problem: Classic Binary Search
 * Description: Given a sorted array of integers and a target value, find if the target exists.
 * 
 * Strategy: Repeatedly divide the search interval in half. If the target is less than the middle,
 * narrow the interval to the lower half. Otherwise, narrow it to the upper half.
 * 
 * FAANG Pattern: "Divide and Conquer (Logarithmic Search)"
 */
public class BinarySearch {

    /**
     * Standard Iterative Binary Search implementation.
     * <p>
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     */
    public static int binarySearch(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            // Optimization to prevent (left + right) overflow
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid; // Found the target
            } else if (nums[mid] < target) {
                left = mid + 1; // Target is in the right half
            } else {
                right = mid - 1; // Target is in the left half
            }
        }
        return -1; // Target not found
    }

    /**
     * Recursive Binary Search implementation.
     * <p>
     * Time Complexity: O(log n)
     * Space Complexity: O(log n) due to recursion stack.
     */
    public static int binarySearchRecursive(int[] nums, int target, int left, int right) {
        if (left > right) return -1;

        int mid = left + (right - left) / 2;

        if (nums[mid] == target) return mid;

        if (nums[mid] < target) {
            return binarySearchRecursive(nums, target, mid + 1, right);
        } else {
            return binarySearchRecursive(nums, target, left, mid - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int target = 6;

        System.out.println("--- Binary Search Validation ---");
        System.out.println("Input Array: " + Arrays.toString(nums));
        System.out.println("Target: " + target);

        // Test Iterative
        int resultIterative = binarySearch(nums, target);
        System.out.println("Result (Iterative) - Index: " + resultIterative);

        // Test Recursive
        int resultRecursive = binarySearchRecursive(nums, target, 0, nums.length - 1);
        System.out.println("Result (Recursive) - Index: " + resultRecursive);

        // Test missing element
        System.out.println("Searching for 12: " + binarySearch(nums, 12));
    }
}
/*
Always use left + (right-left)//2 to avoid integer overflow in Java.
Foundation for every other pattern. Nail the <= vs < distinction.
 */
