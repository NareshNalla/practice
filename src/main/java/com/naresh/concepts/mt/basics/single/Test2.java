package com.naresh.concepts.mt.basics.single;

public class Test2 {
	public static void main(String[] args) throws  Exception {
		for(int i=1;i<=10;i++){
			System.out.println(i);
			Thread.sleep(1000);
		}
		System.out.println("Main Therminated");
	}

}
