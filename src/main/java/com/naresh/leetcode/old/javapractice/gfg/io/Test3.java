package com.naresh.leetcode.old.javapractice.gfg.io;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Test3 {

	 public static void main(String argv[]) {
	   try {
	     byte[] bary = new byte[]{-1, 0, 12, 23, 56, 98, 23, 127, -128};
	     ByteArrayInputStream bais = new ByteArrayInputStream(bary);
	     System.out.print("{ "); 
	     while (test(bais)){
	       System.out.print(", "); 
	     }
	     System.out.println(" }");
	     // output: { 255, 0, 12, 23, 56, 98, 23, 127, 128, -1 }
	     // Notice 2 negative byte value becomes positive
	     // -1 is added to the end to signal EOF.
	   }
	   catch (IOException e) {
	     System.out.println(e); 
	   }
	 }    
	 public static boolean test(InputStream is) throws IOException {
	   // Read one byte at a time and
	   // put it at the lower order byte of an int
	   // That is why the int value will be always positive
	   // unless EOF, which will be -1
	   int value = is.read();
	   System.out.print(value); 
	        
	   // return true as long as value is not -1
	   return value == (value & 0xff);
	 }
	}