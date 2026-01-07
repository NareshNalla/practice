package com.naresh.leetcode.old.javapractice.hash.ex.gfg;

import java.util.HashSet;

/*
Input: k = 3, arr[] = {1, 2, 3, 1, 4, 5}
Output: true
1 is repeated at distance 3.

Input: k = 3, arr[] = {1, 2, 3, 4, 5}
Output: false
*/

public class CheckDuplicatesWithinKImpl {
	
	static boolean checkDuplicatesWithinK(int arr[] , int k){
		//Creates an empty hashset
		HashSet<Integer> hs=new HashSet<>();
		//Traverse the input array
		for(int i=0; i<arr.length;i++){
			//if alredy present n hash, then we found a duplicate within k distance.
			if(hs.contains(arr[i]))
				return true;
			hs.add(arr[i]); 
			
			//remove k+1 distant item
			if( i >= k)
				hs.remove(arr[i-k]);
			
		}
		return false;
	}
	

	public static void main(String[] args) {
		
		int arr[] = {1,2,5,1,2,5};
		if(checkDuplicatesWithinK(arr, 3))
			System.out.println("Yes");
		else
			System.out.println("No");
	}
/*
 * only find after k=3. 
 * O(n) time using Hashing
 * 
1) Create an empty hashtable.
2) Traverse all elements from left from right. Let the current element be �arr[i]�
�.a) If current element �arr[i]� is present in hashtable, then return true.
�.b) Else add arr[i] to hash and remove arr[i-k] from hash if i is greater than or equal to k
 */
}
