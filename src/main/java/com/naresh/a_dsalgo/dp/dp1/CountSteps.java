package com.naresh.a_dsalgo.dp.dp1;

/**
 * Problem: Climbing Stairs / Count Steps
 * Description: Find the number of ways to reach the n-th step if you can take 1, 2, or 3 steps at a time.
 */
public class CountSteps {

    /**
     * Algorithm: Bottom-up DP to count paths.
     */
    public long countStepsDP(int n) {
        // Pattern: 1D DP | Time: O(n), Space: O(n)
        if (n <= 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (n == 3) return 4;
        long[] dp = new long[n + 1];
        dp[1] = 1; dp[2] = 2; dp[3] = 4;
        for (int i = 4; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }
        return dp[n];
    }
    // FAANG Tip: Space can be optimized to O(1) by using three variables instead of an array.

    // --- YOUR ORIGINAL PRACTICE CODE BELOW ---
    
	//TC:O(n) SC:O(n+n)- O(n) memoization
	public static long countSteps2(int n) {
		long[] mem = new long[n+1];
		auxCountSteps2(n, mem);
		return mem[n];
	}
	private static long auxCountSteps2(int n, long[] mem) {
		if(n == 1) return 1;
		if(n == 2) return 2;
		if(n == 3) return 4;
		if(mem[n] != 0) return mem[n];
		long prev1 = auxCountSteps2(n-1, mem);
		long prev2 = auxCountSteps2(n-2, mem);
		long prev3 = auxCountSteps2(n-3, mem);
		return mem[n]= prev1 + prev2 + prev3;
	}
	
	//TC:O(n) SC:O(n) dp
	public static long countSteps3(int n) {
		if (n < 1) return 0;
		if (n == 1) return 1;
		long[] mem = new long[n+1];
		mem[1] = 1;
		mem[2] = 2;
		for(int i = 3; i <= n; ++i)
			mem[i] = mem[i-1] + mem[i-2];
		return mem[n];
	}
	public static void main(String[] args) {
		int n = 3;
		System.out.println("DP Result: " + new CountSteps().countStepsDP(n));
		System.out.println("Original Result: " + countSteps3(n));
	}
}
