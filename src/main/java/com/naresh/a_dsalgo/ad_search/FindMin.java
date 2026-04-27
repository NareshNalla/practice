package com.naresh.a_dsalgo.ad_search;

/**
 * Problem: Find Minimum in Rotated Sorted Array
 * Description: Find the minimum element in an array that has been rotated.
 */
public class FindMin {
    /**
     * Algorithm: Perform binary search to find the inflection point where the rotation occurs. 
     * If nums[mid] > nums[right], the minimum must be in the right half. Otherwise, it's 
     * in the left half (including mid).
     */
    public int findMinOptimized(int[] nums) {
        // Pattern: Binary Search | Time: O(log n), Space: O(1)
        if (nums == null || nums.length == 0) return -1;
        var l = 0; var r = nums.length - 1;
        while (l < r) {
            var mid = l + (r - l) / 2;
            if (nums[mid] > nums[r]){
                l = mid + 1; // Min is in right half
            } else{
                r = mid; // Min is in left half (mid could be min)
            }
        }
        return nums[l];
    }
    // FAANG Tip: Emphasize the comparison with the 'right' element to decide which half to discard. Mention that this $O(\log N)$ approach is much faster than $O(N)$ linear search for large datasets.

    public static void main(String[] args) {
        var sol = new FindMin();
        var nums = new int[]{3, 4, 5, 1, 2};
        System.out.println("Optimized Logic Result: " + sol.findMinOptimized(nums));
    }
}
