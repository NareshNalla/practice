package com.naresh.old.javapractice.gfg.alg.dp;

public class MatrixNumberOfPathsRecur {
	public static void main(String args[])
    {
        System.out.println(numberOfPaths(3, 3));
    }

	private static int numberOfPaths(int m, int n) {
		
		if( m ==1 || n==1)
			return 1;
		int result = numberOfPaths(m-1, n) + numberOfPaths(m, n-1);
		return result;
	}

}
