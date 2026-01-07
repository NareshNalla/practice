package com.naresh.leetcode.old.javapractice.gfg.alg.dp;

public class BinomialCoefficient {
	static int binomialCoeff(int n, int k)
    {
    int C[][] = new int[n+1][k+1];
    int i, j;
     
        // Calculate  value of Binomial Coefficient in bottom up manner
    for (i = 0; i <= n; i++)
    {
        for (j = 0; j <= min(i, k); j++)
        {
            // Base Cases
            if (j == 0 || j == i)
                C[i][j] = 1;
      
            // Calculate value using previosly stored values
            else
                C[i][j] = C[i-1][j-1] + C[i-1][j];
          }
     }
      
    return C[n][k];
    }
 
    // A utility function to return minimum of two integers
    static int min(int a, int b)
    {
    return (a<b)? a: b; 
    }
 
    /* Driver program to test above function*/
    public static void main(String args[])
    {
    int n = 4, k = 2;
    System.out.println("Value of C("+n+","+k+") is "+binomialCoeff(n, k));
    }
}
/*
 * Time Complexity: O(n*k)
 * Auxiliary Space: O(n*k)
 *1) Optimal Substructure
 *  C(n, k) = C(n-1, k-1) + C(n-1, k)
     C(n, 0) = C(n, n) = 1
 *2) Overlapping Subproblems 
 *ABOCE CODE:
 *                          C(5, 2)
                    /                      \
           C(4, 1)                           C(4, 2)
            /   \                          /           \
       C(3, 0)   C(3, 1)             C(3, 1)               C(3, 2)
                /    \               /     \               /     \
         C(2, 0)    C(2, 1)      C(2, 0) C(2, 1)          C(2, 1)  C(2, 2)
                   /        \              /   \            /    \
               C(1, 0)  C(1, 1)      C(1, 0)  C(1, 1)   C(1, 0)  C(1, 1)
 *
 *
 *
 *
 * Space-optimized Binomial Coefficient:
 * use one-dimential array.
 *
 *
 */
