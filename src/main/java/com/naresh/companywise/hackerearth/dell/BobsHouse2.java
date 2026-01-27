package com.naresh.companywise.hackerearth.dell;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BobsHouse2 {
    
    public static class King
    {
        int i;
        int j;
        int f;
    }

    public static void main(String[] args) {
    	
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            int n = in.nextInt();
            String[] board = new String[n];
            for(int board_i = 0; board_i < n; board_i++){
                board[board_i] = in.next();
            }
            // Write Your Code Here
            int[][] f = new int[n][n];
            List<King> kings = new ArrayList<King>();
            for(int j=0;j<n;j++)//column
            {
                for(int i=0;i<n;i++)//row
                {
                    if(board[i].charAt(j)=='X')
                    {
                        f[i][j] = -1;
                    }
                    else if(i==0 && j==0)
                    {
                        f[i][j] = 0;
                    }
                    else
                    {
                        int v = 0;
                        if(i>0)
                        {
                            v |= 1<<(f[i-1][j]+1);
                        }
                        if(j>0)
                        {
                            v |= 1<<(f[i][j-1]+1);
                        }

                        if(i>0 && j>0)
                        {
                            v |= 1<<(f[i-1][j-1]+1);
                        }

                        if((v & 2) == 0)
                        {
                            f[i][j] = 0;
                        }
                        else if((v & 4) == 0)
                        {
                            f[i][j] = 1;
                        }
                        else if((v & 8) == 0)
                        {
                            f[i][j] = 2;
                        }
                        else if((v & 16) == 0)
                        {
                            f[i][j] = 3;
                        }
                    }
                    if(board[i].charAt(j)=='K')
                    {
                        King king = new King();
                        king.i = i;
                        king.j = j;
                        king.f = f[i][j];
                        kings.add(king);
                    }
                }
            }
            
            int res = 0;
            int sum = 0;
            for(int t=0;t<kings.size();t++)
            {
                sum ^= kings.get(t).f;
            }
            
            for(int t=0;t<kings.size();t++)
            {
                King king = kings.get(t);
                
                if(king.i>0 && f[king.i-1][king.j]>=0 && (sum ^ king.f ^ f[king.i-1][king.j])==0)
                {
                    res++;
                }
                
                if(king.j>0 && f[king.i][king.j-1]>=0 && (sum ^ king.f ^ f[king.i][king.j-1])==0)
                {
                    res++;
                }
                
                if(king.i>0 && king.j>0 && f[king.i-1][king.j-1]>=0 && (sum ^ king.f ^ f[king.i-1][king.j-1])==0)
                {
                    res++;
                }
            }
            System.out.println(res>0 ? ("WIN "+res) : "LOSE");
        }
        
        
        
        in.close();
    }
}