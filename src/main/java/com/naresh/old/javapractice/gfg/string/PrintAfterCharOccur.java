package com.naresh.old.javapractice.gfg.string;

public class PrintAfterCharOccur {
	public static void main(String[] args) {
		//String s= "Naresh Nalla";
		//printAfterCharOccur(s, 'e', 1);
		String s="geeksforgeeks";
		printAfterCharOccur(s, 'e', 2);
	}

	private static void printAfterCharOccur(String s, char ch, int count) {
		int occ=0;
		int i;
		if(count == 0){
			System.out.println(s);
		return;
		}
		for(i=0;i<s.length();i++){
			if(s.charAt(i) == ch){
				occ++;
			}
			if(occ == count){
				break;
			}
		}
		if(i<s.length()-1){
			System.out.println(s.substring(i+1));
		}else{
			System.out.println("Empty String");
		}
		
	}

}
