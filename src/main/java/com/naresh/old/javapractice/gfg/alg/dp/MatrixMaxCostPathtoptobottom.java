package com.naresh.old.javapractice.gfg.alg.dp;

/*Time complexity : O(N*N) */
public class MatrixMaxCostPathtoptobottom {
	
	public static void main(String[] args) {
		int M[][] = {{ 4, 1 ,5 ,6 , 1 },
            { 2 ,9 ,2 ,11 ,10 },
            { 15,1 ,3 ,15, 2 },
            { 16, 92, 41,4,3},
            { 8, 142, 6, 4, 8 }	};
		
		System.out.println("Result: "+maxCost(M));
	

}

	private static int maxCost(int[][] m) {
		int i,j;
		int r= m.length;
		int c=m[0].length;
		int dp[][] = new int[r][c];
		dp[0][0]= m[0][0]; //if comnt will get  251
		
		for(i=1;i<r;i++){
			dp[i][0] = m[i][0] + dp[i-1][0];
		}
		for(i = 1; i<r;i++){
			for(j=1; j< i+1 && j< r; j++){
				dp[i][j] = m[i][j] + Math.max(dp[i-1][j-1], dp[i-1][j]);
			}
		}
		
		int result = 0;
		for( i=0; i<r; i++){
			if(result < dp[r-1][i]){
				result = dp[r-1][i];
			}
		}
		return result;
	}
}
/*
Output : 255
Path with max weight : 4 + 2 +15 + 92 + 142 = 255 */