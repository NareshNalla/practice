package com.naresh.dsa.gfg.string;

import java.io.IOException;
import java.util.Scanner;
/*
*/

public class ReverseLines {
	public static void main (String[] args)throws IOException{
		//code
	//	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	    Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		for(int i=0;i<t;i++)
		{
		    String s=sc.next();
		    //System.out.print(s);
		    String[] st=s.split("\\.");
		    //System.out.print(st[0]);
		    /*for(int j=0;j<st.length;j++)
		    {
		        System.out.print(st[j]+" ");
		    }*/
		    for(int j=0;j<st.length/2;j++)
		    {
		        String temp=st[j];
		        st[j]=st[st.length-j-1];
		        st[st.length-j-1]=temp;
		    }
		    for(int j=0;j<st.length;j++)
		    {
		        if(j!=st.length-1)
		            System.out.print(st[j]+".");
		        else
		            System.out.print(st[j]);
		    }
		    System.out.println();
		}
	}

}
