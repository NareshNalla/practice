package com.naresh.corejava.collections;

import java.util.*;
import java.util.stream.Collectors;

public class MapSortExample {
    public static void main(String[] args) {
	
	int[] a = {123,1345123, 2345,24456};
	System.out.println(findQualifiedNumbers(a));
    }
    
    static String findQualifiedNumbers(int[] numberArray) {
        HashMap<Integer, Integer> hm= new HashMap<>(); 
        String result="";
        for(int x: numberArray){
            String xS = x+"";
           // char[] ch = {'1','2','3'};
            if(xS.contains("1")&&xS.contains("2")&&xS.contains("3")){
                hm.put(Integer.valueOf(xS), xS.length());
                
            }
         
       }
  
        List<Map.Entry<Integer,Integer>> sortBySize = new LinkedList<Map.Entry<Integer,Integer>>(hm.entrySet());

        Collections.sort(sortBySize, new Comparator<Map.Entry<Integer,Integer>>() {

            @Override public int compare(Map.Entry<Integer,Integer> o1,
        	    Map.Entry<Integer,Integer> o2){ return
        		    (o2.getValue()).compareTo(o1.getValue()); } });



        hm.entrySet()
        .stream()
        .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
        .forEach(System.out::println);


    //collect the values into map
    Map<Integer, Integer> result1 = hm.entrySet()
	    .stream()
	    .sorted(Map.Entry.<Integer, Integer>comparingByValue())
	    .collect(Collectors.toMap(
	      Map.Entry::getKey, 
	      Map.Entry::getValue, 
	      (oldValue, newValue) -> newValue, LinkedHashMap::new));
    
    
    System.out.println(result1);
    
    

    for (Map.Entry<Integer, Integer> val : sortBySize) {
	if (result != "") {
	    result = result + ",";
	}
	result = result + val.getKey();

    }


    return result;
    }

}
