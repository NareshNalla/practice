package com.naresh.leetcode.old.javapractice.gfg.recur.bt;

public class NQueen {
	final int N=4;
	public static void main(String[] args) {
		NQueen queen= new NQueen();
		queen.solveNQ();
	}
	private boolean solveNQ() {
		int board[][] = {{0,0,0,0},
				{0,0,0,0},
				{0,0,0,0},
				{0,0,0,0}};
	if(solveNQUtil(board,0) == false){
		System.out.print("Solution dones not exist");
		return false;
	}
	printSolution(board);
	return true;
	}
	
	boolean  solveNQUtil(int[][] board, int col) {
		//base case- if all queens are placed then return true
		if(col >= N)
			return true;
		
		//Consider this column and try placing this queen in all rows one bye one
		for(int i=0; i<N; i++){
			//chack if queen can be placed on board[i][col]
			if(isSafe(board, i ,col)){
				//place this queen in board[i][col]
				board[i][col] = 1;
				//recur to place reset of the queen
				if(solveNQUtil(board, col+1) == true)
					return true;
				/*
				 * if placing queen in board[i][col] doesn't lead to a solution then
				 *  remove queen from board[i][col]
				 */
				board[i][col] =0;//Backtrack
			}
		}
		//If queen can not be placed in any row in this colum col, then retun false
		return false;
	}
	private boolean isSafe(int[][] board, int row, int col) {
		int i , j;
		//check this row on left side
		for(i=0; i< col; i++)
			if(board[row][i]==1){
				return false;
			}
		//check upper diagonal on left side
		for(i=row, j=col; i>=0 && j>=0; i-- , j--){
			if(board[i][j] ==1)
				return false;
		}
		//check lower diagonal on left side
		for(i = row, j=col; i>=N && j>=0; i++, j--)
			if( board[i][j] == 1)
				return false;
		
		return true;
	}
private void printSolution(int[][] board) {
	for(int i=0; i<N; i++){
		for(int j=0;j<N;j++){
			System.out.print(" "+board[i][j]);
		}
		System.out.println();
	}
		
	}
}
