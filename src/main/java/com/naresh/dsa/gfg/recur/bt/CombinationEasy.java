package com.naresh.dsa.gfg.recur.bt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationEasy {
	public static void main(String[] args) {
		CombinationEasy cb = new CombinationEasy();
		cb.combinationEasy("AABC".toCharArray());
	}

	private void combinationEasy(char[] charArray) {
		List<Character> list = new ArrayList<>();
		Arrays.sort(charArray);
		combination(charArray, 0 , list);
	}

	private void combination(char[] charArray, int pos, List<Character> list) {
		list.forEach(list1 -> System.out.print(list1+ " "));
		System.out.println();
		for(int i = pos; i<charArray.length;i++){
			if( i != pos && charArray[i] == charArray[i-1]){
				continue;
			}
			list.add(charArray[i]);
			combination(charArray, i+1, list);
			list.remove(list.size() - 1);
			
		}
		
	}

}
