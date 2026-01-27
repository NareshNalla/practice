package com.naresh.companywise.hackerearth.amazon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MoveToNewOffice {
	public static void main(String[] args) throws IOException {
	
		 //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        String line1[]= br.readLine().split(" ");
        int left= Integer.parseInt(line1[0]);
        int right= Integer.parseInt(line1[1]);
        
        int count = Integer.parseInt(br.readLine());
        
        int[] woodsi = new int[count];
        
        String wood[] = br.readLine().split(" ");
        for( int i = 0 ;i < count; i++){
        	int num= Integer.parseInt(wood[i]);
        	woodsi[i]=num;	
        }
        payToWoodCutter(woodsi,count);
               
	}

	private static void payToWoodCutter(int[] woodsi, int count) {
		
		int mid = count/2;
		int[] leftSplit = new int[mid-1];
		
		if(mid < mid+1){
			
			for(int i=0; i<mid-1; i++){
				leftSplit[i] =  woodsi[i];
		}
	for(int a :leftSplit){
		System.out.println("abc :"+a);
			}
	}
	}
}
