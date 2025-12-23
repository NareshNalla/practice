package com.naresh.old.javapractice.sort;

public class SelectionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub	
	int[] a= {2,4,3,7,5,1};
	int[] result=	sort(a);
	
	for( int e : result){
		System.out.println(e);
	}

	}

	private static int[] sort(int[] a) {
      
		for(int i=0;i<=a.length-1; i++){
			for(int j=1;j<=a.length-1;j++){
				if(a[i]<a[j]){
					int temp = a[j];
					a[j] = a[i];
					a[i]=temp;
				}
			}
		}
		return a;
	}

}
