package com.naresh.leetcode.old.javapractice.gfg.alg.dp;

public class MemoizationTopDownFibonacci {
	final static int MAX = 100;
	final static int NIL = -1;
	
	static int  lookup[] = new int[MAX];
	public static void main(String[] args) {
		int n = 40;
		_initialize();
		int r =fib(n);
		System.out.println("Fibonacci of" + n+" is :"+r);
		
	}
	private static void _initialize() {
		for(int i=0;i < MAX; i++){
			lookup[i] = NIL;
		}
		
	}
	private static int fib(int n) {
		if(lookup[n] == NIL){
			if(n <= 1){
				lookup[n] = n;
			}else{
				lookup[n] = fib(n-1) + fib(n-2);
			}
		}
		return lookup[n];
	}

}
