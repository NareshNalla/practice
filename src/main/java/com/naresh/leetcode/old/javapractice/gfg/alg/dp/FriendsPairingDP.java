package com.naresh.leetcode.old.javapractice.gfg.alg.dp;
 import static java.lang.System.out;
 /*
  * Time Complexity : O(n)
 Auxiliary Space : O(n)*/

public class FriendsPairingDP {
	public static void main(String[] args) {
		int n=0;
		out.println("Result:"+friendPair(n));
	}

	private static int friendPair(int n) {
		int dp[] = new int[n+1];
		for(int i=1; i<=n ; i++){
			//if(i==0|| i==1 || i == 2){
			if(i<=2){
				dp[i]=i;
			}else
				dp[i] = dp[i-1]+ (i-1) * dp[i-2];
			
		}
		
		return dp[n];
	}

}
