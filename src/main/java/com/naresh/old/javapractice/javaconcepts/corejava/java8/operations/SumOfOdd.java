package com.naresh.old.javapractice.javaconcepts.corejava.java8.operations;

import java.util.*;

public class SumOfOdd {
    
    public static void main(String[] args) {
	List<Integer> ar =  Arrays.asList(1,2,3,4,5,65,6,2,32,343,4,3);
  	  
    	Optional<Integer> o=  ar.stream().filter(x-> !(x%2==0)).reduce( (x, x1) -> x1+x);
    	System.out.println(o.get());
    	
    	Map<String,String> map =new HashMap<String,String>();
    	System.out.println(map.put("a",null));
    	System.out.println(map.put("a",null));
	
    }
     
}

