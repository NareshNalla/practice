package com.naresh.problems.strings;

public class StringCompressionInPlace {
public static void main(String[] args) {
	String str = "AABBCCCCDAA";
	char[] a= compressString(str);
	System.out.println(a);
}

public static char[] compressString(String str) {
	char[] arr= str.toCharArray();
	
	for( int i=0; i<arr.length-1; i++){
		char c=arr[i];
		
		int j=i+1;
		
		while(j<arr.length && arr[j]==c){
			arr[j] = ' ';
			j++;
		}
		
		if(j != i+1){
			arr[i+1] = String.valueOf(j-1).toCharArray()[0];
			i=j-1;
		 }
	  }
	//second scan
	for(int i=0; i<arr.length-1;i++){
		if(arr[i] >= 'a' && arr[i] <='z'){
			if(arr[i+1] >= 'a' && arr[i+1] <='z'){
				int j=1;
				char temp = arr[j+1];
				char workingOn=arr[j];
				
				while(temp != ' '){
					arr[++j] = workingOn;
					workingOn = temp;
					temp =arr[j+1];
				}
				arr[j+1] = workingOn;
				
				arr[i+1] = String.valueOf(1).toCharArray()[0];
			}
			}else if(arr[i] == ' '){
				int j= i+1;
				while(j < arr.length && arr[j] == ' '){
					j++;
				} if(j < arr.length){
					arr[j]= ' ';
					
					if(j+1 < arr.length){
						if(arr[j+1] >='a' && arr[j+1] <= 'z' ){
							arr[i+1] = String.valueOf(1).toCharArray()[0];
						}else{
							arr[i+1] =arr[j+1];
						}
						arr[j]=' ';
						arr[j+1]=' ';
					 }else{
						 arr[i+1] = String.valueOf(1).toCharArray()[0];
					  }
			  }
			}
			
			}

	
	return arr;
}
}