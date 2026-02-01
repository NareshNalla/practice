package com.naresh.dsalgo.gfg.dp;

/*Time Complexity: O(n^2)
Auxiliary Space: O(n)
*/
public class LongestBitonicSubsequence {
	public static void main (String[] args)
    {
        //int arr[] = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
		int arr[] = {1, 11, 2, 10, 4, 5, 2, 1};
        int n = arr.length;
        System.out.println("\n Length of LBS is "+ lbs( arr, n ));
    }

	private static int lbs(int[] arr, int n) {
		int i , j ;
		/* lis initiaization */
		int[] lis = new int[n];
		for(i = 0; i< n; i++){
			lis[i] = 1;
		}
		/*
		 * lis left to right
		 */
		for(i=1; i<n;i++)
			for(j=0; j<i; j++){
				if(arr[i] > arr[j] && lis[i]< lis[j] +1)
					lis[i] = lis[j] + 1;
			}
		
		
		/* 
		 * initialize lds values for all indexes
		 */
		int[] lds= new int[n];
		for(i = 0; i <n; i++)
			lds[i] = 1;
		
		/* right to left */
		for(i = n-2; i>= 0; i--) //TODO remeber i--
			for(j = n-1; j>i;j--){
				if(arr[i] > arr[j] && lds[i] < lds[j]+1)
					lds[i] = lds[j]+1;
			}
		
		/* return max */
		int max = lis[0] + lds[0] -1;
		for(i =1; i<n; i++)
			if(lis[i] +lds[i] - 1 >max)
				max= lis[i] + lds[i] -1;
		
		//added for print bellow upt return max;
		int incresingUpto = 0;
		int decreasingUpt0 = 0;
		// separate the increasing and decreasing part from the array based on
		// maximum length
		for ( i = 0; i < arr.length; i++) {

		if (lis[i] + lds[i] - 1 == max) {
		incresingUpto = i + 1;
		decreasingUpt0 = max - incresingUpto;
		break;
		}
		}

		// print the increasing sequence
		 j = 1;
		for ( i = 0; i < arr.length && i < incresingUpto; i++) {
		if (lis[i] == j) {
		j++;
		System.out.print(arr[i] + ",");
		}
		}

		// print the decreasing sequence
		int k = decreasingUpt0;
		for ( i = incresingUpto; i < arr.length; i++) {
		if (lds[i] == k) {
		k--;
		System.out.print(arr[i] + ",");
		}
		}
		
			return max;
	}
	

}
