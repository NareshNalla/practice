package com.naresh.dsa.hash.ex.gfg;

import java.util.LinkedHashSet;

public class RemoveDuplicatesChar {
 public static void main(String[] args) {
	String s= "nareshnalla";
	remove(s);
}

private static void remove(String s) {
	
	LinkedHashSet<Character> lh= new LinkedHashSet<>();//dont forget generic
	for(int i=0;i<s.length();i++)
	lh.add(s.charAt(i));
	System.out.print(lh.toString());
	
	for(Character ch:lh){
		System.out.print(ch);
	}
	
	
	
	
}
}
