package com.naresh.dsalgo.gfg.dp;

/* DP
* Time complexity: O ( n^2 )
* Auxiliary Space: O ( n^2 )
* Method 1 ( Brute Force ):
* Time complexity: O ( n^3 )
Auxiliary complexity: O ( 1 )
* 
*/

public class LongestPalindromicSubstring {
	public static void main(String[] args) {
		 
        String str = "forgeeksskeegfor";
        System.out.println("Length is: " + 
                                 longestPalSubstr(str));
    }
	// A utility function to print a substring str[low..high]
    static void printSubStr(String str, int low, int high) {
        System.out.println(str.substring(low, high + 1));
    }
 

	private static int longestPalSubstr(String str) {
		int n = str.length();
		boolean table[][] = new boolean[n][n];
		
		int maxLength = 1;
		for(int i=0; i<n; ++i){
			table[i][i] = true;
		}
		int start = 0;
		for(int i = 0; i< n -1; ++i){
			if(str.charAt(i) == str.charAt(i+1)){
				table[i][i+1] = true;
				start = i;
				maxLength =2;
			}
		}
		
		for(int k = 3; k <= n; ++k){
			for( int i=0; i<n - k +1; ++i){
				int j = i + k -1;
				
				if(table[i+1][j-1] && str.charAt(i)==str.charAt(j)){
					table[i][j] = true;
					if( k > maxLength){
						start = i;
						maxLength =k;
					}
				}
			}
		}
		System.out.println("Result :");
		printSubStr(str, start, start+maxLength -1);
		return maxLength;
	}
	

}
