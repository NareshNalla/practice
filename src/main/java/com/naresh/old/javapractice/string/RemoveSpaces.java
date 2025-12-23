package com.naresh.old.javapractice.string;

public class RemoveSpaces {

	public static void main(String[] args) {
		String abc="g eeks for ge eeks ";
		System.out.println(abc.replaceAll("\\s+",""));

	}

}
