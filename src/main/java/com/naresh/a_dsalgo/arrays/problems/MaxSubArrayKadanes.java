package com.naresh.a_dsalgo.arrays.problems;

public class MaxSubArrayKadanes {
    public static void main(String[] args) {
        int[] nums = {1,2,3,-3};
        System.out.println("Maximum Subarray Sum: " + maxSubArray(nums));
    }

    /**
     * Kadane's Algorithm to find the maximum sum of a contiguous subarray.
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     *
     * @param nums The input array of integers.
     * @return The maximum subarray sum.
     */
    public static int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0){
            return -1;
        }
       int maxSum = nums[0], currentSum = nums[0];
        for(int i =1; i<nums.length ; i++){
             currentSum = Math.max(nums[i], currentSum + nums[i]);
             maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

}
