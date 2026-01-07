package com.naresh.leetcode.old.javapractice.basic.ll.ex;

public class LinkedListPalindromTest {
	public static void main(String[] args) {
		LinkedListPalindromImpl lp = new LinkedListPalindromImpl();
		char str[] = {'M','A','D','A','M'};
		String string= new String(str);
		for(int i=0; i<str.length;i++){
			lp.push(str[i]);
			lp.printList(lp.head);
			if(lp.isPalindrome(lp.head) != false){
				System.out.println("Is Palindrome");
				System.out.println("");
			}else{
				System.out.println("Not Palindrome");
				System.out.println("");
			}
		}
	}

}
