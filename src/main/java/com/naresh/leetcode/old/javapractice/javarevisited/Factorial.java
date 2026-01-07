package com.naresh.leetcode.old.javapractice.javarevisited;

import java.util.Scanner;

public class Factorial {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int n= sc.nextInt();
		System.out.println(fact(n));
		System.out.println(factIte(n));
		System.out.println(fact1Ternary(n));
	}

	private static int factIte(int num) {
		int res = 1;
		while(num !=0){
			res = res *num;
			num--;
		}
		return res;
	}

	private static int fact(int n) {
		if( n == 0){
			return 0;
		}
		if( n == 1){
			return 1;
		}
		return n*fact(n-1);
		
	}	
	static int fact1Ternary(int n){
		//single line to find factorial
		return (n ==1 || n==0) ? 1 : n*fact1Ternary(n-1);
	}
	

}
