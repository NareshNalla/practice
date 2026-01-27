package com.naresh.dsa.hash.ex.gfg;

public class PairSum3Nagative {

//if number is negative and array contains element larger than sum

	
	private static final int MAX = 100000;
	
	public static void main(String[] args){
		final int array[]={2,-5,1,8,3,9,15};
		int sum=10;
		boolean[] binmap=new boolean[MAX];
		boolean[] binmapNegative=new boolean[MAX];
		for(int i=0;i<array.length;i++){
			int temp=sum-array[i];
			if(temp<0){
				if(binmapNegative[Math.abs(temp)]){
					System.out.println(temp +":"+array[i] );
				}
			}else{
				if(binmap[temp]){
					System.out.println(temp +":"+array[i] );
				}
			}
			
			if(array[i]<0){
				binmapNegative[Math.abs(array[i])]=true;
			}else{
				binmap[array[i]]=true;
			}
			
		}
	}
}