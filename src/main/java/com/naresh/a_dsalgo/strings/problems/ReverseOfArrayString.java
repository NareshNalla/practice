package com.naresh.a_dsalgo.strings.problems;

public class ReverseOfArrayString {

	public static void main(String[] args) {
		char[] array = {'F', 'u', 't', 'u', 'r', 'a', 'm', 'a'};
		reverseArrayOrder(array);
	}
	public static void reverseArrayOrder(char[] array){
		System.out.println("The current element order in the array are: ");
		for (int i = 0; i < array.length; i++){
			System.out.print(array[i] + " ");
		}
		char temp;
		/*
		 * We want to loop half of the length of the array because two elements are swapping at once.
		 */
		for (int i = 0, j = array.length-1; i < (array.length/2); i++, j--){
			temp = array[i];
			array[i] = array[j];
			array[j] = temp;
		}
		System.out.println("\nThe new element order in the array are: ");
		for (int i = 0; i < array.length; i++){
			System.out.print(array[i] + " ");
		}
	}
}