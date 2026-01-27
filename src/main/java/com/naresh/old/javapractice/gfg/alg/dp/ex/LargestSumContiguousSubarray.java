package com.naresh.old.javapractice.gfg.alg.dp.ex;

/*Kadane's algorithm*/
/*Time Complexity: O(n)*/

public class LargestSumContiguousSubarray {
	public static void main (String[] args)
    {
        int [] a = {-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println("Result:" +maxSubArraySum(a));
        
    }

	private static int maxSubArraySum(int[] a) {
		int size = a.length;
		int max_so_far = Integer.MIN_VALUE;
		int max_ending_here = 0;
		for(int i =0; i< size; i++){
			max_ending_here = max_ending_here + a[i];
			
			 /* Do not compare for all elements. Compare only   
	          when  max_ending_here > 0 for all values */
			if(max_so_far < max_ending_here)
				max_so_far = max_ending_here;
			
	          
			if(max_ending_here < 0){
				max_ending_here = 0;
			}
		}
		return max_so_far;
	}
}
/*
Kadane's algorithm is to look for all positive contiguous segments of the array

*/