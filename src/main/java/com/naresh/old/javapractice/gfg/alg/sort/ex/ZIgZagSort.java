package com.naresh.old.javapractice.gfg.alg.sort.ex;
/*
 * Time complexity: O(n)
    Auxiliary Space: O(1)
    Convert array into Zig-Zag fashion
 */
public class ZIgZagSort {
	public static void main(String[] args) {
		int[] a={4, 3, 7, 8, 6, 2, 1};
		zigzagformSort(a);
		for (int i : a)
            System.out.print(i+" ");
		
	}
	private static void zigzagformSort(int[] a) {
		boolean flag = true;
		int temp = 0;
		for(int i=0;i<a.length - 2;i++){
			if(flag){
				//if we have a situation like a>b>c we get a>B<c bye swapping b and
				if(a[i]>a[i+1]){
					swap(a,i,i+1);
				}
			}else {
////if we have a situation like a<b<c we get a<c>b bye swapping b and				
				if(a[i] < a[i+1]){
					swap(a,i,i+1);
				}
			}
			flag = !flag;
		}
	}
	private static void swap(int a[],int i,int j){
		int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
	}
}
