package com.naresh.dsalgo.arrays.problems;

import java.util.Arrays;

public class MoveAllZeroRight {
    public static void main(String[] args) {
        int[] nums = {1, 0, 30, 40, 0, 25, 0};
        System.out.println(Arrays.toString(moveZerosRight(nums)));
    }

    private static int[] moveZerosRight(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }

        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != 0){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }
        }
        return nums;
    }
}
