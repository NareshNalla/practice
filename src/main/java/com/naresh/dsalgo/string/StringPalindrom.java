package com.naresh.dsalgo.string;

public class StringPalindrom {
	public static void main(String[] args) {
		String s = "abcba";
		System.out.println(reverse(s));
		checkPalindrom(s);
		
	}

	private static void checkPalindrom(String s) {
		int lenght = s.length();
		StringBuffer sb = new StringBuffer();
		//char[] c = s.toCharArray();
		for(int i=lenght-1;i>=0;i--){
			//System.out.print(c[i]);
			sb = sb.append(s.charAt(i));
		}
		
		if(s.equals(sb.toString())){
			System.out.println("true");
		}else{
			System.out.println("flase");
		}
	}
	public static String reverse(String input){
        if(input == null || input.isEmpty()){
            return input;
        }
       
        return input.charAt(input.length()- 1) + reverse(input.substring(0, input.length() - 1));
    }




}
