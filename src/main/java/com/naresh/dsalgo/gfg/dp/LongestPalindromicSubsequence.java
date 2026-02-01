package com.naresh.dsalgo.gfg.dp;

/*
 * Time Complexity of the above implementation is O(n^2) which is much better than the worst case time complexity of Naive Recursive implementation.
 * */
public class LongestPalindromicSubsequence {
	 public static void main(String args[])
	    {
	        //String seq = "GEEKSFORGEEKS";
	        String seq = "BBABCBCAB";
	        
	        System.out.println("The lnegth of the lps is "+ lps(seq));
	    }
     static int max ( int x , int y){
    	 return (x > y)?x:y;
     }
	private static int lps(String seq) {
	    int n = seq.length();
	    int i , j, cl;
	    int L[][] = new int[n][n];
	    
	    for( i=0; i<n ; i++){
	    	L[i][i] = 1;
	    }
	    for(cl=2; cl<=n;cl++){
	    	for(i=0; i<n-cl+1; i++){
	    		j = i+cl-1;
	    		if(seq.charAt(i)== seq.charAt(j) && cl ==2)
	    			L[i][j]=2;
	    		else if(seq.charAt(i) == seq.charAt(j))
	    			L[i][j] = 2+ L[i+1][j-1];
	    		else 
	    			L[i][j] = max(L[i][j-1] , L[i+1][j]);
	    	}
	    }
		return L[0][n-1];
	}
}
/*
1) Optimal Substructure:
l recursive solution
// Everay single character is a palindrom of length 1
L(i, i) = 1 for all indexes i in given sequence

// IF first and last characters are not same
If (X[i] != X[j])  L(i, j) =  max{L(i + 1, j),L(i, j - 1)} 

// If there are only 2 characters and both are same
Else if (j == i + 1) L(i, j) = 2  

// If there are more than two characters, and first and last 
// characters are same
Else L(i, j) =  L(i + 1, j - 1) + 2 
........
2) Overlapping Subproblems

3. DP



*/