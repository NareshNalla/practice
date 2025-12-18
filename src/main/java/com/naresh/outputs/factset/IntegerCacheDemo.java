package com.naresh.outputs.factset;

/**
 * Demonstrates the behavior of the Java Integer cache.
 */
public class IntegerCacheDemo {
	public static void main(String[] arr) {
		Integer num1 = 100;
		Integer num2 = 100;
		Integer num3 = 500;
		Integer num4 = 500;

		if (num1 == num2) {
			System.out.println("num1 == num2");
		} else {
			System.out.println("num1 != num2");
		}
		if (num3 == num4) {
			System.out.println("num3 == num4");
		} else {
			System.out.println("num3 != num4");
		}
	}
   /*
    == on objects compares memory references, not their values.
    •
    To save memory, Java caches Integer objects for values between -128 and 127.
    •
    Always use the .equals() method to compare the actual values of wrapper objects like Integer, Double, etc. (num3.equals(num4) would be true).
   */
}
