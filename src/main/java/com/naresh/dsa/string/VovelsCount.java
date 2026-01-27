package com.naresh.dsa.string;
/**
 * Vowel Counter
 * HW 4, part 1
 * CSC 211 602
 * @JustinWhite
 */
import java.util.Scanner;
public class VovelsCount {
	public static void main(String [ ] args) {
		Scanner input = new Scanner(System.in);
		String[] words = new String[20];
		String word;
		String vowels = "aeiou";
		int count = 0;
		int vowelCount = 0;
		System.out.println("Enter words, press 'X' when done. Program will count vowels in words.");
		//Read user input and assign each word to an array until user types 'x'
		while (true){
			word = input.next();
			if (word.equals("x"))
				break;
			words[count] = word;
			count++;
		}
		//Take array of strings, and concatenate them into one string
		String combinedString ="";
		for(int i=0; i<count; i++)
			combinedString += words[i];
		//For every letter in the string, check if it is a vowel
		for (int z = 0; z < combinedString.length(); z++){
			char c = combinedString.charAt(z);
			if (vowels.indexOf(c) >= 0)
				vowelCount++;
		}
		System.out.println("You typed a total of " + vowelCount + " vowels.");
	}
}