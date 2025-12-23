package com.naresh.old.javapractice.gfg.string;

import java.util.HashMap;
import java.util.Map;

public class StringRotation {
	public static void main(String[] args) {
		String str1 = "AACD";
        String str2 = "ACDA";
        boolean flag= isRrotaions(str1, str2);
       // boolean flag = stringRotation(str1,str2);
        if(flag)
        	System.out.println("True");
        else
        	System.out.println("False");
	}

	private static boolean isRrotaions(String str1, String str2) {
		
		if((str1.length() == str2.length()) && (str1+str2).indexOf(str2) != -1){
			
			return true;
		}
		else
			return false;
	}

	/*other*/
	public static boolean stringRotation(String a, String b) {

		boolean result = true;

		if (a.length() != b.length())
			return false;

		Map<Character , Integer> alphabets = new HashMap<>();
		for (int i = 0; i < a.length(); i++) {
			if (!alphabets.containsKey(a.charAt(i))) {
				alphabets.put(a.charAt(i), i);
			}
		}

		int dd = 0;
		int d = 0;

		for (int i = 0; i < b.length(); i++) {
			if (alphabets.containsKey(b.charAt(i))) {
				int index = alphabets.get(b.charAt(i));
				d = Math.abs(index - i);
				if (dd == 0)
					dd = d;
				if (dd != d) {
					if ((dd + d) != a.length())
						return false;
				}
			} else {
				break;
			}
		}
		return result;
	}
}
