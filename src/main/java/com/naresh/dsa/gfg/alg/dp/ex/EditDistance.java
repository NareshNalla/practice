package com.naresh.dsa.gfg.alg.dp.ex;

public class EditDistance {
	public static void main(String[] args) {
		String str1="sunday";
		String str2="saturday";
		System.out.println(" Result:"+editDistance(str1,str2,str1.length(),str2.length()));
		
		
	}

	private static int editDistance(String str1, String str2, int m, int n) {
		if(m == 0) return n;
		if(n == 0) return m;
		
		if(str1.charAt(m-1) == str2.charAt(n-1) )
			return editDistance(str1, str2, m-1, n-1);
		
		return 1 + min( editDistance(str1, str2, m, n-1), //Insert
				editDistance(str1, str2, m-1, n),       //remove
				editDistance(str1, str2, m-1, n-1)      //replace
				);
	}

	private static int min(int x, int y, int z) {
		if(x<=y && x<=z) return x;
		if(y<=x && y<=z) return y;
		else 
		return z;
	}

}

