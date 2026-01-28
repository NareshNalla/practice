package com.naresh.problems.gfg;

public class Test1Oracle {

    public static void main(String[] args) {

       int[] ip = {-1,3,4,0,0-2,4,0,0,5,-2};
       findSortedOP(ip);
    }

    private static void findSortedOP(int[] ip) {
	//O(n2)
	int n = ip.length;
	
	/*while(n<=0) {
	    //-1 , -2
	    
	    if(ip[first] <= 0) {
		first +=1;
	    }else{
		int tmp = ip[first];
		ip[first] = ip[last];
		ip[last]=tmp;
		last--;
	    }
	 
	    n--;
	}
	*/
	int count=0;
	for(int i=0;i<n;i++) {
	if(ip[i]==0) {
	    ip[count]= ip[i];
	    count++;
	}else {
	    
	}
	}
	
	System.out.println(count);
	for(int x=n-count+1;x<n;x++) {
	    ip[x]=0;
	}
	//-1,3,4,0,0-2,4,5,-2
	for(int x:ip)
	System.out.print(x);
    }
}
