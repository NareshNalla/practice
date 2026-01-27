package com.naresh.corejava.outputs;

import java.util.*;

public class MapValuesSort {
    public static void main(String[] args) {
	
	int[] a = {123,1345123, 2345,24456};
	findQualifiedNumbers(a);
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
        public int compare(Map.Entry<Integer,Integer> o1, Map.Entry<Integer,Integer> o2){
            return (o1.getValue()).compareTo(o2.getValue());
        }
    });
    
    for(Map.Entry<Integer,Integer> val:sortBySize){
        result = val.getKey()+","+val.getKey();
        
    }
    
    
    return result;
    }

}
