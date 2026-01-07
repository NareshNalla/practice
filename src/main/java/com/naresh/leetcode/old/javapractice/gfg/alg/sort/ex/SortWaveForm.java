package com.naresh.leetcode.old.javapractice.gfg.alg.sort.ex;

public class SortWaveForm {
	public static void main(String[] args) {
		int[] a={10, 5, 6, 3, 2, 20, 100, 80};
		for(int i=0;i<a.length;i++)
			System.out.print(a[i]+" ");
		sortLikeWave(a);
		System.out.println("After sorting");
		for(int i=0;i<a.length;i++)
		System.out.print(a[i]+" ");
		
		
	}

	private static void sortLikeWave(int[] a) {
	int n=a.length;
	for(int i=0;i<n;i++){
		if(i%2==0){
			if(i+1<n && a[i]<a[i+1]){
				swap(a,i,i+1);
			}
			else if(i+1 < n-1 && i+2<n && a[i]>a[i+1] &&a[i+1]>a[i+2]){
				swap(a,i+1,i+2);
				i--;
				}else if(i+1<n && i+2 ==n && a[i]<a[i+1])
					break;
			}
			else{
				if(i+1 <n-1 && i+2<n && a[i]<a[i+1] && a[i+1] < a[i+2]){
					swap(a,i+1,i+2);
					i--;
				}else if(i+1<n && i+2 ==n && a[i]<a[i+1])
					break;
			}
		}
	}

	private static void swap(int[] a, int i, int j) {
		int temp=a[i];
		a[i] = a[j];
		a[j] = temp;
		
	}

}
