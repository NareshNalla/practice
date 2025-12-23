package com.naresh.old.javapractice.string;


public class ReplaceSpaceWithOutStringClass {
	
	static int count=0;
	
	public static void removeSpaces(String str)throws Exception{
		// To keep track of non-space character count
		
		// Traverse the given string. If current character
	    // is not space, then place it at index 'count++'
		StringBuffer[] str1=null;
		
		for (int i=0; i<str.length(); i++) {
			
			if(str.charAt(i) !=' '){
				
				char c=str.charAt(count++);
				str.charAt(i)==c;
			}
		}
		System.out.println("in removeSpaces "+str); 
	}
	public static void main(String[] args)throws Exception {
		String str="abc d ef g hi klm";
		removeSpaces(str);
		
	}
}
	
	
	