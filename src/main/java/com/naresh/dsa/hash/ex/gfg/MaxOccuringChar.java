package com.naresh.dsa.hash.ex.gfg;

public class MaxOccuringChar {

	static final int ASCII_SIZE = 256;
	static char getMaxOccuringChar(String str)
	{
		// Create array to keep the count of individual
		// characters and initialize the array as 0
		int count[] = new int[ASCII_SIZE];

		// Construct character count array from the input string.
		int len = str.length();
		for (int i=0; i<len; i++)
			count[str.charAt(i)]++;

		int max = -1;  // Initialize max count
		char result = ' ';   // Initialize result

		// Traversing through the string and maintaining the count of each character
		for (int i = 0; i < len; i++) {
			if (max < count[str.charAt(i)]) {
				max = count[str.charAt(i)];
				result = str.charAt(i);
			}
		}
		return result;
	}
	// Driver Method
	public static void main(String[] args)
	{
		String str = "sample string";
		System.out.println("Max occurring character is " +
				getMaxOccuringChar(str));
	}
	/*
	ASCII characters are 256, so we use our Hash array size as 256. But if we know that our input string will have characters with value from 0 to 127 only, 
	we can limit Hash array size as 128. Similarly, based on extra info known about input string, the Hash array size can be limited to 26.
	*/
	
	/*
	Time Complexity: O(n)
	Space Complexity: O(1) � Because we are using fixed space (Hash array) irrespective of input string size.
	*/
}

