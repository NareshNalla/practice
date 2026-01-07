package com.naresh.leetcode.old.javapractice.gfg.string;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MaxOccur {
	private static final int ASCII_SIZE = 256;

	public static void main(String[] args) {
		String s="Naresh Nalla";
		maxOccour(s);
		maxOcurence(s);
		maxOccur1(s);
	}

	private static void maxOccour(String s) {
		int[] count= new int[ASCII_SIZE];
		
		int len= s.length();
		for(int i=0;i<len;i++){
			count[s.charAt(i)]++;
		}
		int max = -1;
		char res=' ';
		
		for(int i=0; i<len; i++){
			if(max < count[s.charAt(i)]){
				max= count[s.charAt(i)];
				res= s.charAt(i);
			}
		}
		System.out.println(res);
	}
	/*other*/
	public static void maxOcurence(String str){
		 	//time complexity:O(n)
				
				str=str.toLowerCase();
		 	HashMap<Character,Integer> al=new HashMap<Character,Integer>();
				char array[]=str.toLowerCase().toCharArray();
		 	for(int i=0;i<=array.length-1;i++){
		 		char c=str.charAt(i);
		 		if(al.containsKey(c)){
		 			al.put(c, al.get(c)+1);
		 		}
		 		else{
		 		
		 		al.put(c,1);
		 		}
		 	}
		 	int max=Collections.max(al.values());
		 	for(Character key : al.keySet()){
		 		if(al.get(key)==max){
		 			System.out.println(key+":"+max);
		 		}
		 	}
		 }
public static void maxOccur1(String str){
    Map<Character, Integer> map = new HashMap<>();
    int max = 0;
    for (char c : str.toCharArray()) {
        map.put(c, map.get(c) == null ? 1 : map.get(c) + 1);
        int counter = map.get(c);
        if (counter > max) {
            max = counter;
        }
    }

    System.out.println("Max occurring character:" + max);

}

}

