package com.naresh.leetcode.old.javapractice.gfg.alg.dp;

public class TileTheFloor {
	public static void main(String[] args) {
		int m = 4, n = 4;
		System.out.println("Result:"+tileFloor(m,n));
	}

	private static int tileFloor(int m, int n) {
		int count[]= new int[m+1];
		count[0] =0;
		
		for(int i=1; i<=m; i++){ //<= 
			if( i > n){
				count[i] = count[i-1] + count[i-n];
			}else if( i < n){
				count[i] = 1;
			}else 
				count[i] = 2;
		}
		return count[m];
	}

}
