package com.naresh.dsa.gfg.string;

public class AnagramM2 {

	static boolean areAnagram(String str1, String str2)
	{
		int i;
		int count[] = new int[256];
		int len1 = str1.length();
		int len2 = str2.length();

		if(len1 != len2)
			return false;

		for (i=0; i<len1; i++)
		{
			count[str1.charAt(i)]++;
			count[str2.charAt(i)]--;

		}

		for (i=0; i<256; i++)
		{
			if(count[i] != 0)
				return false;
		}

		return true;

	}

	public static void main (String[] args)
	{
		String str1 = "geeksforgeeks";
		String str2 = "forgeeksgeeks";

		System.out.println( areAnagram(str1, str2) );
	}


}