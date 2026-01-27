package com.naresh.dsa.hash.ex.gfg;

import java.util.HashSet;
/*
Input: arr[] = {12, 10, 9, 45, 2, 10, 10, 45}
Output: 12, 10, 9, 45, 2

Input: arr[] = {1, 2, 3, 4, 5}
Output: 1, 2, 3, 4, 5

Input: arr[] = {1, 1, 1, 1, 1}
Output: 1
*/

public class PrintFirstRepeating {
	static void printFirstRepeating(int arr[]){
		int min = -1;
		
		HashSet<Integer> set = new HashSet<>();
		//from right to left
		for(int i=arr.length-1; i >=0; i--){
			//if element is alredy in hashset
			if(set.contains(arr[i])){
				min =i;
			}else{
				set.add(arr[i]);
			}
		}
		
		//Print the result
		if(min != -1){
			System.out.println("The first repeating element is "+ arr[min]);
		}else{
				System.out.println("There are no repeating elements");
		}
	}
	public static void main(String[] args) throws Exception{
		int arr[] = {10,5,3,43,5,6};
		printFirstRepeating(arr);
	}

	
}
