package com.naresh.old.javapractice.hash.ex.gfg;

import java.util.HashMap;

/*Input: arr[] = {{11, 20}, {30, 40}, {5, 10}, {40, 30}, {10, 5}}
Output: Following pairs have symmetric pairs
        (30, 40)
        (5, 10)
        */

public class SymmetricPairs {

    // Print all pairs that have a symmetric counterpart
    static void findSymPairs(int arr[][])
    {
        // Creates an empty hashMap hM
        HashMap<Integer, Integer> hM = new HashMap<Integer, Integer>();
  
        // Traverse through the given array
        for (int i = 0; i < arr.length; i++)
        {
            // First and second elements of current pair
            int first = arr[i][0];
            int sec   = arr[i][1];
             
            // Look for second element of this pair in hash
            Integer val = hM.get(sec);
  
            // If found and value in hash matches with first
            // element of this pair, we found symmetry
            if (val != null && val == first)
               System.out.println("(" + sec + ", " + first + ")");
                
            else  // Else put sec element of this pair in hash
               hM.put(first, sec);
        }
    }
  
    // Drive method
    public static void main(String arg[])
    {
        int arr[][] = new int[6][2];
        arr[0][0] = 1; arr[0][1] = 1;
        arr[1][0] = 30; arr[1][1] = 40;
        arr[2][0] = 5;  arr[2][1] = 10;
        arr[3][0] = 40;  arr[3][1] = 30;
        arr[4][0] = 10;  arr[4][1] = 5;
        arr[5][0] = 1; arr[5][1] = 2;
        findSymPairs(arr);
    }


}
