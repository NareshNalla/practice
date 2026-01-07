package com.naresh.leetcode.old.javapractice.gfg.alg.dp;

public class KnapsackNaiveRecursive {
	public static void main(String[] args) {
		int value[] = {60,100,120};
		int weight[] = {10,20,30};
		int w=50;
		int n=value.length;
		
		System.out.println("Result:"+knapsack(value,weight,w,n));
		
	}
	static int max(int a, int b){
		return (a>b)?a:b;
	}
	private static int knapsack(int[] val, int[] wt, int w,int n) {
		if(n == 0 || w==0){
			return 0;
		}
		if(wt[n-1] > w){
			return knapsack(val,wt,w,n-1);
		}
		else return max(val[n-1] 
				+ knapsack(val, wt,w-wt[n-1],n-1), 
				knapsack(val,wt,w,n-1));
	}
}
