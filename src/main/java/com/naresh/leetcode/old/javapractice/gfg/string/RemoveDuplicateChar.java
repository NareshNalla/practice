package com.naresh.leetcode.old.javapractice.gfg.string;

import java.util.Arrays;

public class RemoveDuplicateChar {
	public static void main(String[] args) {
		String s="asdefdenareshs";
		char[] ch=s.toCharArray();
		removeduplicate(ch);
	}

	private static void removeduplicate(char[] ch) {
		 Arrays.sort(ch);
		System.out.println(ch);
		StringBuffer sb= new StringBuffer();
		for(int i=0;i<ch.length;i++){
			for(int j=0;j<sb.length();j++){
		   if( sb.charAt(i) == ch[j]){
			   ch[j] =0;
		   }else{
		   sb.append(ch[j]);
		}}}
		System.out.println(sb);
		
	}
}
