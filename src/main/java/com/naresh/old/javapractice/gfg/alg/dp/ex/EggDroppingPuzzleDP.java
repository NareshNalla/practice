package com.naresh.old.javapractice.gfg.alg.dp.ex;

public class EggDroppingPuzzleDP {
	public static void main(String[] args) {
		int e=415; int f=10;
		
		System.out.println("Result:"+eggDrop(e,f));
	}
	
	private static int max(int a, int b) {
		return (a>b)?a:b;

	}
	private static int eggDrop(int e, int f) {
		
		int eggFloor[][] = new int[e+1][f+1];
		int res;
		int i,j,x;
		for(i=0; i<=e; i++){
			eggFloor[i][1]= 1;
			eggFloor[i][0]= 0;
		}
		for(j=1; j<=f;j++){
			eggFloor[1][j]=j;
		}
		
		for(i=2; i<=e; i++){
			for(j=2; j<=f; j++){
				eggFloor[i][j] = Integer.MAX_VALUE;
				for(x=1; x<=j; x++){
					res = 1+ max(eggFloor[i-1][x-1],eggFloor[i][j-x]);
					if(res <eggFloor[i][j])
						eggFloor[i][j] = res;
				}
			}
		}
		return eggFloor[e][f];
	}

}
