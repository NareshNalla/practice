package com.naresh.companywise.altimtric;

public class BinarySearch {
    public static void main(String[] args) {
	//sorted
	// devide and search left or right 
	int[] a = {1,2,3,4,5,6,7,8,9};

	System.out.println(binarySearch(a,0));

    }

    private static boolean binarySearch(int[] ar, int k) {
	int first = 0;
	int last = ar.length-1;

	while(first!=last) {
	    int mid = (first+last)/2;
	    if(ar[mid] == k || ar[first] == k || ar[last] == k) {
		return true;
	    }
	    if(k<mid) {
		last=mid-1;
	    }else {
		first =mid+1;
	    }
	}
	return false;
    }

}
