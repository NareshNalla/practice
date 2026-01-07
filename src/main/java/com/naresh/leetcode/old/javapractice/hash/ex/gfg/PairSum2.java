package com.naresh.leetcode.old.javapractice.hash.ex.gfg;

import java.util.HashSet;
import java.util.Set;

public class PairSum2 {

	public static void main(String[] args) {
		
		int arr[] = { 1, 2, 4, 6, 10, 8};
		int sum=6;

		Set<Integer> visitedElements = new HashSet<Integer>();

		for (int i = 0; i < arr.length; i++) {
			int temp = sum - arr[i];

			if (temp >= 0 && visitedElements.contains(temp)) {
				System.out.println("Pair with given sum " + sum + " is (" + arr[i] + ", " + temp + ")");
			}

			visitedElements.add(arr[i]);
		}
	}
	/*Time complexity: O(n), space complexity O(n);*/
}