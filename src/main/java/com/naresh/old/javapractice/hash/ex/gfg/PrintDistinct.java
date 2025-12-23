package com.naresh.old.javapractice.hash.ex.gfg;

import java.util.HashSet;

public class PrintDistinct {
	static void printDistinct(int arr[]){
		HashSet<Integer> set = new HashSet<>();
		for(int i=0;i<arr.length; i++){
			// If not present, then put it in hashtable and print it
			if(!set.contains(arr[i])){
				set.add(arr[i]);
				System.out.println(arr[i]+" ");
			}
		}
	}	
	public static void main(String[] args) {
		int arr[] = {10, 5, 3, 4, 3, 5,6};
		printDistinct(arr);
	}
	/*10 5 3 4 6 */
	 /*Use Hashing to solve this in O(n) time on average.*/
}
