package com.naresh.old.javapractice.sort;

public class CountingSort {
	static int count[] = new int[256];
	public static void main(String[] args) {
	   int[] a={3,2,1,5,4,1,2};
	   sort(a);
		for(int i:a){
			System.out.print(i+" ");
		}
		String s="nareshnalla";
		char[] r =    sortString(s);
				System.out.print(r+" ");
	}

	private static  char[]   sortString(String a) {
		char[] ca= a.toCharArray();

		for(int i=0;i<ca.length;i++){
			count[ca[i]]++;
		}
		int c=0;
		for(int i=0;i<10;i++){
			while(count[i] > 0){
				ca[c++] =ca[i];
				count[i]--;
			}
		}
		for(int i:ca)
		System.out.println(count[i]);
		return ca;
	}
		private static  void  sort(int[] a) {
			

			for(int i=0;i<a.length;i++){
				count[a[i]]++;
			}
			int c=0;
			for(int i=0;i<10;i++){
				while(count[i] > 0){
					a[c++] = i;
					count[i]--;
				}
			}
	}
	

}
