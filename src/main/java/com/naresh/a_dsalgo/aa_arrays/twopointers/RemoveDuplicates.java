package com.naresh.a_dsalgo.aa_arrays.twopointers;

import java.util.Arrays;

/**
 * Problem: Remove Duplicates from Sorted Array
 * Description: Given a sorted array nums, remove the duplicates in-place such that each unique element appears only once.
 */
public class RemoveDuplicates {
    /**
     * Algorithm: Two pointers - 'i' tracks the next unique position, 'j' iterates through the array.
     */
    public int removeDuplicates(int[] nums) {
        // Pattern: Two Pointers (In-place) | Time: O(n), Space: O(1)
        if (nums == null || nums.length == 0) return 0;
        var i = 1; // Position of the next unique element
        for (var j = 1; j < nums.length; j++) {
            if (nums[j] != nums[j - 1]) {
                nums[i++] = nums[j]; // Shift unique element to the front
            }
        }
        return i; // Length of the unique prefix
    }
    // FAANG Tip: In-place modification is a common requirement to test your pointer manipulation skills.

    /**
     * Algorithm: Use Java Streams to filter unique elements and return a new array.
     */
    public int[] removeDuplicatesStream(int[] nums) {
        // Pattern: Streams (Functional) | Time: O(n), Space: O(n)
        return Arrays.stream(nums).distinct().toArray();
    }
    // FAANG Tip: Streams are concise and readable, but incur O(n) space and object overhead compared to in-place logic.

    public static void main(String[] args) {
        var solution = new RemoveDuplicates();
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        
        System.out.println("--- In-place Pointer Solution ---");
        var nums1 = nums.clone();
        var len = solution.removeDuplicates(nums1);
        System.out.println("Unique length: " + len);
        
        System.out.println("--- Stream Solution ---");
        var uniqueArr = solution.removeDuplicatesStream(nums);
        System.out.println("Unique Array: " + Arrays.toString(uniqueArr));
    }
}
