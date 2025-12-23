package com.naresh.old.javapractice.gfg.alg.sort.ex;

/*Given an array A[] consisting 
 * 0s, 1s and 2s, write a function that sorts A[]. 
 * The functions should put all 0s first, then all 1s and all 2s in last*/

public class Sort0s1s2s {
	public static void main(String[] args) {
		int[] a={0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
		sort0s1s2s(a);
		for (int i : a)
            System.out.print(i+" ");
		
	}
	
	private static void swap(int a[],int i,int j){
		int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
	}
	private static void sort0s1s2s(int[] a) {
		//sort the input array , the array is assumes to have values in (0,1,2}
		int lo = 0;
        int hi = a.length - 1;
        int mid = 0,temp=0;
        while (mid <= hi)
        {
            switch (a[mid])
            {
            case 0:
            {
                //
                //swap(a,a[lo],a[mid]);
            	//wont works
            	temp   =  a[lo];
                a[lo]  = a[mid];
                a[mid] = temp;
                lo++;
                mid++;
                break;
            }
            case 1:
                mid++;
                break;
            case 2:
            {
                temp = a[mid];
                a[mid] = a[hi];
                a[hi] = temp;
                hi--;
                break;
            }
            }
        }
}
}
//Time Complexity: O(n)