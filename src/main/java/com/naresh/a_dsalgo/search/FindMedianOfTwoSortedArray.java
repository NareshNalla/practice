package com.naresh.a_dsalgo.search;

/**
 * Problem: Median of Two Sorted Arrays
 * Description: Find the median of two sorted arrays nums1 and nums2 of size m and n.
 */
public class FindMedianOfTwoSortedArray {

    /**
     * Algorithm: Use binary search to find a partition point in the smaller array such that
     * elements on the left side are less than or equal to elements on the right side.
     * The partition ensures balanced halves across both arrays.
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Pattern: Binary Search on Partitions | Time: O(log(min(m, n))), Space: O(1)
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int x = nums1.length, y = nums2.length;
        int left = 0, right = x;

        while (left <= right) {
            int partX = left + (right - left) / 2; //Partition nums1
            int partY = (x + y + 1) / 2 - partX; //Partition nums2

            int xMaxLeft = (partX == 0) ? Integer.MIN_VALUE : nums1[partX - 1];
            int xMinRight = (partX == x) ? Integer.MAX_VALUE : nums1[partX];
            int yMaxLeft = (partY == 0) ? Integer.MIN_VALUE : nums2[partY - 1];
            int yMinRight = (partY == y) ? Integer.MAX_VALUE : nums2[partY];

            if (xMaxLeft <= yMinRight && yMaxLeft <= xMinRight) {
                /*
                 if ((x + y) % 2 == 0)
                    return (Math.max(xMaxLeft, yMaxLeft) + Math.min(xMinRight, yMinRight)) / 2.0;
                return Math.max(xMaxLeft, yMaxLeft);
                 */
                if ((x + y) % 2 == 1)
                    return Math.max(xMaxLeft, yMaxLeft);
                return (Math.max(xMaxLeft, yMaxLeft) + Math.min(xMinRight, yMinRight)) / 2.0;
            } else if (xMaxLeft > yMinRight) {
                right = partX - 1;
            } else {
                left = partX + 1;
            }
        }
        return 0.0;
    }

    public static void main(String[] args) {
        var sol = new FindMedianOfTwoSortedArray();
        System.out.println("Test 1 (2.0): " + sol.findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
        System.out.println("Test 2 (2.5): " + sol.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
    }
}
/*
Approach
Binary search on a partition of the smaller array. For each partition i of A, compute partition j of B such that left halves balance right halves. Invariant: maxLeftA <= minRightB AND maxLeftB <= minRightA. When invariant holds, compute median from the 4 boundary values.
💡
Tip
Always binary search on the shorter array — swap if needed. Use Integer.MIN_VALUE/MAX_VALUE as sentinels for empty partition edges. j = (m + n + 1) / 2 - i ensures left halves always total (m+n+1)/2 elements.
⚡
FAANG Tip
Top FAANG hard — Google, FB, Amazon flagship. Practice explaining the partition invariant verbally
— that's what separates candidates. Know: O(log(min(m,n))) is the target, naive merge is O(m+n).
Draw the partition on paper. Edge cases: empty array, one element in each, all of A < all of B.
 */