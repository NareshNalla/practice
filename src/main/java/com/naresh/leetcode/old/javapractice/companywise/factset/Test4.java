package com.naresh.leetcode.old.javapractice.companywise.factset;

public class Test4 {
	public static void main(String[] args) {
		Integer a =1;
		Integer b =2;
		
		int c =3;
		int d =4;
		
		swap(a,b);
		swap(c,d);
		
		System.out.format("%d %d %d %d",a,b,c,d);
		System.out.println(a+" "+b+" "+c+" "+d);
		
	}

	private static void swap(Integer a, Integer b) {
		Integer temp= a;
		a = b;
		b = temp;
	}
}

//1 2 3 4