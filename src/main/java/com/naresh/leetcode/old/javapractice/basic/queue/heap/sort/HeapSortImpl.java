package com.naresh.leetcode.old.javapractice.basic.queue.heap.sort;

public class HeapSortImpl {
	static int total;
	static void swap(Comparable[] arr, int a , int b){
		Comparable temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	static void heapify(Comparable[] arr , int i){
		int left = i * 2; //2k
		int right = i * 2 + 1; // 2k+1
		int grt = i;
		if(left <= total && arr[left].compareTo(arr[grt]) >= 0)
			grt = left;
		if(right <= total && arr[right].compareTo(arr[grt]) >= 0)
			grt = right;
		if(grt != i){
			swap(arr, i , grt);
			heapify(arr, grt);
		}
	}
	static void sort(Comparable[] arr){
		total = arr.length -1;
		for(int i=total/2; i >=0; i--){
			heapify(arr, i);
		}
		for(int i=total; i > 0; i--){
			swap(arr, 0,i);
			total--;
			heapify(arr, 0);
		}
	}
	public static void main(String[] args) {
		Integer[] arr= {10, 1, 15, 13, 50, 30, 90};
		System.out.println("Heap before sort:");
		for(int i=0;i<arr.length;i++)
			System.out.println(arr[i]);
		sort(arr);
		System.out.println("Heap After sort:");
		for(int i=0;i<arr.length;i++)
			System.out.println(arr[i]);
		
	}

	/*O(logn) time hippify.. O9nlogn) - n elements
	 * best for sort-time nlogn , space O(1)
	 * 
	 * */
	
}
