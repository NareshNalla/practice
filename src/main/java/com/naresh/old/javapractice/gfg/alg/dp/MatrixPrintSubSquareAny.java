package com.naresh.old.javapractice.gfg.alg.dp;

/*
Time Complexity : O(Row * Col)
Auxiliary Space : O(Row * Col)
*/
public class MatrixPrintSubSquareAny {
	public static void main(String[] args) 
    {
		//only wrks for 0 and 1s
        int M[][] =  {{ 2, 2, 3, 3, 4, 4},
                {5, 5, 7, 7, 7, 4},
                {1, 2, 7, 7, 7, 4},
                {4, 4, 7, 7, 7, 4},
                {5, 5, 5, 1, 2, 7},
                {8, 7, 9, 4, 4, 4} };              
       System.out.println("Result :"+ printMaxSubSquare(M));
    }

	private static int printMaxSubSquare(int[][] m) {
		int r = m.length;
		int c= m[0].length;
		int dp[][] = new int[r][c];
		int i, j;
		int result =0;
		for(i=0;i<r;i++){
			for(j =0;j<c;j++ ){
			if(i == 0 || j == 0){
				dp[i][j] = 1;
			}else{
				if(m[i][j] == m[i-1][j]&& 
				   m[i][j] == m[i][j-1] &&
				   m[i][j] == m[i-1][j-1]){
					   dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1])+1;
				   }else dp[i][j] =1;
			}
			result =  Math.max(result, dp[i][j]);
		}
	}
		return result;
	}
}
/*Method I ( Naive approach ) - 
We can easily find all the square submatrices in O(n3) time and check whether each submatrix contains equal elements or not in O(n2) time Which makes the total running time of the algorithm as 
O(n5).*/