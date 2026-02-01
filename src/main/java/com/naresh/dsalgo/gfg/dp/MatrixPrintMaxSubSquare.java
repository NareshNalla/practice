package com.naresh.dsalgo.gfg.dp;

public class MatrixPrintMaxSubSquare {
	public static void main(String[] args) 
    {
		//only wrks for 0 and 1s
        int M[][] =  {{0, 1, 1, 0, 1}, 
                      {1, 1, 0, 1, 0}, 
                      {1, 1, 1, 1, 0},
                      {1, 1, 1, 1, 0},
                      {1, 1, 1, 1, 1},
                      {0, 0, 0, 0, 0}};
              
        printMaxSubSquare(M);
    }

	private static void printMaxSubSquare(int[][] m) {
		int r = m.length;
		int c= m[0].length;
		int s[][] = new int[r][c];
		int i, j;
		
		//set first col of s[][]
		for( i=0; i<r; i++){
			s[i][0] = m[i][0];
		}
		
		//set first row
		for( j=0;j<c; j++){
			s[0][j] = m[0][j];
		}
		//Constract other entries 
		for(i = 1; i<r; i++){
			for(j = 1;j<c;j++ ){
				if(m[i][j] != 1){
					s[i][j] = s[i][j];
				}else{
					s[i][j]=Math.min(s[i][j-1],Math.min(s[i-1][j], s[i-1][j-1]))+1;
				}
			}
		}
		
		//find the maximum entry 
		int max_of_s= s[0][0];
		int max_i=0; int max_j=0;
		for(i =0; i<r; i++){
			for(j=0; j<c; j++){
				if(max_of_s < s[i][j]){
					max_of_s = s[i][j];
					max_i = i;
					max_j = j;
				}
			}
		}
		
		System.out.println("Result:");
		for(i = max_i; i> max_i- max_of_s;i--){
			for(j=max_j ; j >max_j- max_of_s ; j--){
				System.out.print(m[i][j]+" ");
			}
			System.out.println();
		}
			
		}

}
/*
Time Complexity: O(m*n) where m is number of rows and n is number of columns in the given matrix.
Auxiliary Space: O(m*n) where m is number of rows and n is number of columns in the given matrix.*/
