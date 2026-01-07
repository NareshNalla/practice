package com.naresh.leetcode.old.javapractice.companywise.factset;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatcherTest {
	public static void main(String[] args) {
		Pattern pattern= Pattern.compile("a{1,3}b?c*");
		Matcher matcher = pattern.matcher("aaab");
		System.out.println(matcher.matches());
	}
}
