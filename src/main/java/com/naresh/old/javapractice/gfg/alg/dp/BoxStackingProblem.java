package com.naresh.old.javapractice.gfg.alg.dp;

import java.util.Arrays;

/*
Time Complexity: O(n^2)
Auxiliary Space: O(n)
*/
public class BoxStackingProblem {
	public static void main(String[] args) {
		//int [] [] x= {{4, 7, 9},{5, 8, 9}, {11, 20, 40}, {1, 2, 3}};
		int [] [] x= {{4, 6, 7}, {1, 2, 3}, {4, 5, 6}, {10, 12, 32}};
		System.out.println("Result:"+boxStacking(x));

	}
	private static int boxStacking(int[][] x) {

		Box [] boxes = new Box[x.length*3];
		for (int i = 0; i<x.length ; i++) {
			int h = x[i][0];
			int w = x[i][1];
			int d = x[i][2];
			boxes[i*3] = new Box(h,w,d); //normal dimension
			boxes[i*3+1] = new Box(w,h,d); //first dimension
			boxes[i*3+2] = new Box(d,h,w); //second dimension
		}
		Arrays.sort(boxes);
		//to display all the possible boxes.
		System.out.println("All possible:");
		for(int i= 0; i< boxes.length;i++){
			System.out.println(boxes[i].height+" "+boxes[i].width+" "+boxes[i].depth);
		}

		int[] optimalHeight = new int[boxes.length+1];

		//if there are no boxes then optimal height =0
		optimalHeight[0] = 0;

		for(int i=1; i < optimalHeight.length; i++){
			int maxHeightIndex=0;
			for(int j=i-1; j>= 0; j--){
				//first check if the box can be placed
				if(boxes[j].width > boxes[i-1].width && 
						boxes[j].depth > boxes[i-1].depth){
					if(optimalHeight[maxHeightIndex] < optimalHeight[j+1]){
						maxHeightIndex = j+1;
					}
				}
			}
			optimalHeight[i]= optimalHeight[maxHeightIndex] + boxes[i-1].height;
		}
		return optimalHeight[optimalHeight.length - 1];
	}
}
class Box implements Comparable<Box>{
	int height;
	int width;
	int depth;
	public  Box(int height,int width, int depth){
		this.height = height;
		this.width = width;
		this.depth = depth;
	}
	@Override
	public int compareTo(Box o) {
		int area = o.depth*o.width;
		int thisArea = this.depth * this.width;
		return area-thisArea;
	}
}

