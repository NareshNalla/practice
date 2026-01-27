package com.naresh.dsa.gfg.recur.bt;

import java.util.Map;
import java.util.TreeMap;

public class CombinationsStr {
	public static void main(String[] args) {
		CombinationsStr cb = new CombinationsStr();
		cb.combination("AABC".toCharArray());
	}

	private void combination(char[] charArray) {
		Map<Character , Integer> countMap =  new TreeMap<>();
		for( char ch: charArray){
			countMap.compute(ch , (kay,val) -> {
				if(val == null){
					return 1;
				}else {
					return val +1;
				}
			});
		}
		char str[] = new char[countMap.size()];
		int count[] = new int[countMap.size()];
		int index =0;
		for(Map.Entry<Character, Integer> entry : countMap.entrySet()){
			str[index] = entry.getKey();
			count[index] = entry.getValue();
			index++;
		}
		char[] output = new char[charArray.length];
		combination(str, count , 0, output , 0);
		
	}

	private void combination(char[] input, int[] count, int pos, char[] output, int len) {
		println(output , len);
		for(int i = pos; i< input.length; i++){
			if(count[i] == 0){
				continue;
			}
			output[len] = input[i];
			count[i]--;
			combination(input, count, i , output,len +1);
			count[i]++;
		}
		
	}

	private void println(char[] result, int pos) {
		for(int i=0; i < pos; i++){
            System.out.print(result[i] + " ");
        }
        System.out.println();

		
	}

}
