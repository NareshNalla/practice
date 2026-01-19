package com.naresh.old.javapractice.gfg.alg.dp;

public class KnapsackDP {
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
	private static int knapsack(int[] val, int[] wt, int w, int n) {
		int i , j;
		int k[][]=new int[n+1][w+1];
		for(i = 0; i<=n ; i++){
			for(j=0; j<= w; j++){
				
				if(i==0 || j == 0){
					k[i][j] = 0;
				}
				else if(wt[i-1] <= w){
					k[i][w] = max( 
							val[i-1]+ k[i-1][w-wt[i-1]],
							k[i-1][w]
							);
				}else k[i][w] = k[i-1][w];
				}
					
			}
		return k[n][w];
	}
}
