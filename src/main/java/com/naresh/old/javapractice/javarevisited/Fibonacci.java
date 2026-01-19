package com.naresh.old.javapractice.javarevisited;

import java.util.Scanner;

public class Fibonacci {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int i = sc.nextInt();
		int result =  fibonacci(i);
		System.out.println(result);
		System.out.println(fibonacci2(4));
	}
	public static int fibonacci2(int number){
        if(number == 1 || number == 2){
            return 1;
        }
        int fibo1=1, fibo2=1, fibonacci=1;
        for(int i= 3; i<= number; i++){
           
            //Fibonacci number is sum of previous two Fibonacci number
            fibonacci = fibo1 + fibo2;             
            fibo1 = fibo2;
            fibo2 = fibonacci;
          
        }
        return fibonacci; //Fibonacci number
      
    }   


	private static int fibonacci(int n) {
	 if(n == 0){
		 return 0;
	 }
	 if(n <= 2){
		return 1;
	 }
	  
	 return fibonacci(n-1)+fibonacci(n-2);
		
		
	}

}
