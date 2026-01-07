package com.naresh.leetcode.old.javapractice.gfg.alg.sort.ex;

//time - bigO(n)
public class SortWaveForm1 {
	public static void main(String[] args) {
		int[] a={2, 4, 6, 8, 10, 20};
		waveFormSort(a);
		for (int i : a)
            System.out.print(i+" ");
		
	}
	private static void swap(int a[],int i,int j){
		int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
	}
	private static void waveFormSort(int[] arr) {
		int n=arr.length;
		// Traverse all even elements
		//a) If current element is smaller than previous odd element, swap previous and current.
		//b) If current element is smaller than next odd element, swap next and current.
        for (int i = 0; i < n; i+=2)
        {
            // If current even element is smaller
            // than previous
            if (i>0 && arr[i-1] > arr[i] )
                swap(arr, i-1, i);
 
            // If current even element is smaller
            // than next
            if (i<n-1 && arr[i] < arr[i+1] )
                swap(arr, i, i + 1);
        }
	}}
