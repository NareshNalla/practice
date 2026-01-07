package com.naresh.leetcode.old.javapractice.gfg.recur.bt;

public class Sudoku {
	public static int ar[][] = {{3, 0, 6, 5, 0, 8, 4, 0, 0},
            {5, 2, 0, 0, 0, 0, 0, 0, 0},
            {0, 8, 7, 0, 0, 0, 0, 3, 1},
            {0, 0, 3, 0, 1, 0, 0, 8, 0},
            {9, 0, 0, 8, 6, 3, 0, 0, 5},
            {0, 5, 0, 0, 9, 0, 6, 0, 0},
            {1, 3, 0, 0, 0, 0, 2, 5, 0},
            {0, 0, 0, 0, 0, 0, 0, 7, 4},
            {0, 0, 5, 2, 0, 6, 3, 0, 0}};
	
	public static void main(String[] args) {
		if(solve()){
		System.out.println("Result:");
		printSolution();
		}else 
			System.out.println("unsolved");
	}

	private static boolean solve() {
		int temp[] = findUn();
		if(temp != null){
			int row = temp[0];
			int col = temp[1];
			for(int num=1;num<=9;num++){
				if(isSafe(row, col, num)){
					ar[row][col] = num;
					if(solve()){
						return true;
					}
					ar[row][col] =0;
				}
			}
		}else return true;
		
		return false;
	}

	private static int[] findUn() {
		int[] t = new int[2];
		for(int i=0; i<ar.length; i++){
			for(int j=0; j<ar.length; j++){
				if(ar[i][j] == 0){
					t[0] = i;
					t[1] = j;
					return t;
				}
			}
		}
		return null;
	}

	private static boolean isSafe(int row, int col, int num) {
		return checkRow(row, col, num) && checkCol(row, col, num) && checkGrid(row, col, num);
	}

	private static boolean checkRow(int row, int col, int num) {
		for(int i =0; i<ar.length; i++){
			if(ar[row][i] == num){
				return false;
			}
		}
		return true;
	}
	

	private static boolean checkCol(int row, int col, int num) {
		for(int i=0; i<ar.length; i++){
			if(ar[i][col] == num)
				return false;
		}
		return true;
	}
	private static boolean checkGrid(int row, int col, int num) {
		row = row -(row%3);
		col = col- (col%3);
		for(int i=0; i<3; i++){
			for(int j=0; j<3; j++){
				if(ar[i+row][j+col] == num)
					return false;
			}
		}
		return true;
	}

	private static void printSolution() {
		for(int i=0; i<ar.length; i++){
			for(int j=0;j<ar.length;j++){
				System.out.print(" "+ar[i][j]);
			}
			System.out.println();
		}
			
		}

}
