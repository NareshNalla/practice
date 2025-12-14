package com.naresh.strings;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class AnagramM1Java {
	public static void main(String[] args) throws IOException {
		/*Scanner sc = new Scanner(System.in);
		System.out.println("please enter string:");
		String str = sc.next();
		System.out.println("please enter another string:");
		String str2 = sc.next();*/
		anagramFind("list1","st1il");
}
static void	anagramFind(String str, String str2){
		if (str.length() == str2.length()) {
			
			Set<Object> s = new HashSet<>();
			Set<Object> s2 = new HashSet<>();
			for (int i = 0; i < str.length(); i++) {
				s.add(str.charAt(i));
			}
			for (int i = 0; i < str2.length(); i++) {
				s2.add(str2.charAt(i));
			}
			if (s.size()==s2.size() && s.equals(s2)){
				System.out.println("yes! this is anagram");
			}
			else
				System.out.println("No! this is not anagram");
			System.out.println("s:" + s);

		}
		else
			System.out.println("No! this is not anagram because of two different string size");
	}
	}