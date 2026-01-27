package com.naresh.dsa.hash.ex.gfg;
/*
1) Initialize Binary Hash Map M[] = {0, 0, ...}
2) Do following for each element A[i] in A[]
   (a)	If M[x - A[i]] is set then print the pair (A[i], x - A[i])
   (b)	Set M[A[i]]
		   */
public class PairSum {
	private static final int MAX= 100000; //MAX size of hashMap
	static void printPairs(int arr[]){
		int sum=16;
		boolean[] binmap = new boolean[MAX];
		for(int i=0;i<arr.length; i++){
			int temp = sum - arr[i];
			if(temp >= 0 && binmap[temp]){
				System.out.println("Pairs with given sum "+sum+ " is("+arr[i]+", "+temp+")");
			}
			binmap[arr[i]] = true;
		}
	}
	public static void main(String[] args) {
		int a[] = { 1, 10, 20, 6, 10, 6};
		printPairs(a);
	}

}
/*
Because its not necessary that array will contain all value less than or equal to size of array.
Infact array can contain any big value and to store value 0 or 1 at that index we have to take MAX size array for binmap.*/

/*What if there is a repetition of numbers in array. 
Eg. 1,1, 5, 5,7 Sum is 6. 
As per the above algo there are only one pair 1,5 but there are 4 1,5 pairs*/