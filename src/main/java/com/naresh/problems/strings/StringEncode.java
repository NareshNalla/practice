package com.naresh.problems.strings;

public class StringEncode {
	public static void main(String[] args) {
		String str="aabbccccdaa";
		String compressed="";
		char ch=0;
		int count=1;
		for(int x = 0; x<str.length(); x++){
			if(ch == str.charAt(x)){
			count = count+1;
			}else{
				compressed = compressed + ch;
				if(count != 1){
					compressed = compressed +count;
				}
				ch = str.charAt(x);
				count = 1;
			}
		}
		compressed = compressed + ch;
		if( count!=1){
			compressed = compressed + count;
		}
		System.out.println("Compressed: "+compressed);
	}

}
