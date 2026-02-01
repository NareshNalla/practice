package com.naresh.dsalgo.basics;

public class IntegerPalindrom {
	public static void main(String[] args) {
		int num = 121;
		int palindrom = num;
		int reverse = 0;
		int rem;
		while(palindrom !=0){
		rem = palindrom%10;
		reverse = reverse * 10 +rem;
		palindrom = palindrom /10;
		}
		if(reverse == num){
			System.out.println("True");
		}else{
			System.out.println("False");
		}
		
	}

}
