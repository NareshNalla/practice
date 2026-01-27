package com.naresh.dsa.hash.ex.gfg;

import java.util.HashSet;
/*
1) Create a Hash Table for all the elements of arr1[].
2) Traverse arr2[] and search for each element of arr2[] in the Hash Table. If element is not found then return 0.
3) If all elements are found then return 1.*/

public class SubsetOfOtherArray {
	static boolean isSubset(int arr1[], int arr2[],int m, int n){
		HashSet<Integer> hash= new HashSet<>();
		for(int i=0;i<m; i++){
			if(!hash.contains(arr1[i]))
				hash.add(arr1[i]);
		}
		for(int j=0;j<n;j++){
			if(!hash.contains(arr2[j]))
				return false; 
		}
		return true;
	}
	public static void main(String[] args) {
	 int arr1[] = {1,2,3,4,58,34,75};
	 int arr2[] = {1,34,3,5};
	 int m=arr1.length;
	 int n=arr2.length;
	 
	 if(isSubset(arr1, arr2, m, n))
		 System.out.println("arr2 is a subset of arra1");
	 else
		 System.out.println("arr2 is not a subset of arra1 ");
		 
	}

}
