package com.naresh.old.javapractice.gfg.array.ex;


public class MaxSubArraySumDevide {
	//find the maximum possible sum in arr[]
 static int maxCrossingSum(int arr[] , int l, int m, int h){
	 //include elements on left of mid
	 int sum =0;
	 int left_sum = Integer.MIN_VALUE;
	 for(int i = m; i >= l;i--){
		 sum = sum +arr[i];
		 if(sum > left_sum)
			 left_sum = sum;
	 }
	 
	 //include elements on right of mid
	 sum =0;
	 int right_sum = Integer.MIN_VALUE;
	 for( int i=m+1; i<= h; i++){
		 sum = sum + arr[i];
		 if(sum >right_sum)
			 right_sum = sum;
	 }
	 
	 //return sum of left and right of mid
	 return left_sum + right_sum;
 }
 static int maxSubArraySum(int arr[], int l, int h){
	 //Base case: only one element
	 if( l == h){
		 return arr[l];
	 }
	 //Find middle point
	 int m = (l + h) / 2;
	 /*return maximum of following 3 possible cases
	  * 1. maximum subarray sum in left half, 2. right half , 3. sum such that
	  * the subarray crosses the midpoint
	  * */
	return Math.max(Math.max(maxSubArraySum(arr, l, m),
			maxSubArraySum(arr, m+1, h)),
			maxCrossingSum(arr, l, m, h));
	
 }
 //test
 public static void main(String[] args) {
	int arr[] = {2, 3, 4, 5,7};
	int n = arr.length;
	int max_sum = maxSubArraySum(arr, 0, n-1);
	System.out.println("Maximum contiguous sum is :"+max_sum);
}
 
 
}
/*Time Complexity: maxSubArraySum() is a recursive method and time complexity can be expressed as following recurrence relation.
T(n) = 2T(n/2) + O(n)
The above recurrence is similar to Merge Sort and can be solved either using Recurrence 
Tree method or Master method. It falls in case II of Master Method
 and solution of the recurrence is O(nLogn).

The Kadane�s Algorithm for this problem takes O(n) time. Therefore the Kadane�s algorithm is better than the Divide and Conquer approach, but this problem can be considered as a good example to show power of Divide and Conquer. The above simple approach where we divide the array in two halves, 
reduces the time complexity from O(n^2) to O(nLogn).*/