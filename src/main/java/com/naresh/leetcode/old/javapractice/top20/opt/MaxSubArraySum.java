package com.naresh.leetcode.old.javapractice.top20.opt;

public class MaxSubArraySum {


	
	//recursion
	public static int maxSubarraySum2(int[] in) {
		int max = 0;
		for(int i = 1; i <= in.length; ++i) 
			max = Math.max(max, auxSubarraySum2(i, in));
		return max;
	}
	private static int auxSubarraySum2(int i, int[] in) {
		if(i == 0) return 0;
		return Math.max(auxSubarraySum2(i-1, in), 0)  + in[i-1];
	}
		
	//dynamic programming
	public static int maxSubarraySum4(int[] in) {
		int max = 0;
		int[] mem = new int[in.length+1];
		mem[0] = 0;
		for(int i = 1; i <= in.length; ++i) {
			mem[i] = Math.max(0, mem[i-1]) + in[i-1];
			max = Math.max(max, mem[i]);
		}
		return max;
	}
	  static int maxSubArraySum(int a[])
	    {
	    int max_so_far = a[0];
	    int curr_max = a[0];
	 
	    for (int i = 1; i < a.length; i++)
	    {
	           curr_max = Math.max(a[i], curr_max+a[i]);
	        max_so_far = Math.max(max_so_far, curr_max);
	    }
	    return max_so_far;
	    }
	public static void main(String[] args) {
	    int a[] = {-2, -3, 4, -1, -2, 1, 5, -3};
	    int n = a.length;  
	    int max_sum = maxSubArraySum(a);
	    System.out.println("Maximum contiguous sum is "
	                       + max_sum);
	    }
	
}