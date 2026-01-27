package com.naresh.dsa.gfg.string;

public class RemoveSpace {
	public static void main(String[] args) {
		String s="N are s h";
		char[] ch=s.toCharArray();
		remove(ch);
	}

	private static void remove(char[] ch) {
		int spaceCount =0;
		for(int i=0;i<ch.length;i++){
			if(Character.isSpaceChar(ch[i])){
			spaceCount++;
			}else{
				ch[i-spaceCount]=ch[i];
			}
		}
		String res= String.valueOf(ch);
		res = res.substring(0, ch.length-spaceCount);
		System.out.println(res);
		
		
	}

}
