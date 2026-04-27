package com.naresh.a_dsalgo.dp.dp2;

import java.util.Arrays;
import java.util.TreeSet;

/**
 * Problem: Longest Increasing Subsequence
 * Description: Find the length of the longest strictly increasing subsequence in an array.
 */
public class LISofAnArray {

    /**
     * Algorithm: Patient sorting using Binary Search to maintain an active sequence of potential LIS tails.
     */
    public int lengthOfLIS_FAANG(int[] nums) {
        // Pattern: Binary Search DP | Time: O(n log n), Space: O(n)
        if (nums == null || nums.length == 0) return 0;
        int[] tails = new int[nums.length];
        int size = 0;
        for (int x : nums) {
            int i = 0, j = size;
            while (i != j) {
                int m = (i + j) / 2;
                if (tails[m] < x) i = m + 1;
                else j = m;
            }
            tails[i] = x;
            if (i == size) size++;
        }
        return size;
    }
    // FAANG Tip: O(n log n) is the optimal solution. Standard O(n^2) DP is usually just the starting point.

    // --- YOUR ORIGINAL PRACTICE CODE BELOW ---
    
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
        if (in.length == 0) return 0;
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

    public static void main(String[] args) {
        int v[] = { 2, 5, 3, 7, 11, 8, 10, 13, 6 };
        System.out.println("FAANG Result: " + new LISofAnArray().lengthOfLIS_FAANG(v));
        System.out.println("Original Result: " + lengthOfLIS1(v));
    }
}
