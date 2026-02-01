package com.naresh.dsalgo.string;

public class InPlaceReverse {
	public static void main(String[] args) {
		System.out.println(inPlace(new String("abcd")));
	}

	private static String inPlace(String input) {
		final StringBuilder sb = new StringBuilder(input);
		int length = sb.length();
		for(int i =0; i<length /2 ; i++){
			final char current = sb.charAt(i);
			final int otherEnd = length - i - 1;
			sb.setCharAt(i, sb.charAt(otherEnd)); //swap
			sb.setCharAt(otherEnd, current);
		}
		return sb.toString();
			
	}

}
