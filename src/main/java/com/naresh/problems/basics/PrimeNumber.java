package com.naresh.problems.basics;

import java.util.Scanner;

public class PrimeNumber {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int n = sc.nextInt();
		//findPrime(n);
		for (int i = 0; i <= n; i++) {  
	           if (isPrime(i)) {  
	               System.out.print(i+" ");  
	           }  
	       }  
	}

	private static void findPrime(int n) {
		int m=0; int flag =0;
		if( n == 0 || n ==1){
			System.out.println(n+" not prime");
		}else
			for(int i=2;i<=0;i++){
				if(n%i==0){
					System.out.println(n+" not prime");
					flag =1;
					break;
				}
			}
		if(flag == 0){
			System.out.print(n+" prime");

		}

	}
	public static boolean isPrime(int n){
			if(n <= 1){
				return false;
			}
			for(int j =2;j <=Math.sqrt(n);j++){
				if(n % j == 0){
					return false;
				}
			}
				return true;
		}
	static boolean isPrime1(int n)
    {
		//Time complexity of this solution is O(squarroot n)
		//Introduction and School Method
        // Corner cases
        if (n <= 1) return false;
        if (n <= 3) return true;
     
        // This is checked so that we can skip 
        // middle five numbers in below loop
        if (n % 2 == 0 || n % 3 == 0) return false;
     
        for (int i = 5; i * i <= n; i = i + 6)
            if (n % i == 0 || n % (i + 2) == 0)
            return false;
     
        return true;
    }
	
}
