package com.naresh.leetcode.old.javapractice.companywise.factset;

public class Test2 {
public static void main(String[] args) {
	int[] x = {1,2,3,4,5};
	f(x,5);
}

private static void f(int[] x, int length) {
	System.out.println(" "+x[length - 1]);
	f(x, length - 1);
	
}
}
