package com.naresh.leetcode.outputs.factset;

public class ArrayIndexEx {
	public static void main(String[] args) {
		int[] x = { 1, 2, 3, 4, 5 };
		f(x, 5);
	}

	private static void f(int[] x, int length) {
		System.out.println(" " + x[length - 1]);
		f(x, length - 1);

	}
}
