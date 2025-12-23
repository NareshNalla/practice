package com.naresh.old.javapractice.javaapi.collection;

import java.util.Arrays;
import java.util.List;

public class GetNamesStartwithAStreams {
    static int count = 0;
    public static void main(String[] args) {
	
	List<String> l = Arrays.asList("Naresh","Mounika", "Adya","Ganga","Ani");
	
	l.stream().forEach(x ->{
	   if(x.toLowerCase().startsWith("a")) {
	       count++;
	       System.out.println(x);
	   }
	});
	System.out.println(count);
    }
}
