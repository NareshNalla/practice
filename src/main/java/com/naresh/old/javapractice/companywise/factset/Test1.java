package com.naresh.old.javapractice.companywise.factset;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test1 {

	public static void main(String[] args) {
		Pattern pattern= Pattern.compile("a{1,3}b?c");
		Matcher matcher = pattern.matcher("aaabc");
		System.out.println(matcher.matches());
	}
}

