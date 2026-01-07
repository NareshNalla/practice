package com.naresh.leetcode.old.javapractice.string;

public class ReverseOfArrayString {

	//main method begins execution of Java application
	public static void main(String[] args) {
		//Initialize an array with character elements
		char[] array = {'F', 'u', 't', 'u', 'r', 'a', 'm', 'a'};
		//Call ReverseArray class method, reverseArrayOrder, and pass the array as an argument
		reverseArrayOrder(array);
	}//end of main method
	//Start of method reverseArrayOrder that accepts a character array argument and reverses the
	//order of the elements in the array
	public static void reverseArrayOrder(char[] array){
		//Display the current element order in array
		System.out.println("The current element order in the array are: ");
		//Loop for the entire array length and print out each element in array
		for (int i = 0; i < array.length; i++){
			System.out.print(array[i] + " ");
		}//end for loop
		//Declare a temporary variable to store a character, called temp
		char temp;
		/*
		 * In for loop, the variable i is counting up starting from the first index of the array.
		 * The variable j is counting down starting from the last index of the array.
		 * The loop continues as long as variable i is less than half of the array length.
		 * We want to loop half of the length of the array because two elements are swapping at once.
		 */
		for (int i = 0, j = array.length-1; i < (array.length/2); i++, j--){
			//Assign the value of array[i] element to temp, so the value won't be overwritten
			temp = array[i];
			//Assign the value of array[j] to array[i]
			array[i] = array[j];
			//Assign the value of temp to array[i]
			array[j] = temp;
		}//end for loop
		//Display the new element order in the array
		System.out.println("\nThe new element order in the array are: ");
		//Loop for the entire array length and print out each element in array
		for (int i = 0; i < array.length; i++){
			System.out.print(array[i] + " ");
		}//end for loop
	}//end of method reverseArrayOrder
}//end of class ReverseArray