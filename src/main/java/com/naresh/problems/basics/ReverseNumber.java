package com.naresh.problems.basics;

public class ReverseNumber {
	public static void main(String[] args) {
		int num = 1201;
		System.out.println(reversNum(num));
	}

	private static int reversNum(int num) {
		int reverse = 0;
		int reminder = 0;
		if(num %10 == 0){
			System.out.print("0");
		}
		do{
			reminder = num %10;
			reverse = reverse * 10 + reminder;
			//reverse = reverse * 10 + num % 10 ;
			num = num / 10;
		}while(num >0);
		return reverse;
	}

}
