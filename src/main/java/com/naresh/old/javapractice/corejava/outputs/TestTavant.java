package com.naresh.old.javapractice.corejava.outputs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

public class TestTavant {
    public static void main(String[] args) {
	
	List<String> list = Arrays.asList("abc","ace","mno","abc");
	HashMap<String, Integer> hs = new HashMap<>();
	
	Stream.of(list).forEach(x -> {
	    
	    if(hs.containsKey(x)) {
		Integer x =hs.get(x);
		
	    }else {
		hs.put(x,1);
	    }
	    
	});
	
    }
  
}
