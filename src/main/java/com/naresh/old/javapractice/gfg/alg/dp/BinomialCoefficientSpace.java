package com.naresh.old.javapractice.gfg.alg.dp;

public class BinomialCoefficientSpace {
	static int binomialCoeff(int n, int k)
    {
    int C[] = new int[k+1];
    
    int i, j;
    C[0] = 1;
     
        // Calculate  value of Binomial Coefficient in bottom up manner
    for (i = 0; i <= n; i++) {
    	 for (j = min(i, k); j >0; j--){
            /*
        	Base Cases: Compute next row of pascal triangle using  the previous row
          */
               C[j] = C[j] + C[j-1];
          }
     }
      
    return C[k];
    }
 
    // A utility function to return minimum of two integers
    static int min(int a, int b)
    {
    return (a<b)? a: b; 
    }
 
    /* Driver program to test above function*/
    public static void main(String args[])
    {
    int n = 5, k = 2;
    System.out.println("Value of C("+n+","+k+") is "+binomialCoeff(n, k));
    }
}

/*
Time Complexity: O(n*k)
Auxiliary Space: O(k)
*/