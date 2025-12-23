package com.naresh.old.javapractice.gfg.alg.dp;
//Time complexity O(mn).

public class MatrixNumberOfPaths {
	public static void main(String args[])
    {
        System.out.println(numberOfPaths(3, 3));
    }

	private static int numberOfPaths(int m, int n) {
		
		int count[][] = new int[m][n];
		int i, j;
		for(i=0; i <m; i++){
			count[i][0]=1;
		}
		for(j=0;j<n;j++){
			count[0][j] =1;
		}
		for(i=1; i<m;i++){
			for(j=1;j<n;j++){
				count[i][j] = count[i][j-1] + count[i-1][j];
			}
		}
		return count[m-1][n-1];
	}

}
