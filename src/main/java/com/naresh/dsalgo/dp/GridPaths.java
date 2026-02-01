package com.naresh.dsalgo.dp;

import java.util.Arrays;

public class GridPaths {

	public static void displayPaths(int n) {
		auxPaths(0, 0, n, "");
	}
	private static void auxPaths(int i, int j, int n, String path) {
		if(i >= n || j >= n) return;
		if(i == n-1 && j == n-1) {
			System.out.println(path+"("+(n-1)+","+(n-1)+")");
			return;
		}
		auxPaths(i, j+1, n, path+"("+(i)+","+(j)+")");
		auxPaths(i+1, j, n, path+"("+(i)+","+(j)+")");
	}
	public static int maxSum4(int[][] in) {
		int[][] mem = new int[in.length+1][in.length+1];
		for(int i = 0; i <= in.length; ++i)
			mem[i][0] = mem[0][i] = 0;
		for(int i = 1; i <= in.length; ++i) {
			for(int j = 1; j <= in.length; ++j) {
				int top = mem[i-1][j];
				int left = mem[i][j-1];
				mem[i][j] = Math.max(top, left) + in[i-1][j-1];
			}
		}
		System.out.println();
		for(int[] tmp:mem)
			System.out.println(Arrays.toString(tmp));
		retrieveOptimalPath(in.length, in.length, mem);
		System.out.println("(" + in.length + "," + in.length + ")");

		return mem[in.length][in.length];
	}
	private static void retrieveOptimalPath(int i, int j, int[][] mem) {
		if(i == 1 && j == 1) return;
		if(mem[i-1][j] > mem[i][j-1]) {
			retrieveOptimalPath(i-1, j, mem);
			System.out.print("(" + (i-1) + "," + j + ")->");
		} else {
			retrieveOptimalPath(i, j-1, mem);
			System.out.print("(" + i + "," + (j-1) + ")->");
		}			
	}

	
	public static void main(String[] args) {
		int n = 5;//Integer.parseInt(args[0]);
		int[][] in= {{500, 100, 230},
		           {1000, 300, 100},
		           {200, 1000, 200}};
		int[][] in1= {{1, 2, 1},
		           {1, 2, 2},
		           {0, 1, 3}};
		int ans = maxSum4(in1);
	}


}