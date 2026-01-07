package com.naresh.leetcode.old.javapractice.top20.sortedds;

import java.util.*;

public class GFG {
  
    // Driver Code
    public static void main(String[] args)
    {
  
        int[] array = { 4, 4, 2, 2, 2, 2, 3, 3, 1, 1, 6, 7, 5 };
        
        compareByFrequency(array);
  
  
    }

    private static void compareByFrequency(int[] array) {
	      Map<Integer, Integer> map = new HashMap<>();
	      List<Integer> outputArray = new ArrayList<>();
	  
	        for (int current : array) {
	            int count = map.getOrDefault(current, 0);
	            map.put(current, count + 1);
	            outputArray.add(current);
	        }
	  	  
	        Collections.sort(outputArray, (k1,k2)->{
	            int freqCompare = map.get(k2).compareTo(map.get(k1));
	            int valueCompare = k1.compareTo(k2);
	            if (freqCompare == 0)
	                return valueCompare;
	            else
	                return freqCompare; 
	        });
	  
	        for (Integer i : outputArray) {
	            System.out.print(i + " ");
	        }
	
    }
}
