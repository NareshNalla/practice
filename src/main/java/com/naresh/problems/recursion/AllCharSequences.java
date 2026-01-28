package com.naresh.problems.recursion;

import java.util.Arrays;

public class AllCharSequences {

	public static void allSeq(int n, char[] in) {
		char[] out = new char[n];
		auxSeq(0, out, in);
	}
	private static void auxSeq(int d, char[] out, char[] in) {
		if(d == out.length) {
			System.out.println(Arrays.toString(out));
			return;
		}
		for(int i = 0; i < in.length; ++i) {
			out[d] = in[i];
			auxSeq(d+1, out, in);
		}
	}
	public static void main(String[] args) {
		int n = 2; //Integer.parseInt(args[0]);
		char[] in = {'1','2','3'};// args[1].toCharArray();
		allSeq(n, in);
	}

}