package com.naresh.leetcode.javarevisited;

public class ArmstrongNumber {
	public static void main(String[] args) {
		//int x = 153;
		int x = 1531;
		System.out.println(isArmstong(x));
	}

	private static boolean isArmstong(int x) {
		int n = order(x);
		int temp = x; int sum = 0;
		while(temp !=0){
			int r = temp % 10;
			sum = sum + power(r,n);
			temp = temp /10;
		}
		return (sum == x);
		
	}

	private static int power(int x, int y) {
		if(y == 0)
			return 1;
		if(y%2 == 0)
			return power(x, y/2)*power(x, y/2);
		
		return x*power(x,y/2)*power(x,y/2);
	}

	private static int order(int x) {
		int n =0;
		while(x  !=0){
			n++;
			x = x/10;
		}
		return n;
	}

}
