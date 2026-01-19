package com.naresh.old.javapractice.gfg.alg.sort.ex;

/*Quick Sort Way: We can use quick sort technique to solve this. We represent nuts and bolts in character array for understanding the logic
*/
public class NutsAndBoltsImpl {
	
public static void main(String[] args) {
	char nuts[] = {'@','#','&','$','*','%'};
	char bolts[] = {'%','@','$','*','&','#',};
	
	matchPairs(nuts,bolts,0,nuts.length-1);
	System.out.println("Matched nuts and bolts are : ");
	 for (char ch : nuts){
         System.out.print(ch + " ");
     }
     System.out.print("\n");
     for (char ch : bolts){
         System.out.print(ch + " ");
     }
}

private static void matchPairs(char[] nuts, char[] bolts, int low, int high) {
	
	if(low < high){
		//choose last character of bolts array for nuts partition.
		int pivot = partition(nuts,low,high,bolts[high]);
		//now using the partition of nuts choose tha for bolts partition.
		partition(bolts, low,high,nuts[pivot]);
		// recur for [ low..pivot-1] and [pivot+1...high] for nuts and bolts array.
		matchPairs(nuts, bolts, low,pivot-1);
		matchPairs(nuts,bolts,pivot+1,high);
	}
}

private static int partition(char[] nuts, int low, int high, char pivot) {
	int i = low;
	int j;
	char temp1 , temp2;
	for(j=low;j<high;j++){
		if(nuts[j] < pivot){
			temp1 = nuts[i];
			nuts[i] = nuts[j];
			nuts[j] = temp1;
			i++;
		} else if( nuts[j] == pivot){
			temp1 = nuts[j];
			nuts[j]=nuts[high];
			nuts[high]=temp1;
			j--;
		}
	}
	temp2 = nuts[i];
	nuts[i]=nuts[high];
	nuts[high]=temp2;
	//return the partition index of an array based on the element of other array.
	return i;
}
}

/*
 * Partitioning operations can easily be implemented in O(n)
 *
 *As we apply partitioning on nuts and bolts both so the total time complexity will be tita(2*nlogn) = tita(nlogn) on average
*/