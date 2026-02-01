package com.naresh.dsalgo.gfg.dp;

/*Time Complexity: O(nk^2)
Auxiliary Space: O(nk)
*/
public class EggDroppingPuzzleRecursion {
	public static void main(String[] args) {
		int e=2; int f=10;
		System.out.println("Result:"+eggDrop(e,f));
	}
	private static int max(int a, int b) {
		return (a>b)?a:b;

	}

	private static int eggDrop(int e, int f) {
		if(f == 1 || f==0 )
			return f;
		if(e == 1)
			return f;
		
		int min =  Integer.MAX_VALUE;;
		int res;
		
		for(int x=1; x<= f; x++){
			res= max(eggDrop(e-1, x-1), eggDrop(e, f-x));
			if(res<min)
				min=res;
		}
		return min+1;
		
	}

}
