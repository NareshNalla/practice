package com.naresh.leetcode.old.javapractice.corejava.outputs.factset;

public class SwapStatic {
	public static Integer a =1;
	public static Integer b =2;
	public static void main(String[] args) {
		a =1;
		b =2;
		
		int c =3;
		int d =4;
		
		swapL(a,b);
		swap(c,d);
		
		System.out.format("%d %d %d %d",a,b,c,d);
		System.out.println(a+" "+b+" "+c+" "+d);
		
	}

	private static void swap(Integer a, Integer b) {
		Integer temp= a;
		a = b;
		b = temp;
	}
	private static void swapL(Integer a1, Integer b1) {
		Integer temp= a1;
		a = b1;
		b = temp;
	}
}

//1 2 3 4