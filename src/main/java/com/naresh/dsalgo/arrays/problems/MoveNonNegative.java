package com.naresh.dsalgo.arrays.problems;

import java.util.Arrays;

/**
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class MoveNonNegative {
    public static void main(String[] args) {
        int[] nums = {-1, -20, 30, 40, 50, -8};
        moveAllNegativeToStart(nums);
        System.out.println("Modified array: " + Arrays.toString(nums));
    }

    private static void moveAllNegativeToStart(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }
        }
    }
}
