package com.naresh.a_dsalgo.number;

public class ReverseNumber {
	public static void main(String[] args) {
		int num = 121;
		System.out.println(" revers "+reversNum(num));
        int reverse = reversNum(num);
        if(reverse == num){
            System.out.println(" palindrome True");
        }else{
            System.out.println("palindrome False");
        }
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
