package com.naresh.old.javapractice.gfg.alg.dp;

/*
 * Time Complexity: O(n^2) where n is the number of pairs.
*/
public class MaximumLengthChainofPairs {
	int a;
	int b;
	MaximumLengthChainofPairs(int a, int b){
		this.a=a;
		this.b=b;
	}
	
	public static void main(String[] args) {
		MaximumLengthChainofPairs arr[] = new MaximumLengthChainofPairs[]{new MaximumLengthChainofPairs(5,24), new MaximumLengthChainofPairs(15,25),new MaximumLengthChainofPairs(27, 40), new MaximumLengthChainofPairs(50,60)};
		System.out.println("Result:"+maxChainLength(arr,arr.length));
		
	}

	private static int maxChainLength(MaximumLengthChainofPairs[] arr, int n) {
		int i , j;
		int max =0;
		int mcl[] = new int[n];
		for(i = 0;i<n;i++)
			mcl[i]=1;
		
		for(i=1; i<n; i++)
			for(j=0; j<i; j++){
				if(arr[i].a >arr[j].b && mcl[i] < mcl[j]+ 1 ){
					mcl[i] = mcl[j] +1;
				}
			}
		for(i =0; i <n; i++){
			if( max <mcl[i]){
				max = mcl[i];
			}
		}
		
		return max;
	}

}
/* o/p :Length of maximum size chain is 3*/