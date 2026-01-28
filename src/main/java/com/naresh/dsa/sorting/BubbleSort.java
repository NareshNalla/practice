package com.naresh.dsa.sorting;

public class BubbleSort {
	public static void main(String[] args) {
		int[] a={3,2,5,4,1};
		int[] b= sort(a);
		for(int i:b){
			System.out.print(i+" ");
		}
	}

	private static int[] sort(int[] a) {
		
		for(int j=0;j<=a.length;j++){ //for(int j=a.length;j>=0;j--){ imprtent
		for(int i=0;i<=a.length-2;i++){ //i<a.length - arrayIndexOBE: 5  //i<=a.length-2 -works i<a.length-1 -works
			if(a[i] > a[i+1]){ 
				int temp = a[i+1];
				a[i+1] = a[i];
				a[i] = temp;
			}
		}}
		return a;
		
	}

}
