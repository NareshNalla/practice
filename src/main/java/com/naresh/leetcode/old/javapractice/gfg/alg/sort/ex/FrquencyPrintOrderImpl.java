package com.naresh.leetcode.old.javapractice.gfg.alg.sort.ex;

/*
 *Input:  arr[] = {2, 5, 2, 8, 5, 6, 8, 8}
Output: arr[] = {8, 8, 8, 2, 2, 5, 5, 6}

Input: arr[] = {2, 5, 2, 6, -1, 9999999, 5, 8, 8, 8}
Output: arr[] = {8, 8, 8, 2, 2, 5, 5, 6, -1, 9999999}
*/

import java.util.Arrays;
import java.util.Comparator;

 class Tuple {
	int val, count, index;
	public Tuple(int val, int count , int index){
		this.val = val;
		this.count = count;
		this.index =index;
	}
}

class MyComparator1 implements Comparator<Tuple>{
	public int compare(Tuple t1 , Tuple t2){
		return t1.val - t2.val;
	}
}
class MyComparator2 implements Comparator<Tuple>{
	public int compare(Tuple t1 , Tuple t2){
		if(t1.count != t2.count)
			return t2.count - t1.count;
		else
			return t1.index - t2.index;
	}
}

public class FrquencyPrintOrderImpl{
	static void sortElemntsByFrequency(int arr[]){
		int n = arr.length;
		Tuple[] tuples = new Tuple[n];
		for(int i=0;i<n;i++) {
			Tuple t = new Tuple(arr[i],0,i);
			tuples[i] = t;
		}
 
		Arrays.sort(tuples,new MyComparator1());
 
		tuples[0].count = 1;
		for(int i=1;i<n;i++) {
			if(tuples[i].val == tuples[i-1].val) {
				tuples[i].count += tuples[i-1].count + 1;
				tuples[i-1].count = -1;
				tuples[i].index = tuples[i-1].index;
			}
			else
				tuples[i].count = 1;
		}
 
		Arrays.sort(tuples,new MyComparator2());
 
		int index = 0;
		for(int i=0;i<n;i++) {
			if(tuples[i].count != -1) {
				for(int j=0;j<tuples[i].count;j++)
					arr[index++] = tuples[i].val;
			}
		}
	}
 
	static void printArray(int[] arr) {
		for(int i : arr)
			System.out.print(i + " ");
		System.out.println();
	}
 
	public static void main(String[] args) {
		int[] arr = {2, 5, 2, 6, -1, 9999999, 5, 8, 8, 8};
 
		printArray(arr);
 
		sortElemntsByFrequency(arr);
 
		printArray(arr);
	}
}
