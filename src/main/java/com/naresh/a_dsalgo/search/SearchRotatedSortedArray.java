package com.naresh.a_dsalgo.search;

/**
 * Problem: Search in Rotated Sorted Array
 * Description: Given a sorted integer array that has been rotated at some pivot, 
 * search for a target value. If found, return its index; otherwise, return -1.
 */
public class SearchRotatedSortedArray {

    /**
     * Primary solution using Binary Search on a Rotated Array.
     * <p>
     * FAANG Pattern: "Binary Search on Rotated Data"
     * Strategy:
     * 1. Even if rotated, one half of the array (left to mid or mid to right) will always be sorted.
     * 2. Identify which half is sorted (nums[left] <= nums[mid] means left half is sorted).
     * 3. Check if the target is within the sorted half's range.
     * 4. Update left/right pointers to narrow down the search.
     * <p>
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     */
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int left = 0,  right = nums.length - 1;
        while (left <= right) {
            // Fix: Standard overflow-safe mid calculation
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            // Check if the left half [left...mid] is sorted
            if (nums[left] <= nums[mid]) { // Target lies within the sorted left half
                if (nums[left]  <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else { // Otherwise, the right half [mid...right] must be sorted // Target lies within the sorted right half
                if (nums[mid] < target  && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        SearchRotatedSortedArray sol = new SearchRotatedSortedArray();

        System.out.println("--- Search in Rotated Sorted Array Validation ---");

        int[] nums1 = {4, 5, 6, 7, 0, 1, 2};
        int target1 = 0;
        System.out.println("Test Case 1 (Target 0): Expected 4, Got " + sol.search(nums1, target1));

        int[] nums2 = {4, 5, 6, 7, 0, 1, 2};
        int target2 = 3;
        System.out.println("Test Case 2 (Target 3): Expected -1, Got " + sol.search(nums2, target2));

        int[] nums3 = {1};
        int target3 = 0;
        System.out.println("Test Case 3 (Target 0): Expected -1, Got " + sol.search(nums3, target3));

        int[] nums4 = {3, 1};
        int target4 = 1;
        System.out.println("Test Case 4 (Target 1): Expected 1, Got " + sol.search(nums4, target4));
    }
}
