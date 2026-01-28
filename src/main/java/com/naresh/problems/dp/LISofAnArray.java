package com.naresh.problems.dp;

import java.util.Arrays;
import java.util.TreeSet;

public class LISofAnArray {
    
    
    public static int lengthOfLIS(int[] nums) {            
        int[] dp = new int[nums.length];
        int len = 0;

        for(int x : nums) {
            int i = Arrays.binarySearch(dp, 0, len, x);
            if(i < 0) i = -(i + 1);
            dp[i] = x;
            if(i == len) len++;
        }

        return len;
    }
    public static int lengthOfLIS1(int[] in) {
        if (in.length == 0) {
            return 0;
        }
		int[] mem = new int[in.length+1];
		mem[1] = 1; int max = 1;
		for(int i = 2; i <= in.length; ++i) {
			int tmp = 1;
			for(int j = 1; j < i; ++j) {
				if(in[i-1] > in[j-1])
					tmp = Math.max(tmp, mem[j]+1);
			}
			mem[i] = tmp;
			max = Math.max(max, tmp);
		}
		return max;
        
    }
    public static int lis(int[] in) {
	TreeSet<Integer> tset = new TreeSet<Integer>();
	for(int x:in) {
		Integer ceil = tset.ceiling(x);
		if(ceil != null) 
			tset.remove(ceil);
		tset.add(x);
	}
	return tset.size();
}
    public static void main(String[] args)
    {
	int[] in = {1,3,2,5};
        int v[] = { 2, 5, 3, 7, 11, 8, 10, 13, 6 };
        System.out.println(
            "Length of Longest Increasing Subsequence is "
            + lengthOfLIS1(v));
        System.out.println(
                "Length of Longest Increasing Subsequence is "
                + lis(v));
        
    }
}
