package com.naresh.leetcode.old.javapractice.corejava.outputs.factset;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatcherTest {
	public static void main(String[] args) {
		Pattern pattern = Pattern.compile("a{1,3}b?c*");
		Matcher matcher = pattern.matcher("ac");
		System.out.println(matcher.matches());
		Matcher matcher1 = pattern.matcher("bc");
		System.out.println(matcher1.matches());
	}
}
